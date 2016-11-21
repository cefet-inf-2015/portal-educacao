<?php
ob_start();
class Usuario {
	public $primeiroNome;
	public $ultimoNome;
	public $nickname;
	public $foto;
	public $numeroMatricula;
	public $permissao;

	public function __construct($primeiroNome, $ultimoNome, $nickname, $foto, $numeroMatricula, $permissao) {
		$this->primeiroNome = $primeiroNome;
		$this->ultimoNome = $ultimoNome;
		$this->nickname = $nickname;
		$this->foto = $foto;
		$this->numeroMatricula = $numeroMatricula;
		$this->permissao = $permissao;
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

class Aluno extends Usuario {
	public $turma;
	public $divisaoTurma;

	public function __construct($primeiroNome, $ultimoNome, $nickname, $foto, $numeroMatricula, $turma, $divisao) {
		parent::__construct($primeiroNome, $ultimoNome, $nickname, $foto, $numeroMatricula, 0);
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
		parent::__construct($primeiroNome, $ultimoNome, $nickname, $foto, $numeroMatricula, 1);
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
         parent::__construct($primeiroNome, $ultimoNome, $nickname, $foto, $numeroMatricula, 3);
   }
 }
 class Coordenador extends Usuario{
    public $cursos= Array();
   
	public function __construct($primeiroNome, $ultimoNome, $nickname, $foto, $numeroMatricula, $cursos) {
		parent::__construct($primeiroNome, $ultimoNome, $nickname, $foto, $numeroMatricula, 2);
		$this->cursos=$cursos;
	}

	function getCursos() {
		return $cursos;
	}

	function setCursos($cursos) {
		$this->cursos = $cursos;
	}
}

class Login {
	//Pra salvar ArrayLists deve ser usado o método Join
	public static $conexao=null;
	//Faz a conexão com o banco de dados
	public static function conectarBanco($ip, $user, $senha, $banco) {
		//self::$conexao = mysqli_connect($ip, $user, $senha, $banco);
		self::$conexao = new mysqli($ip, $user, $senha, $banco);
		if (self::$conexao->connect_error) {
		    die('Erro (' . self::$conexao->connect_errno . ')');
		}
	}
	//Realiza login de forma mais generica
	public static function logarUsuario($username, $senha, $tipo){

		if ($tipo == 'Aluno') {
			$tabela = $tipo . 's';
		}
		else {
			$tabela = $tipo . 'es';
		}
		$senha = md5($senha);
		$query ="SELECT * FROM $tabela WHERE username='$username' AND senha='$senha'";
		//$resultado = mysqli_query(self::$conexao, $query);
		$resultado = self::$conexao->query($query);
		//Recupera os dados binários da foto
		//Instancia um novo usuário com os dados recuperados do Banco de Dados
		if($resultado->num_rows == 0){
			return false;
		}
		$dados = $resultado->fetch_assoc();
		$dados['foto'] = NULL;
		//Cria variavel usuario
		$usuario = null;
		switch($tipo) {
			case 'Aluno':
				$usuario = new Aluno($dados["primeiroNome"], 
						$dados["ultimoNome"],
						$dados["username"],
						$dados["foto"],
						$dados["matricula"],
						$dados["turma"],
						$dados["divisao"]
					);
				break;

			case 'Diretor':
				$usuario = new Diretor($dados["primeiroNome"], 
						$dados["ultimoNome"],
						$dados["username"],
						$dados["foto"],
						$dados["matricula"]
					);
				break;
			case 'Professor':
				$usuario = new Professor($dados["primeiroNome"], 
						$dados["ultimoNome"],
						$dados["username"],
						$dados["foto"],
						$dados["matricula"],
						explode(',' , $dados["turmas"])
					);
				break;

			case 'Coordenador':
				$usuario = new Coordenador($dados["primeiroNome"], 
						$dados["ultimoNome"],
						$dados["username"],
						$dados["foto"],
						$dados["matricula"],
						explode(',' , $dados["cursos"])
				);
		}
		
		return $usuario;
	}
}
?>