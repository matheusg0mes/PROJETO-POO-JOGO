package config;

import exceptions.Exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connect {

    private  static Properties properties() {
        try {
            Properties props = new Properties();
            FileInputStream file = new FileInputStream("db.properties");
            props.load(file);
            return props;
        } catch (FileNotFoundException ex) {
            throw new Exceptions("Arquivo não encontrado");
        }catch(IOException ex){
            throw new Exceptions("Arquivo vazio");
        }
    }

    public static Connection conexao() {
        try {
            Properties props =  properties();

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

           return DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            throw new Exceptions("Erro na conexão");
        }
    }
}
