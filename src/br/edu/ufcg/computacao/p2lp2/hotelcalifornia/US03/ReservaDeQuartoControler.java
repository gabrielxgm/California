package br.edu.ufcg.computacao.p2lp2.hotelcalifornia.US03;

import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.HotelCaliforniaSistema;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteUsuario.Usuario;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteUsuario.UsuarioController;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.US02.QuartoController;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteRefeicao.Refeicao;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.exception.HotelCaliforniaException;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;
public class ReservaDeQuartoControler {
    private UsuarioController usuarioController;
    private Map<Long, Reserva> mapReservas;

    public ReservaDeQuartoControler() {
        this.usuarioController = HotelCaliforniaSistema.getUsuarioController();
        this.mapReservas = new HashMap<>();
    }

    public void criaReserva(long idReserva, Usuario usuario, int idQuarto, int numeroDeHospedes, ArrayList<Refeicao> refiecoes, boolean pagamento, LocalDateTime dataInicio, LocalDateTime dataFinal){

        QuartoController controllerQuarto = new QuartoController();
        if(numeroDeHospedes > controllerQuarto.getQuarto(idQuarto).getVagas()){
            throw new IllegalArgumentException("numero de hospedes não pode ser maior que o numero de vagas do quarto!");
        }

        Reserva novaReserva = new Reserva(idReserva, usuario, idQuarto, numeroDeHospedes, refiecoes, pagamento, dataInicio, dataFinal);

        for(Map.Entry<Long, Reserva> reserva : mapReservas.entrySet()){

            if(reserva.getValue().getDataInicio().isBefore(dataFinal) & (reserva.getValue().getQuarto().getId() == idQuarto)){
                throw new IllegalArgumentException("quarto ainda estara em uso nessa data");
            }

        }

        this.mapReservas.put(idReserva, novaReserva);

    }

    public String cancelarReserva(String idCliente,String idReserva) {

        if(!mapReservas.get(Long.parseLong(idReserva)).getUsuario().equals(usuarioController.getMapaUsuario().get(idCliente)))
            throw new HotelCaliforniaException("SOMENTE O PROPRIO CLIENTE PODERA CANCELAR A SUA RESERVA");

        mapReservas.get(Long.parseLong(idReserva)).setStatusCancelado(true);
        return mapReservas.get(Long.parseLong(idReserva)).toString();
    }
}
