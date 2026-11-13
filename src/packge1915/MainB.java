package packge1915;
import java.util.*;


import java.util.Scanner;
import java.util.regex.Pattern;

public class MainB {
    public static void main(String[] args){
        String regex = "^[a-zA-Z_][a-zA-Z0-9_]*$";

        Scanner sc=new Scanner(System.in);
        if(sc.hasNextLine()){
            int n=sc.nextInt();sc.nextLine();//处理nextInt遗留的回车符
            for(int i=0;i<n;i++){
                //trim不要
                String str=sc.nextLine();



                if (Pattern.matches(regex, str)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
        sc.close();
    }
}