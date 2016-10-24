<?php
	$UploadDirectory = 'Upload/';
	if(isset($_FILES['upload'])){
		$fileName = $_FILES['upload']['name'];
		/*if (file_exists($UploadDirectory.$fileName)) {
			die("Arquivo Já Existe!");
		}*/
		$tmpName  = $_FILES['upload']['tmp_name'];
		$fileSize = $_FILES['upload']['size'];
		$fileType = $_FILES['upload']['type'];
		if(move_uploaded_file($_FILES['upload']["tmp_name"], $UploadDirectory .$fileName)){
			$dbconn = mysql_connect('localhost','root','123')or die("Não Funfou");
			mysql_select_db('teste',$dbconn);
			if(mysql_query("INSERT INTO arquivos (nome,size,type) VALUES ('$fileName', '$fileSize', '$fileType')"))
				echo "sucesso<br>";
			//echo "<br>Arquivo $fileName Uploaded<br>";
		}else{
			die('Erro Ao Fazer Upload Do Arquivo!');
		}	
	}
?>	