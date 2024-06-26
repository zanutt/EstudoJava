package classes;

import interfaces.PermitirAcesso;

public class Diretor extends Pessoa implements PermitirAcesso {

    private String registroEducacao;
    private String tempoDirecao;
    private String titulacao;

    private String login;
    private String senha;

    public Diretor (String login, String senha){
        this.login = login;
        this.senha = senha;
    }

    public Diretor(){
    }

    public String getRegistroEducacao() {
        return registroEducacao;
    }

    public void setRegistroEducacao(String registroEducacao) {
        this.registroEducacao = registroEducacao;
    }

    public String getTempoDirecao() {
        return tempoDirecao;
    }

    public void setTempoDirecao(String tempoDirecao) {
        this.tempoDirecao = tempoDirecao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    /*Metodo de contrato de auth*/

    @Override
    public boolean autenticar(String login, String senha) {
        this.login = login;
        this.senha = senha;
        return autenticar();
    }

    @Override
    public boolean autenticar() {
        return login.equals("znt") && senha.equals("123");
    }



}
