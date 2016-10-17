window.addEventListener('load',function() {
historico();

},false);

function historico () {
	let requisicao= new XMLHttpRequest();
	requisicao.open("GET","php/listagem.php", true);
	requisicao.onload= function(e) {
		let historicoElmto = document.querySelector("#historico");
		historicoElmto.innerHTML="";

		let contemMsg = requisicao.response;
		for (let cptraLinha of contemMsg){
			let elmtoHTML = document.createElement("div");
			let elmntoTexto=document.createElement("div");
			elmntoTexto.innerText=cptraLinha;
			elmtoHTML.appendChild(elmntoTexto);
			historicoElmto.appendChild(elmtoHTML);
		}
		historicoElmto.offsetHeight;
		setTimeout(function(){
			historicoElmto.scrollTop += historicoElmto.scrollHeight;
		},0);
	}

	requisicao.responseType="json";
	requisicao.send();
}
 
function enviar () {
	let mensagem= document.querySelector("#mensagem").value;
	document.querySelector("#mensagem").value = '';
	let requisicao= new XMLHttpRequest();
	requisicao.open("POST","php/grava_bd.php", true);
	requisicao.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	requisicao.onload= function(e) {
		historico();
	}
	requisicao.send("mensagem="+mensagem);
}