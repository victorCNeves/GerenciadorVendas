//Victor Hugo Concolato Neves - 2576139

public class ValorNumericoInvalidoException extends Exception{

    private String mensagem;

    public ValorNumericoInvalidoException(){
        mensagem = "O valor numérico é inválido";
    }
    
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String impErro() {
        return mensagem;
    }
     
}
