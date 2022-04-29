const btRed = document.getElementById("btRed");
const btGreen = document.getElementById("btGreen");
const btBlue = document.getElementById("btBlue");

const tred = document.getElementById("tred");
const tgreen = document.getElementById("tgreen");
const tblue = document.getElementById("tblue");

function setBG(color){
    tred.value = color.substring(0,2);
    tgreen.value = color.substring(2,4);
    tblue.value = color.substring(4,6);
    document.body.style.backgroundColor = "#"+color;
}
[btRed,btGreen,btBlue].forEach(e => e.addEventListener("click",function(){setBG(this.dataset.selfcolor)}));

[tred,tgreen,tblue].forEach(e => e.addEventListener("keyup",function(){ if(this.value.length == 2) setBG(tred.value+tgreen.value+tblue.value)}))