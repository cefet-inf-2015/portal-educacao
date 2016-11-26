<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
      <title>Portal Educação</title>
      <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script src="../../template/js/materialize.js"></script>
      <script src="../../template/js/init.js"></script>
      <script src="script.js"></script>
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
      <?php 
        echo "<!--NAVBAR-->" ;
        include('../../navbar.php');
       if(!isset($_SESSION['usuario'])) {
         echo "<!--MODAL-->" ;
         include('../../modal.php');
       }
      ?>
      <!-- ESPAÇO PARA MARQUEE -->
      <div>
      </div>
      <div class="section">
         <div class="section no-pad-bot" id="index-banner">
            <div class="container">
               <div class="row center">
                  <h5 class="header col s12 light">Formulário de Informações</h5>
               </div>
            </div>
         </div>
         <div class="container">
            <form action="partPHP.php" method="POST" enctype="multipart/form-data">
               <div class="container">
                  <label>Quantidade de Alunos:</label><br>
                  <input type="radio" id="individual" value="individual" onclick="exibeCampoEspecifico('individual')" name="quantAlunos"/>
                  <label for="individual">Individual</label>&emsp;
                  <input type="radio" id="turma" name="quantAlunos"/>
                  <label for="turma">Turma</label>&emsp;
                  <input type="radio" id="grupo" name="quantAlunos"/>
                  <label for="grupo">Grupo</label>
               </div>
               <div class="disable" id="divindividual">
                  <div class="container">
                     <label for="matricula">Matrícula</label>
                     <input type="text" name="matricula" id="matricula">
                  </div>
               </div>
               <div class="container">
                  <label>Tipo:</label><br>
                  <input type="radio" id="prova" name="tipo"  value="prova" onclick="exibeCampoEspecifico('prova')" />
                  <label for="prova">Prova</label>&emsp;
                  <input type="radio" id="trabalho" name="tipo" value="trabalho" onclick="exibeCampoEspecifico('trabalho')" />
                  <label for="trabalho"> Trabalho</label>
               </div>
               <div class="container">
                  <label for="valor">  Valor</label><br>
                  <input type="number" name="valor" id="valor" min="0"
                     style="width: 50px; height: 20px"> pts
               </div>
               <div class="container">
                  <label id="TituloP"> Titulo </label>
                  <input type="text" name="Titulo" id="Titulo"/>
               </div>
               <div class="container">
                  <label for="Nquestao" id="letraquestoes"> Nº Questões </label>
                  <input type="number" name="nquestao" id="valor" min="0"
                     style="width: 50px; height: 20px">
               </div>
               <div class="container">
                  <label>Turno: </label>  
                  <div class="input-field col s12">
                     <select name="turno" id='turno' class="browser-default" style="width: 100px; height: 35px">
                        <option value="manha">Manhã</option>
                        <option value="tarde">Tarde</option>
                        <option value="Noite">Noite</option>
                     </select>
                  </div>
               </div>
               <div class="container">
                  <label for="turmas"> Turmas: </label>
                  <input type="text" name="turmas" id="turmas"/>
               </div>
               <div class="container">
                  <label for="prof"> Elaborador: </label>
                  <input type="text" name="prof" id="prof"/>
               </div>
               <div class="container">
                  <label for="instituicao">Instituição: </label>
                  <input type="text" name= "instituicao" id="instituicao"/>
                  <label>Tipo de Instituição</label>
               </div>
               <div class="container">
                  <input type="radio" id="Privada" name="tiopoInsti" value="privada" onclick="exibe('Privada')" />
                  <label for="Privada">Privada</label>&emsp;
                  <input type="radio" id="Publica" name="tiopoInsti" value="publica" onclick="exibe('Publica')" />
                  <label for="Publica">Publica</label>
               </div>
               <div class="container">
                  <label for="foto">Foto</label>
                  <input type="file" name="foto">
               </div>
               <br><br>
               <div class="disable" id="divBotao1">
                  <div class="container">
                     <label for='logo'>Logo</label>
                     <input type="file" name="logo" id="logo"/>
                  </div>
               </div>
               <div class="disable" id="divBotao2">
                  <div class="container">
                     <label for="brasao">Brasao</label>
                     <input type="file" name="brasao"  id="brasao">
                  </div>
               </div>
               <!--Formulário de Prova-->
               <div class="disable" id="divProva">
                  <div class="container">
                     <label for="duração" id="letraduracao"> Duração </label>
                     <input type="number" name="duracao" id="duracao" min="0" style="width: 50px; height: 20px" > min.
                  </div>
                  <div class="container">
                     <label for="data" id="letradata"> Data: </label> 
                     <input type="date" name="data" id="data"/>
                  </div>
               </div>
               <!--Formulário para Trabalho-->
               <div class="disable" id="divTrabalho">
                  <div class="container">
                     <label for="dataEntrega">Data de Entrega:</label>
                     <input type="date" name="dataEntrega" id="dataEntrega"/>
                  </div>
                  <div class="container">
                     <label for="dataRecebimento">Data de Recebimento: </label>
                     <input type="date" name="dataRecebimento" id="dataRecebimento"/>
                  </div>
               </div>
               <br><br>
               <button type="submit" class="waves-effect waves-light blue darken-4 btn"><i class="material-icons left">send</i>Enviar</button>
         </div>
      </div>
      </form>
      </div>
      </div>
      </main>
      <?php 
        include('../../footer.php');
      ?>
      <!--  Scripts-->
      <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script src="../../template/js/materialize.js"></script>
      <script src="../../template/js/init.js"></script>
      <script src="../../index.js"></script>
   </body>
</html>