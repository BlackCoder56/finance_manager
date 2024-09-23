package codePackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.Level;
//import java.util.logging.Logger;


public class Transaction {
    
    public Transaction(){
        getIncomeBalance();
        getExpenseBalance();
    }
    
//    Connection object  
    Connection conn = null;
    
    Statement statement;
    
    PreparedStatement preparedStatement;
    
    ResultSet resultSet;
    
    
//    Private fields
    private String transaction_type;
    private String transaction_category;
    private double transaction_amount;
    private String transaction_date;
    private String transaction_description;
    
    private double income_balance = 0.0;
    private double expense_balance = 0.0;
    
    private String message;
    
    
/*    setters and getters functions     */
    
    public void setType(String type)
    {
        this.transaction_type = type;
    }
    
    public void setCategory(String category)
    {
        this.transaction_category = category;
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
    
    public Double getIncomeBalance(){
        return income_balance = Balances("Income");
    }
    
    public Double getExpenseBalance(){
        return expense_balance = Balances("Expense");
    }
    
    public String getMessage(){
        return message;
    }

    public Double Balances(String typeOption){
        
        Double result_balance = 0.0;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+"financemanager", "postgres", "");
            preparedStatement = conn.prepareStatement("SELECT * FROM transaction_tbl where type = ?;");
            preparedStatement.setString(1, typeOption);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                result_balance = resultSet.getDouble("amount");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result_balance;
    }
    
/*  Adding transaction in database */
    public void AddTransaction(){
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+"financemanager", "postgres", "");
            String query = String.format(
                    "INSERT INTO transaction_tbl(type, category, amount, date, description) "
                            + "VALUES('%s', '%s', '%f', '%s', '%s');", 
                    transaction_type, transaction_category, transaction_amount, transaction_date, transaction_description);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            
            message = "Transaction added successfully";
            
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
                message = "SQL error";
        } catch (SQLException ex) {
//            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
                message = "SQL authentication error";
        }
    }
    
    

}
