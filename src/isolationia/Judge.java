package isolationia;


public class Judge {//apenas classe de administracao do jogo para dizer de quem eh a vez de quem,eorganizar a main
    
    private static byte idP1;
    private static byte idP2;
     
    
    public Judge(Player id1,Player id2){this.idP1=id1.getID();this.idP2=id2.getID();}//soh caso queiramos mudar os nomes
    
    public static void startGame(BoardState board,Player p1, Player p2){//aqui programaremos o sistema de rodadas para cada um dos jogadores
        boolean turn = true;// 1 player 1, 0 player 2.//podemos randomizar isso depois mas tanto faz
        while(true){
            if(turn){
                if(p1.checkMoves(board).size()==0){Judge.endGame(p1.getID());}//Juiz antes da jogava ve se a pessoa perdeu ou nao
                p1.playTurn(board);
            }else{
                if(p2.checkMoves(board).size()==0){Judge.endGame(p2.getID());}//Juiz antes da jogava ve se a pessoa perdeu ou nao
                p2.playTurn(board, p1);//p1 pq o p2 seria o humano entao se coloca adversario
            }
            turn = !turn;
        }
    }
    
    public static void endGame(byte idLoser){//termina o jogo ao ser chamado
        if(idLoser == idP1){
            System.out.println("\n\nTHE WINNER IS PLAYER " +idP2);
        }else{
            System.out.println("THE WINNER IS PLAYER " +idP1);
        }
        System.exit(0);
    }
    
}
