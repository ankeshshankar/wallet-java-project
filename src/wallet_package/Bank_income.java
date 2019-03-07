/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wallet_package;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author i quit techno
 */

class Bank_income {
    private String bank_name;
    private float bank_balence;
    public Bank_income(String bank_name,float bank_balence){
        this.bank_name=bank_name;
        this.bank_balence=bank_balence;
    }
    public String getbank_name(){
        return bank_name;
    }
    public float getbank_balence(){
        return bank_balence;
    }
}

