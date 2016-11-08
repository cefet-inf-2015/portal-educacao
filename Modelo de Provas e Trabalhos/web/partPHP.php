<?php

// Include the PHPWord.php, all other classes were loaded by an autoloader

require_once 'PHPWord.php';
//require_once 'insereBd.php';
$UploadDirectory = 'img/';
$valor           = $_POST['valor'];
$titulo          = $_POST['Titulo'];
$turno           = $_POST['turno'];
$nQuest          = $_POST['nquestao'];
$elab            = $_POST['prof'];
$turma           = $_POST['turmas'];
$escola          = $_POST['instituicao'];
$duracao         = $_POST['duracao'];
$dataProva       = $_POST['datadeAplicacao'];
$dataEntrega     = $_POST['dataEntrega'];
$dataRecebimento = $_POST['dataRecebimento'];
$tipo            = $_POST['tipo'];
$logo            = $_FILES['logo']['name'];
$brasao          = $_FILES['brasao']['name'];
$foto            = $_FILES['foto']['name'];

move_uploaded_file($_FILES['foto']["tmp_name"], $UploadDirectory . $foto);
move_uploaded_file($_FILES['logo']["tmp_name"], $UploadDirectory . $logo);
move_uploaded_file($_FILES['brasao']["tmp_name"], $UploadDirectory . $brasao);
// Create a new PHPWord Object
$PHPWord = new PHPWord();

// Every element you want to append to the word document is placed in a section. So you need a section:
$section = $PHPWord->createSection();


// You can directly style your text by giving the addText function an array:

//$section->addText($titulo, array('align'=>'center','name'=>'Arial', 'size'=>16, 'bold'=>true));

$table = $section->addTable();

if ($tipo == 'prova') {
    
    for ($r = 1; $r <= 1; $r++) { // Loop through rows
        // Add row
        $table->addRow();
        
        for ($c = 1; $c <= 1; $c++) { // Loop through cells
            // Add Cell
            $table->addCell(3000)->addImage($UploadDirectory . $foto, array(
                'width' => 133,
                'height' => 100,
                'align' => 'left'
            ));
            $table->addCell(3000)->addImage($UploadDirectory . $logo, array(
                'width' => 133,
                'height' => 100,
                'align' => 'center'
            ));
            $table->addCell(3000)->addImage($UploadDirectory . $brasao, array(
                'width' => 133,
                'height' => 100,
                'align' => 'right'
            ));
        }
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
    
    
    
    
    //USAR TABELA PARA INSERIR CAMPOS
    
    $section->addText($escola, 'myOwnStyle', 'myOwnP');
    $section->addText($titulo, 'myOwnStyle', 'myOwnP');
    $section->addText('Aluno(a): ' . "\t\t\t\t\t\t\t\t\t" . 'Data: ' . $dataProva, 'myOwnStyle');
    $section->addText('Professor(A): ' . $elab . "\t\t\t\t\t" . 'Turma: ' . $turma, 'myOwnStyle');
    
    
    $section->addText('Valor: ' . $valor . "\t\t\t\t\t\t\t\t\t" . 'Turno: ' . $turno, 'myOwnStyle');
    
    $section->addText('N. de Questoes: ' . $nQuest . "\t\t\t\t\t\t\t\t" . 'Duracao: ' . $duracao . ' min.', 'myOwnStyle');
    
    
    
    // At least write the document to webspace:
    $objWriter = PHPWord_IOFactory::createWriter($PHPWord, 'Word2007');
    $objWriter->save('prova.docx');
    
} else if ($tipo == 'trabalho') {
    
    for ($r = 1; $r <= 1; $r++) { // Loop through rows
        // Add row
        $table->addRow();
        
        for ($c = 1; $c <= 1; $c++) { // Loop through cells
            // Add Cell
            $table->addCell(3000)->addImage($foto, array(
                'width' => 133,
                'height' => 100,
                'align' => 'left'
            ));
            $table->addCell(3000)->addImage($logo, array(
                'width' => 133,
                'height' => 100,
                'align' => 'center'
            ));
            $table->addCell(3000)->addImage($brasao, array(
                'width' => 133,
                'height' => 100,
                'align' => 'right'
            ));
        }
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
    
    
    
    
    //USAR TABELA PARA INSERIR CAMPOS
    
    $section->addText($escola, 'myOwnStyle', 'myOwnP');
    $section->addText($titulo, 'myOwnStyle', 'myOwnP');
    $section->addText('Aluno(a): ' . "\t\t\t\t\t\t\t\t\t" . 'Data: ' . $dataProva, 'myOwnStyle');
    $section->addText('Professor(A): ' . $elab . "\t\t\t\t\t" . 'Turma: ' . $turma, 'myOwnStyle');
    
    
    $section->addText('Valor: ' . $valor . "\t\t\t\t\t\t\t\t\t" . 'Turno: ' . $turno, 'myOwnStyle');
    
    $section->addText('N. de Questoes: ' . $nQuest . "\t\t\t\t\t\t\t\t" . 'Duracao: ' . $duracao . ' min.', '	myOwnStyle');
    
    
    
    // At least write the document to webspace:
    $objWriter = PHPWord_IOFactory::createWriter($PHPWord, 'Word2007');
    $objWriter->save('trabalho.docx');
}


?>