//Victor Hugo Concolato Neves - 2576139

public class ItemVenda implements Exibivel{
    private int quantidade;
    private Movel movel;

    
    public ItemVenda() {
        quantidade = -1;
        movel = null;
    }
    
    //Sobrecarga
    public ItemVenda(int quantidade, Movel movel) {
        this.quantidade = quantidade;
        this.movel = movel;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws EstoqueInsuficienteException {
        if(quantidade <= movel.getQuantidadeEstoque()){
            this.quantidade = quantidade;
        }else{
            throw new EstoqueInsuficienteException();
        }
    }

    public Movel getMovel() {
        return movel;
    }

    public void setMovel(Movel movel) {
        this.movel = movel;
    }

    public double calcularValorTotal() {
        if (movel != null) {
            return quantidade * movel.getValor().getValorVenda();
        }
        return 0;
    }

    public double calcularLucroTotal() {
        if (movel != null) {
            return quantidade * movel.getValor().getLucro();
        }
        return 0;
    }

    public void baixaEstoque() throws ValorNumericoInvalidoException {
        movel.setQuantidadeEstoque(movel.getQuantidadeEstoque() - quantidade);
    }

    //Sobrescrita
    public String exibirInformacoes() {
        return  "Movel: " + movel.exibirInformacoes() + "\nQuantidade: " + quantidade;
    }
}
