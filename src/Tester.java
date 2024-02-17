import static javaNeo.StdIO.*;

public class Tester {
    public static void main(String[] args) {
        var numInt = scan(int.class);
        var numFLoat = scan(float.class);
        var c = scan(char.class);
        var str = scan(String.class);
        println(numInt);
        println(numFLoat);
        println(c);
        println(str);
        close();
    }
}