import java.util.ArrayList;

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

    public boolean disparar(ArrayList<Barco> barcoList, int x, int y) {

        int tocado = 0;

        for (Barco barco : barcoList) {
            for (Coordenadas coordenada : barco.getCoordenadas()) {

                if (coordenada.getX() == x && coordenada.getY() == y) {
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
