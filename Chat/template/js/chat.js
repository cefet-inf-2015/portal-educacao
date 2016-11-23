'use strict';

let ultimoID = 0;
let usuarioAlvo = '';
let tabelaAtiva = '';

window.addEventListener('load', function() {
	setInterval(function() {
		historico();
	},2000);
	
	usuarios();

	document.querySelector('#busca').addEventListener('keyup',function() {
		filtroUsuarios(this.value);
	},false);

	document.querySelector('#info').addEventListener('click',function() {
		if(this.className)
			this.className = '';
	}, false);
}, false);

function carregarConversa(user,tabela) {
	usuarioAlvo = user;
	tabelaAtiva = tabela;
	ultimoID = 0;
	historico();
}

function info(usuario) {
	let requisicao = new XMLHttpRequest();
	requisicao.open("GET", "php/info.php?usuario="+usuario+"&tipo="+tabelaAtiva, true);
	requisicao.onload = function(e) {
		let usuariosElem = document.querySelector("#usuarios");

		let contemMsg = requisicao.response;
		if(contemMsg) {
			document.querySelector('#primeiroNome span').innerText = contemMsg.primeiroNome;
			document.querySelector('#ultimoNome span').innerText = contemMsg.ultimoNome;
			document.querySelector('#username span').innerText = contemMsg.username;
			document.querySelector('#matricula span').innerText = contemMsg.matricula;
			document.querySelector('#turma span').innerText = contemMsg.turma;
			document.querySelector('#divisao span').innerText = contemMsg.divisao;

			document.querySelector('#info').className = 'abrir';
		}
	};

	requisicao.responseType = "json";
	requisicao.send();
}

function usuarios() {
	let requisicao = new XMLHttpRequest();
	requisicao.open("GET", "php/usuarios.php", true);
	requisicao.onload = function(e) {
		let usuariosElem = document.querySelector("#usuarios");
		let contemMsg = requisicao.response;
		if(contemMsg){
			for (let usuario of contemMsg) {
				let userElem = document.createElement('div');
				userElem.classList.add('usuario');
				userElem.innerHTML = usuario.nome;
				userElem.usuario = usuario.username;
				userElem.tabela = usuario.tabela;
				userElem.addEventListener('click',function() {
					carregarConversa(this.usuario,this.tabela);
				},false);
				usuariosElem.appendChild(userElem);
			}
		}
	};

	requisicao.responseType = "json";
	requisicao.send();
}

function historico() {
	//obter historico apenas se houver usuario alvo
	if(!usuarioAlvo) return;
	let requisicao = new XMLHttpRequest();
	requisicao.open("GET", "php/listagem.php?id=" + ultimoID + "&alvo=" + usuarioAlvo, true);
	requisicao.onload = function(e) {
		let ultimoIni = ultimoID;
		let historicoElmto = document.querySelector("#historico");

		//removendo historico no inicio
		if (!ultimoID) historicoElmto.innerHTML = "";

		let contemMsg = requisicao.response;
		for (let cptraLinha of contemMsg) {
			let elmtoHTML = document.createElement("div");
			let elmntoTexto = document.createElement("div");
			elmntoTexto.classList.add('texto');
			let elmntoFoto = document.createElement("div");
			elmntoFoto.classList.add('foto');

			let elmntoMsg = document.createElement("div");
			let elmntoHoras = document.createElement("div");
			elmntoMsg.classList.add('mensagem');
			elmntoHoras.classList.add('horas');
			elmntoMsg.innerText = cptraLinha.mensagem;
			elmntoHoras.innerText = cptraLinha.horas;
			elmntoTexto.appendChild(elmntoMsg);
			elmntoTexto.appendChild(elmntoHoras);

			if (cptraLinha.proprio) {
				elmtoHTML.appendChild(elmntoTexto);
				elmtoHTML.appendChild(elmntoFoto);
				elmtoHTML.classList.add('direita');
			} else {
				elmtoHTML.appendChild(elmntoFoto);
				elmtoHTML.appendChild(elmntoTexto);
				elmtoHTML.classList.add('esquerda');

				elmntoFoto.addEventListener('click',function() {
					info(cptraLinha.usuario);
				},false);
			}
			historicoElmto.appendChild(elmtoHTML);

			ultimoID = cptraLinha.id;
		}
		historicoElmto.offsetHeight;

		//verificar se deve descer a rolagem
		setTimeout(function() {
			if(ultimoIni != ultimoID)
				descerRolagem();
		}, 0);
	};

	requisicao.responseType = "json";
	requisicao.send();
}

function enviar() {
	let mensagem = document.querySelector("#mensagem").value;
	document.querySelector("#mensagem").value = '';
	let requisicao = new XMLHttpRequest();
	requisicao.open("POST", "php/grava_bd.php", true);
	requisicao.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	requisicao.onload = function(e) {
		historico('', ultimoID);
	}
	requisicao.send("mensagem=" + mensagem + "&alvo=" + usuarioAlvo);
}

function descerRolagem() {
	let historicoElmto = document.querySelector("#historico");
	historicoElmto.scrollTop += historicoElmto.scrollHeight;
}

function filtroUsuarios(txt) {
	let reg = new RegExp(txt,'ig');
	let usuarios = document.querySelectorAll('#usuarios .usuario');
	for(let usuario of usuarios) {
		usuario.style.display = (reg.test(usuario.usuario)) ? 'block' : 'none';
	}
}

function buscar() {
	let elem = document.querySelector('#busca');
	historico(elem.value, 0);
	elem.value == '';
	return false;
}
