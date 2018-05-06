package isolationia;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victor
 */
public class MiniMax{
    int depth;
    Node no;
    
    
public MiniMax(Node no,int depth){
        this.depth=depth;
        this.no=no;
        
    }

public int execMinMax(Node no, boolean type){
    if(no.getChildren().isEmpty()){
        return evaluate();
    }
    int resp;
    int[] values=new int[no.getChildren().size()];
    for (int i = 0; i < (no.getChildren().size()-1); i++) {
        values[i]=execMinMax(no.getChildren().get(i),!type);
        }
    if(type){    
        resp=minArr(values);
}
    else{
        resp=maxArr(values);
}
    return resp;
}
    
    
 public int maxArr(int[]arr){
     int holder=arr[0];
     for (int i = 0; i < arr.length-1; i++) {
         if(arr[i]>holder){
             holder=arr[i];
         }
     }
     return holder;
 }   
  public int minArr(int[]arr){
     int holder=arr[0];
     for (int i = 0; i < arr.length-1; i++) {
         if(arr[i]<holder){
             holder=arr[i];
         }
     }
     return holder;
 }   
}
