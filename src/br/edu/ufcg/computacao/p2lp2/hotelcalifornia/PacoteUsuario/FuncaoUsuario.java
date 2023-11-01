package br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteUsuario;

/**
 * Interface das funções de um usuário
 */
public interface FuncaoUsuario {
    /**
     * Verifica se o usuário pode cadastrar um usuário
     * @param tipoUsuarioNovo tipo do usuário a ser cadastrado
     */
    boolean cadastraUsuario(String tipoUsuarioNovo);
    /**
     * Verifica se o usuário pode cadastrar uma refeição
     * @return valor booleano
     */
    boolean podeCadastrarRefeicao();
    /**
     * Verifica se o usuário pode disponibilizar o pagamento
     * @return valor booleano
     */
    boolean podeDisponibilizarPagamento();
    /**
     * Verifica se o usuário pode pagar a reserva
     * @return valor booleano
     */
    boolean podePagarReserva();

}
