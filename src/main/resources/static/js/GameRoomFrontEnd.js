var players = [];
var charName=null;
var character="";

/**
function getCharacter(charNm){
character=character;
}*/
start();


function inicial() {
    //var character="pacman";
    var paramstr = window.location.search.substr(1);
    var paramarr = paramstr.split ("&");
    var params = {};
    for ( var i = 0; i < paramarr.length; i++) {
        var tmparr = paramarr[i].split("=");
        params[tmparr[0]] = tmparr[1];
    }
    character=params[tmparr[0]];
    //alert("su personaje es  "+params[tmparr[0]]);
    //alert("su personaje esssssss  "+character);
    
    if (character === "pacman") {
        createPacMan()
            .then(function (value) {
                getPacMans()
                        .then(function (response) {
                            putPacMans(response.data);
                            }
                        )
                }
            );
    }
    else if(character === "blue" || character === "red"||character === "pink" || character === "orange"){
        createPacMan()
            .then(function (value) {
                getPacMans()
                    .then(function (response) {
                            putGhosts(response.data);
                            }
                        )
                }
            );
    }
}

function start(){
    connectAndSuscribe();
    getBackGroundItems()
        .then(function (response) {
            putBackGroundItems(response.data)
        });
    inicial(charName);
}

function putBackGroundItems(list) {
    agregar = "";
    for(var i = 0; i<list.length;i++){
        if(list[i].visible) {
            if (list[i].type === "Block") {
                agregar += "<img style='position:absolute; width:" + list[i].size + "px; height:" + list[i].size + "px; top:" + list[i].posY + "px; left:" + list[i].posX + "px' src='img/block.png'></img>'";
            }else if(list[i].type === "Dot"){
                newY = list[i].posY + 7;
                newX = list[i].posX + 7;
                agregar += "<img id='" + list[i].id + "' style='position:absolute; top:" + newY + "px; left:" + newX + "px' src='img/pickups/dot.png'></img>'";
            }else if(list[i].type === "Heart"){
                newY = list[i].posY + 7;
                newX = list[i].posX + 7;
                agregar += "<img id='" + list[i].id + "' style='position:absolute; top:" + newY + "px; left:" + newX + "px' src='img/pickups/bigdot.png'></img>'";
            }else if(list[i].type === "Star"){
                newY = list[i].posY + 7;
                newX = list[i].posX + 7;
                agregar += "<img id='" + list[i].id + "' style='position:absolute; top:" + newY + "px; left:" + newX + "px' src='img/pickups/bigdot_old.png'></img>'";
            }
        }
    }
    document.getElementById("game").innerHTML += agregar;
}

function deleteDot(dot) {
    var dot1 = document.getElementById(dot.id);
    dot1.parentNode.removeChild(dot1);
}

function deleteHeart(heart) {
    var heart1 = document.getElementById(heart.id);
    heart1.parentNode.removeChild(heart1);
}

function deleteStar(star) {
    var star1 = document.getElementById(star.id);
    star1.parentNode.removeChild(star1);
}

function deletePacMan(pacman) {
    var pacman1 = document.getElementById(pacman.id);
    pacman1.parentNode.removeChild(pacman1);
}

function putPacMans(list){
    for(var i = 0; i<list.length;i++){
        putPacMan(list[i])
    }
}

function putGhosts(list){
    for(var i = 0; i<list.length;i++){
        putGhost(list[i])
    }
}

async function gameOver(){


}

function scores(){
    agregar = "";
    for(var i = 0;i<players.length;i++){
        agregar+="<label id = 'points"+ players[i].id +"' style='position:absolute; top:"+300+"px; left:"+1750+"px; color:white'> "+players[i].id+" Points: "+players[i].points+"</label>"
    }
    document.getElementById("game").innerHTML+=agregar;
}

function putPacMan(pacman) {
    players.push(pacman);
    agregar = "<img id='pacman"+pacman.id+"' style='position:absolute; width:"+pacman.size+"px; height:"+pacman.size+"px; top:"+pacman.posY+"px; left:"+pacman.posX+"px'";
    if(pacman.dirrection=="U"){
        agregar += " src='img/actors/'"+ character +"'/up-2.png'></img>"
    }else if(pacman.dirrection=="D"){
        agregar += " src='img/actors/'"+ character +"'/down-2.png'></img>"
    }else if(pacman.dirrection=="L"){
        agregar += " src='img/actors/'"+ character +"'/left-2.png'></img>"
    }else{
        agregar += " src='img/actors/'"+ character +"'/right-2.png'></img>"
    }
    document.getElementById("game").innerHTML += agregar;
}

function putGhost(pacman) {
    players.push(pacman);
    agregar = "<img id='pacman" + pacman.id + "' style='position:absolute; width:" + pacman.size + "px; height:" + pacman.size + "px; top:" + pacman.posY + "px; left:" + pacman.posX + "px'";

    if (pacman.dirrection == "U") {
        agregar += " src='img/actors/ghost/'"+ character +"'/up-1.png'></img>"
    } else if (pacman.dirrection == "D") {
        agregar += " src='img/actors/ghost/'"+ character +"'/down-1.png'></img>"
    } else if (pacman.dirrection == "L") {
        agregar += " src='img/actors/ghost/'"+ character +"'/left-1.png'></img>"
    } else {
        agregar += " src='img/actors/ghost/'"+ character +"'/right-1.png'></img>"
    }
    document.getElementById("game").innerHTML += agregar;
}


window.onkeydown = function (e) {
    var key = e.keyCode ? e.keyCode : e.which;
    move(key);
};

function moverPacMan(body) {
    pacman = document.getElementById("pacman"+body.id);
    pacman.style.top = body.posY + "px";
    pacman.style.left = body.posX + "px";
    if(body.dirrection==="U"){
        pacman.src='img/actors/'+character+'/up-2.png';
    }else if(body.dirrection==="D"){
        pacman.src='img/actors/'+character+'/down-2.png';
    }else if(body.dirrection==="L"){
        pacman.src='img/actors/'+character+'/left-2.png';
    }else{
        pacman.src='img/actors/'+character+'/right-2.png';
    }
    updatePlayers(body);
    scores();
}

function moverGhost(body) {
    ghost = document.getElementById("pacman"+ body.id);
    ghost.style.top = body.posY + "px";
    ghost.style.left = body.posX + "px";
    if(body.dirrection==="U"){
        ghost.src='img/actors/ghost/'+character+'/up-1.png';
    }else if(body.dirrection==="D"){
        ghost.src='img/actors/ghost/'+character+'/down-1.png';
    }else if(body.dirrection==="L"){
        ghost.src='img/actors/ghost/'+character+'/left-1.png';
    }else{
        ghost.src='img/actors/ghost/'+character+'/right-1.png';
    }
    updatePlayers(body);
    scores();
}

function updatePlayers(body){
    for(var i = 0; i<players.length;i++){
        if(players[i].id=body.id) players[i] = body;
    }
}