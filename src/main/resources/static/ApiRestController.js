var ApiRestController = (function () {


    iniciarSesion = function () {
        axios.get("/pacwar/"+document.log.nikName.value+"/"+document.log.password.value)
        .then(function(res) {
            if(res.data===""){
                alert("Las credenciales están mal")
            }else{
                sessionStorage.setItem("id",res.data.id);
                sessionStorage.setItem("firstName",res.data.firstName);
                sessionStorage.setItem("lastName",res.data.lastName);
                sessionStorage.setItem("email",res.data.email);
                location.href ="/perfil.html";
            }
        })
        .catch(function(err) {
            console.log(err);
        })
    };

    
    
    agregarUsuario = function () {axios.post('/pacwar/register', {
            firstName: document.getElementById('name').value,
            lastName: document.getElementById('lastName').value,
            id: document.getElementById('nickName').value,
            password: document.getElementById('password').value,
            email: document.getElementById('email').value
        })
        .then(function (res) {
            console.log(res);
            if (res.status == 202) {
                alert("El usuario se creo correctamente")
            }else{

            }
        }).catch(function (err) {
            alert("El usuario ya existe, elija otro nickname porfavor")
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

