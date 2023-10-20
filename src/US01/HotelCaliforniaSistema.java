package US01;

public class HotelCaliforniaSistema {
    UsuarioController usuarioController;
    HotelCaliforniaSistema(){
        this.usuarioController = new UsuarioController();
    }

    private String cadastrarUsuario(String idAutenticacao,String nomeUsuario,String tipoUsuario,long documento){
        this.usuarioController.cadastrarUsuario(idAutenticacao, nomeUsuario, tipoUsuario, documento);
        return null;
    }
    private String atualizarUsuario(String idAutenticacao, String idUsuario, String novoTipoUsuario){
        this.usuarioController.atualizarUsuario(idAutenticacao,idUsuario,novoTipoUsuario);
        return null;
    }

}
