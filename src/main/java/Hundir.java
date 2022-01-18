import java.util.Scanner;

public class Hundir {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("1- Single Player"); // Esto todavia no hace nada pero es un menú para que se vea la intención
        System.out.println("1- MultiPlayer");

        Mundo.crearTablero();
        Mundo.generarBarcos();

    }
}
