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
    
    public Node generateBranches(BoardState currentState,Player p1,Player p2){
        generateBranchesRecursive(root,0,p1,p2,true);
        
       return root;
    }
    
    public void generateBranchesSupport(Node node,Player p){
        List<byte[]> possibleMoves;
        possibleMoves = p.checkMoves(node.state);
        for (int i = 0; i < possibleMoves.size(); i++) {
            node.addChild(possibleMoves.get(i)[0], possibleMoves.get(i)[1]);
        }
        
    }
    
    public void generateBranchesRecursive (Node currentNode,int depthControl,Player p1,Player p2,Boolean playerChoice){
        if(depthControl<treeDepth){
            
            Player currentPlayer;
            
            if(playerChoice){
                currentPlayer=p1;
            }else{
                currentPlayer=p2;
            }
            
            for (int j = 0; j < currentNode.getChildren().size(); j++) {
                generateBranchesSupport(currentNode.getChildren().get(j),currentPlayer);
            }  
           
            depthControl++;
            playerChoice = !playerChoice;
           
            for (int i = 0; i < currentNode.getChildren().size(); i++) {
                generateBranchesRecursive (currentNode.getChildren().get(i),depthControl,p1,p2,playerChoice);
            }
            
        }else{
            if(depthControl==treeDepth || (currentNode.getChildren().isEmpty())){//isso pode dar um problema depois
                currentNode.value=evaluate(p1,p2,currentNode);
                
                
            }       
        }
        if(currentNode.parent.value == null){//se o pai não tiver valor, atribui o seu pro pai
            currentNode.parent.value=currentNode.value;
        }
        if(playerChoice){
            if(currentNode.parent.value<currentNode.value){//se for a vez de max, escolhe o maior valor dentre os filhos
                currentNode.parent.value=currentNode.value;
            }
        }else{
            if(currentNode.parent.value>currentNode.value){//se for min, escolhe o menor dentre os filhos
                currentNode.parent.value=currentNode.value;
        }
    }
    
            
        }
    public int evaluate(Player p1,Player p2,Node current){
        //a função de avaliação pega o tamanho da lista dos possiveis movientos e diminui
        //do tamanho da lista do oponente
        int resp=(p1.checkMoves(current.state).size())-(p2.checkMoves(current.state).size());
        return resp;
    }
}
