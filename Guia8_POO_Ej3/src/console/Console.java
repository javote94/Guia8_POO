package console;

import java.util.Scanner;

public class Console {

    static Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public Console() {
    }

    public static String inputStr(String mensaje) {
        System.out.print(mensaje);
        return leer.next();
    }
    
    public static char inputChr(String mensaje) {
        System.out.print(mensaje);
        return leer.next().charAt(0);
    }
    
    public static int inputInt(String mensaje) {
        System.out.print(mensaje);
        return leer.nextInt();
    }

    public static double inputDouble(String mensaje) {
        System.out.print(mensaje);
        return leer.nextDouble();
    }

    public static void println(Object x) {
        System.out.println(x);
    }
    
    public static void print(Object x) {
        System.out.print(x);
    }
}
