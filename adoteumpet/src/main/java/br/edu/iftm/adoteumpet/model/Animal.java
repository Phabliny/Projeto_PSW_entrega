package br.edu.iftm.adoteumpet.model;

public class Animal {
    private Integer id;
    private String nome;
    private String data_nasc;
    private char sexo;
    private String raca;
    private char porte;
    private String data_entrada;
    private String descricao;
    private String data_adocao;
    private boolean validacao_adocao;
    private Usuario usuario;

    public Animal() {
    }

    public Animal(Integer id, String nome, String data_nasc, char sexo, String raca, char porte, String data_entrada, String descricao, String data_adocao, boolean validacao_adocao, Usuario usuario) {
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

    public String getData_nasc() {
        return this.data_nasc;
    }

    public void setData_nasc(String data_nasc) {
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

    public char getPorte() {
        return this.porte;
    }

    public void setPorte(char porte) {
        this.porte = porte;
    }

    public String getData_entrada() {
        return this.data_entrada;
    }

    public void setData_entrada(String data_entrada) {
        this.data_entrada = data_entrada;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData_adocao() {
        return this.data_adocao;
    }

    public void setData_adocao(String data_adocao) {
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

}
