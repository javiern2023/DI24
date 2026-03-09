package dao;

import dao.ConexionBD;
import modelo.Coche;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CocheDAO {

    public List<Coche> getCochesDisponibles() {
        List<Coche> coches = new ArrayList<>();
        String sql = "SELECT * FROM coches WHERE disponible = TRUE";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Coche c = new Coche();
                c.setId(rs.getInt("id"));
                c.setMarca(rs.getString("marca"));
                c.setModelo(rs.getString("modelo"));
                c.setPrecio(rs.getDouble("precio"));
                c.setDisponible(rs.getBoolean("disponible"));
                coches.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return coches;
    }
}
