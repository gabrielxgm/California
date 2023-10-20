package US01;

public class Funcionario extends Usuario {
    public Funcionario(String idAutenticacao,String nomeFun, String tipoFun,long documento){
        super(idAutenticacao, nomeFun, tipoFun, documento);
        if(!idAutenticacao.substring(0,idAutenticacao.length()-1).equals("ADM")
                && !idAutenticacao.substring(0,idAutenticacao.length()-1).equals("GER")){
            return;
        }
        this.nomeUsuario = nomeFun;
        this.tipoUsuario = tipoFun;
        this.documento = documento;
    }
    public Funcionario(){}
}