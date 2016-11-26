$(document).ready(function() {
	$(".dropdown-button").dropdown();
	$('.modal-trigger').leanModal();
	$('select').material_select();
    let botao;
    if ( document.querySelector("#logOutBtn") != null) {
        botao = document.querySelector("#logOutBtn");
        botao.addEventListener('click', logOut, false);
    }
    else {
        botao = document.querySelector('#loginBtn');
        botao.addEventListener('click', login, false);
    }
});

function AjaxCaller(){
    var xmlhttp=false;
    try{
        xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
    }catch(e){
        try{
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }catch(E){
            xmlhttp = false;
        }
    }

    if(!xmlhttp && typeof XMLHttpRequest!='undefined'){
        xmlhttp = new XMLHttpRequest();
    }
    return xmlhttp;
}

function callPage(url, div){
    ajax=AjaxCaller(); 
    ajax.open("GET", url, true); 
    ajax.onreadystatechange=function(){
        if(ajax.readyState==4){
            if(ajax.status==200){
                resposta = ajax.responseText;
                if (resposta === "passed") {
                  setTimeout( () => {window.location.reload(true);}, 500);
                }
                else {
                    div.textContent = "Dados inválidos";
                }
            }
        }
    }
    ajax.send(null);
}

function logOut() {
    callPage(`./Gerencia/LoginPHP/Logout.php`, document.querySelector('#msgSaiu'));
    //window.location.reload(true);
    setTimeout( () => {window.location.reload(true);}, 500);
}

function login() {
	let modalSenha, nome, senha, tipo;
    modalSenha = document.querySelector('#modal1');
	nome = modalSenha.querySelector('input[name="username"]').value;
    senha = modalSenha.querySelector('input[name="senha"]').value;
    let e = modalSenha.querySelector('#tipoUsuario');
    tipo = e.options[e.selectedIndex].textContent;
    callPage(`./Gerencia/LoginPHP/Login.php?nome=${nome}&senha=${senha}&tipo=${tipo}`, document.getElementById('targetId'));
}