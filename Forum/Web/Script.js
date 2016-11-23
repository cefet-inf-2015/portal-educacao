function Categoria() {
	switch(event.target.innerHTML) {
		case "Máterias do Ensino Médio": 
			if (document.getElementsByName("divhide")[0].className=="esconde") {
				document.getElementsByName("divhide")[0].className = "mostra";
			} else {
				document.getElementsByName("divhide")[0].className = "esconde";
			}
		break;
		case "Cursos Técnicos":
			if (document.getElementsByName("divhide")[1].className=="esconde") {
				document.getElementsByName("divhide")[1].className = "mostra";
			} else {
				document.getElementsByName("divhide")[1].className = "esconde";
			}
		break;
		case "Entretenimento":
			if (document.getElementsByName("divhide")[2].className=="esconde") {
				document.getElementsByName("divhide")[2].className = "mostra";
			} else {
				document.getElementsByName("divhide")[2].className = "esconde";
			}
		break;
	}
}

function Responde() {

	var string = event.target.id;
	var Nome = document.getElementById("Nome"+string.substr(string.length - 1)).innerHTML;
	var Matricula = document.getElementById("Matricula"+string.substr(string.length - 1)).innerHTML;
	var Posts = document.getElementById("Posts"+string.substr(string.length - 1)).innerHTML;
	var Classificacao = document.getElementById("Classificacao"+string.substr(string.length - 1)).innerHTML;
	var comentario = document.getElementById("Comentario"+string.substr(string.length - 1)).innerHTML;

	var aux =comentario.split("<div>"); 
	var aux = aux[aux.length-1].split("</div>");


	document.getElementById("ConteudoResposta").innerHTML = Nome+" - "+Matricula+" - "+Posts+" - "+Classificacao+"<br>"+"\""+aux[0]+"\"";
}

function Listener(x) {
	if(x==0) {
		for(i=0; i<document.querySelectorAll(".collection-item").length; i++) {
			document.querySelectorAll(".collection-item")[i].addEventListener("click", Categoria);
		}	
	} else if (x==1) {
		for(i=0; i<document.getElementsByName("BotaoResponde").length; i++) {
			var string = "#BotaoResponde"+i;
			var string2 = "#like"+i;
			document.querySelector(string).addEventListener("click", Responde);
			document.querySelector(string2).addEventListener("click", Curte);
		}
	}
}

function Perfil(x) {
	switch(x) {
		case 0:
			document.getElementById("Nome").innerHTML="Victor Gabriel";
			document.getElementById("Matricula").innerHTML="201511130210";
			document.getElementById("Posts").innerHTML="7";
			document.getElementById("Classificacao").innerHTML="Aluno";
			document.getElementById("Topico1").innerHTML="Tópico 1";
			document.getElementById("Topico2").innerHTML="Tópico 2";
			document.getElementById("Topico3").innerHTML="Tópico 3";
			document.getElementById("Topico4").innerHTML="Tópico 4";
			document.getElementById("PostsTotal").innerHTML="Posts: "+"75";
			document.getElementById("TopicosTotal").innerHTML="Tópicos: "+"17";	
			break;
		case 1:
			document.getElementById("Nome").innerHTML="Victor Gabriel";
			document.getElementById("Matricula").innerHTML="201511130210";
			document.getElementById("Posts").innerHTML="7";
			document.getElementById("Classificacao").innerHTML="Aluno";
			break;
	}
}

function CarregaTopicos(categoria) {
	document.getElementById("Categoria").innerHTML=categoria
	+"<a href='../Pag_do_Topico.html' class='btn-floating btn-large waves-effect waves-light blue'><i class='material-icons'>add</i></a>";
}

function Curte() {
	var string = document.getElementById("divlike0").innerHTML;
	var numero = ((document.getElementById("divlike0").innerHTML).charAt(0));
	numero++;
	string = string.replace(((document.getElementById("divlike0").innerHTML).charAt(0)), numero);
	document.getElementById("divlike0").innerHTML = string;
}