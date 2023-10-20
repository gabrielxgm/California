package US01;

public class Administrador extends US01.Usuario {
    public Administrador(String idAutenticacao,String nomeAdmin, String tipoAdmin,long documento){
        super(idAutenticacao,nomeAdmin,tipoAdmin,documento);
        if(!idAutenticacao.substring(0,idAutenticacao.length()-1).equals("ADM")){
            return;
        }
        this.nomeUsuario = nomeAdmin;
        this.tipoUsuario = tipoAdmin;
        this.documento = documento;
    }
    public Administrador(){}

    @Override
    public boolean cadastraUsuario(String novoTipoUsuario) {
        return true;
    }
}
