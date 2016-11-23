<?php session_start() ?>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Portal Educação</title>
  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="styles/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="styles/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link rel="icon" href="imgs/logo.png" >
</head>
<body>
  <?php 
    include('navbar.php');
  ?>
  <!-- MODAL -->
  <?php 
    if(!isset($_SESSION['usuario'])) {
      include('modal.php');
    }
   ?>
  <!-- ESPAÇO PARA MARQUEE -->
  <div>
    
  </div>

  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br><br>
      <h1 class="header center blue-text text-darken-4">Colaboradores</h1>
      <div class="row center">
        <h5 class="header col s12 light">Pessoas que tornaram esse projeto viável</h5>
      </div>
      <br><br>

    </div>
  </div>

  <div class="container">
    <div class="section">
      <!-- CONTEÚDO AQUI -->
      <div class="container">
      <div class="row">
        <div class="col l4 s12">
          <h5>Professores</h5>
          <p class="grey-text">
            José Wilson<br>
            William Sallum<br>
          </p>
          <h5>Gerência</h5>
          <p class="grey-text">
            Adalberto Barbosa<br>
            João Pedro Rosa<br>
            Paula Ribeiro<br>
            Vitor Rodarte<br>
          </p>
        </div>
        <div class="col l4 s12">
          <h5>Modelo de Provas/Trabalhos</h5>
          <p class="grey-text">
            Victor César<br>
            Gabriel Victor<br>
            Isabela Carolina<br>
            João Pedro dos Santos<br>
          </p>
          <h5>Fórum</h5>
          <p class="grey-text">
            Victor Gabriel<br>
            Luana Pinheiro<br>
            Matheus Morato<br>
            Rafael Gontijo<br>
          </p>
          <h5>Download/Upload Aplicativos</h5>
          <p class="grey-text">
            Pedro Octávio<br>
            André Mateus<br>
            Bruno Ferreira<br>
          </p>
          <h5>Correção Provas e Trabalhos</h5>
          <p class="grey-text">
            Luiz Augusto<br>
            Felipe Linhares<br>
            Lucas Henrique<br>
          </p>
          <h5>Mural</h5>
          <p class="grey-text">
            Gabriel Haddad<br>
            Breno Mariz<br>
            Bryann Bueno<br>
          </p>
          <h5>Chat</h5>
          <p class="grey-text">
            Carlos Eduardo<br>
            Ana Luísa Menezes<br>
            Ester Atman<br>
          </p>
          <h5>Repositório de Fotos</h5>
          <p class="grey-text">
            Marcelo Augusto<br>
            Maria Carolina Resende<br>
            Thales Alan Araújo<br>
            Gabriel Garcia<br>
          </p>
          <h5>Banco de Questões</h5>
          <p class="grey-text">
            João Vitor de Carvalho<br>
            Breno Paiva<br>
            Thales Gabriel Nunes<br>
            Alice Costa<br>
          </p>
          <h5>Calendário</h5>
          <p class="grey-text">
            Pedro Henrique Almeida<br>
            Gabriel Vinícius<br>
            Amaury Vianna<br>
          </p>
        </div>
        <div class="col l3 s12">
          <h5>Patrocinadores</h5>
          <p class="grey-text">
            Pai do Thales Nunes
          </p>
        </div>
      </div>
    </div>

    </div>
  </div>

  <!-- AQUI FICA O FOOTER -->
  <?php 
    include('footer.php');
  ?>


  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="template/js/materialize.js"></script>
  <script src="template/js/init.js"></script>
  <script type="text/javascript" src="index.js"></script>

  </body>
</html>