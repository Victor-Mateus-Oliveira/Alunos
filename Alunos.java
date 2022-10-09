package br.com.cursomentorama.Cadastro.de.alunos;

public class Alunos {
    private Integer id;
    private String NomedoAluno;
    private Integer idade;

    public Alunos(Integer id, String nomedoAluno, Integer idade) {
        this.id = id;
        NomedoAluno = nomedoAluno;
        this.idade = idade;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomedoAluno() {
        return NomedoAluno;
    }

    public void setNomedoAluno(String nomedoAluno) {
        NomedoAluno = nomedoAluno;
    }

    public Integer size() {
        return 0;
    }
}

