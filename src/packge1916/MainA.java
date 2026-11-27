package packge1916;

import java.util.Scanner;
import java.util.Stack;

public class MainA {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();

        //空格分割
        String[] tokens = line.split("\\s+");
        //栈存储
        Stack<Double> stack = new Stack<>();
        //从右往左遍历

        for (int i = tokens.length - 1; i >= 0; --i) {
            String token = tokens[i];
            //如果是符号出栈运算
            if (token.equals("-") || token.equals("+") || token.equals("*") || token.equals("/")) {
                double right = stack.pop();
                double left = stack.pop();
                double result = 0;

                switch (token) {
                    case "+":
                        result = right + left;
                        break;
                    case "-":
                        result = right - left;
                        break;
                    case "*":
                        result = right * left;
                        break;
                    case "/":
                        result = right / left;
                        break;
                }
                stack.push(result);
            } else {//数字就入栈
                stack.push(Double.parseDouble(token));
            }
        }
        //输出
        System.out.printf("%.2f\n", stack.pop());
        sc.close();
    }
}

