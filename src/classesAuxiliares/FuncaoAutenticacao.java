package classesAuxiliares;

import interfaces.PermitirAcesso;

/*Realmente e somente receber quem tem o contrato da interface de permitir acesso*/
public class FuncaoAutenticacao {

    private PermitirAcesso permitirAcesso;

    public boolean autenticar(){
        return permitirAcesso.autenticar();
    }
    public  FuncaoAutenticacao( PermitirAcesso acesso){
        this.permitirAcesso = acesso;
    }
}
