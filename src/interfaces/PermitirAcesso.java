package interfaces;

/*Essa interface é o contrato de auth*/
public interface PermitirAcesso {

    public boolean autenticar(String login, String senha);
    public boolean autenticar();

}
