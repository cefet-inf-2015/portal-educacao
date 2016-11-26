<?php

// Include the PHPWord.php, all other classes were loaded by an autoloader

require_once 'PHPWord.php';
session_start();

//DESCOMENTA ESSAS LINHAS GERENCIA!!
require_once 'Download.php';
//require_once 'insereBd.php';
//require_once 'formEdicao.php';
//require_once 'Editacampo.php';

$valor           = $_POST['valor'];
$titulo          = $_POST['Titulo'];
$turno           = $_POST['turno'];
$nQuest          = $_POST['nquestao'];
$elab            = $_POST['prof'];
$turma           = $_POST['turmas'];
$escola          = $_POST['instituicao'];
$duracao         = $_POST['duracao'];
$dataProva       = $_POST['data'];
$dataEntrega     = $_POST['dataEntrega'];
$dataRecebimento = $_POST['dataRecebimento'];
$logo            = $_FILES['logo']['name'];
$brasao          = $_FILES['brasao']['name'];
$tipo            = $_POST['tipo'];
$UploadDirectory = 'img/';
$tipoEscola      = $_POST['tiopoInsti'];
$espaco          = "      ";
$valorCompleto   = $_POST['matricula'];
$parte           = explode(",", $valorCompleto);
$_SESSION['nome']=$parte[1];
$_SESSION['matricula']=$parte[0];
$tipoGeral       = $_POST['quantAlunos'];
$tipoDeEscola    = $_POST['tiopoInsti'];
$dirCarometro    = "../../carometro/$parte[0].jpg";
$_SESSION['tipoGeral'] = $tipoGeral;

$conteudo = $_SESSION['prova'];
            

/*$quest =  preg_replace("/<.*?>/", "", $conteudo) ;*/

move_uploaded_file($_FILES['logo']["tmp_name"], $UploadDirectory . $logo);
move_uploaded_file($_FILES['brasao']["tmp_name"], $UploadDirectory . $brasao);

// Create a new PHPWord Object
$PHPWord = new PHPWord();
$section = $PHPWord->createSection();


// You can directly style your text by giving the addText function an array:

