package US01;

public class Gerente extends Usuario {
    public Gerente(String idAutenticacao,String nomeGer, String tipoGer,long documento){
        super(idAutenticacao, nomeGer, tipoGer, documento);
        if(!idAutenticacao.substring(0,idAutenticacao.length()-1).equals("ADM")){
            return;
        }
        this.nomeUsuario = nomeGer;
        this.tipoUsuario = tipoGer;
        this.documento = documento;
    }
    public Gerente(){}
}
