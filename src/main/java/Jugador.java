import java.util.ArrayList;
import java.util.Scanner;

import barcos.Barco;
import utils.Coordenadas;

public class Jugador {

    private Mundo mundo;

    public Jugador() {

    }

    public Mundo getMundo() {
        return mundo;
    }

    public void setMundo(Mundo mundo) {
        this.mundo = mundo;
    }

    public boolean disparar(ArrayList<Barco> barcoList) {

        Scanner in = new Scanner(System.in);
        int disparoY, tocado = 0;
        String disparoX;

        System.out.println("Introduce las coordenadas de Disparo:");

        System.out.println("Introduce la X");
        disparoX = in.nextLine();

        System.out.println("Introduce la Y");
        disparoY = in.nextInt();

        for (Barco barco : barcoList) {
            for (Coordenadas coordenada : barco.getCoordenadas()) {

                if (coordenada.getX() == Mundo.cambiarLetra(disparoX) && coordenada.getY() == disparoY) {
                    tocado = 1;
                }
            }
        }
        if (tocado == 1) {
            return true;
        } else {
            return false;
        }

    }
}
