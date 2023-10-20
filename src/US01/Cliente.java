package US01;

public class Cliente extends Usuario {
    public Cliente(String idAutenticacao,String nomeCliente, String tipoCliente,long documento){
        super(idAutenticacao, nomeCliente, tipoCliente, documento);
        if(idAutenticacao.substring(0,idAutenticacao.length()-1).equals("CLI")){
            return;
        }
        this.nomeUsuario = nomeCliente;
        this.tipoUsuario = tipoCliente;
        this.documento = documento;
    }
    public Cliente(){}
}
