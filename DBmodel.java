
package pharmacymanagementsystem;



import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DBmodel {
    Connection con;
    Statement st;
    ResultSet rs;
    
    DBmodel(){
     try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms_123","root","");
         st=con.createStatement();
         System.out.println("db is connected");
     
     }catch(Exception e){
         System.out.println(e);
     }
  }
       public ResultSet LoginTeacher(int id,String name,String department,String email){
        try {
            String sql="select * from teacher where T_ID='"+id+"' and T_Name='"+name+"'T_Department='"+department+"' and T_Email='"+email+"'";
            rs=st.executeQuery(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBmodel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;  
}
       
  
    public static void main(String[] args) {
        DBmodel input=new DBmodel();
    }
}
