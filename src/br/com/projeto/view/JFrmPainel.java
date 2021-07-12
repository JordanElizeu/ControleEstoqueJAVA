/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.view;

import br.com.projeto.dao.ManipularImagem;
import br.com.projeto.dao.SaleProductsDAO;
import br.com.projeto.dao.StockProductsDAO;
import br.com.projeto.model.Delete_Fields;
import br.com.projeto.model.SaleProducts;
import br.com.projeto.model.StockProducts;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jorda
 */
public class JFrmPainel extends javax.swing.JFrame {

    /**
     * Creates new form JFrmCliente
     */
    public JFrmPainel() {
        initComponents();
    }

    Delete_Fields apagar = new Delete_Fields();
    SaleProducts vendas = new SaleProducts();
    StockProducts estoque = new StockProducts();
    StockProductsDAO estoqueDAO = new StockProductsDAO();
    SaleProductsDAO vendasDAO = new SaleProductsDAO();

    private Connection connection;
    BufferedImage imagem;

    public void listar() {
        List<SaleProducts> lista = vendasDAO.listarClientes();
        DefaultTableModel dados = (DefaultTableModel) TBVendas.getModel();
        dados.setNumRows(0);

        for (SaleProducts sale : lista) {
            dados.addRow(new Object[]{
                sale.getId(),
                sale.getCliente(),
                sale.getProduto(),
                sale.getEndereco(),
                sale.getTelefone(),
                sale.getCompra(),
                sale.getVenda(),
                sale.getCep(),
                sale.getData(),
                sale.getPagamento(),
                sale.getQuantidade(),});
        }

        List<StockProducts> lista2 = estoqueDAO.listarEstoque("estoque");
        DefaultTableModel dados2 = (DefaultTableModel) TBEstoque.getModel();
        dados2.setNumRows(0);

        for (StockProducts stock : lista2) {
            dados2.addRow(new Object[]{
                stock.getId(),
                stock.getNome(),
                stock.getVenda(),
                stock.getCompra(),
                stock.getData(),
                stock.getVencimento(),
                stock.getDescricao(),
                stock.getPrioridade(),
                stock.getMarca(),
                stock.getQuantidade(),
                stock.getImagem()});
        }

        List<StockProducts> lista3 = estoqueDAO.listarEstoque("lixeira");
        DefaultTableModel dados3 = (DefaultTableModel) TrashCanTabela.getModel();
        dados3.setNumRows(0);

        for (StockProducts stock : lista3) {
            dados3.addRow(new Object[]{
                stock.getId(),
                stock.getNome(),
                stock.getVenda(),
                stock.getCompra(),
                stock.getData(),
                stock.getVencimento(),
                stock.getDescricao(),
                stock.getPrioridade(),
                stock.getMarca(),
                stock.getQuantidade(),
                stock.getImagem()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Tela1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Vprodutotxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Vvendatxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Vcompratxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Vdatatxt = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        Vtelefonetxt = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        ButtonVendasCadastrar = new javax.swing.JButton();
        Vclientestxt = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        Venderecotxt = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        Vpagamentotxt = new javax.swing.JComboBox<>();
        Vceptxt = new javax.swing.JFormattedTextField();
        ButtonVendasSalvar = new javax.swing.JButton();
        id_invisible = new javax.swing.JTextField();
        ButtonVendasSalvar_Cancel = new javax.swing.JButton();
        Vquantidadetxt = new javax.swing.JSpinner();
        Tela2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Pcompratxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Pdatatxt = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Pprioridadetxt = new javax.swing.JComboBox<>();
        Pdatavencimentotxt = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Pdescricaotxt = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        Pmarcatxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ButtonProdutosCadastrar = new javax.swing.JButton();
        ButtonProdutosSalvar = new javax.swing.JButton();
        id_invisibleProduct = new javax.swing.JTextField();
        ButtonProdutosSalvar_Cancel = new javax.swing.JButton();
        Pprodutotxt = new javax.swing.JTextField();
        Pvendatxt = new javax.swing.JTextField();
        Pquantidadetxt = new javax.swing.JSpinner();
        Imageview = new javax.swing.JLabel();
        btnImagem = new javax.swing.JButton();
        Tela4 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TBVendas = new javax.swing.JTable();
        Vpesquisartxt = new javax.swing.JTextField();
        ButtonPesquisar_Vendas = new javax.swing.JButton();
        Tela3 = new javax.swing.JPanel();
        Ppesquisartxt = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        TBEstoque = new javax.swing.JTable();
        ButtonPesquisar_Estoque = new javax.swing.JButton();
        Tela5 = new javax.swing.JPanel();
        TrashCantxt = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        TrashCanTabela = new javax.swing.JTable();
        TrashCanButtonPesquisar = new javax.swing.JButton();
        esvaziar_lixeira = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Produto:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Valor de Venda:");

        Vvendatxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VvendatxtActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Valor de Compra:");

        Vcompratxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VcompratxtActionPerformed(evt);
            }
        });

        jLabel9.setText("Data de Registro:");

        try {
            Vdatatxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Vdatatxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VdatatxtActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Telefone:");

        try {
            Vtelefonetxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Vtelefonetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VtelefonetxtActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Cep:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Quantidade:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Endereço:");

        ButtonVendasCadastrar.setText("Cadastrar");
        ButtonVendasCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonVendasCadastrarActionPerformed(evt);
            }
        });

        Vclientestxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VclientestxtActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Cliente:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Pagamento:");

        Vpagamentotxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pagamento à Vista", "Pagamento no cartão 1x", "Pagamento no cartão 2x", "Pagamento no cartão 3x", "Pagamento no cartão 4x", "Pagamento no cartão 5x", "Pagamento no cartão 6x", "Pagamento no cartão 7x", "Pagamento no cartão 8x", "Pagamento no cartão 9x", "Pagamento no cartão 10x", "Pagamento no cartão 11x", "Pagamento no cartão 12x" }));

        try {
            Vceptxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Vceptxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VceptxtActionPerformed(evt);
            }
        });

        ButtonVendasSalvar.setText("Salvar Edição");
        ButtonVendasSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonVendasSalvarActionPerformed(evt);
            }
        });

        ButtonVendasSalvar_Cancel.setText("Cancelar Edição");
        ButtonVendasSalvar_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonVendasSalvar_CancelActionPerformed(evt);
            }
        });

        Vquantidadetxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Vquantidadetxt.setMinimumSize(new java.awt.Dimension(150, 22));
        Vquantidadetxt.setValue(1);
        Vquantidadetxt.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                VquantidadetxtStateChanged(evt);
            }
        });

        javax.swing.GroupLayout Tela1Layout = new javax.swing.GroupLayout(Tela1);
        Tela1.setLayout(Tela1Layout);
        Tela1Layout.setHorizontalGroup(
            Tela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tela1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(Tela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Tela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Tela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Venderecotxt, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Tela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Vpagamentotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Vdatatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonVendasCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Tela1Layout.createSequentialGroup()
                                .addComponent(ButtonVendasSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonVendasSalvar_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Tela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Vceptxt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Vtelefonetxt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Vcompratxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Vclientestxt, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(Vprodutotxt))
                    .addGroup(Tela1Layout.createSequentialGroup()
                        .addComponent(Vvendatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Vquantidadetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(id_invisible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(424, Short.MAX_VALUE))
        );
        Tela1Layout.setVerticalGroup(
            Tela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tela1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(Tela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Vclientestxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Tela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Vprodutotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Tela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Vvendatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(id_invisible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Vquantidadetxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Tela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Vcompratxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Tela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Vdatatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Tela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(Vtelefonetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Tela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(Vceptxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Tela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(Venderecotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Tela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(Vpagamentotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(Tela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonVendasSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonVendasSalvar_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(ButtonVendasCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );

        jTabbedPane1.addTab("Cadastro de Vendas", Tela1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Produto:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Valor de Venda:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Valor de Compra:");

        try {
            Pdatatxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Pdatatxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PdatatxtActionPerformed(evt);
            }
        });

        jLabel7.setText("Data de Registro:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Data Vencimento:");

        jLabel15.setText("Prioridade");

        Pprioridadetxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prioridade A", "Prioridade B", "Prioridade C" }));
        Pprioridadetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PprioridadetxtActionPerformed(evt);
            }
        });

        try {
            Pdatavencimentotxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Pdatavencimentotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PdatavencimentotxtActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Descrição:");

        Pdescricaotxt.setColumns(20);
        Pdescricaotxt.setRows(5);
        jScrollPane2.setViewportView(Pdescricaotxt);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Marca:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Quantidade:");

        ButtonProdutosCadastrar.setText("Cadastrar");
        ButtonProdutosCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonProdutosCadastrarActionPerformed(evt);
            }
        });

        ButtonProdutosSalvar.setText("Salvar Edição");
        ButtonProdutosSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonProdutosSalvarActionPerformed(evt);
            }
        });

        ButtonProdutosSalvar_Cancel.setText("Cancelar Edição");
        ButtonProdutosSalvar_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonProdutosSalvar_CancelActionPerformed(evt);
            }
        });

        Pquantidadetxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Pquantidadetxt.setMinimumSize(new java.awt.Dimension(150, 22));
        Pquantidadetxt.setValue(1);
        Pquantidadetxt.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                PquantidadetxtStateChanged(evt);
            }
        });

        Imageview.setBackground(new java.awt.Color(255, 255, 0));
        Imageview.setForeground(new java.awt.Color(255, 255, 0));
        Imageview.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Imageview.setMaximumSize(new java.awt.Dimension(320, 320));
        Imageview.setMinimumSize(new java.awt.Dimension(320, 320));

        btnImagem.setText("Selecionar Imagem");
        btnImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Tela2Layout = new javax.swing.GroupLayout(Tela2);
        Tela2.setLayout(Tela2Layout);
        Tela2Layout.setHorizontalGroup(
            Tela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tela2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Tela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Tela2Layout.createSequentialGroup()
                        .addGroup(Tela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Tela2Layout.createSequentialGroup()
                                .addGroup(Tela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Tela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(Tela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel3)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Tela2Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(2, 2, 2))
                                            .addComponent(jLabel2))
                                        .addComponent(jLabel16))
                                    .addComponent(jLabel10))
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Tela2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(Tela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Pdatavencimentotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Pdatatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Pprodutotxt)
                            .addGroup(Tela2Layout.createSequentialGroup()
                                .addGroup(Tela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Pvendatxt)
                                    .addComponent(Pcompratxt, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(Tela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(id_invisibleProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Tela2Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Pprioridadetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(Pmarcatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Pquantidadetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Tela2Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(Tela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Tela2Layout.createSequentialGroup()
                                .addComponent(ButtonProdutosSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonProdutosSalvar_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ButtonProdutosCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addGroup(Tela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Imageview, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(120, 120, 120))
        );
        Tela2Layout.setVerticalGroup(
            Tela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tela2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Imageview, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(Tela2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(Tela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Pprodutotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Tela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(Pprioridadetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(Pvendatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Tela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pcompratxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_invisibleProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(16, 16, 16)
                .addGroup(Tela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pdatatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(14, 14, 14)
                .addGroup(Tela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(Pdatavencimentotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(Tela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(Pmarcatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Tela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(Pquantidadetxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(Tela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(43, 43, 43)
                .addComponent(ButtonProdutosCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Tela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonProdutosSalvar_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonProdutosSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cadastro de Produtos", Tela2);

        TBVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cliente", "Produto", "Endereço", "Telefone", "Compra", "Venda", "Cep", "Data", "Pagamento", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBVendasMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(TBVendas);

        Vpesquisartxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                VpesquisartxtKeyPressed(evt);
            }
        });

        ButtonPesquisar_Vendas.setText("Pesquisar");
        ButtonPesquisar_Vendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPesquisar_VendasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Tela4Layout = new javax.swing.GroupLayout(Tela4);
        Tela4.setLayout(Tela4Layout);
        Tela4Layout.setHorizontalGroup(
            Tela4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Tela4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1211, Short.MAX_VALUE))
            .addGroup(Tela4Layout.createSequentialGroup()
                .addGap(336, 336, 336)
                .addComponent(Vpesquisartxt, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonPesquisar_Vendas)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Tela4Layout.setVerticalGroup(
            Tela4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tela4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(Tela4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Vpesquisartxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonPesquisar_Vendas))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Histórico de Vendas", Tela4);

        Ppesquisartxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PpesquisartxtKeyPressed(evt);
            }
        });

        TBEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Valor de Venda", "Valor de Compra", "Data de Registro", "Data de Vencimento", "Descrição", "Prioridade", "Marca", "Quantidade", "Imagem"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBEstoqueMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(TBEstoque);

        ButtonPesquisar_Estoque.setText("Pesquisar");
        ButtonPesquisar_Estoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPesquisar_EstoqueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Tela3Layout = new javax.swing.GroupLayout(Tela3);
        Tela3.setLayout(Tela3Layout);
        Tela3Layout.setHorizontalGroup(
            Tela3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tela3Layout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addComponent(Ppesquisartxt, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonPesquisar_Estoque)
                .addContainerGap(427, Short.MAX_VALUE))
            .addGroup(Tela3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Tela3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1205, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        Tela3Layout.setVerticalGroup(
            Tela3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tela3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(Tela3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ppesquisartxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonPesquisar_Estoque))
                .addContainerGap(570, Short.MAX_VALUE))
            .addGroup(Tela3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Tela3Layout.createSequentialGroup()
                    .addGap(0, 64, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Estoque", Tela3);

        TrashCantxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TrashCantxtKeyPressed(evt);
            }
        });

        TrashCanTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Valor de Venda", "Valor de Compra", "Data de Registro", "Data de Vencimento", "Descrição", "Prioridade", "Marca", "Quantidade", "Imagem"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TrashCanTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrashCanTabelaMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(TrashCanTabela);

        TrashCanButtonPesquisar.setText("Pesquisar");
        TrashCanButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrashCanButtonPesquisarActionPerformed(evt);
            }
        });

        esvaziar_lixeira.setText("Esvaziar Lixeira");
        esvaziar_lixeira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esvaziar_lixeiraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Tela5Layout = new javax.swing.GroupLayout(Tela5);
        Tela5.setLayout(Tela5Layout);
        Tela5Layout.setHorizontalGroup(
            Tela5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tela5Layout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addComponent(TrashCantxt, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TrashCanButtonPesquisar)
                .addGap(67, 67, 67)
                .addComponent(esvaziar_lixeira, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(Tela5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Tela5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1205, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        Tela5Layout.setVerticalGroup(
            Tela5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tela5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(Tela5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TrashCantxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TrashCanButtonPesquisar)
                    .addComponent(esvaziar_lixeira))
                .addContainerGap(570, Short.MAX_VALUE))
            .addGroup(Tela5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Tela5Layout.createSequentialGroup()
                    .addGap(0, 64, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Lixeira", Tela5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ButtonProdutosSalvar_Cancel.setVisible(false);
        ButtonProdutosSalvar.setVisible(false);
        ButtonVendasSalvar_Cancel.setVisible(false);
        ButtonVendasSalvar.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        listar();
        id_invisible.setVisible(false);
        id_invisibleProduct.setVisible(false);
    }//GEN-LAST:event_formWindowActivated

    private void ButtonProdutosSalvar_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonProdutosSalvar_CancelActionPerformed
        ButtonProdutosSalvar_Cancel.setVisible(false);
        ButtonProdutosSalvar.setVisible(false);
        ButtonProdutosCadastrar.setVisible(true);

        id_invisibleProduct.setText(String.valueOf(""));
        Pprodutotxt.setText("");
        Pvendatxt.setText("");
        Pcompratxt.setText("");
        Pdatatxt.setText("");
        Pdatavencimentotxt.setText("");
        Pdescricaotxt.setText("");
        Pprioridadetxt.setSelectedIndex(0);
        Pmarcatxt.setText("");
        Pquantidadetxt.setValue(0);
        Imageview.setIcon(null);
    }//GEN-LAST:event_ButtonProdutosSalvar_CancelActionPerformed

    private void ButtonProdutosSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonProdutosSalvarActionPerformed
        if (Pprodutotxt.getText().isEmpty() || Pvendatxt.getText().isEmpty() || Pcompratxt.getText().isEmpty() || Pdatatxt.getText().isEmpty()
                || Pdatavencimentotxt.getText().isEmpty() || Pdescricaotxt.getText().isEmpty() || Pmarcatxt.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Preencha todos os campos e imagem .");

        } else {
            estoque.setId(Integer.parseInt(id_invisibleProduct.getText()));
            estoque.setNome(Pprodutotxt.getText());
            estoque.setVenda(Pvendatxt.getText());
            estoque.setCompra(Pcompratxt.getText());
            estoque.setData(Pdatatxt.getText());
            estoque.setVencimento(Pdatavencimentotxt.getText());
            estoque.setDescricao(Pdescricaotxt.getText());
            estoque.setPrioridade(Pprioridadetxt.getSelectedItem().toString());
            estoque.setMarca(Pmarcatxt.getText());
            estoque.setQuantidade(Integer.parseInt(Pquantidadetxt.getValue().toString()));
            if (imagem != null) {
                estoque.setImagem(ManipularImagem.getImgBytes(imagem));
            }

            estoqueDAO.alterarProduto(estoque);
            apagar.limpaTela(Tela2);
            Pdescricaotxt.setText(null);
            Pquantidadetxt.setValue(1);
            Imageview.setIcon(null);
            imagem = null;

            jTabbedPane1.setSelectedIndex(3);
            ButtonProdutosCadastrar.setVisible(true);
            ButtonProdutosSalvar.setVisible(false);
            ButtonProdutosSalvar_Cancel.setVisible(false);
        }
    }//GEN-LAST:event_ButtonProdutosSalvarActionPerformed

    private void ButtonProdutosCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonProdutosCadastrarActionPerformed

        if (Pprodutotxt.getText().isEmpty() || Pvendatxt.getText().isEmpty() || Pcompratxt.getText().isEmpty() || Pdatatxt.getText().isEmpty()
                || Pdatavencimentotxt.getText().isEmpty() || Pdescricaotxt.getText().isEmpty() || Pmarcatxt.getText().isEmpty() || imagem == null) {

            JOptionPane.showMessageDialog(null, "Preencha todos os campos .");
        } else {
            try {
                estoque.setNome(Pprodutotxt.getText());
                estoque.setVenda(Pvendatxt.getText());
                estoque.setCompra(Pcompratxt.getText());
                estoque.setData(Pdatatxt.getText());
                estoque.setVencimento(Pdatavencimentotxt.getText());
                estoque.setDescricao(Pdescricaotxt.getText());
                estoque.setPrioridade(Pprioridadetxt.getSelectedItem().toString());
                estoque.setMarca(Pmarcatxt.getText());
                estoque.setQuantidade(Integer.parseInt(Pquantidadetxt.getValue().toString()));
                estoque.setImagem(ManipularImagem.getImgBytes(imagem));

                estoqueDAO.cadastrarProduto(estoque, "estoque", true);
                Imageview.setIcon(null);
                imagem = null;
                apagar.limpaTela(Tela2);
                Pdescricaotxt.setText("");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado " + e);
            }
        }
    }//GEN-LAST:event_ButtonProdutosCadastrarActionPerformed

    private void PdatavencimentotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PdatavencimentotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PdatavencimentotxtActionPerformed

    private void PprioridadetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PprioridadetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PprioridadetxtActionPerformed

    private void PdatatxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PdatatxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PdatatxtActionPerformed

    private void TBEstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBEstoqueMouseClicked
        int id = (int) (TBEstoque.getValueAt(TBEstoque.getSelectedRow(), 0));
        String produto = (TBEstoque.getValueAt(TBEstoque.getSelectedRow(), 1).toString());
        String venda = (TBEstoque.getValueAt(TBEstoque.getSelectedRow(), 2).toString());
        String compra = (TBEstoque.getValueAt(TBEstoque.getSelectedRow(), 3).toString());
        String data_registro = (TBEstoque.getValueAt(TBEstoque.getSelectedRow(), 4).toString());
        String data_vencimento = (TBEstoque.getValueAt(TBEstoque.getSelectedRow(), 5).toString());
        String descricao = (TBEstoque.getValueAt(TBEstoque.getSelectedRow(), 6).toString());
        String prioridade = (TBEstoque.getValueAt(TBEstoque.getSelectedRow(), 7).toString());
        String marca = (TBEstoque.getValueAt(TBEstoque.getSelectedRow(), 8).toString());
        Object quantidade = (TBEstoque.getValueAt(TBEstoque.getSelectedRow(), 9));
        byte[] imagemSalvar = (byte[]) TBEstoque.getValueAt(TBEstoque.getSelectedRow(), 10);
        estoque.setImagem(imagemSalvar);

        Object[] options = new Object[]{
            "Deletar",
            "Editar",
            "Visualizar imagem",
            "Cancelar"
        };
        int escolha = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "ATENÇÃO", WIDTH, HEIGHT, null, options, NORMAL);
        Object[] options2 = new Object[]{
            "Confirmar",
            "Cancelar"
        };
        switch (escolha) {
            case 0:

                int id_confirm = JOptionPane.showOptionDialog(null, "Você está prestes a deletar um armazenamento com nome: " + produto
                        + "\nregistrado em: " + data_registro + " \n\nTem certeza?", "Atenção", WIDTH, HEIGHT, null, options2, NORMAL);
                if (id_confirm == 0) {

                    estoque.setId(id);
                    estoque.setNome(produto);
                    estoque.setVenda(venda);
                    estoque.setCompra(compra);
                    estoque.setData(data_registro);
                    estoque.setVencimento(data_vencimento);
                    estoque.setDescricao(descricao);
                    estoque.setPrioridade(prioridade);
                    estoque.setMarca(marca);
                    estoque.setQuantidade((int) quantidade);
                    estoque.setImagem(imagemSalvar);
                    estoqueDAO.cadastrarProduto(estoque, "lixeira", false);
                    estoqueDAO.excluirProduto(estoque, "estoque", true);
                }
                break;

            case 1:

                ButtonProdutosSalvar.setVisible(true);
                ButtonProdutosSalvar_Cancel.setVisible(true);
                jTabbedPane1.setSelectedIndex(1);

                id_invisibleProduct.setText(String.valueOf(id));
                Pprodutotxt.setText(produto);
                Pvendatxt.setText(venda);
                Pcompratxt.setText(compra);
                Pdatatxt.setText(data_registro);
                Pdatavencimentotxt.setText(data_vencimento);
                Pdescricaotxt.setText(descricao);
                Pprioridadetxt.setSelectedItem(prioridade);
                Pmarcatxt.setText(marca);
                Pquantidadetxt.setValue(quantidade);
                Imageview.setIcon(new ImageIcon(estoque.getImagem()));

                ButtonProdutosCadastrar.setVisible(false);
                break;
            case 2:
                JLabel image_view = new JLabel();
                JFrame img = new JFrame();
                img.setSize(600, 500);
                image_view.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                image_view.setVerticalAlignment((int) CENTER_ALIGNMENT);
                img.add(image_view);
                img.setDefaultCloseOperation(HIDE_ON_CLOSE);
                img.setLocationRelativeTo(this);
                img.setVisible(true);

                ManipularImagem.exibiImagemLabel(estoque.getImagem(), image_view);

        }
    }//GEN-LAST:event_TBEstoqueMouseClicked

    private void TBVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBVendasMouseClicked

        int id = (int) (TBVendas.getValueAt(TBVendas.getSelectedRow(), 0));
        String cliente = (TBVendas.getValueAt(TBVendas.getSelectedRow(), 1).toString());
        String produto = (TBVendas.getValueAt(TBVendas.getSelectedRow(), 2).toString());
        String endereco = (TBVendas.getValueAt(TBVendas.getSelectedRow(), 3).toString());
        String telefone = (TBVendas.getValueAt(TBVendas.getSelectedRow(), 4).toString());
        String compra = (TBVendas.getValueAt(TBVendas.getSelectedRow(), 5).toString());
        String venda = (TBVendas.getValueAt(TBVendas.getSelectedRow(), 6).toString());
        String cep = (TBVendas.getValueAt(TBVendas.getSelectedRow(), 7).toString());
        String data = (TBVendas.getValueAt(TBVendas.getSelectedRow(), 8).toString());
        String pagamento = (TBVendas.getValueAt(TBVendas.getSelectedRow(), 9).toString());
        int quantidade = (int) (TBVendas.getValueAt(TBVendas.getSelectedRow(), 10));

        Object[] options = new Object[]{
            "Deletar",
            "Editar",
            "Cancelar"
        };
        int escolha = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "ATENÇÃO", WIDTH, HEIGHT, null, options, NORMAL);
        Object[] options2 = new Object[]{
            "Confirmar",
            "Cancelar"
        };
        switch (escolha) {
            case 0:

                int id_confirm = JOptionPane.showOptionDialog(null, "Você está prestes a deletar uma venda com nome: " + produto
                        + "\nregistrado em: " + data + " \n\nTem certeza?", "Atenção", WIDTH, HEIGHT, null, options2, NORMAL);
                if (id_confirm == 0) {
                    vendas.setId(id);

                    vendasDAO.excluirVenda(vendas);
                }
                break;

            case 1:

                ButtonVendasSalvar.setVisible(true);
                ButtonVendasSalvar_Cancel.setVisible(true);
                jTabbedPane1.setSelectedIndex(0);

                id_invisible.setText(String.valueOf(id));
                Vclientestxt.setText(cliente);
                Vprodutotxt.setText(produto);
                Venderecotxt.setText(endereco);
                Vtelefonetxt.setText(telefone);
                Vcompratxt.setText(compra);
                Vvendatxt.setText(venda);
                Vceptxt.setText(cep);
                Vdatatxt.setText(data);
                Vpagamentotxt.setSelectedItem(pagamento);
                Vquantidadetxt.setValue(String.valueOf(quantidade));

                ButtonVendasCadastrar.setVisible(false);
                break;
        }
    }//GEN-LAST:event_TBVendasMouseClicked

    private void PquantidadetxtStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_PquantidadetxtStateChanged
        if (Pquantidadetxt.getValue().toString().equals("0")) {
            Pquantidadetxt.setValue(1);
        }
    }//GEN-LAST:event_PquantidadetxtStateChanged

    private void ButtonPesquisar_VendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPesquisar_VendasActionPerformed
        String filtro = "%" + Vpesquisartxt.getText() + "%";

        List<SaleProducts> lista = vendasDAO.consultaPorNome(filtro);

        DefaultTableModel dados = (DefaultTableModel) TBVendas.getModel();
        dados.setNumRows(0);

        for (SaleProducts vendas : lista) {
            dados.addRow(new Object[]{
                vendas.getId(),
                vendas.getCliente(),
                vendas.getProduto(),
                vendas.getEndereco(),
                vendas.getTelefone(),
                vendas.getCompra(),
                vendas.getVenda(),
                vendas.getCep(),
                vendas.getData(),
                vendas.getPagamento(),
                vendas.getQuantidade(),});

        }
    }//GEN-LAST:event_ButtonPesquisar_VendasActionPerformed

    private void ButtonPesquisar_EstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPesquisar_EstoqueActionPerformed
        String filtro = "%" + Ppesquisartxt.getText() + "%";

        List<StockProducts> lista = estoqueDAO.consultaPorNome(filtro, "estoque");

        DefaultTableModel dados = (DefaultTableModel) TBVendas.getModel();
        dados.setNumRows(0);

        for (StockProducts estoque : lista) {
            dados.addRow(new Object[]{
                estoque.getId(),
                estoque.getNome(),
                estoque.getCompra(),
                estoque.getData(),
                estoque.getVencimento(),
                estoque.getDescricao(),
                estoque.getPrioridade(),
                estoque.getMarca(),
                estoque.getQuantidade(),});

        }
    }//GEN-LAST:event_ButtonPesquisar_EstoqueActionPerformed

    private void PpesquisartxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PpesquisartxtKeyPressed
        String filtro = "%" + Ppesquisartxt.getText() + "%";

        List<StockProducts> lista = estoqueDAO.consultaPorNome(filtro, "estoque");

        DefaultTableModel dados = (DefaultTableModel) TBVendas.getModel();
        dados.setNumRows(0);

        for (StockProducts estoque : lista) {
            dados.addRow(new Object[]{
                estoque.getId(),
                estoque.getNome(),
                estoque.getCompra(),
                estoque.getData(),
                estoque.getVencimento(),
                estoque.getDescricao(),
                estoque.getPrioridade(),
                estoque.getMarca(),
                estoque.getQuantidade(),});

        }
    }//GEN-LAST:event_PpesquisartxtKeyPressed

    private void VpesquisartxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VpesquisartxtKeyPressed
        String filtro = "%" + Vpesquisartxt.getText() + "%";

        List<SaleProducts> lista = vendasDAO.consultaPorNome(filtro);

        DefaultTableModel dados = (DefaultTableModel) TBVendas.getModel();
        dados.setNumRows(0);

        for (SaleProducts vendas : lista) {
            dados.addRow(new Object[]{
                vendas.getId(),
                vendas.getCliente(),
                vendas.getProduto(),
                vendas.getEndereco(),
                vendas.getTelefone(),
                vendas.getCompra(),
                vendas.getVenda(),
                vendas.getCep(),
                vendas.getData(),
                vendas.getPagamento(),
                vendas.getQuantidade(),});

        }
    }//GEN-LAST:event_VpesquisartxtKeyPressed

    private void VquantidadetxtStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_VquantidadetxtStateChanged
        if (Vquantidadetxt.getValue().toString().equals("0")) {
            Vquantidadetxt.setValue(1);
        }
    }//GEN-LAST:event_VquantidadetxtStateChanged

    private void ButtonVendasSalvar_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVendasSalvar_CancelActionPerformed
        ButtonVendasCadastrar.setVisible(true);
        ButtonVendasSalvar.setVisible(false);
        ButtonVendasSalvar_Cancel.setVisible(false);

        id_invisible.setText(String.valueOf(""));
        Vclientestxt.setText("");
        Vprodutotxt.setText("");
        Venderecotxt.setText("");
        Vtelefonetxt.setText("");
        Vcompratxt.setText("");
        Vvendatxt.setText("");
        Vceptxt.setText("");
        Vdatatxt.setText("");
        Vpagamentotxt.setSelectedIndex(0);
        Vquantidadetxt.setValue(String.valueOf(""));
    }//GEN-LAST:event_ButtonVendasSalvar_CancelActionPerformed

    private void ButtonVendasSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVendasSalvarActionPerformed

        if (Vclientestxt.getText().isEmpty() || Vprodutotxt.getText().isEmpty() || Venderecotxt.getText().isEmpty() || Vtelefonetxt.getText().isEmpty()
                || Vcompratxt.getText().isEmpty() || Vvendatxt.getText().isEmpty() || Vceptxt.getText().isEmpty() || Vdatatxt.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Preencha todos os campos .");

        } else {
            vendas.setId(Integer.parseInt(id_invisible.getText()));
            vendas.setCliente(Vclientestxt.getText());
            vendas.setProduto(Vprodutotxt.getText());
            vendas.setEndereco(Venderecotxt.getText());
            vendas.setTelefone(Vtelefonetxt.getText());
            vendas.setCompra(Vcompratxt.getText());
            vendas.setVenda(Vvendatxt.getText());
            vendas.setCep(Vceptxt.getText());
            vendas.setData(Vdatatxt.getText());
            vendas.setPagamento(Vpagamentotxt.getSelectedItem().toString());
            vendas.setQuantidade(Integer.parseInt(Vquantidadetxt.getValue().toString()));

            vendasDAO.alterarCliente(vendas);
            apagar.limpaTela(Tela1);
            Vpagamentotxt.setSelectedIndex(0);

            jTabbedPane1.setSelectedIndex(2);
            ButtonVendasCadastrar.setVisible(true);
            ButtonVendasSalvar.setVisible(false);
            ButtonVendasSalvar_Cancel.setVisible(false);
        }
    }//GEN-LAST:event_ButtonVendasSalvarActionPerformed

    private void VceptxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VceptxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VceptxtActionPerformed

    private void VclientestxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VclientestxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VclientestxtActionPerformed

    private void ButtonVendasCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVendasCadastrarActionPerformed

        if (Vclientestxt.getText().isEmpty() || Vprodutotxt.getText().isEmpty() || Venderecotxt.getText().isEmpty() || Vtelefonetxt.getText().isEmpty()
                || Vcompratxt.getText().isEmpty() || Vvendatxt.getText().isEmpty() || Vceptxt.getText().isEmpty() || Vdatatxt.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Preencha todos os campos .");

        } else {
            vendas.setCliente(Vclientestxt.getText());
            vendas.setProduto(Vprodutotxt.getText());
            vendas.setEndereco(Venderecotxt.getText());
            vendas.setTelefone(Vtelefonetxt.getText());
            vendas.setCompra(Vcompratxt.getText());
            vendas.setVenda(Vvendatxt.getText());
            vendas.setCep(Vceptxt.getText());
            vendas.setData(Vdatatxt.getText());
            vendas.setPagamento(Vpagamentotxt.getSelectedItem().toString());
            vendas.setQuantidade(Integer.parseInt(Vquantidadetxt.getValue().toString()));

            SaleProductsDAO sale = new SaleProductsDAO();
            sale.cadastrarClientes(vendas);

            apagar.limpaTela(Tela1);
        }
    }//GEN-LAST:event_ButtonVendasCadastrarActionPerformed

    private void VtelefonetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VtelefonetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VtelefonetxtActionPerformed

    private void VdatatxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VdatatxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VdatatxtActionPerformed

    private void VcompratxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VcompratxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VcompratxtActionPerformed

    private void VvendatxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VvendatxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VvendatxtActionPerformed

    private void btnImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagemActionPerformed
        JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();

            try {
                imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath());

                Imageview.setIcon(new ImageIcon(imagem));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar imagem " + ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
        }
    }//GEN-LAST:event_btnImagemActionPerformed

    private void TrashCantxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TrashCantxtKeyPressed
        String filtro = "%" + Ppesquisartxt.getText() + "%";

        List<StockProducts> lista = estoqueDAO.consultaPorNome(filtro, "lixeira");

        DefaultTableModel dados = (DefaultTableModel) TBVendas.getModel();
        dados.setNumRows(0);

        for (StockProducts estoque : lista) {
            dados.addRow(new Object[]{
                estoque.getId(),
                estoque.getNome(),
                estoque.getCompra(),
                estoque.getData(),
                estoque.getVencimento(),
                estoque.getDescricao(),
                estoque.getPrioridade(),
                estoque.getMarca(),
                estoque.getQuantidade(),});

        }
    }//GEN-LAST:event_TrashCantxtKeyPressed

    private void TrashCanTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrashCanTabelaMouseClicked
        int id = (int) (TrashCanTabela.getValueAt(TrashCanTabela.getSelectedRow(), 0));
        String produto = (TrashCanTabela.getValueAt(TrashCanTabela.getSelectedRow(), 1).toString());
        String venda = (TrashCanTabela.getValueAt(TrashCanTabela.getSelectedRow(), 2).toString());
        String compra = (TrashCanTabela.getValueAt(TrashCanTabela.getSelectedRow(), 3).toString());
        String data_registro = (TrashCanTabela.getValueAt(TrashCanTabela.getSelectedRow(), 4).toString());
        String data_vencimento = (TrashCanTabela.getValueAt(TrashCanTabela.getSelectedRow(), 5).toString());
        String descricao = (TrashCanTabela.getValueAt(TrashCanTabela.getSelectedRow(), 6).toString());
        String prioridade = (TrashCanTabela.getValueAt(TrashCanTabela.getSelectedRow(), 7).toString());
        String marca = (TrashCanTabela.getValueAt(TrashCanTabela.getSelectedRow(), 8).toString());
        Object quantidade = (TrashCanTabela.getValueAt(TrashCanTabela.getSelectedRow(), 9));
        byte[] imagemRecovery = (byte[]) TrashCanTabela.getValueAt(TrashCanTabela.getSelectedRow(), 10);

        Object[] options = new Object[]{
            "Deletar",
            "Recuperar",
            "Visualizar imagem",
            "Cancelar"
        };
        int escolha = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "ATENÇÃO", WIDTH, HEIGHT, null, options, NORMAL);
        Object[] options2 = new Object[]{
            "Confirmar",
            "Cancelar"
        };
        switch (escolha) {
            case 0:

                int id_confirm = JOptionPane.showOptionDialog(null, "Excluir item permamenente?", "Atenção", WIDTH, HEIGHT, null, options2, NORMAL);
                if (id_confirm == 0) {
                    estoque.setId(id);

                    estoqueDAO.excluirProduto(estoque, "lixeira", true);
                }
                break;
            case 1:

                estoque.setId(id);
                estoque.setNome(produto);
                estoque.setVenda(venda);
                estoque.setCompra(compra);
                estoque.setData(data_registro);
                estoque.setVencimento(data_vencimento);
                estoque.setDescricao(descricao);
                estoque.setPrioridade(prioridade);
                estoque.setMarca(marca);
                estoque.setQuantidade((int) quantidade);
                estoque.setImagem(imagemRecovery);
                estoqueDAO.cadastrarProduto(estoque, "estoque", false);
                estoqueDAO.excluirProduto(estoque, "lixeira", false);
                break;

            case 2:
                JLabel image_view = new JLabel();
                JFrame img = new JFrame();
                img.setSize(600, 500);
                image_view.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                image_view.setVerticalAlignment((int) CENTER_ALIGNMENT);
                img.add(image_view);
                img.setDefaultCloseOperation(HIDE_ON_CLOSE);
                img.setLocationRelativeTo(this);
                img.setVisible(true);

                ManipularImagem.exibiImagemLabel(estoque.getImagem(), image_view);
                break;

        }
    }//GEN-LAST:event_TrashCanTabelaMouseClicked

    private void TrashCanButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrashCanButtonPesquisarActionPerformed
        String filtro = "%" + Ppesquisartxt.getText() + "%";

        List<StockProducts> lista = estoqueDAO.consultaPorNome(filtro, "lixeira");

        DefaultTableModel dados = (DefaultTableModel) TBVendas.getModel();
        dados.setNumRows(0);

        for (StockProducts estoque : lista) {
            dados.addRow(new Object[]{
                estoque.getId(),
                estoque.getNome(),
                estoque.getCompra(),
                estoque.getData(),
                estoque.getVencimento(),
                estoque.getDescricao(),
                estoque.getPrioridade(),
                estoque.getMarca(),
                estoque.getQuantidade(),});

        }
    }//GEN-LAST:event_TrashCanButtonPesquisarActionPerformed

    private void esvaziar_lixeiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esvaziar_lixeiraActionPerformed
        estoqueDAO.esvaziarLixeira();
        listar();
       
            
    }//GEN-LAST:event_esvaziar_lixeiraActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrmPainel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmPainel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmPainel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmPainel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrmPainel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonPesquisar_Estoque;
    private javax.swing.JButton ButtonPesquisar_Vendas;
    private javax.swing.JButton ButtonProdutosCadastrar;
    private javax.swing.JButton ButtonProdutosSalvar;
    private javax.swing.JButton ButtonProdutosSalvar_Cancel;
    private javax.swing.JButton ButtonVendasCadastrar;
    private javax.swing.JButton ButtonVendasSalvar;
    private javax.swing.JButton ButtonVendasSalvar_Cancel;
    private javax.swing.JLabel Imageview;
    private javax.swing.JTextField Pcompratxt;
    private javax.swing.JFormattedTextField Pdatatxt;
    private javax.swing.JFormattedTextField Pdatavencimentotxt;
    private javax.swing.JTextArea Pdescricaotxt;
    private javax.swing.JTextField Pmarcatxt;
    private javax.swing.JTextField Ppesquisartxt;
    private javax.swing.JComboBox<String> Pprioridadetxt;
    private javax.swing.JTextField Pprodutotxt;
    private javax.swing.JSpinner Pquantidadetxt;
    private javax.swing.JTextField Pvendatxt;
    private javax.swing.JTable TBEstoque;
    private javax.swing.JTable TBVendas;
    private javax.swing.JPanel Tela1;
    private javax.swing.JPanel Tela2;
    private javax.swing.JPanel Tela3;
    private javax.swing.JPanel Tela4;
    private javax.swing.JPanel Tela5;
    private javax.swing.JButton TrashCanButtonPesquisar;
    private javax.swing.JTable TrashCanTabela;
    private javax.swing.JTextField TrashCantxt;
    private javax.swing.JFormattedTextField Vceptxt;
    private javax.swing.JTextField Vclientestxt;
    private javax.swing.JTextField Vcompratxt;
    private javax.swing.JFormattedTextField Vdatatxt;
    private javax.swing.JTextField Venderecotxt;
    private javax.swing.JComboBox<String> Vpagamentotxt;
    private javax.swing.JTextField Vpesquisartxt;
    private javax.swing.JTextField Vprodutotxt;
    private javax.swing.JSpinner Vquantidadetxt;
    private javax.swing.JFormattedTextField Vtelefonetxt;
    private javax.swing.JTextField Vvendatxt;
    private javax.swing.JButton btnImagem;
    private javax.swing.JButton esvaziar_lixeira;
    private javax.swing.JTextField id_invisible;
    private javax.swing.JTextField id_invisibleProduct;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

}
