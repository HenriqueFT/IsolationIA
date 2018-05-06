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
    while(!ok){
       for (int i = 0; i < avMovs.size(); i++) {
           System.out.print(avMovs.get(i)[2] + ",");
        }
        System.out.println(".");
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