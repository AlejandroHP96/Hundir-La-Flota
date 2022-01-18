import java.util.ArrayList;
import java.util.Scanner;

import barcos.Barco;

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

    public boolean disparar(ArrayList barcos) {

        Scanner in = new Scanner(System.in);
        int disparoX, disparoY;

        Barco barco = new Barco();

        System.out.println("Introduce la X");
        disparoX = in.nextInt();

        System.out.println("Introduce la Y");
        disparoY = in.nextInt();

        if (barco.tocado(disparoX, disparoY) == true) {
            System.out.println("Has acertado");
            return true;
        } else {
            System.out.println("Has fallado");
            return false;
        }
         
    }
}
