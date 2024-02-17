package javaNeo;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StdIO {
    private static final int BUFFER_SIZE = 1 << 16;
    private static DataInputStream din;
    private static byte[] buffer;
    private static int bufferPointer;
    private static int bytesRead;

    static {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void print(Object line) {
        try {
            bw.write(line.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void println(Object line) {
        print(line + "\n");
    }

    public static <T> T scan(Class<T> type) {
        try {
            byte c;
            do {
                c = read();
            } while (c <= ' ');

            String input = "";
            while (c > ' ') {
                input += (char) c;
                c = read();
            }

            if (type == Boolean.class || type == boolean.class) {
                return (T) Boolean.valueOf(input);
            } else if (type == Character.class || type == char.class) {
                return (T) (Character) Character.valueOf(input.charAt(0));
            } else if (type == Byte.class || type == byte.class) {
                return (T) Byte.valueOf(input);
            } else if (type == Short.class || type == short.class) {
                return (T) Short.valueOf(input);
            } else if (type == Integer.class || type == int.class) {
                return (T) Integer.valueOf(input);
            } else if (type == Long.class || type == long.class) {
                return (T) Long.valueOf(input);
            } else if (type == Float.class || type == float.class) {
                return (T) Float.valueOf(input);
            } else if (type == Double.class || type == double.class) {
                return (T) Double.valueOf(input);
            } else if (type == String.class) {
                return (T) input;
            } else {
                throw new IllegalArgumentException("Unsupported data type: " + type.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static char scanChar() {
        try {
            byte c;
            do {
                c = read();
            } while (c <= ' ');

            return (char) c;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return '\0';
    }

    public static String scanWord() {
        StringBuilder word = new StringBuilder();
        try {
            byte c;
            while ((c = read()) <= ' ') {
            }
            while (c > ' ') {
                word.append((char) c);
                c = read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return word.toString();
    }

    public static String scanLine() {
        byte[] buf = new byte[64];
        int cnt = 0, c;
        try {
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(buf, 0, cnt);
    }

    public static byte scanByte() {
        byte ret = 0;
        byte c;
        try {
            do {
                c = read();
            } while (c <= ' ');

            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = (byte) (ret * 10 + c - '0');
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return (byte) -ret;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static short scanShort() {
        short ret = 0;
        byte c;
        try {
            do {
                c = read();
            } while (c <= ' ');

            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = (short) (ret * 10 + c - '0');
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return (short) -ret;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static int scanInt() {
        int ret = 0;
        byte c;
        try {
            do {
                c = read();
            } while (c <= ' ');

            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static long scanLong() {
        long ret = 0;
        byte c;
        try {
            do {
                c = read();
            } while (c <= ' ');

            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static float scanFloat() {
        float ret = 0;
        byte c;
        try {
            do {
                c = read();
            } while (c <= ' ');

            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                float div = 10;
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / div;
                    div *= 10;
                }
            }

            if (neg)
                return -ret;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static double scanDouble() {
        double ret = 0, div = 1;
        byte c;
        try {
            do {
                c = read();
            } while (c <= ' ');

            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static boolean scanBool() {
        String input = scanLine().trim().toLowerCase();
        return input.equals("true") || input.equals("1");
    }

    private static void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private static byte read() throws IOException {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    public static boolean hasNextChar() {
        try {
            din.mark(1);
            int nextByte = din.read();
            din.reset();
            return nextByte != -1;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean hasNextLine() {
        try {
            din.mark(1);
            int nextByte = din.read();
            din.reset();
            return nextByte != -1;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isEmpty() {
        try {
            din.mark(1);
            int nextByte = din.read();
            din.reset();
            return nextByte == -1;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Double> readAllDoubles() {
        List<Double> doubles = new ArrayList<>();
        while (hasNextChar()) {
            doubles.add(scanDouble());
        }
        return doubles;
    }

    public static List<Integer> readAllInts() {
        List<Integer> ints = new ArrayList<>();
        while (hasNextChar()) {
            ints.add(scanInt());
        }
        return ints;
    }

    public static List<Long> readAllLongs() {
        List<Long> longs = new ArrayList<>();
        while (hasNextChar()) {
            longs.add(scanLong());
        }
        return longs;
    }

    public static List<String> readAllStrings() {
        List<String> strings = new ArrayList<>();
        while (hasNextLine()) {
            strings.add(scanLine());
        }
        return strings;
    }

    public static List<String> readAllLines() {
        List<String> lines = new ArrayList<>();
        while (hasNextLine()) {
            lines.add(scanLine());
        }
        return lines;
    }

    public static String readAll() {
        Scanner scanner = new Scanner(System.in).useDelimiter(Pattern.compile("\\A"));
        return scanner.hasNext() ? scanner.next() : "";
    }

    public static void close() {
        try {
            if (bw != null)
                bw.close();
            if (din != null)
                din.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
