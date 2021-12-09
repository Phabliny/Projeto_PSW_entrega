package br.edu.iftm.adoteumpet.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.iftm.adoteumpet.model.Usuario;

@Repository
public class UsuarioRepository {
    
    @Autowired
    JdbcTemplate jdbc;

    public List<Usuario> buscaTodosUsuarios(){
        String consulta = "select * from usuario;";
        return jdbc.query(consulta,
                (resultados, numeroDaLinha) -> new Usuario(resultados.getInt("id"), resultados.getString("nome"), resultados.getString("cpf"), resultados.getString("email"), resultados.getString("endereco"), resultados.getString("telefone"), resultados.getString("data_nasc"), (char)resultados.getInt("sexo"), resultados.getString("senha")));
    }

    public int gravaUsuario(Usuario usuario){
        String consulta = "insert into usuario(nome, cpf, email, endereco, telefone, dataNasc, sexo, senha) values(?,?,?,?,?,?,?,?)";
        return jdbc.update(consulta, usuario.getNome(), usuario.getCpf(), usuario.getEmail(), usuario.getEndereco(), usuario.getTelefone(), usuario.getData_nasc(), usuario.getSexo(), usuario.getSenha());
    }

    public int excluirUsuario(Integer id){
        System.out.println(" -------------> id = " + id);
        String consulta = "delete from usuario where id = ?";
        return jdbc.update(consulta, id);
    }

    public Usuario buscaPorId(Integer id) {
        return jdbc.queryForObject(
            "select * from usuario where id = ?",
            (resultSet, rowNum) -> { return new Usuario(resultSet.getInt("id"),resultSet.getString("nome"), resultSet.getString("cpf"), resultSet.getString("email"), resultSet.getString("endereco"),resultSet.getString("telefone"), resultSet.getString("data_nasc"), (char)resultSet.getInt("sexo"), resultSet.getString("senha")); },
            id);
    }

    public int atualizaUsuario(Usuario usuario){
        String consulta = "update usuario set nome = ? where id = ?";
        return jdbc.update(consulta, usuario.getNome(), usuario.getId());
    }

}