if ($tipoGeral == 'individual') {
    if ($tipo == 'prova') {
        
        $tamanho = array(
            'width' => 5000,
            'valign' => 'center'
        );
        $PHPWord->addTableStyle('tableStyle', $tamanho);
        $table  = $section->addTable();
        $table1 = $section->addTable('tableStyle');
        $table2 = $section->addTable();
        
    if ($tipoEscola == 'publica'){
                    // Add row
            $table->addRow();
            // Add Cell
            $table->addCell(4000)->addImage($dirCarometro, array(
                'width' => 133,
                'height' => 100,
                'align' => 'left'
            ));
            $table->addCell(4000)->addImage($UploadDirectory . $logo, array(
                'width' => 133,
                'height' => 100,
                'align' => 'center'
            ));
            $table->addCell(4000)->addImage($UploadDirectory . $brasao, array(
                'width' => 133,
                'height' => 100,
                'align' => 'right'
            ));
            $table->addRow(1);
            $table->addCell(100)->addText($espaco . $parte[0]);

    } else if($tipoEscola == 'privada') {
                    // Add row
            $table->addRow();
            // Add Cell
            $table->addCell(4000)->addImage($dirCarometro, array(
                'width' => 133,
                'height' => 100,
                'align' => 'left'
            ));
            $table->addCell(4000)->addImage($UploadDirectory . $logo, array(
                'width' => 133,
                'height' => 100,
                'align' => 'center'
            ));
            $table->addCell(4000)->addImage("branco.jpg", array(
                'width' => 133,
                'height' => 100,
                'align' => 'right'
            ));
            $table->addRow(1);
            $table->addCell(100)->addText($espaco . $parte[0]);

    }    
        
        
        $PHPWord->addFontStyle('myOwnStyle', array(
            'align' => 'center',
            'name' => 'Arial',
            'size' => 12,
            'color' => '1B2232'
        ));
        $PHPWord->addParagraphStyle('myOwnP', array(
            'align' => 'center',
            'spaceAfter' => 100
        ));
        $PHPWord->addParagraphStyle('myOwnP_2', array(
            'align' => 'right',
            'spaceAfter' => 200
        ));
        
        // Add row
        $table1->addRow();
        // Add Cell
        $table1->addCell(1500)->addText("\t\t");
        $table1->addCell(6000)->addText($escola, 'myOwnStyle', 'myOwnP');
        // Add Cell
        $table1->addRow();
        // Add Cell
        $table1->addCell(1500)->addText("\t\t");
        $table1->addCell(6000)->addText($titulo, 'myOwnStyle', 'myOwnP');
        
        $table2->addRow();
        $table2->addCell(9500)->addText("Aluno(a): " . $parte[1], 'myOwnStyle');
        $table2->addCell(2500)->addText("Data: " . $dataProva, 'myOwnStyle');
        $table2->addRow();
        $table2->addCell(9500)->addText("Professor(a): " . $elab, 'myOwnStyle');
        $table2->addCell(2000)->addText("Turma: " . $turma, 'myOwnStyle');
        $table2->addRow();
        $table2->addCell(9500)->addText("Valor: " . $valor, 'myOwnStyle');
        $table2->addCell(2000)->addText("Turno: " . $turno, 'myOwnStyle');
        $table2->addRow();
        $table2->addCell(9500)->addText("N. de Questoes: " . $nQuest, 'myOwnStyle');
        $table2->addCell(2000)->addText("Duracao: " . $duracao . " min", 'myOwnStyle');
        
        $abcd = array('a)','b)','c)','d)','e)');
        $VouF = array('(V)','(F)'); 

        $xml=simplexml_load_string($conteudo) or die("Error: Cannot create object");
        for ($i=0; $i < count($xml); $i++) { 
          //INSERE ENUNCIADO  
            $table2->addRow();
            $questao = $xml->questao[$i]->enunciado;
            $quest = utf8_decode($questao);
            $table2->addCell(9500)->addText($quest); 
          //INSERE ALTERNATIVA 
        }    
        

        $parteMatricula = $parte[0];
        $parteNome      = $parte[1];
        
        // At least write the document to webspace:
        $objWriter = PHPWord_IOFactory::createWriter($PHPWord, 'Word2007');
        $objWriter->save("$parteNome $parteMatricula.docx");
    } else if ($tipo == 'trabalho') {
        $tamanho = array(
            'width' => 5000,
            'valign' => 'center'
        );
        $PHPWord->addTableStyle('tableStyle', $tamanho);
        $table  = $section->addTable();
        $table1 = $section->addTable('tableStyle');
        $table2 = $section->addTable();
        
        
        
    if ($tipoEscola == 'publica'){
                    // Add row
            $table->addRow();
            // Add Cell
            $table->addCell(4000)->addImage($dirCarometro, array(
                'width' => 133,
                'height' => 100,
                'align' => 'left'
            ));
            $table->addCell(4000)->addImage($UploadDirectory . $logo, array(
                'width' => 133,
                'height' => 100,
                'align' => 'center'
            ));
            $table->addCell(4000)->addImage($UploadDirectory . $brasao, array(
                'width' => 133,
                'height' => 100,
                'align' => 'right'
            ));
            $table->addRow(1);
            $table->addCell(100)->addText($espaco . $parte[0]);

    } else if($tipoEscola == 'privada') {
   
                    // Add row
            $table->addRow();
            // Add Cell
            $table->addCell(4000)->addImage($dirCarometro, array(
                'width' => 133,
                'height' => 100,
                'align' => 'left'
            ));
            $table->addCell(4000)->addImage($UploadDirectory . $logo, array(
                'width' => 133,
                'height' => 100,
                'align' => 'center'
            ));
            $table->addCell(4000)->addImage("branco.jpg", array(
                'width' => 133,
                'height' => 100,
                'align' => 'right'
            ));
            $table->addRow(1);
            $table->addCell(100)->addText($espaco . $parte[0]);

    }    
        
        
        $PHPWord->addFontStyle('myOwnStyle', array(
            'align' => 'center',
            'name' => 'Arial',
            'size' => 12,
            'color' => '1B2232'
        ));
        $PHPWord->addParagraphStyle('myOwnP', array(
            'align' => 'center',
            'spaceAfter' => 100
        ));
        $PHPWord->addParagraphStyle('myOwnP_2', array(
            'align' => 'right',
            'spaceAfter' => 200
        ));
        
        // Add row
        $table1->addRow();
        // Add Cell
        $table1->addCell(1500)->addText("\t\t");
        $table1->addCell(6000)->addText($escola, 'myOwnStyle', 'myOwnP');
        // Add Cell
        $table1->addRow();
        // Add Cell
        $table1->addCell(1500)->addText("\t\t");
        $table1->addCell(6000)->addText($titulo, 'myOwnStyle', 'myOwnP');
        
        $table2->addRow();
        $table2->addCell(9500)->addText("Aluno(a): " . $parte[1], 'myOwnStyle');
        $table2->addCell(2000)->addText("Turma: " . $turma, 'myOwnStyle');
        $table2->addRow();
        $table2->addCell(9500)->addText("Professor(a): " . $elab, 'myOwnStyle');
        $table2->addCell(2000)->addText("Turno: " . $turno, 'myOwnStyle');
        $table2->addRow();
        $table2->addCell(4000)->addText("Data Entrega: " . $dataEntrega, 'myOwnStyle');
        $table2->addCell(3000)->addText("N. de Questoes: " . $nQuest, 'myOwnStyle');
        $table2->addCell(1000)->addText("Valor: " . $valor, 'myOwnStyle');
        $table2->addRow();
        $table2->addCell(9500)->addText("Data Recebimento: " . $dataRecebimento, 'myOwnStyle');
        $table2->addCell(2000)->addText("Duracao: " . $duracao . " min", 'myOwnStyle');
        

        $parteMatricula2 = $parte[0];
        $parteNome2      = $parte[1];
        
        $objWriter = PHPWord_IOFactory::createWriter($PHPWord, 'Word2007');
        $objWriter->save("$parteMatricula2 $parteNome2.docx");
        
    }
} else 
if ($tipoGeral == 'turma') {

    if ($tipo == 'prova') {
        //$conexao = new mysqli('cefet-inf-2015.ddns.net:43306', 'root', 'apenasinf-2015', 'Usuarios');
        $conexao = new mysqli( 'localhost' , 'root', '', 'Usuarios');
        $query   = "SELECT primeiroNome, ultimoNome, matricula FROM Alunos";
        $vet     = Array();
        if ($result = $conexao->query($query)) {
            
            while ($row = $result->fetch_assoc()) {
                array_push($vet, $row);
            
            }
            $result->close();
        }
        
        // Puxei as informaçoes do bd, falta fazer a alteração de dados de acordo com o numero de alunos.
        // o count nao ta funcionando
        for ($i = 0; $i < count($vet); $i++) {
            $PHPWord = new PHPWord();
            $section = $PHPWord->createSection();
            $dirCarometro2 =  "../../carometro/".$vet[$i]['matricula'].".jpg";
            
            $tamanho = array(
                'width' => 5000,
                'valign' => 'center'
            );
            $PHPWord->addTableStyle('tableStyle', $tamanho);
            $table     = $section->addTable();
            $table1    = $section->addTable('tableStyle');
            $table2    = $section->addTable();
            $nome      = $vet[$i]['primeiroNome'] . ' ' . $vet[$i]['ultimoNome'];
            $matricula = $vet[$i]['matricula'];
            // Add row
    if ($tipoEscola == 'publica'){
                    // Add row
            $table->addRow();
            // Add Cell
            $table->addCell(4000)->addImage($dirCarometro2, array(
                'width' => 133,
                'height' => 100,
                'align' => 'left'
            ));
            $table->addCell(4000)->addImage($UploadDirectory . $logo, array(
                'width' => 133,
                'height' => 100,
                'align' => 'center'
            ));
            $table->addCell(4000)->addImage($UploadDirectory . $brasao, array(
                'width' => 133,
                'height' => 100,
                'align' => 'right'
            ));
            $table->addRow(1);
            $table->addCell(100)->addText($espaco . $vet[$i]['matricula']);

    } else if($tipoEscola == 'privada') {
                    // Add row
            $table->addRow();
            // Add Cell
            $table->addCell(4000)->addImage($dirCarometro2, array(
                'width' => 133,
                'height' => 100,
                'align' => 'left'
            ));
            $table->addCell(4000)->addImage($UploadDirectory . $logo, array(
                'width' => 133,
                'height' => 100,
                'align' => 'center'
            ));
            $table->addCell(4000)->addImage("branco.jpg", array(
                'width' => 133,
                'height' => 100,
                'align' => 'right'
            ));
            $table->addRow(1);
            $table->addCell(100)->addText($espaco . $parte[0]);

    }    
            
            
            $PHPWord->addFontStyle('myOwnStyle', array(
                'align' => 'center',
                'name' => 'Arial',
                'size' => 12,
                'color' => '1B2232'
            ));
            $PHPWord->addParagraphStyle('myOwnP', array(
                'align' => 'center',
                'spaceAfter' => 100
            ));
            $PHPWord->addParagraphStyle('myOwnP_2', array(
                'align' => 'right',
                'spaceAfter' => 200
            ));
            
            // Add row
            $table1->addRow();
            // Add Cell
            $table1->addCell(1500)->addText("\t\t");
            $table1->addCell(6000)->addText($escola, 'myOwnStyle', 'myOwnP');
            // Add Cell
            $table1->addRow();
            // Add Cell
            $table1->addCell(1500)->addText("\t\t");
            $table1->addCell(6000)->addText($titulo, 'myOwnStyle', 'myOwnP');
            
            $table2->addRow();
            $table2->addCell(9500)->addText("Aluno(a): " . $vet[$i]['primeiroNome'] . ' ' . $vet[$i]['ultimoNome'], 'myOwnStyle');
            $table2->addCell(2500)->addText("Data: " . $dataProva, 'myOwnStyle');
            $table2->addRow();
            $table2->addCell(9500)->addText("Professor(a): " . $elab, 'myOwnStyle');
            $table2->addCell(2000)->addText("Turma: " . $turma, 'myOwnStyle');
            $table2->addRow();
            $table2->addCell(9500)->addText("Valor: " . $valor, 'myOwnStyle');
            $table2->addCell(2000)->addText("Turno: " . $turno, 'myOwnStyle');
            $table2->addRow();
            $table2->addCell(9500)->addText("N. de Questoes: " . $nQuest, 'myOwnStyle');
            $table2->addCell(2000)->addText("Duracao: " . $duracao . " min", 'myOwnStyle');


        $xml=simplexml_load_string($conteudo) or die("Error: Cannot create object");
        for ($i=0; $i < count($xml); $i++) { 
          //INSERE ENUNCIADO  
            $table2->addRow();
            $questao = $xml->questao[$i]->enunciado;
            $quest = utf8_decode($questao);
            $table2->addCell(9500)->addText($quest); 
          //INSERE ALTERNATIVA 
        }    
        
            
            $_SESSION['nomeTurma'] = $nome;
            $_SESSION['matTurma']  = $matTurma;
            
            // At least write the document to webspace:
            $objWriter = PHPWord_IOFactory::createWriter($PHPWord, 'Word2007');
            $objWriter->save("$nome $matricula.docx");
        }   

    } else
    if ($tipo == 'trabalho') {
        $conexao = new mysqli('cefet-inf-2015.ddns.net:43306', 'root', 'apenasinf-2015', 'Usuarios');
        $query   = "SELECT primeiroNome, ultimoNome, matricula FROM Alunos";
        $vet     = Array();
        $dirCarometro3 =  "../../carometro/".$vet[$i]['matricula'].".jpg";
        
        if ($result = $conexao->query($query)) {
            
            while ($row = $result->fetch_assoc()) {
                array_push($vet, $row);

            }
            $result->close();
        }
        
        // Puxei as informaçoes do bd, falta fazer a alteração de dados de acordo com o numero de alunos.
        // o count nao ta funcionando
        for ($i = 0; $i < count($vet); $i++) {
            $PHPWord = new PHPWord();
            $section = $PHPWord->createSection();
            $tamanho = array(
                'width' => 5000,
                'valign' => 'center'
            );
            $PHPWord->addTableStyle('tableStyle', $tamanho);
            $table  = $section->addTable();
            $table1 = $section->addTable('tableStyle');
            $table2 = $section->addTable();
            
            
            
    if ($tipoEscola == 'publica'){
                    // Add row
            $table->addRow();
            // Add Cell
            $table->addCell(4000)->addImage($dirCarometro3, array(
                'width' => 133,
                'height' => 100,
                'align' => 'left'
            ));
            $table->addCell(4000)->addImage($UploadDirectory . $logo, array(
                'width' => 133,
                'height' => 100,
                'align' => 'center'
            ));
            $table->addCell(4000)->addImage($UploadDirectory . $brasao, array(
                'width' => 133,
                'height' => 100,
                'align' => 'right'
            ));
            $table->addRow(1);
            $table->addCell(100)->addText($espaco . $vet[$i]['matricula']);

    } else if($tipoEscola == 'privada') {
 
            $table->addRow();
            // Add Cell
            $table->addCell(4000)->addImage($dirCarometro3, array(
                'width' => 133,
                'height' => 100,
                'align' => 'left'
            ));
            $table->addCell(4000)->addImage($UploadDirectory . $logo, array(
                'width' => 133,
                'height' => 100,
                'align' => 'center'
            ));
            $table->addCell(4000)->addImage("branco.jpg", array(
                'width' => 133,
                'height' => 100,
                'align' => 'right'
            ));
            $table->addRow(1);
            $table->addCell(100)->addText($espaco . $vet[$i]['matricula']);

    }    
            
            
            $PHPWord->addFontStyle('myOwnStyle', array(
                'align' => 'center',
                'name' => 'Arial',
                'size' => 12,
                'color' => '1B2232'
            ));
            $PHPWord->addParagraphStyle('myOwnP', array(
                'align' => 'center',
                'spaceAfter' => 100
            ));
            $PHPWord->addParagraphStyle('myOwnP_2', array(
                'align' => 'right',
                'spaceAfter' => 200
            ));
            
            // Add row
            $table1->addRow();
            // Add Cell
            $table1->addCell(1500)->addText("\t\t");
            $table1->addCell(6000)->addText($escola, 'myOwnStyle', 'myOwnP');
            // Add Cell
            $table1->addRow();
            // Add Cell
            $table1->addCell(1500)->addText("\t\t");
            $table1->addCell(6000)->addText($titulo, 'myOwnStyle', 'myOwnP');
            
            $table2->addRow();
            $table2->addCell(9500)->addText("Aluno(a): " . $vet[$i]['primeiroNome'] . ' ' . $vet[$i]['ultimoNome'], 'myOwnStyle');
            $table2->addCell(2000)->addText("Turma: " . $turma, 'myOwnStyle');
            $table2->addRow();
            $table2->addCell(9500)->addText("Professor(a): " . $elab, 'myOwnStyle');
            $table2->addCell(2000)->addText("Turno: " . $turno, 'myOwnStyle');
            $table2->addRow();
            $table2->addCell(4000)->addText("Data Entrega: " . $dataEntrega, 'myOwnStyle');
            $table2->addCell(3000)->addText("N. de Questoes: " . $nQuest, 'myOwnStyle');
            $table2->addCell(1000)->addText("Valor: " . $valor, 'myOwnStyle');
            $table2->addRow();
            $table2->addCell(9500)->addText("Data Recebimento: " . $dataRecebimento, 'myOwnStyle');
            $table2->addCell(2000)->addText("Duracao: " . $duracao . " min", 'myOwnStyle');
            

        $xml=simplexml_load_string($conteudo) or die("Error: Cannot create object");
        for ($i=0; $i < count($xml); $i++) { 
          //INSERE ENUNCIADO  
            $table2->addRow();
            $questao = $xml->questao[$i]->enunciado;
            $quest = utf8_decode($questao);
            $table2->addCell(9500)->addText($quest); 
          //INSERE ALTERNATIVA 
        }    
        

            $parteMatricula3 = $vet[$i]['matricula'];
            $parteNome3      = $vet[$i]['primeiroNome'] . ' ' . $vet[$i]['ultimoNome'];
                    
            // At least write the document to webspace:
            $objWriter = PHPWord_IOFactory::createWriter($PHPWord, 'Word2007');
            $objWriter->save("$parteNome3_$parteMatricula3.docx");
        }
    }
}


?>