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
        String consulta = "select * from animais;";
        List<Animal> lista = new ArrayList<Animal>();
        lista = jdbc.query(consulta,
                (res, numeroDaLinha) -> new Animal(res.getInt("id"), res.getString("nome"),
                        res.getDate("data_nasc"), res.getString("sexo").charAt(0),
                        res.getString("raca"),
                        res.getString("porte"), res.getDate("data_entrada"),
                        res.getString("descricao"), res.getDate("data_adocao"),
                        res.getBoolean("validacao_adocao"), new Usuario(), res.getString("imagem")));
        for (Animal animal : lista) {
            System.out.println("----------------" + animal.getNome());
            String sql = "SELECT u.id , u.nome, u.cpf, u.email FROM animais a, usuarios u WHERE u.ID = a.ID_USER AND a.ID = ?;";
            Usuario usuario = null;
            try {
                usuario = jdbc.queryForObject(
                        sql,
                        (res, linha) -> new Usuario(
                                res.getInt("id"),
                                res.getString("nome"),
                                res.getString("cpf"),
                                res.getString("email") /*
                                                        * ,
                                                        * res.getString("endereco"),
                                                        * res.getString("telefone"),
                                                        * res.getString("dataNasc"),
                                                        * (char) res.getInt("sexo"),
                                                        * res.getString("senha")
                                                        */),
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
        String consulta = "insert into animais(nome, data_nasc, sexo, raca, porte, descricao, imagem) values(?,?,?,?,?,?,?)";
        return jdbc.update(consulta, animal.getNome(), animal.getData_nasc(), animal.getSexo() + "", animal.getRaca(),
                animal.getPorte(), animal.getDescricao(), animal.getImagem());
    }

    public int excluirAnimal(Integer cod) {
        String consulta = "delete from animais where id = ?";
        return jdbc.update(consulta, cod);
    }

    public Animal buscaPorIdAnimal(Integer id) {
        return jdbc.queryForObject(
                "select * from animais where id_pet = ?",
                (res, rowNum) -> {
                    return new Animal(res.getInt("id"), res.getString("nome"), res.getDate("data_nasc"),
                            res.getString("sexo").charAt(0), res.getString("raca"), res.getString("porte"),
                            res.getDate("data_entrada"), res.getString("descricao"), res.getDate("data_adocao"),
                            res.getBoolean("validacao_adocao"), new Usuario(), res.getString("imagem"));
                },
                id);
    }

    public int atualizaAnimal(Animal animal) {
        String consulta = "update animais set nome = ? where id_pet = ?";
        return jdbc.update(consulta, animal.getNome(), animal.getId());
    }

    /*
     * ============================= teste validação adoção
     */

    public List<Animal> buscaAnimaisEmAdocao() {
        String consulta = "select * from animais where id_user IS NULL;";
        return jdbc.query(
                consulta,
                (res, linha) -> new Animal(res.getInt("id_pet"), res.getString("nome"), res.getDate("data_nasc"),
                        res.getString("sexo").charAt(0), res.getString("raca"), res.getString("porte"),
                        res.getDate("data_entrada"), res.getString("descricao"), res.getDate("data_adocao"),
                        res.getBoolean("validacao_adocao"), new Usuario(), res.getString("imagem")));
    }

    public int atualizaAdocao(Integer animalID, Integer usuarioID) {
        String consulta = "update animais set id_user = ? where id_pet = ?";
        return jdbc.update(consulta, usuarioID, animalID);
    }

    public List<Animal> buscaAnimaisConfirmaAdocao() {
        String consulta = "select *, a.nome as nome_pet, u.nome as nome_adotante from animais a,usuarios u where a.id_user is not null and a.id_user = u.id_user and validacao_adocao is null;";
        return jdbc.query(
                consulta,
                (res, linha) -> new Animal(res.getInt("id_pet"), res.getString("nome_pet"), res.getDate("data_nasc"),
                        res.getString("sexo").charAt(0), res.getString("raca"), res.getString("porte"),
                        res.getDate("data_entrada"), res.getString("descricao"), res.getDate("data_adocao"),
                        res.getBoolean("validacao_adocao"), 
                        new Usuario(res.getInt("id_user"), res.getString("nome_adotante"), res.getString("cpf"), res.getString("email")), 
                        res.getString("imagem")));
    }

    public int confirmaAdocao(Integer animalID) {
        String consulta = "update animais set validacao_adocao = 1 where id_pet = ?";
        return jdbc.update(consulta, animalID);
    }

    public int cancelaAdocao(Integer animalID) {
        String consulta = "update animais set validacao_adocao = 0 where id_pet = ?";
        return jdbc.update(consulta, animalID);
    }


}
