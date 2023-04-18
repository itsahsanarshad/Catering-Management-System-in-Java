/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catering.management.system;

/**
 *
 * @author Ahsan
 */
public class Total {
    
        int quanInt ;
        int priceInt ;
        int total ;
        String subTotal;
        
        public String total (String quan ,String Price){
         quanInt = Integer.parseInt(quan);
         priceInt = Integer.parseInt(Price);
        total = quanInt*priceInt;
         subTotal=String.valueOf(total);
        return subTotal;
        }
    
}
