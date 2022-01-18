import barcos.Barco;
import barcos.Submarino;
import barcos.Transatlantico;
import barcos.Yate;
import utils.Coordenadas;

import java.nio.charset.CoderResult;
import java.util.ArrayList;
import java.util.Scanner;

public class Mundo {

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

        ArrayList<Barco> barcoList = new ArrayList<>();

        Coordenadas[] coordenadasArray = new Coordenadas[6];
        Coordenadas coordenadas;

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
        coordenadas = new Coordenadas(x, y);

        coordenadasArray[0] = coordenadas;
        yate1.setCoordenadas(coordenadasArray);

        System.out.println("Introduce la posición del Segundo Yate");
        x = in.nextInt();
        y = in.nextInt();

        coordenadasArray[1] = coordenadas;
        yate2.setCoordenadas(coordenadasArray);

        barcoList.add(yate1);
        barcoList.add(yate2);
        System.out.println(barcoList.size());

        for (int i = 0; i < barcoList.size(); i++) {
            System.out.println("Yate:" + barcoList.get(i).getCoordenadas());
        }

    }

}
