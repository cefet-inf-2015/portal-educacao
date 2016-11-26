<?php
	//Manipula um XML com o obetivo enviar a outra aplicacao as questoes que irao compor a prova.
	//Deve ser modificada pela gerencia para integração com qualquer outro grupo que precise da prova
	session_start();
	echo $_SESSION['prova'];	
?>
