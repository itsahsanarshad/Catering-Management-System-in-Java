/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catering.management.system;

/**
 *
 * @author princ
 */
public interface CRUD {
    public void create (String id,String cus_name,String cus_pno,String cus_add,String item,String quantity ,String total);
    public String read (String id);
    public boolean update (String id);
    public boolean delete (String id);
}
