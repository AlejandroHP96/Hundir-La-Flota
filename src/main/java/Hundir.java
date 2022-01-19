import java.util.Scanner;

public class Hundir {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("1- Single Player"); // Esto todavia no hace nada pero es un menú para que se vea la intención
        System.out.println("2- MultiPlayer");

        System.out.println("Jugador 1");
        Mundo.crearTablero();
        System.out.println("Jugador 2");
        Mundo.crearTablero();
        
        Mundo.generarBarcos();

    }
}
