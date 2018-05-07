package isolationia;


import java.util.*;
        
public class HPlayerInterface extends Player {
    
    byte name;

    public HPlayerInterface(byte startX, byte startY, boolean id) {
        super(startX, startY, id);
    }
   


@Override
public void turnAction (BoardState board) {
    Boolean ok =false;
    System.out.println("Escolha seu proximo movimento entre : \n");
    List<byte[]> avMovs = super.checkMoves(board);
    byte [] nextMoveCoord = new byte[2];
    byte []test = new byte[3];
    while(!ok){
        
       for (int i = 0; i < avMovs.size(); i++) {
           test=avMovs.get(i);
           System.out.print(test[2] + ",");
        }
       
        Scanner sc = new Scanner(System.in);
        int mov = sc.nextInt();   
        byte[] temp = new byte[3];
        for (int j = 0; j < avMovs.size(); j++) {
            temp =avMovs.get(j);
           if(temp[2]==(byte)mov){
               nextMoveCoord[0] = temp[0];
               nextMoveCoord[1] = temp[1];
               ok=true;
           }
        }
        if(!ok){
             System.out.println("Movimento invalido, escolha outro");
        }
    }    
    super.makeMove(nextMoveCoord,board);
}

}