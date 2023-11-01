package br.edu.ufcg.computacao.p2lp2.hotelcalifornia;

import org.junit.jupiter.api.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class HotelCaliforniaSistemaTest {
    /**
     * Obj de sistema de hotel California
     */
    HotelCaliforniaSistema hotelCaliforniaSistema;

    @BeforeEach
    void setUpHotelCalifornia(){
        hotelCaliforniaSistema = new HotelCaliforniaSistema();
    }
    @AfterEach
    void tearDown() {
        //hotelCaliforniaSistema = null;
         }
    @Test
    void testAdministradorCadastraAdministrador(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Arlis","ADM",777);
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("ADM2").getIdUsuario(),2);
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("ADM2").getTipoUsuario(),"ADM");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("ADM2").getNomeUsuario(),"Arlis");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("ADM2").getDocumento(),777L);

    }
    @Test
    void testAdministradorCadastraGerente(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Vitor","GER",9090);
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("GER2").getIdUsuario(),2);
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("GER2").getTipoUsuario(),"GER");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("GER2").getNomeUsuario(),"Vitor");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("GER2").getDocumento(),9090L);
    }
    @Test
    void testAdministradorCadastraFuncionario(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("FUN2").getIdUsuario(),2);
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("FUN2").getTipoUsuario(),"FUN");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("FUN2").getNomeUsuario(),"Gabriel");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("FUN2").getDocumento(),157L);
    }
    @Test
    void testAdministradorCadastraCliente(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Epic Games","CLI",-1);
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("CLI2").getIdUsuario(),2);
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("CLI2").getTipoUsuario(),"CLI");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("CLI2").getNomeUsuario(),"Epic Games");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("CLI2").getDocumento(),-1L);
    }

    @Test
    void testFuncionarioCadastraCliente(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        hotelCaliforniaSistema.cadastrarUsuario("FUN2","Epic Games","CLI",-1);
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("CLI3").getIdUsuario(),3);
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("CLI3").getTipoUsuario(),"CLI");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("CLI3").getNomeUsuario(),"Epic Games");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("CLI3").getDocumento(),-1L);
    }
    @Test
    void testFuncionarioCadastraFuncionario() {
        hotelCaliforniaSistema.cadastrarUsuario("ADM1", "Gabriel", "FUN", 157);
        try {
            hotelCaliforniaSistema.cadastrarUsuario("FUN2", "Epic Games", "FUN",-1);
            fail("Título do teste falhou");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não pode cadastrar essa função");
        }
    }
    @Test
    void testFuncionarioCadastraGerente() {
        hotelCaliforniaSistema.cadastrarUsuario("ADM1", "Gabriel", "FUN", 157);
        try {
            hotelCaliforniaSistema.cadastrarUsuario("FUN2", "Epic Games", "GER", -1);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não pode cadastrar essa função");
        }
    }
    @Test
    void testFuncionarioCadastraAdministrador() {
        hotelCaliforniaSistema.cadastrarUsuario("ADM1", "Gabriel", "FUN", 157);
        try {
            hotelCaliforniaSistema.cadastrarUsuario("FUN2", "Epic Games", "ADM", -1);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não pode cadastrar essa função");
        }
    }
    @Test
    void testClienteCadastraCliente() {
        hotelCaliforniaSistema.cadastrarUsuario("ADM1", "Epic Games", "CLI", -1);
        try {
            hotelCaliforniaSistema.cadastrarUsuario("CLI2", "Riot", "CLI", -1);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não pode cadastrar essa função");
        }
    }
    @Test
    void testClienteCadastraAdministrador() {
        hotelCaliforniaSistema.cadastrarUsuario("ADM1", "Epic Games", "CLI", -1);
        try {
            hotelCaliforniaSistema.cadastrarUsuario("CLI2", "Riot", "ADM", -1);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não pode cadastrar essa função");
        }
    }
    @Test
    void testClienteCadastraGerente() {
        hotelCaliforniaSistema.cadastrarUsuario("ADM1", "Epic Games", "CLI", -1);
        try {
            hotelCaliforniaSistema.cadastrarUsuario("CLI2", "Riot", "GER", -1);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não pode cadastrar essa função");
        }
    }
    @Test
    void testClienteCadastraFuncionario() {
        hotelCaliforniaSistema.cadastrarUsuario("ADM1", "Epic Games", "CLI", -1);
        try {
            hotelCaliforniaSistema.cadastrarUsuario("CLI2", "Riot", "FUN", -1);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não pode cadastrar essa função");
        }
    }
    @Test
    void testGerenteCadastraCliente(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Vitor","GER",9090);
        hotelCaliforniaSistema.cadastrarUsuario("GER2","Epic Games","CLI",-1);
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("CLI3").getIdUsuario(),3);
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("CLI3").getTipoUsuario(),"CLI");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("CLI3").getNomeUsuario(),"Epic Games");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("CLI3").getDocumento(),-1L);
    }
    @Test
    void testGerenteCadastraGerente() {
        hotelCaliforniaSistema.cadastrarUsuario("ADM1", "Vitor", "GER", 9090);
        try {
            hotelCaliforniaSistema.cadastrarUsuario("GER2", "Epic Games", "GER", -1);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não pode cadastrar essa função");
        }
    }
    @Test
    void testGerenteCadastraFuncionario(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Vitor","GER",9090);
        hotelCaliforniaSistema.cadastrarUsuario("GER2","Epic Games","FUN",-1);
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("FUN3").getIdUsuario(),3);
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("FUN3").getTipoUsuario(),"FUN");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("FUN3").getNomeUsuario(),"Epic Games");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("FUN3").getDocumento(),-1L);
    }
    @Test
    void testCadastrarDoisGerentes() {
        hotelCaliforniaSistema.cadastrarUsuario("ADM1", "Vitor", "GER", 9090);
        try {
            hotelCaliforniaSistema.cadastrarUsuario("ADM1", "Gabriel", "GER", 157);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Já existe um gerente cadastrado");
        }
    }
    @Test
    void testGerenteCadastraAdministrador() {
        hotelCaliforniaSistema.cadastrarUsuario("ADM1", "Vitor", "GER", 9090);
        try {
            hotelCaliforniaSistema.cadastrarUsuario("GER2", "Epic Games", "ADM", -1);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),"Usuário não pode cadastrar essa função");
        }
    }
    @Test
    void testatualizaAdministrador(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Arlis","ADM",777);
        hotelCaliforniaSistema.atualizarUsuario("ADM1","ADM2","FUN");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("FUN2").getIdUsuario(),2);
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("FUN2").getTipoUsuario(),"FUN");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("FUN2").getNomeUsuario(),"Arlis");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("FUN2").getDocumento(),777L);
    }
    @Test
    void testatualizaCliente() {
        hotelCaliforniaSistema.cadastrarUsuario("ADM1", "Arlis", "CLI", 777);
        try {
            hotelCaliforniaSistema.atualizarUsuario("ADM1", "CLI2", "ADM");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Cliente não pode ser atualizado");
        }
    }
    @Test
    void testatualizaFuncionario(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Arlis","FUN",777);
        hotelCaliforniaSistema.atualizarUsuario("ADM1","FUN2","ADM");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("ADM2").getIdUsuario(),2);
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("ADM2").getTipoUsuario(),"ADM");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("ADM2").getNomeUsuario(),"Arlis");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("ADM2").getDocumento(),777L);
    }
    @Test
    void testatualizaGerente(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Arlis","ADM",777);
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Vitor","GER",9090);
        hotelCaliforniaSistema.atualizarUsuario("ADM1","ADM2","GER");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("FUN3").getIdUsuario(),3);
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("FUN3").getTipoUsuario(),"FUN");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("FUN3").getNomeUsuario(),"Vitor");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("FUN3").getDocumento(),9090L);
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("GER2").getIdUsuario(),2);
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("GER2").getTipoUsuario(),"GER");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("GER2").getNomeUsuario(),"Arlis");
        assertEquals(hotelCaliforniaSistema.usuarioController.getMapaUsuario().get("GER2").getDocumento(),777L);
    }
    @Test
    void testClienteAtualiza(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Ben 10","CLI",10);
        try {
            hotelCaliforniaSistema.atualizarUsuario("CLI2", "ADM1", "FUN");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Somente um administrador pode atualizar um usuário");
        }
    }
    @Test
    void testGerenteAtualiza(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Ben 10","GER",10);
        try {
            hotelCaliforniaSistema.atualizarUsuario("GER2", "ADM1", "FUN");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Somente um administrador pode atualizar um usuário");
        }
    }
    @Test
    void testFuncionarioAtualiza() {
        hotelCaliforniaSistema.cadastrarUsuario("ADM1", "Ben 10", "FUN", 10);
        try {
            hotelCaliforniaSistema.atualizarUsuario("FUN2", "ADM1", "FUN");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Somente um administrador pode atualizar um usuário");
        }
    }
    @Test
    void exibirUsuario(){
        assert Objects.equals(hotelCaliforniaSistema.exibirUsuario("ADM1"),"[ADM1] Joao Costa (No. Doc. 123456)");
    }
    @Test
    void listarUsuario(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        ArrayList<String> list = new ArrayList<>();
        list.add("[FUN2] Gabriel (No. Doc. 157)");
        list.add("[ADM1] Joao Costa (No. Doc. 123456)");
        assertEquals(list, hotelCaliforniaSistema.listarUsuarios());
    }
    @Test
    void gerenteDisponibilizaRefeicao(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Vitor","GER",9090);
        assertEquals(hotelCaliforniaSistema.disponibilizarRefeicao("GER2","Cafe-da-manha"
                ,"Cafe completo reforcado", LocalTime.of(6,0,0),LocalTime.of(10,0,0)
                ,30.00,true),"Refeição cadastrada com sucesso");
    }
    @Test
    void administradorDisponibilizaRefeicao(){
        try {
            hotelCaliforniaSistema.disponibilizarRefeicao("ADM1", "Cafe-da-manha"
                    , "Cafe completo reforcado", LocalTime.of(6, 0, 0)
                    , LocalTime.of(10, 0, 0), 30.00, true);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não tem permissão para disponibilizar refeição");
        }
    }
    @Test
    void funcionarioDisponibilizaRefeicao() {
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        assertEquals(hotelCaliforniaSistema.disponibilizarRefeicao("FUN2", "Cafe-da-manha"
                , "Cafe completo reforcado", LocalTime.of(6, 0, 0)
                , LocalTime.of(10, 0, 0)
                , 30.00, true),"Refeição cadastrada com sucesso");
    }
    @Test
    void clienteDisponibilizaRefeicao(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Gabriel","CLI",157);
        try {
            hotelCaliforniaSistema.disponibilizarRefeicao("CLI2", "Cafe-da-manha"
                    , "Cafe completo reforcado", LocalTime.of(6, 0, 0)
                    , LocalTime.of(10, 0, 0), 30.00, true);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não tem permissão para disponibilizar refeição");
        }
    }
    @Test
    void disponibilizaRefeicaoComMesmoTitulo(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        hotelCaliforniaSistema.disponibilizarRefeicao("FUN2", "Cafe-da-manha"
                , "Cafe completo reforcado", LocalTime.of(6, 0, 0)
                , LocalTime.of(10, 0, 0)
                , 30.00, true);
        try {
            hotelCaliforniaSistema.disponibilizarRefeicao("FUN2"
                    , "Jantar", "Cafe completo reforcado", LocalTime.of(10, 0, 0)
                    , LocalTime.of(20, 0, 0), 45.00, true);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Título de refeição já existe");
        }
    }
    @Test
    void disponibilizaJantar(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        assertEquals(hotelCaliforniaSistema.disponibilizarRefeicao("FUN2", "Jantar"
                , "Cafe completo reforcado", LocalTime.of(6, 0, 0)
                , LocalTime.of(10, 0, 0)
                , 30.00, true),"Refeição cadastrada com sucesso");
    }
    @Test
    void disponibilizaAlmoco(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        assertEquals(hotelCaliforniaSistema.disponibilizarRefeicao("FUN2", "Almoco"
                , "Cafe completo reforcado", LocalTime.of(6, 0, 0)
                , LocalTime.of(10, 0, 0)
                , 30.00, true),"Refeição cadastrada com sucesso");

    }
    @Test
    void disponibilizaRefeicaoTipoInvalido(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        try {
            hotelCaliforniaSistema.disponibilizarRefeicao("FUN2", "Sobremesa"
                    , "Cafe completo reforcado", LocalTime.of(6, 0, 0)
                    , LocalTime.of(10, 0, 0), 30.00, true);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Tipo de refeição inválido");
        }


    }
    @Test
    void disponibilizaRefeicaoHorarioInicioPosteriorHorarioFinal(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        try {
            hotelCaliforniaSistema.disponibilizarRefeicao("FUN2", "Cafe-da-manha"
                    , "Cafe completo reforcado", LocalTime.of(12, 0, 0)
                    , LocalTime.of(10, 0, 0), 30.00, true);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Horário de início não pode ser posterior ao horário final");
        }
    }
    @Test
    void atualizarRefeicao(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        hotelCaliforniaSistema.disponibilizarRefeicao("FUN2", "Cafe-da-manha"
                , "Cafe completo reforcado", LocalTime.of(6, 0, 0)
                , LocalTime.of(10, 0, 0), 30.00, true);

        hotelCaliforniaSistema.alterarRefeicao(1L,LocalTime.of(9,45,0),LocalTime.of(13,0,0)
                ,38.99,false);

        assertEquals(hotelCaliforniaSistema.refeicaoController.getMapaRefeicao().get(1L).getHorarioInicio(),LocalTime.of(9,45,0));
        assertEquals(hotelCaliforniaSistema.refeicaoController.getMapaRefeicao().get(1L).getHorarioFinal(),LocalTime.of(13,0,0));
        assertEquals(hotelCaliforniaSistema.refeicaoController.getMapaRefeicao().get(1L).getValorRefeicao(),38.99);
        assertFalse(hotelCaliforniaSistema.refeicaoController.getMapaRefeicao().get(1L).getDisponivel());
    }
    @Test
    void exibirRefeicao(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Gabriel","FUN",157);

        hotelCaliforniaSistema.disponibilizarRefeicao("FUN2", "Cafe-da-manha"
                , "Cafe completo reforcado", LocalTime.of(6, 0, 0)
                , LocalTime.of(10, 0, 0), 30.00, true);

        assertEquals(hotelCaliforniaSistema.exibirRefeicao(1L)
                ,"[1] Cafe-da-manha: Cafe completo reforcado (06h00 as 10h00). Valor por pessoa: R$30,00. VIGENTE.");
    }
    @Test
    void listarRefeicao(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Gabriel","FUN",157);

        ArrayList<String> list = new ArrayList<>();

        list.add("[1] Cafe-da-manha: Cafe completo reforcado (06h00 as 10h00). Valor por pessoa: R$30,00. VIGENTE.");
        list.add("[2] Jantar: Jantar a dois (18h00 as 20h00). Valor por pessoa: R$80,00. INDISPONIVEL.");

        hotelCaliforniaSistema.disponibilizarRefeicao("FUN2", "Cafe-da-manha"
                , "Cafe completo reforcado", LocalTime.of(6, 0, 0)
                , LocalTime.of(10, 0, 0), 30.00, true);

        hotelCaliforniaSistema.disponibilizarRefeicao("FUN2", "Jantar"
                , "Jantar a dois", LocalTime.of(18, 0, 0)
                , LocalTime.of(20, 0, 0), 80.00, false);
        assertEquals(hotelCaliforniaSistema.listarRefeicoes(),list);
    }
    @Test
    void disponibilizarPagamentoCartao(){
        hotelCaliforniaSistema.disponibilizarFormaDePagamento("ADM1","Cartao",0);
        assertEquals(hotelCaliforniaSistema.pagamentoController.getMapaPagamentos().get(1).getFormaPagamento(),"Cartao");
        assertEquals(hotelCaliforniaSistema.pagamentoController.getMapaPagamentos().get(1).getIdPagamento(),1);
        assertEquals(hotelCaliforniaSistema.pagamentoController.getMapaPagamentos().get(1).getPercentualDesconto(),0);
    }
    @Test
    void disponibilizarPagamentoPIX(){
        hotelCaliforniaSistema.disponibilizarFormaDePagamento("ADM1","PIX",5);
        assertEquals(hotelCaliforniaSistema.pagamentoController.getMapaPagamentos().get(1).getFormaPagamento(),"PIX");
        assertEquals(hotelCaliforniaSistema.pagamentoController.getMapaPagamentos().get(1).getIdPagamento(),1);
        assertEquals(hotelCaliforniaSistema.pagamentoController.getMapaPagamentos().get(1).getPercentualDesconto(),5);
    }
    @Test
    void disponibilizarPagamentoDinheiro(){
        hotelCaliforniaSistema.disponibilizarFormaDePagamento("ADM1","Dinheiro",10);
        assertEquals(hotelCaliforniaSistema.pagamentoController.getMapaPagamentos().get(1).getFormaPagamento(),"Dinheiro");
        assertEquals(hotelCaliforniaSistema.pagamentoController.getMapaPagamentos().get(1).getIdPagamento(),1);
        assertEquals(hotelCaliforniaSistema.pagamentoController.getMapaPagamentos().get(1).getPercentualDesconto(),10);
    }
    @Test
    void disponibilizarPagamentoMesmoTipo(){
        hotelCaliforniaSistema.disponibilizarFormaDePagamento("ADM1","Dinheiro",10);
        try {
            hotelCaliforniaSistema.disponibilizarFormaDePagamento("ADM1", "Dinheiro", 15);
            fail("Não podem existir dois tipos iguais de pagamento");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Tipo de pagamento já está cadastrado");
        }
    }
    @Test
    void disponibilizarPagamentoTipoInvalido(){
        try {
            hotelCaliforniaSistema.disponibilizarFormaDePagamento("ADM1", "Pedras", 10);
            fail("Tipo de pagamento era pra ser inválido");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Forma de pagamento inválida");
        }
    }
    @Test
    void disponibilizarPagamentoUsuarioInvalido(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        try{
            hotelCaliforniaSistema.disponibilizarFormaDePagamento("FUN2","Dinheiro",10);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuario não pode disponibilizar pagamento");
        }
    }
    @Test
    void atualizarPagamento(){
        hotelCaliforniaSistema.disponibilizarFormaDePagamento("ADM1","PIX",5);
        hotelCaliforniaSistema.alterarFormaDePagamento("ADM1",1,"PIX",8);
        assertEquals(hotelCaliforniaSistema.pagamentoController.getMapaPagamentos().get(1).getPercentualDesconto(),8);
    }
    @Test
    void atualizarPagamentoUsuarioInvalido(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        try{
            hotelCaliforniaSistema.alterarFormaDePagamento("FUN2",1,"PIX",8);
            fail("Funcionário não pode alterar forma de pagamento");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não tem permissão para atualizar o pagamento");
        }
    }
    @Test
    void atualizarPagamentoFormaDePagamentoJaExiste(){
        hotelCaliforniaSistema.disponibilizarFormaDePagamento("ADM1","PIX",5);
        hotelCaliforniaSistema.disponibilizarFormaDePagamento("ADM1","Dinheiro",10);
        try {
            hotelCaliforniaSistema.alterarFormaDePagamento("ADM1",2,"PIX",10);
            fail("Não pode se repetir a mesma forma de pagamento");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Forma de pagamento já existe");
        }
    }
    @Test
    void exibirPagamento(){
        hotelCaliforniaSistema.disponibilizarFormaDePagamento("ADM1","PIX",5);
        assertEquals(hotelCaliforniaSistema.exibirFormaPagamento(1)
                ,"[1] Forma de pagamento: PIX (5% de desconto em pagamentos)");
    }
    @Test
    void listarPagamentos(){
        hotelCaliforniaSistema.disponibilizarFormaDePagamento("ADM1","PIX",5);
        hotelCaliforniaSistema.disponibilizarFormaDePagamento("ADM1","Cartao",0);

        ArrayList<String> list = new ArrayList<>();
        list.add("[1] Forma de pagamento: PIX (5% de desconto em pagamentos)");
        list.add("[2] Forma de pagamento: Cartao (0% de desconto em pagamentos)");
        assertEquals(list,hotelCaliforniaSistema.listarFormasPagamentos());
    }
    @Test
    void clienteCancelaReserva(){
        hotelCaliforniaSistema.cadastrarUsuario("ADM1","Gabriel","CLI",157);
        //hotelCaliforniaSistema.cancelarReserva("CLI2",)
    }
}
