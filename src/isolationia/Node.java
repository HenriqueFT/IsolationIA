package isolationia;

import java.util.*;

public class Node {
    BoardState state;
    Node parent;
    List<Node> children;
    
    public Node(){}
    
    private Node(BoardState newState){//para ser usada apenas pelos metodos aqui dentro
        this.state = newState;
    }
    
    public void addChild(BoardState newState){
        Node node = new Node(newState);
        children.add(node);
    }
    
    public void addChild(int i,int j){
        BoardState newState = new BoardState(this.parent.state,i,j);
        Node node = new Node(newState);
        children.add(node);
    }
    
    public void addChild(Node node){
        children.add(node);
    }
     
}
