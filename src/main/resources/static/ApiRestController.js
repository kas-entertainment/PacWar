var ApiRestControllerModule= (function() {
    var agregarUsuario = function(user, callback){
        axios.post("/packwar/registrar",user).then(function(user) {
            callback.onSUccess(user.data);
            console.log("Usuario agregado");
    
        }).catch(function(error){
            callback.onFailed(error);
                    console.log(error);
                    alert("error");
        });
    };
    
    var iniciarSesion=function(user, callback){
        axios.post('/login',user).then(function (value) {
                callback.onSuccess(value);
            })
            .catch(function (error) {
                callback.onFailed(error);
                console.log(error);
            })
    }

return {
    agregarUsuario:agregarUsuario,
    iniciarSesion:iniciarSesion
};
})();
