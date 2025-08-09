//Victor Hugo Concolato Neves - 2576139

public class Cliente extends Pessoa{

    private String telefone;
    private String email;

    public Cliente() {
        super();
        telefone="";
        email="";
    }

    //Sobrecarga
    public Cliente(int id, String nome, String telefone, String email) {
        super(id, nome);
        this.telefone = telefone;
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Sobrescrita
    public String exibirInformacoes() {
        return super.exibirInformacoes() + "\nTelefone: " + telefone + "\nEmail: " + email;
    }
}
