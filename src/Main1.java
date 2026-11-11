import java.util.*;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            boolean inString = false;
            boolean hasText = false; // 记录该行在注释前是否已经有代码

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                // 1. 处理字符串状态 
                // 2. 遇到注释  
                // 3. 遇到非空白字符，标记本行有实际代码
                if (c == '"') {
                    if (i == 0 || line.charAt(i - 1) != '\\') {
                        inString = !inString;
                    }
                }


                if (!inString && c == '/' && i + 1 < line.length() && line.charAt(i + 1) == '/') {
                    break;
                }


                if (!Character.isWhitespace(c)) {
                    hasText = true;
                }

                result.append(c);
            }

            if (hasText || result.length() > 0) {
                System.out.println(result.toString());
            }
        }
        scanner.close();
    }
}