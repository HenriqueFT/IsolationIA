package isolationia;

import java.util.*;

public class Tree {//carregarah a arvore. Serah onde terah a parte de procura,e possivelmente a de heuristica
    
    private Node root;
    private final int treeDepth = 5; 

    public Tree(BoardState currentState) {//carregara o estadu atual do campo,sendo a raiz da arvore
        root = new Node();
        root.state = currentState.clone();
        root.children = new ArrayList<Node>(0); //soh eh iniciado a lista tendo entrado na arvore(Comeca com 0,por na ter filhos)
    }
    
    public Node getRoot ()
    {
        return root;
    }
    
    public Tree generateBranches(BoardState currentState,Player p1,Player p2){
        int depthControl=0;
        List<byte[]> possibleMoves;
        possibleMoves = p1.checkMoves(currentState);
        for (int i = 0; i < possibleMoves.size(); i++) {
            this.root.addChild(possibleMoves.get(i)[0], possibleMoves.get(i)[1]);
        }
        
        Player currentPlayer = p2;
        
        while(depthControl<treeDepth){
            for (int j = 0; j < root.getChildren().size(); j++) {
                generateBranchesSupport(root.children.get(j),currentPlayer);
            }
            if(currentPlayer == p2){
                currentPlayer=p1;
            }else{
                currentPlayer=p2;
            }
            depthControl++;
        }
         
       return null;
    }
    
    public void generateBranchesSupport(Node node,Player p){
        List<byte[]> possibleMoves;
        possibleMoves = p.checkMoves(node.state);
        for (int i = 0; i < possibleMoves.size(); i++) {
            this.root.addChild(possibleMoves.get(i)[0], possibleMoves.get(i)[1]);
        }
    }
    
}
