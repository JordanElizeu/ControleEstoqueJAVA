package br.com.projeto.jdbc;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.SwingUtilities;

public class ConnectionFactory {
    
    public Connection getConnection() { 
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DBCONTROLADOR", "userADMIN", "123");

        } catch (SQLException e) {
            StringWriter strStackTrace = new StringWriter();
            e.printStackTrace(new PrintWriter(strStackTrace));
            SwingUtilities.invokeLater(() -> TratacaoErros.showException(e.getClass() + " " + e.getMessage(),strStackTrace.toString()));
            return null;
        }
    }
}
