//Victor Hugo Concolato Neves - 2576139

import java.util.ArrayList;
import java.util.List;

public class BdPessoa {
    private List<Pessoa> bdPessoa;

    //Inicio MÉTODO SINGLETON
    private static BdPessoa pessoaInstance;
    
    private BdPessoa(){
        bdPessoa = new ArrayList<>();
        
        //popular
        cadPessoa(new Cliente (11111111, "Alice Silva", "11999990001", "alice@mail.com"));
        cadPessoa(new Cliente (22222222, "Bruno Costa", "11999990002", "bruno@mail.com"));
        cadPessoa(new Cliente (33333333, "Carla Souza", "11999990003", "carla@mail.com"));
        cadPessoa(new Cliente (44444444, "Daniel Rocha", "11999990004", "daniel@mail.com"));
        cadPessoa(new Cliente (55555555, "Eduardo Lima", "11999990005", "eduardo@mail.com"));
        cadPessoa(new Vendedor(66666666, "Fernanda Melo", 2500.00, 0));
        cadPessoa(new Vendedor(77777777, "Gabriel Alves", 2700.00, 0));
        cadPessoa(new Vendedor(88888888, "Helena Pinto", 2600.00, 0));
        cadPessoa(new Vendedor(99999999, "Igor Mendes", 2800.00, 0));
        cadPessoa(new Vendedor(12233445, "Juliana Freitas", 3000.00, 0));
    }
        
    public static BdPessoa getInstance(){
        if(pessoaInstance==null){
            pessoaInstance = new BdPessoa();
        }
        return pessoaInstance;
    }
    //Fim MÉTODO SINGLETON

    //Sobrecarga
    private BdPessoa(List<Pessoa> bdPessoa) {
        this.bdPessoa = bdPessoa;
    }
    
    public List<Pessoa> getBdPessoa() {
        return bdPessoa;
    }
    
    public Pessoa cadPessoa(Pessoa pessoa){
        if(pessoa!=null){
            if(getPessoa(pessoa.getId())==null){
                bdPessoa.add(pessoa);
                return pessoa;
            }else{
                throw new IllegalArgumentException("Pessoa já cadastrada com este ID.");
            }
        }else{
            throw new NullPointerException("Não é possível cadastrar uma pessoa nula.");
        }
    }
    
    public Pessoa getPessoa(int id){
        for(int i = 0; i<bdPessoa.size();i++){
            //Reflexividade
            if(bdPessoa.get(i).getId()==id){
                return bdPessoa.get(i);
            }
        }
        return null;
    }
    
    public Pessoa attPessoa(Pessoa pessoa){
        if(pessoa != null){
            if(getPessoa(pessoa.getId())!=null){
                    rmvPessoa(pessoa.getId());
                    cadPessoa(pessoa);
                    return pessoa;
                }else{
                throw new NullPointerException("A pessoa com o ID informado não existe.");
            }
        }
        throw new NullPointerException("Não é possível atualizar uma pessoa com outra pessoa nula.");
    }

    public Pessoa rmvPessoa(int id){
        Pessoa pessoaRemover = getPessoa(id);
        if(pessoaRemover!=null){
            bdPessoa.remove(pessoaRemover);
        }else{
            throw new NullPointerException("Não é possível remover a pessoa porque não há pessoa cadastrada com esse ID.");
        }
        return pessoaRemover;
    }
}
