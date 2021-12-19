package br.edu.iftm.adoteumpet;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class AdoteumpetApplication /*implements CommandLineRunner*/{

	public static void main(String[] args) {
		SpringApplication.run(AdoteumpetApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;


	// @Override
	// public void run(String... args) throws Exception {
			
		
	// 	jdbcTemplate.update("INSERT INTO usuario(nome, cpf, email, endereco, telefone, data_nasc, sexo, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", "Edson Angoti Júnior", "11122233344", "edson@gmail.com", "rua fulano", "998724532", "04-10-1980", "Masculino", "123456");

	// 	jdbcTemplate.update("INSERT INTO usuario(nome, cpf, email, endereco, telefone, data_nasc, sexo, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", "Clarimundo Machado", "55566677788", "clarimundo@gmail.com", "rua maria jose", "995764562","04-10-1980", "Masculino", "147934");

	// 	jdbcTemplate.update("INSERT INTO animal (nome, data_nasc, sexo, raca, porte, data_entrada, descricao, data_adocao, validacao_adocao, id_user) Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "Mel", "10-01-2010", "f", "p", "pinscher", "07-12-2021", "castrada", null, null, 1);

	// 	jdbcTemplate.update("INSERT INTO animal (nome, data_nasc, sexo, raca, porte, data_entrada, descricao, data_adocao, validacao_adocao, id_user) Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "Leo", "10-01-2011", "m", "p", "pinscher", "07-12-2021", "castrada", null, null, 1);
		
	// }
}
