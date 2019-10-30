function menuClick(ref) {
  ref.class = "active";

  var listContainer = document.getElementById("myDIV");

  var btns = btnContainer.getElementsByClassName("btn");

  for (var i = 0; i < lists.length; i++) {
  btns[i].addEventListener("click", function() {
    var current = document.getElementsByClassName("active");
    current[0].className = current[0].className.replace(" active", "");
    this.className += " active";
  });
}
}
