function getCharacter(character){
alert("the sahjdkasjh is "+character);
char=character;
}
start();

var players = [];



function inicial() {
    alert("2. HOLA");
    //var char="pacman";
    var char="blue";
    alert("3. "+char);
   
    if(char==="pacman"){
        alert("4. Entro pcm /GameRoomFrontEnd");
        createPacMan()
            .then(function (value) {
                alert("6. Entro a get /GameRoomFrontEnd");
                getPacMans()
                .then(function (response) {
                    alert("7. Entro a put /GameRoomFrontEnd");
                    putPacMans(response.data);
                }
                )
            }
            );
    }
    if(char==="blue"){
        alert("4F. Entro a blue --->FANTASMA /GameRoomFrontEnd");
        createGhost()
        .then(function (value) {
            alert("6F. "+sol);
            getGhosts()
                .then(function (response) {
                    alert("7F. "+sol);
                    putGhostList(response.data);
                }
                )
            }
            );
        alert("salio --->FANTASMA /GameRoomFrontEnd"+num);
    }
}

function start(){
    connectAndSuscribe();
    getBackGroundItems()
        .then(function (response) {
            putBackGroundItems(response.data)
        });
    inicial();
}

function putBackGroundItems(list) {
    agregar = "";
    for(var i = 0; i<list.length;i++){
        if(list[i].visible) {
            if (list[i].type === "Block") {
                agregar += "<img style='position:absolute; width:" + list[i].size + "px; height:" + list[i].size + "px; top:" + list[i].posY + "px; left:" + list[i].posX + "px' src='img/block.png'></img>'";
            } else {
                newY = list[i].posY + 7;
                newX = list[i].posX + 7;
                agregar += "<img id='" + list[i].id + "' style='position:absolute; top:" + newY + "px; left:" + newX + "px' src='img/pickups/dot.png'></img>'";
            }
        }
    }
    document.getElementById("game").innerHTML += agregar;
}

function deleteDot(dot) {
    var dot1 = document.getElementById(dot.id);
    dot1.parentNode.removeChild(dot1);
}

function putPacMans(list){
    alert("8. putPacMans PAC-MAN /GameRoomFrontEnd");
    for(var i = 0; i<list.length;i++){
        putPacMan(list[i])
    }
}

function putGhostList(list){
    alert("8G. putGhostList --->FANTASMA /GameRoomFrontEnd");
    for(var i = 0; i<list.length;i++){
        putGhost(list[i])
    }
}

function scores(){
    agregar = "";
    for(var i = 0;i<players.length;i++){
        if(document.getElementById("points"+players[i].id)!=null){
            document.getElementById("points"+players[i].id).innerText = players[i].id+" Points: " + players[i].points
        }else{
            agregar+="<label id = 'points"+ players[i].id +"' style='position:absolute; top:"+(300+(i*30))+"px; left:"+700+"px; color:white'> "+players[i].id+" Points: "+players[i].points+"</label>"
        }
    }
    document.getElementById("game").innerHTML+=agregar;
}

function putPacMan(pacman) {
    alert("9. putPacMan PAC-MAN LO DE LA IMAGEN /GameRoomFrontEnd");
    players.push(pacman);
    agregar = "<img id='pacman"+pacman.id+"' style='position:absolute; width:"+pacman.size+"px; height:"+pacman.size+"px; top:"+pacman.posY+"px; left:"+pacman.posX+"px'";
    if(pacman.dirrection=="U"){
        agregar += " src='img/actors/pacman/up-2.png'></img>"
    }else if(pacman.dirrection=="D"){
        agregar += " src='img/actors/pacman/down-2.png'></img>"
    }else if(pacman.dirrection=="L"){
        agregar += " src='img/actors/pacman/left-2.png'></img>"
    }else{
        agregar += " src='img/actors/pacman/right-2.png'></img>"
    }
    document.getElementById("game").innerHTML += agregar;
}

function putGhost(ghost) {
    alert("9G. putGhost--->FANTASMA LO DE LA IMAGEN /GameRoomFrontEnd");
    players.push(ghost);
    agregar="<img id='pacman"+ghost.id+"' style='position:absolute; width:"+ghost.size+"px; height:"+ghost.size+"px; top:"+ghost.posY+"px; left:"+ghost.posX+"px'";
    
    if(ghost.dirrection=="U"){
            agregar += "src/main/resources/static/img/actors/ghost/" + "blue" + "/" + "up-1.png";
            agregar += "src/main/resources/static/img/actors/ghost/" + "blue" + "/" + "up-2.png";
    }else if(ghost.dirrection=="D"){
            agregar += "src/main/resources/static/img/actors/ghost/" + "blue" + "/" + "down-1.png";
            agregar += "src/main/resources/static/img/actors/ghost/" + "blue" + "/" + "down-2.png";
    }else if(ghost.dirrection=="L"){
            agregar += "src/main/resources/static/img/actors/ghost/" + "blue" + "/" + "left-1.png";
            agregar += "src/main/resources/static/img/actors/ghost/" + "blue" + "/" + "left-2.png";
    }else{
            agregar += "src/main/resources/static/img/actors/ghost/" + "blue" + "/" + "right-1.png";
            agregar += "src/main/resources/static/img/actors/ghost/" + "blue" + "/" + "right-2.png";
    }
    alert("agregar IMAGEN /GameRoomFrontEnd");
    alert(agregar);
    document.getElementById("game").innerHTML += agregar;
}


window.onkeydown = function (e) {
    var key = e.keyCode ? e.keyCode : e.which;
    move(key);
};

function moverPacMan(body) {
    //alert("10. moverPacMan /GameRoomFrontEnd");
    pacman = document.getElementById("pacman"+body.id);
    pacman.style.top = body.posY + "px";
    pacman.style.left = body.posX + "px";
    if(body.dirrection==="U"){
        pacman.src='img/actors/pacman/up-2.png';
    }else if(body.dirrection==="D"){
        pacman.src='img/actors/pacman/down-2.png';
    }else if(body.dirrection==="L"){
        pacman.src='img/actors/pacman/left-2.png';
    }else{
        pacman.src='img/actors/pacman/right-2.png';
    }
    updatePlayers(body);
    scores();
}

function moverGhost(body) {
    //alert("10G. moverGhost--->FANTASMA /GameRoomFrontEnd");
    ghost = document.getElementById(ghost + body.id);
    ghost.style.top = body.posY + "px";
    ghost.style.left = body.posX + "px";
    if(body.dirrection==="U"){
        ghost.src='img/actors/ghost/'+'blue'+'/up-2.png';
    }else if(body.dirrection==="D"){
        ghost.src='img/actors/ghost/'+'blue'+'/down-2.png';
    }else if(body.dirrection==="L"){
        ghost.src='img/actors/ghost/'+'blue'+'/left-2.png';
    }else{
        ghost.src='img/actors/ghost/'+'blue'+'/right-2.png';
    }
    updatePlayers(body);
    scores();
}

function updatePlayers(body){
    for(var i = 0; i<players.length;i++){
        if(players[i].id=body.id) players[i] = body;
    }
}