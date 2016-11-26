<!DOCTYPE html>
<html>
   <head>
      <title>Prova Online</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
      <title>Portal Educação</title>
      <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script src="../../template/js/materialize.js"></script>
      <script src="../../template/js/init.js"></script>
      <script src="script.js"></script>
       <!-- Compiled and minified CSS -->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">

      <script type="text/javascript">
         
var numeroQuestoes;
 function insere() {
   var script = document.createElement('script');
   script.src = 'http://code.jquery.com/jquery-1.11.0.min.js';
   script.type = 'text/javascript';
   document.getElementsByTagName('head')[0].appendChild(script);
  var input = event.target;
  var reader = new FileReader();
  reader.onload = function(){
   var xmlDoc = <?php echo json_encode($_POST['conteudo']); ?>;
   var numeroQuestoes = xmlDoc.getElementsByTagName("questao").length;
   var questoes = xmlDoc.getElementsByTagName("questao");
   /*var h5 = document.createElement("h5");
      h5.innerHTML = "Insira o gabarito: ";
      h5.setAttribute("class", "blue-text text-darken-4");*/
      var container = document.getElementById("containerInput");

      for (var i=0; i<numeroQuestoes; i++){
         container.innerHTML = container.innerHTML + ("<b>Questão "+(i+1)+": </b>");
         var enunciado = questoes[i].getElementsByTagName("enunciado")[0].childNodes[0].nodeValue;
         if (questoes[i].getAttribute("tipo")=="ME"){
            var iterador = questoes[i].getElementsByTagName("alternativa").length;
            
            
            container.innerHTML += enunciado;
            container.appendChild(document.createElement("BR"));

            for (var j=0; j<iterador; j++){
               var textoAlternativaAtual = questoes[i].getElementsByTagName("alternativa")[j].childNodes[0].nodeValue;
               var input = document.createElement("input");
               var label = document.createElement("label");
               input.name = "q"+i;
               input.type = "radio";
               var nomeAtual = "q"+i+"a"+j; //mudei aqui
               input.id = nomeAtual;
               label.setAttribute("for", nomeAtual);
               input.value = textoAlternativaAtual;
               switch (j){
                  case 0:
                     label.appendChild(document.createTextNode("a)"));
                     break;
                  case 1:
                     label.appendChild(document.createTextNode("b)"));
                     break;
                  case 2:
                     label.appendChild(document.createTextNode("c)"));
                     break;
                  case 3:
                     label.appendChild(document.createTextNode("d)"));
                     break;
                  case 4:
                     label.appendChild(document.createTextNode("e)"));
                     break;
               }
               container.appendChild(input);
               container.appendChild(label);
               container.innerHTML += textoAlternativaAtual;
               container.appendChild(document.createElement("BR"));
            }
         }

         if (questoes[i].getAttribute("tipo")=="VF"){
            var iterador = questoes[i].getElementsByTagName("alternativa").length;
            container.innerHTML += enunciado;
            container.appendChild(document.createElement("BR"));
            for (var k=0; k<iterador; k++){
               var textoAlternativaAtual = questoes[i].getElementsByTagName("alternativa")[k].childNodes[0].nodeValue;
               var input = document.createElement("input");
               var label = document.createElement("label");
               input.type = "checkbox";
               input.name = "q"+i+"[]";
               var nomeCheckbox = "q"+i+"a"+k;//mudei aqui
               input.id = nomeCheckbox
               input.value = k;
               label.setAttribute("for", nomeCheckbox);
               container.appendChild(input);
               container.appendChild(label);
               container.innerHTML += textoAlternativaAtual;
               container.appendChild(document.createElement("BR"));
            }
         }

         if (questoes[i].getAttribute("tipo")=="aberta"){
            var iterador = questoes[i].getElementsByTagName("alternativa").length;
            container.innerHTML += enunciado;
            container.appendChild(document.createElement("BR"));

            container.appendChild(document.createElement("textarea"));
            container.appendChild(document.createElement("BR"));
         }
         container.appendChild(document.createElement("br"));
  }

$("#remover1").remove();
$("#remover2").remove();
$("#remover3").remove();
$("#remover4").remove();

document.getElementById("containerEnviar").style.visibility='visible';
};
reader.readAsText(input.files[0]);
};
      </script>

      <!-- Compiled and minified JavaScript -->
      <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
      <script src="criaInputs.js"></script>
      <!-- CSS  -->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <link href="../../styles/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
      <link href="../../styles/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
      <link rel="icon" href="../../imgs/logo.png" >
      <link rel="stylesheet" type="text/css" href="estilo.css">
      <style type="text/css">
         body {
         display: flex;
         min-height: 100vh;
         flex-direction: column;
         }
         main {
         flex: 1 0 auto;
         }
      </style>
      <link rel="icon" href="../../imgs/logo.png" >
   </head>
   <body>
      <body action="#" method="post" enctype="multipart/form-data" onload="insere()">
         <nav class="light-blue darken-4" role="navigation">
            <div class="nav-wrapper container">
               <!-- MENU SLIDE OUT STRUCTURE-->
               <ul id="slide-out" class="side-nav">
                  <br>
                  <li>
                     <div class="logo">
                        <img class="background center-block responsive" src="../../imgs/logo.png">
                     </div>
                  </li>
                  <br>
                  <li><a class="waves-effect" href="../../index.html">Página Inicial</a></li>
                  <li><a class="waves-effect" href="pagInicial.html">Modelo de Provas/Trabalhos</a></li>
                  <li><a class="waves-effect" href="../../Forum/Web/Fórum.html">Fórum</a></li>
                  <li><a class="waves-effect" href="../../Upload/index.html">Download/Upload Aplicativos</a></li>
                  <li><a class="waves-effect" href="../../Correcao/LayoutCorrecaoProvas.html">Correção Provas e Trabalhos</a></li>
                  <li><a class="waves-effect" href="../../Mural/web/index.html">Mural</a></li>
                  <li><a class="waves-effect" href="#!">Chat</a></li>
                  <li><a class="waves-effect" href="#!">Repositório de Fotos</a></li>
                  <li><a class="waves-effect" href="#!">Banco de Questões</a></li>
                  <li><a class="waves-effect" href="#!">Calendário</a></li>
                  <!--<li><div class="divider"></div></li>-->
                  <!--<li><a class="subheader">Subheader</a></li>-->
               </ul>
               <ul class="left ">
                  <li>
                     <button data-activates="slide-out" class="waves-effect waves-light btn-flat button-collapse white-text light-blue darken-4">Menu</button>
                  </li>
               </ul>
               <ul class="right ">
                  <!-- <li><button class="waves-effect waves-light btn-flat white-text light-blue darken-4">Entrar</button></li> -->
                  <li><a class="waves-effect waves-light btn modal-trigger white-text light-blue darken-3" href="#modal1">Entrar</a></li>
               </ul>
            </div>
         </nav>
         <!-- Modal de login -->
         <div id="modal1" class="modal modal-fixed-footer">
            <div class="modal-content">
               <h4>Login</h4>
               <div class="row">
                  <p>Insira dados</p>
                  <form>
                     <label for="username">Nome de usuario</label>
                     <input type="text" name="username">
                     <label for="senha">Senha</label>
                     <input type="password" name="senha">
                     <label for="tipoUsuario">Tipo de usuário</label>
                     <select name="tipoUsuario">
                        <option value="" disabled selected>Tipo de Usuario</option>
                        <option value="1">Aluno</option>
                        <option value="2">Professor</option>
                        <option value="3">Coordenador</option>
                        <option value="4">Diretor</option>
                     </select>
                     <button class="col s12 btn-flat waves-effect waves-light green white-text" type="submit" name="action">Entrar
                     <i class="material-icons right">input</i>
                     </button>
                  </form>
               </div>
            </div>
            <div class="modal-footer">
               <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat red white-text">Sair</a>
            </div>
         </div>
         <!-- ESPAÇO PARA MARQUEE -->
         <div>
         </div>
         <div class="section">
         <div class="section no-pad-bot" id="index-banner">
            <div class="container">
               <div class="row center">
                  <h5 class="header col s12 light">Prova Online</h5>
               </div>
            </div>
         </div>
         <div class="container">
         
            <form action="resultado.php" method="post" enctype="multipart/form-data">
            <div class="container" id="containerInput">
               
            </div>

            <div class="container">
            <br><br>
               <div class="row">
                  <div class="col s6">
                     <button href="resultado.php" class="hoverable blue darken-4 btn-large" type="submit"><i class="material-icons right">edit</i>Corrigir</button>
                  </div>
               </div>
            </div>
            </form>
         </div>
   </body>
</html>