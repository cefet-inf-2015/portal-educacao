
var numeroQuestoes;
var openFile = function(event) {
  var input = event.target;
  var reader = new FileReader();
  reader.onload = function(){
	var xmlDoc = jQuery.parseXML(reader.result);
	numeroQuestoes = xmlDoc.getElementsByTagName("questao").length;
	var h5 = document.createElement("h5");
	h5.innerHTML = "Insira o gabarito: ";
	h5.setAttribute("class", "blue-text text-darken-4");
	var container = document.getElementById("containerInput");
	container.appendChild(h5);
	for (var i=1; i<=numeroQuestoes; i++){
		var input = document.createElement("input");
		input.type = "text";
		input.setAttribute("name", "resposta[]");
		var label = document.createElement("label");
		label.setAttribute("for", "resposta[]");
		label.innerHTML = "Questão "+i;
		container.appendChild(label);
		container.appendChild(input);
		container.appendChild(document.createElement("br"));
  }
};
reader.readAsText(input.files[0]);
};
