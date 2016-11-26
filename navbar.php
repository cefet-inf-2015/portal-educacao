<nav class="light-blue darken-4" role="navigation">
  <div class="nav-wrapper container">
      <!-- MENU SLIDE OUT STRUCTURE-->
  <ul id="slide-out" class="side-nav">
    <br>
    <li>
      <div class="logo">
        <img class="background center-block responsive" src="imgs/logo.png">
      </div>
    </li>
    <br>
    <li><a class="waves-effect" href="./index.php">Página Inicial</a></li>
    <li><a class="waves-effect" href="./Mural/web/index.php">Mural</a></li>
    <li><a class="waves-effect" href="./rep-fotos/web/repositorio.php">Repositório de Fotos</a></li>
    <li><a class="waves-effect" href="./Upload/Inicio.php">Download/Upload Aplicativos</a></li>
    
    <?php
      if(isset($_SESSION['usuario']) ) {
        $data = (array) $_SESSION['usuario'];
        switch( $data['permissao']) {
          case 3:
          case 2:
          case 1:
            echo '<li><a class="waves-effect" href="./provas-e-trabs/web/pagInicial.php">Modelo de Provas/Trabalhos</a></li>
            <li><a class="waves-effect" href="./Correcao/Web/ProvaOffline.php">Correção Provas e Trabalhos</a></li>';
          case 0:
            echo '<li><a class="waves-effect" href="./Calendario/index.php">Calendário</a></li>
            <li><a class="waves-effect" href="./Chat/index.html">Chat</a></li>
            <li><a class="waves-effect" href="./Forum/Web/Forum.php">Fórum</a></li>
            <li><a class="waves-effect" href="./banco-questoes/web/BancoDeQuestoes.php">Banco de Questões</a></li>';
            break;
        }
      }
    ?>
  </ul>
    <ul class="left ">
      <li>
        <button data-activates="slide-out" class="waves-effect waves-light btn-flat button-collapse white-text light-blue darken-4">Menu</button>
      </li>
    </ul>
    <ul class="right ">
      <?php 
        if(!isset($_SESSION['usuario'])) {
          echo '<li><a class="waves-effect waves-light btn modal-trigger white-text light-blue darken-3" href="#modal1">Entrar</a></li>';
        }
        else {
          $userData = (array) $_SESSION["usuario"];
          echo '<li>Bem vindo(a), '. $userData["primeiroNome"]. '</li>';
          echo '<li><a class="waves-effect waves-light btn white-text light-red darken-3" id="logOutBtn">Sair</a></li>'; 
          echo '<div id="msgSaiu"></div>';
        }
      ?>
    </ul>
  </div>
</nav>

<!-- ESPAÇO PARA MARQUEE-->
<div id="marquee">
    <div><span>Portal Educação</span></div>
</div>