class Solution {
    public boolean solveSudoku(char[][] board) {
        return check(0,0,board);
    }
    public boolean issafe(char [][]b,int i,int j,char ele){
        int m=b.length;
        int n=b[0].length;
        for(int k=0;k<9;k++){
        if( b[i][k] == ele) return false;
        if( b[k][j] == ele) return false;
        }

        int strow=(i/3)*3;
        
        int stcol=(j/3)*3;
       
        for(int k=strow;k<=strow+2;k++){
            for(int l=stcol;l<=stcol+2;l++){
                if(b[k][l]==ele){
                    return false;
                }
            }
        
        } 
        return true;

    }
    public boolean check(int i,int j,char [][]b){
        if(i==9){
            return true;
        }
        if(j==9){
            return check(i+1,0,b);
        }
        if(b[i][j]!='.'){
            return check(i,j+1,b);
        }
        for(int n=1;n<=9;n++){
            
                char c = (char)(n + '0');
                if(issafe(b,i,j,c)){
                    b[i][j]=c;
                    if(check(i,j+1,b))return true;
                    b[i][j]='.';

                }

            
        }
        return false;
        
    }
}