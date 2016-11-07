$(document).ready(function() {
	$(".dropdown-button").dropdown();
	$('.modal-trigger').leanModal();
	$('select').material_select();
    document.querySelector('#loginBtn').addEventListener('click', login, false);
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
                div.innerHTML = ajax.responseText;
            }
        }
    }
    ajax.send(null);
}

function login() {
	let modalSenha, nome, senha, tipo;
    modalSenha = document.querySelector('#modal1');
	nome = modalSenha.querySelector('input[name="username"]').value;
    senha = modalSenha.querySelector('input[name="senha"]').value;
    tipo = modalSenha.querySelector('input[name="tipoUsuario"]');
    console.log(tipo);
    callPage(`/Gerência/LoginPHP/Login.php?nome=${nome}&senha=${senha}&tipo=${tipo}`, document.getElementById(targetId));
}