package isolationia;


import java.util.*;
        
public class HPlayerInterface extends Player {
    
   byte name;

    public HPlayerInterface(byte startX, byte startY, boolean id) {
        super(startX, startY, id);
    }
   



public void turnAction (BoardState board) {
    Boolean ok =false;
    System.out.println("Sua vez");
    List<byte[]> avMovs = super.checkMoves(board);
       byte[] available = new byte[2];
       while(!ok){
       for (int i = 0; i < avMovs.size(); i++) {
        available = avMovs.get(i);
        if(available[0]==0){
            if(available[1]==0){
                System.out.println(",7");
            }
            if(available[1]==1){
                System.out.println(",4");
            }
            if(available[1]==2){
                System.out.println(",1");
            }
        }
        if(available[1]==0){
            if(available[1]==0){
                System.out.println(",8");
            }            
            if(available[1]==2){
                System.out.println(",2");
            }
        }
        if(available[2]==0){
            if(available[1]==0){
                System.out.println(",9");
            }
            if(available[1]==1){
                System.out.println(",6");
            }
            if(available[1]==2){
                System.out.println(",3");
            }
        }
    }
    System.out.println(".");
    Scanner sc = new Scanner(System.in);
    int mov = sc.nextInt();    
    if(mov==9){
        ok=true;
        available[0]=2;
        available[1]=0;
    }     
    if(mov==8){
        ok=true;
        available[0]=1;
        available[1]=0;
    }     
    if(mov==7){
        ok=true;
        available[0]=0;
        available[1]=0;
    }     
    if(mov==6){
        ok=true;
        available[0]=2;
        available[1]=1;
    }     
    if(mov==4){
        ok=true;
        available[0]=0;
        available[1]=1;
    }     
    if(mov==3){
        ok=true;
        available[0]=2;
        available[1]=2;
    }     
    if(mov==2){
        ok=true;
        available[0]=1;
        available[1]=2;
    }     
    if(mov==1){
        ok=true;
        available[0]=0;
        available[1]=2;
    } else{
        System.out.println("Movimento invalido, escolha outro");
    }
    }    
    super.makeMove(available,board);
}

}