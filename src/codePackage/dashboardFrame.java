
package codePackage;

import java.awt.Color;
import javax.swing.JPanel;


public class dashboardFrame extends javax.swing.JFrame {

   
    public dashboardFrame() {
        initComponents();
        parentpanel.setSelectedIndex(1);
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
        jLabel5 = new javax.swing.JLabel();
        parentpanel = new javax.swing.JTabbedPane();
        expenseChild = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        expense_total_show = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        trans_typetxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        expense_amount_txt = new javax.swing.JTextField();
        expense_date_txt = new javax.swing.JTextField();
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
        homechild = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        income_balance_show1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        income_balance_show2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        incomechild = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        income_table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        trans_type = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        income_category_txt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        income_amount_txt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        income_description_txt = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        income_amount_txt1 = new javax.swing.JTextField();
        add_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
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

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assetsPackage/log-out.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(36, 36, 36))
        );

        mainpanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 650));

        expenseChild.setBackground(new java.awt.Color(204, 204, 204));

        jLabel15.setFont(new java.awt.Font("FreeMono", 1, 28)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 0, 0));
        jLabel15.setText("EXP.Total:");

        expense_total_show.setBackground(new java.awt.Color(51, 51, 51));
        expense_total_show.setFont(new java.awt.Font("FreeMono", 1, 28)); // NOI18N
        expense_total_show.setForeground(new java.awt.Color(153, 0, 0));
        expense_total_show.setText("40000");

        jLabel17.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabel17.setText("Transaction Type:");

        trans_typetxt.setEditable(false);
        trans_typetxt.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        trans_typetxt.setText("Expense");

        jLabel18.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabel18.setText("Amount:");

        expense_amount_txt.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        expense_amount_txt.setText("40000");

        expense_date_txt.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        expense_date_txt.setText("01/09/24");

        jLabel19.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabel19.setText("Date:");

        jLabel20.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabel20.setText("Category:");

        expense_category_txt.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        expense_category_txt.setText("Rent");

        expense_description_txt.setColumns(10);
        expense_description_txt.setFont(new java.awt.Font("FreeMono", 0, 16)); // NOI18N
        expense_description_txt.setRows(2);
        jScrollPane4.setViewportView(expense_description_txt);

        jLabel21.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabel21.setText("Description:");

        add_expense_btn.setFont(new java.awt.Font("FreeMono", 0, 16)); // NOI18N
        add_expense_btn.setText("ADD");

        update_expense_btn.setFont(new java.awt.Font("FreeMono", 0, 16)); // NOI18N
        update_expense_btn.setText("UPDATE");

        expense_table.setBackground(new java.awt.Color(204, 204, 204));
        expense_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Category", "Amount", "Date", "Description"
            }
        ));
        jScrollPane5.setViewportView(expense_table);
        if (expense_table.getColumnModel().getColumnCount() > 0) {
            expense_table.getColumnModel().getColumn(0).setMinWidth(100);
            expense_table.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        javax.swing.GroupLayout expenseChildLayout = new javax.swing.GroupLayout(expenseChild);
        expenseChild.setLayout(expenseChildLayout);
        expenseChildLayout.setHorizontalGroup(
            expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(expenseChildLayout.createSequentialGroup()
                .addGroup(expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(expenseChildLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(expenseChildLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(expenseChildLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(expense_total_show))
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
                                            .addGap(122, 122, 122)
                                            .addComponent(expense_amount_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(32, 32, 32)
                                    .addGroup(expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel20)
                                        .addComponent(jLabel19))
                                    .addGap(34, 34, 34)
                                    .addGroup(expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(expense_date_txt)
                                        .addComponent(expense_category_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        expenseChildLayout.setVerticalGroup(
            expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(expenseChildLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expense_total_show)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(expenseChildLayout.createSequentialGroup()
                        .addGroup(expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(trans_typetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(expenseChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(expense_amount_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(expenseChildLayout.createSequentialGroup()
                        .addComponent(expense_category_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(expense_date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(expenseChildLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel19)))
                .addGap(43, 43, 43)
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

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Type", "Category", "Amount", "Date", "Description"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel16.setFont(new java.awt.Font("FreeMono", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 102, 0));
        jLabel16.setText("Income Balance:");

        income_balance_show1.setBackground(new java.awt.Color(51, 51, 51));
        income_balance_show1.setFont(new java.awt.Font("FreeMono", 1, 24)); // NOI18N
        income_balance_show1.setForeground(new java.awt.Color(51, 102, 0));
        income_balance_show1.setText("40000");

        jLabel22.setFont(new java.awt.Font("FreeMono", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 0, 0));
        jLabel22.setText("Exp.Balance:");

        income_balance_show2.setBackground(new java.awt.Color(51, 51, 51));
        income_balance_show2.setFont(new java.awt.Font("FreeMono", 1, 24)); // NOI18N
        income_balance_show2.setForeground(new java.awt.Color(153, 0, 0));
        income_balance_show2.setText("40000");

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout homechildLayout = new javax.swing.GroupLayout(homechild);
        homechild.setLayout(homechildLayout);
        homechildLayout.setHorizontalGroup(
            homechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homechildLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(homechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(homechildLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(income_balance_show1))
                    .addGroup(homechildLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(income_balance_show2)))
                .addGap(82, 82, 82))
            .addGroup(homechildLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(homechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        homechildLayout.setVerticalGroup(
            homechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homechildLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(homechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(income_balance_show1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(homechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(income_balance_show2))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        parentpanel.addTab("home", homechild);

        incomechild.setBackground(new java.awt.Color(204, 204, 204));

        income_table.setBackground(new java.awt.Color(204, 204, 204));
        income_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Category", "Amount", "Date", "Description"
            }
        ));
        jScrollPane2.setViewportView(income_table);
        if (income_table.getColumnModel().getColumnCount() > 0) {
            income_table.getColumnModel().getColumn(0).setMinWidth(100);
            income_table.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jLabel7.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabel7.setText("Transaction Type:");

        trans_type.setEditable(false);
        trans_type.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        trans_type.setText("Income");

        jLabel9.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabel9.setText("Category:");

        income_category_txt.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        income_category_txt.setText("Salary");

        jLabel10.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabel10.setText("Amount:");

        income_amount_txt.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        income_amount_txt.setText("Salary");

        jLabel11.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabel11.setText("Description:");

        income_description_txt.setColumns(10);
        income_description_txt.setFont(new java.awt.Font("FreeMono", 0, 16)); // NOI18N
        income_description_txt.setRows(2);
        jScrollPane3.setViewportView(income_description_txt);

        jLabel12.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabel12.setText("Date:");

        income_amount_txt1.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        income_amount_txt1.setText("01/09/24");

        add_btn.setFont(new java.awt.Font("FreeMono", 0, 16)); // NOI18N
        add_btn.setText("ADD");

        update_btn.setFont(new java.awt.Font("FreeMono", 0, 16)); // NOI18N
        update_btn.setText("UPDATE");

        income_balance_show.setBackground(new java.awt.Color(51, 51, 51));
        income_balance_show.setFont(new java.awt.Font("FreeMono", 1, 28)); // NOI18N
        income_balance_show.setForeground(new java.awt.Color(51, 102, 0));
        income_balance_show.setText("40000");

        jLabel14.setFont(new java.awt.Font("FreeMono", 1, 28)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 102, 0));
        jLabel14.setText("Income Balance:");

        javax.swing.GroupLayout incomechildLayout = new javax.swing.GroupLayout(incomechild);
        incomechild.setLayout(incomechildLayout);
        incomechildLayout.setHorizontalGroup(
            incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(incomechildLayout.createSequentialGroup()
                .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(incomechildLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(incomechildLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(incomechildLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(income_balance_show))
                            .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(incomechildLayout.createSequentialGroup()
                                    .addGap(244, 244, 244)
                                    .addComponent(add_btn)
                                    .addGap(138, 138, 138)
                                    .addComponent(update_btn))
                                .addGroup(incomechildLayout.createSequentialGroup()
                                    .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(incomechildLayout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(trans_type, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(incomechildLayout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addGap(122, 122, 122)
                                            .addComponent(income_amount_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(32, 32, 32)
                                    .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel12))
                                    .addGap(34, 34, 34)
                                    .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(income_amount_txt1)
                                        .addComponent(income_category_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        incomechildLayout.setVerticalGroup(
            incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(incomechildLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(income_balance_show)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(incomechildLayout.createSequentialGroup()
                        .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(trans_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(income_amount_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(incomechildLayout.createSequentialGroup()
                        .addComponent(income_category_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(income_amount_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(incomechildLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel12)))
                .addGap(43, 43, 43)
                .addGroup(incomechildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(incomechildLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
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
        parentpanel.setSelectedIndex(2);
    }//GEN-LAST:event_incomepanelMouseClicked

    private void expensepanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expensepanelMouseClicked
        setColor(expensepanel);
        resetColor(incomepanel);
        resetColor(home);
        parentpanel.setSelectedIndex(0);
    }//GEN-LAST:event_expensepanelMouseClicked

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        setColor(home);
        resetColor(incomepanel);
        resetColor(expensepanel);
        parentpanel.setSelectedIndex(1);
    }//GEN-LAST:event_homeMouseClicked

    private void incomepanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_incomepanelMouseMoved
        //hover(incomepanel);
    }//GEN-LAST:event_incomepanelMouseMoved

    private void exp_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exp_btnMouseClicked
        setColor(expensepanel);
        resetColor(incomepanel);
        resetColor(home);
        parentpanel.setSelectedIndex(0);
    }//GEN-LAST:event_exp_btnMouseClicked

    private void homtxtbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homtxtbtnMouseClicked
        setColor(home);
        resetColor(incomepanel);
        resetColor(expensepanel);
        parentpanel.setSelectedIndex(1);
    }//GEN-LAST:event_homtxtbtnMouseClicked

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboardFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    private javax.swing.JButton add_expense_btn;
    private javax.swing.JLabel exp_btn;
    private javax.swing.JPanel expenseChild;
    private javax.swing.JTextField expense_amount_txt;
    private javax.swing.JTextField expense_category_txt;
    private javax.swing.JTextField expense_date_txt;
    private javax.swing.JTextArea expense_description_txt;
    private javax.swing.JTable expense_table;
    private javax.swing.JLabel expense_total_show;
    private javax.swing.JPanel expensepanel;
    private javax.swing.JPanel home;
    private javax.swing.JPanel homechild;
    private javax.swing.JLabel homtxtbtn;
    private javax.swing.JLabel incobtn;
    private javax.swing.JTextField income_amount_txt;
    private javax.swing.JTextField income_amount_txt1;
    private javax.swing.JLabel income_balance_show;
    private javax.swing.JLabel income_balance_show1;
    private javax.swing.JLabel income_balance_show2;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JTabbedPane parentpanel;
    private javax.swing.JTextField trans_type;
    private javax.swing.JTextField trans_typetxt;
    private javax.swing.JButton update_btn;
    private javax.swing.JButton update_expense_btn;
    // End of variables declaration//GEN-END:variables
}
