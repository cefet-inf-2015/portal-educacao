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

        <body onload="Listener(1); Perfil(1)">
            <nav class="light-blue darken-4" role="navigation">
                <div class="nav-wrapper container">

                    <ul id="slide-out" class="side-nav">
                        <br>
                        <li>
                            <div class="logo">
                                <img class="background center-block responsive" src="../../imgs/logo.png">
                            </div>
                        </li>
                        <br>

                        <li><a class="waves-effect" href="../../index.html">Página Inicial</a></li>
                        <li><a class="waves-effect" href="#!">Modelo de Provas/Trabalhos</a></li>
                        <li><a class="waves-effect" href="Fórum.html">Fórum</a></li>
                        <li><a class="waves-effect" href="../../Upload/index.html">Download/Upload Aplicativos</a></li>
                        <li><a class="waves-effect" href="../../Correcao/LayoutCorrecaoProvas.html">Correção Provas e Trabalhos</a></li>
                        <li><a class="waves-effect" href="../../Mural/web/index.html">Mural</a></li>
                        <li><a class="waves-effect" href="#!">Chat</a></li>
                        <li><a class="waves-effect" href="#!">Repositório de Fotos</a></li>
                        <li><a class="waves-effect" href="#!">Banco de Questões</a></li>
                        <li><a class="waves-effect" href="#!">Calendário</a></li>
                    </ul>

                    <ul class="left ">
                        <li>
                            <button data-activates="slide-out" class="waves-effect waves-light btn-flat button-collapse white-text light-blue darken-4">Menu</button>
                        </li>
                    </ul>

                    <ul class="right ">
                        <li><a class="waves-effect waves-light btn modal-trigger white-text light-blue darken-3" href="#modal1">Entrar</a></li>
                    </ul>

                </div>
            </nav>
          
            <!-- Modal de login -->
            <div id="modal1" class="modal modal-fixed-footer">
                <div class="modal-content">
                    <h4>Login</h4>
                    <div class="row">
                        <p>Insira dados</p>
                        <form>
                            <label for="username">Nome de usuario</label>
                            <input type="text" name="username">
                            <label for="senha">Senha</label>
                            <input type="password" name="senha">
                            <label for="tipoUsuario">Tipo de usuário</label>
                            <select name="tipoUsuario">
                                <option value="" disabled selected>Tipo de Usuario</option>
                                <option value="1">Aluno</option>
                                <option value="2">Professor</option>
                                <option value="3">Coordenador</option>
                                <option value="4">Diretor</option>
                            </select>
                            <button class="col s12 btn-flat waves-effect waves-light green white-text" type="submit" name="action">Entrar
                                <i class="material-icons right">input</i>
                            </button>
                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                    <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat red white-text">Sair</a>
                </div>
            </div>

            <!-- ESPAÇO PARA MARQUEE -->
            <div>
            
            </div>
