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

    public void inserir(String valor) {
        NoRubroNegra novo = new NoRubroNegra(valor);

        if (raiz == null) {
            raiz = novo;
            raiz.cor = NoRubroNegra.Cor.Black;
            return;
        }

        NoRubroNegra atual = raiz;
        NoRubroNegra pai = null;

        while (atual != null) {
            pai = atual;
            if (novo.valor.compareTo(atual.valor) < 0) {
                atual = atual.esquerda;
            } else {
                atual = atual.direita;
            }
        }

        novo.pai = pai;
        if (valor.compareTo(pai.valor) < 0) {
            pai.esquerda = novo;
        } else {
            pai.direita = novo;
        }
    }

    public NoRubroNegra remover(NoRubroNegra raiz, String valor) {
        NoRubroNegra z = buscar(valor);
        if (z == null) return raiz;

        NoRubroNegra y = z;
        NoRubroNegra.Cor corOriginal = y.cor;
        NoRubroNegra x;

        if (z.esquerda == null) {
            x = z.direita;
            transplantar(raiz, z, z.direita);
        } else if (z.direita == null) {
            x = z.esquerda;
            transplantar(raiz, z, z.esquerda);
        } else {
            y = minimo(z.direita);
            corOriginal = y.cor;
            x = y.direita;
            if (y.pai == z) {
                if (x != null) x.pai = y;
            } else {
                transplantar(raiz, y, y.direita);
                y.direita = z.direita;
                if (y.direita != null) y.direita.pai = y;
            }
            transplantar(raiz, z, y);
            y.esquerda = z.esquerda;
            if (y.esquerda != null) y.esquerda.pai = y;
            y.cor = z.cor;
        }
        return raiz;
    }

    private void transplantar(NoRubroNegra raiz, NoRubroNegra u, NoRubroNegra v) {
        if (u.pai == null) {
            raiz = v;
        } else if (u == u.pai.esquerda) {
            u.pai.esquerda = v;
        } else {
            u.pai.direita = v;
        }
        if (v != null) {
            v.pai = u.pai;
        }
    }

    private NoRubroNegra minimo(NoRubroNegra no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }
    
    private void rotacaoEsquerda(NoRubroNegra x) {
        NoRubroNegra y = x.direita;
        x.direita = y.esquerda;
        if (y.esquerda != null) {
            y.esquerda.pai = x;
        }

        y.pai = x.pai;
        if (x.pai == null) {
        } else if (x == x.pai.esquerda) {
            x.pai.esquerda = y;
        } else {
            x.pai.direita = y;
        }

        y.esquerda = x;
        x.pai = y;

    }

    private void rotacaoDireita(NoRubroNegra y) {
        NoRubroNegra x = y.esquerda;
        y.esquerda = x.direita;
        if (x.direita != null) {
            x.direita.pai = y;
        }
        x.pai = y.pai;
        if (y.pai == null) {
        } else if (y == y.pai.direita) {
            y.pai.direita = x;
        } else {
            y.pai.esquerda = x;
        }
        x.direita = y;
        y.pai = x;
    }

    private void Coloração(NoRubroNegra no) {
        while (no != raiz && no.pai.cor == Cor.Red) {
            NoRubroNegra avo = no.pai.pai;
            if (no.pai == avo.esquerda) {
                NoRubroNegra tio = avo.direita;
                if (tio != null && tio.cor == Cor.Red) {
                    no.pai.cor = Cor.Black;
                    tio.cor = Cor.Black;
                    avo.cor = Cor.Red;
                    no = avo;
                } else {
                    if (no == no.pai.direita) {
                    no = no.pai;
                    rotacaoEsquerda(no);
                }
                    no.pai.cor = Cor.Black;
                    avo.cor = Cor.Red;
                    rotacaoDireita(avo);
                }
            } else {
                NoRubroNegra tio = avo.esquerda;
                    if (tio != null && tio.cor == Cor.Red) {
                    no.pai.cor = Cor.Black;
                    tio.cor = Cor.Black;
                    avo.cor = Cor.Red;
                    no = avo;
                } else {
                    if (no == no.pai.esquerda) {
                        no = no.pai;
                        rotacaoDireita(no);
                    }
                    no.pai.cor = Cor.Black;
                    avo.cor = Cor.Red;
                    rotacaoEsquerda(avo);
                }
            }
        }
        raiz.cor = Cor.Black;
    }

    public NoRubroNegra buscar(String valor) {
        if (this.valor.equals(valor)) return this;
        if (valor.compareTo(this.valor) < 0 && esquerda != null)
            return esquerda.buscar(valor);
        if (valor.compareTo(this.valor) > 0 && direita != null)
            return direita.buscar(valor);
        return null;
    }
}
