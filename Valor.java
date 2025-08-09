//Victor Hugo Concolato Neves - 2576139

public class Valor implements Exibivel{
    private double valorCusto;
    private double valorVenda;

    
    public Valor(){
        valorCusto = 0;
        valorVenda = 0;
    }
    
    //Sobrecarga
    public Valor(double valorCusto, double valorVenda){
        this.valorCusto = valorCusto;
        this.valorVenda = valorVenda;
    }
    
    public double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(double valorCusto) throws ValorNumericoInvalidoException {
        if(valorCusto>=0){
            this.valorCusto = valorCusto;
        }else{
            ValorNumericoInvalidoException ex = new ValorNumericoInvalidoException();
            ex.setMensagem("O valor de custo não pode ser negativo.");
            throw ex;
        }
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) throws ValorNumericoInvalidoException {
        if(valorVenda>=0){
            this.valorVenda = valorVenda;
        }else{
            ValorNumericoInvalidoException ex = new ValorNumericoInvalidoException();
            ex.setMensagem("O valor de venda não pode ser negativo.");
            throw ex;
        }
    }

    public double getLucro(){
        return valorVenda - valorCusto;
    }

    //Sobrescrita
    public String exibirInformacoes() {
        return String.format("Valor Custo: %.2f\nValor Venda: %.2f\nLucro: %.2f", valorCusto, valorVenda, getLucro());
    }
}
