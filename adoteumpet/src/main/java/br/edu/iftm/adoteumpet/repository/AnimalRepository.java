package br.edu.iftm.adoteumpet.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import br.edu.iftm.adoteumpet.model.Animal;
import br.edu.iftm.adoteumpet.model.Usuario;

@Repository
public class AnimalRepository {
    @Autowired
    JdbcTemplate jdbc;

    public List<Animal> buscaTodosAnimais() {
        String consulta = "select * from animal;";

        return jdbc.query(consulta,
                (resultados, numeroDaLinha) -> new Animal(resultados.getInt("id"), resultados.getString("nome"), 
                resultados.getString("data_nasc"), (char)resultados.getInt("sexo"),resultados.getString("raca"),
                (char)resultados.getInt("porte"),  resultados.getString("data_entrada"), resultados.getString("descricao"), resultados.getString("data_adocao"), resultados.getBoolean("validacao_adocao"), 
                new Usuario(resultados.getInt("id"), resultados.getString("nome"),resultados.getString("cpf"), resultados.getString("email"), 
                resultados.getString("endereco"), resultados.getString("telefone"), resultados.getString("data_nasc"), (char)resultados.getInt("sexo"), resultados.getString("senha"))));
    }

    public int gravaAnimal(Animal animal) {
        String consulta = "insert into animal(nome, data_nasc, raca, porte, data_entrada, descricao, data_adocao, validacao_adocao, id_user) values(?,?,?,?,?,?,?,?,?)";

        return jdbc.update(consulta, animal.getNome(), animal.getData_nasc(), animal.getRaca(), animal.getPorte(), animal.getData_entrada(), animal.getData_adocao(), animal.getValidacao_adocao(), animal.getUsuario().getId());
    }

    public int excluirAnimal(Integer cod) {
        System.out.println(" -------------> id = " + cod);
        String consulta = "delete from animal where id = ?";
        return jdbc.update(consulta, cod);
    }

    public Animal buscaPorIdAnimal(Integer id) {
        return jdbc.queryForObject("select * from animal where id = ?", (resultSet, rowNum) -> {
            return new Animal(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("data_nasc"),
            (char)resultSet.getInt("sexo") , resultSet.getString("raca"),  
            (char)resultSet.getInt("porte"),resultSet.getString("data_entrada"), resultSet.getString("descricao"), resultSet.getString("data_adocao"), resultSet.getBoolean("validacao_adocao"), 
            new Usuario(resultSet.getInt("id"), resultSet.getString("nome"),resultSet.getString("cpf"), resultSet.getString("email"), 
            resultSet.getString("endereco"), resultSet.getString("telefone"), resultSet.getString("data_nasc"), (char)resultSet.getInt("sexo"), resultSet.getString("senha")));
        }, id);
    }

    public int atualizaAnimal(Animal animal) {
        String consulta = "update animal set nome = ? where id = ?";
        return jdbc.update(consulta, animal.getId(), animal.getNome(), animal.getData_nasc(), animal.getRaca(), animal.getPorte(), animal.getData_entrada(), animal.getDescricao(), animal.getData_adocao(), animal.getValidacao_adocao());
    }
}
