package br.edu.ufcg.computacao.p2lp2.hotelcalifornia.exception;

public class HotelCaliforniaException extends RuntimeException {
    private String excecao;

    public HotelCaliforniaException(String mensagem) {
        this.excecao = mensagem;

    }
    @Override
    public String getMessage() {
        return excecao;
    }
}
