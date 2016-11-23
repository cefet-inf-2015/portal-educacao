window.onload = function(){
    callPage_1 ('atualizaAlunos.php', null);
    document.getElementById('enviar').onclick = function() {
    //Pega selecionado do select:
        var nome = $('selecionaNome').find(":selected").text();
        console.log(nome);
        callPage_1 ('partPHP.php?nome=${nome}', null);
    }
}
 
function AjaxCaller_1(){
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
 
    function callPage_1(url, div){
        ajax = AjaxCaller_1();
        ajax.open("GET", url, true);
        ajax.onreadystatechange=function(){
            if(ajax.readyState==4){
                if(ajax.status==200){
                    resposta = ajax.responseText;
                    //Transforma resp em array de objetos.
                    //Sugestao: fazer laço for que cria opcoes no select.
                    //P/ ver como cria dinamicamente: http://bit.ly/2fq2SCI
                    resposta = JSON.parse(resposta);
                    geraSelect(resposta);
                }
            }
        }
    ajax.send(null);
    }


function geraSelect(vetor) {
    let select = document.createElement('select');
    select.setAttribute("name","matricula");
    for (let aluno of vetor) {
        let option = document.createElement('option');
        let nomeCompleto = aluno.primeiroNome + ' ' + aluno.ultimoNome;
        option.textContent = nomeCompleto;
        option.value = aluno.matricula +","+ nomeCompleto;
        select.appendChild(option);
    }
    let div = document.querySelector('#divMat');
    div.appendChild(select);
    //console.log(div.innerHTML);
    $('select').material_select();
}

// var botao = document.getElementsByName("Enviar");
// botao.addEventListener("click", function(){callPage_1 ('partPHP.php?nome=${nome}', null); });
 

