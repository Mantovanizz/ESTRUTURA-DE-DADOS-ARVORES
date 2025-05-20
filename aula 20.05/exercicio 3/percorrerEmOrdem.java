public class percorrerEmOrdem {
    public void percorrerEmOrdem(No node) {
        if (node != null) {
            percorrerEmOrdem(node.esquerda);
            System.out.println(node.valor);
            percorrerEmOrdem(node.direita);
        }
    }
}