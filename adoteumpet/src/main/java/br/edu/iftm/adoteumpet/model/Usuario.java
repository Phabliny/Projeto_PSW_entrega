package br.edu.iftm.adoteumpet.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated
public class Usuario {

    private Integer id;
    private String nome;
    @NotEmpty
    @Size(min = 11, max = 11, message = "CPF inválido!")
    private String cpf;
    private String email; // username login
    private String endereco;
    private String telefone;
    private String data_nasc;
    private Character sexo;
    private String senha; // password login
    private String papel;

    public Usuario() {
    }

    public Usuario(Integer id, String nome, String cpf, String email, String endereco, String telefone,
            String data_nasc, Character sexo, String senha, String papel) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.data_nasc = data_nasc;
        this.sexo = sexo;
        this.senha = senha;
        this.papel = papel;
    }

    public Usuario(Integer id, String nome, String cpf, String email, String endereco, String telefone, String dataNasc, char sexo, String senha) {

        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.data_nasc = dataNasc;
        this.sexo = sexo;
        this.senha = senha;
    }

    public Usuario(Integer id, String nome, String cpf, String email) {

        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getPapel() {
        return this.papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getData_nasc() {
        return this.data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public Character getSexo() {
        return this.sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
