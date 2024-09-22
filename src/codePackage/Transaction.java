package codePackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Transaction {
    
//    Connection object
    Connection conn = null;
    
    Statement statement;
    
//    Private fields
    private String transaction_type;
    private String transaction_category;
    private double transaction_amount;
    private String transaction_date;
    private String transaction_description;
    
    
    
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
//    type | category | amount | date | description
    public void AddTransaction(){
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+"financemanager", "postgres", "");
            System.out.println(transaction_description);
            String query = String.format(
                    "INSERT INTO transaction_tbl(type, category, amount, date, description) "
                            + "VALUES('%s', '%s', '%f', '%s', '%s');", 
                    transaction_type, transaction_category, transaction_amount, transaction_date, transaction_description);
            statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

   
}
