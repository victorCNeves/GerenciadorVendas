//Victor Hugo Concolato Neves - 2576139

import java.util.ArrayList;
import java.util.List;

public class BdMovel {
    private List<Movel> bdMovel;    
    
    //Inicio MÉTODO SINGLETON
    private static BdMovel movelInstance;
    
    private BdMovel(){
        bdMovel = new ArrayList<>();
        
        //popular
        cadMovel(new Geladeira(1, 10, new Valor(500.0, 800.0), "Geladeira Frost Free", 300, true));
        cadMovel(new Geladeira(2, 5, new Valor(450.0, 700.0), "Geladeira Duplex", 250, false));
        cadMovel(new GuardaRoupa(3, 7, new Valor(350.0, 550.0), "Guarda-Roupa 2 Portas", 2, true));
        cadMovel(new GuardaRoupa(4, 3, new Valor(400.0, 620.0), "Guarda-Roupa 3 Portas", 3, false));
        cadMovel(new Mesa(5, 8, new Valor(150.0, 280.0), "Mesa Jantar 6 Lugares", 6, "Retangular"));
        cadMovel(new Mesa(6, 4, new Valor(120.0, 220.0), "Mesa Centro", 0, "Oval"));
        cadMovel(new Mesa(7, 6, new Valor(200.0, 350.0), "Mesa Escritório", 4, "Quadrada"));
        cadMovel(new GuardaRoupa(8, 2, new Valor(500.0, 900.0), "Roupeiro 4 Portas", 4, true));
        cadMovel(new Geladeira(9, 4, new Valor(600.0, 950.0), "Side by Side", 400, true));
        cadMovel(new Mesa(10, 5, new Valor(100.0, 180.0), "Mesa Café", 2, "Redonda"));
    }
    
    
    public static BdMovel getInstance(){
        if(movelInstance==null){
            movelInstance = new BdMovel();
        }
        return movelInstance;
    }
    //Fim MÉTODO SINGLETON
    
    //Sobrecarga
    private BdMovel(List<Movel> bdMovel) {
        this.bdMovel = bdMovel;
    }
    
    public List<Movel> getBdMovel() {
        return bdMovel;
    }
    
    public Movel cadMovel(Movel movel){
        if(movel!=null){
            if(getMovel(movel.getId())==null){
                bdMovel.add(movel);
                return movel;
            }else{
                throw new IllegalArgumentException("Móvel já cadastrado com este ID.");
            }
        }else{
            throw new NullPointerException("Não é possível cadastrar um móvel nulo.");
        }
    }
    
    public Movel getMovel(int id){
        for(int i = 0; i<bdMovel.size();i++){
            //Reflexividade
            if(bdMovel.get(i).getId()==id){
                return bdMovel.get(i);
            }
        }
        return null;
    }
    
    public Movel attMovel(Movel movel){
        if(movel != null){        
            if(getMovel(movel.getId())!=null){
                rmvMovel(movel.getId());
                cadMovel(movel);
                return movel;
            }else{
                throw new NullPointerException("O móvel com o ID informado não existe.");
            }
        }
        throw new NullPointerException("Não é possível atualizar um móvel com outro móvel nulo.");
    }

    public Movel rmvMovel(int id){
        Movel movelRemover = getMovel(id);
        if(movelRemover!=null){
            bdMovel.remove(movelRemover);
        }else{
            throw new NullPointerException("Não é possível remover o móvel porque não há móvel cadastrado com esse ID.");
        }
        return movelRemover;
    }
}
