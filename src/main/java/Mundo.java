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
    private String[][] tablero1 = new String[10][10];
    private String[][] tablero2 = new String[10][10];
    private ArrayList<Barco> barcoListJ1 = new ArrayList<>();
    private ArrayList<Barco> barcoListJ2 = new ArrayList<>();

    public void mostrarTablero(String[][] tableroJugador) {

        String[] letras = { "A ", "B ", "C ", "D ", "E ", "F ", "G ", "H ", "I ", "J " };
        String[] numeros = { "  1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

        for (int i = 0; i < letras.length; i++) {
            System.out.print(" " + numeros[i] + " ");
        }
        System.out.println("");

        for (int i = 0; i < tableroJugador.length; i++) {
            for (int j = 0; j < tableroJugador[i].length; j++) {
                tableroJugador[i][j] = " * ";

            }
        }

        for (int i = 0; i < tableroJugador.length; i++) {
            System.out.print(letras[i]);
            for (int j = 0; j < tableroJugador[i].length; j++) {
                System.out.print(tableroJugador[i][j]);

            }
            System.out.println("");
        }

    }

    public void generarBarcos() {

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

        String letraX;

        System.out.println("Jugador 1:");
        System.out.println("Introduce la posición del Yate");
        System.out.print("X: ");
        letraX = in.next();
        System.out.print("Y: ");
        y = in.nextInt();

        x = cambiarLetra(letraX);
        coorYate1 = new Coordenadas(x, --y);
        coordenadasYate1[0] = coorYate1;
        yate1.setCoordenadas(coordenadasYate1);
        tablero1[x][y] = " Y ";
        tableroFinal(tablero1);

        int incre = 0;

        System.out.println("Introduce las posiciones del Submarino");
        while (incre < 2) {

            System.out.print("X: ");
            letraX = in.next();
            System.out.print("Y: ");
            y = in.nextInt();

            x = cambiarLetra(letraX);

            coorSubma1 = new Coordenadas(x, --y);

            coordenadasSubma1[incre] = coorSubma1;
            incre++;
            tablero1[x][y] = " S ";

        }
        tableroFinal(tablero1);
        submarino1.setCoordenadas(coordenadasSubma1);

        incre = 0;
        System.out.println("Introduce las posiciones del Transatlantico");

        while (incre < 3) {

            System.out.print("X: ");
            letraX = in.next();
            System.out.print("Y: ");
            y = in.nextInt();

            x = cambiarLetra(letraX);

            coorTransa1 = new Coordenadas(x, --y);

            coordenadasTransa1[incre] = coorTransa1;
            incre++;
            tablero1[x][y] = " T ";

        }
        transatlantico1.setCoordenadas(coordenadasTransa1);

        System.out.println("----------------------------------------------------------------------------\n");

        System.out.println("Jugador 2:");
        System.out.println("Introduce la posición del Yate");
        System.out.print("X: ");
        letraX = in.next();
        System.out.print("Y: ");
        y = in.nextInt();

        x = cambiarLetra(letraX);
        coorYate2 = new Coordenadas(x, --y);

        coordenadasYate2[0] = coorYate2;
        yate2.setCoordenadas(coordenadasYate2);
        tablero2[x][y] = " Y ";

        incre = 0;
        System.out.println("Introduce las posiciones del Submarino");
        while (incre < 2) {

            System.out.print("X: ");
            letraX = in.next();
            System.out.print("Y: ");
            y = in.nextInt();

            x = cambiarLetra(letraX);

            coorSubma2 = new Coordenadas(x, --y);

            coordenadasSubma2[incre] = coorSubma2;
            incre++;
            tablero2[x][y] = " S ";

        }
        submarino2.setCoordenadas(coordenadasSubma2);

        incre = 0;
        System.out.println("Introduce las posiciones del Transatlantico");

        while (incre < 3) {

            System.out.print("X: ");
            letraX = in.next();
            System.out.print("Y: ");
            y = in.nextInt();

            x = cambiarLetra(letraX);

            coorTransa2 = new Coordenadas(x, --y);

            coordenadasTransa2[incre] = coorTransa2;
            incre++;
            tablero2[x][y] = " T ";

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

        while (barcoTotalJ1 < 6 && barcoTotalJ2 < 6) {
            int disparoY;
            String disparoX;

            System.out.println("Jugador 1");

            System.out.println("Introduce las coordenadas de Disparo:");

            tableroFinal(tablero2);
            in.nextLine();
            System.out.println("Introduce la X");
            disparoX = in.nextLine();

            System.out.println("Introduce la Y");
            disparoY = in.nextInt();
            if (jugador1.disparar(barcoListJ2, Mundo.cambiarLetra(disparoX), disparoY)) {
                System.out.println("Has acertado");
                barcoTotalJ1++;
                tablero2[Mundo.cambiarLetra(disparoX)][disparoY] = " X ";
                removerCoordenada(barcoListJ2, x, y);

            } else {
                System.out.println("Has fallado");
                tablero2[Mundo.cambiarLetra(disparoX)][disparoY] = " ~ ";
            }
            mostrar(barcoListJ2);
            System.out.println("-------------------------------------------------------");

            System.out.println("Jugador 2");
            System.out.println("Introduce las coordenadas de Disparo:");

            System.out.println("Introduce la X");
            disparoX = in.next();

            System.out.println("Introduce la Y");
            disparoY = in.nextInt();
            if (jugador2.disparar(barcoListJ1, Mundo.cambiarLetra(disparoX), disparoY)) {
                System.out.println("Has acertado");
                tablero1[Mundo.cambiarLetra(disparoX)][disparoY] = "X";
                barcoTotalJ2++;
                removerCoordenada(barcoListJ1, x, y);
            } else {
                System.out.println("Has fallado");
                tablero1[Mundo.cambiarLetra(disparoX)][disparoY] = "~";

            }
            mostrar(barcoListJ1);

        }
        if (barcoTotalJ1 < 6) {
            System.out.println("Ganó el Jugador 2");
        } else {
            System.out.println("Ganó el Jugador 1");
        }

    }

    public void tableroFinal(String[][] tablero) {

        String[] letras = { "A ", "B ", "C ", "D ", "E ", "F ", "G ", "H ", "I ", "J " };
        String[] numeros = { "  1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

        for (int i = 0; i < letras.length; i++) {
            System.out.print(" " + numeros[i] + " ");
        }
        System.out.println("");

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == null) {

                    tablero[i][j] = " * ";
                }

            }
        }

        for (int i = 0; i < tablero.length; i++) {
            System.out.print(letras[i]);
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j]);

            }
            System.out.println("");
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

    public void removerCoordenada(ArrayList<Barco> listaBarcos, int x, int y) {

        for (Barco barco : listaBarcos) {
            for (Coordenadas coordenada : barco.getCoordenadas()) {

                if (coordenada.getX() == x && coordenada.getY() == y) {
                    coordenada.setX(20);
                    coordenada.setY(20);
                }
            }
        }
    }

    public static int cambiarLetra(String letra) {

        int numero = 0;

        switch (letra.toUpperCase()) {
            case "A":
                numero = 0;
                break;

            case "B":
                numero = 1;
                break;

            case "C":
                numero = 2;
                break;

            case "D":
                numero = 3;
                break;

            case "E":
                numero = 4;
                break;

            case "F":
                numero = 5;
                break;

            case "G":
                numero = 6;
                break;

            case "H":
                numero = 7;
                break;

            case "I":
                numero = 8;
                break;

            case "J":
                numero = 9;
                break;
        }
        return numero;
    }

    public void mostrar(ArrayList<Barco> lista) {
        for (Barco barco : lista) {
            for (Coordenadas coordenada : barco.getCoordenadas()) {
                System.out.print(coordenada.getX() + " ");
                System.out.println(coordenada.getY());
            }
        }

    }

}
