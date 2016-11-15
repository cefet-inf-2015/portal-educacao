/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssh;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.jcraft.jsch.UserInfo;
import java.io.File;
import java.io.InputStream;
import java.util.Vector;

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
    public static void enviarArquivo(String host, String usuario, String senha, String arquivo, String destino){
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
        } catch (SftpException e) {
            e.printStackTrace();
        }
    }
    /**
     * Método para deletar um arquivo do servidor
     * @param host Endereço do servidor
     * @param usuario Nome de usuário
     * @param senha Senha para acessar o SSH
     * @param arquivo Caminho do arquivo a ser deletado do servidor
     */
    public static void deletarArquivo(String host, String usuario, String senha, String arquivo){
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
            sftpChannel.rm(arquivo);
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();  
        } catch (SftpException e) {
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
    public static void baixarArquivo(String host, String usuario, String senha, String arquivo, String destino){
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
        } catch (SftpException e) {
            e.printStackTrace();
        }
    }
    /**
      * Método para baixar um diretorio do servidor
      * @param host Endereço do servidor
      * @param usuario Nome de usuário
      * @param senha Senha para acessar o SSH
      * @param diretorio Diretorio no servidor que será baixado
      * @param destino Diretório em que o diretorio será salvo no computador
      */
    public static void baixarDiretorio(String host, String usuario, String senha, String diretorio, String destino){
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
            String dir1 = diretorio.split("\\/")[diretorio.split("\\/").length-1];
            File dir = new File(destino+"/"+dir1);
            dir.mkdir();
            Vector v = sftpChannel.ls(diretorio);
            for(int I=2; I<v.size(); I++){
                LsEntry entr = (LsEntry) v.get(I);
                System.out.println(entr.getFilename());
                if(entr.getFilename().contains(".")){
                    SSH.baixarArquivo(host, usuario, senha, diretorio+"/"+entr.getFilename(), destino+"/"+dir1+"/"+entr.getFilename());
                }else{
                    SSH.baixarDiretorio(host, usuario, senha, diretorio+"/"+entr.getFilename(), destino+"/"+dir1);
                }
            }          
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace(); 
        } catch (SftpException e) {
            e.printStackTrace();
        }
    }
    
    public static void main (String[] args){
        SSH.baixarDiretorio("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro", "C:/Users/umcan/Desktop");
    }
}
