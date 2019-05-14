
var stompClient = null;

function getBackGroundItems() {
    return axios.get("/pacwar/game/"+sessionStorage.getItem("room")+"/backgrounditems")
}

function createPacMan() {
    return axios.post("/pacwar/game/"+sessionStorage.getItem("room")+"/pacman/",{
        "id":sessionStorage.getItem("id"),
        "dirrection":"U"
    })
}

function getPacMans(){
    return axios.get("/pacwar/game/"+sessionStorage.getItem("room")+"/pacmans")
}

function move(key) {
    stompClient.send("/app/move."+sessionStorage.getItem("room"),{},JSON.stringify({"id":sessionStorage.getItem("id"),"key":key}))
}

function connectAndSuscribe() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame){
        stompClient.subscribe("/topic/move."+sessionStorage.getItem("room"),function(message){
            var paramstr = window.location.search.substr(1);
            var paramarr = paramstr.split ("&");
            var params = {};
            for ( var i = 0; i < paramarr.length; i++) {
                var tmparr = paramarr[i].split("=");
                params[tmparr[0]] = tmparr[1];
            }
            if(params[tmparr[0]]=="pacman"){
                moverPacMan(JSON.parse(message.body));
            }else{
                moverGhost(JSON.parse(message.body));   
            }
        });
        
        stompClient.subscribe("/topic/newpacman."+sessionStorage.getItem("room"), function (message) {
            var paramstr = window.location.search.substr(1);
            var paramarr = paramstr.split ("&");
            var params = {};
            for ( var i = 0; i < paramarr.length; i++) {
                var tmparr = paramarr[i].split("=");
                params[tmparr[0]] = tmparr[1];
            }
            if(params[tmparr[0]]=="pacman"){
                putPacMan(JSON.parse(message.body));
            }else{
                putGhost(JSON.parse(message.body));
            }
        });
        stompClient.subscribe("/topic/deletedot."+sessionStorage.getItem("room"),function (message) {
            deleteDot(JSON.parse(message.body));
        });
        stompClient.subscribe("/topic/deleteheart."+sessionStorage.getItem("room"),function (message) {
            deleteHeart(JSON.parse(message.body));
        });
        stompClient.subscribe("/topic/deletestar."+sessionStorage.getItem("room"),function (message) {
            deleteStar(JSON.parse(message.body));
        });
        stompClient.subscribe("/topic/deletepacman."+sessionStorage.getItem("room"),function (message) {
            deletePacMan(JSON.parse(message.body));
        });
        //stompClient.send("/app/newpacman."+sessionStorage.getItem("room"),{},JSON.stringify({"id":sessionStorage.getItem("id"), "dirrection":"U"}));
    });

}

