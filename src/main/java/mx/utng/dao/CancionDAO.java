package mx.utng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mx.utng.database.Conexion;
import mx.utng.model.Cancion;

public class CancionDAO {

    public boolean guardar(Cancion cancion) {

        String sql = "INSERT INTO tb_canciones(titulo, interprete, genero, anio) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cancion.getTitulo());
            ps.setString(2, cancion.getInterprete());
            ps.setString(3, cancion.getGenero());
            ps.setInt(4, cancion.getAnio());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    // LISTAR TODAS LAS CANCIONES
    public List<Cancion> listar() {

        List<Cancion> lista = new ArrayList<>();

        String sql = "SELECT * FROM tb_canciones";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Cancion cancion = new Cancion();

                cancion.setId(rs.getInt("id_cancion"));
                cancion.setTitulo(rs.getString("titulo"));
                cancion.setInterprete(rs.getString("interprete"));
                cancion.setGenero(rs.getString("genero"));
                cancion.setAnio(rs.getInt("anio"));

                lista.add(cancion);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar canciones: " + e.getMessage());
        }

        return lista;
    }

    // INSERTAR CANCION
    public boolean insertar(Cancion cancion) {

        String sql = "INSERT INTO tb_canciones(titulo, interprete, genero, anio) VALUES (?,?,?,?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cancion.getTitulo());
            ps.setString(2, cancion.getInterprete());
            ps.setString(3, cancion.getGenero());
            ps.setInt(4, cancion.getAnio());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar cancion: " + e.getMessage());
            return false;
        }

    }

    // ACTUALIZAR CANCION
    public boolean actualizar(Cancion cancion) {

        String sql = "UPDATE tb_canciones SET titulo=?, interprete=?, genero=?, anio=? WHERE id_cancion=?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cancion.getTitulo());
            ps.setString(2, cancion.getInterprete());
            ps.setString(3, cancion.getGenero());
            ps.setInt(4, cancion.getAnio());
            ps.setInt(5, cancion.getId());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al actualizar cancion: " + e.getMessage());
            return false;
        }

    }

    // ELIMINAR CANCION
    public boolean eliminar(int idCancion) {

        String sql = "DELETE FROM tb_canciones WHERE id_cancion=?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCancion);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al eliminar cancion: " + e.getMessage());
            return false;
        }

    }

    // BUSCAR CANCION
    public Cancion buscar(int idCancion) {

        String sql = "SELECT * FROM tb_canciones WHERE id_cancion=?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCancion);

            ResultSet rs = ps.executeQuery();
            Cancion cancion = null;
            if (rs.next()) {
                cancion = new Cancion();
                cancion.setId(rs.getInt("id_cancion"));
                cancion.setTitulo(rs.getString("titulo"));
                cancion.setInterprete(rs.getString("interprete"));
                cancion.setGenero(rs.getString("genero"));
                cancion.setAnio(rs.getInt("anio"));
            }
            return cancion;

        } catch (SQLException e) {
            System.out.println("Error al buscar cancion: " + e.getMessage());
            return null;
        }
    }

}