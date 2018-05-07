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
        int controlX=0;
        int controlY=0;
        for (byte i = (byte) (this.positionY-1); i <= (this.positionY+1); i++) {
            controlX=0;
            for (byte j = (byte) (this.positionX-1); j <= (this.positionX+1); j++) {
                if(i>=0 && i< board.getLengthX()){  //ve se sai pelo lado
                    if(j>=0 && j< board.getLengthY()){ //ve se sai por cima ou por baixo
                        if(i==this.positionY && j==this.positionX){ //ve se ta olhando onde o jogador esta
                        }else{
                            if(board.getBoard()[i][j]==0){ //ve se ja nao foi passado ou ocupado
                                    System.out.println(i + "|" + j);
                                    available[0]=j; available[1]=i;
                                    available=numbMapping(available,controlX,controlY);
                                    positions.add(available);
                            }
                        }
                    }
                }
                controlX++;
            }
            controlY++;
        }
        
        return positions;
    }
    
    public byte[] numbMapping(byte[] available,int x,int y){//metodo que enumera aqueles que estao de acordo com os numeros de do numPad
       if(x==0){if(y==0){
            available[2]=7;
        }}
       if(x==1){if(y==0){
            available[2]=8;
        }}
       if(x==2){if(y==0){
            available[2]=9;
        }}
       if(x==0){if(y==1){
            available[2]=4;
        }}
       if(x==2){if(y==1){
            available[2]=6;
        }}
       if(x==0){if(y==2){
            available[2]=1;
        }}
       if(x==1){if(y==2){
            available[2]=2;
        }}
       if(x==2){if(y==2){
            available[2]=3;
        }}
        return available;
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