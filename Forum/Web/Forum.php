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

        <body onload="Listener(0);">
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

            <div class="container">
                <div class="section">
                    <div class="row">
                        <div class="col s7">
                            <div class="row collection">
                                <a href="#!" class="collection-item"><h5>Máterias do Ensino Médio</h5></a>
                                <div name="divhide" class="esconde">
                            	   <a href="Categorias/Matematica.php" class="collection-item">Matemática</a>
                            	   <a href="Categorias/Português.html" class="collection-item">Português</a>
                            	   <a href="Categorias/Biologia.html" class="collection-item">Biologia</a>
                            	   <a href="Categorias/Filosofia.html" class="collection-item">Filosofia</a>
                            	   <a href="Categorias/Geografia.html" class="collection-item">Geografia</a>
                            	   <a href="Categorias/História.html" class="collection-item">História</a>
                            	   <a href="Categorias/Inglês.html" class="collection-item">Inglês</a>
                            	   <a href="Categorias/Química.html" class="collection-item">Química</a>
                            	   <a href="Categorias/Redação.html" class="collection-item">Redação</a>
                            	   <a href="Categorias/Sociologia.html" class="collection-item">Sociologia</a>
                            	   <a href="Categorias/EducaçãoFísica.html" class="collection-item">Educação Física</a>
                                </div>
                            </div>

                            <div class="row collection">
                                <a href="#!" class="collection-item"><h5>Cursos Técnicos</h5></a>
                                <div name="divhide" class="esconde">
                                    <a href="Categorias/Edificações.html" class="collection-item">Edificações</a>
                                    <a href="Categorias/Eletrônica.html" class="collection-item">Eletrônica</a>
                                    <a href="Categorias/Eletrotécnica.html" class="collection-item">Eletrotécnica</a>
                                    <a href="Categorias/EquipamentosBiomédicos.html" class="collection-item">Equipamentos Biomédicos</a>
                                    <a href="Categorias/Estradas.html" class="collection-item">Estradas</a>
                                    <a href="Categorias/Informática.html" class="collection-item">Informática</a>
                                    <a href="Categorias/MeioAmbiente.html" class="collection-item">Meio Ambiente</a>
                                    <a href="Categorias/Mecânica.html" class="collection-item">Mecânica</a>
                                    <a href="Categorias/Mecatrônica.html" class="collection-item">Mecatrônica</a>
                                    <a href="Categorias/QuímicaTécnico.html" class="collection-item">Química</a>
                                    <a href="Categorias/RededeComputadores.html" class="collection-item">Rede de Computadores</a>
                                    <a href="Categorias/TransporteseTransito.html" class="collection-item">Transportes e Trânsito</a>
                                    <a href="Categorias/Hospedagem.html" class="collection-item">Hospedagem</a>
                                </div>
                            </div>

                            <div class="row collection">
                                <a href="#!" class="collection-item"><h5>Entretenimento</h5></a>
                                <div name="divhide" class="esconde">
                                    <a href="Categorias/Filmes.html" class="collection-item">Filmes</a>
                                    <a href="Categorias/Teatro.html" class="collection-item">Teatro</a>
                                    <a href="Categorias/Livros.html" class="collection-item">Livros</a>
                                    <a href="Categorias/Jogos.html" class="collection-item">Jogos</a>
                                    <a href="Categorias/Moda.html" class="collection-item">Moda</a>
                                </div>
                            </div>

                            <div class="row collection">
                                <a href="Categorias/DúvidasGerais.html" class="collection-item"><h5>Dúvidas Gerais</h5></a>
                            </div>

                            <div class="row collection">
                                <a href="Categorias/AssuntosGenéricos.html" class="collection-item"><h5>Assuntos Genéricos</h5></a>
                            </div>
                        </div>

                        <div class="col s5">
                            <div class="col s12 m10">
                                <div class="card horizontal">
                                    
                                        <?php

                                        $dbhost = 'localhost'; // endereco do servidor de banco de dados
                                        $dbuser = 'root'; // login do banco de dados
                                        $dbname = 'bdforum'; // nome do banco de dados a ser usado
               
                                        $conecta = @mysql_connect($dbhost, $dbuser, $dbpass);
                                        $seleciona = @mysql_select_db($dbname);

                                       

                                        if ( isset($_SESSION["usuario"]) ) {
                                             
                                            $userData = (array) $_SESSION["usuario"];
                                            $nome = $userData['primeiroNome']; //." ".$userData['ultimoNome'];
                                            $matricula = $userData['numeroMatricula'];
                                            if (is_file("../../".$userData['foto'])) {
                                                $foto = "../../".$userData['foto'];
                                            }else{
                                                $foto = "foto.png";
                                            }

                                             
                                            
                                            switch ($userData['permissao']) {
                                                case '0':$hierarquia= "Aluno"; break;
                                                case '1':$hierarquia= "Professor"; break;                                                
                                                case '2':$hierarquia= "Coordenador";break;
                                                case '3':$hierarquia= "Diretor";break;
                                            }

                                            $sqlinsereusuario= "INSERT INTO usuarios ( nome,tipo,foto,matricula) VALUES ('$nome','$hierarquia','$foto','$matricula')";
                                            $insererusuario = @mysql_query($sqlinsereusuario, $conecta);
    
                                             

                                             $busca = mysql_query("select * from usuarios where matricula='$matricula' "); //informaçoes do autor
                                        
                                             while($infouser=mysql_fetch_array($busca)){
                                            
                                                $tipo = $infouser['Tipo'];
                                                $criados = $infouser['Criados'];
                                            }

                                        echo 
                                        "<div class=\"card-image\">
                                        <img src=\"".$foto."\">
                                    	</div>
                                    	<div class=\"card-stacked\">
                                        <div class=\"card-content\">
                                            <div style=\"color: #1E90FF\">Nome: </div><div id=\"Nome\">".
                                                 $userData['primeiroNome']." 
                                            </div>
                                            <div style=\"color: #1E90FF\">Matrícula: </div>
                                            <div id=\"Matricula\">"
                                            .$userData['numeroMatricula'].
                                            "</div>
                                            <div style=\"color: #1E90FF\">Posts: </div>".$criados."<div id=\"Posts\"></div>
                                            <div id=\"Classificacao\" style=\"color: blue\">".$tipo."</div>
                                        </div>";
										}else{
											echo "
											<div class=\"card-stacked\">
											<h2 class=\"header\" style=\"color:#069\"> Bem Vindo ao Fórum!</h2>";
										}

                                        

                                        ?>
                                    </div>
                                </div>

                                

                                <div class="collection">
                                    <a href="#!" class="collection-item"><h6>Estatísticas do Fórum</h6></a>
                                    <?php 

                                    $busca = mysql_query("select * from usuarios"); //informaçoes do autor
                                        $Posts=0;
                                        $Respostas=0;
                                        $users=0;

                                        while($infouser=mysql_fetch_array($busca)){
                                            
                                            $Posts = $Posts + $infouser['Criados'] + $infouser['Comentarios'];
                                            $Respostas =$Respostas + $infouser['Criados'];
                                            $users++;
                                        }

                                    echo "
                                    <a href=\"#!\" class=\"collection-item\"><div id=\"PostsTotal\">Posts: ".$Posts."</div></a>
                                    <a href=\"#!\" class=\"collection-item\"><div id=\"TopicosTotal\">Topicos: ".$Respostas."</div></a>
                                    <a href=\"#!\" class=\"collection-item\"><div >Usuários: ".$users."</div></a>
                                    "

                                    ?>
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