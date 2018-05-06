package isolationia;

import java.util.*;

public class Node {
    BoardState state;
    Node parent;
    List<Node> children;
    Integer value=null;
    public Node(){}
    
    private Node(BoardState newState){//para ser usada apenas pelos metodos aqui dentro
        this.state = newState;
    }
    
    public void addChild(BoardState newState){
        Node node = new Node(newState);
        children.add(node);
    }
    
    public void addChild(int x, int y)
    {
        //BoardState newState = new BoardState(this.parent.state,x,y);
        BoardState newState = this.parent.state.clone();
        newState.occupy(x, y);
        Node node = new Node(newState);
        children.add(node);
    }
    
    public void addChild(Node node){
        children.add(node);
    }
    
    public List<Node> getChildren(){
        return children;
    }
    public void min(){
        int resp=this.getChildren().get(0).value;
        for (int i = 0; i < (this.getChildren().size()-1); i++) {
            if (resp>this.getChildren().get(i).value){
                resp=this.getChildren().get(i).value;
            }
        }
        this.value=resp;
    }    
    public void max(){
        int resp=this.getChildren().get(0).value;
        for (int i = 0; i < (this.getChildren().size()-1); i++) {
            if (resp<this.getChildren().get(i).value){
                resp=this.getChildren().get(i).value;
            }
        }
        this.value=resp;
    }
    public void evaluate(){
    
    }
}
