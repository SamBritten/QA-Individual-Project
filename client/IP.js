function menuClick() {
  var listContainer = document.getElementById("ul");

  var lists = listContainer.getElementsByClassName("li");

  for (var i = 0; i < lists.length; i++) {
    lists[i].addEventListener("click", function() {
      var current = document.getElementsByClassName("active");
      current[0].className = current[0].className.replace(" active", "");
      this.className += " active";
    });
  }
}

function higlightDisable() {
  document.getElementById("a1").style.color = "gray";
}

function getSwitchRecords() {
  console.log("gsr");
  let request = new XMLHttpRequest();
  request.open("GET", "http://"+location.hostname+":9005/switches.html");
  request.onload = function() {
      displayRecords(JSON.parse(request.response));
    }
  request.send();
}

getSwitchRecords();

function checkSwitches() {
  let ref1 = document.getElementById("mF");
  let ref2 = document.getElementById("nF");
  let ref3 = document.getElementById("afF");
  let ref4 = document.getElementById("iF");
  let falseCheck = true;

  if(ref1.value == "") {
    document.getElementById("s1").style.visibility = "visible";
    falseCheck = false;
  }
  if(ref2.value == "") {
    document.getElementById("s2").style.visibility = "visible";
    falseCheck = false;
  }
  if(ref3.value == "") {
    document.getElementById("s3").style.visibility = "visible";
    falseCheck = false;
  }
  if(ref4.value == "") {
    document.getElementById("s4").style.visibility = "visible";
    falseCheck = false;
  }
  return falseCheck;
}

function addSwitchRecord(formData) {
  let manufacturer = document.getElementById("mF").value;
  let name = document.getElementById("nF").value;
  let type = document.querySelector('input[name = "type"]:checked').value;
  let actuation = document.getElementById("afF").value;
  let tactile = document.getElementById("tfF").value;
  let image = document.getElementById("iF").value;
  let request = new XMLHttpRequest();
  request.open("POST", "http://"+location.hostname+":9005/addNewSwitch");
  request.setRequestHeader("Content-Type", "application/json");
  request.onload = function(){
    getSwitchRecords();
  }
  request.send(JSON.stringify({"manufacturer":manufacturer, "name":name, "type":type, "actuation":actuation,
   "tactile":tactile, "image":image}));
  return false;
}

function deleteSwitchRecord(id) {
  let request = new XMLHttpRequest();
  request.open("DELETE", "http://"+location.hostname+":9005/deleteSwitch/"+id);
  request.onload = function () {
    getSwitchRecords();
  }
  request.send();
}

let clickedId;


function updateSwitchRecord(formData) {
  let manufacturer = document.getElementById("mF2").value;
  let name = document.getElementById("nF2").value;
  let type = document.querySelector('input[name = "type2"]:checked').value;
  let actuation = document.getElementById("afF2").value;
  let tactile = document.getElementById("tfF2").value;
  let image = document.getElementById("iF2").value;
  let request = new XMLHttpRequest();
  request.open("PUT", "http://"+location.hostname+":9005/updateSwitch/"+clickedId);
  request.setRequestHeader("Content-Type", "application/json")
  request.onload = function () {
    getSwitchRecords();
  }


  let jsonData=JSON.stringify({"id": clickedId, "manufacturer":manufacturer, "name":name, "type":type, "actuation":actuation,
   "tactile":tactile, "image":image});
  request.send(jsonData);
}


function displayRecords(jsData) {
  let showAll = document.getElementById("switches");
  showAll.innerHTML="";

  jsData.forEach(function(item) {
    let card = document.createElement("div");
    card.className = "card m-2 p-3";
    let list = document.createElement("ul");
    list.className = "list-group";
    let manufacturer=document.createElement("li");
    manufacturer.id="manufacturer";
    manufacturer.className="list-group-item";
    let name=document.createElement("li");
    name.id="name";
    name.className="list-group-item";
    let type=document.createElement("li");
    type.className="list-group-item";
    let actuation=document.createElement("li");
    actuation.id="actuation";
    actuation.className="list-group-item";
    let tactile=document.createElement("li");
    tactile.id="tactile";
    tactile.className="list-group-item";
    let image=document.createElement("li");
    image.id="image";
    image.className="list-group-item";
    let imageBox = document.createElement("img");
    imageBox.setAttribute("src", item.image);
    imageBox.setAttribute("width", 350);
    imageBox.setAttribute("height", 300);

    let delete2 = document.createElement("button");
    delete2.innerText = "DELETE";
    delete2.addEventListener("click", function() {
      deleteSwitchRecord(item.id);
    });

    let update = document.createElement("button");
    update.innerText = "EDIT";
    update.addEventListener("click", function() {
      clickedId = item.id;
      window.scroll({
        top: 0,
        left: 0,
        behavior: 'smooth'
      });
      document.getElementById("editForm").style.visibility="visible";

      document.getElementById("mF2").value=item.manufacturer;
      document.getElementById("nF2").value=item.name;
      //document.querySelector('input[name = "type"]:checked').value=item.type;
      document.getElementById("afF2").value=item.actuation;
      document.getElementById("tfF2").value=item.tactile;
      document.getElementById("iF2").value=item.image;
    });

    image.appendChild(imageBox);

    manufacturer.innerText="Manufacturer: " + item.manufacturer;
    name.innerText="Name: " + item.name;
    type.innerText="Type: " + item.type;
    actuation.innerText="Actuation force: " + item.actuation + " cN";
    tactile.innerText="Tactile force: " + item.tactile + " cN";
    list.appendChild(manufacturer);
    list.appendChild(name);
    list.appendChild(type);
    list.appendChild(actuation);
    if(item.tactile!=0) {
      list.appendChild(tactile);
    }
    list.appendChild(image);
    list.appendChild(delete2);
    list.appendChild(update);

    card.appendChild(list)
    showAll.appendChild(card);
  });
}
