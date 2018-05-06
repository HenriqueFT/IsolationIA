package isolationia;

import java.util.Scanner;

public class IsolationIA {

    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            System.out.println("Se utilizarah do tabuleiro padrao (6x8) ? \n\n S ou N");

            String resp = scan.nextLine();

            if(resp == "N"){
                BoardState board = new BoardState();
                
                System.out.println("Por favor escolha um tamanho para X de seu tabuleiro (2 ateh 128");
                int coordinate = scan.nextInt();
                board.setboardX(coordinate);
                
                System.out.println("Por favor escolha um tamanho para Y de seu tabuleiro (2 ateh 128");
                coordinate = scan.nextInt();
                board.setboardY(coordinate);
                
                board.initializeBoard();

                System.out.println("Que tipo de Jogo sera?\n 1 - Human vs AI1 \n 2 - Human vs AI2 \n 3 - AI vs AI \n 4 - Human vs Human");

                int vsResp = scan.nextInt();
                Player p1;Player p2;
                switch(vsResp){
                    case 1: p1 = new HPlayerInterface((byte)0,(byte)(board.getLengthY()/2),true);
                            p2 = new Player((byte)board.getLengthX(),(byte)(board.getLengthY()/2 +1),false);//trocar pela classe especifica da AI a ser usada aqui
                            Judge.startGame(board,p1,p2);
                            break;
                    case 2: p1 = new HPlayerInterface((byte)0,(byte)(board.getLengthY()/2),true);
                            p2 = new Player((byte)board.getLengthX(),(byte)(board.getLengthY()/2 +1),false);//trocar pela classe especifica da AI a ser usada aqui
                            Judge.startGame(board,p1,p2);
                            break;      
                    case 3: p1 = new Player((byte)0,(byte)(board.getLengthY()/2),true);
                            p2 = new Player((byte)board.getLengthX(),(byte)(board.getLengthY()/2 +1),false);
                            Judge.startGame(board,p1,p2);
                    case 4: p1 = new HPlayerInterface((byte)0,(byte)(board.getLengthY()/2),true);
                            p2 = new HPlayerInterface((byte)board.getLengthX(),(byte)(board.getLengthY()/2 +1),false);
                            Judge.startGame(board,p1,p2);
                }
            }else{
                BoardState board = new BoardState();

                System.out.println("Que tipo de Jogo sera?\n 1 - Human vs AI1 \n 2 - Human vs AI2 \n 3 - AI vs AI \n 4 - Human vs Human");

                int vsResp = scan.nextInt();
                Player p1;Player p2;
                switch(vsResp){
                    case 1: p1 = new HPlayerInterface((byte)0,(byte)(board.getLengthY()/2),true);
                            p2 = new Player((byte)board.getLengthX(),(byte)(board.getLengthY()/2 +1),false);//trocar pela classe especifica da AI a ser usada aqui
                            Judge.startGame(board,p1,p2);
                            break;
                    case 2: p1 = new HPlayerInterface((byte)0,(byte)(board.getLengthY()/2),true);
                            p2 = new Player((byte)board.getLengthX(),(byte)(board.getLengthY()/2 +1),false);//trocar pela classe especifica da AI a ser usada aqui
                            Judge.startGame(board,p1,p2);
                            break;      
                    case 3: p1 = new Player((byte)0,(byte)(board.getLengthY()/2),true);//trocar pela classe especifica da AI a ser usada aqui
                            p2 = new Player((byte)board.getLengthX(),(byte)(board.getLengthY()/2 +1),false);//trocar pela classe especifica da AI a ser usada aqui
                            Judge.startGame(board,p1,p2);
                    case 4: p1 = new HPlayerInterface((byte)0,(byte)(board.getLengthY()/2),true);
                            p2 = new HPlayerInterface((byte)board.getLengthX(),(byte)(board.getLengthY()/2 +1),false);
                            Judge.startGame(board,p1,p2);
            }
        }
    }
}
