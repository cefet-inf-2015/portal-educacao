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
function Listener() {
	for(i=0; i<document.querySelectorAll(".collection-item").length; i++) {
		document.querySelectorAll(".collection-item")[i].addEventListener("click", Categoria);
	}
	
}