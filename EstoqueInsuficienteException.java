//Victor Hugo Concolato Neves - 2576139

public class EstoqueInsuficienteException extends Exception{
    private String mensagem;

    public EstoqueInsuficienteException(){
        mensagem = "A quantidade informada é maior que a quantidade em estoque.";
    }

    public String impErro() {
        return mensagem;
    }
}
