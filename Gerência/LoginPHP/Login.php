<?php
	public class Usuario {
		$primeiroNome;
		$ultimoNome;
		$nickname;
		$foto;
		$numeroMatricula;

		public Usuario($primeiroNome, $ultimoNome, $nickname, $foto, $numeroMatricula) {
			this.primeiroNome = primeiroNome;
			this.ultimoNome = ultimoNome;
			this.nickname = nickname;
			this.foto = foto;
			this.numeroMatricula = numeroMatricula;
		}


		function getPrimeiroNome() {
			return primeiroNome;
		}

		function setPrimeiroNome($primeiroNome) {
			this.primeiroNome = primeiroNome;
		}

		function getUltimoNome() {
			return ultimoNome;
		}

		function setUltimoNome($ultimoNome) {
			this.ultimoNome = ultimoNome;
		}

		function getNickname() {
			return nickname;
		}

		function setNickname($nickname) {
			this.nickname=nickname;
		}
		
		function getFoto() {
			return foto;
		}
		
		function setFoto($foto) {
			this.foto = foto;
		}
		
		function getNumeroMatricula() {
			return numeroMatricula;
		}
		
		function setNumeroMatricula($numeroMatricula) {
			this.numeroMatricula = numeroMatricula;
		}  
		
	}
	
   class Aluno{
	   
   }
   class Professor{
	   
   }
   class Diretor{
	   
   }
   class Coordenador{
	   
   }
   class Login{
		//Pra salvar ArrayLists deve ser usado o método Join
		$conexao=null;
		//Faz a conexão com o banco de dados
		public static function conectarBanco($ip, $user, $senha, $banco) {
			$conexao = mysqli_connect(ip, user, senha, banco);
			if(!conexao){
				echo 'Erro ao conectar ao banco de dados';
				exit;
			}
		}
		//Realiza o login de um aluno
		public static function logarAluno($username, $senha, $tabela){
			$resultado = mysqli_query($conexao, "SELECT * FROM " + tabela + " WHERE username=\'" + username + "\' AND senha=\'" + senha + "\'");
			//Recupera os dados binários da foto
			//Instancia um novo usuário com os dados recuperados do Banco de Dados
			$dados = mysqli_fetch_array($resultado, MYSQLI_ASSOC);
			$usuario;
			$usuario = new Aluno($dados["primeiroNome"], 
					$dados["ultimoNome"],
					$dados["username"],
					$dados["foto"],
					$dados["matricula"],
					$dados["turma"],
					$dados["divisao"]);
			return usuario;
		}
		//Realiza o login de um diretor
		
		public static function logarDiretor($username, $senha, $tabela){
			$resultado = mysqli_query($conexao, "SELECT * FROM " + tabela + " WHERE username=\'" + username + "\' AND senha=\'" + senha + "\'");
			//Recupera os dados binários da foto
			//Instancia um novo usuário com os dados recuperados do Banco de Dados
			$dados = mysqli_fetch_array($resultado, MYSQLI_ASSOC);
			$usuario;
			$usuario = new Diretor($dados["primeiroNome"], 
					$dados["ultimoNome"],
					$dados["username"],
					$dados["foto"],
					$dados["matricula"]);
			return usuario;
		}
		
		//Realiza o login de um professor
		public static function logarProfessor($username, $senha, $tabela){
			$resultado = mysqli_query($conexao, "SELECT * FROM " + tabela + " WHERE username=\'" + username + "\' AND senha=\'" + senha + "\'");
			//Recupera os dados binários da foto
			//Instancia um novo usuário com os dados recuperados do Banco de Dados
			$dados = mysqli_fetch_array($resultado, MYSQLI_ASSOC);
			$usuario;
			$usuario = new Professor($dados["primeiroNome"], 
					$dados["ultimoNome"],
					$dados["username"],
					$dados["foto"],
					$dados["matricula"],
					explode(',' , $dados["turmas"]));
			return usuario;
		}
		//Realiza o login de um coordenador
		public static function logarCoordenador($username, $senha, $tabela){
			$resultado = mysqli_query($conexao, "SELECT * FROM " + tabela + " WHERE username=\'" + username + "\' AND senha=\'" + senha + "\'");
			//Recupera os dados binários da foto
			//Instancia um novo usuário com os dados recuperados do Banco de Dados
			$dados = mysqli_fetch_array($resultado, MYSQLI_ASSOC);
			$usuario;
			$usuario = new Coordenador($dados["primeiroNome"], 
					$dados["ultimoNome"],
					$dados["username"],
					$dados["foto"],
					$dados["matricula"],
					explode(',' , $dados["cursos"]));
			return usuario;
		}
   }
?>