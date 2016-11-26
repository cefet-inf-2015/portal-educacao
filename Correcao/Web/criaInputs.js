
var numeroQuestoes;
var openFile = function(event) {
	var script = document.createElement('script');
script.src = 'http://code.jquery.com/jquery-1.11.0.min.js';
script.type = 'text/javascript';
document.getElementsByTagName('head')[0].appendChild(script);
  var input = event.target;
  var reader = new FileReader();
  reader.onload = function(){
	var xmlDoc = jQuery.parseXML(reader.result);
	var numeroQuestoes = xmlDoc.getElementsByTagName("questao").length;
	var questoes = xmlDoc.getElementsByTagName("questao");
	var h5 = document.createElement("h5");
		h5.innerHTML = "Insira o gabarito: ";
		h5.setAttribute("class", "blue-text text-darken-4");
		var container = document.getElementById("containerInput");
		container.appendChild(h5);
		var array = ["a", "b", "c", "d", "e"];
		for (var i=0; i<numeroQuestoes; i++){
			if (questoes[i].getAttribute("tipo")=="ME"){
				var iterador = questoes[i].getElementsByTagName("alternativa").length;
				container.innerHTML = container.innerHTML + ("Questão "+(i+1)+": ");
				for (var j=0; j<iterador; j++){
					var alternativaAtual = questoes[i].getElementsByTagName("alternativa")[j].childNodes[0].nodeValue;
					var input = document.createElement("input");
					var label = document.createElement("label");
					input.name = "q"+i;
					input.type = "radio";
					var nomeAtual = "q"+i+"a"+j; //mudei aqui
					input.id = nomeAtual;
					label.setAttribute("for", nomeAtual);
					input.value = alternativaAtual;
					switch (j){
						case 0:
							label.appendChild(document.createTextNode("a)"));
							input.required = true;
							break;
						case 1:
							label.appendChild(document.createTextNode("b)"));
							break;
						case 2:
							label.appendChild(document.createTextNode("c)"));
							break;
						case 3:
							label.appendChild(document.createTextNode("d)"));
							break;
						case 4:
							label.appendChild(document.createTextNode("e)"));
							break;
					}
					container.appendChild(input);
					container.appendChild(label);
				}
			} else if (questoes[i].getAttribute("tipo")=="VF"){
				container.innerHTML = container.innerHTML + ("Questão "+(i+1)+": ");
				var iterador = questoes[i].getElementsByTagName("alternativa").length;
				for (var k=0; k<iterador; k++){
					var input = document.createElement("input");
					var label = document.createElement("label");
					input.type = "checkbox";
					input.name = "q"+i+"[]";
					var nomeCheckbox = "q"+i+"a"+k;//mudei aqui
					input.id = nomeCheckbox
					input.value = k;
					label.setAttribute("for", nomeCheckbox);
					container.appendChild(input);
					container.appendChild(label);
				}
			}
			container.appendChild(document.createElement("br"));
  }
};
reader.readAsText(input.files[0]);
};
