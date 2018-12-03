/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author test
 */
public class SignUp {
    private String name,email,password;
    private short tempIntrests;
    final private ArrayList<Short> intrests= new ArrayList<>();
    public void signUp(){
        System.out.println("Sign Up");
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your name..");
        name = s.nextLine();
        System.out.println("Enter your email id..");
        email = s.nextLine();
        System.out.println("Enter your password..");
        password = s.nextLine();
        System.out.println("Choose your intrest.. \n1.Programming\n2.Playing\n3.News");
        System.out.println("Enter 0 to stop inserting your intrests");
        while(true){
            tempIntrests=s.nextShort();
            if(tempIntrests>0&&tempIntrests<=3)
                intrests.add(tempIntrests);
            else
                break;
        }
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(("MediumSignUp.txt"),true));) {
            pw.println(email + "-" + password + "-" + name + "-" +intrests);
        } catch (FileNotFoundException ex) {
            System.out.println("Catch block");
        }
        System.out.println("SignUp Successful");
        Blog b = new Blog(email);
        b.blog();
    }
}