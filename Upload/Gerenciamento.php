<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>Portal Educação</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="styles/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="styles/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="../styles/css/layoutmural.css" type="text/css" rel="stylesheet" media="screen,projection">
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
    <link rel="icon" href="../imgs/logo.png" >
  </head>
  
  <body>
    <?php 
      include('../navbar.php');
    ?>

     <!-- Modal de login -->
    <?php 
      if(!isset($_SESSION['usuario'])) {
        include('../modal.php');
      }
     ?>

    <div class="section no-pad-bot" id="index-banner">
      <div class="container">
        <br><br>
        <h1 class="header center blue-text text-darken-4">Gerenciar</h1>
        <div class="row center">
          <h5 class="header col s12 light">Encontre arquivos com alguma palavra-chave</h5>
        </div>
        <br><br>
      </div>
    </div>

    <main>
      <div class="container">
        <div class="section">
          <!-- CONTEÃšDO AQUI -->
          <div>
            <form enctype= "multipart/form-data" class="col s12" action="Admin.php" method="post">
              <div class="row center">
                <div class="input-field col s10">
                  <input type="text" name = "palavrasChave" id="palavrasChave" class="materialize-textarea tooltipped" data-position="left" data-delay="50" data-tooltip="Palavras simples separadas por vírgula" placeholder="Faça uma pesquisa vazia para listar todos os arquivos"/>
                  <label for="palavrasChave">Palavras-chave</label>
                </div>
                <div class="right-align">
                  <button class="btn-large waves-effect waves-light" type="submit" name="enviar">Procurar
                    <i class="material-icons right">search</i>
                  </button>
                </div>
              </div>
            </form>
          </div>
        </div>
        <div class="row divider"></div>
        <div class="row">
        </div>
      </div>
    </main>
    <?php 
      include('../footer.php');
    ?>

    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="../template/js/materialize.js"></script>
    <script src="../template/js/init.js"></script>
    <script src="../index.js"></script>
  </body>
</html>