package br.edu.ufcg.computacao.p2lp2.hotelcalifornia.exception;

public class HotelCaliforniaException extends Exception{
    public String UsuarioAutenticacaoNaoExisteAoCadastrar(){
        return "USUARIO NAO EXISTE";
    }
}
