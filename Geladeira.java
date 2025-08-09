//Victor Hugo Concolato Neves - 2576139

public class Geladeira extends Movel{

    private int capacidadeLitros;
    private boolean freezer;

    public Geladeira() {
        super();
        capacidadeLitros=0;
        freezer=false;
    }

    //Sobrecarga
    public Geladeira(int id, int quantidadeEstoque, Valor valor, String nome, int capacidadeLitros, boolean freezer) {
        super(id, quantidadeEstoque, valor, nome);
        this.capacidadeLitros = capacidadeLitros;
        this.freezer = freezer;
    }

    public int getCapacidadeLitros() {
        return capacidadeLitros;
    }

    public void setCapacidadeLitros(int capacidadeLitros) throws ValorNumericoInvalidoException {
        if(capacidadeLitros >= 0){
            this.capacidadeLitros = capacidadeLitros;
        }else{
            ValorNumericoInvalidoException ex = new ValorNumericoInvalidoException();
            ex.setMensagem("A capacidade de litros deve ser maior ou igual a zero.");
            throw ex;
        }
    }

    public boolean isFreezer() {
        return freezer;
    }

    public void setFreezer(boolean freezer) {
        this.freezer = freezer;
    }

    //Sobrescrita
    public String exibirInformacoes(){
        return super.exibirInformacoes() + "\nCapacidade de litros: " + capacidadeLitros + "\nFreezer: " + (freezer ? "Sim" : "Nao");
    }
}
