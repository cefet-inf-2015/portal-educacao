<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>Portal Educação</title>


    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="../styles/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="../styles/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
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
        <h1 class="header center blue-text text-darken-4">Download</h1>
        <div class="row center">
          <h5 class="header col s12 light">Arquivos Com As Tags Especificadas</h5>
        </div>
        <br><br>
      </div>
    </div>

    <main>
      <div class="container">
        <div class="section">
          <!-- CONTEÚDO AQUI -->
          <div>
            <form enctype= "multipart/form-data" class="col s12" action="Download.php" method="post">
              <div class="row center">
                <div class="input-field col s10">
                  <input type="text" name = "palavrasChave" id="palavrasChave" class="materialize-textarea tooltipped" data-position="left" data-delay="50" data-tooltip="Palavras simples separadas por vírgula" placeholder="Exemplo: &quot;vídeo,matemática,etc&quot;"/>
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
<?php
            date_default_timezone_set("America/Sao_Paulo");
            $conexao = mysqli_connect('localhost','root','123','bd_upload');
            $result = mysqli_query($conexao,"SELECT * FROM arquivo WHERE arquivo_int_status=1");
			$numCard = 0;   //Se houverem 4 cards pula uma linha
			if(@$_POST['palavrasChave']!=""){
            $tags = explode(',', $_POST['palavrasChave']);
                while ($arrArq = mysqli_fetch_assoc($result)) {
                    $enc = false;
                    $tagsArq = explode(',', $arrArq["arquivo_char_tag"]);
                    foreach ($tags as $t) {
                        foreach ($tagsArq as $tA) {
                            if ($t == $tA) {
                                $enc = true;
                                $numCard++;
                                 echo '<div class="card sticky-action col s3">
                            <div class="card-image waves-effect waves-block waves-light">
                              <img class="activator" src="icon.png">
                            </div>
                            <div class="card-content">
                              <span class="card-title activator grey-text text-darken-4 truncate">' . $arrArq['arquivo_char_nome'] . '<i class="material-icons right">more_vert</i></span>
                              <a class="col btn-large s12" href="' . $arrArq['arquivo_char_diretorio'] . '" download>BAIXAR</a>
                            </div>
                            <div class="card-reveal">
                              <span class="card-title grey-text text-darken-4">' . $arrArq['arquivo_char_nome'] . '<i class="material-icons right">close</i></span>
                              <p> Tags: ' . $arrArq['arquivo_char_tag'] . '</p>
                            </div>
                          </div>
						  <div class="container">';
                                break;
                            }
                        }
                        if ($numCard == 4) {
                            echo '</div>
                    <div class="row">';
                        }
                        if ($enc) {
                            break;
                        }
                    }
                }
				echo '</div>';
            } else{
                while ($arrArq = mysqli_fetch_assoc($result)) {
                    $numCard++;
                      echo '<div class="card sticky-action col s3">
                            <div class="card-image waves-effect waves-block waves-light">
                              <img class="activator" src="icon.png">
                            </div>
                            <div class="card-content">
                              <span class="card-title activator grey-text text-darken-4 truncate">' . $arrArq['arquivo_char_nome'] . '<i class="material-icons right">more_vert</i></span>
                              <a class="col btn-large s12" href="' . $arrArq['arquivo_char_diretorio'] . '" download>BAIXAR</a>
                            </div>
                            <div class="card-reveal">
                              <span class="card-title grey-text text-darken-4">' . $arrArq['arquivo_char_nome'] . '<i class="material-icons right">close</i></span>
                              <p> Tags: ' . $arrArq['arquivo_char_tag'] . '</p>
                            </div>
                          </div>';
                    if ($numCard == 4) {
                        echo '</div>
						<div class="row">';
                    }
                }
				echo '</div>';
            }
            ?>
        </div>
      </div>
    </main>
    <!--  Footer-->
    <?php 
      include('../footer.php');
    ?>

    <!--  Scripts-->
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="../template/js/materialize.js"></script>
    <script src="../template/js/init.js"></script>
    <script src="../index.js"></script>

  </body>
</html>