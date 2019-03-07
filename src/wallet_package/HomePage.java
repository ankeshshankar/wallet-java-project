/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wallet_package;
import java.awt.Color;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;//PieChart;
import javafx.scene.chart.PieChartBuilder;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author i quit techno
 */
public final class HomePage extends javax.swing.JFrame {
           public static int mon =1 ;
           public static int mon2 = 12;
           public static int acc1 = 1;
           public static int acc2 = 2;
           public static int item1 = 1;
           public static int item2 = 6;
           public static float t_income =0;
           private static float am=0;
           public static float m_budget;
           public static float e_amount,pro_amount = 0;
 //          public static String curr_month;
           
    /**
     * Creates new form HomePage
     * @throws java.sql.SQLException
     */
    public HomePage() throws SQLException {
        initComponents();
       // String acc_name = jLabel6.getText();
        LoadIncome();   
       // daily_pie();
        ShowBudget();
        Show_income_bank();
        Show_Expence_data();
        LoadExpence();
        LoadBudget();
        MonthName();
       

    }
    public void MonthName(){
         String month_name = jLabel7.getText();
          new AddExpence(month_name);
    }
    public static void Clear_table(){
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        model.fireTableDataChanged();
    }
    public static ArrayList<Bank_income> Bank() throws SQLException{
        ArrayList<Bank_income> Bank = new ArrayList<>();
                    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Wallet_Database", "wallet", "12345");
                  Statement st = con.createStatement();
                  ResultSet rs = st.executeQuery("SELECT * FROM BANK_ACCOUNT");
                  Bank_income bank1;
                  while(rs.next()){
                      bank1 = new Bank_income(rs.getString("B_NAME"),rs.getFloat("B_BALANCE"));
                      Bank.add(bank1);
                  }
                  return Bank;       
    }
    public static void Show_income_bank()throws SQLException{
        ArrayList<Bank_income> list = Bank();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setColumnCount(0);
        model.addColumn("Bank Name");
        model.addColumn("Balence");
        Object[] row = new Object[2];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getbank_name();
            row[1] = list.get(i).getbank_balence();
            model.addRow(row);
        }
        
    }
    
    public static ArrayList<Cash_income> Cash() throws SQLException{
        ArrayList<Cash_income> Cash = new ArrayList<>();
                    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Wallet_Database", "wallet", "12345");
                  Statement st = con.createStatement();
                  ResultSet rs = st.executeQuery("SELECT * FROM CASH_ACCOUNT");
                  Cash_income cash1;
                  while(rs.next()){
                      cash1 = new Cash_income(rs.getFloat("C_BALANCE"));
                      Cash.add(cash1);
                  }
                  return Cash;       
    }
    public static void Show_income_cash()throws SQLException{
        ArrayList<Cash_income> list = Cash();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        Object[] row = new Object[2];
        model.setColumnCount(0);
        model.addColumn("Balence");
       // jTable2.getColumnModel().
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getcash_balence();
            model.addRow(row);
        }
        
    }
    public static void LoadIncome(){
        Connection con;
               try {
                  con = DriverManager.getConnection("jdbc:derby://localhost:1527/Wallet_Database", "wallet", "12345");
                  Statement st = con.createStatement();
                  ResultSet rs = st.executeQuery("SELECT * FROM BANK_ACCOUNT");
                  Statement st1 = con.createStatement();
                  ResultSet rs1 = st1.executeQuery("SELECT * FROM CASH_ACCOUNT");
                  while(rs.next()){
                    //  jTable2.setModel(rs);
                      float x = Float.valueOf(rs.getString(2));
                      t_income = t_income + x;
                        //total_income.setText(String.valueOf(x));
                  }
                  while(rs1.next()){
                      float x1 = Float.valueOf(rs1.getString(1));
                      t_income = t_income + x1;
                  }
                  total_income.setText(String.valueOf(t_income));
                  jLabel4.setText(String.valueOf(t_income));
                  t_income = 0;
               } catch (SQLException ex) {
                   Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
               }
    }
    public static void LoadExpence(){
        jLabel5.setText("000");
               try {
                   
                   String month = jLabel7.getText();
                   Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Wallet_Database", "wallet", "12345");
                   Statement st = con.createStatement();
                   ResultSet rs = st.executeQuery("SELECT E_AMOUNT FROM EXPENCE_ACCOUNT WHERE E_MONTH ='"+month+"'");
                   while(rs.next()){
                       am  = rs.getFloat(1);
                       e_amount = am + e_amount; 
                   }
                   jLabel5.setText(String.valueOf(e_amount));
                   e_amount = 0;
                   
               } catch (SQLException ex) {
                   Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
               }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        total_income = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Wallet ");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane4.setAutoscrolls(true);

        jPanel1.setPreferredSize(new java.awt.Dimension(2828, 528));
        jPanel1.setLayout(null);

        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 2, true));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category", "Date", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(470, 160, 350, 200);

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("January");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(50, 90, 230, 60);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wallet_package/search.png"))); // NOI18N
        jPanel1.add(jLabel11);
        jLabel11.setBounds(860, 260, 30, 30);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wallet_package/analize.png"))); // NOI18N
        jPanel1.add(jLabel10);
        jLabel10.setBounds(850, 150, 30, 30);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wallet_package/export (1).png"))); // NOI18N
        jPanel1.add(jLabel9);
        jLabel9.setBounds(860, 190, 30, 30);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Month Budget");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(640, 40, 120, 20);

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel5.setForeground(java.awt.Color.red);
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("00000");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 290, 140, 20);

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel4.setForeground(java.awt.Color.green);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("00000");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 210, 140, 20);

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Expence");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 250, 110, 20);

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Income");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 160, 100, 20);

        jProgressBar1.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jProgressBar1.setForeground(new java.awt.Color(255, 0, 51));
        jProgressBar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 2, true));
        jProgressBar1.setString(" + Add...");
        jProgressBar1.setStringPainted(true);
        jProgressBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jProgressBar1MouseClicked(evt);
            }
        });
        jPanel1.add(jProgressBar1);
        jProgressBar1.setBounds(560, 80, 270, 30);

        jTable2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 2, true));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.setColumnSelectionAllowed(true);
        jTable2.setSelectionBackground(new java.awt.Color(0, 153, 255));
        jScrollPane3.setViewportView(jTable2);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(1340, 210, 510, 210);

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Bank");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(980, 100, 180, 40);

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Total Balance ");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(980, 160, 190, 30);

        total_income.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        total_income.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total_income.setText("000000");
        jPanel1.add(total_income);
        total_income.setBounds(1000, 210, 140, 30);

        jButton1.setText("+ Add Income");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 2, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(1500, 90, 270, 30);

        jButton3.setText("+ Add Account");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 2, true));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(1500, 150, 270, 30);

        jLabel16.setText("Item Name : -");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(2470, 140, 100, 30);

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Electronics");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(1930, 110, 230, 50);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wallet_package/grater then.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(300, 110, 20, 30);

        jLabel20.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Total Items ");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(1940, 180, 150, 20);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wallet_package/less then.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(280, 110, 20, 30);

        jLabel21.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("0");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(1960, 220, 110, 20);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("jLabel22");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(2620, 140, 110, 30);

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wallet_package/less then.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(1210, 110, 20, 30);

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wallet_package/grater then.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(1230, 110, 20, 30);

        jButton4.setText(" + Add Item");
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 2, true));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(2480, 50, 270, 30);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wallet_package/grater then.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(2210, 120, 20, 30);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wallet_package/less then.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(2190, 120, 20, 30);

        jTable3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 2, true));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable3);

        jPanel1.add(jScrollPane5);
        jScrollPane5.setBounds(2280, 200, 480, 210);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wallet_package/dailymain.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 2828, 528);

        jScrollPane4.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void ShowBudget(){
       float e,per;
               try {
                   Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Wallet_Database", "wallet", "12345");
                   Statement st = con.createStatement();
                   ResultSet rs = st.executeQuery("SELECT B_AMOUNT FROM BUDGET WHERE B_MONTH ='"+jLabel7.getText()+"'");
                   while(rs.next()){
                       m_budget = rs.getFloat(1);
                   } 
                   Statement st1 = con.createStatement();
                   ResultSet rs1 = st1.executeQuery("SELECT E_AMOUNT FROM EXPENCE_ACCOUNT WHERE E_MONTH ='"+jLabel7.getText()+"'");
                   while(rs1.next()){
                       e = rs1.getFloat(1);  
                      pro_amount = e + pro_amount;
                   }
                   jProgressBar1.setString("+ Add           "+pro_amount+"/"+m_budget);
                   per = (pro_amount/m_budget)*100;
                   if(per > 1 && per <= 10){
                        jProgressBar1.setValue(10);
                        jProgressBar1.setForeground(Color.yellow);
                   }
                   else if(per > 10 && per <= 20){
                        jProgressBar1.setValue(20);
                        jProgressBar1.setForeground(Color.red);
                   }
                   else if(per > 20 && per <= 30){
                        jProgressBar1.setValue(30);
                        jProgressBar1.setForeground(Color.red);
                   }
                   else if(per > 30 && per <= 40){
                        jProgressBar1.setValue(40);
                       jProgressBar1.setForeground(Color.red);
                   }
                   else if(per > 40 && per <= 50){
                        jProgressBar1.setValue(50);
                        jProgressBar1.setForeground(Color.red);
                   }
                   else if(per > 50 && per <= 60){
                        jProgressBar1.setValue(60);
                        jProgressBar1.setForeground(Color.red);
                   }
                   else if(per > 60 && per <= 70){
                        jProgressBar1.setValue(70);
                       jProgressBar1.setForeground(Color.red);
                   }
                   else if(per > 70 && per <= 80){
                        jProgressBar1.setValue(80);
                       jProgressBar1.setForeground(Color.red);
                   }
                   else if(per > 80 && per <= 90){
                        jProgressBar1.setValue(90);
                        jProgressBar1.setForeground(Color.red);
                   }
                   else if(per > 90 && per <= 100){
                        jProgressBar1.setValue(100);
                        jProgressBar1.setForeground(Color.red);
                   }
                   
                   pro_amount = 0;
                  
                   //jProgressBar1.setValue(100);
               } catch (SQLException ex) {
                   Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
               }
    }
    
    
    public static void LoadBudget(){
               try {
                   Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Wallet_Database", "wallet", "12345");
                   Statement st = con.createStatement();
                   ResultSet rs = st.executeQuery("SELECT B_AMOUNT FROM BUDGET WHERE B_MONTH ='"+jLabel7.getText()+"'");
                   while(rs.next()){
                       m_budget = rs.getFloat(1);
                   } 
               } catch (SQLException ex) {
                   Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
               } 
    }    public static ArrayList<Expence_Account> Expence() throws SQLException{
        ArrayList<Expence_Account> Expence = new ArrayList<>();
                    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Wallet_Database", "wallet", "12345");
                  Statement st = con.createStatement();
                  ResultSet rs = st.executeQuery("SELECT * FROM EXPENCE_ACCOUNT WHERE E_MONTH ='"+jLabel7.getText()+"'");
                  Expence_Account expence1;
                  while(rs.next()){
                      expence1 = new Expence_Account(rs.getFloat("E_AMOUNT"),rs.getString("E_CATEGORY"),rs.getString("E_DATE"));
                      Expence.add(expence1);
                  }
                  return Expence;       
    }
    public static void Show_Expence_data() throws SQLException{
        ArrayList<Expence_Account> list = Expence();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getCategory();
            row[1] = list.get(i).getDate();
            row[2] = list.get(i).getAmount();
            model.addRow(row);
        }
        
    }
    
    public static void Clear_table1(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
    }
    
   // public static void daily_pie(){
   //     ObservableList<PieChart.Data> pieChartData;
   //            pieChartData = FXCollections.observableArrayList(
   //                    new PieChart.Data("Grapefruit", 13),
    //                   new PieChart.Data("Oranges", 25),
    //                   new PieChart.Data("Plums", 10),
    //                   new PieChart.Data("Pears", 22),
    //                   new PieChart.Data("Apples", 30));
    //             final PieChart chart = new PieChart(pieChartData);
    
        
        
   // }
    
    
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
         
         
      
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            try ( // TODO add your handling code here:
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Wallet_Database", "wallet", "12345")) {
                Statement st = con.createStatement();
                String budget = JOptionPane.showInputDialog("Enter your monthly budget ?? ");
                int x = st.executeUpdate("UPDATE BUDGET SET B_AMOUNT ="+(m_budget+Float.valueOf(budget))+"WHERE B_MONTH ='"+jLabel7.getText()+"'");
                ShowBudget();
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jProgressBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBar1MouseClicked
        // TODO add your handling code here:
        new AddExpence().setVisible(true);
    }//GEN-LAST:event_jProgressBar1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String value = jButton1.getText();
        if ("+ Add Income".equals(value)){
            new AddIncome().setVisible(true);
        } else {
            float cash = Float.valueOf(JOptionPane.showInputDialog("Enter your Cash Balance :- "));
            try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Wallet_Database", "wallet", "12345")) {
                Statement st = con.createStatement();
                ResultSet rs;
                rs = st.executeQuery("SELECT * FROM CASH_ACCOUNT");
                while(rs.next()){
                    am = Float.valueOf(rs.getString(1));
                }

                float total_cash = am + cash;
                int x = st.executeUpdate("UPDATE CASH_ACCOUNT SET C_BALANCE ="+total_cash);
                con.close();
                HomePage.Clear_table();
                HomePage.LoadIncome();
                HomePage.Show_income_cash();
            } catch (SQLException ex) {
                Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new AddAccount().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        switch(mon2){
            case 1: jLabel7.setText("January");
            mon2 = 12;mon = 2;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 2: jLabel7.setText("February");
            mon2 = 1;mon = 3;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 3: jLabel7.setText("March");
            mon2 = 2;mon = 4;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 4: jLabel7.setText("April");
            mon2 = 3;mon = 5;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 5: jLabel7.setText("May");
            mon2 = 4;mon = 6;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 6: jLabel7.setText("June");
            mon2 = 5;mon = 7;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {

                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 7: jLabel7.setText("July");
            mon2 = 6;mon = 8;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 8: jLabel7.setText("August");
            mon2 = 7;mon = 9;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 9: jLabel7.setText("September");
            mon2 = 8;mon = 10;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 10: jLabel7.setText("October");
            mon2 = 9;mon = 11;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 11: jLabel7.setText("November");
            mon2 = 10;mon = 12;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 12: jLabel7.setText("December");
            mon2 = 11;mon = 1;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        switch(mon){
            case 1: jLabel7.setText("January");
            mon = 2;mon2 = 12;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();

            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 2: jLabel7.setText("February");
            mon = 3;mon2 = 1;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();

            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            break;
            case 3: jLabel7.setText("March");
            mon = 4;mon2 = 2;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 4: jLabel7.setText("April");
            mon = 5;mon2 = 3;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 5: jLabel7.setText("May");
            mon = 6;mon2 = 4;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 6: jLabel7.setText("June");
            mon = 7;mon2 = 5;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 7: jLabel7.setText("July");
            mon = 8;mon2 = 6;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 8: jLabel7.setText("August");
            mon = 9;mon2 = 7;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 9: jLabel7.setText("September");
            mon = 10;mon2 = 8;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 10: jLabel7.setText("October");
            mon = 11;mon2 = 9;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 11: jLabel7.setText("November");
            mon = 12;mon2 = 10;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 12: jLabel7.setText("December");
            mon = 1;mon2 = 11;
            LoadBudget();
            ShowBudget();
            Clear_table1();
            LoadExpence();
            MonthName();
            {
                try {
                    Show_Expence_data();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
         switch(acc2){
            case 1: jLabel6.setText("Bank");
            acc1= 1;acc2=2;
            jButton3.setVisible(true);
            jButton1.setText("+ Add Income");
            {
                try {
                    Clear_table();
                    Show_income_bank();
                    LoadIncome();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            break;
            case 2: jLabel6.setText("Cash");
            acc1= 2;acc2=1;
            jButton1.setText("+ Add Cash");
            jButton3.setVisible(false);
            {
                try {
                    Clear_table();
                    Show_income_cash();
                    LoadIncome();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            break;
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
         switch(acc1){
            case 1: jLabel6.setText("Bank");
            acc1= 2;acc2=1;
            jButton3.setVisible(true);
            jButton1.setText("+ Add Income");

            {
                try {
                    Clear_table();
                    Show_income_bank();
                    LoadIncome();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            break;
            case 2: jLabel6.setText("Cash");
            acc1= 1;acc2=2;
            jButton1.setText("+ Add Cash");
            jButton3.setVisible(false);

            {
                try {
                    Clear_table();
                    Show_income_cash();
                    LoadIncome();
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        switch(item1){
            case 1: jLabel17.setText("Electronics");
            item1 = 6;item2 = 2;
            break;
            case 2: jLabel17.setText("Home");
            item1 = 1;item2 = 3;
            break;
            case 3: jLabel17.setText("Sports");
            item1 = 2;item2 = 4;
            break;
            case 4: jLabel17.setText("Books");
            item1 = 3;item2 = 5;
            break;
            case 5: jLabel17.setText("Vehicle");
            item1 = 4;item2 = 6;
            break;
            case 6: jLabel17.setText("Fashion");
            item1 = 5;item2 = 1;
            break;
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        switch(item1){
            case 1: jLabel17.setText("Electronics");
            item1 = 2;item2 = 6;
            break;
            case 2: jLabel17.setText("Home");
            item1 = 3;item2 = 1;
            break;
            case 3: jLabel17.setText("Sports");
            item1 = 4;item2 = 2;
            break;
            case 4: jLabel17.setText("Books");
            item1 = 5;item2 = 3;
            break;
            case 5: jLabel17.setText("Vehicle");
            item1 = 6;item2 = 4;
            break;
            case 6: jLabel17.setText("Fashion");
            item1 = 1;item2 = 5;
            break;
        }
    }//GEN-LAST:event_jButton10ActionPerformed
   // public ArrayList<Load_Label_Text> Label() 
            //Array
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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                // HomePage() h1 = new HomePage();
                
                new HomePage().setVisible(true);
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private static javax.swing.JLabel jLabel4;
    private static javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private static javax.swing.JTable jTable1;
    public static javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    public static javax.swing.JLabel total_income;
    // End of variables declaration//GEN-END:variables
}