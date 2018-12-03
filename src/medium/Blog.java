/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author test
 */
public class Blog {
    private Short choice,writeChoice;
    private int length;
    private String str,tempstr,temparrstr[],name;
    final private String email;
    final private Scanner s = new Scanner(System.in);
    Blog(String email){
        this.email = email;
        this.str = null;
        this.choice = 0;
        this.length = 0;
        this.name = null;
    }
    void blog(){
        System.out.println("In Medium Blog");
        System.out.println("Choose the choice you have to perform\n1. Write Blog\n2. ReadBlog");
        choice = s.nextShort();
        if(choice==1){
            System.out.println("Get ready to write blog...");
            Blog blog = new Blog(this.email);
            blog.writeBlog();
        }
        if(choice==2){
            System.out.println("Start Reading intresting blogs...");
            Blog blog = new Blog(this.email);
            blog.readBlog();
        }
    }
    void writeBlog(){
        System.out.println("Choose the topic you have to write blog");
        try(BufferedReader br = new BufferedReader(new FileReader("MediumSignUp.txt"))){
            while((tempstr = br.readLine())!=null ){
                temparrstr = tempstr.split("-");
                if(email.equals(temparrstr[0])){
                   length = temparrstr[3].length();
                   name = temparrstr[2];
                   for(int i=0;i<length;++i){
                       if(temparrstr[3].charAt(i)==49)
                           System.out.println("1.Programming");
                       if(50==temparrstr[3].charAt(i))
                           System.out.println("2.Playing");
                       if(51==temparrstr[3].charAt(i))
                           System.out.println("3.News");
                   }
                }
            }
        } catch (Exception ex) {
            System.out.println("Catch block");
        }
        writeChoice = s.nextShort();
        System.out.println("Start Writing your blog...");
        s.nextLine();
        str = s.nextLine();
        try(PrintWriter pw = new PrintWriter(new FileOutputStream((this.writeChoice+"//"+this.email+"-"+"Blog.txt"),true));
                PrintWriter printwriterall = new PrintWriter(new FileOutputStream(("AllBlog.txt"),true));) {
            pw.println(str);
            pw.println("*");
            printwriterall.println("This blog was written by "+this.name);
            printwriterall.println(str);
            printwriterall.println("--------------------------");
            System.out.println("Your blog post has been published.");
        } catch (FileNotFoundException ex) {
            System.out.println("Catch block");
        }
    }
    void readBlog(){
        String str;
        try(BufferedReader br = new BufferedReader(new FileReader("AllBlog.txt"));){
            while((str=br.readLine())!=null){
                System.out.println(str);
            }
        }
        catch(Exception e){
            System.out.println("Catch Block");
        }
    }
}
