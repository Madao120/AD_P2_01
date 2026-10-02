package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Contiene las operaciones CRUD sobre la tabla "anime".
public class AnimeDAO {

    // CREATE → Inserta un anime en la base de datos.
    public void insertar(Anime anime) {

        String sql = "INSERT INTO anime (nome, descripcion, data, puntuacion) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection conn = new Conexion().conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, anime.getNome());
            ps.setString(2, anime.getDescripcion());
            ps.setDate(3, anime.getData());
            ps.setInt(4, anime.getPuntuacion());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }


    // READ → Lee todos los animes de la base de datos.
    public void listarTodos() {

        String sql = "SELECT * FROM anime";

        try (Connection conn = new Conexion().conexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                System.out.println(
                        rs.getString("nome") + " | " +
                                rs.getString("descripcion") + " | " +
                                rs.getDate("data") + " | " +
                                rs.getInt("puntuacion")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
    }


    // READ → Busca un anime concreto por su nombre.
    public void buscarPorNome(String nome) {

        String sql = "SELECT * FROM anime WHERE nome = ?";

        try (Connection conn = new Conexion().conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getString("nome") + " | " +
                                rs.getString("descripcion") + " | " +
                                rs.getDate("data") + " | " +
                                rs.getInt("puntuacion")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
    }


    // UPDATE → Actualiza la puntuación de un anime.
    public void actualizar(String nome, int nuevaPuntuacion) {

        String sql = "UPDATE anime SET puntuacion = ? WHERE nome = ?";

        try (Connection conn = new Conexion().conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, nuevaPuntuacion);
            ps.setString(2, nome);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }


    // DELETE → Elimina un anime por su nombre.
    public void eliminar(String nome) {

        String sql = "DELETE FROM anime WHERE nome = ?";

        try (Connection conn = new Conexion().conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nome);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}
