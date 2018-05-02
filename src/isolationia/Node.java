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
    
    public void addChild(byte x,byte y){
        BoardState newState = new BoardState(this.parent.state,x,y);
        Node node = new Node(newState);
        children.add(node);
    }
    
    public void addChild(Node node){
        children.add(node);
    }
     
}
