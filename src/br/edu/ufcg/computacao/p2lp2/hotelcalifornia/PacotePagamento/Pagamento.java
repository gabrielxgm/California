package br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacotePagamento;

/**
 * Classe de um pagamento
 */
public class Pagamento {
    /**
     * id sequencial de pagamento
     */
    private int idPagamento;
    /**
     * forma de pagamento
     */
    private String formaPagamento;
    /**
     * percentual de desconto
     */
    private double percentualDesconto;
    /**
     * função de tipo de pagamento
     */
    private FuncaoPagamento funcaoPagamento;

    /**
     * Cria um pagamento a partir de seu id,forma de pagamento e percentual de desconto
     * @param idPagamento id de pagamento
     * @param formaPagamento forma de pagamento
     * @param percentualDesconto percentual de desconto
     */
    Pagamento(int idPagamento, String formaPagamento,double percentualDesconto){
        this.idPagamento = idPagamento;
        formaPagamento= formaPagamento.replaceAll("_"," ");
        this.formaPagamento = formaPagamento;
        this.percentualDesconto = percentualDesconto;
    }

    /**
     * Altera os dados de percentual de desconto
     * @param percentualDesconto percentual de desconto
     */
    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    /**
     * Acessa os dados de forma de pagamento
     * @return forma de pagamento
     */
    public String getFormaPagamento() {
        return formaPagamento;
    }
    /**
     * Acessa os dados de percentual de desconto
     * @return percentual de desconto
     */
    public double getPercentualDesconto() {
        return percentualDesconto;
    }
    /**
     * Acessa os dados do id do pagamento
     * @return id do pagamento
     */
    public int getIdPagamento() {
        return idPagamento;
    }

    /**
     * Altera a função do pagamento
     * @param funcaoPagamento função do pagamento
     */
    public void setFuncaoPagamento(String funcaoPagamento) {
        switch (funcaoPagamento){
            case "PIX" -> this.funcaoPagamento = new PIX();
            case "DINHEIRO" -> this.funcaoPagamento = new Dinheiro();
            case "CARTAO_DE_CREDITO" -> this.funcaoPagamento = new Cartao();
            default -> throw new IllegalArgumentException("Forma de pagamento inválida");
        }
    }

    /**
     * Cria um representação textual de pagamento
     * @return representação textual de pagamento
     */
    @Override
    public String toString() {
        return "["+idPagamento+"] Forma de pagamento: "+formaPagamento
                +" ("+String.format("%.0f",(percentualDesconto*100))+"% de desconto em pagamentos)";
    }
}
