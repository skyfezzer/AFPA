

const body = document.getElementsByClassName("conteneur")[0];

function deg_to_rad(degrees)
{
  var pi = Math.PI;
  return degrees * (pi/180);
}

function generate_trigo() {
    // get the reference for the body

    // creates a <table> element and a <tbody> element
    const tbl = document.createElement("table");
    const tblBody = document.createElement("tbody");
    var row = document.createElement("tr");
    var cell = document.createElement("th");
    var content = document.createTextNode("Angle en degrés");
    cell.appendChild(content);
    row.appendChild(cell);
    content = document.createTextNode("Sinus");
    cell = document.createElement("th");
    cell.appendChild(content);
    row.appendChild(cell);
    content = document.createTextNode("Cosinus");
    cell = document.createElement("th");
    cell.appendChild(content);
    row.appendChild(cell);
    content = document.createTextNode("Tangeante");
    cell = document.createElement("th");
    cell.appendChild(content);
    row.appendChild(cell);
    tbl.appendChild(row);
    // creating all cells
    for (let i = 0; i < 91; i++) {
        // creates a table row
        row = document.createElement("tr");
        // creates a cell
        cell = document.createElement("td");
        // first cell to current degree
        content = document.createTextNode(i);
        cell.appendChild(content);
        //add cell to current row
        row.appendChild(cell);
        // second cell is sinus
        cell = document.createElement("td");
        content = document.createTextNode(Math.sin(deg_to_rad(i)));
        cell.appendChild(content);
        //add cell to current row
        row.appendChild(cell);
        // third is cosinus
        cell = document.createElement("td");
        content = document.createTextNode(Math.cos(deg_to_rad(i)));
        cell.appendChild(content);
        //add cell to current row
        row.appendChild(cell);
        // last is tan.
        cell = document.createElement("td");
        content = document.createTextNode(Math.tan(deg_to_rad(i)));
        cell.appendChild(content);
        //add cell to current row
        row.appendChild(cell);

        // add the row to the end of the table body
        tblBody.appendChild(row);
    }

    tbl.appendChild(tblBody);
    body.appendChild(tbl);
}

function generate_infos(){
        // get the reference for the body
        const body = document.getElementsByTagName("body")[0];
        // create a title as <h1>
        const title = document.createElement("h1");
        title.textContent = "Informations sur le navigateur utilisé";
        body.appendChild(title);
        // creates a <table> element and a <tbody> element
        const tbl = document.createElement("table");
        const tblBody = document.createElement("tbody");
        // Browser name
        var row = document.createElement("tr");
        var cell = document.createElement("td");
        var content = document.createTextNode(navigator.appName);
        cell.appendChild(content);
        row.appendChild(cell);
        tblBody.appendChild(row);

        // Browser version
        row = document.createElement("tr");
        cell = document.createElement("td");
        content = document.createTextNode(navigator.appVersion);
        cell.appendChild(content);
        row.appendChild(cell);
        tblBody.appendChild(row);

        // Browser "CodeName"
        row = document.createElement("tr");
        cell = document.createElement("td");
        content = document.createTextNode(navigator.appCodeName);
        cell.appendChild(content);
        row.appendChild(cell);
        tblBody.appendChild(row);

        // Browser UserAgent
        row = document.createElement("tr");
        cell = document.createElement("td");
        content = document.createTextNode(navigator.userAgent);
        cell.appendChild(content);
        row.appendChild(cell);
        tblBody.appendChild(row);

        // Browser Platform
        row = document.createElement("tr");
        cell = document.createElement("td");
        content = document.createTextNode(navigator.platform);
        cell.appendChild(content);
        row.appendChild(cell);
        tblBody.appendChild(row);
        // -----------
        tbl.appendChild(tblBody);
        body.appendChild(title);
        body.appendChild(tbl);
}

function dateMaj(){
    let d = document.lastModified.substring(0,10).split("/");
    let e = d[1];
    let m = d[0];
    let y = d[2]; 
    return( e + "/" + m + "/" + y);
}
function generate_footer(){
    // main div
    document.getElement
    var div = document.createElement("div");
    div.classList.add("footer");
    var sentence = document.createElement("p");
    sentence.innerHTML = "<p>Pour toute question ou remarque concernant cette page, envoyez un mail à <a href=\"mailto:alexisragot77@gmail.com\">alexisragot77@gmail.com</a></p>";
    div.appendChild(sentence);
    sentence=document.createElement("p");
    
    sentence.textContent = "Copyright \u00a9 2022 Alexis RAGOT - Dernière modification " + dateMaj();
    div.appendChild(sentence);
    body.appendChild(div);


}

generate_trigo();
generate_infos();
generate_footer();