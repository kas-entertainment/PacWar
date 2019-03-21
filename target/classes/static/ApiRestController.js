 var ApiRestControllerModule= (function() {
    
    iniciarSesion=function(){
        axios.post('/login',{ name: document.getElementById('nikName').value, password: document.getElementById('password').value }).then(function (response) {
            console.log("error");
            })
    };
    
    agregarUsuario = function(){
        axios.post('/registrar',{name:document.getElementById('name').value, lastName:document.getElementById('lastName').value,
            email:document.getElementById('email').value, nikName:document.getElementById('nikName').value,
            password:document.getElementById('password').value}).then(function (response) {
            console.log("error");
            })
    };
    
    
return {
    agregarUsuario:agregarUsuario,
    iniciarSesion:iniciarSesion
};
})();

