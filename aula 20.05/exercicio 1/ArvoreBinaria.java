public class ArvoreBinaria {
    public int contarNos(No node) {
        return (node == null) ? 0 : 1 + contarNos(node.esquerda) + contarNos(node.direita);
    }
}