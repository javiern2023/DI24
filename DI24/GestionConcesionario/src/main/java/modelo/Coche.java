package modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coche {
    private int id;
    private String marca;
    private String modelo;
    private double precio;
    private boolean disponible;
}
