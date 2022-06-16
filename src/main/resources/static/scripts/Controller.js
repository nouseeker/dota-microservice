//adding listener for all buttons on .hero-overview class
let buttons = document.querySelector(".hero_overview").querySelectorAll("button")
for (var i = 0, len = buttons.length; i < len; i++) {
    buttons[i].addEventListener("click", addHero);
}
let roleCh = document.getElementById("roleCh")
roleCh.addEventListener("click", showRole);
let rankCh = document.getElementById("rankCh")
rankCh.addEventListener("click", showRank);
let defCh = document.getElementById("defCh")
defCh.addEventListener("click", showOption);
let selectCh = document.getElementById("select-date")
let postRequest = "";
//elementary radiant and dire count
r = 0;
d = 0;
var def = 1;
var role = 0;
var rank = 0;
var period = selectCh.options[selectCh.selectedIndex].value;
let radiantPlace = document.querySelector(".radiant-placeholder");
let direPlace = document.querySelector(".dire-placeholder");

function addHero() {
    if (this.name == "radiant" && (r < 5)) {
        r++;
        createButton(this);
    } else if ((this.name == "dire") && (d < 5)) {
        d++;
        createButton(this);
    }
}

function createButton(hero) {
    let placeholder = "." + hero.name + "-placeholder";
    let parent = document.querySelector(placeholder);
    let div = document.createElement("button");
    div.id = hero.id;
    div.value = hero.value;
    div.name = hero.name;
    div.style.background = "url(\"../icons/id (" + hero.id + ").png\")";
    div.style.backgroundSize = "cover"
    div.className = "button_hero"
    div.addEventListener("click", remove)
    hero.parentNode.style.zIndex = "-1";
    parent.replaceChild(div, parent.querySelector(".hero-placeholder"))
}

function createDiv(button) {
    let buttonElement = document.createElement("button");
    buttonElement.className = "hero-placeholder";
    button.parentNode.replaceChild(buttonElement, button);
}

//remove item
function remove() {
    createDiv(this);
    document.querySelector(".hero_overview")
        .getElementsByTagName("div")
        .item((this.id - 1))
        .removeAttribute("style");
    if (this.name == "radiant") {
        r--;
    } else d--;
    this.remove();
}

//send data to spring serlvet
function analyze() {
    if ((d == 5) && (r == 5)) {
        var text = "heroes=";
        for (let i = 0; i < 5; i++) {
            text = text + radiantPlace.querySelectorAll("button")[i].value +","
        }
        for (let i = 0; i < 4; i++) {
            text = text + direPlace.querySelectorAll("button")[i].value +","
        }
        text = text + direPlace.querySelectorAll("button")[4].value
        if (def==0){
            if (role==1){
                text = text + "&roleCh=1"
            }
            if (rank==1){
                text = text +"&rankCh=1"
            }
            text = text + "&date="+period;
        }
        else{
            text = text + "&defCh=1"
        }
        post(text)
    } else {
        this.preventDefault();
    }
}

function post(text) {
    $.ajax({
        type: 'POST',
        url: 'selectHero',
        data: text,
        success: function () {
            window.location = "/statistic";
        }
    })
}

function showRole() {
    if (this.checked) {
        document.getElementById("radiantRole").style.display = "table";
        document.getElementById("direRole").style.display = "table";
        role = 1;
    } else {
        document.getElementById("radiantRole").style.display = "none";
        document.getElementById("direRole").style.display = "none";
        role = 0;

    }
}

function showOption() {
    let elem = document.getElementById("options");
    if (this.checked) {
        elem.style.pointerEvents = "none"
        elem.style.opacity = "0.3"
        this.value = 1;
        def = 1;
    } else {
        elem.style.pointerEvents = "visible"
        elem.style.opacity = "1"
        this.value = 0;
        def =0;

    }
}

function showRank() {
    if (this.checked) {
        document.getElementById("rank-container").style.display = "table";
        rank = 1;
    } else {
        document.getElementById("rank-container").style.display = "none";
        rank = 0;
    }
}

