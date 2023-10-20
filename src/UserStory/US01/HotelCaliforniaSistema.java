package UserStory.US01;

import UserStory.US01.US04.RefeicaoController;
import UserStory.US01.UsuarioController;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Locale;

public class HotelCaliforniaSistema {
    UsuarioController usuarioController;
    RefeicaoController refeicaoController;
    HotelCaliforniaSistema(){
        this.usuarioController = new UsuarioController();
        this.refeicaoController = new RefeicaoController();
    }

    public String cadastrarUsuario(String idAutenticacao,String nomeUsuario,String tipoUsuario,long documento){
        this.usuarioController.cadastrarUsuario(idAutenticacao, nomeUsuario, tipoUsuario, documento);
        return "Cadastrado com sucesso";
    }
    public String atualizarUsuario(String idAutenticacao, String idUsuario, String novoTipoUsuario) {
        this.usuarioController.atualizarUsuario(idAutenticacao, idUsuario, novoTipoUsuario);
        return this.usuarioController.atualizarUsuario(idAutenticacao, idUsuario, novoTipoUsuario);
    }
    public String exibirUsuario(String idUsuario){
        return this.usuarioController.exibirUsuario(idUsuario);
    }
    public ArrayList<String> listarUsuarios(){
        return this.usuarioController.listarUsuarios();
    }
    public String disponibilizarRefeicao(String idAutenticacao, String titulo, LocalTime horarioInicio
            ,LocalTime horarioFinal,double valorRefeicao,boolean disponivel){
    }
}
