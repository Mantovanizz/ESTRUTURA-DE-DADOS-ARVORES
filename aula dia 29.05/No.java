import java.util.Queue;

public class No {
        String valor;
        No esquerda, direita;

    public No(String valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    public int contarNosFila() {
        int contador = 0;
            Queue<No> fila = new java.util.LinkedList<>();
            fila.add(this);

        while (!fila.isEmpty()) {
            No atual = fila.poll();
                contador++; 
            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.add(atual.direita);
        }
        return contador;
    }
}