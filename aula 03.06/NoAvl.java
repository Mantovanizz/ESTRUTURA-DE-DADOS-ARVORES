public class NoAvl {
    String valor;
    NoAvl esquerda, direita;
    int altura;

    public NoAvl(String valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null; 
    }

    public NoAvl inserir(NoAvl no, String valor) {
        if (no == null) return new NoAvl(valor);

        int cmp = valor.compareTo(no.valor); 
        if (cmp < 0) { 
            no.esquerda = inserir(no.esquerda, valor); 
        } else if (cmp > 0) { 
            no.direita = inserir(no.direita, valor);
        } else {
            return no; 
        }
        return no;
    }

    public NoAvl remover(NoAvl no, String valor) {
        if (no == null) return null;

        int cmp = valor.compareTo(no.valor);
        if (cmp < 0) {
            no.esquerda = remover(no.esquerda, valor);
        } else if (cmp > 0) {
            no.direita = remover(no.direita, valor);
        } else {
            if (no.esquerda == null) return no.direita;
            else if (no.direita == null) return no.esquerda;

            NoAvl temp = no.direita;
            while (temp.esquerda != null) {
                temp = temp.esquerda;
            }
            no.valor = temp.valor;
            no.direita = remover(no.direita, temp.valor);
        }
        return no;
    }
 
    public NoAvl busca(NoAvl no, String valor) {
        if (no == null || no.valor.equals(valor)) return no;

        int cmp = valor.compareTo(no.valor);
        if (cmp < 0) {
            return busca(no.esquerda, valor);
        } else {
            return busca(no.direita, valor);
        }
    }
}