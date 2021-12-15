package com.hallLearning.atividadeIII;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {

    // 1 - Consulta
    public List<Veiculo> list(){

        //Prepara lista que ira retornar veiculos apos consultar o banco;
        List<Veiculo> veiculos = new ArrayList<>();

        try (Connection conn = ConnectionJDBC.getConnection()) {

            String sql = "SELECT * FROM veiculo";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){

                int id = rs.getInt("id");
                String modelo = rs.getString("modelo");
                String placa = rs.getString("placa");


                veiculos.add(new Veiculo(
                        id,
                        modelo,
                        placa
                ));
            }

        } catch(SQLException e){
            System.out.println("Listagem dos veiculos FALHOU!");
            e.printStackTrace();
        }

        return veiculos;
    }

    // 2 - Consulta com id
    public Veiculo getById(int id){
        //Prepara objeto que ira retornar o veiculo apos consultar o banco;
        Veiculo veiculo = new Veiculo();

        try(Connection conn = ConnectionJDBC.getConnection()){

            String sql = "SELECT * FROM veiculo WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                veiculo.setId(rs.getInt("id"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setPlaca(rs.getString("placa"));
            }

        } catch (SQLException e){
            System.out.println("Listagem do Veiculo FALHOU!");
        }

        //retorna veiculo encontrado
        return veiculo;
    }

    // 3 - Inserção
    public void create(Veiculo veiculo){
        try (Connection conn = ConnectionJDBC.getConnection()) {

            String sql = "INSERT INTO veiculo(modelo, placa) VALUES(?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getPlaca());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Inserção BEM SUCEDIDA!. Foi adicionada " + rowsAffected + "linha");

        } catch (SQLException e){
            System.out.println("Inserção FALHOU!");
            e.printStackTrace();
        }
    }

    // 4 - Delete
    public void delete(int id) {

        try(Connection conn = ConnectionJDBC.getConnection()){

            String sql = "DELETE FROM veiculo WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Delete BEM SUCEDIDA! Foi deletada " + rowsAffected + " linha.");

        }catch (SQLException e){
            System.out.println("Delete FALHOU!");
            e.printStackTrace();
        }
    }

    // 5 - Atualizar
    public void update(Veiculo veiculo){
        try(Connection conn = ConnectionJDBC.getConnection()){

            String sql = "UPDATE veiculo SET modelo = ?, placa = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setInt(3, veiculo.getId());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Atualização BEM SUCEDIDA! Foi atualizada: " + rowsAffected + " linha.");

        } catch (SQLException e){
            System.out.println("Atualização FALHOU!");
            e.printStackTrace();
        }
    }
}
