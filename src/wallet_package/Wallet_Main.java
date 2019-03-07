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
public class Wallet_Main {
    public static void main(String[] args)
    {
        
        SplashScreen s1= new SplashScreen();
        LoginScreen login = new LoginScreen();
        s1.setVisible(true);
        try {
            for (int i = 0; i <= 100; i++) {
                 Thread.sleep(20);
                s1.jLabel3.setText(Integer.toString(i)+"%");
                s1.jProgressBar1.setValue(i);
                if (i== 100) {
                    s1.dispose();
                    login.setVisible(true);
                 }
            }
            } catch (InterruptedException e) {
        }
        
        
    }
}
