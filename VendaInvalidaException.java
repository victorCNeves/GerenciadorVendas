//Victor Hugo Concolato Neves - 2576139

public class VendaInvalidaException extends Exception{
    private String mensagem;

    public VendaInvalidaException(){
        mensagem = "Venda inválida, é necessário preencher todos os campos.";
    }
    
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String impErro() {
        return mensagem;
    }
}
