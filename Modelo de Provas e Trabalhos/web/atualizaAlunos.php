<?php
    //$conexao = new mysqli( 'cefet-inf-2015.ddns.net:43306' , 'root', 'apenasinf-2015', 'Usuarios');
    $conexao = new mysqli( 'localhost' , 'root', '', 'Usuarios');
    $query = "SELECT primeiroNome, ultimoNome, matricula FROM Alunos";
    $vet = array();
    $vetGrande = array();
 
    if ($result = $conexao->query($query)) {
 
        while ($row=$result->fetch_assoc()) {
            array_push($vet, $row);
        }
        echo json_encode(utf8ize($vet));
        $result->close();
    }
    //Transfrma p/ utf8 possibilitando Json encode
    function utf8ize($d) {
    if (is_array($d)) {
        foreach ($d as $k => $v) {
            $d[$k] = utf8ize($v);
        }
    } else if (is_string ($d)) {
        return utf8_encode($d);
    }
    return $d;
    }
 ?>