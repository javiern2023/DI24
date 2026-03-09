package modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    private int id;
    private int idUsuario;
    private int idCoche;
    private Date fecha;
}
