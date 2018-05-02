package isolationia;


public class Judge {//apenas classe de administracao do jogo para dizer de quem eh a vez de quem,eorganizar a main
    
    private static byte idP1;
    private static byte idP2;
     
    
    public Judge(byte id1,byte id2){this.idP1=id1;this.idP2=id2;}//soh caso queiramos mudar os nomes
    
    public static void startGame(){//aqui programaremos o sistema de rodadas para cada um dos jogadores
        boolean turn = true;// 0 player 1, 1 player 2.//podemos randomizar isso depois mas tanto faz
        while(true){
            if(turn){
                
            }
        }
    }
    
    public static void endGame(byte idLoser){//termina o jogo ao ser chamado
        if(idLoser == idP1){
            System.out.println("THE WINNER IS PLAYER " +idP2);
        }else{
            System.out.println("THE WINNER IS PLAYER " +idP1);
        }
        System.exit(0);
    }
    
}
