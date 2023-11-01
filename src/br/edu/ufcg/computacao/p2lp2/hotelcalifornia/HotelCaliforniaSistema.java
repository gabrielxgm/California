package br.edu.ufcg.computacao.p2lp2.hotelcalifornia;

import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteUsuario.UsuarioController;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.US02.QuartoController;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.US03.ReservaDeQuartoControler;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteRefeicao.RefeicaoController;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacotePagamento.PagamentoController;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Classe do sistema de hotel California
 */
public class HotelCaliforniaSistema {
	/**
	 * Controlador de usuários
	 */
	static UsuarioController usuarioController;
	/**
	 * Controlador de refeição
	 */
	static RefeicaoController refeicaoController;
	/**
	 * Controlador de pagamentos
	 */
	static PagamentoController pagamentoController;
	/**
	 * Controlador de quartos
	 */
	static QuartoController quartoController;
	/**
	 * Controlador de reserva de quartos
	 */
	static ReservaDeQuartoControler reservaDeQuartoControler;

	/**
	 * Cria um sistema do hotel California
	 */
	HotelCaliforniaSistema(){
		usuarioController = new UsuarioController();
		refeicaoController = new RefeicaoController();
		pagamentoController = new PagamentoController();
		quartoController = new QuartoController();
		reservaDeQuartoControler = new ReservaDeQuartoControler();
	}

	/**
	 * Cadastra um usuário
	 * @param idAutenticacao id autenticador do usuário
	 * @param nomeUsuario nome do usuário novo
	 * @param tipoUsuario tipo do usuário novo
	 * @param documento documento do usuário nov
	 * @return representação textual de confirmação do cadastro
	 */
	public String cadastrarUsuario(String idAutenticacao,String nomeUsuario,String tipoUsuario,long documento){
		return usuarioController.cadastrarUsuario(idAutenticacao, nomeUsuario, tipoUsuario, documento);
	}

	/**
	 * Atualiza um usuário
	 * @param idAutenticacao id autenticador do usuário
	 * @param idUsuario id do usuário a ser atualizado
	 * @param novoTipoUsuario novo tipo do usuário
	 * @return representação textual de confirmação da atualização
	 */
	public String atualizarUsuario(String idAutenticacao, String idUsuario, String novoTipoUsuario) {
		return usuarioController.atualizarUsuario(idAutenticacao, idUsuario, novoTipoUsuario);
	}

	/**
	 * Exibe os dados de um usuário
	 * @param idUsuario id do usuário
	 * @return representação textual de um usuário
	 */
	public String exibirUsuario(String idUsuario){
		return usuarioController.exibirUsuario(idUsuario);
	}

	/**
	 * Lista os dados de todos usuários
	 * @return lista de todos os usuários cadastrados
	 */
	public ArrayList<String> listarUsuarios(){
		return usuarioController.listarUsuarios();
	}

	/**
	 * Cria um refeição
	 * @param idAutenticacao id autenticador de usuário
	 * @param tipoRefeicao tipo da refeição
	 * @param titulo título da refeição
	 * @param horarioInicio horário de início da refeição
	 * @param horarioFinal horário de término da refeição
	 * @param valorRefeicao valor da refeição
	 * @param disponivel disponibilidade da refeição
	 * @return representação textual de confirmação do cadastro da refeição
	 */
	public String disponibilizarRefeicao(String idAutenticacao,String tipoRefeicao, String titulo, LocalTime horarioInicio
			,LocalTime horarioFinal,double valorRefeicao,boolean disponivel){
		return refeicaoController.disponibilizarRefeicao(idAutenticacao, tipoRefeicao, titulo, horarioInicio, horarioFinal, valorRefeicao, disponivel);
	}

	/**
	 * Altera os dados de uma refeição
	 * @param idRefeicao id da refeição
	 * @param horarioInicio horário de início da refeição
	 * @param horarioFinal horário de término da refeição
	 * @param valorRefeicao valor da refeição
	 * @param disponivel disponibilidade da refeição
	 * @return representação textual de confirmação de atualização da refeição
	 */
	public String alterarRefeicao(long idRefeicao,LocalTime horarioInicio,LocalTime horarioFinal,double valorRefeicao
			,boolean disponivel){
		return refeicaoController.atualizarRefeicao(idRefeicao,horarioInicio,horarioFinal,valorRefeicao,disponivel);
	}

	/**
	 * Exibe os dados de uma refeição
	 * @param idRefeicao id da refeição
	 * @return representação textual de uma refeição
	 */
	public String exibirRefeicao(long idRefeicao){
		return refeicaoController.exibirRefeicao(idRefeicao);
	}

	/**
	 * Lista os dados de todas as refeições cadastradas
	 * @return lista de refeições
	 */
	public ArrayList<String> listarRefeicoes(){
		return refeicaoController.listarRefeicoes();
	}

	/**
	 * Cria um pagamento
	 * @param idAutenticacao id autenticador de usuário
	 * @param formaPagamento forma de pagamento
	 * @param percentualDesconto percentual de desconto
	 * @return representação textual de confirmação de cadastro do pagamento
	 */
	public String disponibilizarFormaDePagamento(String idAutenticacao,String formaPagamento,double percentualDesconto){
		return pagamentoController.disponibilizarFormaDePagamento(idAutenticacao,formaPagamento,percentualDesconto);
	}

	/**
	 * Altera um pagamento
	 * @param idAutenticacao id autenticador de usuário
	 * @param idFormaPagamento id do pagamento
	 * @param formaPagamento forma de pagamento
	 * @param percentualDesconto percentual de desconto
	 * @return representação textual de confirmação de atualização do pagamento
	 */
	public String alterarFormaDePagamento(String idAutenticacao,int idFormaPagamento,String formaPagamento,double percentualDesconto){
		return pagamentoController.atualizarPagamento(idAutenticacao, idFormaPagamento, formaPagamento, percentualDesconto);
	}

	/**
	 * Exibe os dados de um pagamento
	 * @param idFormaPagamento id do pagamento
	 * @return representação textual de um pagamento
	 */
	public String exibirFormaPagamento(int idFormaPagamento){
		return pagamentoController.exibirFormaPagamento(idFormaPagamento);
	}

	/**
	 * Lista os dados de todos os pagamentos
	 * @return lista de pagamentos
	 */
	public ArrayList<String> listarFormasPagamentos(){
		return pagamentoController.listarFormasPagamentos();
	}

	/**
	 * Cancela uma reserva
	 * @param idCliente id do cliente
	 * @param idReserva id da reserva
	 * @return representação textual de confirmação do cancelamento da reserva
	 * @throws Exception cancelamento fora do prazo estipulado
	 */
	public String cancelarReserva(String idCliente,String idReserva) throws Exception {
		return reservaDeQuartoControler.cancelarReserva(idCliente,idReserva);
	}

	public static UsuarioController getUsuarioController() {
		return usuarioController;
	}
}
