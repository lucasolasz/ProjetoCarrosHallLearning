package com.hallLearning.atividadeIII;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionJDBC {

    private ConnectionJDBC() { throw new UnsupportedOperationException(); }

    public static Connection getConnection() {

        Connection connection = null;


            String connectionUrl = "jdbc:mysql://localhost/desafio_veiculos";
            String user = "root";
            String password = "";

            try {
                connection = DriverManager.getConnection(connectionUrl, user, password);
                System.out.println("CONECTADO com sucesso!\n");
            } catch (SQLException e) {
                System.out.println("FALHA ao tentar criar conexão");
                throw new RuntimeException(e);
            }

        return connection;
    }


}
