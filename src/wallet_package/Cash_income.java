/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wallet_package;

/**
 *
 * @author i quit techno
 */
class Cash_income {
     private float cash_balence;
    public Cash_income(float c_balence){
        
        this.cash_balence= c_balence;
    }
    
    public float getcash_balence(){
        return cash_balence;
    }
}
