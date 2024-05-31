document.getElementById('registroForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const nombre = document.getElementById('nombre').value;
    const email = document.getElementById('email').value;
    const contrasena = document.getElementById('contrasena').value;

    fetch('/usuarios', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nombre, email, contrasena })
    })
    .then(response => {
        if (response.ok) {
            document.getElementById('mensaje').innerText = 'Usuario registrado con éxito';
        } else {
            return response.text().then(text => { throw new Error(text) });
        }
    })
    .catch(error => {
        document.getElementById('mensaje').innerText = 'Error al registrar el usuario: ' + error.message;
    });
});
