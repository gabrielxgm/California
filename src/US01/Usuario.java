package US01;

public abstract class Usuario{
    protected String nomeUsuario;
    protected String tipoUsuario;
    protected long documento;
    public Usuario(String idAutenticacao, String nomeUsuario, String tipoUsuario,long documento){}
    public Usuario(){}
    public void atualizarUsuario(String novoTipoUsuario){
        this.tipoUsuario = tipoUsuario;
    }
    public String toString() {
        return nomeUsuario+" (No. Doc. "+this.documento+")";
    }
}