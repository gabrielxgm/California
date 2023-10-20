package US01;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UsuarioController {
    Map<String,Usuario> mapaUsuario;
    int contadorIdSeq;
    UsuarioController(){
        this.mapaUsuario = new HashMap<>();
        this.contadorIdSeq = 1;
    }
    public void cadastrarUsuario(String idAutenticacao,String nomeUsuario,String tipoUsuario,long documento){

    }
    public void atualizarUsuario(String idAutenticacao,String idUsuario,String novoTipoUsuario) {
        if (!idAutenticacao.substring(0, idAutenticacao.length() - 1).equals("ADM")) {
            return;
        }
    }
    public Usuario verificaTipoUsuario(String tipoUsuario){
        return switch (tipoUsuario) {
            case "ADM" -> new Administrador();
            case "CLI" -> new Cliente();
            case "GER" -> new Gerente();
            case "FUN" -> new Funcionario();
            default -> throw new IllegalArgumentException();
        };
    }
    public exibirUsuario()

}
