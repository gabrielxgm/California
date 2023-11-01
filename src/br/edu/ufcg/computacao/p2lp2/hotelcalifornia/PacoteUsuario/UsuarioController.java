package br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteUsuario;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.exception.HotelCaliforniaException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UsuarioController{
/**
 * Mapa de usuários
 */
private Map<String,Usuario> mapaUsuario;
/**
 * Contador sequencial de identificação do usuário
 */
private static int contadorIdSeq;

/**
 * Cria um controlador de usuários
 */
public UsuarioController(){
        mapaUsuario = new HashMap<>();
        mapaUsuario.put("ADM1",new Usuario(1,"Joao Costa","ADM",123456));
        mapaUsuario.get("ADM1").setFuncaoUsuario("ADM");
        contadorIdSeq = 2;
        }

/**
 * Cadastra um usuário
 * @param idAutenticacao Identificador de autenticação do usuário que fará o cadastro
 * @param nomeUsuario nome do usuário
 * @param tipoUsuario tipo do usuário
 * @param documento documento do usuário
 * @return representação textual de confirmação de usuário
 */
public String cadastrarUsuario(String idAutenticacao,String nomeUsuario,String tipoUsuario,long documento) throws HotelCaliforniaException.UsuarioAutenticacaoNaoExisteAoCadastrar {
        if(!mapaUsuario.containsKey(idAutenticacao)){
        throw new HotelCaliforniaException.UsuarioAutenticacaoNaoExisteAoCadastrar();
        }

        if(!mapaUsuario.get(idAutenticacao).getFuncaoUsuario().cadastraUsuario(tipoUsuario))
        throw new IllegalArgumentException("Usuário não pode cadastrar essa função");

        // verifica se existe um gerente no mapa de usuários, e se sim lança uma exceção
        if(verificaSeExisteGerente() && tipoUsuario.equals("GER")){
        for(Usuario usuario: mapaUsuario.values()) {
        if (usuario.getTipoUsuario().equals("GER"))
        throw new IllegalArgumentException("Já existe um gerente cadastrado");
        }
        }

        mapaUsuario.put(tipoUsuario+contadorIdSeq,new Usuario(contadorIdSeq,nomeUsuario,tipoUsuario,documento));
        mapaUsuario.get(tipoUsuario+contadorIdSeq).setFuncaoUsuario(tipoUsuario);
        contadorIdSeq++;
        return tipoUsuario;
        }

/**
 * Atualiza os dados do usuário
 * @param idAutenticacao Identificador de autenticação de usuário que fará o cadastro
 * @param idUsuario identificador de usuário
 * @param novoTipoUsuario novo tipo do usuário
 * @return representação textual de confirmação de atualização
 */
public String atualizarUsuario(String idAutenticacao,String idUsuario,String novoTipoUsuario) {

        if(!Objects.equals(mapaUsuario.get(idAutenticacao).getTipoUsuario(), "ADM"))
        throw new IllegalArgumentException("Somente um administrador pode atualizar um usuário");

        if(Objects.equals(getMapaUsuario().get(idUsuario).getTipoUsuario(),"CLI"))
        throw new IllegalArgumentException("Cliente não pode ser atualizado");

        Usuario usuarioAntigo = mapaUsuario.get(idUsuario);

        Usuario usuarioAtualizado = new Usuario(usuarioAntigo.getIdUsuario(),usuarioAntigo.getNomeUsuario()
        ,novoTipoUsuario,usuarioAntigo.getDocumento());

        // verifica se existe gerente no mapa de usuários, e se sim o altera para um funcionário
        if(novoTipoUsuario.equals("GER") && verificaSeExisteGerente()){
        for(Usuario usuario: mapaUsuario.values()){
        if(usuario.getTipoUsuario().equals("GER")){
        mapaUsuario.put("FUN"+usuario.getIdUsuario(),new Usuario(usuario.getIdUsuario()
        ,usuario.getNomeUsuario(), "FUN",usuario.getDocumento()));
        mapaUsuario.get(usuario.getTipoUsuario()+usuario.getIdUsuario()).setFuncaoUsuario(usuario.getTipoUsuario());
        mapaUsuario.remove(usuario.getTipoUsuario()+usuario.getIdUsuario());
        break;
        }
        }
        }

        mapaUsuario.put(novoTipoUsuario+usuarioAntigo.getIdUsuario(),usuarioAtualizado);
        mapaUsuario.get(novoTipoUsuario+usuarioAntigo.getIdUsuario()).setFuncaoUsuario(novoTipoUsuario);
        mapaUsuario.remove(idUsuario);
        return "Atualizado com sucesso";
        }


/**
 * Verifica se existe gerente no mapa de usuários
 * @return um valor booleano
 */
public boolean verificaSeExisteGerente(){
        for(Usuario usuario: mapaUsuario.values()){
                if(usuario.getTipoUsuario().equals("GER")){
        return true;
                }
        }
        return false;
}

/**
 * Exibe os dados de usuário
 * @param idUsuario identificador de usuário
 * @return representação textual de usuário
 */
public String exibirUsuario(String idUsuario){
        return mapaUsuario.get(idUsuario).toString();
        }

/**
 * Lista todos os usuários
 * @return lista das representações textuais de todos os usuários
 */
public ArrayList<String> listarUsuarios(){
        ArrayList<String> listaUsuario = new ArrayList<>();
        for(Usuario usuario:mapaUsuario.values()){
        listaUsuario.add(usuario.toString());
        }
        return listaUsuario;
        }

/**
 * Acessa os dados de mapa de usuários
 * @return mapa de usuário
 */
public Map<String, Usuario> getMapaUsuario() {
        return mapaUsuario;
        }
/**
 * Gera uma instância de usuario controller
 * @return controlador de usuários
 */
public static UsuarioController getInstance() {
        return new UsuarioController();
        }
}
