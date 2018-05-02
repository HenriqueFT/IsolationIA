package isolationia;

public class BoardState {
        
        private int xLength = 6;
        private int yLength = 8;
        private byte [][] board = new byte [xLength][yLength];
        
        public BoardState(){ //primeira iniciacao
            for (int i = 0; i < 6; i++) { //deixei os numeros inteiros soh apra ser um pouco mais rapido
                for (int j = 0; j < 8; j++) {
                    board[i][j] = 0;
                }
            }
        }
        
         public BoardState(Player p1,Player p2){ //primeira iniciacao
            for (int i = 0; i < xLength; i++) { //deixei os numeros inteiros soh apra ser um pouco mais rapido
                for (int j = 0; j < yLength; j++) {
                    board[i][j] = 0;
                }
            }
            board[p1.positionX][p1.positionY] = p1.getID();
            board[p2.positionX][p2.positionY] = p2.getID();
        }
        
        public BoardState(BoardState previous){ //caso precisemos apenas copiar o tabuleiro
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    this.board[i][j]=previous.board[i][j];
                }
            }
        }
        
        public BoardState(BoardState previous,byte x,byte y){ //caso precisemos adicionar um novo lugar em menos pacos
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    this.board[i][j]=previous.board[i][j];
                }
            }
            if(this.board [x][y]!=1){
                this.board [x][y]=1;
            }else{
                System.err.println("TENTANDO AVANCAR PARA CASA JA OCUPADA");
            }
        }
         
         public void occupy(byte x,byte y){
             if(this.board [x][y]!=1){
                this.board [x][y]=1;
            }else{
                System.err.println("TENTANDO AVANCAR PARA CASA JA OCUPADA");
            }
         }
         
         public byte [][] getBoard(){
             return board;
         }
         
         public int getLengthX(){
             return xLength;
         }
         
          public int getLengthY(){
             return yLength;
         }
}
