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
