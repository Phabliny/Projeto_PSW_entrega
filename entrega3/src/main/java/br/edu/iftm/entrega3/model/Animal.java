package br.edu.iftm.entrega3.model;

public class Animal {
    private Integer id;
    private String nome;
    private String raca;
    private String dataNasc;
    private String idade;
    private String porte;
    private String descricao;

    public Animal() {
    }

    public Animal(Integer id, String nome, String raca, String dataNasc, String idade, String porte, String descricao) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.dataNasc = dataNasc;
        this.idade = idade;
        this.porte = porte;
        this.descricao = descricao;
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

    public String getRaca() {
        return this.raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getDataNasc() {
        return this.dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getIdade() {
        return this.idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getPorte() {
        return this.porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
