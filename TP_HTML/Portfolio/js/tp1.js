var frame = document.getElementById("frame");
function refreshFrame()
// function execute while load the iframe 
{
    // set the height of the iframe as 
    // the height of the iframe content
    frame.style.height =
        frame.contentWindow.document.body.scrollHeight + 'px';


}

function pointToFile(index){
    frame.src = "TP1/"+"item" + index + ".html";
}
// Selecting the iframe element

// Adjusting the iframe height onload event
frame.onload = refreshFrame();
let buttons = document.getElementsByTagName("button");
for (let index = 0; index < buttons.length; index++) {
    const element = buttons[index];
    element.addEventListener("click", function(){pointToFile(index+1)});
    element.addEventListener("click", refreshFrame);

}
setInterval(refreshFrame, 200);

