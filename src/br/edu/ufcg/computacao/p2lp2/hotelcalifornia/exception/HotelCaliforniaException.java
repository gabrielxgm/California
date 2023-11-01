package br.edu.ufcg.computacao.p2lp2.hotelcalifornia.exception;

import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteUsuario.UsuarioController;

public class HotelCaliforniaException{
    public static class UsuarioAutenticacaoNaoExisteAoCadastrar extends Exception{
        public String mensagem;
        public UsuarioAutenticacaoNaoExisteAoCadastrar(){
            this.mensagem = "USUARIO NAO EXISTE";
        }
    }
}
