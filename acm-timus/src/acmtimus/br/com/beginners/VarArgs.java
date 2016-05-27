package acmtimus.br.com.beginners;

public class VarArgs {
    // Um teste que me veio a mente
    public static void print(String format, Object ... args) {
	System.out.printf(format, args);
    }

    public static void main(String [] args) {
	print("%s %s %s", "A", "B", "C");
    }

}
