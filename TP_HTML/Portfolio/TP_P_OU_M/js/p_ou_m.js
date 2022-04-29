var tauntSentences = ["Allez, on se concentre un peu, tu fais aucun effort."
        ,"Je pourrais faire un robot qui joue mieux que toi..."
        ,"Tu le fais exprès ?"
        ,"On en a pour toute la soirée..."
        ,"Bien joué, tu t'es encore loupé."
        ,"ZzzZZzZz..."
        ,"Si c'est pour faire ça, laisse moi jouer tout seul... "
        ,"Tu as déjà pensé aux tests de QI ? Penses-y."
        ,""
        ,""
        ];

function $(s){
    return document.getElementById(s);
}
const divInput = $("reponseJoueur");
const btReset = $("btReset");
const btJouer = $("btJouer");
const btValider = $("btReponse");
const lSubtitle = $("subtitle");
const tDerniereProp = $("tDerniereProp");
const tEssaiNum = $("tEssaiNum");
const tRepOut = $("tRep");
const tRepIn = $("tReponse");


const randMin = 1, randMax = 500;
var atrouver,tour;

function getRandomInt(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min)) + min;
  }

function startGame(){
    document.forms[0].reset();
    atrouver = getRandomInt(randMin,randMax);
    tour = 0;
    btJouer.disabled = true;

    showInputs();
}

function playATurn(){
    tour++;

    if(tRepIn.value.length == 0){
        lSubtitle.textContent = "Il faut taper sur le clavier avec tes doigts avant de cliquer !";
        return;
    }

    refreshGUI();


}

function refreshGUI(){
    $("subtitle").textContent = tauntSentences[getRandomInt(0,(tauntSentences.length*100))%tauntSentences.length];
    tDerniereProp.value = tRepIn.value;
    tRepIn.value = "";
    tEssaiNum.value = tour;
    tRepOut.value = getReponse();
    tRepIn.focus();
}

function getReponse(){
    switch (true) {
        case tDerniereProp.value == atrouver:
            playerWon();
            return "Gagné !";
        case tDerniereProp.value > atrouver:
            return "Plus petit !";
        default:
            return "Plus grand !";
    }
}

function showInputs(){
    $("reponseJoueur").classList.remove('hidden');
}


function playerWon(){
    divInput.classList.add("hidden");
}

tRepIn.addEventListener("keydown",function(e){
    if(e.code == "Enter"){
        btValider.click();
    }
});
btReset.addEventListener("click",function(){location.reload()});
btJouer.addEventListener("click",function(){startGame()});
btValider.addEventListener("click",function(){playATurn()});
