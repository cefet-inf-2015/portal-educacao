<?php
  $UploadDirectory = 'web/';
  if(isset($_FILES['logo'])){
    $fileName = $_FILES['logo']['name'];
    /*if (file_exists($UploadDirectory.$fileName)) {
      die("Arquivo Já Existe!");
    }*/
    $tmpName  = $_FILES['logo']['tmp_name'];
    $fileSize = $_FILES['logo']['size'];
    $fileType = $_FILES['logo']['type'];
    echo ("ola");
    if(move_uploaded_file($_FILES['logo']["tmp_name"], $UploadDirectory.$fileName)){
      $banco = "arquivo";
      $link = mysqli_connect("localhost", "root", "", "dados");
     if(!$link) {
       
       die('Not connected : ' . mysql_error()); 
      
      }
   
     $db = mysqli_select_db($link, $banco); 

      $query = "INSERT INTO Cabecalho (nome, logo, type, size) VALUES ('$fileName','$_FILES', '$fileType','$fileSize')";
      
      mysqli_query($link, $query) or die("Erro ao guardar Informaçoes");
      mysqli_close($link);

      echo "informacoes guardadas";
    } 
  }

?>