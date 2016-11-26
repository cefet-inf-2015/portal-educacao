<?php 
  //$conexao = mysqli_connect('localhost', 'root', '', 'modelos');
  $conexao = new mysqli_connect("cefet-inf-2015.ddns.net:43306", "root", "apenasinf-2015", "modelos");
  session_start();
  $titulo = $_SESSION['linha']; 
  $query = sprintf("SELECT * FROM cabecalho WHERE titulo='$titulo'");
  $dados = mysqli_query($conexao,$query);
  $linha = mysqli_fetch_assoc($dados);

    echo "<!DOCTYPE html>
          <html>
          <head>
            <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
            <meta name='viewport' content='width=device-width, initial-scale=1, maximum-scale=1.0'/>
            <title>Portal Educação</title>


            <script src='https://code.jquery.com/jquery-2.1.1.min.js'></script>
            <script src='../../template/js/materialize.js'></script>
            <script src='../../template/js/init.js'></script>
            <script src='script.js'></script>

            <!-- CSS  -->
            <link href='https://fonts.googleapis.com/icon?family=Material+Icons' rel='stylesheet'>
            <link href='../../styles/css/materialize.css' type='text/css' rel='stylesheet' media='screen,projection'/>
            <link href='../../styles/css/style.css' type='text/css' rel='stylesheet' media='screen,projection'/>
            <link rel='icon' href='../../imgs/logo.png' >
            <style type='text/css'>
              body {
                  display: flex;
                  min-height: 100vh;
                  flex-direction: column;
                }

                main {
                  flex: 1 0 auto;
                }
            </style>
            <link rel='icon' href='../../imgs/logo.png' >
          </head>
          <body>
            <nav class='light-blue darken-4' role='navigation'>
              <div class='nav-wrapper container'>
                  <!-- MENU SLIDE OUT STRUCTURE-->
              <ul id='slide-out' class='side-nav'>
                <br>
                <li>
                  <div class='logo'>
                    <img class='background center-block responsive' src='../../imgs/logo.png'>
                  </div>
                </li>
                <br>
                <li><a class='waves-effect' href='../../index.html'>Página Inicial</a></li>
                <li><a class='waves-effect' href='pagInicial.html'>Modelo de Provas/Trabalhos</a></li>
                <li><a class='waves-effect' href='../../Forum/Web/Fórum.html'>Fórum</a></li>
                <li><a class='waves-effect' href='../../Upload/index.html'>Download/Upload Aplicativos</a></li>
                <li><a class='waves-effect' href='../../Correcao/LayoutCorrecaoProvas.html'>Correção Provas e Trabalhos</a></li>
                <li><a class='waves-effect' href='../../Mural/web/index.html'>Mural</a></li>
                <li><a class='waves-effect' href='#!'>Chat</a></li>
                <li><a class='waves-effect' href='#!'>Repositório de Fotos</a></li>
                <li><a class='waves-effect' href='#!'>Banco de Questões</a></li>
                <li><a class='waves-effect' href='#!'>Calendário</a></li>
                <!--<li><div class='divider'></div></li>-->
                <!--<li><a class='subheader'>Subheader</a></li>-->
              </ul>
                <ul class='left '>
                  <li>
                    <button data-activates='slide-out' class='waves-effect waves-light btn-flat button-collapse white-text light-blue darken-4'>Menu</button>
                  </li>
                </ul>
                <ul class='right '>
                  <!-- <li><button class='waves-effect waves-light btn-flat white-text light-blue darken-4'>Entrar</button></li> -->
                  <li><a class='waves-effect waves-light btn modal-trigger white-text light-blue darken-3' href='#modal1'>Entrar</a></li>
                </ul>
              </div>
            </nav>
            
            <!-- Modal de login -->
            <div id='modal1' class='modal modal-fixed-footer'>
              <div class='modal-content'>
                <h4>Login</h4>
                <div class='row'>
                  <p>Insira dados</p>
                  <form>
                    <label for='username'>Nome de usuario</label>
                    <input type='text' name='username'>
                    <label for='senha'>Senha</label>
                    <input type='password' name='senha'>
                    <label for='tipoUsuario'>Tipo de usuário</label>
                    <select name='tipoUsuario'>
                      <option value=' disabled selected>Tipo de Usuario</option>
                      <option value='1'>Aluno</option>
                      <option value='2'>Professor</option>
                      <option value='3'>Coordenador</option>
                      <option value='4'>Diretor</option>
                    </select>
                    <button class='col s12 btn-flat waves-effect waves-light green white-text' type='submit' name='action'>Entrar
                        <i class='material-icons right'>input</i>
                      </button>
                  </form>

                </div>
              </div>
              <div class='modal-footer'>
                <a href='#!' class='modal-action modal-close waves-effect waves-green btn-flat red white-text'>Sair</a>
              </div>
            </div>

            <!-- ESPAÇO PARA MARQUEE -->
            <div>
              
            </div>

            <main>
            <div class='section no-pad-bot' id='index-banner'>
              <div class='container'>
                <div class='row center'>
                  <h5 class='header col s12 light'>Selecione o que Deseja Editar</h5>
                </div>
              </div>
            </div>
 
              <div>
            <form action='Edita.php' method='POST'><br>   
              <div id='divmatricula'>
                <div class='container'>
                  <label for='matricula'>Matrícula</label>
                  <input type='text' name='matricula' id='matricula' value=".$linha['matricula']."></input> 
                </div>
              </div>
              
                <div id='divValor'>
                <div class='container'>
                <label for='valor'> Valor</label><br>
                <input type='number' name='valor' id='valor' min='0' value=".$linha['valor']." style='width: 50px; height: 20px'> pts
                  </div>
                  </div>

                  <div id='divTitulo'>
                  <div class='container'>
                <label id='TituloP'> Titulo </label>
                <input type='text' name='Titulo' id='Titulo' value=".$linha['titulo']."/>
              </div>
              </div>

              <div id='divNquest'>
              <div class='container'>
                <label for='Nquestao' id='letraquestoes'> Nº Questões </label>
                <input type='number' name='nquestao' value=".$linha['numeroQuestoes']." id='valor' min='0'
                   style='width: 50px; height: 20px'>
                </div>
                </div>
                
              <div id='divTurno'>
              <div class='container'>
                <label>Turno: </label>  
                <div class='input-field col s12'>
                <select name='turno' id='turno' class='browser-default' value=".$linha['turno']."style='width: 100px; height: 35px'>
                  <option value='manha'>Manhã</option>
                  <option value='tarde'>Tarde</option>
                  <option value='Noite'>Noite</option>
                </select> 
              </div>
              </div>
              </div>

              <div id='divTurma'>
              <div class='container'>
                <label for='turmas'> Turmas: </label>
                <input type='text' name='turmas' id='turmas' value=".$linha['turma']."></input> 
              </div>
              </div>

              <div id='divProf'>
              <div class='container'>
                <label for='prof'> Elaborador: </label>
                <input type='text' name='prof' id='prof' value=".$linha['nomeProfessor']."></input> 
                </div>
                </div>

                <div id='divInsti'>
                <div class='container'>
                  <label for='instituicao'>Instituição: </label>
                  <input type='text' name= 'instituicao' id='instituicao' value=".$linha['nomeEscola']."></input> 
                  <label>Tipo de Instituição</label>
                </div>
                </div>

                <div id='divTipoInst'>
              <div class='container'>
                  <input type='radio' id='Privada' name='tiopoInsti' value='privada' />
                  <label for='Privada'>Privada</label>&emsp;
                  
                  <input type='radio' id='Publica' name='tiopoInsti' value='publica' />
                  <label for='Publica'>Publica</label>
                </div>
                </div>

                <div id='divBotao1'>
                <div class='container'>
                <label for='logo'>Logo</label>
                <input type='file'  value=".$linha['nomeLogotipo']." name='logo' id='logo'/>
              </div>
                  </div>  
                  <div id='divBotao2'>
                <div class='container'>
                <label for='brasao'>Brasao</label>
                <input type='file' value=".$linha['nomeBrasao']." name='brasao' id='brasao'>
                  </div>
                  </div>

                  <!--Formulário de Prova-->

               <div id='divDuracao'>
                <div class='container'>
                <label for='duração' id='letraduracao'> Duração </label>
                <input type='number' name='duracao' value=".$linha['duracao']."  id='duracao' min='0' style='width: 50px; height: 20px' > min.
                  </div>
                  </div>

                  <div id='divDataApli'>
                <div class='container'>
                <label for='data' id='letradata'> Data: </label> 
                <input type='date'  value=".$linha['dataProva']."  name='data' id='data'/>
                  </div>
                  </div>

                <!--Formulário para Trabalho-->
                <div id='divDataEntre'>
                <div class='container'>
                  <label for='dataEntrega'>Data de Entrega (Caso seja trabalho):</label>
                  <input type='date' name='dataEntrega'  value=".$linha['dataEntrega']." id='dataEntrega'/>
                </div>
                </div>

                <div id='divDataReceb'>
                <div class='container'>
                  <label for='dataRecebimento'>Data de Recebimento (Caso seja trabalho): </label>
                  <input type='date' name='dataRecebimento'  value=".$linha['dataRecebimento']." id='dataRecebimento'/>
                </div>
                </div>

                <div class='container'>
                <div id='botao'>
              <br><br>
              <button type='submit' class='waves-effect waves-light blue darken-4 btn'><i class='material-icons left'>send</i>Enviar</button>
              </div>
              </div>

              </div>
               </div>
            </form>
          </div>
          </main>
                


            <footer class='page-footer blue'>
              <div class='container'>
                <div class='row'>
                  <div class='col l6 s12'>
                    <h5 class='white-text'>Desenvolvedores</h5>
                    <p class='grey-text text-lighten-4'>
                      Somos a turma de Informática 2A do ano de 2016 do CEFET-MG (Centro Federal de Educação Tecnológica de Minas Gerais) desenvolvendo o trabalho final multidisciplinar de Linguagem de Programação 1 e Aplicações para WEB.
                      <br><a class='white-text link' href='../../colaboradores.html'>Clique aqui</a> para saber mais
                    </p>
                  </div>
                  <div class='col l3 s12'>
                    <h5 class='white-text'>Sobre a Instituição</h5>
                    <p class='grey-text text-lighten-4'>
                      Centro Federal de Educação Tecnológica de Minas Gerais
                      <br>Av. Amazonas 5253 - Nova Suiça - Belo Horizonte - MG - Brasil
                      <br>Telefone: +55 (31) 3319-7000 - Fax: +55 (31) 3319-7001
                    </p>
                  </div>
                  <div class='col l3 s12'>
                    <h5 class='white-text'>Recursos</h5>
                    <ul>
                      <li><a class='white-text link' href='https://github.com/cefet-inf-2015/portal-educacao/' target='_blank'>Github</a></li>
                      <li><a class='white-text link' href='http://cefetmg.br/' target='_blank'>CEFET-MG</a></li>
                    </ul>
                  </div>
                </div>
              </div>
              <div class='footer-copyright'>
                <div class='container'>
                Made by <a class='blue-text text-lighten-3' href='http://materializecss.com'>Materialize</a>
                </div>
              </div>
            </footer>

            <!--  Scripts-->
            <script src='https://code.jquery.com/jquery-2.1.1.min.js'></script>
            <script src='../../template/js/materialize.js'></script>
            <script src='../../template/js/init.js'></script>
            <script src='../../index.js'></script>

            </body>
          </html>";

?>