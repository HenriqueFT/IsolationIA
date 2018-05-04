package isolationia;

import java.util.*;

public class Tree {//carregarah a arvore. Serah onde terah a parte de procura,e possivelmente a de heuristica
    
    private Node root;

    public Tree(BoardState currentState) {//carregara o estadu atual do campo,sendo a raiz da arvore
        root = new Node();
        root.state = currentState;
        root.children = new ArrayList<Node>(0); //soh eh iniciado a lista tendo entrado na arvore(Comeca com 0,por na ter filhos)
    }
    
    public Node getRoot ()
    {
        return root;
    }
}
