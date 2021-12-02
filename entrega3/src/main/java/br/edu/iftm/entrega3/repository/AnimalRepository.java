package br.edu.iftm.entrega3.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import br.edu.iftm.entrega3.model.Animal;

@Repository
public class AnimalRepository {
    @Autowired
    JdbcTemplate jdbc;

    public List<Animal> buscaTodosAnimais() {
        String consulta = "select * from animal;";

        return jdbc.query(consulta,
                (resultados, numeroDaLinha) -> new Animal(resultados.getInt("id"), resultados.getString("nome"), resultados.getString("raca"), resultados.getString("dataNasc"), resultados.getString("idade"), resultados.getString("porte"), resultados.getString("descricao")));
    }

    public int gravaAnimal(Animal animal) {
        String consulta = "insert into animal(nome, raca, dataNasc, idade, porte, descricao) values(?,?,?,?,?,?)";

        return jdbc.update(consulta, animal.getNome(), animal.getRaca(), animal.getDataNasc(), animal.getIdade(), animal.getPorte(), animal.getDescricao());
    }

    public int excluirAnimal(Integer cod) {
        System.out.println(" -------------> id = " + cod);
        String consulta = "delete from animal where id = ?";
        return jdbc.update(consulta, cod);
    }

    public Animal buscaPorIdAnimal(Integer id) {
        return jdbc.queryForObject("select * from animal where id = ?", (resultSet, rowNum) -> {
            return new Animal(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("raca"), resultSet.getString("dataNasc"), resultSet.getString("idade"), resultSet.getString("porte"),  resultSet.getString("descricao"));
        }, id);
    }

    public int atualizaAnimal(Animal animal) {
        String consulta = "update animal set nome = ? where id = ?";
        return jdbc.update(consulta, animal.getId(), animal.getNome(), animal.getRaca(), animal.getDataNasc(),
                animal.getIdade(), animal.getPorte(), animal.getDescricao());
    }
}
