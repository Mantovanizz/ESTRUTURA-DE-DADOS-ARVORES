import java.util.LinkedList;
import java.util.Queue;

public class No {
    String valor;
    No esquerda, direita;

    public No(String valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    public class Arvore {
    No raiz;
    }

    public class contarNos {
    public int contarNos(No node) {
        return (node == null) ? 0 : 1 + contarNos(node.esquerda) + contarNos(node.direita);
        }
    }

    public class percorrerPreOrdem {
    public void percorrerPreOrdem(No node) {
        if (node != null) {
            System.out.println(node.valor);
            percorrerPreOrdem(node.esquerda);
            percorrerPreOrdem(node.direita);
            }
        }
    }

    public class percorrerEmOrdem {
    public void percorrerEmOrdem(No node) {
        if (node != null) {
            percorrerEmOrdem(node.esquerda);
            System.out.println(node.valor);
            percorrerEmOrdem(node.direita);
            }
        }
    }
    public class percorrerPosOrdem {        
    public void percorrerPosOrdem(No node) {
        if (node != null) {
            percorrerPosOrdem(node.esquerda);
            percorrerPosOrdem(node.direita);
            System.out.println(node.valor);
            }
        }
    }

    public void buscaEmNivel() {
        No raiz = null;
        if (raiz == null) {
            return;
        }
        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);
        while (!fila.isEmpty()) {
            No noAtual = fila.poll();
            System.out.println(noAtual.valor);
            if (noAtual.esquerda != null) {
                fila.add(noAtual.esquerda);
            }
            if (noAtual.direita != null) {
                fila.add(noAtual.direita);
            }
        }
    }
}