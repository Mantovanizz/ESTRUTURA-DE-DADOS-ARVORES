public class percorrerPosOrdem {
    public void percorrerPosOrdem(No node) {
        if (node != null) {
            percorrerPosOrdem(node.esquerda);
            percorrerPosOrdem(node.direita);
            System.out.println(node.valor);
        }
    }
}