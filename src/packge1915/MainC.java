package packge1915;

import java.util.Scanner;

public class MainC {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int t=sc.nextInt();
            sc.nextLine();
            String str=null;
            for(int k=1;k<=t;++k){
                str=sc.nextLine();
                if(str.contains("13")){
                    System.out.println("Case #"+k+":No, it's terrible!");
                }else{
                    System.out.println("Case #"+k+":Yes, I like it!");
                }
            }
        }
        sc.close();
    }
}
