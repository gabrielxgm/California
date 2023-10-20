package US01;

import java.util.ArrayList;
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
        if(!mapaUsuario.get(idAutenticacao).cadastraUsuario(tipoUsuario)){
            throw new IllegalArgumentException();
        }
        Usuario usuarioNovo = verificaTipoUsuario(tipoUsuario);
        usuarioNovo.cadastraDadosDoProprioUsuario(tipoUsuario+contadorIdSeq, nomeUsuario, tipoUsuario, documento);
        mapaUsuario.put(tipoUsuario+contadorIdSeq,usuarioNovo);
        contadorIdSeq++;
    }
    public void atualizarUsuario(String idAutenticacao,String idUsuario,String novoTipoUsuario) {
        if(!Objects.equals(mapaUsuario.get(idAutenticacao).getTipoUsuario(), "ADM")){
            throw new IllegalArgumentException();
        }
        Usuario usuarioAtualizado = verificaTipoUsuario(novoTipoUsuario);
        Usuario usuarioAntigo = mapaUsuario.get(idUsuario);
        usuarioAtualizado.cadastraDadosDoProprioUsuario(usuarioAntigo.getTipoUsuario()+contadorIdSeq,usuarioAntigo.getNomeUsuario(),
                usuarioAntigo.getTipoUsuario(),usuarioAntigo.getDocumento());
        mapaUsuario.put(novoTipoUsuario+usuarioAntigo.getIdUsuario().charAt(usuarioAntigo.getIdUsuario().length()-1),usuarioAtualizado);
        mapaUsuario.remove(idUsuario);
        if(novoTipoUsuario.equals("GER")){
            for(Usuario usuario: mapaUsuario.values()){
                if(usuario.getTipoUsuario().equals("GER")){
                    mapaUsuario.put(usuario.getIdUsuario(),new Funcionario(usuario.getIdUsuario(),usuario.getNomeUsuario(),
                            usuario.getTipoUsuario(),usuario.getDocumento()));
                    mapaUsuario.remove(usuario);
                    break;
                }
            }
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
    public String exibirUsuario(String idUsuario){
        return mapaUsuario.get(idUsuario).toString();
    }
    public ArrayList<String> listarUsuarios(){
        ArrayList<String> listaUsuario = null;
        for(Usuario usuario:mapaUsuario.values()){
            assert false;
            listaUsuario.add(usuario.toString());
        }
        return listaUsuario;
    }

}
