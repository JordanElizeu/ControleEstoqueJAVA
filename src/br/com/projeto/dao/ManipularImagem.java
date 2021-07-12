/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author marcelosiedler
 */
public class ManipularImagem {

    /*
     * Faz redimensionamento da imagem conforme os parâmetros imgLargura e imgAltura mantendo a proporcionalidade. 
     * Caso a imagem seja menor do que os parâmetros de redimensionamento, a imagem não será redimensionada. 
     *  
     * @param caminhoImg caminho e nome da imagem a ser redimensionada. 
     * @param imgLargura nova largura da imagem após ter sido redimensionada. 
     * @param imgAltura  nova altura da imagem após ter sido redimensionada. 
     *  
     * @return Não há retorno 
     * @throws Exception Erro ao redimensionar imagem 
     ************************************************************************************************************/
    public static BufferedImage setImagemDimensao(String caminhoImg) {
        Double novaImgLargura = 550.0;
        Double novaImgAltura = 400.0;
        Graphics2D g2d = null;
        BufferedImage imagem = null, novaImagem = null;

        try {
            //--- Obtém a imagem a ser redimensionada ---
            imagem = ImageIO.read(new File(caminhoImg));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(ManipularImagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        novaImagem = new BufferedImage(novaImgLargura.intValue(), novaImgAltura.intValue(), BufferedImage.TYPE_INT_RGB);
        g2d = novaImagem.createGraphics();
        g2d.drawImage(imagem, 0, 0, novaImgLargura.intValue(), novaImgAltura.intValue(), null);

        return novaImagem;
    }

    public static byte[] getImgBytes(BufferedImage image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "JPEG", baos);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Imagem não suportada .");
        }
        
        return baos.toByteArray();
    }
    //Novo método para exibir imagem na tela
    //Recebe o label que queremos exibir E a imagem como array de bytes do banco
    public static void exibiImagemLabel(byte[] minhaimagem, javax.swing.JLabel label)
{
        //primeiro verifica se tem a imagem
        //se tem convert para inputstream que é o formato reconhecido pelo ImageIO
       
        if(minhaimagem!=null)
        {
            InputStream input = new ByteArrayInputStream(minhaimagem);
            try {
                BufferedImage imagem = ImageIO.read(input);
                label.setIcon(new ImageIcon(imagem));
                label.setAlignmentY(200);
                label.setAlignmentX(200);
            } catch (IOException ex) {
            }
            
        
        }
        else
        {
            label.setIcon(null);
            
        }

}
}
