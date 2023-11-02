package br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteRefeicao;

import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.HotelCaliforniaSistema;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteUsuario.UsuarioController;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.exception.HotelCaliforniaException;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Controlador de refeição
 */
public class RefeicaoController {
    private UsuarioController usuarioController;
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
        this.usuarioController = HotelCaliforniaSistema.getUsuarioController();
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
        if(!usuarioController.getMapaUsuario().containsKey(idAutenticacao))
            throw new HotelCaliforniaException("USUARIO NAO EXISTE");

        if(!usuarioController.getMapaUsuario().get(idAutenticacao).getFuncaoUsuario().podeCadastrarRefeicao())
            throw new HotelCaliforniaException("NAO E POSSIVEL PARA USUARIO CADASTRAR UMA REFEICAO");

        if(horarioInicio.isAfter(horarioFinal))
            throw new HotelCaliforniaException("HORARIO DE FIM DEVE SER POSTERIOR AO HORARIO DE INICIO");

        for(Refeicao refeicao: mapaRefeicao.values()){
            if(refeicao.getTitulo().equals(titulo))
                throw new HotelCaliforniaException("REFEICAO JA EXISTE");
        }

        mapaRefeicao.put(contadorIdRefeicao,new Refeicao(contadorIdRefeicao,tipoRefeicao,titulo,horarioInicio,horarioFinal
                ,valorRefeicao,disponivel));

        contadorIdRefeicao++;
        return mapaRefeicao.get(contadorIdRefeicao-1).toString();
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
        if(!mapaRefeicao.containsKey(idRefeicao))
            throw new HotelCaliforniaException("REFEICAO NAO EXISTE");

        if(horarioInicio.isAfter(horarioFinal))
            throw new HotelCaliforniaException("HORARIO DE FIM DEVE SER POSTERIOR AO HORARIO DE INICIO");

        mapaRefeicao.get(idRefeicao).atualizarRefeicao(horarioInicio, horarioFinal, valorRefeicao, disponivel);
        return mapaRefeicao.get(idRefeicao).toString();
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
    public String[] listarRefeicoes() {
        String[] listaRefeicao = new String[mapaRefeicao.size()];
        int i = 0;
        for(Refeicao refeicao:mapaRefeicao.values()){
            listaRefeicao[i] = refeicao.toString();
            i++;
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
