
package codePackage;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

import java.text.SimpleDateFormat;


public class dashboardFrame extends javax.swing.JFrame {
   
    public dashboardFrame() {
        initComponents();
        parentpanel.setSelectedIndex(1);
        income_balance_show.setText(String.format("%,.0f", transaction.getIncomeBalance()));
        expense_total_show.setText(String.format("%, .0f", transaction.getExpenseBalance()));      
        
        homeIncomeShow.setText(String.format("%,.0f", transaction.getIncomeBalance()));
        homeExpenseShow.setText(String.format("%, .0f", transaction.getExpenseBalance()));
        
        AllTransactions();
        AllIncomeTransactions();
        AllExpensesTransactions();
        
        clearTextF();
        clearTextE();
    }
    
//    Converting from postgresql dat format to simpledateformat
    SimpleDateFormat customOutput = new  SimpleDateFormat("MMM/dd/yyyy");
    
//   Object for Class Transaction
    Transaction transaction = new Transaction();  
    
//   Private fields
    private String t_type;
    private String t_category;
    private double t_amount;
    private String t_date;
    private String t_desc;
    
    
    
    private void AllExpensesTransactions(){
        Connection conn;
        PreparedStatement preparedStatement;
        ResultSet resultSet;      
        
        try {
            conn = Transaction.getConnection();
            preparedStatement = conn.prepareStatement("SELECT * FROM transaction_tbl WHERE type = ?  ORDER BY id DESC;");
        
            preparedStatement.setString(1, "Expense");
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData Rsm = resultSet.getMetaData();
            
            int countr;
            countr = Rsm.getColumnCount();
            
            DefaultTableModel tableModel = (DefaultTableModel)expense_table.getModel();
            tableModel.setRowCount(0);
            
            while(resultSet.next()){
                
                Vector vector = new Vector();
                
                for(int i = 1; i <= countr; i++)
                {
                vector.add("TID0"+resultSet.getString("id"));
                vector.add(resultSet.getString("category"));
                vector.add(resultSet.getDouble("amount"));
                vector.add(customOutput.format(resultSet.getDate("date")));
                vector.add(resultSet.getString("description"));              
                }
                
                tableModel.addRow(vector);
                
            }
            
            } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(dashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
    
    private void AllIncomeTransactions(){
        Connection conn;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            
            conn = Transaction.getConnection();
            
            preparedStatement = conn.prepareStatement("SELECT * FROM transaction_tbl WHERE type = ?  ORDER BY id DESC;");
            preparedStatement.setString(1, "Income");
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData Rsm = resultSet.getMetaData();
            
            int countr;
            countr = Rsm.getColumnCount();
            
            DefaultTableModel tableModel = (DefaultTableModel)income_table.getModel();
            tableModel.setRowCount(0);
            
            while(resultSet.next()){
                
                Vector vector = new Vector();
                
                for(int i = 1; i <= countr; i++)
                {
                vector.add("TID0"+resultSet.getString("id"));
                vector.add(resultSet.getString("category"));
                vector.add(resultSet.getDouble("amount"));
                vector.add(customOutput.format(resultSet.getDate("date")));
                vector.add(resultSet.getString("description"));              
                }
                
                tableModel.addRow(vector);
                
            }
        }   catch (ClassNotFoundException ex) {
            Logger.getLogger(dashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(dashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    private void AllTransactions(){
        
        
        
        
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        try {
            conn = Transaction.getConnection();            
            pst = conn.prepareStatement("SELECT * FROM transaction_tbl ORDER BY id DESC;");
            rs = pst.executeQuery();
            ResultSetMetaData Rsm = rs.getMetaData();
            
            int countr;
            countr = Rsm.getColumnCount();
            
            DefaultTableModel tableModel = (DefaultTableModel)transactiontbl.getModel();
            tableModel.setRowCount(0);
            
            while(rs.next()){
                
                Vector vector = new Vector();
                
                for(int i = 1; i <= countr; i++)
                {
                vector.add("TID0"+rs.getString("id"));
                vector.add(rs.getString("type"));
                vector.add(rs.getString("category"));
                vector.add(rs.getDouble("amount"));
                vector.add(customOutput.format(rs.getDate("date")));
                vector.add(rs.getString("description"));
                

                
                }
                
                tableModel.addRow(vector);
                
            }
            
            
        

        }   catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(dashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
 
    private void addIncomeTransact(){
        
         if(income_category_txt.getText().isEmpty() && 
         income_amount_txt.getText().isEmpty() && ic_date_txt.getDate().toString().isEmpty() && 
         income_description_txt.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "All fields are requiered!", "Error", HEIGHT);
        }      
        else
         {
             
            t_type = trans_type_txt.getText();
            t_category = income_category_txt.getText();
            t_amount = Double.parseDouble(income_amount_txt.getText());
            t_date = ic_date_txt.getDate().toString();
            t_desc = income_description_txt.getText();
             
             
            transaction.setType(t_type);
            transaction.setCategory(t_category);
            transaction.setAmount(t_amount);
            transaction.setDate(t_date);
            transaction.setDescription(t_desc);

            transaction.AddTransaction();
            
                        
            JOptionPane.showMessageDialog(this, transaction.getMessage());
            
            income_balance_show.setText(String.format("%,.0f", transaction.getIncomeBalance()));
            expense_total_show.setText(String.format("%, .0f", transaction.getExpenseBalance()));      

            homeIncomeShow.setText(String.format("%,.0f", transaction.getIncomeBalance()));
            homeExpenseShow.setText(String.format("%, .0f", transaction.getExpenseBalance()));

            AllTransactions();
            AllIncomeTransactions();
            AllExpensesTransactions();
            
            clearTextF();
            
        }
        
    }
    
    private void addExpenseTransact(){        
        
        if(expense_category_txt.getText().isEmpty() && 
        expense_amount_txt.getText().isEmpty() && expense_date_txt.getDate().toString().isEmpty() && 
        expense_description_txt.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "All fields are requiered!");
        }
        else
        {
            
            t_type = trans_typetxt.getText();
            t_category = expense_category_txt.getText();
            t_amount = Double.parseDouble(expense_amount_txt.getText());
//            t_date = expense_date_txt.getDate();
            t_desc = expense_description_txt.getText();
            
            
            transaction.setType(t_type);
            transaction.setCategory(t_category);
            transaction.setAmount(t_amount);
            transaction.setDate(expense_date_txt.getDate().toString());
            transaction.setDescription(t_desc);

            transaction.AddTransaction();
            
                        
            JOptionPane.showMessageDialog(this, transaction.getMessage());
            
           
            income_balance_show.setText(String.format("%,.0f", transaction.getIncomeBalance()));
            expense_total_show.setText(String.format("%, .0f", transaction.getExpenseBalance()));      

            homeIncomeShow.setText(String.format("%,.0f", transaction.getIncomeBalance()));
            homeExpenseShow.setText(String.format("%, .0f", transaction.getExpenseBalance()));
            
            AllTransactions();
            AllIncomeTransactions();
            AllExpensesTransactions();
            
            clearTextE();
            
        }
        
    }
    
    private void clearTextF(){
        income_category_txt.setText("");
        income_amount_txt.setText("");
        ic_date_txt.setCalendar(null);
        income_description_txt.setText("");
    }
    
    private void clearTextE(){
        expense_category_txt.setText("");
        expense_amount_txt.setText("");
        expense_date_txt.setCalendar(null);
        expense_description_txt.setText("");
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        home = new javax.swing.JPanel();
        homtxtbtn = new javax.swing.JLabel();
        incomepanel = new javax.swing.JPanel();
        incobtn = new javax.swing.JLabel();
        expensepanel = new javax.swing.JPanel();
        exp_btn = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        stationerypanel = new javax.swing.JPanel();
        stati_btn = new javax.swing.JLabel();
        parentpanel = new javax.swing.JTabbedPane();
        expenseChild = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        trans_typetxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        expense_amount_txt = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        expense_category_txt = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        expense_description_txt = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        add_expense_btn = new javax.swing.JButton();
        update_expense_btn = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        expense_table = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        expense_total_show = new javax.swing.JLabel();
        expense_date_txt = new com.toedter.calendar.JDateChooser();
        homechild = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactiontbl = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        homeIncomeShow = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        homeExpenseShow = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        incomechild = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        income_table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        trans_type_txt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        income_category_txt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        income_amount_txt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        income_description_txt = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        ic_date_txt = new com.toedter.calendar.JDateChooser();
        add_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        income_balance_show = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Finance Manager");
        setResizable(false);

        mainpanel.setBackground(new java.awt.Color(204, 204, 204));
        mainpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assetsPackage/login.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        home.setBackground(new java.awt.Color(51, 51, 51));
        home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });

        homtxtbtn.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        homtxtbtn.setForeground(new java.awt.Color(204, 204, 204));
        homtxtbtn.setText("Home");
        homtxtbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homtxtbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(homtxtbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homtxtbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        incomepanel.setBackground(new java.awt.Color(102, 102, 102));
        incomepanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        incomepanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                incomepanelMouseMoved(evt);
            }
        });
        incomepanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                incomepanelMouseClicked(evt);
            }
        });

        incobtn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        incobtn.setForeground(new java.awt.Color(204, 204, 204));
        incobtn.setText("My Income");

        javax.swing.GroupLayout incomepanelLayout = new javax.swing.GroupLayout(incomepanel);
        incomepanel.setLayout(incomepanelLayout);
        incomepanelLayout.setHorizontalGroup(
            incomepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(incomepanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(incobtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        incomepanelLayout.setVerticalGroup(
            incomepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(incomepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(incobtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        expensepanel.setBackground(new java.awt.Color(102, 102, 102));
        expensepanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        expensepanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expensepanelMouseClicked(evt);
            }
        });

        exp_btn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        exp_btn.setForeground(new java.awt.Color(204, 204, 204));
        exp_btn.setText("My Expenses");
        exp_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exp_btnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout expensepanelLayout = new javax.swing.GroupLayout(expensepanel);
        expensepanel.setLayout(expensepanelLayout);
        expensepanelLayout.setHorizontalGroup(
            expensepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(expensepanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(exp_btn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        expensepanelLayout.setVerticalGroup(
            expensepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(expensepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exp_btn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assetsPackage/log-out.png"))); // NOI18N
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });

        stationerypanel.setBackground(new java.awt.Color(102, 102, 102));
        stationerypanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        stationerypanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stationerypanelMouseClicked(evt);
            }
        });

        stati_btn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        stati_btn.setForeground(new java.awt.Color(204, 204, 204));
        stati_btn.setText("Stationery");
        stati_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stati_btnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout stationerypanelLayout = new javax.swing.GroupLayout(stationerypanel);
        stationerypanel.setLayout(stationerypanelLayout);
        stationerypanelLayout.setHorizontalGroup(
            stationerypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stationerypanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(stati_btn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        stationerypanelLayout.setVerticalGroup(
            stationerypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stationerypanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stati_btn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(expensepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(incomepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(stationerypanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(incomepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(expensepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(stationerypanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addComponent(logout)
                .addGap(36, 36, 36))
        );

        mainpanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 650));

        expenseChild.setBackground(new java.awt.Color(204, 204, 204));

        jLabel17.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabel17.setText("Transaction Type:");

        trans_typetxt.setEditable(false);
        trans_typetxt.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        trans_typetxt.setText("Expense");

        jLabel18.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabel18.setText("Amount:");

        expense_amount_txt.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N

        jLabel19.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabel19.setText("Date:");

        jLabel20.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabel20.setText("Category:");

        expense_category_txt.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N

        expense_description_txt.setColumns(10);
        expense_description_txt.setFont(new java.awt.Font("FreeMono", 0, 16)); // NOI18N
        expense_description_txt.setRows(2);
        jScrollPane4.setViewportView(expense_description_txt);

        jLabel21.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabel21.setText("Description:");

        add_expense_btn.setFont(new java.awt.Font("FreeMono", 0, 16)); // NOI18N
        add_expense_btn.setText("ADD");
        add_expense_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_expense_btnMouseClicked(evt);
            }
        });

        update_expense_btn.setFont(new java.awt.Font("FreeMono", 0, 16)); // NOI18N
        update_expense_btn.setText("UPDATE");

        expense_table.setBackground(new java.awt.Color(204, 204, 204));
        expense_table.setFont(new java.awt.Font("FreeMono", 1, 11)); // NOI18N
        expense_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Category", "Amount", "Date", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(expense_table);
        if (expense_table.getColumnModel().getColumnCount() > 0) {
            expense_table.getColumnModel().getColumn(0).setMinWidth(60);
            expense_table.getColumnModel().getColumn(0).setPreferredWidth(60);
            expense_table.getColumnModel().getColumn(0).setMaxWidth(60);
            expense_table.getColumnModel().getColumn(1).setMinWidth(200);
            expense_table.getColumnModel().getColumn(1).setMaxWidth(200);
            expense_table.getColumnModel().getColumn(2).setMinWidth(150);
            expense_table.getColumnModel().getColumn(2).setMaxWidth(150);
            expense_table.getColumnModel().getColumn(3).setMinWidth(100);
            expense_table.getColumnModel().getColumn(3).setMaxWidth(100);
            expense_table.getColumnModel().getColumn(4).setMinWidth(400);
            expense_table.getColumnModel().getColumn(4).setMaxWidth(400);
        }

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 4));

        jLabel15.setFont(new java.awt.Font("FreeMono", 1, 28)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 0, 0));
        jLabel15.setText("Expense Total:sh.");

        expense_total_show.setBackground(new java.awt.Color(51, 51, 51));
        expense_total_show.setFont(new java.awt.Font("FreeMono", 1, 28)); // NOI18N
        expense_total_show.setForeground(new java.awt.Color(153, 0, 0));
        expense_total_show.setText("40,000");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(expense_total_show, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expense_total_show)
                    .addComponent(jLabel15))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        expense_date_txt.setDateFormatString("dd/MM/y");
        expense_date_txt.setFont(new java.awt.Font("FreeMono", 0, 16)); // NOI18N

        javax.swing.GroupLayout expenseChildLayout = new javax.swing.GroupLayout(expenseChild);
        expenseChild.setLayout(expenseChildLayout);
        expenseChildLayout.setHorizontalGroup(
            expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, expenseChildLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(256, 256, 256))
            .addGroup(expenseChildLayout.createSequentialGroup()
                .addGroup(expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(expenseChildLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(expenseChildLayout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addComponent(add_expense_btn)
                                .addGap(138, 138, 138)
                                .addComponent(update_expense_btn))
                            .addGroup(expenseChildLayout.createSequentialGroup()
                                .addGroup(expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(expenseChildLayout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(trans_typetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(expenseChildLayout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(73, 73, 73)
                                        .addComponent(expense_amount_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(42, 42, 42)
                                .addGroup(expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(expenseChildLayout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(expense_category_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(expenseChildLayout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(48, 48, 48)
                                        .addComponent(expense_date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(expenseChildLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 114, Short.MAX_VALUE))
        );
        expenseChildLayout.setVerticalGroup(
            expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(expenseChildLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(expense_category_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(expenseChildLayout.createSequentialGroup()
                        .addGroup(expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(trans_typetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19)
                            .addGroup(expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(expense_amount_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(expense_date_txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(47, 47, 47)
                .addGroup(expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(expenseChildLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel21))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_expense_btn)
                    .addComponent(update_expense_btn))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        parentpanel.addTab("expenses", expenseChild);

        homechild.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("FreeMono", 0, 24)); // NOI18N
        jLabel6.setText("Recent Transactions:");

        transactiontbl.setBackground(new java.awt.Color(204, 204, 204));
        transactiontbl.setFont(new java.awt.Font("FreeMono", 1, 11)); // NOI18N
        transactiontbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Type", "Category", "Amount", "Date", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(transactiontbl);
        if (transactiontbl.getColumnModel().getColumnCount() > 0) {
            transactiontbl.getColumnModel().getColumn(0).setMinWidth(50);
            transactiontbl.getColumnModel().getColumn(0).setMaxWidth(50);
            transactiontbl.getColumnModel().getColumn(1).setMinWidth(80);
            transactiontbl.getColumnModel().getColumn(1).setMaxWidth(80);
            transactiontbl.getColumnModel().getColumn(2).setMinWidth(150);
            transactiontbl.getColumnModel().getColumn(2).setMaxWidth(150);
            transactiontbl.getColumnModel().getColumn(3).setMinWidth(100);
            transactiontbl.getColumnModel().getColumn(3).setMaxWidth(100);
            transactiontbl.getColumnModel().getColumn(4).setMinWidth(100);
            transactiontbl.getColumnModel().getColumn(4).setMaxWidth(100);
            transactiontbl.getColumnModel().getColumn(5).setMinWidth(400);
            transactiontbl.getColumnModel().getColumn(5).setMaxWidth(400);
        }

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 4));

        homeIncomeShow.setBackground(new java.awt.Color(51, 51, 51));
        homeIncomeShow.setFont(new java.awt.Font("FreeMono", 1, 22)); // NOI18N
        homeIncomeShow.setForeground(new java.awt.Color(0, 153, 0));
        homeIncomeShow.setText("40000");

        jLabel16.setFont(new java.awt.Font("FreeMono", 1, 22)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 0));
        jLabel16.setText("Income Balance:shs.");

        jLabel22.setFont(new java.awt.Font("FreeMono", 1, 22)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 0, 0));
        jLabel22.setText("Exp.Balance:shs.");

        homeExpenseShow.setBackground(new java.awt.Color(51, 51, 51));
        homeExpenseShow.setFont(new java.awt.Font("FreeMono", 1, 22)); // NOI18N
        homeExpenseShow.setForeground(new java.awt.Color(153, 0, 0));
        homeExpenseShow.setText("40000");

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 72, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeIncomeShow, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeExpenseShow, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homeExpenseShow)
                    .addComponent(jLabel22)))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(homeIncomeShow)
                .addComponent(jLabel16))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(394, 394, 394)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout homechildLayout = new javax.swing.GroupLayout(homechild);
        homechild.setLayout(homechildLayout);
        homechildLayout.setHorizontalGroup(
            homechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homechildLayout.createSequentialGroup()
                .addGroup(homechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homechildLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(homechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(homechildLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        homechildLayout.setVerticalGroup(
            homechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homechildLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        parentpanel.addTab("home", homechild);

        incomechild.setBackground(new java.awt.Color(204, 204, 204));

        income_table.setBackground(new java.awt.Color(204, 204, 204));
        income_table.setFont(new java.awt.Font("FreeMono", 1, 11)); // NOI18N
        income_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Category", "Amount", "Date", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(income_table);
        if (income_table.getColumnModel().getColumnCount() > 0) {
            income_table.getColumnModel().getColumn(0).setMinWidth(60);
            income_table.getColumnModel().getColumn(0).setMaxWidth(60);
            income_table.getColumnModel().getColumn(1).setMinWidth(200);
            income_table.getColumnModel().getColumn(1).setMaxWidth(200);
            income_table.getColumnModel().getColumn(2).setMinWidth(150);
            income_table.getColumnModel().getColumn(2).setMaxWidth(150);
            income_table.getColumnModel().getColumn(3).setMinWidth(100);
            income_table.getColumnModel().getColumn(3).setMaxWidth(100);
            income_table.getColumnModel().getColumn(4).setMinWidth(400);
            income_table.getColumnModel().getColumn(4).setMaxWidth(400);
        }

        jLabel7.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabel7.setText("Transaction Type:");

        trans_type_txt.setEditable(false);
        trans_type_txt.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        trans_type_txt.setText("Income");

        jLabel9.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabel9.setText("Category:");

        income_category_txt.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        income_category_txt.setText("Salary");

        jLabel10.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabel10.setText("Amount:");

        income_amount_txt.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        income_amount_txt.setText("40000");

        jLabel11.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabel11.setText("Description:");

        income_description_txt.setColumns(10);
        income_description_txt.setFont(new java.awt.Font("FreeMono", 0, 16)); // NOI18N
        income_description_txt.setRows(2);
        jScrollPane3.setViewportView(income_description_txt);

        jLabel12.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabel12.setText("Date:");

        ic_date_txt.setDateFormatString("dd/MM/y");
        ic_date_txt.setFont(new java.awt.Font("FreeMono", 0, 16)); // NOI18N

        add_btn.setFont(new java.awt.Font("FreeMono", 0, 16)); // NOI18N
        add_btn.setText("ADD");
        add_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_btnMouseClicked(evt);
            }
        });

        update_btn.setFont(new java.awt.Font("FreeMono", 0, 16)); // NOI18N
        update_btn.setText("UPDATE");

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 4));

        income_balance_show.setBackground(new java.awt.Color(51, 51, 51));
        income_balance_show.setFont(new java.awt.Font("FreeMono", 1, 28)); // NOI18N
        income_balance_show.setForeground(new java.awt.Color(0, 153, 0));
        income_balance_show.setText("40,000");

        jLabel14.setFont(new java.awt.Font("FreeMono", 1, 28)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 0));
        jLabel14.setText("Income Balance:shs.");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(income_balance_show, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(income_balance_show)
                .addComponent(jLabel14))
        );

        javax.swing.GroupLayout incomechildLayout = new javax.swing.GroupLayout(incomechild);
        incomechild.setLayout(incomechildLayout);
        incomechildLayout.setHorizontalGroup(
            incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(incomechildLayout.createSequentialGroup()
                .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(incomechildLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(incomechildLayout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addComponent(add_btn)
                                .addGap(138, 138, 138)
                                .addComponent(update_btn))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(incomechildLayout.createSequentialGroup()
                                .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(incomechildLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(trans_type_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10))
                                    .addGroup(incomechildLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(income_amount_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)))
                                .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(incomechildLayout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(income_category_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(incomechildLayout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ic_date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(incomechildLayout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(incomechildLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        incomechildLayout.setVerticalGroup(
            incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(incomechildLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(incomechildLayout.createSequentialGroup()
                        .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(income_category_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addComponent(ic_date_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                    .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel12)
                        .addGroup(incomechildLayout.createSequentialGroup()
                            .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(trans_type_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(51, 51, 51)
                            .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(income_amount_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(35, 35, 35)
                .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_btn)
                    .addComponent(update_btn))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        parentpanel.addTab("income", incomechild);

        mainpanel.add(parentpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, -40, 980, 680));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1126, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void incomepanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_incomepanelMouseClicked
        setColor(incomepanel);
        resetColor(home);
        resetColor(expensepanel);
        resetColor(stationerypanel);
        parentpanel.setSelectedIndex(2);
    }//GEN-LAST:event_incomepanelMouseClicked

    private void expensepanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expensepanelMouseClicked
        setColor(expensepanel);
        resetColor(incomepanel);
        resetColor(stationerypanel);
        resetColor(home);
        parentpanel.setSelectedIndex(0);
    }//GEN-LAST:event_expensepanelMouseClicked

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        setColor(home);
        resetColor(incomepanel);
        resetColor(expensepanel);
        resetColor(stationerypanel);
        parentpanel.setSelectedIndex(1);
    }//GEN-LAST:event_homeMouseClicked

    private void incomepanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_incomepanelMouseMoved
        //hover(incomepanel);
    }//GEN-LAST:event_incomepanelMouseMoved

    private void exp_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exp_btnMouseClicked
        setColor(expensepanel);
        resetColor(incomepanel);
        resetColor(home);
        resetColor(stationerypanel);
        parentpanel.setSelectedIndex(0);
    }//GEN-LAST:event_exp_btnMouseClicked

    private void homtxtbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homtxtbtnMouseClicked
        setColor(home);
        resetColor(incomepanel);
        resetColor(expensepanel);
        resetColor(stationerypanel);
        
        parentpanel.setSelectedIndex(1);
    }//GEN-LAST:event_homtxtbtnMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?!", "Confirm", WIDTH);
        
        if(option != 2 && option != 1){
            this.dispose();
        }        
    }//GEN-LAST:event_logoutMouseClicked

    private void add_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_btnMouseClicked
       addIncomeTransact();
    }//GEN-LAST:event_add_btnMouseClicked

    private void add_expense_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_expense_btnMouseClicked
        addExpenseTransact();
    }//GEN-LAST:event_add_expense_btnMouseClicked

    private void stati_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stati_btnMouseClicked
        setColor(stationerypanel);
        resetColor(home);
        resetColor(expensepanel);
        resetColor(incomepanel);
    }//GEN-LAST:event_stati_btnMouseClicked

    private void stationerypanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stationerypanelMouseClicked
        setColor(stationerypanel);
        resetColor(home);
        resetColor(expensepanel);
        resetColor(incomepanel);
    }//GEN-LAST:event_stationerypanelMouseClicked

//   Animations
     public void setColor(JPanel pane1){
         pane1.setBackground(new Color(51,51,51));
     }
     
     public void resetColor(JPanel pane1){
         pane1.setBackground(new Color(102,102,102));
     }
     
     public void hover(JPanel pane1){
         pane1.setBackground(new Color(102,102,102));
     }
      public void hoveroff(JPanel pane1){
         pane1.setBackground(new Color(51,51,51));
     }
      
      
      
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
            java.util.logging.Logger.getLogger(dashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new dashboardFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    private javax.swing.JButton add_expense_btn;
    private javax.swing.JLabel exp_btn;
    private javax.swing.JPanel expenseChild;
    private javax.swing.JTextField expense_amount_txt;
    private javax.swing.JTextField expense_category_txt;
    private com.toedter.calendar.JDateChooser expense_date_txt;
    private javax.swing.JTextArea expense_description_txt;
    private javax.swing.JTable expense_table;
    private javax.swing.JLabel expense_total_show;
    private javax.swing.JPanel expensepanel;
    private javax.swing.JPanel home;
    private javax.swing.JLabel homeExpenseShow;
    private javax.swing.JLabel homeIncomeShow;
    private javax.swing.JPanel homechild;
    private javax.swing.JLabel homtxtbtn;
    private com.toedter.calendar.JDateChooser ic_date_txt;
    private javax.swing.JLabel incobtn;
    private javax.swing.JTextField income_amount_txt;
    private javax.swing.JLabel income_balance_show;
    private javax.swing.JTextField income_category_txt;
    private javax.swing.JTextArea income_description_txt;
    private javax.swing.JTable income_table;
    private javax.swing.JPanel incomechild;
    private javax.swing.JPanel incomepanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logout;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JTabbedPane parentpanel;
    private javax.swing.JLabel stati_btn;
    private javax.swing.JPanel stationerypanel;
    private javax.swing.JTextField trans_type_txt;
    private javax.swing.JTextField trans_typetxt;
    private javax.swing.JTable transactiontbl;
    private javax.swing.JButton update_btn;
    private javax.swing.JButton update_expense_btn;
    // End of variables declaration//GEN-END:variables
}
