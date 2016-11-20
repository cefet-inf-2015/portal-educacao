<?php 
  if (!isset($_SESSION['usuario'])) {
    header('Location: ../../index.php');
  }
?>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>Portal Educação</title>


    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="../../styles/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="../../styles/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="../../styles/css/layoutmural.css" type="text/css" rel="stylesheet" media="screen,projection"/>
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
      include('../../navbar.php');
    ?>

  <!-- Modal de login -->
  <?php 
    if(!isset($_SESSION['usuario'])) {
      include('../../modal.php');
    }
  ?>

  <!-- ESPAÇO PARA MARQUEE-->
  <div id="marquee">
      <div><span>Portal Educação</span></div>
  </div>

  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br><br>
      <h1 class="header center blue-text text-darken-4">Mural</h1>
      <div class="row center">
        <h5 class="header col s12 light">Mural de postagens</h5>
      </div>
      <br><br>

    </div>
  </div>


  <div class="container">
    <div class="section">

 <!-- CONTEUDO AQUI --> 
   <div class="container">
     <div class="section" id="posts">
       <!-- Postar -->
       <div class="col s1 m8 offset-m2 l6 offset-l3" >
         <div class="card-panel grey lighten-5 z-depth-1">
          <form>
           <div class="row valign-wrapper">
             <div class="col s6 m4 l2">
               <img src="https://yt3.ggpht.com/-ZtBlVYCvXOg/AAAAAAAAAAI/AAAAAAAAAAA/-5eDEfuCFlA/s900-c-k-no-rj-c0xffffff/photo.jpg" alt="" class="square responsive-img" id="perfil">
             </div>
             <div class="col s10">
               <textarea id="post" name="post" placeholder="Poste algo aqui!" class="materialize-textarea"></textarea>
             </div>
           </div>
           <div class="row valign-wrapper">
             <div class="col s10">
               <div class="file-field input-field">
                 <div class="btn waves-effect waves-light light-blue darken-4 left">
                   <span class="medium material-icons white-text text-darken-1">attach_file</span>
                     <input type="file" id="arq" name="arq">
                  </div>
                  <div class="file-path-wrapper">
                    <input class="file-path validate" placeholder="Selecione um arquivo" readonly type="text" id="file_path">
                  </div>
               </div>
             </div>
             <div class="col s4 m3 l2">
               <a onclick="sendBD()" class = "waves-effect waves-light btn light-blue darken-4 right" id="btnPost" name="upload">Publicar</a>
             </div>
           </div>
          </form>
         </div>
       </div>
     </div>  

       <!--Postagens --> 
       <div class="col s12 m8 offset-m2 l6 offset-l3">
         <div class="card-panel grey lighten-5 z-depth-1">
           <div class="row valign-wrapper">
             <div class="col s6 m2 l2">
               <img src="https://scontent.fplu3-1.fna.fbcdn.net/v/t1.0-1/p160x160/13439037_1193975307319450_2334157368209366229_n.jpg?oh=62c70b5f87040b2480bded086e0b8e53&oe=58607AFD" alt="" class="square responsive-img">
             </div> 
             <div class="col s11">
               <a class="blue-text text-lighten-1" id="nameProf">PERFIL EXEMPLO</a><br>
               <p class="grey-text text-lighten-1 hora"> 19h</p>
             </div>          
           </div>
           <div class="row">
             <div class="col s12">
               <p class="black-text center">TEXTO EXEMPLO DA POSTAGEM</p><br><br>
               <img class="center-block materialboxed square responsive-img" src="https://scontent.fplu3-1.fna.fbcdn.net/v/t1.0-0/q84/s526x395/14494637_1761260080798489_4491825794709950861_n.jpg?oh=b7226ef563bb52abb997c29959265643&oe=585F61BF" alt=""><br><br>
                 
             </div>
             <div class="col s6">
               <a class="waves-effect waves-light btn grey lighten-1" id="like">
               <i class="medium material-icons white-text text-darken-3" id="like">thumb_up</i>
               </a>               
             </div>
           </div>            
         </div>
       </div>    
     </div>
   </div>
 </div>
 </div>


  <?php 
      include('../../footer.php');
  ?>


  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="../../template/js/materialize.js"></script>
  <script src="../../template/js/init.js"></script>
  <script src="../../index.js"></script>
  <script src="../../scripts/mural.js"></script>

  </body>
</html>