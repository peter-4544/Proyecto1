package mx.utng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mx.utng.database.Conexion;
import mx.utng.model.Cancion;
import mx.utng.model.Usuario;

public class UsuarioDAO {
    public boolean validar(String usuario,String password){

        String sql =
        "SELECT * FROM tb_usuarios WHERE nombre=? AND password=?";

        try(Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, usuario);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        }catch(SQLException e){

            e.printStackTrace();

        }

        return false;

    } 

        // LISTAR TODOS LOS LIBROS
    public List<Usuario> listar() {

        List<Usuario> lista = new ArrayList<>();

        String sql = "SELECT * FROM tb_usuarios";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setPasword(rs.getString("password"));

                lista.add(usuario);
            }


        } catch (SQLException e) {
            System.out.println("Error al listar libros: " + e.getMessage());
        }

        return lista;
    }
    
    //Guardar 
    public boolean guardar(Usuario usuario) {
        String sql = "INSERT INTO tb_usuarios(nombre, apellidos, direccion, telefono, correo, password) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getDireccion());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getCorreo());
            ps.setString(6, usuario.getPasword());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    //ELIMINAR
    public boolean eliminar(int id) {
        String sql = "DELETE FROM tb_usuarios WHERE id=?";
        try(Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1,id);
            ps.executeUpdate();
            return true;

        } catch(SQLException e){

            System.out.println("Error al eliminar Usuario: " + e.getMessage());
            return false;
        }

    }

    // buscar LIBRO
    public Usuario buscar(int id) {
        String sql = "SELECT * FROM tb_usuarios WHERE id=?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);){
                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                Usuario usuario = null;
                if(rs.next()){ 
                    usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellidos(rs.getString("apellidos"));
                    usuario.setDireccion(rs.getString("direccion"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setPasword(rs.getString("password"));
                }
            return usuario;
                
        } catch (SQLException e) {
            System.out.println("Error al buscar Usuario: " + e.getMessage());
            return null;
        }
    }

    //Actualizar
    public boolean actualizar(Usuario usuario) {
        String sql = "UPDATE tb_usuarios SET nombre=?,apellidos=?,direccion=?,telefono=?,correo=?,password=? WHERE id=?";
        try(Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getDireccion());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getCorreo());
            ps.setString(6, usuario.getPasword());
            ps.setInt(7, usuario.getId());

            ps.executeUpdate();

            return true;

        } catch(SQLException e){
            System.out.println("Error al actualizar libro: " + e.getMessage());
            return false;
        }

    }
}