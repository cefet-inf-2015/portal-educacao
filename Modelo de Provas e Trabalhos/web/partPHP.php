<?php

// Include the PHPWord.php, all other classes were loaded by an autoloader

require_once 'PHPWord.php';
//require_once 'insereBd.php';

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
$foto            = $_FILES['foto']['name'];
$tipo            = $_POST['tipo'];
$UploadDirectory = 'img/';
$tipoEscola      = $_POST['tiopoInsti'];

move_uploaded_file($_FILES['foto']["tmp_name"], $UploadDirectory . $foto);
move_uploaded_file($_FILES['logo']["tmp_name"], $UploadDirectory . $logo);
move_uploaded_file($_FILES['brasao']["tmp_name"], $UploadDirectory . $brasao);

// Create a new PHPWord Object
$PHPWord = new PHPWord();

// Every element you want to append to the word document is placed in a section. So you need a section:
$section = $PHPWord->createSection();


// You can directly style your text by giving the addText function an array:

//$section->addText($titulo, array('align'=>'center','name'=>'Arial', 'size'=>16, 'bold'=>true));
if ($tipo == 'prova') {
    
    
    
    $tamanho = array(
        'width' => 5000,
        'valign' => 'center'
    );
    $PHPWord->addTableStyle('tableStyle', $tamanho);
    $table  = $section->addTable();
    $table1 = $section->addTable('tableStyle');
    $table2 = $section->addTable();
    
    
    
    // Add row
    $table->addRow();
    // Add Cell
    $table->addCell(4000)->addImage($UploadDirectory . $foto, array(
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
    $table2->addCell(9500)->addText("Aluno(a): " . "NOME DO ALUNO", 'myOwnStyle');
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
    
    // At least write the document to webspace:
    $objWriter = PHPWord_IOFactory::createWriter($PHPWord, 'Word2007');
    $objWriter->save('prova.docx');
} else if ($tipo == 'trabalho') {
    
    $tamanho = array(
        'width' => 5000,
        'valign' => 'center'
    );
    $PHPWord->addTableStyle('tableStyle', $tamanho);
    $table  = $section->addTable();
    $table1 = $section->addTable('tableStyle');
    $table2 = $section->addTable();
    
    
    
    // Add row
    $table->addRow();
    // Add Cell
    $table->addCell(4000)->addImage($UploadDirectory . $foto, array(
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
    $table2->addCell(9500)->addText("Aluno(a): " . "puxar do banco de dados", 'myOwnStyle');
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
    
    
    // At least write the document to webspace:
    $objWriter = PHPWord_IOFactory::createWriter($PHPWord, 'Word2007');
    $objWriter->save('trabalho.docx');
    
    
}

?>