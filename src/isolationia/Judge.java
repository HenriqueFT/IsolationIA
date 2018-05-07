
package isolationia;

import java.util.Scanner;

public class Judge {//apenas classe de administracao do jogo para dizer de quem eh a vez de quem,eorganizar a main
    
    private static byte idP1;
    private static byte idP2;
     
    
    public Judge(Player id1,Player id2){this.idP1=id1.getID();this.idP2=id2.getID();}//soh caso queiramos mudar os nomes
    
    public static void startGame(BoardState board,Player p1, Player p2){//aqui programaremos o sistema de rodadas para cada um dos jogadores
        boolean turn = true;// 1 player 1, 0 player 2.//podemos randomizar isso depois mas tanto faz
        while(true){
            board.printBoard(p1, p2);
            if(turn){
                System.out.println("\nVez de Player de ID : " + p1.getID());
                if(p1.checkMoves(board).size()==0){Judge.endGame(turn);}//Juiz antes da jogava ve se a pessoa perdeu ou nao
                p1.turnAction(board);
            }else{
                System.out.println("\nVez de Player de ID : " + p2.getID());
                if(p2.checkMoves(board).size()==0){Judge.endGame(turn);}//Juiz antes da jogava ve se a pessoa perdeu ou nao
                p2.turnAction(board, p1);//p1 pq o p2 seria o humano entao se coloca adversario
            }
            turn = !turn;
        }
    }
    
    public static void endGame(boolean turn){//termina o jogo ao ser chamado
        if(turn){
            System.out.println("\n\nTHE WINNER IS PLAYER P2");
        }else{
            System.out.println("\n\nTHE WINNER IS PLAYER P1");
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Pressione qualquer tecla para sair.");
        
        if(scan.hasNextLine()){System.exit(0);}
    }
    
}
