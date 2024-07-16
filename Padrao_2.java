import java.util.ArrayList;
import java.util.List;

public class Padrao_2 {

 
public static void main(String[] args) {
    Estrutura2 estrutura2 = new Estrutura2();

    estrutura2.add(new obj("obj1", 10));
    estrutura2.add(new obj("obj2", 15));

    Estrutura2 estruturaSecundaria = new Estrutura2();
    estruturaSecundaria.add(new obj("obj3", 5));

    estrutura2.add(estruturaSecundaria);

    System.out.println("Custo total: " + estrutura2.getCost());
}
}
//---------------------------------------

abstract class Estrutura {
    abstract int getCost();
    void add(Estrutura product) {}
    void remove(Estrutura product) {}
}

//---------------------------------------

class obj extends Estrutura {
    private String name;
    private int cost;

    public obj(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    int getCost() {
        return this.cost;
    }
}

//---------------------------------------

class Estrutura2 extends Estrutura {
    private List<Estrutura> children = new ArrayList<>();

    @Override
    void add(Estrutura product) {
        children.add(product);
    }

    @Override
    void remove(Estrutura product) {
        children.remove(product);
    }

    @Override
    int getCost() {
        int totalCost = 0;
        for (Estrutura child : children) {
            totalCost += child.getCost();
        }
        return totalCost;
    }
}

    
