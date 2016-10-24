<?php
	$dbconn = mysql_connect('localhost','root')or die("Não Funfou");
	$result = mysql_query($query) or die('Error, query failed');

    $query = "SELECT id, name FROM upload";
    $result = mysql_query($query) or die('Erro');

    if(mysql_num_rows($result)==0){
        echo "BD Vazio<br>";
    }
    else{
        while(list($id, $name) = mysql_fetch_array($result)){
            echo "<a href=\"download.php?id=\$id\">$name</a><br>";
        }
    }

    if(isset($_GET['id'])){
        $id = $_GET['id'];   
        $query = "SELECT name, type, size, content FROM upload WHERE id = '$id'";       
        $result = mysql_query($query) or die('Error, query failed');
        list($name, $type, $size, $content) =  mysql_fetch_row($result);
        header("Content-Disposition: attachment; filename=\"$name\"");
        header("Content-type: $type");
        header("Content-length: $size");
        print $content;
    }
?>