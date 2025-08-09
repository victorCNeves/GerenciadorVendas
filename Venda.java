//Victor Hugo Concolato Neves - 2576139

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Venda implements Exibivel{

    private int id;
    private boolean statusVendido;
    private LocalDate data;
    private Cliente cliente;
    private Vendedor vendedor;
    private List<ItemVenda> itensVenda;

    public Venda() {
        id = -1;
        data = null;
        cliente = new Cliente();
        vendedor = new Vendedor();
        statusVendido = false;
        itensVenda = new ArrayList<>();
    }

    //Sobrecarga
    public Venda(int id, int quantidade, double valor, LocalDate data, Cliente cliente, Vendedor vendedor, Movel movel, List<ItemVenda> itensVenda) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.statusVendido = false;
        this.itensVenda = itensVenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws ValorNumericoInvalidoException, VendaInvalidaException {
        if (!statusVendido) {
            if (id >= 0) {
                this.id = id;
            } else {
                ValorNumericoInvalidoException ex = new ValorNumericoInvalidoException();
                ex.setMensagem("O id da venda deve ser maior ou igual a zero.");
                throw ex;
            }
        } else {
            VendaInvalidaException ex = new VendaInvalidaException();
            ex.setMensagem("Não é possível alterar o id da venda depois de realizada.");
            throw ex;
        }
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }    

    public void addMovel(Movel movel, int quantidade) throws ValorNumericoInvalidoException, VendaInvalidaException, EstoqueInsuficienteException {
        if (!statusVendido) {
            if (movel!=null) {
                if(quantidade >=0){
                    for(ItemVenda item : itensVenda){
                        if(item.getMovel().getId() == movel.getId()){
                            item.setQuantidade(item.getQuantidade() + quantidade);
                            return;
                        }
                    }
                    ItemVenda itemVenda = new ItemVenda();
                    itemVenda.setMovel(movel);
                    itemVenda.setQuantidade(quantidade);
                    itensVenda.add(itemVenda);                
                }else{
                    ValorNumericoInvalidoException ex = new ValorNumericoInvalidoException();
                    ex.setMensagem("A quantidade para venda deve ser maior ou igual a zero.");
                    throw ex;
                }
            }else{
                ValorNumericoInvalidoException ex = new ValorNumericoInvalidoException();
                ex.setMensagem("Não é possível adicionar um móvel nulo à venda.");
                throw ex;
            }
        }else{
            VendaInvalidaException ex = new VendaInvalidaException();
            ex.setMensagem("Não é possível adicionar um móvel na venda depois de realizada.");
            throw ex;
        }
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) throws VendaInvalidaException {
        if (!statusVendido) {
            this.data = data;
        } else {
            VendaInvalidaException ex = new VendaInvalidaException();
            ex.setMensagem("Não é possível alterar a data da venda depois de realizada.");
            throw ex;
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) throws VendaInvalidaException {
        if (!statusVendido) {
            this.cliente = cliente;
        } else {
            VendaInvalidaException ex = new VendaInvalidaException();
            ex.setMensagem("Não é possível alterar o cliente da venda depois de realizada.");
            throw ex;
        }
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) throws VendaInvalidaException {
        if (!statusVendido) {
            this.vendedor = vendedor;
        } else {
            VendaInvalidaException ex = new VendaInvalidaException();
            ex.setMensagem("Não é possível alterar o vendedor que realizou a venda depois de realizada.");
            throw ex;
        }
    }

    public boolean isStatusVendido() {
        return statusVendido;
    }

    public void realizarVenda() throws ValorNumericoInvalidoException, VendaInvalidaException {
        if (!statusVendido) {
            //Reflexividade
            if (id != -1 && itensVenda.get(0).getQuantidade() != -1 && !data.equals("") && cliente != null && vendedor != null && itensVenda.get(0).getMovel() != null) {
                statusVendido = true;
                for (ItemVenda itemVenda : itensVenda) {
                    itemVenda.baixaEstoque();
                }
                vendedor.addVenda();
            } else {
                VendaInvalidaException ex = new VendaInvalidaException();
                ex.setMensagem("A venda não pode ser realizada porque nem todos os dados foram preenchidos.");
                throw ex;
            }
        } else {
            VendaInvalidaException ex = new VendaInvalidaException();
            ex.setMensagem("Não é possível realizar uma venda depois de já realizada.");
            throw ex;
        }
    }

    public double calcularValorTotal() {
        double total = 0;
        for(ItemVenda item : itensVenda){
            total+=item.calcularValorTotal();
        }
        return total;
    }

    public double calcularLucroTotal(){
        double total = 0;
        for(ItemVenda item : itensVenda){
            total+=item.calcularLucroTotal();
        }
        return total;
    }

    
    //Sobrescrita
    public String exibirInformacoes() {
        String itensVenda = "";
        for(ItemVenda item : this.itensVenda){
            itensVenda += item.exibirInformacoes() + String.format("\nValor total: %.2f Lucro: %.2f", item.calcularValorTotal(), item.calcularLucroTotal()) +"\n";
        }
        itensVenda += String.format("Valor total da venda: %.2f Lucro total: %.2f", calcularValorTotal(), calcularLucroTotal());
        return "ID: " + id + "\nData: " + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\nCliente: " + cliente.getNome() + " ID: " + cliente.getId() + "\nVendedor: " + vendedor.getNome() + " ID: " + vendedor.getId() + "\nItens da venda:\n" + itensVenda;
    }
}
