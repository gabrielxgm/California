package br.edu.ufcg.computacao.p2lp2.hotelcalifornia;

import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.exception.HotelCaliforniaException;
import org.junit.jupiter.api.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class HotelCaliforniaSistemaTest {
    /**
     * Obj de sistema de hotel California
     */
    HotelCaliforniaSistema driver;

    @BeforeEach
    void setUpHotelCalifornia(){
        driver = new HotelCaliforniaSistema();
    }
    @AfterEach
    void tearDown() {
        driver = null;
         }

    @Test
    void testAdministradorCadastraAdministrador() {
        driver.cadastrarUsuario("ADM1","Arlis","ADM",777);
        assertEquals(driver.usuarioController.getMapaUsuario().get("ADM2").getIdUsuario(),2);
        assertEquals(driver.usuarioController.getMapaUsuario().get("ADM2").getTipoUsuario(),"ADM");
        assertEquals(driver.usuarioController.getMapaUsuario().get("ADM2").getNomeUsuario(),"Arlis");
        assertEquals(driver.usuarioController.getMapaUsuario().get("ADM2").getDocumento(),777L);

    }
    @Test
    @DisplayName("CA.01.1: Cadastrar Administrador")
    void testCadastrarAdministrador() throws Throwable {
        String resultado = driver.cadastrarUsuario("ADM1", "Novo Administrador", "ADM", 123456L);
        assertTrue(resultado.contains("ADM"));
    }
    @Test
    @DisplayName("CA.01.1: Cadastrar Gerente")
    void testCadastrarGerente() throws Throwable {
        String resultado = driver.cadastrarUsuario("ADM1", "Novo Gerente", "GER", 123456L);
        assertTrue(resultado.contains("GER"));
    }
    @Test
    @DisplayName("CA.01.1: Usuario Autenticacao nao existe ao cadastrar")
    void testUsuarioAutenticacaoNaoExisteAoCadastrar() {
        HotelCaliforniaException hce = assertThrows(HotelCaliforniaException.class, () -> {
            driver.cadastrarUsuario("ADM2", "Novo Gerente", "GER", 123456L);
        });
        assertTrue(hce.getMessage().toUpperCase().contains("USUARIO NAO EXISTE"));
    }
  /*  @Test
    void testAdministradorCadastraGerente(){
        driver.cadastrarUsuario("ADM1","Vitor","GER",9090);
        assertEquals(driver.usuarioController.getMapaUsuario().get("GER2").getIdUsuario(),2);
        assertEquals(driver.usuarioController.getMapaUsuario().get("GER2").getTipoUsuario(),"GER");
        assertEquals(driver.usuarioController.getMapaUsuario().get("GER2").getNomeUsuario(),"Vitor");
        assertEquals(driver.usuarioController.getMapaUsuario().get("GER2").getDocumento(),9090L);
    }
    @Test
    void testAdministradorCadastraFuncionario(){
        driver.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        assertEquals(driver.usuarioController.getMapaUsuario().get("FUN2").getIdUsuario(),2);
        assertEquals(driver.usuarioController.getMapaUsuario().get("FUN2").getTipoUsuario(),"FUN");
        assertEquals(driver.usuarioController.getMapaUsuario().get("FUN2").getNomeUsuario(),"Gabriel");
        assertEquals(driver.usuarioController.getMapaUsuario().get("FUN2").getDocumento(),157L);
    }
    @Test
    void testAdministradorCadastraCliente(){
        driver.cadastrarUsuario("ADM1","Epic Games","CLI",-1);
        assertEquals(driver.usuarioController.getMapaUsuario().get("CLI2").getIdUsuario(),2);
        assertEquals(driver.usuarioController.getMapaUsuario().get("CLI2").getTipoUsuario(),"CLI");
        assertEquals(driver.usuarioController.getMapaUsuario().get("CLI2").getNomeUsuario(),"Epic Games");
        assertEquals(driver.usuarioController.getMapaUsuario().get("CLI2").getDocumento(),-1L);
    }

    @Test
    void testFuncionarioCadastraCliente(){
        driver.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        driver.cadastrarUsuario("FUN2","Epic Games","CLI",-1);
        assertEquals(driver.usuarioController.getMapaUsuario().get("CLI3").getIdUsuario(),3);
        assertEquals(driver.usuarioController.getMapaUsuario().get("CLI3").getTipoUsuario(),"CLI");
        assertEquals(driver.usuarioController.getMapaUsuario().get("CLI3").getNomeUsuario(),"Epic Games");
        assertEquals(driver.usuarioController.getMapaUsuario().get("CLI3").getDocumento(),-1L);
    }
    @Test
    void testFuncionarioCadastraFuncionario() {
        driver.cadastrarUsuario("ADM1", "Gabriel", "FUN", 157);
        try {
            driver.cadastrarUsuario("FUN2", "Epic Games", "FUN",-1);
            fail("Título do teste falhou");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não pode cadastrar essa função");
        }
    }
    @Test
    void testFuncionarioCadastraGerente() {
        driver.cadastrarUsuario("ADM1", "Gabriel", "FUN", 157);
        try {
            driver.cadastrarUsuario("FUN2", "Epic Games", "GER", -1);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não pode cadastrar essa função");
        }
    }
    @Test
    void testFuncionarioCadastraAdministrador() {
        driver.cadastrarUsuario("ADM1", "Gabriel", "FUN", 157);
        try {
            driver.cadastrarUsuario("FUN2", "Epic Games", "ADM", -1);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não pode cadastrar essa função");
        }
    }
    @Test
    void testClienteCadastraCliente() {
        driver.cadastrarUsuario("ADM1", "Epic Games", "CLI", -1);
        try {
            driver.cadastrarUsuario("CLI2", "Riot", "CLI", -1);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não pode cadastrar essa função");
        }
    }
    @Test
    void testClienteCadastraAdministrador() {
        driver.cadastrarUsuario("ADM1", "Epic Games", "CLI", -1);
        try {
            driver.cadastrarUsuario("CLI2", "Riot", "ADM", -1);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não pode cadastrar essa função");
        }
    }
    @Test
    void testClienteCadastraGerente() {
        driver.cadastrarUsuario("ADM1", "Epic Games", "CLI", -1);
        try {
            driver.cadastrarUsuario("CLI2", "Riot", "GER", -1);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não pode cadastrar essa função");
        }
    }
    @Test
    void testClienteCadastraFuncionario() {
        driver.cadastrarUsuario("ADM1", "Epic Games", "CLI", -1);
        try {
            driver.cadastrarUsuario("CLI2", "Riot", "FUN", -1);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não pode cadastrar essa função");
        }
    }
    @Test
    void testGerenteCadastraCliente(){
        driver.cadastrarUsuario("ADM1","Vitor","GER",9090);
        driver.cadastrarUsuario("GER2","Epic Games","CLI",-1);
        assertEquals(driver.usuarioController.getMapaUsuario().get("CLI3").getIdUsuario(),3);
        assertEquals(driver.usuarioController.getMapaUsuario().get("CLI3").getTipoUsuario(),"CLI");
        assertEquals(driver.usuarioController.getMapaUsuario().get("CLI3").getNomeUsuario(),"Epic Games");
        assertEquals(driver.usuarioController.getMapaUsuario().get("CLI3").getDocumento(),-1L);
    }
    @Test
    void testGerenteCadastraGerente() {
        driver.cadastrarUsuario("ADM1", "Vitor", "GER", 9090);
        try {
            driver.cadastrarUsuario("GER2", "Epic Games", "GER", -1);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não pode cadastrar essa função");
        }
    }
    @Test
    void testGerenteCadastraFuncionario(){
        driver.cadastrarUsuario("ADM1","Vitor","GER",9090);
        driver.cadastrarUsuario("GER2","Epic Games","FUN",-1);
        assertEquals(driver.usuarioController.getMapaUsuario().get("FUN3").getIdUsuario(),3);
        assertEquals(driver.usuarioController.getMapaUsuario().get("FUN3").getTipoUsuario(),"FUN");
        assertEquals(driver.usuarioController.getMapaUsuario().get("FUN3").getNomeUsuario(),"Epic Games");
        assertEquals(driver.usuarioController.getMapaUsuario().get("FUN3").getDocumento(),-1L);
    }
    @Test
    void testCadastrarDoisGerentes() {
        driver.cadastrarUsuario("ADM1", "Vitor", "GER", 9090);
        try {
            driver.cadastrarUsuario("ADM1", "Gabriel", "GER", 157);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Já existe um gerente cadastrado");
        }
    }
    @Test
    void testGerenteCadastraAdministrador() {
        driver.cadastrarUsuario("ADM1", "Vitor", "GER", 9090);
        try {
            driver.cadastrarUsuario("GER2", "Epic Games", "ADM", -1);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),"Usuário não pode cadastrar essa função");
        }
    }
    @Test
    void testatualizaAdministrador(){
        driver.cadastrarUsuario("ADM1","Arlis","ADM",777);
        driver.atualizarUsuario("ADM1","ADM2","FUN");
        assertEquals(driver.usuarioController.getMapaUsuario().get("FUN2").getIdUsuario(),2);
        assertEquals(driver.usuarioController.getMapaUsuario().get("FUN2").getTipoUsuario(),"FUN");
        assertEquals(driver.usuarioController.getMapaUsuario().get("FUN2").getNomeUsuario(),"Arlis");
        assertEquals(driver.usuarioController.getMapaUsuario().get("FUN2").getDocumento(),777L);
    }
    @Test
    void testatualizaCliente() {
        driver.cadastrarUsuario("ADM1", "Arlis", "CLI", 777);
        try {
            driver.atualizarUsuario("ADM1", "CLI2", "ADM");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Cliente não pode ser atualizado");
        }
    }
    @Test
    void testatualizaFuncionario(){
        driver.cadastrarUsuario("ADM1","Arlis","FUN",777);
        driver.atualizarUsuario("ADM1","FUN2","ADM");
        assertEquals(driver.usuarioController.getMapaUsuario().get("ADM2").getIdUsuario(),2);
        assertEquals(driver.usuarioController.getMapaUsuario().get("ADM2").getTipoUsuario(),"ADM");
        assertEquals(driver.usuarioController.getMapaUsuario().get("ADM2").getNomeUsuario(),"Arlis");
        assertEquals(driver.usuarioController.getMapaUsuario().get("ADM2").getDocumento(),777L);
    }
    @Test
    void testatualizaGerente(){
        driver.cadastrarUsuario("ADM1","Arlis","ADM",777);
        driver.cadastrarUsuario("ADM1","Vitor","GER",9090);
        driver.atualizarUsuario("ADM1","ADM2","GER");
        assertEquals(driver.usuarioController.getMapaUsuario().get("FUN3").getIdUsuario(),3);
        assertEquals(driver.usuarioController.getMapaUsuario().get("FUN3").getTipoUsuario(),"FUN");
        assertEquals(driver.usuarioController.getMapaUsuario().get("FUN3").getNomeUsuario(),"Vitor");
        assertEquals(driver.usuarioController.getMapaUsuario().get("FUN3").getDocumento(),9090L);
        assertEquals(driver.usuarioController.getMapaUsuario().get("GER2").getIdUsuario(),2);
        assertEquals(driver.usuarioController.getMapaUsuario().get("GER2").getTipoUsuario(),"GER");
        assertEquals(driver.usuarioController.getMapaUsuario().get("GER2").getNomeUsuario(),"Arlis");
        assertEquals(driver.usuarioController.getMapaUsuario().get("GER2").getDocumento(),777L);
    }
    @Test
    void testClienteAtualiza(){
        driver.cadastrarUsuario("ADM1","Ben 10","CLI",10);
        try {
            driver.atualizarUsuario("CLI2", "ADM1", "FUN");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Somente um administrador pode atualizar um usuário");
        }
    }
    @Test
    void testGerenteAtualiza(){
        driver.cadastrarUsuario("ADM1","Ben 10","GER",10);
        try {
            driver.atualizarUsuario("GER2", "ADM1", "FUN");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Somente um administrador pode atualizar um usuário");
        }
    }
    @Test
    void testFuncionarioAtualiza() {
        driver.cadastrarUsuario("ADM1", "Ben 10", "FUN", 10);
        try {
            driver.atualizarUsuario("FUN2", "ADM1", "FUN");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Somente um administrador pode atualizar um usuário");
        }
    }
    @Test
    void exibirUsuario(){
        assert Objects.equals(driver.exibirUsuario("ADM1"),"[ADM1] Joao Costa (No. Doc. 123456)");
    }
    @Test
    void listarUsuario(){
        driver.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        ArrayList<String> list = new ArrayList<>();
        list.add("[FUN2] Gabriel (No. Doc. 157)");
        list.add("[ADM1] Joao Costa (No. Doc. 123456)");
        assertEquals(list, driver.listarUsuarios());
    }
    @Test
    void gerenteDisponibilizaRefeicao(){
        driver.cadastrarUsuario("ADM1","Vitor","GER",9090);
        assertEquals(driver.disponibilizarRefeicao("GER2","Cafe-da-manha"
                ,"Cafe completo reforcado", LocalTime.of(6,0,0),LocalTime.of(10,0,0)
                ,30.00,true),"Refeição cadastrada com sucesso");
    }
    @Test
    void administradorDisponibilizaRefeicao(){
        try {
            driver.disponibilizarRefeicao("ADM1", "Cafe-da-manha"
                    , "Cafe completo reforcado", LocalTime.of(6, 0, 0)
                    , LocalTime.of(10, 0, 0), 30.00, true);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não tem permissão para disponibilizar refeição");
        }
    }
    @Test
    void funcionarioDisponibilizaRefeicao() {
        driver.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        assertEquals(driver.disponibilizarRefeicao("FUN2", "Cafe-da-manha"
                , "Cafe completo reforcado", LocalTime.of(6, 0, 0)
                , LocalTime.of(10, 0, 0)
                , 30.00, true),"Refeição cadastrada com sucesso");
    }
    @Test
    void clienteDisponibilizaRefeicao(){
        driver.cadastrarUsuario("ADM1","Gabriel","CLI",157);
        try {
            driver.disponibilizarRefeicao("CLI2", "Cafe-da-manha"
                    , "Cafe completo reforcado", LocalTime.of(6, 0, 0)
                    , LocalTime.of(10, 0, 0), 30.00, true);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não tem permissão para disponibilizar refeição");
        }
    }
    @Test
    void disponibilizaRefeicaoComMesmoTitulo(){
        driver.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        driver.disponibilizarRefeicao("FUN2", "Cafe-da-manha"
                , "Cafe completo reforcado", LocalTime.of(6, 0, 0)
                , LocalTime.of(10, 0, 0)
                , 30.00, true);
        try {
            driver.disponibilizarRefeicao("FUN2"
                    , "Jantar", "Cafe completo reforcado", LocalTime.of(10, 0, 0)
                    , LocalTime.of(20, 0, 0), 45.00, true);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Título de refeição já existe");
        }
    }
    @Test
    void disponibilizaJantar(){
        driver.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        assertEquals(driver.disponibilizarRefeicao("FUN2", "Jantar"
                , "Cafe completo reforcado", LocalTime.of(6, 0, 0)
                , LocalTime.of(10, 0, 0)
                , 30.00, true),"Refeição cadastrada com sucesso");
    }
    @Test
    void disponibilizaAlmoco(){
        driver.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        assertEquals(driver.disponibilizarRefeicao("FUN2", "Almoco"
                , "Cafe completo reforcado", LocalTime.of(6, 0, 0)
                , LocalTime.of(10, 0, 0)
                , 30.00, true),"Refeição cadastrada com sucesso");

    }
    @Test
    void disponibilizaRefeicaoTipoInvalido(){
        driver.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        try {
            driver.disponibilizarRefeicao("FUN2", "Sobremesa"
                    , "Cafe completo reforcado", LocalTime.of(6, 0, 0)
                    , LocalTime.of(10, 0, 0), 30.00, true);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Tipo de refeição inválido");
        }


    }
    @Test
    void disponibilizaRefeicaoHorarioInicioPosteriorHorarioFinal(){
        driver.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        try {
            driver.disponibilizarRefeicao("FUN2", "Cafe-da-manha"
                    , "Cafe completo reforcado", LocalTime.of(12, 0, 0)
                    , LocalTime.of(10, 0, 0), 30.00, true);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Horário de início não pode ser posterior ao horário final");
        }
    }
    @Test
    void atualizarRefeicao(){
        driver.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        driver.disponibilizarRefeicao("FUN2", "Cafe-da-manha"
                , "Cafe completo reforcado", LocalTime.of(6, 0, 0)
                , LocalTime.of(10, 0, 0), 30.00, true);

        driver.alterarRefeicao(1L,LocalTime.of(9,45,0),LocalTime.of(13,0,0)
                ,38.99,false);

        assertEquals(driver.refeicaoController.getMapaRefeicao().get(1L).getHorarioInicio(),LocalTime.of(9,45,0));
        assertEquals(driver.refeicaoController.getMapaRefeicao().get(1L).getHorarioFinal(),LocalTime.of(13,0,0));
        assertEquals(driver.refeicaoController.getMapaRefeicao().get(1L).getValorRefeicao(),38.99);
        assertFalse(driver.refeicaoController.getMapaRefeicao().get(1L).getDisponivel());
    }
    @Test
    void exibirRefeicao(){
        driver.cadastrarUsuario("ADM1","Gabriel","FUN",157);

        driver.disponibilizarRefeicao("FUN2", "Cafe-da-manha"
                , "Cafe completo reforcado", LocalTime.of(6, 0, 0)
                , LocalTime.of(10, 0, 0), 30.00, true);

        assertEquals(driver.exibirRefeicao(1L)
                ,"[1] Cafe-da-manha: Cafe completo reforcado (06h00 as 10h00). Valor por pessoa: R$30,00. VIGENTE.");
    }
    @Test
    void listarRefeicao(){
        driver.cadastrarUsuario("ADM1","Gabriel","FUN",157);

        ArrayList<String> list = new ArrayList<>();

        list.add("[1] Cafe-da-manha: Cafe completo reforcado (06h00 as 10h00). Valor por pessoa: R$30,00. VIGENTE.");
        list.add("[2] Jantar: Jantar a dois (18h00 as 20h00). Valor por pessoa: R$80,00. INDISPONIVEL.");

        driver.disponibilizarRefeicao("FUN2", "Cafe-da-manha"
                , "Cafe completo reforcado", LocalTime.of(6, 0, 0)
                , LocalTime.of(10, 0, 0), 30.00, true);

        driver.disponibilizarRefeicao("FUN2", "Jantar"
                , "Jantar a dois", LocalTime.of(18, 0, 0)
                , LocalTime.of(20, 0, 0), 80.00, false);
        assertEquals(driver.listarRefeicoes(),list);
    }
    @Test
    void disponibilizarPagamentoCartao(){
        driver.disponibilizarFormaDePagamento("ADM1","Cartao",0);
        assertEquals(driver.pagamentoController.getMapaPagamentos().get(1).getFormaPagamento(),"Cartao");
        assertEquals(driver.pagamentoController.getMapaPagamentos().get(1).getIdPagamento(),1);
        assertEquals(driver.pagamentoController.getMapaPagamentos().get(1).getPercentualDesconto(),0);
    }
    @Test
    void disponibilizarPagamentoPIX(){
        driver.disponibilizarFormaDePagamento("ADM1","PIX",5);
        assertEquals(driver.pagamentoController.getMapaPagamentos().get(1).getFormaPagamento(),"PIX");
        assertEquals(driver.pagamentoController.getMapaPagamentos().get(1).getIdPagamento(),1);
        assertEquals(driver.pagamentoController.getMapaPagamentos().get(1).getPercentualDesconto(),5);
    }
    @Test
    void disponibilizarPagamentoDinheiro(){
        driver.disponibilizarFormaDePagamento("ADM1","Dinheiro",10);
        assertEquals(driver.pagamentoController.getMapaPagamentos().get(1).getFormaPagamento(),"Dinheiro");
        assertEquals(driver.pagamentoController.getMapaPagamentos().get(1).getIdPagamento(),1);
        assertEquals(driver.pagamentoController.getMapaPagamentos().get(1).getPercentualDesconto(),10);
    }
    @Test
    void disponibilizarPagamentoMesmoTipo(){
        driver.disponibilizarFormaDePagamento("ADM1","Dinheiro",10);
        try {
            driver.disponibilizarFormaDePagamento("ADM1", "Dinheiro", 15);
            fail("Não podem existir dois tipos iguais de pagamento");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Tipo de pagamento já está cadastrado");
        }
    }
    @Test
    void disponibilizarPagamentoTipoInvalido(){
        try {
            driver.disponibilizarFormaDePagamento("ADM1", "Pedras", 10);
            fail("Tipo de pagamento era pra ser inválido");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Forma de pagamento inválida");
        }
    }
    @Test
    void disponibilizarPagamentoUsuarioInvalido(){
        driver.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        try{
            driver.disponibilizarFormaDePagamento("FUN2","Dinheiro",10);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuario não pode disponibilizar pagamento");
        }
    }
    @Test
    void atualizarPagamento(){
        driver.disponibilizarFormaDePagamento("ADM1","PIX",5);
        driver.alterarFormaDePagamento("ADM1",1,"PIX",8);
        assertEquals(driver.pagamentoController.getMapaPagamentos().get(1).getPercentualDesconto(),8);
    }
    @Test
    void atualizarPagamentoUsuarioInvalido(){
        driver.cadastrarUsuario("ADM1","Gabriel","FUN",157);
        try{
            driver.alterarFormaDePagamento("FUN2",1,"PIX",8);
            fail("Funcionário não pode alterar forma de pagamento");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Usuário não tem permissão para atualizar o pagamento");
        }
    }
    @Test
    void atualizarPagamentoFormaDePagamentoJaExiste(){
        driver.disponibilizarFormaDePagamento("ADM1","PIX",5);
        driver.disponibilizarFormaDePagamento("ADM1","Dinheiro",10);
        try {
            driver.alterarFormaDePagamento("ADM1",2,"PIX",10);
            fail("Não pode se repetir a mesma forma de pagamento");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"Forma de pagamento já existe");
        }
    }
    @Test
    void exibirPagamento(){
        driver.disponibilizarFormaDePagamento("ADM1","PIX",5);
        assertEquals(driver.exibirFormaPagamento(1)
                ,"[1] Forma de pagamento: PIX (5% de desconto em pagamentos)");
    }
    @Test
    void listarPagamentos(){
        driver.disponibilizarFormaDePagamento("ADM1","PIX",5);
        driver.disponibilizarFormaDePagamento("ADM1","Cartao",0);

        ArrayList<String> list = new ArrayList<>();
        list.add("[1] Forma de pagamento: PIX (5% de desconto em pagamentos)");
        list.add("[2] Forma de pagamento: Cartao (0% de desconto em pagamentos)");
        assertEquals(list, driver.listarFormasPagamentos());
    }
    @Test
    void clienteCancelaReserva(){
        driver.cadastrarUsuario("ADM1","Gabriel","CLI",157);
        //hotelCaliforniaSistema.cancelarReserva("CLI2",)
    }*/
}
