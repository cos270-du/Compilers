import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 使用 BufferedReader 逐字符读取，效率高且不会因为换行符出问题
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        // 定义状态
        final int CODE = 0;           // 正常代码
        final int SINGLE_COMMENT = 1; // 单行注释 //
        final int BLOCK_COMMENT = 2;  // 多行注释 /* */
        final int IN_STRING = 3;      // 字符串内部 "..."

        int state = CODE;
        int c;
        int prevC = -1; // 记录上一个字符，用来防范转义 \" 和 */

        // 逐个字符读取，直到文件结束 (-1 为 EOF)
        while ((c = br.read()) != -1) {

            if (state == CODE) {
                if (c == '"') {
                    // 遇到双引号，进入字符串状态
                    state = IN_STRING;
                    result.append((char) c);
                } else if (c == '/') {
                    // 遇到 /，需要往后偷看一眼
                    br.mark(1); // 标记当前读取位置
                    int nextC = br.read();
                    if (nextC == '/') {
                        state = SINGLE_COMMENT; // 是 //，进入单行注释
                    } else if (nextC == '*') {
                        state = BLOCK_COMMENT;  // 是 /*，进入多行注释
                    } else {
                        // 都不是，说明是普通的除号 /，把偷看的字符退回去，正常输出
                        br.reset();
                        result.append((char) c);
                    }
                } else {
                    // 普通字符，直接输出
                    result.append((char) c);
                }
            }
            else if (state == IN_STRING) {
                result.append((char) c);
                // 遇到双引号且前一个不是转义符 \，说明字符串结束
                if (c == '"' && prevC != '\\') {
                    state = CODE;
                }
            }
            else if (state == SINGLE_COMMENT) {
                // 单行注释遇到换行符结束，必须保留换行符
                if (c == '\n') {
                    result.append((char) c);
                    state = CODE;
                }
                // 其他字符忽略
            }
            else if (state == BLOCK_COMMENT) {
                // 多行注释中，寻找 */
                if (c == '*') {
                    br.mark(1);
                    int nextC = br.read();
                    if (nextC == '/') {
                        state = CODE; // 多行注释结束
                    } else {
                        br.reset(); // 不是 /，说明是个普通的星号，退回去继续找
                    }
                }
                // 多行注释里的字符和换行符统统丢弃
            }

            prevC = c; // 更新上一个字符
        }

        // 一次性输出最终结果
        System.out.print(result.toString());
    }
}