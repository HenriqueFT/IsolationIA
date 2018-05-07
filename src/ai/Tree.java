/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import game.Board;
import game.Player;

/**
 *
 * @author gabrielsmith
 */
public class Tree
{
    // State of the board in this tree
    public Board board;
    // The turn before this one
    Turn turn;
    // The player that played before this turn
    Player player;
    // Where the player moved to or removed a tile
    public int x, y;
    
    public enum Turn
    {
        MOVE,
        REMOVE
    }
    
    public Tree (Board board, Turn turn, Player player, int x, int y)
    {
        this.board = board;
        this.turn = turn;
        this.player = player;
        this.x = x;
        this.y = y;
    }
    
    public Turn getTurn ()
    {
        return this.turn;
    }
}
