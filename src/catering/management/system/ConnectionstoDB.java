package catering.management.system;
import java.sql.*;
import javax.swing.JOptionPane;
public class ConnectionstoDB implements CRUD {
 
    private Connection conn = null;
    
    private Statement stmt=null;
    private PreparedStatement pst = null;
    private ResultSet rs=null;
    private String LoginStr,sql;
    public Connection Establish(){
          try
        {
          Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conn=DriverManager.getConnection("jdbc:ucanaccess://D:\\kaka.accdb");

        }
        catch(Exception ex)
                {
                     JOptionPane.showMessageDialog(null,ex);
                }
          return conn;
    }
    Connection con_obj = Establish();
     public boolean LoginUser(String uname,String pass)
        {
           
            LoginStr = "select * from users where username ='"+uname+"' and password='"+pass+"'";
            boolean b; 
           try
             
            {            
                
            pst=con_obj.prepareStatement(LoginStr);
            rs=pst.executeQuery();
            if(rs.next())
            {
//                JOptionPane.showMessageDialog(null,"Succcessfully Logged IN");
                b= true;
            }
            else
            {
//                 JOptionPane.showMessageDialog(null,"Cannot Log In");
                 b= false;
            }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,ex);
                b=false;
            }
          
          
           return b;
        }
     
     public void create(String uname,String pass,String pno, String email)
        {
             sql="insert into users(username,password,contact,email) values ('"+uname+"','"+pass+"','"+pno+"','"+email+"')";
            try
            {
                stmt=con_obj.createStatement();
           
         int res = stmt.executeUpdate(sql);
         if(res>0)
         {
              JOptionPane.showMessageDialog(null,"Inserted");
         }
         else
         {
              JOptionPane.showMessageDialog(null,"Error");
         }
           
            }
            catch(Exception ex)
            {
                 JOptionPane.showMessageDialog(null,ex);
            }
        }
     public String read(String uid)
        {
            String str = null;
            String str2 = null;
            sql="select * from users where id = '"+uid+"'";
            try
            {
                stmt=con_obj.createStatement();
           
          rs = stmt.executeQuery(sql);
         if(rs.next())
         {
             str = rs.getString("username");
             str2 = rs.getString("password");
              JOptionPane.showMessageDialog(null,"Fetched");
         }
         else
         {
              JOptionPane.showMessageDialog(null,"Error");
         }
           
            }
            catch(Exception ex)
            {
                 JOptionPane.showMessageDialog(null,ex);
            }
             return "User Name ...: "+str+"\nPassword...: "+str2;
        }
     
     public void update(String uid,String uname,String upass)
        {
            
            
             sql="update users set username='"+uname+"' ,  password ='"+upass+"' where id = '"+uid+"' ";
            try
            {
                stmt=con_obj.createStatement();
                int rs = stmt.executeUpdate(sql);
         if(rs>0)
         {
              JOptionPane.showMessageDialog(null,"updated");
         }
         else
         {
              JOptionPane.showMessageDialog(null,"Error");
         }
           
         }
         catch(Exception ex)
            {
                 JOptionPane.showMessageDialog(null,ex);
            }
             
        }
         public boolean delete(String id)
        {
           boolean b = true;
            LoginStr = "delete  from users where id ='"+id+"'";

           try
             
            {       
                stmt = con_obj.createStatement();
                stmt.executeUpdate(LoginStr);
            
            if(stmt.toString() != null)
            {
               JOptionPane.showMessageDialog(null, "Deleted");
            }

            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,ex);
            
            }
          return b;  
        }

    @Override
    public void create(String id,String cus_name,String cus_pno,String cus_add,String item,String quantity ,String total) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(String id) {

           boolean b =false; 
            
             sql="update types set type='"+id+"'  where id = 1 ";
            try
            {
                stmt=con_obj.createStatement();
                int rs = stmt.executeUpdate(sql);
         if(rs>0)
         {
             b=true;
             // JOptionPane.showMessageDialog(null,"updated");
         }
         else
         {
             // JOptionPane.showMessageDialog(null,"Error");
         }
           
         }
         catch(Exception ex)
            {
                 JOptionPane.showMessageDialog(null,ex);
            }
             
         //To change body of generated methods, choose Tools | Templates.
         return b;
    }

    public String readType(String uid)
        {
            String str = null;
            String str2 = null;
            sql="select * from types where id = '"+uid+"'";
            try
            {
                stmt=con_obj.createStatement();
           
          rs = stmt.executeQuery(sql);
         if(rs.next())
         {
             str = rs.getString("type");
            // str2 = rs.getString("password");
             // JOptionPane.showMessageDialog(null,"Fetched");
              
         }
         else
         {
            //  JOptionPane.showMessageDialog(null,"Error");
         }
           
            }
            catch(Exception ex)
            {
                 JOptionPane.showMessageDialog(null,ex);
            }
            finally {
                update("");
            }
             return str;
        }
    public String readDishPrice(String uid)
        {
            String str = null;
            String str2 = null;
            sql="select * from dish where dish_name = '"+uid+"'";
            try
            {
                stmt=con_obj.createStatement();
           
          rs = stmt.executeQuery(sql);
         if(rs.next())
         {
             str = rs.getString("dish_price");
             
              JOptionPane.showMessageDialog(null,"Fetched");
         }
         else
         {
              JOptionPane.showMessageDialog(null,"Error");
         }
           
            }
            catch(Exception ex)
            {
                 JOptionPane.showMessageDialog(null,ex);
            }
             return str;
        }
    public String readSuppliesPrice(String uid)
        {
            String str = null;
  //.          String str2 = null;
            sql="select * from supplies where supplies_name = '"+uid+"'";
            try
            {
                stmt=con_obj.createStatement();
           
          rs = stmt.executeQuery(sql);
         if(rs.next())
         {
             str = rs.getString("supplies_price");
             
              JOptionPane.showMessageDialog(null,"Fetched");
         }
         else
         {
              JOptionPane.showMessageDialog(null,"Error");
         }
           
            }
            catch(Exception ex)
            {
                 JOptionPane.showMessageDialog(null,ex);
            }
             return str;
        }

}