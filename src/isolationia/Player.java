package isolationia;


import java.util.*;

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
        
        byte available[] = new byte[3];
        List<byte[]> positions = new ArrayList<byte[]>(0);
        for (byte i = (byte) (positionX-1); i <= (positionX+1); i++) {
            for (byte j = (byte) (positionY-1); j <= (positionY+1); j++) {
                if(i>=0 && i< board.getLengthX()){  //ve se sai pelo lado
                    if(j>=0 && j< board.getLengthY()){ //ve se sai por cima ou por baixo
                        if(i!=positionX && j!=positionY){ //ve se ta olhando onde o jogador esta
                            if(board.getBoard()[i][j]==0){ //ve se ja nao foi passado ou ocupado
                                System.out.println(i + "|" + j);
                                available[0]=i; available[1]=j;
                                numbMapping(available,i,j);
                                positions.add(available);
                            }
                        }
                    }
                }
            }
        }
        
        return positions;
    }
    
    public void numbMapping(byte[] available,byte i,byte j){//metodo que enumera aqueles que estao de acordo com os numeros de do numPad
        if(i ==(byte)this.positionX-1 && j == (byte)this.positionY-1){
            available[2]=7;
        }else if(i ==(byte) this.positionX && j == (byte)this.positionY-1){
            available[2]=8;
        }
        else if(i ==(byte) this.positionX+1 && j == (byte)this.positionY-1){
            available[2]=9;
        }
        else if(i == (byte)this.positionX-1 && j ==(byte) this.positionY){
            available[2]=4;
        }
        else if(i ==(byte) this.positionX+1 && j ==(byte) this.positionY){
            available[2]=6;
        }
        else if(i ==(byte) this.positionX-1 && j ==(byte) this.positionY+1){
            available[2]=1;
        }
        else if(i == (byte)this.positionX && j ==(byte) this.positionY+1){
            available[2]=2;
        }
        else if(i == (byte)this.positionX+1 && j == (byte)this.positionY+1){
            available[2]=3;
        }else{
            System.out.println("COME MEU CU");
        }
    }
    
    public void makeMove(byte[] pos,BoardState board){ //essa funcao deverah existir na versao do IA ,que utilizarah o checkMoves para fazer a arvore
    //entao escolherah a melhor e farah em si o movimento,ja no caso do jogador humano teria de ser interativo
        this.positionX = pos[0];
        this.positionY = pos[1];
        board.occupy(this.positionX ,this.positionY);

    }
    public byte getID(){
        return id;
    }

    public void turnAction(BoardState board){//para o Humano
        //fazer tudo que deve ser feito na sua rodada,
    }
    
    public void turnAction(BoardState board,Player adversary){//para a AI,precisa dos players para
        //fazer tudo que deve ser feito na sua rodada.
    }
    
}