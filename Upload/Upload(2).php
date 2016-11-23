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
        <h1 class="header center blue-text text-darken-4">Upload</h1>
        <div class="row center">
          <h5 class="header col s12 light">Envie um arquivo com palavras-chave</h5>
        </div>
        <br><br>
      </div>
    </div>

    <main>
      <div class="container">
        <div class="section">
          <!-- CONTEÚDO AQUI -->
          <div class="row">
            <form enctype= "multipart/form-data" class="col s12" action="Upload(2).php" method="post">
              <div class="row">
                <div class="file-field input-field">
                  <div class="btn">
                    <span>Selecionar</span>
                    <input type="file" name="upload" id="upload">
                    <i class="material-icons left">perm_media</i>
                  </div>
                  <div class="file-path-wrapper">
                    <input class="file-path validate" type="text">
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input type="text" name = "palavrasChave" id="palavrasChave" class="materialize-textarea tooltipped" data-position="left" data-delay="50" data-tooltip="Palavras simples separadas por vírgula" placeholder="Exemplo: &quot;vídeo,matemática,etc&quot;"/>
                  <label for="palavrasChave">Palavras-chave</label>
                </div>
              </div>
              <div class="row center">
                <button class="btn-large waves-effect waves-light" type="submit" name="enviar">Enviar
                  <i class="material-icons right">send</i>
                </button>
              </div>
            </form>
            <div class="center">
              <h5 class="light-blue-text darken-4">
<?php
    date_default_timezone_set("America/Sao_Paulo");
    $UploadDirectory = 'dado/';
    $conexao = mysqli_connect('localhost', 'root', '123','bd_upload');
    if (isset($_FILES['upload'])) {
        $fileName = $_FILES['upload']['name'];
        if (!file_exists($UploadDirectory . $fileName)) {
            $tmpName = $_FILES['upload']['tmp_name'];
            $fileSize = $_FILES['upload']['size'];
            $fileType = $_FILES['upload']['type'];
            if (move_uploaded_file($_FILES['upload']["tmp_name"], $UploadDirectory . $fileName)) {
                if ($conexao) {
                    if (mysqli_query($conexao,"INSERT INTO arquivo(arquivo_char_nome,arquivo_char_tamanho,arquivo_char_extensao,arquivo_char_diretorio,arquivo_char_tag) VALUES ('$fileName','$fileSize', '$fileType','$UploadDirectory$fileName','$_POST[palavrasChave]')")) {
                        unset($_FILES['upload']);
                        //header('Location: Inicio.html');
                    }else{
            echo 'Erro no query';
                    }
                }else{
          echo 'Erro na conexão';
                }
            }else{
        echo 'Erro no upload do arquivo!';
      }
        }else{
            echo 'Erro, arquivo já existente';
        }
        unset($_FILES['upload']);
    } else {
        echo 'Nenhum arquivo selecionado';
          }
?>
              </h5>
            </div>
          </div>
        </div>
      </div>
    </main>
    <footer class="page-footer blue">
      <div class="container">
        <div class="row">
          <div class="col l6 s12">
            <h5 class="white-text">Desenvolvedores</h5>
            <p class="grey-text text-lighten-4">
              Somos a turma de Informática 2A do ano de 2016 do CEFET-MG (Centro Federal de Educação Tecnológica de Minas Gerais) desenvolvendo o trabalho final multidisciplinar de Linguagem de Programação 1 e Aplicações para WEB.
              <br><a class="white-text link" href="colaboradores.html">Clique aqui</a> para saber mais
            </p>
          </div>
          <div class="col l3 s12">
            <h5 class="white-text">Sobre a Instituição</h5>
            <p class="grey-text text-lighten-4">
              Centro Federal de Educação Tecnológica de Minas Gerais
              <br>Av. Amazonas 5253 - Nova Suiça - Belo Horizonte - MG - Brasil
              <br>Telefone: +55 (31) 3319-7000 - Fax: +55 (31) 3319-7001
            </p>
          </div>
          <div class="col l3 s12">
            <h5 class="white-text">Recursos</h5>
            <ul>
              <li><a class="white-text link" href="https://github.com/cefet-inf-2015/portal-educacao/" target="_blank">Github</a></li>
              <li><a class="white-text link" href="http://cefetmg.br/" target="_blank">CEFET-MG</a></li>
            </ul>
          </div>
        </div>
      </div>
      <div class="footer-copyright">
        <div class="container">
          Made by <a class="blue-text text-lighten-3" href="http://materializecss.com">Materialize</a>
        </div>
      </div>
    </footer>


    <!--  Scripts-->
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="../template/js/materialize.js"></script>
    <script src="../template/js/init.js"></script>
    <script src="../index.js"></script>
  </body>
</html>