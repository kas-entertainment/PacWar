var ApiRestControllerModule = (function () {


    iniciarSesion = function () {
        axios.get('http://localhost:8080/pacwar/login', 
        { params: {name: document.getElementById('nikName').value,
        password: document.getElementById('password').value
        }})
        .then(function(res) {
            console.log(res);
        })
        .catch(function(err) {
            console.log(err);
        }).then(function(){
            
        })
    };

    
    
    agregarUsuario = function () {axios.post('http://localhost:8080/pacwar/register', {
            name: document.getElementById('name').value,
            lastName: document.getElementById('lastName').value,
            email: document.getElementById('email').value,
            nikName: document.getElementById('nikName').value,
            password: document.getElementById('password').value
        })
        .then(function (res) {
            if (res.status == 201) {
                mensaje.innerHTML = 'El nuevo Post ha sido almacenado con id: ' + res.data.id;
            }
        })
        .catch(function (err) {
            console.log(err);
        })
        .then(function () {
        loading.style.display = 'none';
        });
    };


    return {
        agregarUsuario: agregarUsuario,
        iniciarSesion: iniciarSesion
    };
})();

