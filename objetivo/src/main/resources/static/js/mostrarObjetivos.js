document.addEventListener('DOMContentLoaded', function() {
    const objetivosPorCumplirList = document.getElementById('objetivos-por-cumplir');
    const objetivosCumplidosList = document.getElementById('objetivos-cumplidos');
    const mensaje = document.getElementById('mensaje');

    fetch('/objetivos')
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                return response.text().then(text => { throw new Error(text) });
            }
        })
        .then(data => {
            if (data.length === 0) {
                mensaje.innerText = 'No hay objetivos disponibles';
            } else {
                data.forEach(objetivo => {
                    const li = document.createElement('li');
                    li.textContent = `${objetivo.nombre} - ${objetivo.descripcion} (Vencimiento: ${objetivo.vencimiento} días)`;
                    if (objetivo.completado) {
                        objetivosCumplidosList.appendChild(li);
                    } else {
                        objetivosPorCumplirList.appendChild(li);
                    }
                });
            }
        })
        .catch(error => {
            mensaje.innerText = 'Error al recuperar los objetivos: ' + error.message;
        });
});
