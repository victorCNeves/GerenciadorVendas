//Victor Hugo Concolato Neves - 2576139

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BdVenda {
    private List<Venda> bdVenda;
    
    //Inicio MÉTODO SINGLETON
    private static BdVenda vendaInstance;
    
    private BdVenda(){
        bdVenda = new ArrayList<>();
        
        //popular
        // --- Cadastro de Vendas Manual ---
        List<ItemVenda> itens;

        BdMovel bdMovel = BdMovel.getInstance();
        BdPessoa bdPessoa = BdPessoa.getInstance();
        

        // Venda 1
        itens = new ArrayList<>();
        itens.add(new ItemVenda(2, bdMovel.getMovel(1)));
        cadVenda(new Venda(1, 2, bdMovel.getMovel(1).getValor().getValorVenda(), LocalDate.now().minusDays(9), 
                (Cliente) bdPessoa.getPessoa(11111111), (Vendedor) bdPessoa.getPessoa(66666666), bdMovel.getMovel(1), itens));

        // Venda 2
        itens = new ArrayList<>();
        itens.add(new ItemVenda(1, bdMovel.getMovel(2)));
        cadVenda(new Venda(2, 1, bdMovel.getMovel(2).getValor().getValorVenda(), LocalDate.now().minusDays(8), 
                (Cliente) bdPessoa.getPessoa(22222222), (Vendedor) bdPessoa.getPessoa(77777777), bdMovel.getMovel(2), itens));

        // Venda 3
        itens = new ArrayList<>();
        itens.add(new ItemVenda(3, bdMovel.getMovel(3)));
        cadVenda(new Venda(3, 3, bdMovel.getMovel(3).getValor().getValorVenda(), LocalDate.now().minusDays(7), 
                (Cliente) bdPessoa.getPessoa(33333333), (Vendedor) bdPessoa.getPessoa(88888888), bdMovel.getMovel(3), itens));

        // Venda 4
        itens = new ArrayList<>();
        itens.add(new ItemVenda(1, bdMovel.getMovel(4)));
        cadVenda(new Venda(4, 1, bdMovel.getMovel(4).getValor().getValorVenda(), LocalDate.now().minusDays(6), 
                (Cliente) bdPessoa.getPessoa(44444444), (Vendedor) bdPessoa.getPessoa(99999999), bdMovel.getMovel(4), itens));

        // Venda 5
        itens = new ArrayList<>();
        itens.add(new ItemVenda(4, bdMovel.getMovel(5)));
        cadVenda(new Venda(5, 4, bdMovel.getMovel(5).getValor().getValorVenda(), LocalDate.now().minusDays(5), 
                (Cliente) bdPessoa.getPessoa(55555555), (Vendedor) bdPessoa.getPessoa(12233445), bdMovel.getMovel(5), itens));

        // Venda 6
        itens = new ArrayList<>();
        itens.add(new ItemVenda(2, bdMovel.getMovel(6)));
        cadVenda(new Venda(6, 2, bdMovel.getMovel(6).getValor().getValorVenda(), LocalDate.now().minusDays(4), 
                (Cliente) bdPessoa.getPessoa(11111111), (Vendedor) bdPessoa.getPessoa(66666666), bdMovel.getMovel(6), itens));

        // Venda 7
        itens = new ArrayList<>();
        itens.add(new ItemVenda(1, bdMovel.getMovel(7)));
        cadVenda(new Venda(7, 1, bdMovel.getMovel(7).getValor().getValorVenda(), LocalDate.now().minusDays(3), 
                (Cliente) bdPessoa.getPessoa(22222222), (Vendedor) bdPessoa.getPessoa(77777777), bdMovel.getMovel(7), itens));

        // Venda 8
        itens = new ArrayList<>();
        itens.add(new ItemVenda(2, bdMovel.getMovel(8)));
        cadVenda(new Venda(8, 2, bdMovel.getMovel(8).getValor().getValorVenda(), LocalDate.now().minusDays(2), 
                (Cliente) bdPessoa.getPessoa(33333333), (Vendedor) bdPessoa.getPessoa(88888888), bdMovel.getMovel(8), itens));

        // Venda 9
        itens = new ArrayList<>();
        itens.add(new ItemVenda(3, bdMovel.getMovel(9)));
        cadVenda(new Venda(9, 3, bdMovel.getMovel(9).getValor().getValorVenda(), LocalDate.now().minusDays(1), 
                (Cliente) bdPessoa.getPessoa(44444444), (Vendedor) bdPessoa.getPessoa(99999999), bdMovel.getMovel(9), itens));

        // Venda 10
        itens = new ArrayList<>();
        itens.add(new ItemVenda(1, bdMovel.getMovel(10)));
        cadVenda(new Venda(10, 1, bdMovel.getMovel(10).getValor().getValorVenda(), LocalDate.now(), 
                (Cliente) bdPessoa.getPessoa(55555555), (Vendedor) bdPessoa.getPessoa(12233445), bdMovel.getMovel(10), itens));
    }
    
    public static BdVenda getInstance(){
        if(vendaInstance==null){
            vendaInstance = new BdVenda();
        }
        return vendaInstance;
    }
    //Fim MÉTODO SINGLETON
    
    //Sobrecarga
    private BdVenda(List<Venda> bdVenda) {
        this.bdVenda = bdVenda;
    }
    
    public List<Venda> getBdVenda() {
        return bdVenda;
    }
    
    public Venda cadVenda(Venda venda){
        if(venda!=null){
            if(getVenda(venda.getId())==null){
                bdVenda.add(venda);
                return venda;
            }else{
                throw new IllegalArgumentException("Venda já cadastrada com este ID.");
            }
        }else{
            throw new NullPointerException("Não é possível cadastrar uma venda nula.");
        }
    }
    
    public Venda getVenda(int id){
        for(int i = 0; i<bdVenda.size();i++){
            //Reflexividade
            if(bdVenda.get(i).getId()==id){
                return bdVenda.get(i);
            }
        }
        return null;
    }
    
    public Venda attVenda(Venda venda) throws ValorNumericoInvalidoException{
        if(venda != null){
            if(getVenda(venda.getId())!=null){
                rmvVenda(venda.getId());
                cadVenda(venda);
                return venda;                
            }else{
                throw new NullPointerException("A venda com o ID informado não existe.");
            }
        }
        throw new NullPointerException("Não é possível atualizar uma venda com outra venda nula.");
    }

    public Venda rmvVenda(int id) throws ValorNumericoInvalidoException{
        Venda vendaRemover = getVenda(id);
        if(vendaRemover!=null){
            for (ItemVenda itemVenda : vendaRemover.getItensVenda()) {
                //Reflexividade
                itemVenda.getMovel().setQuantidadeEstoque(itemVenda.getMovel().getQuantidadeEstoque()+itemVenda.getQuantidade());
            }
            bdVenda.remove(vendaRemover);
        }else{
            throw new NullPointerException("Não é possível remover a venda porque não há venda cadastrada com esse ID.");
        }
        return vendaRemover;
    }
}
