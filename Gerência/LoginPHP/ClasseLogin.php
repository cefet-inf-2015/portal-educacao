<?php
	class Usuario {
		public $primeiroNome;
		public $ultimoNome;
		public $nickname;
		public $foto;
		public $numeroMatricula;

		public function __construct($primeiroNome, $ultimoNome, $nickname, $foto, $numeroMatricula) {
			$this->primeiroNome = $primeiroNome;
			$this->ultimoNome = $ultimoNome;
			$this->nickname = $nickname;
			$this->foto = $foto;
			$this->numeroMatricula = $numeroMatricula;
		}


		function getPrimeiroNome() {
			return $primeiroNome;
		}

		function setPrimeiroNome($primeiroNome) {
			$this->primeiroNome = $primeiroNome;
		}

		function getUltimoNome() {
			return $ultimoNome;
		}

		function setUltimoNome($ultimoNome) {
			$this->ultimoNome = $ultimoNome;
		}

		function getNickname() {
			return $nickname;
		}

		function setNickname($nickname) {
			$this->nickname=$nickname;
		}
		
		function getFoto() {
			return $foto;
		}
		
		function setFoto($foto) {
			$this->foto = $foto;
		}
		
		function getNumeroMatricula() {
			return $numeroMatricula;
		}
		
		function setNumeroMatricula($numeroMatricula) {
			$this->numeroMatricula = $numeroMatricula;
		}  
		
	}
	
   class Aluno extends Usuario{
		public $turma;
		public $divisaoTurma;

		public function __construct($primeiroNome, $ultimoNome, $nickname, $foto, $numeroMatricula, $turma, $divisao) {
			parent::__construct($primeiroNome, $ultimoNome, $nickname, $foto, $numeroMatricula);
			$this->turma=$turma;
			$divisaoTurma=$divisao;
		}

		function getTurma() {
			return $turma;
		}

		function setTurma($turma) {
			$this->turma = $turma;
		}

		function getDivisaoTurma() {
			return $divisaoTurma;
		}
		
		function setDivisaoTurma($divisaoTurma) {
			$this->divisaoTurma = $divisaoTurma;
		}
   }
   class Professor extends Usuario{
		public $turmas = Array();
		public function __construct($primeiroNome, $ultimoNome, $nickname, $foto, $numeroMatricula, $turmas) {
			parent::__construct($primeiroNome, $ultimoNome, $nickname, $foto, $numeroMatricula);
			$this->turmas=$turmas;
		}
		function getTurmas() {
			return $turmas;
		}

		function setTurmas($turmas) {
			$this->turmas = $turmas;
		}
   }
   class Diretor extends Usuario{
	   public function __construct($primeiroNome, $ultimoNome, $nickname, $foto, $numeroMatricula) {
           parent::__construct($primeiroNome, $ultimoNome, $nickname, $foto, $numeroMatricula);
	   }
   }
   class Coordenador extends Usuario{
	    public $cursos= Array();
	   
		public function __construct($primeiroNome, $ultimoNome, $nickname, $foto, $numeroMatricula, $cursos) {
			parent::__construct($primeiroNome, $ultimoNome, $nickname, $foto, $numeroMatricula);
			$this->cursos=$cursos;
		}

		function getCursos() {
			return $cursos;
		}

		function setCursos($cursos) {
			$this->cursos = $cursos;
		}
    
   }
   class Login{
		//Pra salvar ArrayLists deve ser usado o método Join
		public static $conexao=null;
		//Faz a conexão com o banco de dados
		public static function conectarBanco($ip, $user, $senha, $banco) {
			self::$conexao = mysqli_connect($ip, $user, $senha, $banco);
			if(!self::$conexao){
				echo 'Erro ao conectar ao banco de dados';
				exit;
			}
			mysqli_select_db(self::$conexao,$banco);
		}
		//Realiza login de forma mais generica
		public static function logarUsuario($username, $senha, $tabela, $tipo){
			$query ="SELECT * FROM $tabela WHERE username='$username' AND senha='.md5($senha)'";
			$resultado = mysqli_query(self::$conexao, $query);
			//Recupera os dados binários da foto
			//Instancia um novo usuário com os dados recuperados do Banco de Dados
			if(!$resultado){
				return false;
			}
			$dados = mysqli_fetch_assoc($resultado);
			$usuario;
			switch($tipo) {
				case 'aluno':
					$usuario = new Aluno($dados["primeiroNome"], 
							$dados["ultimoNome"],
							$dados["username"],
							$dados["foto"],
							$dados["matricula"],
							$dados["turma"],
							$dados["divisao"]);
					break;

				case 'diretor':
					$usuario = new Diretor($dados["primeiroNome"], 
							$dados["ultimoNome"],
							$dados["username"],
							$dados["foto"],
							$dados["matricula"]);
					break;
				case 'professor':
					$usuario = new Professor($dados["primeiroNome"], 
							$dados["ultimoNome"],
							$dados["username"],
							$dados["foto"],
							$dados["matricula"],
							explode(',' , $dados["turmas"]));
					break;

				case 'coordenador':
					$usuario = new Coordenador($dados["primeiroNome"], 
							$dados["ultimoNome"],
							$dados["username"],
							$dados["foto"],
							$dados["matricula"],
							explode(',' , $dados["cursos"]));
			}
			return $usuario;
		}

		//Realiza o login de um aluno
		public static function logarAluno($username, $senha, $tabela){
			$query ="SELECT * FROM $tabela WHERE username='$username' AND senha='.md5($senha)'";
			$resultado = mysqli_query(self::$conexao, $query);
			//Recupera os dados binários da foto
			//Instancia um novo usuário com os dados recuperados do Banco de Dados
			if(!$resultado){
				echo "Erro ao obter os dados da tabela";
			}
			$dados = mysqli_fetch_assoc($resultado);
			$usuario;
			$usuario = new Aluno($dados["primeiroNome"], 
					$dados["ultimoNome"],
					$dados["username"],
					$dados["foto"],
					$dados["matricula"],
					$dados["turma"],
					$dados["divisao"]);
			return $usuario;
		}
		//Realiza o login de um diretor
		
		public static function logarDiretor($username, $senha, $tabela){
			$query ="SELECT * FROM $tabela WHERE username='$username' AND senha='.md5($senha)'";
			$resultado = mysqli_query(self::$conexao, $query);
			//Recupera os dados binários da foto
			//Instancia um novo usuário com os dados recuperados do Banco de Dados
			$dados = mysqli_fetch_assoc($resultado);
			$usuario;
			$usuario = new Diretor($dados["primeiroNome"], 
					$dados["ultimoNome"],
					$dados["username"],
					$dados["foto"],
					$dados["matricula"]);
			return $usuario;
		}
		
		//Realiza o login de um professor
		public static function logarProfessor($username, $senha, $tabela){
			$query ="SELECT * FROM $tabela WHERE username='$username' AND senha='.md5($senha)'";
			$resultado = mysqli_query(self::$conexao, $query);
			//Recupera os dados binários da foto
			//Instancia um novo usuário com os dados recuperados do Banco de Dados
			if(!$resultado){
				echo "Erro ao obter os dados da tabela";
			}
			$dados = mysqli_fetch_assoc($resultado);
			$usuario;
			$usuario = new Professor($dados["primeiroNome"], 
					$dados["ultimoNome"],
					$dados["username"],
					$dados["foto"],
					$dados["matricula"],
					explode(',' , $dados["turmas"]));
			return $usuario;
		}
		//Realiza o login de um coordenador
		public static function logarCoordenador($username, $senha, $tabela){
			$query ="SELECT * FROM $tabela WHERE username='$username' AND senha='.md5($senha)'";
			$resultado = mysqli_query(self::$conexao, $query);
			//Recupera os dados binários da foto
			//Instancia um novo usuário com os dados recuperados do Banco de Dados
			if(!$resultado){
				echo "Erro ao obter os dados da tabela";
			}
			$dados = mysqli_fetch_assoc($resultado);
			$usuario;
			$usuario = new Coordenador($dados["primeiroNome"], 
					$dados["ultimoNome"],
					$dados["username"],
					$dados["foto"],
					$dados["matricula"],
					explode(',' , $dados["cursos"]));
			return $usuario;
		}
   }
?>