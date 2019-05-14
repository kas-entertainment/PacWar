var character="";
getRooms();

function createRoom() {
    var room = prompt("Which is the id of the room?");
    axios.post("/pacwar/game/newroom?id="+room)
        .then(function (value) {
            getRooms();
        })
}


function getCharRooms(){
    var i;
    for (i=0;i<document.characters.chars.length;i++){ 
        if (document.characters.chars[i].checked){
            break;
        }
    }
    character=document.characters.chars[i].value;
    getCharacter(character);
    getRooms();
    return character;
}

function getRooms() {
    axios.get("/pacwar/game/rooms")
        .then(async function (response) {
            var agregar = "";
            for(var i = 0; i<response.data.length;i++){
                agregar += "<button onclick='toRoom("+response.data[i].idRoom+")' class=\"btn btn-outline-secondary my-2 my-sm-0\" style=\"background-color: #5a6268; color: #ffffff\"> "+response.data[i].idRoom+"</button>"
            }
            document.getElementById("rooms").innerHTML = agregar;
        });
}

function toRoom(id) {
    sessionStorage.setItem("room",id);
    window.location.href = 'gameRoom.html?num='+character;
}