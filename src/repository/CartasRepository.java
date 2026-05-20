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
}
