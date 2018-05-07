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
public class Player
{
    private int id;
    private int x;
    private int y;
    
    private PlayerType type;
    
    public enum PlayerType
    {
        HUMAN,
        COMPUTER
    }
    
    public Player (int id, PlayerType type, int x, int y)
    {
        this.id = id;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }
    
    /**
     * @param x the x to set
     * @param y the y to set
     */
    public void setPosition (int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the type
     */
    public PlayerType getType() {
        return type;
    }
    
    
}
