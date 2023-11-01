package br.edu.ufcg.computacao.p2lp2.hotelcalifornia.US03;

import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.HotelCaliforniaSistema;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteUsuario.Usuario;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.US02.QuartoController;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteRefeicao.Refeicao;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;
public class ReservaDeQuartoControler {
    private Map<Integer, Reserva> mapReservas;

    public ReservaDeQuartoControler() {
        this.mapReservas = new HashMap<>();
    }

    public void criaReserva(int idReserva, Usuario usuario, int idQuarto, int numeroDeHospedes, ArrayList<Refeicao> refiecoes, boolean pagamento, LocalDateTime dataInicio, LocalDateTime dataFinal){

        QuartoController controllerQuarto = new QuartoController();
        if(numeroDeHospedes > controllerQuarto.getQuarto(idQuarto).getVagas()){
            throw new IllegalArgumentException("numero de hospedes não pode ser maior que o numero de vagas do quarto!");
        }

        Reserva novaReserva = new Reserva(idReserva, usuario, idQuarto, numeroDeHospedes, refiecoes, pagamento, dataInicio, dataFinal);

        for(Map.Entry<Integer, Reserva> reserva : mapReservas.entrySet()){

            if(reserva.getValue().getDataInicio().isBefore(dataFinal) & (reserva.getValue().getQuarto().getId() == idQuarto)){
                throw new IllegalArgumentException("quarto ainda estara em uso nessa data");
            }

        }

        this.mapReservas.put(idReserva, novaReserva);

    }

    public String cancelarReserva(String idCliente,String idReserva) throws Exception {
        if(!HotelCaliforniaSistema.getUsuarioController().getMapaUsuario().get(idCliente).getFuncaoUsuario().podePagarReserva())
            throw new IllegalArgumentException("Usuário não pode pagar reserva");

        if(!mapReservas.get(Integer.parseInt(idReserva)).getUsuario().equals(HotelCaliforniaSistema.getUsuarioController().getMapaUsuario().get(idCliente)))
            throw new IllegalArgumentException("Somente o cliente que fez o cadastro da reserva pode fazer seu pagamento");

        if(ChronoUnit.DAYS.between(LocalDateTime.now(),mapReservas.get(Integer.parseInt(idReserva)).getDataInicio()) < 1)
            throw new Exception("Só é possível cancelar a reserva até 1 dia antes de seu início");

        mapReservas.get(Integer.parseInt(idReserva)).setStatusCancelado(true);
        return "Reserva cancelada";
    }
}
