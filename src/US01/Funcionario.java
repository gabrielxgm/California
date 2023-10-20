package US01;

public class Funcionario extends Usuario {
    public Funcionario(String idUsuario,String nomeFun, String tipoFun,long documento){
        super(idUsuario, nomeFun, tipoFun, documento);
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeFun;
        this.tipoUsuario = tipoFun;
        this.documento = documento;
    }
    public Funcionario(){}

    @Override
    public boolean cadastraUsuario(String tipoUsuarioNovo) {
        return tipoUsuarioNovo.equals("GER");
    }
}