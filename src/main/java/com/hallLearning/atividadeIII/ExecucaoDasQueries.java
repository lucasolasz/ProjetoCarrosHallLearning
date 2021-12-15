package com.hallLearning.atividadeIII;

import java.util.List;

public class ExecucaoDasQueries {
    public static void main(String[] args) {

        VeiculoDAO veiculoDAO = new VeiculoDAO();

        //1 - consulta genérica que retorna todos os veiculos
//        List<Veiculo> veiculos = veiculoDAO.list();
        //Usado para imprmir registros na tela
//        veiculos.stream().forEach(System.out::println);

        //2 - Consulta passando o id. Basta alterar o id no parâmetro
//        Veiculo veiculoConsulta = veiculoDAO.getById(1);
        //Usado para imprmir registros na tela
//        System.out.println(veiculoConsulta);
//
//        //3 - Inserção. Basta alterar os valores nos parâmetros
//        Veiculo veiculoInsercao = new Veiculo(
//                "Ranger",
//                "RFL-6789"
//        );
//        veiculoDAO.create(veiculoInsercao);
//        //Usado para imprmir registros na tela
//        veiculoDAO.list().stream().forEach(System.out::println);
//
//        //4 - Delete
//        System.out.println("===========ANTES===========");
//        veiculoDAO.list().stream().forEach(System.out::println);
//
//        //Para deletar, inclua o id no parametro
//        veiculoDAO.delete(1);
//        System.out.println("==========DEPOIS===========");
//        veiculoDAO.list().stream().forEach(System.out::println);

//
        //5 - Atualizar
//        System.out.println("===========ANTES===========");
//        veiculoDAO.list().stream().forEach(System.out::println);
//
//        //Atualiza veiculo de acordo com o id informado no parametro
//        Veiculo veiculoAtualiza = veiculoDAO.getById(3);
//        veiculoAtualiza.setModelo("Honda");
//        veiculoAtualiza.setPlaca("JHL-8976");
//
//        veiculoDAO.update(veiculoAtualiza);
//
//        System.out.println("==========DEPOIS===========");
//        veiculoDAO.list().stream().forEach(System.out::println);

    }
}
