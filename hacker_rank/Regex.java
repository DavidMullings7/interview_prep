import java.util.regex.*;

public class Regex {
    public static void main(String args[]) {
        boolean b = Pattern.matches("a.*a|a|b|b.*b", "a");
        System.out.println(b);
    }
}
