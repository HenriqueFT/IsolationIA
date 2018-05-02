package isolationia;

import java.util.*;

//esta classe devera conter comandos de mover as pecas,e ela serah a classe a qual as IA`s extenderao,entao
//coloquemos aqui o q que tanto a IA utilizaria qquanto o que o humano utilizaria

public class Player {
    
    byte positionX;
    byte positionY;
    private byte id;
    
    public Player(byte startX,byte startY,boolean id){
       this.positionX = startX;
       this.positionY = startY;
       if(id){
           this.id = 4;
       }else{
           this.id = 2;
       }
    }
    
    public List<byte[]> checkMoves(BoardState board){//funcao que retornarah tods as coordenadas q o player pode ir dada sua posicao
        
        byte available[] = new byte[2];
        List<byte[]> positions = new ArrayList<byte[]>(0);
        for (byte i = (byte) (positionX-1); i <= (positionX+1); i++) {
            for (byte j = (byte) (positionY-1); j <= (positionY+1); j++) {
                if(i>=0 && i< board.getLengthX()){  //ve se sai pelo lado
                    if(j>=0 && j< board.getLengthY()){ //ve se sai por cima ou por baixo
                        if(i!=positionX && j!=positionY){ //ve se ta olhando onde o jogador esta
                            if(board.getBoard()[i][j]==0){ //ve se ja nao foi passado ou ocupado
                                available[0]=i; available[1]=j;
                                positions.add(available);
                            }
                        }
                    }
                }
            }
        }
        if(positions.size()==0){
            Judge.endGame(id);
        }
        
        return positions;
    }
    
    public void makeMove(){} //essa funcao deverah existir na versao do IA ,que utilizarah o checkMoves para fazer a arvore
    //entao escolherah a melhor e farah em si o movimento,ja no caso do jogador humano teria de ser interativo
    
    
    public byte getID(){
        return id;
    }
    
}
