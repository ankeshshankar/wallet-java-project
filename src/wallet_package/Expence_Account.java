/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wallet_package;

import java.sql.Date;

/**
 *
 * @author i quit techno
 */
class Expence_Account {
    private float amount;
    private String category;
    private String date;
    public Expence_Account(float amount,String category,String date){
        this.amount=amount;
        this.category=category;
        this.date=date;
    }
    public float getAmount(){
        return amount;
    }
    public String getCategory(){
        return category;
    }
    public String getDate(){
        return date;
    }
    
}
