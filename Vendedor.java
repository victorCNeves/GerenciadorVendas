//Victor Hugo Concolato Neves - 2576139

public class Vendedor extends Pessoa{

    private double salario;
    private int quantidadeVendas;

    public Vendedor() {
        super();
        salario=0;
        quantidadeVendas=0;
    }

    //Sobrecarga
    public Vendedor(int id, String nome, double salario, int quantidadeVendas) {
        super(id, nome);
        this.salario = salario;
        this.quantidadeVendas = quantidadeVendas;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) throws ValorNumericoInvalidoException {
        if (salario>=1518) {
            this.salario = salario;
        }else{
            ValorNumericoInvalidoException ex = new ValorNumericoInvalidoException();
            ex.setMensagem("O salário não pode ser menor que R$ 1518,00.");
            throw ex;
        }

    }

    public int getQuantidadeVendas() {
        return quantidadeVendas;
    }

    public void setQuantidadeVendas(int quantidadeVendas) throws ValorNumericoInvalidoException {
        if(quantidadeVendas >= 0){
            this.quantidadeVendas = quantidadeVendas;
        }else{
            ValorNumericoInvalidoException ex = new ValorNumericoInvalidoException();
            ex.setMensagem("A quantidade de lugares deve ser maior ou igual a zero.");
            throw ex;
        }
    }

    public void addVenda(){
        quantidadeVendas++;
    }

    //Sobrescrita
    public String exibirInformacoes(){
        return super.exibirInformacoes() + "\nSalário: " + salario + "\nQuantidade de vendas: " + quantidadeVendas;
    }
}
