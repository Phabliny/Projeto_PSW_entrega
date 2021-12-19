package br.edu.iftm.adoteumpet.repository;

import java.util.ArrayList;
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
        List<Animal> lista = new ArrayList<Animal>();
        lista = jdbc.query(consulta,
                (res, numeroDaLinha) -> new Animal(res.getInt("id"), res.getString("nome"),
                        res.getString("data_nasc"), res.getString("sexo").charAt(0),
                        res.getString("raca"),
                        res.getString("porte").charAt(0), res.getString("data_entrada"),
                        res.getString("descricao"), res.getString("data_adocao"),
                        res.getBoolean("validacao_adocao")));
        for (Animal animal : lista) { System.out.println("----------------" + animal.getNome());
            String sql = "SELECT u.id , u.nome, u.cpf, u.email FROM ANIMAL, USUARIO u WHERE u.ID = ANIMAL.ID_USER AND ANIMAL.ID = ?;";
            Usuario usuario = null;
            try {
                usuario = jdbc.queryForObject( 
                    sql,
                    (res, linha) -> new Usuario(
                            res.getInt("id"),
                            res.getString("nome"),
                            res.getString("cpf"),
                            res.getString("email") /*,
                            res.getString("endereco"),
                            res.getString("telefone"),
                            res.getString("dataNasc"),
                            (char) res.getInt("sexo"),
                            res.getString("senha")*/),
                    animal.getId());
            } catch (Exception e) {
                System.out.println("ERRO ================================== " + e.getMessage());
            } 
            animal.setUsuario(usuario);
        }
        return lista;
    }

    public int gravaAnimal(Animal animal) {
        System.out.println("================" + animal);
        String consulta = "insert into animal(nome, data_nasc, sexo, raca, porte, data_entrada, descricao) values(?,?,?,?,?,?,?)";
        return jdbc.update(consulta, animal.getNome(), animal.getData_nasc(), animal.getSexo(), animal.getRaca(),
                animal.getPorte(), animal.getData_entrada(), animal.getDescricao());
    }

    public int excluirAnimal(Integer cod) {
        String consulta = "delete from animal where id = ?";
        return jdbc.update(consulta, cod);
    }

    public Animal buscaPorIdAnimal(Integer id) {
        return jdbc.queryForObject("select * from animal where id_pet = ?", (resultSet, rowNum) -> {
            return new Animal(resultSet.getInt("id_pet"), resultSet.getString("nome"), resultSet.getString("data_nasc"), resultSet.getString("sexo").charAt(0), resultSet.getString("raca"),
                    resultSet.getString("porte").charAt(0), resultSet.getString("data_entrada"),
                    resultSet.getString("descricao"), resultSet.getString("data_adocao"),
                    resultSet.getBoolean("validacao_adocao"));
        }, id);
    }

    public int atualizaAnimal(Animal animal) {
        String consulta = "update animal set nome = ? where id_pet = ?";
        return jdbc.update(consulta, animal.getNome(), animal.getId());
    }


    /* ============================= teste validação adoção ==============================================*/

    public List<Animal> buscaAnimaisEmAdocao() {
        String consulta = "select * from animais where id_user IS NOT NULL;";
        return jdbc.query(consulta,
        (res,linha) -> new Animal(res.getInt("id_pet"), res.getString("nome"),
                        res.getString("data_nasc"), res.getString("sexo").charAt(0),
                        res.getString("raca"),
                        res.getString("porte").charAt(0), res.getString("data_entrada"),
                        res.getString("descricao"), res.getString("data_adocao"),
                        res.getBoolean("validacao_adocao"),
                        new Usuario())
        );
    }

    public void atualizaAdocao(Animal animal) {
    }
}