<!--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
			<div class="section no-pad-bot" id="index-banner">
			    <div class="container">
				    <br><br>
				    <a href="Fórum.html"><h1 class="header center blue-text text-darken-4">Fórum</h1></a>
				    <div class="row center">
				    	<h5 class="header col s12 light">Fórum para discussões</h5>
				    </div>
				    <br><br>
			    </div>
		  	</div>
		  	<div>

				<?php
				$dbhost = 'cefet-inf-2015.ddns.net:43306'; // endereco do servidor de banco de dados
				$dbuser = 'root'; // login do banco de dados
				$dbpass = 'apenasinf-2015'; // senha
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

				echo "<h4 class=\"center-align\" id=\"titulo\"  >".$titulo."</h4>";
				
				$consulta = mysql_query("select * from $categoria where Titulo='$titulo' "); 

				

				while($conteudo=mysql_fetch_array($consulta)){
					$name = $conteudo['Autor'];

					$busca = mysql_query("select * from usuario where nome='$name' "); //informaçoes do autor
					while($infouser=mysql_fetch_array($busca)){
						$matricula= $infouser['matricula'];
						$tipo = $infouser['tipo'];
						$criados = $infouser['criados'];
					}




					echo "<div class=\"container\">
					<div class=\"grid-example col s12 m6\">
						<div class=\"card-panel\">
							<div>
								<div class=\"row\">
									<div class=\"col s12 m9 l3\">
											<div class=\"card horizontal\">
			                                    <div class=\"card-image\">
			                                        <img src=\"Squirtle.png\">
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
									<div class=\"col s12 m6 l3\">
										<a class=\"btn-floating btn-large waves-effect waves-light blue\"><i class=\"material-icons\">thumb_up</i></a>
									</div>
									<div align=\"right\" class=\"row col s12 m6 l9\">
										<a name=\"BotaoResponde\" id=\"BotaoResponde".$idresponde."\" href=\"#comentario\" class=\"waves-effect waves-light blue btn\">responder</a>       
									</div>	
								</div>
							</div>
						</div>
					</div>
				</div>";

				$idname++;
				$idmatricula++;
				$idposts++;
				$idclassificacao++;
				$idcomentario++;
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

							document.getElementById("conteudo").value = "<div style=\"color: grey\"> "+document.getElementById("ConteudoResposta").innerHTML +" </div><br>"+document.getElementById("campoTexto").value ;

							
							document.envia.submit();

						}
    				
					</script>
					<div class="container">
						<div class="grid-example col s12 m6">
							<div class="card-panel">
								<div id="comentario">
									<div class="row">
										<div class="col s12 m9 l3">
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
										</div>
										<div class="row col s12 m8 l9 card-panel">
											<div id="ConteudoResposta">
											</div>
											<div >
												<textarea id="campoTexto" form="criaComentario"></textarea>
											</div>
										</div>						
									</div>
									<div class="row">
										<div class="col s12 m6 l3">
										</div>
										<div align="right" class="row col s12 m6 l9">
											<a class="waves-effect waves-light blue btn"><input type="button" value="Enviar" onclick="inserevalores()"></a>     
										</div>	
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
<!--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
	<footer class="page-footer blue">
                <div class="container">
                    <div class="row">
                        <div class="col l6 s12">
                            <h5 class="white-text">Desenvolvedores</h5>
                            <p class="grey-text text-lighten-4">
                              Somos a turma de Informática 2A do ano de 2016 do CEFET-MG (Centro Federal de Educação Tecnológica de Minas Gerais) desenvolvendo o trabalho final      multidisciplinar     de Linguagem de Programação 1 e Aplicações para WEB.           
                              <br><a class="white-text link" href="colaboradores.h    tml">Clique aqui</a>    para saber mais        
                            </p>      
                        </div>

                        <div c      lass="col l3 s12">      
                            <h5       class="white-text">Sobre a Instituição</h5>     
                            <p c      lass="grey-text text-lighten-4">    
                              Ce      ntro Federal de Educação Tecnoló    gica de Minas Gerais      
                              <b      r>Av. Amazonas 5253 - Nova Suiça     - Belo Horizonte - MG - Brasil       
                              <b      r>Telefone: +55 (31) 3319-7000 -     Fax: +55 (31) 3319-7001      
                            </p>      
                        </div>      
                        <div c      lass="col l3 s12">      
                            <h5       class="white-text">Recursos</h5>    
                            <ul>      
                              <l      i><a class="white-text link" href="https://github.com/cefet-inf-2015/portal-educacao/" target="_blank">Github</a></li>      
                              <l  i><a class="white-text link" href="http://cefetmg.br/" target="_blank">CEFET-MG</a></li>    
                            </ul  > 
                        </div>  
                    </div>    
                </div> 

                <div c  lass="footer-copyright">  
                    <div   class="container">   
                        Made by <a class="blue-text text-lighten-3" href="http://materializecss.com">Materialize</a>  
                    </div>
                </div>
            </footer>

            <!--  Scripts-->
            <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
            <script src="../../template/js/materialize.js"></script>
            <script src="../../template/js/init.js"></script>
            <script src="../../index.js"></script>
            <script type="text/javascript" src="Script.js"></script>
        </body>
    </html>