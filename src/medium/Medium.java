/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

import java.util.Scanner;

/**
 *
 * @author test
 */
public class Medium {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        char status;
        System.out.println("Are you new user?");
        System.out.println("If yes type : Y/N");
        Scanner s = new Scanner(System.in);
        status = s.next().charAt(0);
        if(status == 'Y'){
           SignUp signup = new SignUp();
           signup.signUp();
        } else if(status == 'N'){
           SignIn signin = new SignIn();
           signin.signIn();
        } else{
           System.out.println("Invalid entry");
        }
    }
}
