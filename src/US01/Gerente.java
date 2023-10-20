package US01;

public class Gerente extends Usuario {
    public Gerente(String idUsuario,String nomeGer, String tipoGer,long documento){
        super(idUsuario, nomeGer, tipoGer, documento);
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeGer;
        this.tipoUsuario = tipoGer;
        this.documento = documento;
    }
    public Gerente(){}

    @Override
    public boolean cadastraUsuario(String tipoUsuarioNovo) {
        return !tipoUsuarioNovo.equals("ADM");
    }
}
