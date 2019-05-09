
var stompClient = null;

function getBackGroundItems() {
    return axios.get("/pacwar/game/"+sessionStorage.getItem("room")+"/backgrounditems")
}

function createPacMan() {
    alert("5. Pcmn /GameROomBAckEnd");
    return axios.post("/pacwar/game/"+sessionStorage.getItem("room")+"/pacman/",{
        "id":sessionStorage.getItem("id"),
        "dirrection":"U"
    })
}

function createGhost() {
    alert("5G. createGhost--->FANTASMA/GameROomBAckEnd");
    return axios.post("/pacwar/game/"+sessionStorage.getItem("room")+"/ghost/",{
        "id":sessionStorage.getItem("id"),
        "dirrection":"U"
    })
}

function getPacMans(){
    alert("getPacMans Pac-man/GameROomBAckEnd");
    return axios.get("/pacwar/game/"+sessionStorage.getItem("room")+"/pacmans")
}

function getGhosts(){
    alert("getGhosts--->FANTASMA/GameROomBAckEnd");
    return axios.get("/pacwar/game/"+sessionStorage.getItem("room")+"/ghosts")
}

function move(key) {
    stompClient.send("/app/move."+sessionStorage.getItem("room"),{},JSON.stringify({"id":sessionStorage.getItem("id"),"key":key}))
}

function connectAndSuscribe() {
    alert("1. connectAndSuscribe /GameROomBAckEnd");
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame){
        stompClient.subscribe("/topic/move."+sessionStorage.getItem("room"),function(message){
            alert("9. pacMan moverPacMan StompCLient connectAndSuscribe /GameROomBAckEnd");
            moverPacMan(JSON.parse(message.body));
        });
        stompClient.subscribe("/topic/move."+sessionStorage.getItem("room"),function(message){
            alert("9G. GHOST moverGhost StompCLient connectAndSuscribe /GameROomBAckEnd");
            moverGhost(JSON.parse(message.body));
        });
        
        stompClient.subscribe("/topic/newpacman."+sessionStorage.getItem("room"), function (message) {
            alert(" pacMan putPacMan StompCLient connectAndSuscribe /GameROomBAckEnd");
            putPacMan(JSON.parse(message.body));
        });
        stompClient.subscribe("/topic/newghost."+sessionStorage.getItem("room"), function (message) {
            alert(" GHOST putGhost StompCLient connectAndSuscribe /GameROomBAckEnd");
            putGhost()(JSON.parse(message.body));
        });
        
        stompClient.subscribe("/topic/deletedot."+sessionStorage.getItem("room"),function (message) {
            deleteDot(JSON.parse(message.body))
        })
        //stompClient.send("/app/newpacman."+sessionStorage.getItem("room"),{},JSON.stringify({"id":sessionStorage.getItem("id"), "dirrection":"U"}));
    });

}

