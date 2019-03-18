var APIControllerModule = (function() {
    var logIn= function(name, password) {
        alert("Entro a LOGIN");
        var username={
            "name":name,
            "password":password
        }
        var callback={
            onSuccess: function(){
                
            },onFailed: function(exception){
                console.log(exception);
                alert("El usuario no existe"); 
            }
        };
        ApiRestControllerModule.iniciarSesion(username,callback);
    };

    var register=function (name, lastName, email, nikName, password) {
        alert("Entro a registrar");
        var username={
            "name":name,
            "lastName":lastName,
            "email":email,
            "nikName":nikName,
            "password":password
        }
        var callback={
            onSuccess: function(){
                alert("User created");
            },
            onFailed: function(exception){
                console.log(exception);
                alert("User has not been created"); 
            }
        };
        ApiRestControllerModule.agregarUsuario(username,callback);
    };
    
    return {
        logIn:logIn,
        register:register
    };
    
})();