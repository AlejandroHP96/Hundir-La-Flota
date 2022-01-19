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
        String[] numeros = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

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

        boolean subma = false;
        boolean transa = false;

        ArrayList<Barco> barcoList = new ArrayList<>();

        Coordenadas[] coordenadasYate1 = new Coordenadas[1];
        Coordenadas[] coordenadasYate2 = new Coordenadas[1];
        Coordenadas[] coordenadasSubma1 = new Coordenadas[2];
        Coordenadas[] coordenadasSubma2 = new Coordenadas[2];
        Coordenadas[] coordenadasTransa1 = new Coordenadas[3];
        Coordenadas[] coordenadasTransa2 = new Coordenadas[3];

        Coordenadas coorYate1, coorYate2, coorSubma1, coorSubma2, coorTransa1, coorTransa2;

        Yate yate1 = new Yate();
        Yate yate2 = new Yate();

        Submarino submarino1 = new Submarino();
        Submarino submarino2 = new Submarino();

        Transatlantico transatlantico1 = new Transatlantico();
        Transatlantico transatlantico2 = new Transatlantico();

        Scanner in = new Scanner(System.in);

        int x, y;

        System.out.println("Jugador 1");
        System.out.println("Introduce la posición del Yate");
        x = in.nextInt();
        y = in.nextInt();
        coorYate1 = new Coordenadas(x, y);

        coordenadasYate1[0] = coorYate1;
        yate1.setCoordenadas(coordenadasYate1);

        System.out.println("Introduce la posición del Segundo Yate");
        System.out.print("X: ");
        x = in.nextInt();
        System.out.print("Y: ");
        y = in.nextInt();

        coorYate2 = new Coordenadas(x, y);

        coordenadasYate2[0] = coorYate2;
        yate2.setCoordenadas(coordenadasYate2);

        int incre = 0;

        while (incre < 2) {

            System.out.println("Introduce las posiciones del Primer Submarino");

            System.out.print("X: ");
            x = in.nextInt();
            System.out.print("Y: ");
            y = in.nextInt();

            coorSubma1 = new Coordenadas(x, y);

            coordenadasSubma1[incre] = coorSubma1;
            incre++;

        }
        submarino1.setCoordenadas(coordenadasSubma1);

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

        barcoList.add(yate1);
        barcoList.add(yate2);
        barcoList.add(submarino1);
        barcoList.add(submarino2);
        barcoList.add(transatlantico1);
        barcoList.add(transatlantico2);

        
        if(jugador1.disparar(barcoList)){
            System.out.println("Has acertado");
        }else{
            System.out.println("Has fallado");
        }

    }

}
