package packge1916;

import java.util.*;
public class MainH {
    static String input;
    static int pos;//记录当前读取到的位置

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            input=sc.nextLine().trim();
            if(input.isEmpty())continue;//判空
            pos=0;

            try{
                E();
                if(input.charAt(pos)=='#'){
                    System.out.println("syntax correct");
                }else{
                    System.out.println("syntax error");
                }
            }catch (RuntimeException e){
                System.out.println("syntax error");
            }
        }
        sc.close();
    }
    //获取当前字符
    static char cur(){
        return input.charAt(pos);
    }
    //匹配消耗当前字符
    static void match(char expected){
        if(cur()==expected){
            pos++;
        }else{
            throw new RuntimeException();
        }
    }
    //E -> T E'
    static void E(){
        T();
        EPrime();
    }
    //E' -> + T E' | 空
    static void EPrime(){
        if(cur()=='+'){
            match('+');
            T();
            EPrime();
        }else{
            //其他字符属于 空 直接返回
        }
    }
    //T -> F T'
    static void T(){
        F();
        TPrime();
    }

    //T' → * F T' | ε
    static void TPrime() {
        if (cur() == '*') {
            match('*');
            F();
            TPrime(); // 递归调用
        }else{
            // 同理，如果不匹配 *，则走 ε 分支，返回即可
        }
    }

    // F → ( E ) | i
    static void F() {
        if (cur() == '(') {
            match('(');
            E();
            match(')');
        } else if (cur() == 'i') {
            match('i');
        } else {
            throw new RuntimeException();
        }
    }
}
