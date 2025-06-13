public class NoRubroNegra {
    enum Cor {
        Red, Black
    }

    String valor;
    NoRubroNegra esquerda, direita, pai;
    Cor cor;

    public NoRubroNegra(String valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
        this.cor = Cor.Red; 
    }
}
