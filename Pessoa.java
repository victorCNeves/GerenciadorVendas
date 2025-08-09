//Victor Hugo Concolato Neves - 2576139

public abstract class Pessoa implements Exibivel{

    private int id;
    private String nome;

    public Pessoa() {
        id = 0;
        nome = "";
    }

    //Sobrecarga
    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws ValorNumericoInvalidoException {
        if (id >= 0) {
            this.id = id;
        }else{
            ValorNumericoInvalidoException ex = new ValorNumericoInvalidoException();
            ex.setMensagem("O ID deve ser maior ou igual a zero.");
            throw ex;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //Sobrescrita
    public String exibirInformacoes(){
        return "ID: " + id + "\nNome: " + nome;
    }
}
