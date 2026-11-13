package packge1915;

import java.util.Scanner;

public class MainD {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int len=str.length();
        // 枚举每一段的长度 i，从 1 到 len
        for(int i=1;i<=len;i++){
            if(len%i==0){
                boolean flag=true;
                String fstr=str.substring(0,i);
                //当字符串不能被截断成多个相同的字串时：i遍历到len时，j=i=len,循环结束此时flag=true
                //真好输出len/i=1;
                for(int j=i;j<len;j+=i){
                    if(!str.substring(j,j+i).equals(fstr)){
                        flag=false;
                        break;//这个长度i已经不满足
                    }
                }
                if (flag) {
                    System.out.println(len/i);
                    break;
                }

            }

        }
        sc.close();
    }
}
