
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
	/*var h5 = document.createElement("h5");
		h5.innerHTML = "Insira o gabarito: ";
		h5.setAttribute("class", "blue-text text-darken-4");*/
		var container = document.getElementById("containerInput");

		for (var i=0; i<numeroQuestoes; i++){
			container.innerHTML = container.innerHTML + ("<b>Questão "+(i+1)+": </b>");
			var enunciado = questoes[i].getElementsByTagName("enunciado")[0].childNodes[0].nodeValue;
			if (questoes[i].getAttribute("tipo")=="ME"){
				var iterador = questoes[i].getElementsByTagName("alternativa").length;
				
				
				container.innerHTML += enunciado;
				container.appendChild(document.createElement("BR"));

				for (var j=0; j<iterador; j++){
					var textoAlternativaAtual = questoes[i].getElementsByTagName("alternativa")[j].childNodes[0].nodeValue;
					var input = document.createElement("input");
					var label = document.createElement("label");
					input.name = "q"+i;
					input.type = "radio";
					var nomeAtual = "q"+i+"a"+j; //mudei aqui
					input.id = nomeAtual;
					label.setAttribute("for", nomeAtual);
					input.value = textoAlternativaAtual;
					switch (j){
						case 0:
							label.appendChild(document.createTextNode("a)"));
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
					container.innerHTML += textoAlternativaAtual;
					container.appendChild(document.createElement("BR"));
				}
			}

			if (questoes[i].getAttribute("tipo")=="VF"){
				var iterador = questoes[i].getElementsByTagName("alternativa").length;
				container.innerHTML += enunciado;
				container.appendChild(document.createElement("BR"));
				for (var k=0; k<iterador; k++){
					var textoAlternativaAtual = questoes[i].getElementsByTagName("alternativa")[k].childNodes[0].nodeValue;
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
					container.innerHTML += textoAlternativaAtual;
					container.appendChild(document.createElement("BR"));
				}
			}

			if (questoes[i].getAttribute("tipo")=="aberta"){
				var iterador = questoes[i].getElementsByTagName("alternativa").length;
				container.innerHTML += enunciado;
				container.appendChild(document.createElement("BR"));

				container.appendChild(document.createElement("textarea"));
				container.appendChild(document.createElement("BR"));
			}
			container.appendChild(document.createElement("br"));
  }

$("#remover1").remove();
$("#remover2").remove();
$("#remover3").remove();
$("#remover4").remove();

document.getElementById("containerEnviar").style.visibility='visible';
};
reader.readAsText(input.files[0]);
};