import barcos.Barco;
import barcos.Submarino;
import barcos.Transatlantico;
import barcos.Yate;
import utils.Coordenadas;

import java.util.ArrayList;
import java.util.Scanner;

public class Mundo {
    private static Jugador jugador1 = new Jugador();
    private static Jugador jugador2 = new Jugador();

    public static void crearTablero() {

        String[][] tablero = new String[10][10];
        String[] letras = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
        String[] numeros = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

        for (int i = 0; i < letras.length; i++) {
            System.out.print(" " + letras[i] + " ");
        }
        System.out.println("");

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = " * ";

            }
        }

        for (int i = 0; i < tablero.length; i++) {
            System.out.print(numeros[i]);
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j]);

            }
            System.out.println("");
        }

    }

    public static void generarBarcos() {

        ArrayList<Barco> barcoListJ1 = new ArrayList<>();
        ArrayList<Barco> barcoListJ2 = new ArrayList<>();

        Coordenadas[] coordenadasYate1 = new Coordenadas[1];
        Coordenadas[] coordenadasYate2 = new Coordenadas[1];
        Coordenadas[] coordenadasSubma1 = new Coordenadas[2];
        Coordenadas[] coordenadasSubma2 = new Coordenadas[2];
        Coordenadas[] coordenadasTransa1 = new Coordenadas[3];
        Coordenadas[] coordenadasTransa2 = new Coordenadas[3];

        Coordenadas coorYate1, coorYate2, coorSubma1, coorSubma2, coorTransa1, coorTransa2;
        Coordenadas fin = new Coordenadas();

        Yate yate1 = new Yate();
        Yate yate2 = new Yate();

        Submarino submarino1 = new Submarino();
        Submarino submarino2 = new Submarino();

        Transatlantico transatlantico1 = new Transatlantico();
        Transatlantico transatlantico2 = new Transatlantico();

        Scanner in = new Scanner(System.in);

        int x, y;

        System.out.println("Jugador 1:");
        System.out.println("Introduce la posición del Yate");
        x = in.nextInt();
        y = in.nextInt();
        coorYate1 = new Coordenadas(x, y);

        modificarTablero(coorYate1, "Y", false);
        coordenadasYate1[0] = coorYate1;
        yate1.setCoordenadas(coordenadasYate1);

        int incre = 0;

        System.out.println("Introduce las posiciones del Primer Submarino");
        while (incre < 2) {

            System.out.print("X: ");
            x = in.nextInt();
            System.out.print("Y: ");
            y = in.nextInt();

            coorSubma1 = new Coordenadas(x, y);
            modificarTablero(coorSubma1, "S", false);

            coordenadasSubma1[incre] = coorSubma1;
            incre++;

        }
        submarino1.setCoordenadas(coordenadasSubma1);

        incre = 0;
        System.out.println("Introduce las posiciones del Primer Transatlantico");

        while (incre < 3) {

            System.out.print("X: ");
            x = in.nextInt();
            System.out.print("Y: ");
            y = in.nextInt();

            coorTransa1 = new Coordenadas(x, y);

            coordenadasTransa1[incre] = coorTransa1;
            incre++;

        }
        transatlantico1.setCoordenadas(coordenadasTransa1);

        System.out.println("----------------------------------------------------------------------------");

        System.out.println("Jugador 2:");
        System.out.println("Introduce la posición del Segundo Yate");
        System.out.print("X: ");
        x = in.nextInt();
        System.out.print("Y: ");
        y = in.nextInt();

        coorYate2 = new Coordenadas(x, y);

        coordenadasYate2[0] = coorYate2;
        yate2.setCoordenadas(coordenadasYate2);

        incre = 0;
        System.out.println("Introduce las posiciones del Segundo Submarino");
        while (incre < 2) {

            System.out.print("X: ");
            x = in.nextInt();
            System.out.print("Y: ");
            y = in.nextInt();

            coorSubma2 = new Coordenadas(x, y);

            coordenadasSubma2[incre] = coorSubma2;
            incre++;

        }
        submarino2.setCoordenadas(coordenadasSubma2);

        incre = 0;
        System.out.println("Introduce las posiciones del Segundo Transatlantico");

        while (incre < 3) {

            System.out.print("X: ");
            x = in.nextInt();
            System.out.print("Y: ");
            y = in.nextInt();

            coorTransa2 = new Coordenadas(x, y);

            coordenadasTransa2[incre] = coorTransa2;
            incre++;

        }
        transatlantico2.setCoordenadas(coordenadasTransa2);

        barcoListJ1.add(yate1);
        barcoListJ1.add(submarino1);
        barcoListJ1.add(transatlantico1);

        barcoListJ2.add(yate2);
        barcoListJ2.add(submarino2);
        barcoListJ2.add(transatlantico2);

        int barcoTotalJ1 = 0;
        int barcoTotalJ2 = 0;

        modificarTablero(fin, "letra", true);

        while (barcoTotalJ1 < 6 && barcoTotalJ2 < 6) {

            System.out.println("Barcos Primer Jugador");
            if (jugador1.disparar(barcoListJ2)) {
                System.out.println("Has acertado");
                barcoTotalJ1++;
            } else {
                System.out.println("Has fallado");
            }

            System.out.println("Barcos Segundo Jugador");
            if (jugador2.disparar(barcoListJ1)) {
                System.out.println("Has acertado");
                barcoTotalJ2++;
            } else {
                System.out.println("Has fallado");
            }

        }
        if (barcoTotalJ1 < 6) {
            System.out.println("Ganó el Jugador 2");
        } else {
            System.out.println("Ganó el Jugador 1");
        }

    }

    public static boolean comprobrarSiExiste(ArrayList<Barco> arrayBarco, Coordenadas coordenadas) {

        boolean existe = false;

        for (Barco barco : arrayBarco) {
            for (Coordenadas coordenada : barco.getCoordenadas()) {

                if (coordenada.getX() == coordenadas.getX() && coordenada.getY() == coordenadas.getY()) {
                    existe = true;
                }
            }
        }

        return existe;
    }

    public static void modificarTablero(Coordenadas coordenadas, String letra, boolean usar) {

        String[][] tablero = new String[10][10];
        String[] letras = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
        String[] numeros = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

        if (!usar) {

            tablero[coordenadas.getX()][coordenadas.getY()] = " " + letra + " ";
        }


        if (usar) {
            for (int i = 0; i < letras.length; i++) {
                System.out.print(" " + letras[i] + " ");
            }
            System.out.println("");

            for (int i = 0; i < tablero.length; i++) {
                System.out.print(numeros[i]);
                for (int j = 0; j < tablero[i].length; j++) {
                    System.out.print(tablero[i][j]);

                }
                System.out.println("");
            }

        }

    }

}
