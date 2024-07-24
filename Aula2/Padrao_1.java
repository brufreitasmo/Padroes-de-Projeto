package Aula2;

import java.util.HashMap;
import java.util.Map;


public class Padrao_1 {
    public static void main(String[] args) {
        Arvore carvalhoVerde = FabricaDeArvores.obterArvore("Carvalho", "Verde");
        carvalhoVerde.plantar(10, 20);

        Arvore pinheiroVerde = FabricaDeArvores.obterArvore("Pinheiro", "Verde");
        pinheiroVerde.plantar(30, 40);

        Arvore carvalhoVerde2 = FabricaDeArvores.obterArvore("Carvalho", "Verde");
        carvalhoVerde2.plantar(50, 60);

    }
}



//----------------------------------------------------



interface Arvore {
    void plantar(int x, int y);
}


//----------------------------------------------------



class ArvoreConcreta implements Arvore {
    private String tipo;
    private String cor;

    public ArvoreConcreta(String tipo, String cor) {
        this.tipo = tipo;
        this.cor = cor;
    }

    @Override
    public void plantar(int x, int y) {
        System.out.println("Plantando uma árvore do tipo " + tipo + " e cor " + cor + " em (" + x + ", " + y + ")");
    }

}


//----------------------------------------------------



class FabricaDeArvores {
    private static final Map<String, Arvore> arvores = new HashMap<>();

    public static Arvore obterArvore(String tipo, String cor) {
        String chave = tipo + "-" + cor;
        Arvore arvore = arvores.get(chave);
        if (arvore == null) {
            arvore = new ArvoreConcreta(tipo, cor);
            arvores.put(chave, arvore);
            System.out.println("Criando uma árvore do tipo: " + tipo + " e cor: " + cor);
        }
        return arvore;
    }
}


