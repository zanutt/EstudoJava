package ConhecendoLinguagem.src.classes;

import ConhecendoLinguagem.src.constantes.StatusAluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aluno {
    String nome;
    int idade;
    String dataNascimento;
    String registroGeral;
    String numeroCpf;
    String nomeMae;
    String nomePai;
    String dataMatricula;

    private List <Disciplina> disciplinas = new ArrayList<Disciplina>();

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    /*Método set recebe dados*/
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRegistroGeral() {
        return registroGeral;
    }

    public void setRegistroGeral(String registroGeral) {
        this.registroGeral = registroGeral;
    }

    public String getNumeroCpf() {
        return numeroCpf;
    }

    public void setNumeroCpf(String numeroCpf) {
        this.numeroCpf = numeroCpf;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(String dataMatricula) {
        this.dataMatricula = dataMatricula;
    }



    /*Método que rotorna media do aluno*/
    public double getMediaNota(){

        double somaNotas = 0.0;

        for (Disciplina disciplina : disciplinas){
            somaNotas += disciplina.getNota();
        }
        return somaNotas / disciplinas.size();
    }
    public boolean getAlunoAprovado(){
        double media = this.getMediaNota();
        if (media >= 70){
            return true;
        }else {
            return false;
        }
    }

    public String getAlunoAprovado2(){
        double media = this.getMediaNota();
        if (media >= 50){
            if (media >= 70){
                return StatusAluno.APROVADO;
            }else {
                return StatusAluno.RECUPERACAO;
            }
        }else {
            return StatusAluno.REPROVADO;
        }
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", registroGeral='" + registroGeral + '\'' +
                ", numeroCpf='" + numeroCpf + '\'' +
                ", nomeMae='" + nomeMae + '\'' +
                ", nomePai='" + nomePai + '\'' +
                ", dataMatricula='" + dataMatricula + '\'' +
                ", disciplinas=" + disciplinas +
                '}';
    }

    /*Cpf Equals :D*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(numeroCpf, aluno.numeroCpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numeroCpf);
    }
}
