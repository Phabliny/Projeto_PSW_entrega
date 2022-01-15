package br.edu.iftm.adoteumpet.model;

import java.sql.Date;

public class Animal {
    private Integer id;
    private String nome;
    private Date data_nasc;
    private char sexo;
    private String raca;
    private String porte;
    private Date data_entrada;
    private String descricao;
    private Date data_adocao;
    private boolean validacao_adocao;
    private Usuario usuario;
    private String imagem;

    public Animal() {
    }

    public Animal(Integer id, String nome, Date data_nasc, char sexo, String raca, String porte, Date data_entrada, String descricao, Date data_adocao, boolean validacao_adocao, Usuario usuario, String imagem) {
        this.id = id;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.sexo = sexo;
        this.raca = raca;
        this.porte = porte;
        this.data_entrada = data_entrada;
        this.descricao = descricao;
        this.data_adocao = data_adocao;
        this.validacao_adocao = validacao_adocao;
        this.usuario = usuario;
        this.imagem = imagem;
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

    public Date getData_nasc() {
        return this.data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public char getSexo() {
        return this.sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getRaca() {
        return this.raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getPorte() {
        return this.porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public Date getData_entrada() {
        return this.data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData_adocao() {
        return this.data_adocao;
    }

    public void setData_adocao(Date data_adocao) {
        this.data_adocao = data_adocao;
    }

    public boolean isValidacao_adocao() {
        return this.validacao_adocao;
    }

    public boolean getValidacao_adocao() {
        return this.validacao_adocao;
    }

    public void setValidacao_adocao(boolean validacao_adocao) {
        this.validacao_adocao = validacao_adocao;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getImagem() {
        return this.imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", data_nasc='" + getData_nasc() + "'" +
            ", sexo='" + getSexo() + "'" +
            ", raca='" + getRaca() + "'" +
            ", porte='" + getPorte() + "'" +
            ", data_entrada='" + getData_entrada() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", data_adocao='" + getData_adocao() + "'" +
            ", validacao_adocao='" + isValidacao_adocao() + "'" +
            ", usuario='" + getUsuario() + "'" +
            ", imagem='" + getImagem() + "'" +
            "}";
    }

}
