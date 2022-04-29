const urlParams = new URLSearchParams(window.location.search);
const loc = urlParams.get("location");
if (loc) {
    $(document).ready(function () {
        $("#result").load(loc);
    });
} else {
    $("#result").append("<br/><h3>Paramètres reçus : </h3><p>");
    for (var pair of urlParams.entries()) {
        
        $("#result").append("var <strong>"+pair[0]+"</strong>" + ' = [' + pair[1] + "]<br/>");
    }
    $("#result").append("</p>");
}