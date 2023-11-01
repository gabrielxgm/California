package br.edu.ufcg.computacao.p2lp2.hotelcalifornia.US03;

import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteUsuario.Usuario;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.US02.QuartoController;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.US02.QuartoI;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteRefeicao.Refeicao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Reserva {
    private int id;
    private Usuario usuario;
    private QuartoI quarto;
    private int numeroDeHospedes;
    private ArrayList<Refeicao> refiecoes;
    private boolean pagamento;
    private double valorReserva;
    private br.edu.ufcg.computacao.p2lp2.hotelcalifornia.US02.QuartoController QuartoController;
    private QuartoController controllerQuarto = QuartoController;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFinal;
    /**
     * Indica se uma reserva foi cancelada
     */
    private boolean statusCancelado;

    public Reserva(int id, Usuario usuario, int idQuarto, int numeroDeHospedes, ArrayList<Refeicao> refiecoes, boolean pagamento, LocalDateTime dataInicio, LocalDateTime dataFinal) {
        this.id = id;
        this.usuario = usuario;
        this.quarto = controllerQuarto.getQuarto(idQuarto);
        this.numeroDeHospedes = numeroDeHospedes;
        this.refiecoes = refiecoes;
        this.pagamento = pagamento;
        this.valorReserva = calculaValorReserva(quarto, numeroDeHospedes);
        this.dataFinal = dataFinal;
        this.dataInicio = dataInicio;
        this.statusCancelado = false;


    }

    public double calculaValorReserva(QuartoI quarto, int numeroDeHospedes){
        return calculaDias() * (quarto.getValorBasico() + numeroDeHospedes * quarto.getValorPessoa()) + calculaDias() * numeroDeHospedes * somaValorRefeicao();
    }

    public double calculaDias(){
        long diasDeReserva = ChronoUnit.DAYS.between(dataInicio, dataFinal);
        if(diasDeReserva < 1 | !dataInicio.isBefore(dataFinal)){
            throw new IllegalArgumentException("o tempo de estadia é de no minimo uma diaria!");
        }
        else if(dataInicio.getHour() != 14 | dataFinal.getHour() != 12){
            throw new IllegalArgumentException("a hora do check-in ou do check-out esta errada");
        }
        else {
         return Math.ceil(diasDeReserva);
        }
    }

    public double somaValorRefeicao(){
        double soma = 0;
        for (Refeicao refiecao : refiecoes) {
            soma += refiecao.getValorRefeicao();
        }
        return soma;
    }


    public String formatadata(LocalDateTime data){
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public StringBuilder formataComidas(ArrayList<Refeicao> refiecoes){
        StringBuilder refeicoesFormatadas = new StringBuilder();
        for (Refeicao refiecao : refiecoes) {
             refeicoesFormatadas.append("\n" + refiecao.toString());
        }
        return refeicoesFormatadas;
    }

    public double formataValorDaReserva(){
        return quarto.getValorDiaria() + somaValorRefeicao();
    }

    @Override
    public String toString() {
        // toString caso a reserva não esteja cancelada
        if(!statusCancelado) {
            return "[" + this.id + "] Reserva de quarto em favor de: \n" +
                    " - " + this.usuario.toString() +
                    "\nDetalhes da instalacao: \n" +
                    " - " + quarto.toString() +
                    "\nDetalhes da reserva: \n" +
                    "- Periodo: " + formatadata(this.dataInicio) + " ate " + formatadata(dataFinal) + " \n" +
                    "- No. Hospedes: " + this.numeroDeHospedes + " pessoa(s) \n" +
                    "- Refeicoes incluidas: [" + formataComidas(refiecoes) + "] \n" +
                    "VALOR TOTAL DA RESERVA: R$" + formataValorDaReserva() + " x" + calculaDias() + "(diarias) => R$" + this.valorReserva + " \n" +
                    "SITUACAO DO PAGAMENTO: PENDENTE.";
        } else {
            // toString caso a reserva tenha sido cancelada
            return "[" + this.id + "] Reserva de quarto em favor de: \n" +
                    " - " + this.usuario.toString() +
                    "\nDetalhes da instalacao: \n" +
                    " - " + quarto.toString() +
                    "\nDetalhes da reserva: \n" +
                    "- Periodo: " + formatadata(this.dataInicio) + " ate " + formatadata(dataFinal) + " \n" +
                    "- No. Hospedes: " + this.numeroDeHospedes + " pessoa(s) \n" +
                    "- Refeicoes incluidas: [" + formataComidas(refiecoes) + "] \n" +
                    "VALOR TOTAL DA RESERVA: R$" + formataValorDaReserva() + " x" + calculaDias() + "(diarias) => R$" + this.valorReserva + " \n" +
                    "SITUACAO DO PAGAMENTO: PENDENTE. [CANCELADA]";
        }
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public QuartoI getQuarto() {
        return quarto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Altera o status de cancelamento
     * @param statusCancelado valor booleano
     */
    public void setStatusCancelado(boolean statusCancelado) {
        this.statusCancelado = statusCancelado;
    }
}
