package US01;

public class Cliente extends Usuario {
    public Cliente(String idUsuario,String nomeCliente, String tipoCliente,long documento){
        super(idUsuario, nomeCliente, tipoCliente, documento);
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeCliente;
        this.tipoUsuario = tipoCliente;
        this.documento = documento;
    }
    public Cliente(){}

}
