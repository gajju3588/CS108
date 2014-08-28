// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

package HW1;

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
        int X = grid.length;
        int Y = grid[0].length;

        int i;
        boolean found = false;
        int minx = 100000, miny=100000, maxx=0,maxy=0;
        for(i=0;i<X;i++){
            int j;
            for(j=0;j<Y;j++){
                 if(grid[i][j] == ch){
                      found = true;

                     if(i<minx){
                         minx = i;
                     }
                     if(j<miny){
                         miny = j;
                     }
                     if(i>maxx){
                         maxx = i;
                     }
                     if(j>maxy){
                         maxy = j;
                     }
                 }
             }
        }

        if(found ){
            return (maxx-minx+1)*(maxy-miny+1);
        }
        return 0;

	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
        int X = grid.length;
        int Y = grid[0].length;

        int countP =0;
        for (int i = 1; i < X; i++) {
            for (int j = 1; j < Y; j++) {
                char temp = grid[i][j];
                if(temp == grid[i-1][j]&& temp == grid[i+1][j] && temp == grid[i][j-1] &&temp == grid[i][j+1]){
                      countP++;
                }

            }

        }
        return countP;
    }
	
}
