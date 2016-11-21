/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galeria.SSH;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.jcraft.jsch.UserInfo;
import java.io.InputStream;

/**
 *
 * @author umcan
 */
public class SSH {

    /**
     * Método para enviar um arquivo para o servidor
     * @param host Endereço do servidor
     * @param usuario Nome de usuário
     * @param senha Senha para acessar o SSH
     * @param arquivo Arquivo no computador que será enviado ao servidor
     * @param destino Diretório em que o arquivo será enviado dentro do servidor com o nome e extensão do arquivo no final
     */
    public static void enviarArquivo(String host, String usuario, String senha, String arquivo, String destino) throws SftpException{
        JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession(usuario, host, 4022);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(senha);
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            sftpChannel.put(arquivo, destino);
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();  
        }
    }
    /**
      * Método para baixar um arquivo do servidor
      * @param host Endereço do servidor
      * @param usuario Nome de usuário
      * @param senha Senha para acessar o SSH
      * @param arquivo Arquivo no servidor que será baixado (com o diretório completo)
      * @param destino Diretório em que o arquivo será salvo no computador com nome e extensão do arquivo no final
      */
    public static void baixarArquivo(String host, String usuario, String senha, String arquivo, String destino) throws SftpException{
        JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession(usuario, host, 4022);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(senha);
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            sftpChannel.get(arquivo, destino);
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace(); 
        }
    }
}
