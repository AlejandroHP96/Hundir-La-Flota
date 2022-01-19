package utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coordenadas {

    private int x;
    private int y;

    public String toString(){

        return "X = " + this.x + "\nY = " + this.y;
    }

}
