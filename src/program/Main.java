package program;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.*;
import config.Connect;
import exceptions.Exceptions;
import javafx.application.Application;
import viewer.Tela;

public class Main {
    public static void main(String[] args) {

        Application.launch(Tela.class, args);

    }
}