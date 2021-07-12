package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.jdbc.TratacaoErros;
import br.com.projeto.model.StockProducts;
import br.com.projeto.view.JFrmPainel;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class StockProductsDAO {

    private Connection connection;

    public StockProductsDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastrarProduto(StockProducts estoque, String tabela, Boolean msg) {
        try {

            String sql = "INSERT INTO " + tabela + " (nome,venda,compra,data_registro,data_vencimento,descricao,prioridade,marca,quantidade,imagem)" + "values (?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, estoque.getNome());
            stmt.setString(2, estoque.getVenda());
            stmt.setString(3, estoque.getCompra());
            stmt.setString(4, estoque.getData());
            stmt.setString(5, estoque.getVencimento());
            stmt.setString(6, estoque.getDescricao());
            stmt.setString(7, estoque.getPrioridade());
            stmt.setString(8, estoque.getMarca());
            stmt.setInt(9, estoque.getQuantidade());
            stmt.setBytes(10, estoque.getImagem());

            stmt.execute();
            stmt.close();
            if (msg == true) {
                JOptionPane.showMessageDialog(null, "Produto Cadastrado!");
            }

        } catch (SQLException ex) {
            StringWriter strStackTrace = new StringWriter();
            ex.printStackTrace(new PrintWriter(strStackTrace));
            SwingUtilities.invokeLater(() -> TratacaoErros.showException(ex.getClass() + " " + ex.getMessage(), strStackTrace.toString()));
        }
    }

    public List<StockProducts> listarEstoque(String tabela) {
        try {

            //1 passo criar a lista
            List<StockProducts> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "SELECT * FROM " + tabela;
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                StockProducts estoque = new StockProducts();

                estoque.setId(rs.getInt("id"));
                estoque.setNome(rs.getString("nome"));
                estoque.setVenda(rs.getString("venda"));
                estoque.setCompra(rs.getString("compra"));
                estoque.setData(rs.getString("data_registro"));
                estoque.setVencimento(rs.getString("data_vencimento"));
                estoque.setDescricao(rs.getString("descricao"));
                estoque.setPrioridade(rs.getString("prioridade"));
                estoque.setMarca(rs.getString("marca"));
                estoque.setQuantidade(rs.getInt("quantidade"));
                estoque.setImagem(rs.getBytes("imagem"));

                lista.add(estoque);
            }

            return lista;

        } catch (SQLException ex) {

            StringWriter strStackTrace = new StringWriter();
            ex.printStackTrace(new PrintWriter(strStackTrace));
            SwingUtilities.invokeLater(() -> TratacaoErros.showException(ex.getClass() + " " + ex.getMessage(), strStackTrace.toString()));
            return null;
        }

    }

    public void excluirProduto(StockProducts estoque, String tabela, Boolean msg) {
        try {

            String sql = "DELETE FROM " + tabela + " WHERE id = ?";
            PreparedStatement pdt = connection.prepareStatement(sql);
            pdt.setInt(1, estoque.getId());

            pdt.execute();
            pdt.close();

            if (msg == true) {
                JOptionPane.showMessageDialog(null, "Produto deletado com sucesso .");
            } else {
                JOptionPane.showMessageDialog(null, "Produto recuperado com sucesso .");
            }

        } catch (SQLException ex) {
            StringWriter strStackTrace = new StringWriter();
            ex.printStackTrace(new PrintWriter(strStackTrace));
            SwingUtilities.invokeLater(() -> TratacaoErros.showException(ex.getClass() + " " + ex.getMessage(), strStackTrace.toString()));
        }

    }

    public void alterarProduto(StockProducts produtos) {
        try {

            String sql = "UPDATE estoque SET nome=?, venda=?, compra=?, data_registro=?, data_vencimento=?, descricao=?, prioridade=?, marca=?, quantidade=?, imagem=?"
                    + " where id=?";
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, produtos.getNome());
            pst.setString(2, produtos.getVenda());
            pst.setString(3, produtos.getCompra());
            pst.setString(4, produtos.getData());
            pst.setString(5, produtos.getVencimento());
            pst.setString(6, produtos.getDescricao());
            pst.setString(7, produtos.getPrioridade());
            pst.setString(8, produtos.getMarca());
            pst.setInt(9, produtos.getQuantidade());
            pst.setBytes(10, produtos.getImagem());
            pst.setInt(11, produtos.getId());

            pst.execute();
            pst.close();

            JOptionPane.showMessageDialog(null, "Venda editada com sucesso .");

        } catch (SQLException ex) {
            StringWriter strStackTrace = new StringWriter();
            ex.printStackTrace(new PrintWriter(strStackTrace));
            SwingUtilities.invokeLater(() -> TratacaoErros.showException(ex.getClass() + " " + ex.getMessage(), strStackTrace.toString()));
        }
    }

    public List<StockProducts> consultaPorNome(String nome, String tabela) {
        try {
            List<StockProducts> lista = new ArrayList<>();
            String sql = "SELECT * FROM " + tabela + " WHERE nome LIKE? OR data_registro LIKE? OR marca LIKE? OR prioridade like?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, nome);
            stmt.setString(3, nome);
            stmt.setString(4, nome);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                StockProducts estoque = new StockProducts();

                estoque.setId(rs.getInt("id"));
                estoque.setNome(rs.getString("nome"));
                estoque.setVenda(rs.getString("venda"));
                estoque.setCompra(rs.getString("compra"));
                estoque.setData(rs.getString("data_registro"));
                estoque.setVencimento(rs.getString("data_vencimento"));
                estoque.setDescricao(rs.getString("descricao"));
                estoque.setPrioridade(rs.getString("prioridade"));
                estoque.setMarca(rs.getString("marca"));
                estoque.setQuantidade(rs.getInt("quantidade"));

                lista.add(estoque);
            }
            return lista;

        } catch (SQLException ex) {
            StringWriter strStackTrace = new StringWriter();
            ex.printStackTrace(new PrintWriter(strStackTrace));
            SwingUtilities.invokeLater(() -> TratacaoErros.showException(ex.getClass() + " " + ex.getMessage(), strStackTrace.toString()));
            return null;
        }

    }

    public void esvaziarLixeira() {

        try {

            String sql = "TRUNCATE TABLE lixeira";
            PreparedStatement pdt = connection.prepareStatement(sql);
            pdt.execute();
            pdt.close();

        } catch (SQLException ex) {
            Logger.getLogger(JFrmPainel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
