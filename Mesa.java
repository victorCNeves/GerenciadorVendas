//Victor Hugo Concolato Neves - 2576139

public class Mesa extends Movel{

    private int quantidadeLugares;
    private String formato;

    public Mesa() {
        super();
        quantidadeLugares=0;
        formato="";
    }

    //Sobrecarga
    public Mesa(int id, int quantidadeEstoque, Valor valor, String nome, int quantidadeLugares, String formato) {
        super(id, quantidadeEstoque, valor, nome);
        this.quantidadeLugares = quantidadeLugares;
        this.formato = formato;
    }

    public int getQuantidadeLugares() {
        return quantidadeLugares;
    }

    public void setQuantidadeLugares(int quantidadeLugares) throws ValorNumericoInvalidoException {
        if(quantidadeLugares >= 0){
            this.quantidadeLugares = quantidadeLugares;
        }else{
            ValorNumericoInvalidoException ex = new ValorNumericoInvalidoException();
            ex.setMensagem("A quantidade de lugares deve ser maior ou igual a zero.");
            throw ex;
        }
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    //Sobrescrita
    public String exibirInformacoes(){
        return super.exibirInformacoes() + "\nQuantidade de lugares: " + quantidadeLugares + "\nFormato: " + formato;
    }
}
