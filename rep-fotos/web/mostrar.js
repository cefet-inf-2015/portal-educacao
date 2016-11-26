
function MOSTRAR() {

	var clicar = document.getElementById("inv").style.display
	if (clicar == "none"){
	  document.getElementById("inv").style.display = "block";
 	  document.getElementById("descricao").style.display = "none";
	}else{
 	  document.getElementById("inv").style.display = "none";
          document.getElementById("descricao").style.display = "block"
}
}




