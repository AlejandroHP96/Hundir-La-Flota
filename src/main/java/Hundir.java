import java.util.Scanner;

public class Hundir {

    public static void main(String[] args) {

        Mundo mundo = new Mundo();
        Scanner in = new Scanner(System.in);

        System.out.println("Jugador 1");
        mundo.crearTablero();
        System.out.println("Jugador 2");
        mundo.crearTablero();

        Mundo.generarBarcos();

    }
}
