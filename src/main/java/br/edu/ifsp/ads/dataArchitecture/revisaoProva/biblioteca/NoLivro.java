package br.edu.ifsp.ads.dataArchitecture.revisaoProva.biblioteca;

public class NoLivro {
    public NoLivro anterior;
    public NoLivro proximo;
    public String autores;
    public String titulo;
    public String edicao;
    public String cidade;
    public String editora;
    public int ano;

    public NoLivro(String autores, String titulo, String edicao, String cidade, String editora, int ano) {
        this.anterior = null;
        this.proximo = null;
        this.autores = autores;
        this.titulo = titulo;
        this.edicao = edicao;
        this.cidade = cidade;
        this.editora = editora;
        this.ano = ano;
    }

    public void exibirSimples() {
        System.out.println(this.titulo + " - " + this.autores + " - " + this.ano);
    }

    public void exibirEspecifico() {
        System.out.println("Título: " + this.titulo);
        System.out.println("Autores: " + this.autores);
        System.out.println("Edição: " + this.edicao);
        System.out.println("Cidade: " + this.cidade);
        System.out.println("Editora: " + this.editora);
        System.out.println("Ano: " + this.ano);
    }
}
