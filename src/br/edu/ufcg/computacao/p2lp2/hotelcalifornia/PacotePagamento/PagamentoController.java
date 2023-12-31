package br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacotePagamento;

import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.HotelCaliforniaSistema;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteUsuario.UsuarioController;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.exception.HotelCaliforniaException;

import java.util.HashMap;
import java.util.Map;

/**
 * Controlador de pagamentos
 */
public class PagamentoController {
    private UsuarioController usuarioController;
    /**
     * Mapa de pagamentos acessados a partir de um identificador sequencial inteiro
     */
    private Map<Integer,Pagamento> mapaPagamentos;
    /**
     * Contador sequencial inteiro de pagamentos
     */
    private int contadorIdPag;

    /**
     * Cria um controller de pagamentos
     */
    public PagamentoController(){
        this.usuarioController = HotelCaliforniaSistema.getUsuarioController();
        this.mapaPagamentos = new HashMap<>();
        this.contadorIdPag = 1;
    }

    /**
     * Disponibiliza uma forma de pagamento
     * @param idAutenticacao Identificador de autenticação de usuário
     * @param formaPagamento forma de pagamento
     * @param percentualDesconto percentual de desconto de pagamento
     * @return uma representação textual de confirmação do cadastro
     */
    public String disponibilizarFormaDePagamento(String idAutenticacao,String formaPagamento,double percentualDesconto){
        if(!usuarioController.getMapaUsuario().containsKey(idAutenticacao))
            throw new HotelCaliforniaException("USUARIO NAO EXISTE");

        if(!usuarioController.getMapaUsuario().get(idAutenticacao).getFuncaoUsuario().podeDisponibilizarPagamento())
            throw new HotelCaliforniaException("NAO E POSSIVEL PARA USUARIO CADASTRAR UMA FORMA DE PAGAMENTO");

        for(Pagamento pagamento: mapaPagamentos.values()){
            if(pagamento.getFormaPagamento().equals(formaPagamento))
                throw new HotelCaliforniaException("FORMA DE PAGAMENTO JA EXISTE");
        }
        mapaPagamentos.put(contadorIdPag,new Pagamento(contadorIdPag,formaPagamento,percentualDesconto));
        mapaPagamentos.get(contadorIdPag).setFuncaoPagamento(formaPagamento);
        // atualiza o contador para o próximo cadastro
        contadorIdPag++;
        return mapaPagamentos.get(contadorIdPag-1).toString();
    }

    /**
     * Atualiza uma forma de pagamento
     * @param idAutenticacao Identificador de autenticação de usuário
     * @param idFormaPagamento Identificador da forma de pagamento
     * @param formaPagamento forma de pagamento
     * @param percentualDesconto percentual de desconto
     * @return representação textual de confirmação de atualização
     */
    public String atualizarPagamento(String idAutenticacao,int idFormaPagamento,String formaPagamento,double percentualDesconto){
        if(!usuarioController.getMapaUsuario().get(idAutenticacao).getFuncaoUsuario().podeDisponibilizarPagamento())
            throw new IllegalArgumentException("Usuário não tem permissão para atualizar o pagamento");

        for(Pagamento pagamento: mapaPagamentos.values()){
            if(pagamento.getFormaPagamento().equals(formaPagamento) && pagamento.getIdPagamento()!=idFormaPagamento)
                throw new IllegalArgumentException("Forma de pagamento já existe");
        }

        mapaPagamentos.get(idFormaPagamento).setPercentualDesconto(percentualDesconto);
        return mapaPagamentos.get(idFormaPagamento).toString();
    }

    /**
     * Exibe os dados de um pagamento
     * @param idFormaPagamento Identificador de forma de pagamento
     * @return representação textual de forma de pagamento
     */
    public String exibirFormaPagamento(int idFormaPagamento){
        return mapaPagamentos.get(idFormaPagamento).toString();
    }

    /**
     * Lista todos os pagamentos
     * @return uma lista de pagamentos
     */
    public String[] listarFormasPagamentos(){
        String[] listaPagamentos = new String[mapaPagamentos.size()];
        int i = 0;
        for(Pagamento pagamento: mapaPagamentos.values()){
            listaPagamentos[i] = pagamento.toString();
            i++;
        }
        return listaPagamentos;
    }

    /**
     * Acessa os dados de mapa de pagamentos
     * @return mapa de pagamentos
     */
    public Map<Integer, Pagamento> getMapaPagamentos() {
        return mapaPagamentos;
    }
}
