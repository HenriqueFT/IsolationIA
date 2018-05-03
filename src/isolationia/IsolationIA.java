package isolationia;


public class IsolationIA {

    public static void main(String[] args) {
        //Judge.startGame();
        
        BoardState xablau = new BoardState();
        System.out.println(xablau.toString());
        System.out.println(xablau.clone().toString());
        System.out.println(xablau.equals(xablau.clone()));
    }
    
}
