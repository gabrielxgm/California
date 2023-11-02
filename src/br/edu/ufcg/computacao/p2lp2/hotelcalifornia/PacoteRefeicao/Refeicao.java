package br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteRefeicao;

import org.junit.platform.commons.util.StringUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe de uma refeição
 */
public class Refeicao {
    /**
     * id da refeição
     */
    private Long idRefeicao;
    /**
     * tipo da refeição
     */
    private String tipoRefeicao;
    /**
     * título da refeição
     */
    private String titulo;
    /**
     * horário de início da refeição
     */
    private LocalTime horarioInicio;
    /**
     * horário de término da refeição
     */
    private LocalTime horarioFinal;
    /**
     * valor da refeição
     */
    private double valorRefeicao;
    /**
     * disponibilidade da refeição
     */
    private boolean disponivel;

    /**
     * Cria uma refeição a partir de seu id,tipo,título,horário de início,horário de término, valor da refeição e disponibilidade
     * @param idRefeicao id da refeição
     * @param tipoRefeicao tipo da refeição
     * @param titulo título da refeição
     * @param horarioInicio horário de início da refeição
     * @param horarioFinal horário de término da refeição
     * @param valorRefeicao valor da refeição
     * @param disponivel disponibilidade da refeição
     */
    public Refeicao(Long idRefeicao,String tipoRefeicao,String titulo,LocalTime horarioInicio,LocalTime horarioFinal
            ,double valorRefeicao,boolean disponivel){
        this.idRefeicao = idRefeicao;
        tipoRefeicao = tipoRefeicao.replaceAll("_","-");
        tipoRefeicao = tipoRefeicao.substring(0,1).concat(tipoRefeicao.substring(1).toLowerCase());
        this.tipoRefeicao = tipoRefeicao;
        this.titulo = titulo;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
        this.valorRefeicao = valorRefeicao;
        this.disponivel = disponivel;
    }

    /**
     * Atualiza os dados de uma refeição
     * @param horarioInicio horário de início da refeição
     * @param horarioFinal horário de término da refeição
     * @param valorRefeicao valor da refeição
     * @param disponivel disponibiliade da refeição
     */
    public void atualizarRefeicao(LocalTime horarioInicio,LocalTime horarioFinal,double valorRefeicao,boolean disponivel){
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
        this.valorRefeicao = valorRefeicao;
        this.disponivel = disponivel;
    }

    /**
     * Cria uma representação textual de refeição com base em sua disponibilidade
     * @return representação textual de refeiçõa
     */
    public String toString() {
        String disponibilidade;
        if(disponivel){
            disponibilidade = "VIGENTE";
        } else {
            disponibilidade = "INDISPONÍVEL";
        }
        DateTimeFormatter formatterHora =DateTimeFormatter.ofPattern("HH");
        DateTimeFormatter formatterMinuto = DateTimeFormatter.ofPattern("mm");
        return "["+idRefeicao+"] "+tipoRefeicao+": "+titulo+" ("+formatterHora.format(horarioInicio)+"h"
                +formatterMinuto.format(horarioInicio)+" as "
                +formatterHora.format(horarioFinal)+"h"+formatterMinuto.format(horarioFinal)+"). Valor por pessoa: R$"+
                String.format("%,.2f",valorRefeicao)+". "+disponibilidade+".";
    }

    /**
     * Acessa os dados do título da refeição
     * @return título da refeição
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * Acessa os dados do valor da refeição
     * @return valor da refeiçõo
     */
    public double getValorRefeicao() {
        return valorRefeicao;
    }
    /**
     * Acessa os dados do horário de início da refeição
     * @return horário de início da refeição
     */
    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }
    /**
     * Acessa os dados do horário de término da refeição
     * @return horário de término da refeição
     */
    public LocalTime getHorarioFinal() {
        return horarioFinal;
    }
    /**
     * Acessa os dados da disponibilidade da refeição
     * @return disponibilidade da refeição
     */
    public boolean getDisponivel(){
        return disponivel;
    }
}