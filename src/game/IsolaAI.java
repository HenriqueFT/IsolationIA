/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import ai.MiniMax;
import game.Player.PlayerType;
import java.util.Scanner;

/**
 *
 * @author gabrielsmith
 */
public class IsolaAI {
    
    private enum GameTurn
    {
        PLAYER1,
        PLAYER2
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Board board;
        Player player1 = null, player2 = null;
        
        MiniMax ai1 = null, ai2;
        
        GameTurn turn = GameTurn.PLAYER1;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Selecione o modo de jogo:\n"
                + "1 - Jogador vs IA\n"
                + "2 - IA vs IA");
        
        int input = 2;
        //int input = scan.nextInt();
        
        switch (input) {
            case 1:
                player1 = new Player(
                        2,
                        PlayerType.HUMAN,
                        Board.WIDTH/2,
                        Board.HEIGHT - 1);
                player2 = new Player(
                        3,
                        PlayerType.COMPUTER,
                        Board.WIDTH/2 - 1,
                        0);
                break;
            case 2:
                player1 = new Player(
                        2,
                        PlayerType.COMPUTER,
                        Board.WIDTH/2,
                        Board.HEIGHT - 1);
                player2 = new Player(
                        3,
                        PlayerType.COMPUTER,
                        Board.WIDTH/2 - 1,
                        0);
                break;
            default:
                System.err.println("Input invalido");
                System.exit(1);
        }
        
        board = new Board(player1, player2);
        
        if (input == 2) ai1 = new MiniMax(board, player1, player2, 4);
        ai2 = new MiniMax(board, player2, player1, 12);
        
        System.out.println(board.toString());
        
        while(!board.checkGameOver())
        {
            if (turn == GameTurn.PLAYER1)
            {
                if (player1.getType() == PlayerType.HUMAN)
                {
                    // TODO: Human turn
                }
                else
                {
                    System.out.println("AI 1 movendo");
                    ai1.makeMovement();
                    System.out.println("AI 1 removendo");
                    ai1.makeRemove();
                    
                    turn = GameTurn.PLAYER2;
                }
            }
            else
            {
                ai2.makeMovement();
                ai2.makeRemove();
                
                turn = GameTurn.PLAYER1;
            }
            
            System.out.println(board.toString());
        }
    }
    
}
