package repository;

import config.Connect;
import exceptions.Exceptions;
import model.Cartas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartasRepository {

    Connect conexao = new Connect();

    public Cartas criar(Cartas novo){
        String sql = "INSERT INTO carta (id_carta, velocidade, altura) VALUES (?, ?, ?)";

        try (Connection conn = Connect.conexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, novo.getId());
            stmt.setDouble(2, novo.getVelocidade());
            stmt.setDouble(3, novo.getAltura());
            stmt.executeUpdate();


        } catch (SQLException ex) {
            throw new Exceptions("Erro ao criar carta: " + ex.getMessage());
        }
        return novo;


    }
    public void deletarPorId(int id) {
        String sql = "DELETE FROM carta WHERE id_carta = ?";

        try (Connection conn = Connect.conexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0) {
                throw new Exceptions("Carta com id " + id + " não encontrada.");
            }

        } catch (SQLException ex) {
            throw new Exceptions("Erro ao deletar carta: " + ex.getMessage());
        }
    }

    public Cartas buscarPorId(int id) {
        String sql = "SELECT * FROM carta WHERE id_carta = ?";

        try (Connection conn = Connect.conexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            var rs = stmt.executeQuery();

            if (rs.next()) {
                return new Cartas(
                        rs.getInt("id_carta"),
                        rs.getDouble("velocidade"),
                        rs.getDouble("altura")
                );
            } else {
                throw new Exceptions("Carta com id " + id + " não encontrada.");
            }

        } catch (SQLException ex) {
            throw new Exceptions("Erro ao buscar carta: " + ex.getMessage());
        }
    }
    public Cartas atualizar(Cartas carta) {
        String sql = "UPDATE carta SET velocidade = ?, altura = ? WHERE id_carta = ?";

        try (Connection conn = Connect.conexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, carta.getVelocidade());
            stmt.setDouble(2, carta.getAltura());
            stmt.setInt(3, carta.getId());
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0) {
                throw new Exceptions("Carta com id " + carta.getId() + " não encontrada.");
            }

        } catch (SQLException ex) {
            throw new Exceptions("Erro ao atualizar carta: " + ex.getMessage());
        }
        return carta;
    }
}
