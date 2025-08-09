//Victor Hugo Concolato Neves - 2576139

public class GuardaRoupa extends Movel{

    private int quantidadePortas;
    private boolean espelho;

    public GuardaRoupa() {
        super();
        quantidadePortas=0;
        espelho=false;
    }

    //Sobrecarga
    public GuardaRoupa(int id, int quantidadeEstoque, Valor valor, String nome, int quantidadePortas, boolean espelho) {
        super(id, quantidadeEstoque, valor, nome);
        this.quantidadePortas = quantidadePortas;
        this.espelho = espelho;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) throws ValorNumericoInvalidoException {
        if(quantidadePortas >= 0){
            this.quantidadePortas = quantidadePortas;
        }else{
            ValorNumericoInvalidoException ex = new ValorNumericoInvalidoException();
            ex.setMensagem("A quantidade de portas deve ser maior ou igual a zero.");
            throw ex;
        }
    }

    public boolean isEspelho() {
        return espelho;
    }

    public void setEspelho(boolean espelho) {
        this.espelho = espelho;
    }

    //Sobrescrita
    public String exibirInformacoes(){
        return super.exibirInformacoes() + "\nQuantidade de portas: " + quantidadePortas + "\nEspelho: " + (espelho ? "Sim" : "Nao");
    }
}