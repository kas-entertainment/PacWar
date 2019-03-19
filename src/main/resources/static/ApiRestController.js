
 var ApiRestControllerModule= (function() {
    
    var agregarUsuario = function(){
        
        axios.post("/packwar/registrar",document.getElementById('nikName').value,document.getElementById('password').value).then(function(response) {
            alert("ENtro al post");
            console.log("Usuario agregado");
    
        }).catch(function(error){
            console.log(error);
        });
    };
    
    axios.post('/save', { firstName: 'Oxxido', lastName: 'Test' })
  .then(function(response){
    console.log('Guardado exitoso')
  });
    
    
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

