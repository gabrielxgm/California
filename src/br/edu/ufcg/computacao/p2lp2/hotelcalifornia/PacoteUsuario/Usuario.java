package br.edu.ufcg.computacao.p2lp2.hotelcalifornia.PacoteUsuario;

/**
 * Classe de um usuário
 */
public class Usuario{
    /**
     * Identificador sequencial do usuario(EX:1,2,3)
     */
    private int idUsuario;
    /**
     * Nome do usuário
     */
    private String nomeUsuario;
    /**
     * Tipo do usuário(EX:CLI,ADM)
     */
    private String tipoUsuario;
    /**
     * Documento do usuário
     */
    private long documento;
    /**
     * Função do usuário
     */
    private FuncaoUsuario funcaoUsuario;

    /**
     * Cria um usuário a partir de seu id,nome,tipo e documento
     * @param idUsuario identificador sequencial do usuário
     * @param nomeUsuario nome do usuário
     * @param tipoUsuario tipo do usuário
     * @param documento documento do usuário
     */
    public Usuario(int idUsuario,String nomeUsuario,String tipoUsuario,long documento){
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.tipoUsuario = tipoUsuario;
        this.documento = documento;
    }

    /**
     * Acessa os dados do tipo do usuário
     * @return tipo do usuário
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * Acessa os dados do nome do usuário
     * @return nome do usuário
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * Acessa os dados do documento do usuário
     * @return documento do usuário
     */
    public long getDocumento() {
        return documento;
    }

    /**
     * Acessa os dados do id do usuário
     * @return id do usuário
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Acessa os dados da função do usuário
     * @return função do usuário
     */
    public FuncaoUsuario getFuncaoUsuario() {
        return funcaoUsuario;
    }

    /**
     * Altera a função do usuário
     * @param funcaoUsuario nova função do usuário
     */
    public void setFuncaoUsuario(String funcaoUsuario) {
        switch (funcaoUsuario) {
            case "ADM" -> this.funcaoUsuario = new Administrador();
            case "CLI" -> this.funcaoUsuario = new Cliente();
            case "GER" -> this.funcaoUsuario = new Gerente();
            case "FUN" -> this.funcaoUsuario = new Funcionario();
            default -> throw new IllegalArgumentException("Função de usuário inválida");
        }
    }

    /**
     * Cria uma representação textual de um usuário
     * @return representação textual de um usuário
     */
    @Override
    public String toString(){
        return "["+tipoUsuario+idUsuario+"] "+nomeUsuario+" (No. Doc. "+documento+")";
    }
}
