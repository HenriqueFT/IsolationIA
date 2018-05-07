/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author gabrielsmith
 */
public class Board
{
    public static final int WIDTH = 6;
    public static final int HEIGHT = 8;
    
    // 0 - free tile
    // 1 - removed tile
    // 2 - player 1
    // 3 - player 2
    private int[][] board;
    
    private Player p1, p2;
    
    public Board (Player player1, Player player2)
    {
        this.board = new int[WIDTH][HEIGHT];
        
        this.p1 = player1;
        this.p2 = player2;
        
        initializeBoard();
    }
    
    private Board (int[][] board)
    {
        board = new int[WIDTH][HEIGHT];
        
        for (int i = 0; i < WIDTH; i++) {
            System.arraycopy(board[i], 0, this.board[i], 0, HEIGHT);
        }
    }
    
    private void initializeBoard ()
    {
        board[p1.getX()][p1.getY()] = 2;
        board[p2.getX()][p2.getY()] = 3;
    }
    
    // Checks if Player player can move to position (x,y)
    public boolean canMove (Player player, int x, int y)
    {
        if (!validPosition(x, y)) return false;
        
        int px = player.getX();
        int py = player.getY();
        
        // Checks how far player wants to move and if he is moving
        if ((px == x && py == y) || Math.abs(px - x) > 1 || Math.abs(py - y) > 1)
            return false;
        
        return true;
    }
    
    public void move (Player player, int x, int y)
    {
        if (!canMove(player, x, y))
        {
            String error;
            error = "Player can't move to position (" + x + "," + y + ")";
            System.err.println(error);
        }
        
        board[player.getX()][player.getY()] = 1;
        board[x][y] = player.getId();
        
        player.setPosition(x, y);
    }
    
    // Returns the number of possible moves Player player can make
    public int numberPossibleMoves (Player player)
    {
        int moves = 0;
        int px = player.getX(), py = player.getY();
        
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (validPosition(px + i ,py + j) && isFree(px + i, py + j))
                        moves++;
            }
        }
        
        //System.out.println(moves);
        
        return moves;
    }
    
    // Checks if a tile is free
    public boolean isFree (int x, int y)
    {
        if (!validPosition(x, y)) return false;
        if (board[x][y] != 0) return false;
        return true;
    }
    
    // Removes tile from play
    public void removeTile (int x, int y)
    {
        if (!isFree(x, y))
        {
            String error;
            error = "Can't remove tile in position (" + x + "," + y + ")";
            System.err.println(error);
        }
        
        board[x][y] = 1;
    }
    
    // Checks if (x, y) are coordinates inside the board
    public boolean validPosition (int x, int y)
    {
        return (x >= 0 && x < WIDTH) && (y >= 0 && y < HEIGHT);
    }
    
    // Returns true if either player has no moves left
    public boolean checkGameOver ()
    {
        return playerLost(p1) || playerLost(p2);
    }
    
    // Returns true if player has no possible moves left
    public boolean playerLost (Player player)
    {
        return numberPossibleMoves(player) == 0;
    }
    
    @Override
    public Board clone ()
    {
        Board clone = new Board(this.board);
        clone.setP1(this.p1);
        clone.setP2(this.p2);
        
        return clone;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                sb.append(this.board[j][i]).append(",");
            }
            sb.append('\n');
        }
        sb.append(']');
        return sb.toString();
    }

    /**
     * @return the p1
     */
    public Player getP1() {
        return p1;
    }

    /**
     * @param p1 the p1 to set
     */
    public void setP1(Player p1) {
        this.p1 = p1;
    }

    /**
     * @return the p2
     */
    public Player getP2() {
        return p2;
    }

    /**
     * @param p2 the p2 to set
     */
    public void setP2(Player p2) {
        this.p2 = p2;
    }
}
