let nom = document.getElementById("nom");
let prenom = document.getElementById("prenom");
let age = document.getElementById("age");

function callback(bypass){
    let estHomme = document.getElementById("sexeHomme").checked;
    
    if(bypass || checkAge(age.value)){
        alert("Bonjour ch" + (estHomme?"er ":"ère ") + prenom.value + " " + nom.value);
        if(bypass == true){
            HTMLFormElement.prototype.submit.call(document.getElementById("form"));
        }
        return true;
    }else{
        alert("Erreur");
    return false;
    }
}

function isEmpty(s){
    if(s == null){
        return true;
    }
    if(s.length == 0){
        return true;
    }
    return false;
}

function isNumeric(s){
    if(s == null){
        return false;
    }
    return s.match("^[0-9]+([\.,][0-9]*)?$") != null;
}

function checkAge(age){
    return isNumeric(age) && (parseInt(age,10) < 130);
}

function preremplir(){
    nom.value = "RAGOT";
    prenom.value = "Alexis";
    age.value = 23;
}
document.getElementById("forcesend").onclick = function(){callback(true)};
document.getElementById("preremp").onclick = preremplir;