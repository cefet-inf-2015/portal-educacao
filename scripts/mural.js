//include '../Gerência/LoginPHP/Login.php';

let dataAtual = null;


window.onload=function(){
	dataAtual = new Date();

	document.querySelector("#teste").addEventListener('click', posta, false);
		
}


function posta(){
 	let dataPostagem = new Date(),
		texto = document.querySelector("#post").value,
//		nomeUsuario = getPrimeiroNome() + " " + getUltimoNome(),
//		fotoUsuario = getFoto(),
		imgPost = document.querySelector("#file_path").value;
		criaPost(texto, imgPost);
		
}

function cria(el){
	return document.createElement(el);
}

function criaPost(texto, imgPost){
	//criação de Divs
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
	fotoPerf.src = "https://yt3.ggpht.com/-ZtBlVYCvXOg/AAAAAAAAAAI/AAAAAAAAAAA/-5eDEfuCFlA/s900-c-k-no-rj-c0xffffff/photo.jpg"

	divNome = cria('div');
	divNome.className = "col s11";

	nomePerf = cria('a');
	nomePerf.className = "blue-text text-lighten-1";
	nomePerf.setAttribute("id", "nameProf");
	nomePerf.innerHTML = "Gabriel Haddad";

	tempo = cria('p');
	tempo.className = "grey-text text-lighten-1 hora";
	tempo.innerHTML= "2 min";


	divRow2 = cria('div');
	divRow2.className = "row";

	divCont = cria('div');
	divCont.className = "col s12";

	post = cria('p');
	post.className = "black-text center";
	post.innerHTML = texto;

	fotoCont = cria('img');
	fotoCont.className = "center-block materialboxed square responsive-img";
	fotoCont.src = "../../../"+imgPost;


	divLike = cria('div');
	divLike.className = "col s6";

	aLike = cria('a');
	aLike.className = "waves-effect waves-light btn light-blue darken-4";
	aLike.setAttribute("id","pub");

	iLike= cria('i');
	iLike.className = "medium material-icons white-text text-darken-1";
	iLike.innerHTML = "thumb_up";

	aLike.appendChild(iLike);
	divLike.appendChild(aLike);

	divCont.appendChild(post);
	divCont.appendChild(fotoCont);

	divRow2.appendChild(divCont);
	divRow2.appendChild(divLike);

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

