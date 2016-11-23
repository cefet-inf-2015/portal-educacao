

function sendBD() {
	let dataPostagem = new Date(),
		segundos = dataPostagem.getSeconds(),
		minutos = dataPostagem.getMinutes(),
		horas = dataPostagem.getHours(),
		dia = dataPostagem.getDate(),
		mes = dataPostagem.getMonth()+1,
		ano = dataPostagem.getFullYear(),
		dataPostString = "",
		texto = document.querySelector("#post").value;
	if(texto!=''){
		if(dia<10) {
			dia='0'+dia;
		} 
		if(mes<10) {
		    mes='0'+mes;
		}
		if(horas<10) {
			horas='0'+horas;
		} 
		if(minutos<10) {
		    minutos='0'+minutos;
		}
		if(segundos<10) {
			segundos='0'+segundos;
		} 
		dataPostString = dia+"/"+mes+"/"+ano+" as "+horas+":"+minutos+":"+segundos; 	
  	    window.location.href = "UploadBD.php?texto="+texto+"&dataPostString="+dataPostString;
	}
}

function loadBD(linha){
	$(function(){
		$.ajax({
			url: '../web/LoadPosts.php',
			data: {
				linha: linha
			},
			dataType: 'json',
			success: function(data){
				//data = JSON.parse(data);

				//Chama função para criação do layout do post obtido
				criaPost(data);

				//Chama a função recursivamente para carregar todas postagens
				if(data!=null){	
					loadBD(++linha);
				}

			}
		});
	});
}


function posta(){ 
 	let dataPostagem = new Date(),
 		segundos = dataPostagem.getSeconds(),
 		minutos = dataPostagem.getMinutes(),
 		horas = dataPostagem.getHours(),
 		dia = dataPostagem.getDate(),
 		mes = dataPostagem.getMonth()+1,
 		ano = dataPostagem.getFullYear(),
 		dataPostString = "",
		texto = document.querySelector("#post").value,
//		nomeUsuario = getPrimeiroNome() + " " + getUltimoNome(),
//		fotoUsuario = getFoto(),
		imgPost = document.querySelector("#file_path").value;
		if(texto == "" && imgPost == ""){

		}else{

			if(dia<10) {
			    dia='0'+dia;
			} 

			if(mes<10) {
			    mes='0'+mes;
			}

			dataPostString = dia+"/"+mes+"/"+ano+" às "+horas+":"+minutos+":"+segundos 

			criaPost(texto, imgPost, dataPostString);
		}
}

function cria(el){
	return document.createElement(el);
}


window.onload=function(){
	//document.querySelector("#teste").addEventListener('click', posta, false);
	document.querySelector("#btnPost").addEventListener('click', sendBD, false);
	loadBD(1);

}


function criaPost(data){ //criação do Layout de uma postagem

	//Criação de Divs para o layout
	let divExt, divCard, divRow1, divFoto,
		divNome, divRow2, divCont, divLike;
	let fotoPerf, nomePerf, tempo, post, fotoCont, aLike, iLike;
	divExt= cria('div');
	divExt.className = "col s12 m8 offset-m2 l6 offset-l3";
	divCard = cria('div');
	divCard.className= "card-panel grey lighten-5 z-depth-1";
	divRow1 = cria('div');
	divRow1.className= "row valign-wrapper";
	divFoto = cria('div');
	divFoto.className = "col s6 m2 l2";
	fotoPerf = cria('img');
	fotoPerf.className = "square responsive-img";
	fotoPerf.src = "http://elaele.com.br/img/anonimo.png";
	divNome = cria('div');
	divNome.className = "col s11";
	nomePerf = cria('a');
	nomePerf.className = "blue-text text-lighten-1";
	nomePerf.setAttribute("id", "nameProf");
	nomePerf.innerHTML = data.usuario;
	tempo = cria('p');
	tempo.className = "grey-text text-lighten-1 hora";
	tempo.innerHTML= data.data;
	divRow2 = cria('div');
	divRow2.className = "row";
	divCont = cria('div');
	divCont.className = "col s12";
	post = cria('p');
	post.className = "black-text center";
	post.innerHTML = data.conteudo;

	// fotoCont = cria('img');
	// fotoCont.className = "center-block materialboxed square responsive-img";
	// fotoCont.src = "../../../"+imgPost;

	//Impede a criação de campo vazio ou com erro
	if(data.conteudo!=""){
		divCont.appendChild(post);
	}
	
	divRow2.appendChild(divCont);
	divNome.appendChild(nomePerf);
	divNome.appendChild(tempo);
	divFoto.appendChild(fotoPerf);
	divRow1.appendChild(divFoto);
	divRow1.appendChild(divNome);
	divCard.appendChild(divRow1);
	divCard.appendChild(divRow2);
	divExt.appendChild(divCard);
	document.querySelector('#posts').appendChild(divExt);

}
