
package pharmacymanagementsystem;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBMS_Connectivity {
      Connection con;
      Statement st ;
      ResultSet rs;
       DBMS_Connectivity(){
          try{
              Class.forName("com.mysql.cj.jdbc.Driver");
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacymanagementsystem","root","");
              st=  con.createStatement();
              System.out.println("DB is connected");
              
          }catch(Exception e){
              System.out.println(e);
          }
       }     
       public ResultSet searchUser(String username){
          try {
              String sql="Select * from users where username='"+username+"'";
              System.out.println(sql);
              rs=st.executeQuery(sql);
             
          } catch (SQLException ex) {
              Logger.getLogger(DBMS_Connectivity.class.getName()).log(Level.SEVERE, null, ex);
          }
           return rs;
         }
         
          public ResultSet searchAdmin(String username){
          try {
              String sql="Select * from Admin_Info where username='"+username+"'";
              System.out.println(sql);
              rs=st.executeQuery(sql);
             
          } catch (SQLException ex) {
              Logger.getLogger(DBMS_Connectivity.class.getName()).log(Level.SEVERE, null, ex);
          }
           return rs;
         }
          public int updateRecordOfUser(String name,String email,String address){
               int s=0;
          try {
             
              String sql="Update users set name='"+name+"',email'"+email+"',address'"+address+"'";
              s=st.executeUpdate(sql);
             
          } catch (SQLException ex) {
              Logger.getLogger(DBMS_Connectivity.class.getName()).log(Level.SEVERE, null, ex);
          }
           return s;
          }

          public ResultSet updateRecordOfMedicine(String medicine_id){
              
          try {
              String sql="Select* from medicinesdetails where Medicine_ID='"+medicine_id+"'";
              System.out.println(sql);
              rs=st.executeQuery(sql);
            
          } catch (SQLException ex) {
              Logger.getLogger(DBMS_Connectivity.class.getName()).log(Level.SEVERE, null, ex);
          }
            return rs;
          }
          
            public ResultSet searchRecordOfMedicine(String medicine_id,String Med_name){
              
          try {
              String sql="Select* from medicinesdetails where Medicine_ID='"+medicine_id+"'or Med_Name='"+Med_name+"'";
              System.out.println(sql);
              rs=st.executeQuery(sql);
            
          } catch (SQLException ex) {
              Logger.getLogger(DBMS_Connectivity.class.getName()).log(Level.SEVERE, null, ex);
          }
            return rs;
          }
            public ResultSet medicineShowInTable(){
          try {
              String sql="Select * from medicinesdetails";
              System.out.println(sql);
              rs=st.executeQuery(sql);
            
          } catch (SQLException ex) {
              Logger.getLogger(DBMS_Connectivity.class.getName()).log(Level.SEVERE, null, ex);
          }
            return rs;
       }
              public ResultSet adminlogin(String name, String password){
           
           String sql= "Select * from admin_info where name='"+name+"' and password='"+password+"'";
           System.out.println(sql);
          try {
              rs=st.executeQuery(sql);
          } catch (SQLException ex) {
              Logger.getLogger(DBMS_Connectivity.class.getName()).log(Level.SEVERE, null, ex);
          }
           return rs;
       }
                  public ResultSet userLogin(String name, String password){
           String sql="Select * from users where  name='"+name+"'and password='"+password+"'";
          try {
              rs=st.executeQuery(sql);
          } catch (SQLException ex) {
              Logger.getLogger(DBMS_Connectivity.class.getName()).log(Level.SEVERE, null, ex);
          }
           return rs;
       }
       public ResultSet viewUser(){
           String sql="Select *from users ";
          try {
              rs=st.executeQuery(sql);
          } catch (SQLException ex) {
              Logger.getLogger(DBMS_Connectivity.class.getName()).log(Level.SEVERE, null, ex);
          }
           return rs;
       }
       
        public int deleteMedicineFromTable(int medicine_id){
            int s=0;      

          try {
              
              String sql="delete from medicinesdetails where Medicine_ID='"+medicine_id+"'";
              s=st.executeUpdate(sql);
              
          } catch (SQLException ex) {
              Logger.getLogger(DBMS_Connectivity.class.getName()).log(Level.SEVERE, null, ex);
          }
          return s;
       }
        public ResultSet searchbymedicineName(String Med_name){
          try {
              String sql="Select * from medicinesdetails where Med_Name like'"+Med_name+"'";
              System.out.println(sql);
              rs=st.executeQuery(sql);
             
          } catch (SQLException ex) {
              Logger.getLogger(DBMS_Connectivity.class.getName()).log(Level.SEVERE, null, ex);
          }
           return rs;
        }
            
         public ResultSet viewMedicine(){
           String sql="Select * from medicinesdetails";
          try {
              rs=st.executeQuery(sql);
          } catch (SQLException ex) {
              Logger.getLogger(DBMS_Connectivity.class.getName()).log(Level.SEVERE, null, ex);
          }
           return rs;
       } 
       public static Connection connectDB(){
  try{
              Class.forName("com.mysql.cj.jdbc.Driver");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacymanagementsystem","root","");
              
              return con;
              
          }catch(Exception e){
              System.out.println(e);
          }
   
   return null;
  }
     

       public int DeleteDataFromTable(String role){
       int s=0;
      
          try {
               String sql="delete from users where role='"+role+"'";
         System.out.println(sql);
              s=st.executeUpdate(sql);
          } catch (SQLException ex) {
              Logger.getLogger(DBMS_Connectivity.class.getName()).log(Level.SEVERE, null, ex);
          }
       
       return s;
     }
      
       
 
    public static void main(String[] args) {
        DBMS_Connectivity dc = new DBMS_Connectivity();
    }
 
}
