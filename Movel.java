//Victor Hugo Concolato Neves - 2576139

public abstract class Movel implements Exibivel{

    private int id;
    private int quantidadeEstoque;
    private Valor valor;
    private String nome;

    public Movel() {
        id=0;
        quantidadeEstoque=0;
        valor=new Valor();
        nome="";
    }

    //Sobrecarga
    public Movel(int id, int quantidadeEstoque, Valor valor, String nome) {
        this.id = id;
        this.quantidadeEstoque = quantidadeEstoque;
        this.valor = valor;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws ValorNumericoInvalidoException {
        if(id >= 0){
            this.id = id;
        }else{
            ValorNumericoInvalidoException ex = new ValorNumericoInvalidoException();
            ex.setMensagem("O id do movel deve ser maior ou igual a zero.");
            throw ex;
        }
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) throws ValorNumericoInvalidoException {
        if(quantidadeEstoque >= 0){
            this.quantidadeEstoque = quantidadeEstoque;
        }else{
            ValorNumericoInvalidoException ex = new ValorNumericoInvalidoException();
            ex.setMensagem("A quantidade de estoque deve ser maior ou igual a zero.");
            throw ex;
        }
    }

    public Valor getValor() {
        return valor;
    }
    
    public void setValor(Valor valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //Sobrescrita
    public String exibirInformacoes(){
        String infoValor = (valor != null) ? valor.exibirInformacoes() : "Valores não definidos";
        return "ID: " + id + "\nNome: " + nome + "\nEstoque atual: " + quantidadeEstoque + "\n" + infoValor;
    }
}