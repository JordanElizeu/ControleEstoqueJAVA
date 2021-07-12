package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.jdbc.TratacaoErros;
import br.com.projeto.model.SaleProducts;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class SaleProductsDAO {

    private Connection connection;

    public SaleProductsDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastrarClientes(SaleProducts cli) {
        try {
            String sql = "INSERT INTO VENDAS (cliente,produto,endereco,telefone,compra,venda,cep,data_registro,pagamento,quantidade)" + "values (?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, cli.getCliente());
            stmt.setString(2, cli.getProduto());
            stmt.setString(3, cli.getEndereco());
            stmt.setString(4, cli.getTelefone());
            stmt.setString(5, cli.getCompra());
            stmt.setString(6, cli.getVenda());
            stmt.setString(7, cli.getCep());
            stmt.setString(8, cli.getData());
            stmt.setString(9, cli.getPagamento());
            stmt.setInt(10, cli.getQuantidade());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Venda cadastrada!");

        } catch (SQLException ex) {
            StringWriter strStackTrace = new StringWriter();
            ex.printStackTrace(new PrintWriter(strStackTrace));
            SwingUtilities.invokeLater(() -> TratacaoErros.showException(ex.getClass() + " " + ex.getMessage(), strStackTrace.toString()));
        }
    }

    public List<SaleProducts> listarClientes() {
        try {

            //1 passo criar a lista
            List<SaleProducts> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "SELECT * FROM vendas";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                SaleProducts vendas = new SaleProducts();

                vendas.setId(rs.getInt("id"));
                vendas.setCliente(rs.getString("cliente"));
                vendas.setProduto(rs.getString("produto"));
                vendas.setEndereco(rs.getString("endereco"));
                vendas.setTelefone(rs.getString("telefone"));
                vendas.setCompra(rs.getString("compra"));
                vendas.setVenda(rs.getString("venda"));
                vendas.setCep(rs.getString("cep"));
                vendas.setData(rs.getString("data_registro"));
                vendas.setPagamento(rs.getString("pagamento"));
                vendas.setQuantidade(rs.getInt("quantidade"));

                lista.add(vendas);
            }

            return lista;

        } catch (SQLException ex) {

            StringWriter strStackTrace = new StringWriter();
            ex.printStackTrace(new PrintWriter(strStackTrace));
            SwingUtilities.invokeLater(() -> TratacaoErros.showException(ex.getClass() + " " + ex.getMessage(), strStackTrace.toString()));
            return null;
        }

    }

    public void excluirVenda(SaleProducts cli) {
        try {

            String sql = "DELETE FROM vendas WHERE id = ?";
            PreparedStatement pdt = connection.prepareStatement(sql);
            pdt.setInt(1, cli.getId());

            pdt.execute();
            pdt.close();

            JOptionPane.showMessageDialog(null, "Venda deletada com sucesso .");

        } catch (SQLException ex) {
            StringWriter strStackTrace = new StringWriter();
            ex.printStackTrace(new PrintWriter(strStackTrace));
            SwingUtilities.invokeLater(() -> TratacaoErros.showException(ex.getClass() + " " + ex.getMessage(), strStackTrace.toString()));
        }

    }

    public void alterarCliente(SaleProducts vendas) {
        try {

            String sql = "UPDATE vendas SET cliente=?, produto=?, endereco=?, telefone=?, compra=?, venda=?, cep=?, data_registro=?, pagamento=?, quantidade=?"
                    + " where id=?";
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, vendas.getCliente());
            pst.setString(2, vendas.getProduto());
            pst.setString(3, vendas.getEndereco());
            pst.setString(4, vendas.getTelefone());
            pst.setString(5, vendas.getCompra());
            pst.setString(6, vendas.getVenda());
            pst.setString(7, vendas.getCep());
            pst.setString(8, vendas.getData());
            pst.setString(9, vendas.getPagamento());
            pst.setInt(10, vendas.getQuantidade());
            pst.setInt(11, vendas.getId());

            pst.execute();
            pst.close();

            JOptionPane.showMessageDialog(null, "Venda editada com sucesso .");

        } catch (SQLException ex) {
            StringWriter strStackTrace = new StringWriter();
            ex.printStackTrace(new PrintWriter(strStackTrace));
            SwingUtilities.invokeLater(() -> TratacaoErros.showException(ex.getClass() + " " + ex.getMessage(), strStackTrace.toString()));
        }
    }

    public List<SaleProducts> consultaPorNome(String nome) {
        try {
            List<SaleProducts> lista = new ArrayList<>();
            String sql = "SELECT * FROM vendas WHERE cliente LIKE? OR produto LIKE? OR data_registro LIKE?";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, nome);
            stmt.setString(3, nome);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                SaleProducts vendas = new SaleProducts();

                vendas.setId(rs.getInt("id"));
                vendas.setCliente(rs.getString("cliente"));
                vendas.setProduto(rs.getString("produto"));
                vendas.setEndereco(rs.getString("endereco"));
                vendas.setTelefone(rs.getString("telefone"));
                vendas.setCompra(rs.getString("compra"));
                vendas.setVenda(rs.getString("venda"));
                vendas.setCep(rs.getString("cep"));
                vendas.setData(rs.getString("data_registro"));
                vendas.setPagamento(rs.getString("pagamento"));
                vendas.setQuantidade(rs.getInt("quantidade"));

                lista.add(vendas);
            }
            return lista;

        } catch (SQLException ex) {
            StringWriter strStackTrace = new StringWriter();
            ex.printStackTrace(new PrintWriter(strStackTrace));
            SwingUtilities.invokeLater(() -> TratacaoErros.showException(ex.getClass() + " " + ex.getMessage(), strStackTrace.toString()));
            return null;
        }

    }
}
