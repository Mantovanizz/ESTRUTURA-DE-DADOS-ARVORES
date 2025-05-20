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
}