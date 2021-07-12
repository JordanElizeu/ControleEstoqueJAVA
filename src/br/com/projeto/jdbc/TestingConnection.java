package br.com.projeto.jdbc;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class TestingConnection {
    
    public static void main(String[] args) {
        
        try {
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Operação concluida com sucesso. ");
        } catch (Exception e) {
             StringWriter strStackTrace = new StringWriter();
            e.printStackTrace(new PrintWriter(strStackTrace));
            SwingUtilities.invokeLater(() -> TratacaoErros.showException(e.getClass() + " " + e.getMessage(),strStackTrace.toString()));
        }
    }
}
