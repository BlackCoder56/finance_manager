package codePackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Transaction {   
    
    
//    Connection objects  
    private Connection conn = null;
    
    private Statement statement;
    
    public PreparedStatement preparedStatement;
    
    public ResultSet resultSet;
    
    public ResultSetMetaData resultSetMetaData;
    
    
//    Private fields
    private String transaction_name;
    private double transaction_amount;
    private String transaction_date;
    private String transaction_description;
    
    private double income_balance = 0.0;
    private double expense_balance = 0.0;
    
    private Double result_balance = 0.0;
    
    private Double calculated_income = 0.0;
    
    private String message;
    
    private static String enteredPassword;
    
    
/*    setters and getters functions     */
    
    public void setName(String name)
    {
        this.transaction_name = name;
    }
    
    
    public void setAmount(double amount)
    {
        this.transaction_amount = amount;
    }
    
    public void setDate(String date)
    {
        this.transaction_date = date;
    }
    
    public void setDescription(String description)
    {
        this.transaction_description = description;
    }
    
    public void setPassword(String enteredPassword){
        Transaction.enteredPassword = enteredPassword;
    }
    
    public Double getIncomeBalance(){
        calculated_income = incomeBalances() - expenseBalances();
        income_balance = calculated_income;
        return income_balance;
    }
    
    public Double getExpenseBalance(){
        expense_balance = expenseBalances();
        return expense_balance;
    }
    
    public String getMessage(){
        return message;
    }
    
    
    public Double expenseBalances(){        
        
        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement("SELECT SUM(amount) FROM expense_tbl;");
//            preparedStatement.setString(1, typeOption);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                result_balance = resultSet.getDouble(1);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result_balance;
    }    
    
    public Double incomeBalances(){        
        
        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement("SELECT SUM(amount) FROM income_tbl;");
//            preparedStatement.setString(1, typeOption);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                result_balance = resultSet.getDouble(1);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result_balance;
    }    
        
/*  Adding expense transaction in database */
    public void addExpenseTransaction(){
        try {
            conn = getConnection();
            String query = String.format(
                    "INSERT INTO expense_tbl(name, amount,description,date) "
                            + "VALUES('%s','%f', '%s', '%s');", 
                    transaction_name, transaction_amount, transaction_description, transaction_date);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            
            message = "Transaction added successfully";
            
        } catch (ClassNotFoundException ex) {
                message = "SQL error";
        } catch (SQLException ex) {
                message = "SQL authentication error";
        }
    }
    
    /*  Adding income transaction in database */
    public void addIncomeTransaction(){
        try {
            conn = getConnection();
            String query = String.format(
                    "INSERT INTO income_tbl(name, amount,description,date) "
                            + "VALUES('%s','%f', '%s', '%s');", 
                    transaction_name, transaction_amount, transaction_description, transaction_date);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            
            message = "Transaction added successfully";
            
        } catch (ClassNotFoundException ex) {
                message = "SQL error";
        } catch (SQLException ex) {
                message = "SQL authentication error";
        }
    }
   
    
//    Connection to PostreSQL database Method   
    public static Connection getConnection() throws ClassNotFoundException, SQLException{        
        String  database_url = "jdbc:postgresql://localhost:5432/"+"financemanager";
        String user = "postgres";
        String password = enteredPassword;        
       
        Class.forName("org.postgresql.Driver");
        
        return DriverManager.getConnection(database_url,user, password);
           
    }
    

}
