package isolationia;

public class BoardState {
        
        private byte [][] board = new byte [6][8];
        
        public BoardState(){ //primeira iniciacao
            for (int i = 0; i < 6; i++) { //deixei os numeros inteiros soh apra ser um pouco mais rapido
                for (int j = 0; j < 8; j++) {
                    board[i][j] = 0;
                }
            }
        }
        
        public BoardState(BoardState previous){ //caso precisemos apenas copiar o tabuleiro
            this.board = previous.board;
        }
        
         public BoardState(BoardState previous,int i,int j){ //caso precisemos adicionar um novo lugar em menos pacos
            this.board = previous.board;
            if(this.board [i][j]!=1){
                this.board [i][j]=1;
            }else{
                System.err.println("TENTANDO AVANCAR PARA CASA JA OCUPADA");
            }
        }
         
         private void occupy(int i,int j){
             if(this.board [i][j]!=1){
                this.board [i][j]=1;
            }else{
                System.err.println("TENTANDO AVANCAR PARA CASA JA OCUPADA");
            }
         }
}
