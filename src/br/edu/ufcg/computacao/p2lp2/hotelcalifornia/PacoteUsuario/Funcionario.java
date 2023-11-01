package br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteUsuario;
/**
 * Classe das funções de um funcionario
 */
public class Funcionario implements FuncaoUsuario {
    /**
     * Verifica se o usuário pode cadastrar uma refeição
     * @return valor booleano
     */
    public boolean podeCadastrarRefeicao() {
        return true;
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
        return false;
    }
    /**
     * Verifica se o usuário pode cadastrar um usuário
     * @param tipoUsuarioNovo tipo do usuário a ser cadastrado
     * @return valor booleano
     */
    public boolean cadastraUsuario (String tipoUsuarioNovo){
        return tipoUsuarioNovo.equals("CLI");
    }
}
