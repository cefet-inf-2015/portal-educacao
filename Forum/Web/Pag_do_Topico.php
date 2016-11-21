<?php 
    session_start();
    if ( isset($_SESSION["usuario"]) ) {
      $userData = (array) $_SESSION["usuario"];
    }
?>

<!DOCTYPE html>
    <html>
        <head>
            <title>Portal Educação</title>
            <!--Meta-->
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
            <!-- CSS  -->
            <link href="CSS.css" rel="stylesheet">
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
            <link href="../../styles/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
            <link href="../../styles/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
            <link rel="icon" href="../../imgs/logo.png" >
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
        </head>

        <body onload="Perfil(0)">
            <?php 
                include('../../navbar.php');
            ?>
          
            <!-- Modal de login -->
            <?php 
                if(!isset($_SESSION['usuario'])) {
                    include('../../modal.php');
                }
            ?>
<!--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
			<div class="section no-pad-bot" id="index-banner">
		    	<div class="container">
		    	  	<br><br>
		    	  	<a href="Forum.php"><h1 class="header center blue-text text-darken-4">Fórum</h1></a>
		    	  	<div class="row center">
		    	  	  	<h5 class="header col s12 light">Fórum para discussões</h5>
		    	  	</div>
		    	  	<br><br>
		    	</div>
		  	</div>

			<!-- Página para Criação do Tópico! -->
			<div class="container">
				<div class="section">
					<div class="row">
						<div class="input-field col s6">
							<form action="envia.php" method="post" id="criaTopico">
                            <?php
                        
                             $categoriavet=  explode("/", $_SERVER['HTTP_REFERER']);
                            $categoria = explode(".", end($categoriavet));
                            $aux =current($categoria);
                            echo "<input type=\"hidden\" name=\"categoria\" value=\"$aux\">";

                            ?>
								<dl><class="titulo">
									<legend>Título: </legend>
									<input type="text" name="titulo" placeholder="Título do Tópico..." value=""/>
								</dl>

                                <input type="hidden" name="comentario" value="0">

								<legend>Campo de texto: </legend>
								<textarea id="campoTexto" form="criaTopico" name="pergunta"></textarea> 
								<div class="file-field input-field">
									<div class="blue darken-4 btn">
										<span><i class="material-icons right">publish</i>Upload</span>
										<input type="file">
									</div>
									<div class="file-path-wrapper">
										<input class="file-path validate" type="text">
									</div>
								</div>
								<div id="botao_enviar">
									<a class="waves-effect waves-light blue darken-4 btn"><i class="material-icons right">send</i><input type="submit" name="enviar"></a>
								</div>
							</form>
						</div>

						<div class="col s6">
                            <div class="col s12 m7">
                                <div class="card horizontal">
                                    <div class="card-image">
                                        <img src="Squirtle.png">
                                    </div>
                                    <div class="card-stacked">
                                        <div class="card-content">
                                            <div style="color: #1E90FF">Nome: </div><div id="Nome"></div>
                                            <div style="color: #1E90FF">Matrícula: </div><div id="Matricula"></div>
                                            <div style="color: #1E90FF">Posts: </div><div id="Posts"></div>
                                            <div id="Classificacao" style="color: blue"></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="collection">
                                    <a href="#!" class="collection-item"><h6>Novos Posts</h6></a>
                                    <a href="#!" class="collection-item"><div id="Topico1"></div></a>
                                    <a href="#!" class="collection-item"><div id="Topico2"></div></a>
                                    <a href="#!" class="collection-item"><div id="Topico3"></div></a>
                                    <a href="#!" class="collection-item"><div id="Topico4"></div></a>
                                </div>

                                <div class="collection">
                                    <a href="#!" class="collection-item"><h6>Estatísticas do Fórum</h6></a>
                                    <a href="#!" class="collection-item"><div id="PostsTotal"></div></a>
                                    <a href="#!" class="collection-item"><div id="TopicosTotal"></div></a>
                                </div>
                            </div>
                        </div>
					</div>
				</div>
			</div>
<!--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
			<?php 
              include('../../footer.php');
            ?>
            <!--  Scripts-->
            <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
            <script src="../../template/js/materialize.js"></script>
            <script src="../../template/js/init.js"></script>
            <script src="../../index.js"></script>
            <script type="text/javascript" src="Script.js"></script>
        </body>
    </html>




