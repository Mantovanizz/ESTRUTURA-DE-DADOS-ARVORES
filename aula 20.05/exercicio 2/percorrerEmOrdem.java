public class percorrerEmOrdem {
    public void percorrerPreOrdem(No node) {
        if (node != null) {
            System.out.println(node.valor);
            percorrerPreOrdem(node.esquerda);
            percorrerPreOrdem(node.direita);
        }
    }
}