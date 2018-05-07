/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import ai.Tree.Turn;

import game.Board;
import game.Player;
import java.util.ArrayList;

/**
 *
 * @author gabrielsmith
 */
public class MiniMax
{
    private int profundity;
    private Board board;
    private Player MAX, MIN;
    
    
    
    public MiniMax (Board board, Player MAX, Player MIN, int profundity)
    {
        this.board = board;
        this.MAX = MAX;
        this.MIN = MIN;
        this.profundity = profundity;
        System.out.println("criooooo");
    }
    
    public void makeMovement ()
    {
        System.out.println("cheguei");
        // Creates a tree that comes from the MIN player (other player)
        // removing a tile off the board
        Tree t = new Tree(board, Turn.REMOVE, MIN, 0, 0);
        // Finds the best move it can make
        Tree move = findBestMove(t);
        // Executes movement
        board.move(MAX, move.x, move.y);
    }
    
    public void makeRemove ()
    {
        // Creates a tree that comes from the MAX player (this AI)
        // moving to a tile of the board
        Tree t = new Tree(board, Turn.MOVE, MAX, 0, 0);
        // Finds the best tile it can remove
        Tree remove = findBestMove(t);
        // Removes tile
        board.removeTile(remove.x, remove.y);
    }
    
    private ArrayList<Tree> findNextMoves (Tree tree)
    {
        ArrayList<Tree> res = new ArrayList<Tree>();
        
        Player player = (tree.player == MAX) ? MIN : MAX;
        
        int x = player.getX();
        int y = player.getY();
        
        if (tree.turn == Turn.MOVE)
        {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (tree.board.canMove(player, x, y))
                    {
                        Board newBoard = tree.board.clone();
                        newBoard.move(player, x + i, y + j);
                        Tree nextMove = new Tree(
                                newBoard,
                                Turn.REMOVE,
                                player,
                                x + i,
                                y + j);
                        
                        res.add(nextMove);
                    }
                }
            }
        }
        else
        {
            for (int i = -2; i <= 2; i++) {
                for (int j = -2; j <= 2; j++) {
                    if (tree.board.isFree(x, y))
                    {
                        Board newBoard = tree.board.clone();
                        newBoard.removeTile(x + i, y + j);
                        Tree nextMove = new Tree(
                                newBoard,
                                Turn.MOVE,
                                tree.player,
                                x + i,
                                y + j);
                        
                        res.add(nextMove);
                    }
                }
            }
        }
        
        return res;
    }
    
    private Tree findBestMove (Tree root)
    {
        Tree bestMove = null;
        double bestV = Double.NEGATIVE_INFINITY;
        for (Tree t : findNextMoves(root))
        {
            double v = minimaxWithAB(
                    t, 
                    Double.NEGATIVE_INFINITY, 
                    Double.POSITIVE_INFINITY, 
                    this.profundity);
            
            if (bestV < v)
            {
                bestV = v;
                bestMove = t;
            }
        }
        
        return bestMove;
    }
    
    private double minimaxWithAB (
            Tree tree,
            double alpha,
            double beta,
            int profundity)
    {
        if (cutoff(tree, profundity)) return eval (tree);
        
        ArrayList<Tree> moves = findNextMoves(tree);
        
        if((tree.player == MAX && tree.turn == Turn.REMOVE) ||
                (tree.player == MIN && tree.turn == Turn.MOVE))
        {
            for (Tree t : moves)
            {
                double v = minimaxWithAB(t, alpha, beta, profundity - 1);
                alpha = (v > alpha) ? v : alpha;
                if (beta <= alpha) break;
            }
            
            return alpha;
        }
        else
        {
            for (Tree t : moves)
            {
                double v = minimaxWithAB(t, alpha, beta, profundity - 1);
                beta = (v < alpha) ? v : alpha;
                if (beta <= alpha) break;
            }
            
            return beta;
        }
    }
    
    private boolean cutoff (Tree tree, int profundity)
    {
        return endNode(tree) || (profundity == 0);
    }
    
    private boolean endNode (Tree tree)
    {
        return tree.board.checkGameOver();
    }
    
    // Heuristic function
    private double eval (Tree tree)
    {
        if (tree.board.playerLost(MIN)) return Double.POSITIVE_INFINITY;
        if (tree.board.playerLost(MAX)) return Double.NEGATIVE_INFINITY;
        
        double maxPositionToCenter = centerControl(MAX, tree.board);
        double minPositionToCenter = centerControl(MIN, tree.board);
        
        // When moving, favor a better position for MAX rather than
        // a bad position for MIN
        // Do the opposite when removing
        if (tree.getTurn() == Turn.MOVE)
            return (3 * maxPositionToCenter/2) - minPositionToCenter/2;
        else
            return maxPositionToCenter/2 - (3 * minPositionToCenter/2);
    }
    
    // Returns the distance from the player to the center of the board
    private double centerControl (Player player, Board board)
    {
        double cx = (board.WIDTH-1)/2;
        double cy = (board.HEIGHT-1)/2;
        
        return Math.sqrt(Math.pow(cx-player.getX(), 2)
                + Math.pow(cy-player.getY(), 2));
    }
}
