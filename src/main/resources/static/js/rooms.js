var character="";
getRooms();

function createRoom() {
    var room = prompt("Which is the id of the room?");
    axios.post("/pacwar/game/newroom?id="+room)
        .then(function (value) {
            getRooms();
        })
}

function getRooms() {
    axios.get("/pacwar/game/rooms")
        .then(function (response) {
            var agregar = "";
            for(var i = 0; i<response.data.length;i++){
                agregar += "<button onclick='toRoom("+response.data[i].idRoom+")' class=\"btn btn-outline-secondary my-2 my-sm-0\" style=\"background-color: #5a6268; color: #ffffff\"> "+response.data[i].idRoom+"</button>"
            }
            document.getElementById("rooms").innerHTML = agregar;
        });
}

function toRoom(id) {
    sessionStorage.setItem("room",id);
    window.location.href = 'gameRoom.html';
}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}