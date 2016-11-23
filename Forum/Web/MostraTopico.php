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

        <body onload="Listener(1);">
            <?php 
              include('../../navbar.php');
            ?>
          
            <!-- Modal de login -->
           <?php 
             if(!isset($_SESSION['usuario'])) {
               include('../../modal.php');
             }
            ?>
<!--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
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
		  	<div>

				<?php
				/*
				$dbhost = 'cefet-inf-2015.ddns.net:43306'; // endereco do servidor de banco de dados
				$dbuser = 'root'; // login do banco de dados
				$dbpass = 'apenasinf-2015'; // senha
				*/

				$dbhost = 'localhost'; // endereco do servidor de banco de dados
				$dbuser = 'root'; // login do banco de dados

				$dbname = 'bdforum'; // nome do banco de dados a ser usado
				$categoria = $_POST["categoria"];
				$titulo = $_POST["tituloo"]; 
				$conecta = @mysql_connect($dbhost, $dbuser, $dbpass);
                $seleciona = @mysql_select_db($dbname);
                

				$idname = 0;
				$idmatricula = 0;
				$idposts = 0;
				$idclassificacao = 0;
				$idcomentario = 0;
				$idresponde = 0;
				$idlike = 0;

				echo "<h4 class=\"center-align\" id=\"titulo\"  >".$titulo."</h4>";
				
				$consulta = mysql_query("select * from $categoria where Titulo='$titulo' "); 

				

				while($conteudo=mysql_fetch_array($consulta)){
					$name = $conteudo['Autor'];
					$id = $conteudo['Id'];

					$likesql = "UPDATE matematica SET Avaliacao = Avaliacao + 1 WHERE Id = '$id'";
					//$like= mysql_query($likesql , $conecta);
					
					$busca = mysql_query("select * from usuarios where nome='$name' "); //informaçoes do autor
					while($infouser=mysql_fetch_array($busca)){
						$matricula= $infouser['Matricula'];
						$tipo = $infouser['Tipo'];
						$criados = $infouser['Criados'];
						if (is_file($infouser['Foto'])) {
							$foto =$infouser['Foto']; 
						}else{
							$foto = "foto.png";
						}
					}




					echo "<div class=\"container\">
					<div class=\"grid-example col s12 m6\">
						<div class=\"card-panel\">
							<div>
								<div class=\"row\">
									<div class=\"col s12 m9 l3\">
											<div class=\"card horizontal\">
			                                    <div class=\"card-image\">
			                                        <img src=\"".$foto."\">
			                                    </div>
			                                    <div class=\"card-stacked\">
			                                        <div class=\"card-content\">
			                                            <div style=\"color: #1E90FF\">Nome: </div><div id=\"Nome".$idname."\">".$conteudo['Autor']."</div>
			                                            <div style=\"color: #1E90FF\">Matrícula: </div><div id=\"Matricula".$idmatricula."\">".$matricula."</div>
			                                            <div style=\"color: #1E90FF\">Posts: </div><div id=\"Posts".$idposts."\">".$criados."</div>
			                                            <div id=\"Classificacao".$idclassificacao."\" style=\"color: blue\">".$tipo."</div>
			                                        </div>
			                                    </div>
			                                </div>
										</div>	
									<div class=\"row col s12 m8 l9\">
									<h5 class=\"col s12 light\">					
										<span id=\"Comentario".$idcomentario."\" class=\"flow-text\">".$conteudo['Conteudo']."
										</span>
										</h5>
									</div>							
								</div>
								<div class=\"row\">
									<div class=\"col s12 m6 l3\" id=\"divlike".$idlike."\">".$conteudo['Avaliacao']."
										<a class=\"btn-floating btn-large waves-effect waves-light blue\" id=\"like".$idlike."\" ><i class=\"material-icons\" >thumb_up</i></a>
									</div>
									<div align=\"right\" class=\"row col s12 m6 l9\">
										<a name=\"BotaoResponde\" id=\"BotaoResponde".$idresponde."\" href=\"#comentario\" class=\"waves-effect waves-light blue btn\">responder</a>       
									</div>	
								</div>
							</div>
						</div>
					</div>
				</div>
				";

				$idname++;
				$idmatricula++;
				$idposts++;
				$idclassificacao++;
				$idcomentario++;
				$idlike++;
				$idresponde++;

				}
				
				echo "<p id=\"categoria\" style=\"display: none\" >".$categoria."</p>";

				?>
	

			</div>

			<div>
				<form action="envia.php" method="post" id="criaComentario" name="envia">
					<input type="hidden" name="comentario" value="1">
					<input type="hidden" id="titu" name="titulo" value="teste">
					<input type="hidden" id="conteudo" name="pergunta">
					<input type="hidden" id="categ" name="categoria">
					

					<script type="text/javascript">
						
						function inserevalores() {
							
							document.getElementById("titu").value = document.getElementById("titulo").innerHTML;

							document.getElementById("categ").value = document.getElementById("categoria").innerHTML;

					
							

							document.getElementById("conteudo").value = "<div style=\"color: grey\">"+document.getElementById("ConteudoResposta").innerHTML+"</div>"+"<div>"+document.getElementById("campoTexto").value+"</div>";

							
							document.envia.submit();

						}
    				
					</script>


											<?php  
											
											if ( isset($_SESSION["usuario"]) ) {
      										
    										if (is_file("../../".$userData['foto'])) {
                                                $foto = "../../".$userData['foto'];
                                            }else{
                                                $foto = "foto.png";
                                            }										

											 $matricula= $userData['numeroMatricula'];

                                        	$busca = mysql_query("select * from usuarios where matricula='$matricula' "); //informaçoes do autor
                                        
                                        	while($infouser=mysql_fetch_array($busca)){
                                            
                                            	$tipo = $infouser['Tipo'];
                                            	$criados = $infouser['Criados'];
                                        	}

											echo "
					<div class=\"container\">
						<div class=\"grid-example col s12 m6\">
							<div class=\"card-panel\">
								<div id=\"comentario\">
									<div class=\"row\">
										<div class=\"col s12 m9 l3\">
											<div class=\"card horizontal\">
			                                    <div class=\"card-image\">
			                                        <img src=\"".$foto."\">
			                                    </div>
			                                    <div class=\"card-stacked\">
			                                        <div class=\"card-content\">
			                                            <div style=\"color: #1E90FF\">Nome: </div>".$userData['primeiroNome']."<div id=\"Nome\"></div>
			                                            <div style=\"color: #1E90FF\">Matrícula: </div>".$userData['numeroMatricula']."<div id=\"Matricula\"></div>
			                                            <div style=\"color: #1E90FF\">Posts: </div>".$criados."<div id=\"Posts\"></div>
			                                            <div id=\"Classificacao\" style=\"color: blue\">".$tipo."</div>
			                                        </div>
			                                    </div>
			                                </div>
										</div>
										<div class=\"row col s12 m8 l9 card-panel\">
											<div id=\"ConteudoResposta\">
											</div>
											<div >
												<textarea id=\"campoTexto\" form=\"criaComentario\"></textarea>
											</div>
										</div>						
									</div>
									<div class=\"row\">
										<div class=\"col s12 m6 l3\">
										</div>
										<div align=\"right\" class=\"row col s12 m6 l9\">
											<a class=\"waves-effect waves-light blue btn\"><input type=\"button\" value=\"Enviar\" onclick=\"inserevalores()\"></a>     
										</div>	
									</div>
								</div>
							</div>
						</div>
					</div>";
											}
											?>

				</form>
			</div>
<!--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
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