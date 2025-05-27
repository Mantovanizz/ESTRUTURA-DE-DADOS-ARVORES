import java.util.Stack;

public class No {
    String valor;
    No esquerda, direita;

    public No(String valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    public int contarNos() {
        Object raiz = null;
        if (raiz == null) return 0;

        int contador = 0;
        Stack<No> pilha = new Stack<>();
        pilha.push((No) raiz);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            contador++;
            if (atual.direita != null) pilha.push(atual.direita);
            if (atual.esquerda != null) pilha.push(atual.esquerda);
        }

        return contador;
    }

     public void percorrerPreOrdem() {
        Stack<No> pilha = new Stack<>();
        pilha.push(this);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            System.out.println(atual.valor);

            if (atual.direita != null) pilha.push(atual.direita);
            if (atual.esquerda != null) pilha.push(atual.esquerda);
        }
    }

    public void percorrerEmOrdem() {
        Stack<No> pilha = new Stack<>();
        No atual = this;

        while (atual != null || !pilha.isEmpty()) {
            while (atual != null) {
                pilha.push(atual);
                atual = atual.esquerda;
            }
            atual = pilha.pop();
            System.out.println(atual.valor);
            atual = atual.direita;
        }
    }

    public void percorrerPosOrdem() {
        Stack<No> pilha = new Stack<>();
        Stack<No> resultado = new Stack<>();
        pilha.push(this);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            resultado.push(atual);

            if (atual.esquerda != null) pilha.push(atual.esquerda);
            if (atual.direita != null) pilha.push(atual.direita);
        }

        while (!resultado.isEmpty()) {
            System.out.println(resultado.pop().valor);
        }
    }
    public void buscaEmNivel() {
        No raiz = null;
        if (raiz == null) return;

        Stack<No> fila = new Stack<>();
        fila.push(raiz);

        while (!fila.isEmpty()) {
            No noAtual = fila.pop();
            System.out.println(noAtual.valor);
            if (noAtual.esquerda != null) fila.push(noAtual.esquerda);
            if (noAtual.direita != null) fila.push(noAtual.direita);
        }
    }
    public int contarFolhasRecursivo() {
        if (this == null) return 0;
        if (esquerda == null && direita == null) {
            return 1;
        }
        int folhas = 0;
            if (esquerda != null) folhas += esquerda.contarFolhasRecursivo();
            if (direita != null) folhas += direita.contarFolhasRecursivo();
        return folhas;
    }

    public int contarFolhas() {
        int folhas = 0;
            Stack<No> pilha = new Stack<>();
            pilha.push(this);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            if (atual.esquerda == null && atual.direita == null) {
                folhas++;
            }
            if (atual.direita != null) pilha.push(atual.direita);
            if (atual.esquerda != null) pilha.push(atual.esquerda);
        }
            return folhas;
}
}