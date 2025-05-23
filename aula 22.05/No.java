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
}