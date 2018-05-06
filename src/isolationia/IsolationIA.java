package isolationia;


public class IsolationIA {

    public static void main(String[] args) {
        
        System.out.println("Que tipo de Jogo sera?");
        
        Player p1 = new HPlayerInterface((byte)2,(byte)0,true);
        Player p2 = new Player((byte)3,(byte)7,false);
        
        BoardState board = new BoardState(p1,p2);
        
        Judge.startGame(board,p1,p2);
        
        
    }
    
}
