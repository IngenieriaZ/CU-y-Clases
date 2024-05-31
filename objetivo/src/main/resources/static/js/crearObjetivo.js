document.getElementById('crearObjetivoForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const nombre = document.getElementById('nombre').value;
    const descripcion = document.getElementById('descripcion').value;
    const vencimiento = document.getElementById('vencimiento').value;

    fetch('/objetivos', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nombre, descripcion, vencimiento: parseInt(vencimiento, 10) })
    })
    .then(response => {
        if (response.ok) {
            document.getElementById('mensaje').innerText = 'Objetivo creado con éxito';
        } else {
            return response.text().then(text => { throw new Error(text) });
        }
    })
    .catch(error => {
        document.getElementById('mensaje').innerText = 'Error al crear el objetivo: ' + error.message;
    });
});