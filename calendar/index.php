<?php  
   if (!isset($_SESSION['usuario'])) { 
     header('Location: ../index.php'); 
   } 
?> 
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <title>Calendário de Atividades</title>
    <!--Faz a Linkagem com o conteúdo CSS necessário-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/materialize.css"  media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="css/frontend.css">
    <!--Faz a Linkagem com o conteúdo JS necessário-->
    <script type="text/javascript" src="js/backend.js"></script>
    <script type="text/javascript" src="js/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="js/jquery.maskedinput.js"></script>
    <script type="text/javascript" src="js/materialize.js"></script>
    <link rel="icon" href="../../imgs/logo.png" >
  </head>

  <body onload="carrega(new Date())">
    <!-- AQUI FICA A NAVBAR -->
    <?php 
      include('../navbar.php');
    ?>
  	<!--Título da página-->
  	<div class="card-panel blue darken-3 titulo"><center>Calendário de Atividades</center></div>
  	<!--Captação da data-->
  	<div class="row center">     
      <div class="input-field" style="display: inline-block; width: 57px; margin-right: 1%">
    		<input placeholder="Data" id="data" type="text" class="validate" style="text-align: center;">
    		<script> //Máscara da data
  				jQuery(function($){
         		$("#data").mask("99/9999");
  				});
  			</script>
    	</div>
      <button  id="ok" type="button" class="waves-effect waves-light btn blue" onclick="dataShow()">OK</button>
      <div id="mensagem" style="display: none"> *Data Inválida </div>   
    </div>
  	
  	<!--Calendário-->
    <div class="centro">
      <div class="blue darken-3 titulo" style="font-size:25px;"><center>
        <div id="mes"></div>
      </center></div>
      <div class="flex-container"> 
        <div class="coluna">
          <div class="semana">Domingo</div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(1)"><div id="1"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(8)"><div id="8"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(15)"><div id="15"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(22)"><div id="22"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(29)"><div id="29"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(36)"><div id="36"></div></div>
        </div>
        <div class="coluna">
          <div class="semana">Segunda</div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(2)"><div id="2"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(9)"><div id="9"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(16)"><div id="16"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(23)"><div id="23"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(30)"><div id="30"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(37)"><div id="37"></div></div>
        </div> 
        <div class="coluna">
          <div class="semana">Terça</div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(3)"><div id="3"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(10)"><div id="10"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(17)"><div id="17"></div></div> 
          <div class="dia modal-trigger" href="#modal" onclick="preenche(24)"><div id="24"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(31)"><div id="31"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(38)"><div id="38"></div></div>
        </div> 
        <div class="coluna">
          <div class="semana">Quarta</div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(4)"><div id="4"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(11)"><div id="11"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(18)"><div id="18"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(25)"><div id="25"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(32)"><div id="32"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(39)"><div id="39"></div></div>
        </div> 
        <div class="coluna">
          <div class="semana">Quinta</div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(5)"><div id="5"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(12)"><div id="12"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(19)"><div id="19"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(26)"><div id="26"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(33)"><div id="33"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(40)"><div id="40"></div></div> 
        </div> 
        <div class="coluna">
          <div class="semana">Sexta</div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(6)"><div id="6"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(13)"><div id="13"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(20)"><div id="20"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(27)"><div id="27"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(34)"><div id="34"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(41)"><div id="41"></div></div>
        </div> 
        <div class="coluna">
          <div class="semana">Sábado</div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(7)"><div id="7"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(14)"><div id="14"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(21)"><div id="21"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(28)"><div id="28"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(35)"><div id="35"></div></div>
          <div class="dia modal-trigger" href="#modal" onclick="preenche(42)"><div id="42"></div></div> 
        </div>
      </div>  
    </div>

    <!--Botões da página-->
    <div class="centro botao" style="padding-top: 1%;">
      <button type="button" class="waves-effect waves-light btn blue" onclick="mostra('formInserir','formFiltrar','inserir')">Inserir Atividade</button>
      <button type="button" class="waves-effect waves-light btn blue" onclick="mostra('formFiltrar','formInserir','filtrar')">Filtrar Atividades</button>
    </div>
    <!--Fomulários correspondente a Inserir Atividade-->
    <div class="row centro" style="display: none; justify-content: center;" id="formInserir">
      <form class="col" action="php/insere.php" method="POST" onsubmit="validar(this); return false;">
        <div class="row">
          <div class="input-field col" style="width: 500px">
            <input id="atividade" name="atividade" type="text" class="validate">
            <label for="atividade">Atividade</label>  
          </div>
          <div class="input-field col" style="width: 105px">
            <input placeholder="AA/MM/DD" id="dataForm" name="dataForm" type="text" class="validate">
            <label for="dataForm">Data</label>
            <script> //Máscara da data
              jQuery(function($){
                $("#dataForm").mask("9999/99/99");
              });
            </script>
          </div>
          <div class="input-field col" style="width: 85px">
            <input  placeholder="Opcional" id="hora" name="hora" type="text" class="validate">
            <label for="hora">Hora</label>
            <script> //Máscara da hora
              jQuery(function($){
                $("#hora").mask("99:99:99");
              });
            </script>
          </div>
        </div>
        <div class="row">
          <div class="input-field col" style="width: 690px">
            <input placeholder="Opcional" id="descricao" name="descricao" type="text" class="validate">
            <label for="descricao"> Descrição</label>    
          </div>
        </div>
        <div class="row">
          <div class="input-field col">
            <input id="materia" name="materia" type="text" class="validate">
            <label for="materia"> Matéria</label>    
          </div>
          <div class="col">
            <input type="checkbox" id="enviarMural" name="enviarMural"/>
            <label for="enviarMural">Enviar para o Mural</label>
          </div>
          <div class="col">
            <input type="checkbox" id="enviarEmail" name="enviarEmail"/>
            <label for="enviarEmail">Enviar para o Email</label>
          </div>
        </div>
        <div class="botao">  
          <button id="inserir" type="submit" class="waves-effect waves-light btn blue">Inserir</button>
        </div>
        <div id="mensagem2" style="display: none; text-align: center" > *Inserção inválida! </div>
      </form> 
    </div>
    <!--Fomulários correspondente a Filtrar Atividade-->
    <div class="row centro" style="display: none; justify-content: center;" id="formFiltrar">
      <form class="col">
        <div class="row">
          <div class="input-field col" style="width: 450px">
            <input id="fAtividade" type="text" class="validate" placeholder="Opcional">
            <label for="fAtividade">Atividade</label>  
          </div>
          <div class="input-field col">
            <input id="fMateria" type="text" class="validate">
            <label for="fMateria">Matéria</label>
          </div>  
        </div>
        <div class="botao">
          <button type="button" id="filtrar" class="waves-effect waves-light btn blue" onclick="filtro()">Filtrar</button>
        </div>
        <div id="fMensagem" style="display: none; text-align: center" > *Nenhum parâmetro foi passado! </div>
      </form>
    </div>
    <!-- Modal que exibe as atividades completas -->
    <div id="modal" class="modal">
      <div class="modal-content">
        <h4><center>Atividades<center></h4>
        <div id="mAtividades"></div>
      </div>
    </div>

    <!-- AQUI FICA O FOOTER -->
    <?php 
      include('../footer.php');
    ?>
    <!-- Habilita o funcionamento do Model -->
    <script >
      $(document).ready(function(){
        $('.modal-trigger').leanModal();
      });
    </script>
  </body>
</html>