
var stompClient = null;

function getBackGroundItems() {
    return axios.get("/pacwar/game/"+sessionStorage.getItem("room")+"/backgrounditems")
}

function createPacMan() {
    return axios.post("/pacwar/game/"+sessionStorage.getItem("room")+"/pacman",{
        "id":sessionStorage.getItem("id"),
        "dirrection":"U"
    })
}

function createGhost() {
    return axios.post("/pacwar/game/"+sessionStorage.getItem("room")+"/ghosts",{
        "id":sessionStorage.getItem("id"),
        "dirrection":"U"
    })
}

function getPacMans(){
    return axios.get("/pacwar/game/"+sessionStorage.getItem("room")+"/pacmans")
}

function getGhosts(){
    return axios.get("/pacwar/game/"+sessionStorage.getItem("room")+"/ghosts")
}

function move(key) {
    stompClient.send("/app/move."+sessionStorage.getItem("room"),{},JSON.stringify({"id":sessionStorage.getItem("id"),"key":key}))
}

function connectAndSuscribe() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame){
        stompClient.subscribe("/topic/move."+sessionStorage.getItem("room"),function(message){
            moverPacMan(JSON.parse(message.body));
        });
        stompClient.subscribe("/topic/newpacman."+sessionStorage.getItem("room"), function (message) {
            putPacMan(JSON.parse(message.body));
        });
        stompClient.subscribe("/topic/move."+sessionStorage.getItem("room"),function(message){
            moverGhost(JSON.parse(message.body));
        });
        stompClient.subscribe("/topic/newpacman."+sessionStorage.getItem("room"), function (message) {
            putGhost(JSON.parse(message.body),name);
        });
        stompClient.subscribe("/topic/deletedot."+sessionStorage.getItem("room"),function (message) {
            deleteDot(JSON.parse(message.body))
        })
        //stompClient.send("/app/newpacman."+sessionStorage.getItem("room"),{},JSON.stringify({"id":sessionStorage.getItem("id"), "dirrection":"U"}));
    });

}

