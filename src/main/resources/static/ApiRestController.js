var ApiRestController = (function () {


    iniciarSesion = function () {
        axios.get('http://localhost:8080/pacwar/logIn', 
        { params: {name: document.getElementById('nickName').value,
        password: document.getElementById('password').value
        }})
        .then(function(res) {
            console.log(res);
        })
        .catch(function(err) {
            console.log(err);
        })
    };

    
    
    agregarUsuario = function () {axios.post('http://localhost:8080/pacwar/register', {
            name: document.getElementById('name').value,
            lastName: document.getElementById('lastName').value,
            email: document.getElementById('email').value,
            nikName: document.getElementById('nickName').value,
            password: document.getElementById('password').value
        })
        .then(function (res) {
            if (res.status == 201) {
                mensaje.innerHTML = 'El nuevo Post ha sido almacenado con id: ' + res.data.id;
            }
        })
        /*.catch(function (err) {
            console.log(err);
        });*/
    };


    return {
        agregarUsuario: agregarUsuario,
        iniciarSesion: iniciarSesion
    };
})();

