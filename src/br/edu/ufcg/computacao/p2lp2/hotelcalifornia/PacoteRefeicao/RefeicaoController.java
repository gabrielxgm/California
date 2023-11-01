package br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteRefeicao;

import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.HotelCaliforniaSistema;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Controlador de refeição
 */
public class RefeicaoController {
    /**
     * Mapa de refeições
     */
    private Map<Long,Refeicao> mapaRefeicao;
    /**
     * Contador sequencial de refeição
     */
    private long contadorIdRefeicao;

    /**
     * Cria um controlador de refeição
     */
    public RefeicaoController(){
        this.mapaRefeicao = new HashMap<>();
        this.contadorIdRefeicao = 1;
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
    public String disponibilizarRefeicao(String idAutenticacao,String tipoRefeicao,String titulo, LocalTime horarioInicio
            ,LocalTime horarioFinal,double valorRefeicao,boolean disponivel){

        if(!(tipoRefeicao.equals("Jantar") || tipoRefeicao.equals("Almoco") || tipoRefeicao.equals("Cafe-da-manha")))
            throw new IllegalArgumentException("Tipo de refeição inválido");

        if(!HotelCaliforniaSistema.getUsuarioController().getMapaUsuario().get(idAutenticacao).getFuncaoUsuario().podeCadastrarRefeicao())
            throw new IllegalArgumentException("Usuário não tem permissão para disponibilizar refeição");

        if(horarioInicio.isAfter(horarioFinal))
            throw new IllegalArgumentException("Horário de início não pode ser posterior ao horário final");

        for(Refeicao refeicao: mapaRefeicao.values()){
            if(refeicao.getTitulo().equals(titulo))
                throw new IllegalArgumentException("Título de refeição já existe");
        }

        mapaRefeicao.put(contadorIdRefeicao,new Refeicao(contadorIdRefeicao,tipoRefeicao,titulo,horarioInicio,horarioFinal
                ,valorRefeicao,disponivel));

        contadorIdRefeicao++;
        return "Refeição cadastrada com sucesso";
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
    public String atualizarRefeicao(Long idRefeicao, LocalTime horarioInicio, LocalTime horarioFinal, double valorRefeicao
            , boolean disponivel){

        if(horarioInicio.isAfter(horarioFinal))
            throw new IllegalArgumentException("Horário de início não pode ser posterior ao horário de término");

        mapaRefeicao.get(idRefeicao).atualizarRefeicao(horarioInicio, horarioFinal, valorRefeicao, disponivel);
        return "Refeição atualizada com sucesso";
    }

    /**
     * Exibe os dados de uma refeição
     * @param idRefeicao id da refeição
     * @return representação textual de uma refeição
     */
    public String exibirRefeicao(Long idRefeicao){
        return mapaRefeicao.get(idRefeicao).toString();
    }

    /**
     * Lista os dados de todas as refeições cadastradas
     * @return lista de refeições
     */
    public ArrayList<String> listarRefeicoes() {
        ArrayList<String> listaRefeicao = new ArrayList<>();
        for(Refeicao refeicao:mapaRefeicao.values()){
            listaRefeicao.add(refeicao.toString());
        }
        return listaRefeicao;
    }

    /**
     * Acessa os dados de mapa de refeição
     * @return mapa de refeição
     */
    public Map<Long, Refeicao> getMapaRefeicao() {
        return mapaRefeicao;
    }
}
