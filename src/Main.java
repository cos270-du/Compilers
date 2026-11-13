import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        PushbackReader reader = new PushbackReader(
                new InputStreamReader(System.in), 1);
        StringBuilder sb = new StringBuilder();

        int c;
        boolean inLineComment = false;
        boolean inBlockComment = false;

        while ((c = reader.read()) != -1) {
            char ch = (char) c;

            if (inLineComment) {
                if (ch == '\n') {
                    inLineComment = false;
                    sb.append(ch);
                }
                // 其他丢弃
            } else if (inBlockComment) {
                if (ch == '*') {
                    int next = reader.read();
                    if (next == -1) {
                        break;
                    }
                    char nextCh = (char) next;
                    if (nextCh == '/') {
                        inBlockComment = false;
                    } else {
                        // 不是 */，把nextCh放回
                        reader.unread(next);
                    }
                }
                // 其他丢弃
            } else {
                if (ch == '/') {
                    int next = reader.read();
                    if (next == -1) {
                        sb.append(ch);
                        break;
                    }
                    char nextCh = (char) next;
                    if (nextCh == '/') {
                        inLineComment = true;
                    } else if (nextCh == '*') {
                        inBlockComment = true;
                    } else {
                        sb.append(ch);
                        reader.unread(next);
                    }
                } else {
                    sb.append(ch);
                }
            }
        }

        System.out.print(sb.toString());
    }
}