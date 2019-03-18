var host = "http://localhost:8080/register/"



async function getUser(){  
    var agregar = "";
    await Promise.resolve(axios.get(host)
	.then(async function(response){
                
            }));           
}

async function addUser(){
    var room = prompt("coloque el valor requerido")
    await Promise.resolve(axios.post(host+"?room="+room));
    await getUser();
}