                <?php
                date_default_timezone_set("America/Sao_Paulo");
                $UploadDirectory = 'dado/';
                $conexao = mysql_connect('localhost', 'root', '123');
				mysql_select_db('teste',$conexao);
                if (isset($_FILES['upload'])) {
                    $fileName = $_FILES['upload']['name'];
                    if (!file_exists($UploadDirectory . $fileName)) {
                        $tmpName = $_FILES['upload']['tmp_name'];
                        $fileSize = $_FILES['upload']['size'];
                        $fileType = $_FILES['upload']['type'];
                        if (move_uploaded_file($_FILES['upload']["tmp_name"], $UploadDirectory . $fileName)) {
                            if ($conexao) {
                                if (mysql_query("INSERT INTO new_table(nome,size,type,path,tags1) VALUES ('$fileName','$fileSize', '$fileType','$UploadDirectory$fileName','$_POST[palavrasChave]')")) {
                                    unset($_FILES['upload']);
                                    header('Location: Inicio.html');
                                } else {
                                    echo 'Erro no query';
                                }
                            } else {
                                echo 'Erro na conexão';
                            }
                        } else {
                            echo 'Erro no upload do arquivo!';
							}
                    } else {
                        echo 'Erro, arquivo já existente';
                    }
                    unset($_FILES['upload']);
                } else {
                    echo 'Nenhum arquivo selecionado';
					}
                ?>