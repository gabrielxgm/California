package br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteUsuario;
/**
 * Classe das funções de um cliente
 */
public class Cliente implements FuncaoUsuario {

    /**
     * Verifica se o usuário pode cadastrar um usuário
     * @param tipoUsuarioNovo tipo do usuário a ser cadastrado
     * @return valor booleano
     */
    public boolean cadastraUsuario(String tipoUsuarioNovo) {
        return false;
    }
    /**
     * Verifica se o usuário pode cadastrar uma refeição
     * @return valor booleano
     */
    public boolean podeCadastrarRefeicao() {
        return false;
    }
    /**
     * Verifica se o usuário pode disponibilizar o pagamento
     * @return valor booleano
     */
    public boolean podeDisponibilizarPagamento() {
        return false;
    }
    /**
     * Verifica se o usuário pode pagar a reserva
     * @return valor booleano
     */
    public boolean podePagarReserva() {
        return true;
    }
}
