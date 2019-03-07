/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wallet_package;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author i quit techno
 */
public class Refresh {
    HomePage h1 ;
    public void re(){
        try {
            h1 = new HomePage();
            
            String value = h1.jLabel6.getText();
            if ("Bank".equals(value)){
                Clear_table();
                //h1.LoadIncome();
                //  h1.Show_income_bank();
                
            }
            else
            {
                Clear_table();
                //  h1.LoadIncome();
                //  h1.Show_income_cash();
            }   } catch (SQLException ex) {
            Logger.getLogger(Refresh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void Clear_table(){
        DefaultTableModel model = (DefaultTableModel) h1.jTable2.getModel();
        model.setRowCount(0);
        model.fireTableDataChanged();
     }
}
    


