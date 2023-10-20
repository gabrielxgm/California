package US01;

public abstract class Usuario{
    protected String idUsuario;
    protected String nomeUsuario;
    protected String tipoUsuario;
    protected long documento;
    public Usuario(String idUsuario, String nomeUsuario, String tipoUsuario,long documento){}
    public Usuario(){}
    public boolean cadastraUsuario(String tipoUsuarioNovo){
        return false;
    }
    public void cadastraDadosDoProprioUsuario(String idUsuario,String nomeUsuario,String tipoUsuario,long documento){
        setIdUsuario(idUsuario);
        setNomeUsuario(nomeUsuario);
        setTipoUsuario(tipoUsuario);
        setDocumento(documento);
    }
    public void atualizarUsuario(String novoTipoUsuario){
        this.tipoUsuario = tipoUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public long getDocumento() {
        return documento;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    @Override
    public String toString(){
        return "["+idUsuario+"] "+nomeUsuario+" (No. Doc. "+documento+")";
    }
}