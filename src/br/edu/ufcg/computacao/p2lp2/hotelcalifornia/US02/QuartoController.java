package br.edu.ufcg.computacao.p2lp2.hotelcalifornia.US02;

import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteUsuario.Usuario;
import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteUsuario.UsuarioController;

import java.util.HashMap;
import java.util.Map;

public class QuartoController {
    private Map<Integer, QuartoI> QuartosCadastrados;

    public QuartoController() {
        QuartosCadastrados = new HashMap<>();
    }

    public void CadastraQuarto(String idUsuario, int idQuarto, String tipoDoQuarto, String pedidos, double valorBase, double valorPessoa, int vagas){
        UsuarioController usuarioController = new UsuarioController();
        Map<String, Usuario> usuarioMap = usuarioController.getMapaUsuario();
        String tipoUsuario = usuarioMap.get(idUsuario).getTipoUsuario();

        if(tipoUsuario.equals("ADM") | tipoUsuario.equals("GER")){
            switch (tipoDoQuarto){
                case "Single":

                    if (vagas != 1){
                        throw new IllegalArgumentException("quartos Single so podem ter uma vaga!");
                    } else {
                        QuartoI quartonovo = new QuartoSingle(valorBase, valorPessoa, idQuarto);
                        QuartosCadastrados.put(idQuarto,quartonovo);

                    }
                case "Double":

                    if (vagas != 2){
                        throw new IllegalArgumentException("quartos double devem ter duas vagas!");
                    } else if(pedidos.equals("")){
                        QuartoI quartonovo = new QuartoDouble(valorBase, valorPessoa, idQuarto);
                        QuartosCadastrados.put(idQuarto,quartonovo);
                    } else {
                        QuartoI quartonovo = new QuartoDouble(valorBase, valorPessoa, idQuarto, pedidos);
                        QuartosCadastrados.put(idQuarto,quartonovo);
                    }
                case "Family":

                    if(pedidos.equals("")){
                        QuartoI quartonovo = new QuartoFamily(vagas, valorBase, valorPessoa, idQuarto);
                        QuartosCadastrados.put(idQuarto,quartonovo);
                    } else {
                        QuartoI quartonovo = new QuartoFamily(vagas, valorBase, valorPessoa, idQuarto, pedidos);
                        QuartosCadastrados.put(idQuarto,quartonovo);
                    }
                default:
                    throw new IllegalArgumentException("O Hotel California so aceita quartos dos tipos Single, Double ou Family");
            }
        }
        else {
            throw new IllegalArgumentException("Usuario não tem permição para executar este comando!");
        }
    }

    public QuartoI getQuarto(Integer id){
        return QuartosCadastrados.get(id);
    }
}
