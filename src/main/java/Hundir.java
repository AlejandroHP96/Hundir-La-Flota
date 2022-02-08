import java.util.Scanner;

public class Hundir {
    public static void main(String[] args) {

        Mundo mundo = new Mundo();
        Scanner in = new Scanner(System.in);
        String[][] inicioTablero = new String[10][10];

        System.out.println("Tablero");
        mundo.mostrarTablero(inicioTablero);

        System.out.println("1- Los datos se introducirán siempre siendo la Letra primero y en numero después\n");
        System.out.println("2- Cada jugador tendrá un turno para disparar\n");
        System.out.println("3- Una vez destruyas los barcos enemigos se acabará el juego\n");

        mundo.generarBarcos();

    }
}
