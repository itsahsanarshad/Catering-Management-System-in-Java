package catering.management.system;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class list {
    Statement stmt;
    ResultSet rs;
    PreparedStatement pst;
    ConnectionstoDB con = new ConnectionstoDB();
    Connection con_obj = con.Establish();
    public ArrayList makeList(String type){

            ArrayList str= new ArrayList();
            ArrayList str1= new ArrayList();
          
            String sql="select * from dish where DISH_TYPE = '"+type+"'";
            
            try
            {
            //    stmt=con_obj.createStatement();
           pst=con_obj.prepareStatement(sql);
            rs=pst.executeQuery();
          //rs = stmt.executeQuery(sql);
         while(rs.next() !=false)
         {
             str.add(rs.getString("dish_name"));
            
            
         } 

           
            }
            catch(Exception ex)
            {
                 JOptionPane.showMessageDialog(null,ex);
            }
             return str ;
        }
    public ArrayList makeListNF(String type){

            ArrayList str= new ArrayList();
            ArrayList str1= new ArrayList();
          
            String sql="select * from supplies where supplies_type = '"+type+"'";
            
            try
            {
           pst=con_obj.prepareStatement(sql);
            rs=pst.executeQuery();
         while(rs.next() !=false)
         {
             str.add(rs.getString("supplies_name"));
            
            
         } 

           
            }
            catch(Exception ex)
            {
                 JOptionPane.showMessageDialog(null,ex);
            }
             return str ;
        }
  }
  
   
