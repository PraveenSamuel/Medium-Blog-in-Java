/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author test
 */
public class SignIn {
    private String email,password;
    private boolean toggle;
    public void signIn(){
        System.out.println("Sign In");
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your email id..");
        email = s.nextLine();
        System.out.println("Enter your password..");
        password = s.nextLine();
        String str,temp[];
        try(BufferedReader br = new BufferedReader(new FileReader("MediumSignUp.txt"))){
            while((str = br.readLine())!=null ){
                temp = str.split("-");
                if(email.equals(temp[0]) && password.equals(temp[1])){
                    toggle = true;
                    break;
                }
            }
            if(toggle == true){
                Blog b = new Blog(email);
                b.blog();
            }else{
                System.out.println("Please check your email id and password");
            }
        } catch (Exception ex) {
            System.out.println("Catch block");
        }
    }
}
