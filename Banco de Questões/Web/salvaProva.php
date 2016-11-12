<?php
		//~ session_start("prova");
		$fp = fopen('/home/terror/Desktop/prova.xml', 'w+');
		fwrite($fp, $_SESSION['prova']);
		fclose($fp);
?>
