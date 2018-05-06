package isolationia;

public class BoardState {
        
        private int xLength = 6;
        private int yLength = 8;
        private byte[][] board = new byte [xLength][yLength];
        
        public BoardState () { }
        
        public BoardState (byte[][] board)
        {
            for (int i = 0; i < xLength; i++)
                System.arraycopy(board[i], 0, this.board[i], 0, yLength);
        }
        
        public void initializeBoard(){
            this.board = new byte [xLength][yLength];
        } 
         
        public void occupy(int x, int y){
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
        
        @Override
        public BoardState clone ()
        {
            return new BoardState(this.board);
        }
        
        @Override
        public String toString ()
        {
            StringBuilder sb = new StringBuilder();
            sb.append("[\n");
            for (int i = 0; i < xLength; i++) {
                for (int j = 0; j < yLength; j++) {
                    sb.append(this.board[i][j]).append(",");
                }
                sb.append('\n');
            }
            sb.append(']');
            return sb.toString();
        }
        
        public String toString (Player p1,Player p2)
        {
            StringBuilder sb = new StringBuilder();
            sb.append("[\n");
            for (int i = 0; i < xLength; i++) {
                for (int j = 0; j < yLength; j++) {
                    if(p1.positionX == i && p1.positionY==j){
                        sb.append(p1.getID()).append(",");
                    }else if (p2.positionX == i && p2.positionY==j){
                        sb.append(p2.getID()).append(",");
                    }else{
                        sb.append(this.board[i][j]).append(",");
                    }
                }
                sb.append('\n');
            }
            sb.append(']');
            return sb.toString();
        }
        
        public void setboardX(int x){this.xLength=x;}
        public void setboardY(int y){this.xLength=y;}
}
