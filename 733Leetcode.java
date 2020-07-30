class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(newColor==image[sr][sc])
        {
            return image;
        }
        dfs(image, sr,sc,newColor,image[sr][sc]);
        return image;
    }
    
    
    
    
    
    
    void dfs(int [][] image, int row, int col, int newColor, int oldColor)
    {
        image[row][col]=newColor;
        if(row>0 && image[row-1][col]==oldColor)
        {
          //  System.out.println("a");
          dfs(image,row-1,col,newColor,oldColor);  
        }
        if(col>0 && image[row][col-1]==oldColor)
        {
          //  System.out.println("b");
           dfs(image,row,col-1,newColor,oldColor);  
        }
        if(row<image.length-1 && image[row+1][col]==oldColor)
        {
          //  System.out.println("c");
           dfs(image,row+1,col,newColor,oldColor);   
        }
        if(col<image[0].length-1 && image[row][col+1]==oldColor)
        {
          //  System.out.println("d");
           dfs(image,row,col+1,newColor,oldColor);   
        }
    }
}
