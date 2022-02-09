package barcos;

import utils.Coordenadas;

public class Barco {

    private int longitud;
    private Coordenadas[] coordenadas;

    public Barco(int longitud) {
        this.longitud = longitud;
        this.coordenadas = new Coordenadas[longitud];

    }

    public Barco() {
    }

    public int getLongitud() {
        return longitud;
    }

    public Coordenadas[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenadas[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public boolean tocado(int x, int y) {
        for (int i = 0; i < coordenadas.length; i++) {

            if (this.coordenadas[i].getX() == x && this.coordenadas[i].getY() == y) {
                return true;

            }
        }
        return false;
    }

}
