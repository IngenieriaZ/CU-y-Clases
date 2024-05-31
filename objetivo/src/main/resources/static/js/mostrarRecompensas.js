document.addEventListener('DOMContentLoaded', function() {
    const recompensasList = document.getElementById('recompensas-list');
    const mensaje = document.getElementById('mensaje');

    fetch('/recompensas')
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                return response.text().then(text => { throw new Error(text) });
            }
        })
        .then(data => {
            if (data.length === 0) {
                mensaje.innerText = 'No hay recompensas disponibles';
            } else {
                data.forEach(recompensa => {
                    const li = document.createElement('li');
                    li.textContent = `${recompensa.nombre} - ${recompensa.descripcion}`;
                    recompensasList.appendChild(li);
                });
            }
        })
        .catch(error => {
            mensaje.innerText = 'Error al recuperar las recompensas: ' + error.message;
        });
});
