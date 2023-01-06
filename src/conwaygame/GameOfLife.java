package conwaygame;
import java.util.ArrayList;
/**
 * Conway's Game of Life Class holds various methods that will
 * progress the state of the game's board through it's many iterations/generations.
 *
 * Rules 
 * Alive cells with 0-1 neighbors die of loneliness.
 * Alive cells with >=4 neighbors die of overpopulation.
 * Alive cells with 2-3 neighbors survive.
 * Dead cells with exactly 3 neighbors become alive by reproduction.

 * @author Seth Kelley 
 * @author Maxwell Goldberg
 */
public class GameOfLife {

 // Instance variables
 private static final boolean ALIVE = true;
 private static final boolean DEAD = false;

 private boolean[][] grid; // The board has the current generation of cells
 private int totalAliveCells; // Total number of alive cells in the grid (board)

 /**
 * Default Constructor which creates a small 5x5 grid with five alive cells.
 * This variation does not exceed bounds and dies off after four iterations.
 */
 public GameOfLife() {
 grid = new boolean[5][5];
 totalAliveCells = 5;
 grid[1][1] = ALIVE;
 grid[1][3] = ALIVE;
 grid[2][2] = ALIVE;
 grid[3][2] = ALIVE;
 grid[3][3] = ALIVE;
 }

 /**
 * Constructor used that will take in values to create a grid with a given number
 * of alive cells
 * @param file is the input file with the initial game pattern formatted as follows:
 * An integer representing the number of grid rows, say r
 * An integer representing the number of grid columns, say c
 * Number of r lines, each containing c true or false values (true denotes an ALIVE cell)
 */
 public GameOfLife (String file) {
 
 // WRITE YOUR CODE HERE
 StdIn.setFile(file);
 int m = StdIn.readInt();
 int n = StdIn.readInt();
 grid = new boolean[m][n];
 for (int i = 0; i < m; i++) {
 for (int j = 0; j < n; j++) {
 grid[i][j] = StdIn.readBoolean();
 }
 }
 
 }
 

 /**
 * Returns grid
 * @return boolean[][] for current grid
 */
 public boolean[][] getGrid () {
 return grid;
 }
 
 /**
 * Returns totalAliveCells
 * @return int for total number of alive cells in grid
 */
 public int getTotalAliveCells () {
 return totalAliveCells;
 }

 /**
 * Returns the status of the cell at (row,col): ALIVE or DEAD
 * @param row row position of the cell
 * @param col column position of the cell
 * @return true or false value "ALIVE" or "DEAD" (state of the cell)
 */
 public boolean getCellState (int row, int col) {

 // WRITE YOUR CODE HERE
 if(grid[row][col]== ALIVE){
 return true; 
 }
 return false;
 // update this line, provided so that code compiles
 }

 /**
 * Returns true if there are any alive cells in the grid
 * @return true if there is at least one cell alive, otherwise returns false
 */
 public boolean isAlive () {

 // WRITE YOUR CODE HERE
 if (getTotalAliveCells() > 0)
 {
 return true;
 }
 return false; // update this line, provided so that code compiles
 }

 /**
 * Determines the number of alive cells around a given cell.
 * Each cell has 8 neighbor cells which are the cells that are 
 * horizontally, vertically, or diagonally adjacent.
 * 
 * @param col column position of the cell
 * @param row row position of the cell
 * @return neighboringCells, the number of alive cells (at most 8).
 */
 public int numOfAliveNeighbors (int row, int col) {

 // WRITE YOUR CODE HERE
 int r = grid.length-1;
 int c = grid[0].length-1;
 int cnt = 0;

 //top left corner
 if(row==0 && col==0 && col<c){
 if( (grid[row][col+1] == ALIVE)){ // (0,1)
 cnt++;
 }
 if((grid[row+1][col] == ALIVE)){ //(1,0)
 cnt++;

 }
 if((grid[row+1][col+1] == ALIVE)){//(1,1)
 cnt++;

 }
 if( (grid[r][0] == ALIVE)){ //(3,0)
 cnt++;
 }
 if( (grid[r][1] == ALIVE)){//(3,1)
 cnt++;
 }
 if((grid[0][c] == ALIVE)){//(0,3)
 cnt++;
 }
 if((grid[1][c] == ALIVE)){//(1,3)
 cnt++;
 }
 if((grid[r][c] == ALIVE)){//(3,3)
 cnt++;
 }
 }
 
 
 
 //top right corner (0,3)
 if(row == 0 && col == c){

 if(row == 0 && col != 0 && (grid[row][col-1] == ALIVE)){//(0,2)
 cnt ++;
 }
 if(row == 0 && col != 0 && (grid[row+1][col] == ALIVE)){//(1,3)
 cnt ++;
 }
 if(row == 0 && col != 0 && (grid[row+1][col-1] == ALIVE)){//(1,2)
 cnt ++;
 }
 if(row == 0 && col != 0 && (grid[r][0] == ALIVE)){//(3,0)
 cnt ++;
 }
 if(row == 0 && col != 0 && (grid[0][0] == ALIVE)){//(0,0)
 cnt ++;
 }
 if(row == 0 && col != 0 && (grid[1][0] == ALIVE)){//(1,0)
 cnt ++;
 }
 if(row == 0 && col != 0 && (grid[r][col-1] == ALIVE)){//(3,2)
 cnt ++;
 }
 if(row == 0 && col != 0 && (grid[r][c] == ALIVE)){//(3,3)
 cnt ++;
 }
 }


 //bottom left corner (3,0)
 
 if(row == r && col == 0){
 if(row != 0 && col == 0 && (grid[row-1][0] == ALIVE)){ //(2,0)
 cnt ++;
 }
 if(row != 0 && col == 0 && (grid[row-1][1] == ALIVE)){//(2,1)
 cnt ++;
 }
 if(row != 0 && col == 0 && (grid[row][1] == ALIVE)){//(3,1)
 cnt ++;
 }
 if(row != 0 && col == 0 && (grid[row-1][col] == ALIVE)){ //(2,3)
 cnt ++;
 }
 if(row != 0 && col == 0 && (grid[row][col] == ALIVE)){ //(3,3)
 cnt ++;
 }
 if(row != 0 && col == 0 && (grid[0][0] == ALIVE)){ //(0,0)
 cnt ++;
 }
 if(row != 0 && col == 0 && (grid[0][1] == ALIVE)){//(0,1)
 cnt++;
 }
 if(row != 0 && col == 0 && (grid[0][c] == ALIVE)){//(0,3)
 cnt++;
 }
 }



 //bottom right corner (3,3)
 if(row == r && col==c ){
 if((grid[row-1][col-1] == ALIVE)){ //(2,2)
 cnt ++;

 }
 if((grid[row-1][col] == ALIVE)){ //(2,3)
 cnt ++;
 
 }
 if((grid[row][col-1] == ALIVE)){ //(3,2)
 cnt ++;
 
 }
 if( (grid[0][col-1] == ALIVE)){ //(0,2)
 cnt ++;
 
 }
 if((grid[0][col] == ALIVE)){ //(0,3)
 cnt ++;
 
 }
 if( (grid[row-1][0] == ALIVE)){ //(2,0)
 cnt ++;
 
 }
 if( (grid[row][0] == ALIVE)){ //(3,0)
 cnt ++;
 
 }
 if( (grid[0][0] == ALIVE)){ //(0,0)
 cnt ++;
 
 }
 }
 
 // // //top edge (0,1)
 if(row==0 && col!=0 && col!=c){

 if((grid[0][col-1] == ALIVE)){ //(0,0)
 cnt ++;
 }
 if((grid[0][col+1] == ALIVE)){ //(0,2)
 cnt++;
 }
 if( (grid[row+1][col-1] == ALIVE)){//(1,0)
 cnt++;
 }
 if( (grid[row+1][col+1] == ALIVE)){//(1,2)
 cnt++;
 }
 if((grid[row+1][col] == ALIVE)){//(1,1)
 cnt++;
 }
 if((grid[r][col-1] == ALIVE)){//(3,0)
 cnt++;
 }
 if((grid[r][col] == ALIVE)){//(3,1)
 cnt++;
 }
 if((grid[r][col+1] == ALIVE)){//(3,2)
 cnt++;
 }

 }
 

 // // // //bottom edge (3,2)
 if(col!=c && row == r){
 if( row!= 0 && col !=0 && (grid[row][col-1] == ALIVE) ){//(3,1)//left
 cnt++;
 }
 
 if(row!= 0 && col !=0 && (grid[row][col+1] == ALIVE) ){//(3,3)//right
 cnt++;
 }

 if(row!= 0 && col !=0 && (grid[row-1][col] == ALIVE) ){//(2,3)//above be
 cnt++;
 }
 if(row!= 0 && col !=0 && (grid[row-1][col-1] == ALIVE) ){//(2,1)
 cnt++;
 }
 if(row!= 0 && col !=0 && (grid[row-1][col+1] == ALIVE) ){//(2,3)
 cnt++;
 }
 if(row!= 0 && col !=0 && (grid[0][col+1] == ALIVE) ){//(0,3)
 cnt++;
 }
 if(row!= 0 && col !=0 && (grid[0][col-1] == ALIVE) ){//(0,2)
 cnt++;
 }
 if(row!= 0 && col !=0 && (grid[0][col] == ALIVE) ){//(0,3)
 cnt++;
 }
 }

 // // // //right edge (1,3)

 if(row>0 && row<r && col==c){

 if(row!= 0 && col !=0 && (grid[row-1][col] == ALIVE) ){//(0,3)
 cnt++;
 }
 if(row!= 0 && col !=0 && (grid[row+1][col] == ALIVE) ){//(2,3)
 cnt++;
 }
 if(row!= 0 && col !=0 && (grid[row][col-1] == ALIVE) ){//(1,2)
 cnt++;
 }
 if(row!= 0 && col !=0 && (grid[row-1][col-1] == ALIVE) ){//(0,2)
 cnt++;
 }
 if(row!= 0 && col !=0 && (grid[row+1][col-1] == ALIVE) ){//(2,2)
 cnt++;
 }
 if(row!= 0 && col !=0 && (grid[row][0] == ALIVE) ){//(1,0)
 cnt++;
 }
 if(row!= 0 && col !=0 && (grid[row+1][0] == ALIVE) ){//(2,0)
 cnt++;
 }
 if(row!= 0 && col !=0 && (grid[row-1][0] == ALIVE) ){//(0,0)
 cnt++;
 }
 }
 


 // // // //left edge (1,0)

 if(row<r && col==0 && row!=0){

 if(row!= 0 && (grid[row-1][col] == ALIVE) ){//(0,0)
 cnt++;
 }
 if(row!= 0 && (grid[row+1][col] == ALIVE) ){//(2,0)
 cnt++;
 }
 if(row!= 0 && (grid[row-1][col+1] == ALIVE) ){//(0,1)
 cnt++;
 }
 if(row!= 0 && (grid[row+1][col+1] == ALIVE) ){//(2,1)
 cnt++;
 }
 if(row!= 0 && (grid[row][col+1] == ALIVE) ){//(1,1)
 cnt++;
 }
 if(row!= 0 && (grid[row][c] == ALIVE) ){//(1,3)
 cnt++;
 }
 if(row!= 0 && (grid[row+1][c] == ALIVE) ){//(2,3)
 cnt++;
 }
 if(row!= 0 && (grid[row-1][c] == ALIVE) ){//(0,3)
 cnt++;
 }
 }

 //center (2,1)
 if( row!=0 && col!=0 && row<r && col<c ){
 if(grid[row][col+1] == ALIVE){
 cnt++;
 }
 if(grid[row][col-1] == ALIVE){
 cnt++; 
 }
 if(grid[row+1][col] == ALIVE){
 cnt++;
 }
 if(grid[row-1][col] == ALIVE){
 cnt++;
 }

 //^ up, down, right, left
 //v crosses
 if(grid[row-1][col+1] == ALIVE){
 cnt++;
 }
 if(grid[row-1][col-1] == ALIVE){
 cnt++; 
 }
 if(grid[row+1][col+1] == ALIVE){
 cnt++;
 }
 if(grid[row+1][col-1] == ALIVE){
 cnt++;
 }
 }
 
 
 
 
 return cnt; // update this line, provided so that code compiles
}
 
 /**
 * Creates a new grid with the next generation of the current grid using 
 * the rules for Conway's Game of Life.
 * 
 * @return boolean[][] of new grid (this is a new 2D array)
 */
 public boolean[][] computeNewGrid () {
 int r = grid.length;
 int c = grid[0].length;
 boolean[][] copy = new boolean[r][c];
 

 // WRITE YOUR CODE HERE
 for (int i = 0; i < r; i++) {
 for (int j = 0; j < c; j++) {
 if( numOfAliveNeighbors(i,j) == 0 || numOfAliveNeighbors(i,j) == 1) {//rule 1
 copy[i][j] = DEAD;
 

 }
 if(numOfAliveNeighbors(i,j) == 3){ //rule 2
 copy[i][j] = ALIVE;
 }

 if(grid[i][j] == ALIVE){
 if( numOfAliveNeighbors(i,j)== 3 || numOfAliveNeighbors(i,j)== 2) {//rule 3
 copy[i][j] = ALIVE;
 }
 }

 if(numOfAliveNeighbors(i,j) >= 4){ //rule4
 copy[i][j] = DEAD;
 }

 
 }
 }

 
 
 return copy;// update this line, provided so that code compiles
 }

 /**
 * Updates the current grid (the grid instance variable) with the grid denoting
 * the next generation of cells computed by computeNewGrid().
 * 
 * Updates totalAliveCells instance variable
 */
 public void nextGeneration () {
 
 // WRITE YOUR CODE HERE
 grid = computeNewGrid();
 }

 /**
 * Updates the current grid with the grid computed after multiple (n) generations. 
 * @param n number of iterations that the grid will go through to compute a new grid
 */
 public void nextGeneration (int n) {

 // WRITE YOUR CODE HERE
 for(int i = 0; i<n; i++){
 grid = computeNewGrid();
 }
 
 }

 /**
 * Determines the number of separate cell communities in the grid
 * @return the number of communities in the grid, communities can be formed from edges
 */
 public int numOfCommunities() {
 int r = grid.length-1;
 int c = grid[0].length-1;

 WeightedQuickUnionUF cat = new WeightedQuickUnionUF(r+1, c+1);
 

 // WRITE YOUR CODE HERE
 
 for (int row = 0; row < (r+1); row++) {
 for (int col = 0; col < (c+1); col++) {


 //top left


 // if( (grid[row][col+1] == ALIVE)){ // (0,1)
 // cat.union(row, col, row, col+1);
 // }
 // if((grid[row+1][col] == ALIVE)){ //(1,0)
 // cat.union(row,col, row+1, col);
 
 // }
 // if((grid[row+1][col+1] == ALIVE)){//(1,1)
 // cat.union(row,col, row+1, col+1);
 
 // }
 // if( (grid[r][0] == ALIVE)){ //(3,0)
 // cat.union(row,col, r, 0);
 // }
 // if( (grid[r][1] == ALIVE)){//(3,1)
 // cat.union(row,col, r, 1);
 // }
 // if((grid[0][c] == ALIVE)){//(0,3)
 // cat.union(row,col, 0, c);
 // }
 // if((grid[1][c] == ALIVE)){//(1,3)
 // cat.union(row,col, 1, c);
 // }
 // if((grid[r][c] == ALIVE)){//(3,3)
 // cat.union(row,col, r, c);
 // }
 
 if(row==0 && col==0 && col<c){

 if( (grid[row][col+1] == ALIVE)){ // (0,1)
 cat.union(row, col, row, (col+1));
 }
 if((grid[row+1][col] == ALIVE)){ //(1,0)
 cat.union(row,col,(row+1),col);
 
 }
 if((grid[row+1][col+1] == ALIVE)){//(1,1)
 cat.union(row,col,(row+1),col+1);
 
 }
 if( (grid[r][0] == ALIVE)){ //(3,0)
 cat.union(row,col, grid.length-1,0);
 }
 if( (grid[r][1] == ALIVE)){//(3,1)
 cat.union(row,col,r,1);
 }
 if((grid[0][c] == ALIVE)){//(0,3)
 cat.union(row,col,0,c);
 }
 if((grid[1][c] == ALIVE)){//(1,3)
 cat.union(row,col,1,c);
 }
 if((grid[r][c] == ALIVE)){//(3,3)
 cat.union(row,col,r,c);
 }

 
 }
 
 
 
 //top right corner (0,3)
 if(row == 0 && col == c){
 
 if(row == 0 && col != 0 && (grid[row][col-1] == ALIVE)){//(0,2)
 cat.union(row,col,row,(col-1));
 } 

 
 if(row == 0 && col != 0 && (grid[row+1][col] == ALIVE)){//(1,3)
 cat.union(row,col,(row+1),col);
 }
 if(row == 0 && col != 0 && (grid[row+1][col-1] == ALIVE)){//(1,2)
 cat.union(row,col,row+1,col-1);
 }
 if(row == 0 && col != 0 && (grid[r][0] == ALIVE)){//(3,0)
 cat.union(row,col,r,0);

 }
 if(row == 0 && col != 0 && (grid[0][0] == ALIVE)){//(0,0)
 cat.union(row,col,0,0);

 }
 if(row == 0 && col != 0 && (grid[1][0] == ALIVE)){//(1,0)
 cat.union(row,col,1,0);

 }
 if(row == 0 && col != 0 && (grid[r][col-1] == ALIVE)){//(3,2)
 cat.union(row,col,r,(col-1));

 }
 if(row == 0 && col != 0 && (grid[r][c] == ALIVE)){//(3,3)
 cat.union(row,col,r,c);

 }
 }


 //bottom left corner (3,0)

 
 if(row == r && col == 0){

 if(row != 0 && col == 0 && (grid[row-1][0] == ALIVE)){ //(2,0)
 cat.union(row,col,(row-1),0);
 }
 if(row != 0 && col == 0 && (grid[row-1][1] == ALIVE)){//(2,1)
 cat.union(row,col,(row-1),1);
 //cat.union(r, c, r, c);
 }
 if(row != 0 && col == 0 && (grid[row][1] == ALIVE)){//(3,1)
 cat.union(row,col,row,1);
 }
 if(row != 0 && col == 0 && (grid[row-1][col] == ALIVE)){ //(2,3)
 cat.union(row,col,row-1,col);
 }
 if(row != 0 && col == 0 && (grid[row][col] == ALIVE)){ //(3,3)
 cat.union(row,col,row,col);
 }
 if(row != 0 && col == 0 && (grid[0][0] == ALIVE)){ //(0,0)
 cat.union(row,col,0,0);
 }
 if(row != 0 && col == 0 && (grid[0][1] == ALIVE)){//(0,1)
 cat.union(row,col,0,1);
 }
 if(row != 0 && col == 0 && (grid[0][c] == ALIVE)){//(0,3)
 cat.union(row,col,0,c);
 }

 }
 
 
 
 //bottom right corner (3,3)
 if(row == r && col==c ){
 if((grid[row-1][col-1] == ALIVE)){ //(2,2)
 cat.union(row,col,(row-1),(col-1));
 
 }
 if((grid[row-1][col] == ALIVE)){ //(2,3)
 cat.union(row,col,(row-1),col);
 
 }
 if((grid[row][col-1] == ALIVE)){ //(3,2)
 cat.union(row,col,row,(col-1));
 
 }
 if( (grid[0][col-1] == ALIVE)){ //(0,2)
 cat.union(row,col,0,(col-1));
 
 }
 if((grid[0][col] == ALIVE)){ //(0,3)
 cat.union(row,col,0,col);
 
 }
 if( (grid[row-1][0] == ALIVE)){ //(2,0)
 cat.union(row,col,(row-1),0);
 
 }
 if( (grid[row][0] == ALIVE)){ //(3,0)
 cat.union(row,col,row,0);
 
 }
 if( (grid[0][0] == ALIVE)){ //(0,0)
 cat.union(row,col,0,0);
 
 }
 }
 
 // // //top edge (0,1)
 if(row==0 && col!=0 && col!=c){
 
 if((grid[0][col-1] == ALIVE)){ //(0,0)
 cat.union(row,col,0,(col-1));
 }
 if((grid[0][col+1] == ALIVE)){ //(0,2)
 cat.union(row,col,0,(col+1));
 }
 if( (grid[row+1][col-1] == ALIVE)){//(1,0)
 cat.union(row,col,(row+1),(col-1));
 }
 if( (grid[row+1][col+1] == ALIVE)){//(1,2)
 cat.union(row,col,(row+1),(col+1));
 }
 if((grid[row+1][col] == ALIVE)){//(1,1)
 cat.union(row,col,(row+1),col);
 }
 if((grid[r][col-1] == ALIVE)){//(3,0)
 cat.union(row,col,r,(col-1));
 }
 if((grid[r][col] == ALIVE)){//(3,1)
 cat.union(row,col,r,col);
 }
 if((grid[r][col+1] == ALIVE)){//(3,2)
 cat.union(row,col,r,(col+1));
 }
 
 }
 
 
 // // // //bottom edge (3,2)
 if(col!=c && row == r){
 if( row!= 0 && col !=0 && (grid[row][col-1] == ALIVE) ){//(3,1)//left
 cat.union(row,col,row,(col-1));
 }
 
 if(row!= 0 && col !=0 && (grid[row][col+1] == ALIVE) ){//(3,3)//right
 cat.union(row,col,row,(col+1));
 }
 
 if(row!= 0 && col !=0 && (grid[row-1][col] == ALIVE) ){//(2,3)//above be
 cat.union(row,col,(row-1),col);
 }
 if(row!= 0 && col !=0 && (grid[row-1][col-1] == ALIVE) ){//(2,1)
 cat.union(row,col,(row-1),(col-1));
 }
 if(row!= 0 && col !=0 && (grid[row-1][col+1] == ALIVE) ){//(2,3)
 cat.union(row,col,(row-1),(col+1));
 }
 if(row!= 0 && col !=0 && (grid[0][col+1] == ALIVE) ){//(0,3)
 cat.union(row,col,0,(col+1));
 }
 if(row!= 0 && col !=0 && (grid[0][col-1] == ALIVE) ){//(0,2)
 cat.union(row,col,0,(col-1));
 }
 if(row!= 0 && col !=0 && (grid[0][col] == ALIVE) ){//(0,3)
 cat.union(row,col,0,col);
 }
 }
 
 // // // //right edge (1,3)
 
 if(row>0 && row<r && col==c){
 
 if(row!= 0 && col !=0 && (grid[row-1][col] == ALIVE) ){//(0,3)
 cat.union(row,col,(row-1),col);
 }
 if(row!= 0 && col !=0 && (grid[row+1][col] == ALIVE) ){//(2,3)
 cat.union(row,col,(row+1),col);
 }
 if(row!= 0 && col !=0 && (grid[row][col-1] == ALIVE) ){//(1,2)
 cat.union(row,col,row,(col-1));
 }
 if(row!= 0 && col !=0 && (grid[row-1][col-1] == ALIVE) ){//(0,2)
 cat.union(row,col,(row-1),(col-1));
 }
 if(row!= 0 && col !=0 && (grid[row+1][col-1] == ALIVE) ){//(2,2)
 cat.union(row,col,(row+1),(col-1));
 }
 if(row!= 0 && col !=0 && (grid[row][0] == ALIVE) ){//(1,0)
 cat.union(row,col,row,0);
 }
 if(row!= 0 && col !=0 && (grid[row+1][0] == ALIVE) ){//(2,0)
 cat.union(row,col,(row+1),0);
 }
 if(row!= 0 && col !=0 && (grid[row-1][0] == ALIVE) ){//(0,0)
 cat.union(row,col,(row-1),0);
 }
 }
 
 
 
 // // // //left edge (1,0)
 
 if(row<r && col==0 && row!=0){
 
 if(row!= 0 && (grid[row-1][col] == ALIVE) ){//(0,0)
 cat.union(row,col,(row-1),col);
 }
 if(row!= 0 && (grid[row+1][col] == ALIVE) ){//(2,0)
 cat.union(row,col,(row+1),col);
 }
 if(row!= 0 && (grid[row-1][col+1] == ALIVE) ){//(0,1)
 cat.union(row,col,(row-1),(col+1));
 }
 if(row!= 0 && (grid[row+1][col+1] == ALIVE) ){//(2,1)
 cat.union(row,col,(row+1),(col+1));
 }
 if(row!= 0 && (grid[row][col+1] == ALIVE) ){//(1,1)
 cat.union(row,col,row,(col+1));
 }
 if(row!= 0 && (grid[row][c] == ALIVE) ){//(1,3)
 cat.union(row,col,row,c);
 }
 if(row!= 0 && (grid[row+1][c] == ALIVE) ){//(2,3)
 cat.union(row,col,(row+1),c);
 }
 if(row!= 0 && (grid[row-1][c] == ALIVE) ){//(0,3)
 cat.union(row,col,(row-1),c);
 }
 }
 
 //center (2,1)
 if( row!=0 && col!=0 && row<r && col<c ){
 if(grid[row][col+1] == ALIVE){
 cat.union(row,col,row,(col+1));
 }
 if(grid[row][col-1] == ALIVE){
 cat.union(row,col,row,(col-1));
 }
 if(grid[row+1][col] == ALIVE){
 cat.union(row,col,(row+1),col);
 }
 if(grid[row-1][col] == ALIVE){
 cat.union(row,col,(row-1),col);
 }
 
 //^ up, down, right, left
 //v crosses
 if(grid[row-1][col+1] == ALIVE){
 cat.union(row,col,(row-1),(col+1));
 }
 if(grid[row-1][col-1] == ALIVE){
 cat.union(row,col,(row-1),(col-1));
 }
 if(grid[row+1][col+1] == ALIVE){
 cat.union(row,col,(row+1),(col+1));
 }
 if(grid[row+1][col-1] == ALIVE){
 cat.union(row,col,(row+1),(col-1));
 }
 }



 }
 
 
 }
 
 
 int counter = 0;

 int[] mid = new int [(r+1)*(c+1)];
 for (int row = 0; row < r+1; row++) {
 for (int col = 0; col < c+1; col++) {
    if(grid[row][col]!= DEAD){
        mid[cat.find(row, col)]++;
    }

 }
 }
 for (int x = 0; x < mid.length; x++) {
 if(mid[x]>1){
 counter++;
 }
 }
 return counter;



 }
 
 

 
 }





































// package conwaygame;
// import java.util.ArrayList;

// /**
//  * Conway's Game of Life Class holds various methods that will
//  * progress the state of the game's board through it's many iterations/generations.
//  *
//  * Rules 
//  * Alive cells with 0-1 neighbors die of loneliness.
//  * Alive cells with >=4 neighbors die of overpopulation.
//  * Alive cells with 2-3 neighbors survive.
//  * Dead cells with exactly 3 neighbors become alive by reproduction.

//  * @author Seth Kelley 
//  * @author Maxwell Goldberg
//  */
// public class GameOfLife {

//     // Instance variables
//     private static final boolean ALIVE = true;
//     private static final boolean  DEAD = false;

//     private boolean[][] grid;    // The board has the current generation of cells
//     private int totalAliveCells; // Total number of alive cells in the grid (board)

//     /**
//     * Default Constructor which creates a small 5x5 grid with five alive cells.
//     * This variation does not exceed bounds and dies off after four iterations.
//     */
//     public GameOfLife() {
//         grid = new boolean[5][5];
//         totalAliveCells = 5;
//         grid[1][1] = ALIVE;
//         grid[1][3] = ALIVE;
//         grid[2][2] = ALIVE;
//         grid[3][2] = ALIVE;
//         grid[3][3] = ALIVE;
//     }

//     /**
//     * Constructor used that will take in values to create a grid with a given number
//     * of alive cells
//     * @param file is the input file with the initial game pattern formatted as follows:
//     * An integer representing the number of grid rows, say r
//     * An integer representing the number of grid columns, say c
//     * Number of r lines, each containing c true or false values (true denotes an ALIVE cell)
//     */
//     public GameOfLife (String file) {

//         // WRITE YOUR CODE HERE
        
//         StdIn.setFile(file);
//         String firstIndex = StdIn.readLine();
//         String secondIndex = StdIn.readLine();
//         grid = new boolean[Integer.parseInt(firstIndex)][Integer.parseInt(secondIndex)];

//             String lines = StdIn.readLine();
//             int counter = 0;

//             while (lines != null){
//                 String newLine = "";
               
//                 for(int i = 0; i < lines.length(); i++ ){
//                     if(lines.substring(i, i+1).equals("f")){
//                         newLine += "false ";
//                     }
//                     else if(lines.substring(i, i+1).equals("t")){
//                         newLine += "true ";
//                         totalAliveCells++;
//                     }
//                 }


//                 String[] split = newLine.split(" ");

//                 for(int i = 0; i < grid[counter].length; i++){
//                     grid[counter][i] = Boolean.parseBoolean(split[i].trim());
//                 }

//                 counter++;
//                 lines = StdIn.readLine();

//             }        
        
//     }

//     /**
//      * Returns grid
//      * @return boolean[][] for current grid
//      */
//     public boolean[][] getGrid () {
//         return grid;
//     }
    
//     /**
//      * Returns totalAliveCells
//      * @return int for total number of alive cells in grid
//      */
//     public int getTotalAliveCells () {
//         return totalAliveCells;
//     }

//     /**
//      * Returns the status of the cell at (row,col): ALIVE or DEAD
//      * @param row row position of the cell
//      * @param col column position of the cell
//      * @return true or false value "ALIVE" or "DEAD" (state of the cell)
//      */
//     public boolean getCellState (int row, int col) {

//         // WRITE YOUR CODE HERE
//         return grid[row][col];
//     }

//     /**
//      * Returns true if there are any alive cells in the grid
//      * @return true if there is at least one cell alive, otherwise returns false
//      */
//     public boolean isAlive () {

//         // WRITE YOUR CODE HERE

//         return getTotalAliveCells() != 0; // update this line, provided so that code compiles
//     }

//     /**
//      * Determines the number of alive cells around a given cell.
//      * Each cell has 8 neighbor cells which are the cells that are 
//      * horizontally, vertically, or diagonally adjacent.
//      * 
//      * @param col column position of the cell
//      * @param row row position of the cell
//      * @return neighboringCells, the number of alive cells (at most 8).
//      */
//     public int numOfAliveNeighbors (int row, int col) {

//         // WRITE YOUR CODE HERE

//         int numAliveNeighbors = 0;

//         //CHECKING IF TOP LEFT CORNER SELECTED
//         if(row == 0 && col==0){

//         if(grid[0][1] == ALIVE){
//             numAliveNeighbors++;
//         }
//         if(grid[1][0] == ALIVE){
//             numAliveNeighbors++;
//         }
//         if(grid[1][1] == ALIVE){
//             numAliveNeighbors++;
//         }

        
//         if(grid[0][grid[0].length-1] == ALIVE){
//             numAliveNeighbors++;
//         }
//         if(grid[1][grid[0].length-1] == ALIVE){
//             numAliveNeighbors++;
//         }

//         if(grid[grid.length-1][0] == ALIVE){
//             numAliveNeighbors++;
//         }
//         if(grid[grid.length-1][1] == ALIVE){
//             numAliveNeighbors++;
//         }


//         if(grid[grid.length-1][grid[0].length-1] == ALIVE){
//             numAliveNeighbors++;
//         }
            
//         }

//         //CHECKING IF BOTTOM RIGHT CORNER SELECTED
//         else if(row == grid.length-1 && col==grid[0].length - 1){

//             if(grid[row][col - 1] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if(grid[row - 1][col] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if(grid[row - 1][col - 1] == ALIVE){
//                 numAliveNeighbors++;
//             }
    
            
//             if(grid[0][col] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if(grid[0][col - 1] == ALIVE){
//                 numAliveNeighbors++;
//             }
    
//             if(grid[row][0] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if(grid[row-1][0] == ALIVE){
//                 numAliveNeighbors++;
//             }
    
    
//             if(grid[0][0] == ALIVE){
//                 numAliveNeighbors++;
//             }
                
//         }

//         //CHECKING IF BOTTOM LEFT CORNER SELECTED
//         else if (row == grid.length-1 && col == 0){


//             if(grid[row][col + 1] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if(grid[row - 1][col] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if(grid[row - 1][col + 1] == ALIVE){
//                 numAliveNeighbors++;
//             }
    
            
//             if(grid[0][col] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if(grid[0][col + 1] == ALIVE){
//                 numAliveNeighbors++;
//             }
    
//             if(grid[row][grid[row].length - 1] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if(grid[row-1][grid[row].length - 1] == ALIVE){
//                 numAliveNeighbors++;
//             }
    
    
//             if(grid[0][grid[0].length - 1] == ALIVE){
//                 numAliveNeighbors++;
//             }

//         }

//         //CHECKING IF TOP RIGHT CORNER SELECTED
//         else if (row == 0 && col == grid[0].length - 1){

//             if(grid[row][col - 1] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if(grid[row + 1][col] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if(grid[row + 1][col - 1] == ALIVE){
//                 numAliveNeighbors++;
//             }
    
            
//             if(grid[row][0] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if(grid[row + 1][0] == ALIVE){
//                 numAliveNeighbors++;
//             }
    

//             if(grid[grid.length-1][col] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if(grid[grid.length-1][col - 1] == ALIVE){
//                 numAliveNeighbors++;
//             }
    
    
//             if(grid[grid.length-1][0] == ALIVE){
//                 numAliveNeighbors++;
//             }
            
//         }


//         //CHECKING IF LOCATION IS ON TOP EDGE
//         else if( row == 0){
            
//             if( grid[row][col+1] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if( grid[row][col-1] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if( grid[row+1][col] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if( grid[row+1][col+1] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if( grid[row+1][col-1] == ALIVE){
//                 numAliveNeighbors++;
//             }

//             if( grid[grid.length - 1][col] == ALIVE){
//                 numAliveNeighbors++;
//             }

//             if( grid[grid.length - 1][col + 1] == ALIVE){
//                 numAliveNeighbors++;
//             }

//             if( grid[grid.length - 1][col - 1] == ALIVE){
//                 numAliveNeighbors++;
//             }


//         }

//         //CHECKING IF LOCATION IS ON BOTTOM EDGE
//         else if (row == grid.length - 1){
//             if( grid[row][col+1] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if( grid[row][col-1] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if( grid[row-1][col] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if( grid[row-1][col+1] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if( grid[row-1][col-1] == ALIVE){
//                 numAliveNeighbors++;
//             }

//             if( grid[0][col] == ALIVE){
//                 numAliveNeighbors++;
//             }

//             if( grid[0][col + 1] == ALIVE){
//                 numAliveNeighbors++;
//             }

//             if( grid[0][col - 1] == ALIVE){
//                 numAliveNeighbors++;
//             }
//         }

//         //CHECKING IF THE LOCATION IS ON RIGHT EDGE
//         else if (col == grid[0].length - 1){
//             if (grid[row-1][col] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if (grid[row+1][col] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if (grid[row-1][col-1] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if (grid[row][col-1] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if (grid[row+1][col-1] == ALIVE){
//                 numAliveNeighbors++;
//             }


//             if (grid[row][0] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if (grid[row-1][0] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if (grid[row+1][0] == ALIVE){
//                 numAliveNeighbors++;
//             }
            
//         }

//         //CHECKING IF THE LOCATION IS ON THE LEFT EDGE
//         else if (col == 0){
//             if (grid[row-1][col] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if (grid[row+1][col] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if (grid[row-1][col+1] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if (grid[row][col+1] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if (grid[row+1][col+1] == ALIVE){
//                 numAliveNeighbors++;
//             }


//             if (grid[row][grid[0].length - 1] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if (grid[row-1][grid[0].length - 1] == ALIVE){
//                 numAliveNeighbors++;
//             }
//             if (grid[row+1][grid[0].length - 1] == ALIVE){
//                 numAliveNeighbors++;
//             }
            
//         }


//         //CHECKING IF ANY MIDDLE LOCATION IS SELECTED
//         else{
//         //CHECKING ABOVE THE SPECIFIED LOCATION
//         if(grid[row-1][col] == ALIVE){
//             numAliveNeighbors++;
//         }
//         if(grid[row-1][col+1] == ALIVE){
//             numAliveNeighbors++;
//         }
//         if(grid[row-1][col-1] == ALIVE){
//             numAliveNeighbors++;
//         }

//         //CHECKING NEXT TO THE SPECIFIED LOCATION
//         if(grid[row+1][col] == ALIVE){
//             numAliveNeighbors++;
//         }
//         if(grid[row+1][col+1] == ALIVE){
//             numAliveNeighbors++;
//         }
//         if(grid[row+1][col-1] == ALIVE){
//             numAliveNeighbors++;
//         }
        
//         //CHECKING NEXT TO THE LOCATION
//         if(grid[row][col-1] == ALIVE){
//             numAliveNeighbors++;
//         }
//         if(grid[row][col+1] == ALIVE){
//             numAliveNeighbors++;
//         }


//     }


//         return numAliveNeighbors; 
//     }

//     /**
//      * Creates a new grid with the next generation of the current grid using 
//      * the rules for Conway's Game of Life.
//      * 
//      * @return boolean[][] of new grid (this is a new 2D array)
//      */
//     public boolean[][] computeNewGrid () {

//         // WRITE YOUR CODE HERE
//         boolean[][] newGrid = new boolean[grid.length][grid[0].length];

//         for(int i = 0; i < grid.length; i ++){
//             for (int j = 0; j < grid[i].length; j++){

//                 if (numOfAliveNeighbors(i, j) <= 1){
//                     newGrid[i][j] = DEAD;
//                 }
//                 else if (numOfAliveNeighbors(i, j) == 3 && grid[i][j] == DEAD ){
//                     newGrid[i][j] = ALIVE;
//                 }
//                 else if((numOfAliveNeighbors(i, j) == 2 || numOfAliveNeighbors(i, j) == 3)  && grid[i][j] == ALIVE){
//                     newGrid[i][j] = ALIVE;
//                 }
//                 else if (numOfAliveNeighbors(i, j) >=4 && grid[i][j] == ALIVE){
//                     newGrid[i][j] = DEAD;
//                 }


//             }

//         }

//         return newGrid;
//     }

//     /**
//      * Updates the current grid (the grid instance variable) with the grid denoting
//      * the next generation of cells computed by computeNewGrid().
//      * 
//      * Updates totalAliveCells instance variable
//      */
//     public void nextGeneration () {

//         // WRITE YOUR CODE HERE

//         int counter = 0;
       

//         grid = computeNewGrid();

//         for(boolean[] x : grid){
//             for(boolean y : x){
//                 if (y){
//                     counter++;
//                 }
//             }

//         }

//         totalAliveCells = counter;



//     }

//     /**
//      * Updates the current grid with the grid computed after multiple (n) generations. 
//      * @param n number of iterations that the grid will go through to compute a new grid
//      */
//     public void nextGeneration (int n) {

//         // WRITE YOUR CODE HERE

//         for(int i = 0 ; i < n ; i++){
//             nextGeneration();
//         }
//     }

//     /**
//      * Determines the number of separate cell communities in the grid
//      * @return the number of communities in the grid, communities can be formed from edges
//      */
//     public int numOfCommunities() {

//         // WRITE YOUR CODE HERE

//         WeightedQuickUnionUF communities = new WeightedQuickUnionUF(grid.length, grid[0].length);
//         int max = 0 ;
//         int[] counter ;
//         int numCommunities = 0;

//         for(int row = 0; row < grid.length; row++){
//             for (int col = 0; col < grid[row].length; col++){
//                 if (grid[row][col] == ALIVE){



//                     //CHECKING IF TOP LEFT CORNER SELECTED
//                     if(row == 0 && col==0){

//                     if(grid[0][1] == ALIVE){
//                         communities.union(row, col, row, col+1);
//                     }
//                     if(grid[1][0] == ALIVE){
//                         communities.union(row, col, row+1, col);
//                     }
//                     if(grid[1][1] == ALIVE){
//                         communities.union(row, col, row+1, col+1);
//                     }
            
                    
//                     if(grid[0][grid[0].length-1] == ALIVE){
//                         communities.union(row, col, row, grid[0].length-1);
//                     }

//                     if(grid[1][grid[0].length-1] == ALIVE){
//                         communities.union(row, col, row+1, grid[0].length-1);
//                     }
            
//                     if(grid[grid.length-1][0] == ALIVE){
//                         communities.union(row, col, grid.length - 1, col);
//                     }
//                     if(grid[grid.length-1][1] == ALIVE){
//                         communities.union(row, col, grid.length - 1, col+1);
//                     }
            
            
//                     if(grid[grid.length-1][grid[0].length-1] == ALIVE){
//                         communities.union(row, col, grid.length-1, grid[row].length - 1);
//                     }
                        
//                     }
            
//                     //CHECKING IF BOTTOM RIGHT CORNER SELECTED
//                     else if(row == grid.length-1 && col==grid[grid.length-1].length - 1){
            
//                         if(grid[row][col - 1] == ALIVE){
//                             communities.union(row, col, row, col-1);
//                         }
//                         if(grid[row - 1][col] == ALIVE){
//                             communities.union(row, col, row-1, col);
//                         }
//                         if(grid[row - 1][col - 1] == ALIVE){
//                             communities.union(row, col, row-1,col-1);
//                         }
                
                        
//                         if(grid[0][col] == ALIVE){
//                             communities.union(row, col, 0, col);
//                         }
//                         if(grid[0][col - 1] == ALIVE){
//                             communities.union(row, col, 0, col);
//                         }
                
//                         if(grid[row][0] == ALIVE){
//                             communities.union(row, col, row, 0);
//                         }
//                         if(grid[row-1][0] == ALIVE){
//                             communities.union(row, col, row-1, 1);
//                         }
                
                
//                         if(grid[0][0] == ALIVE){
//                             communities.union(row, col, 0, 0);
//                         }
                            
//                     }
            
//                     //CHECKING IF BOTTOM LEFT CORNER SELECTED
//                     else if (row == grid.length-1 && col == 0){
    
    
//                 if(grid[row][col + 1] == ALIVE){
//                     communities.union(row, col, row, col + 1 );
//                 }
//                 if(grid[row - 1][col] == ALIVE){
//                     communities.union(row, col, row - 1, col );
//                 }
//                 if(grid[row - 1][col + 1] == ALIVE){
//                     communities.union(row, col, row - 1, col + 1 );
//                 }
        
                
//                 if(grid[0][col] == ALIVE){
//                     communities.union(row, col, 0, col);
//                 }
//                 if(grid[0][col + 1] == ALIVE){
//                     communities.union(row, col, 0, col + 1 );
//                 }
        
//                 if(grid[row][grid[row].length - 1] == ALIVE){
//                     communities.union(row, col, row, grid[row].length - 1 );
//                 }
//                 if(grid[row-1][grid[row].length - 1] == ALIVE){
//                     communities.union(row, col, row - 1, grid[row].length - 1);
//                 }
        
        
//                 if(grid[0][grid[0].length - 1] == ALIVE){
//                     communities.union(row, col, 0, grid[row].length - 1 );
//                 }
    
//             }
    
//                     //CHECKING IF TOP RIGHT CORNER SELECTED
//                     else if (row == 0 && col == grid[0].length - 1){
    
//                 if(grid[row][col - 1] == ALIVE){
//                     communities.union(row, col, row, col - 1 );
//                 }
//                 if(grid[row + 1][col] == ALIVE){
//                     communities.union(row, col, row+1, col );
//                 }
//                 if(grid[row + 1][col - 1] == ALIVE){
//                     communities.union(row, col, row+1, col - 1 );
//                 }
        
                
//                 if(grid[row][0] == ALIVE){
//                     communities.union(row, col, row, 0 );
//                 }
//                 if(grid[row + 1][0] == ALIVE){
//                     communities.union(row, col, row + 1, 0 );
//                 }
        
    
//                 if(grid[grid.length-1][col] == ALIVE){
//                     communities.union(row, grid.length - 1, row, col );
//                 }
//                 if(grid[grid.length-1][col - 1] == ALIVE){
//                     communities.union(row, col, grid.length - 1, col -1 );
//                 }
        
        
//                 if(grid[grid.length-1][0] == ALIVE){
//                     communities.union(row, col, grid.length - 1, 0 );
//                 }
                
//             }
    
    
//                     //CHECKING IF LOCATION IS ON TOP EDGE
//                     else if( row == 0){
                        
//                         if( grid[row][col+1] == ALIVE){
//                             communities.union(row, col, row, col + 1 );
//                         }
//                         if( grid[row][col-1] == ALIVE){
//                             communities.union(row, col, row, col - 1 );
//                         }
//                         if( grid[row+1][col] == ALIVE){
//                             communities.union(row, col, row+1, col  );
//                         }
//                         if( grid[row+1][col+1] == ALIVE){
//                             communities.union(row, col, row + 1, col + 1 );
//                         }
//                         if( grid[row+1][col-1] == ALIVE){
//                             communities.union(row, col, row + 1, col - 1 );
//                         }
            
//                         if( grid[grid.length - 1][col] == ALIVE){
//                             communities.union(row, col, grid.length - 1, col );
//                         }
            
//                         if( grid[grid.length - 1][col + 1] == ALIVE){
//                             communities.union(row, col, grid.length - 1, col + 1);
//                         }
            
//                         if( grid[grid.length - 1][col - 1] == ALIVE){
//                             communities.union(row, col, grid.length - 1, col - 1 );
//                         }
            
            
//                     }
            
//                     //CHECKING IF LOCATION IS ON BOTTOM EDGE
//                     else if (row == grid.length - 1){
//                 if( grid[row][col+1] == ALIVE){
//                     communities.union(row, col, row, col +1);
//                 }
//                 if( grid[row][col-1] == ALIVE){
//                     communities.union(row, col, row, col - 1);
//                 }
//                 if( grid[row-1][col] == ALIVE){
//                     communities.union(row, col, row -1, col );
//                 }
//                 if( grid[row-1][col+1] == ALIVE){
//                     communities.union(row, col, row - 1, col + 1);
//                 }
//                 if( grid[row-1][col-1] == ALIVE){
//                     communities.union(row, col, row-1, col -1);
//                 }
    
//                 if( grid[0][col] == ALIVE){
//                     communities.union(row, col, 0, col );
//                 }
    
//                 if( grid[0][col + 1] == ALIVE){
//                     communities.union(row, col, 0, col +1);
//                 }
    
//                 if( grid[0][col - 1] == ALIVE){
//                     communities.union(row, col, 0, col - 1);
//                 }
//             }
    
//                     //CHECKING IF THE LOCATION IS ON RIGHT EDGE
//                     else if (col == grid[0].length - 1){
//                         if (grid[row-1][col] == ALIVE){
//                             communities.union(row, col, row-1, col);
//                         }
//                         if (grid[row+1][col] == ALIVE){
//                             communities.union(row, col, row+1, col);
//                         }
//                         if (grid[row-1][col-1] == ALIVE){
//                             communities.union(row, col, row-1, col-1);
//                         }
//                         if (grid[row][col-1] == ALIVE){
//                             communities.union(row, col, row, col-1);
//                         }
//                         if (grid[row+1][col-1] == ALIVE){
//                             communities.union(row, col, row+1, col-1 );
//                         }
            
            
//                         if (grid[row][0] == ALIVE){
//                             communities.union(row, col, row, 0);
//                         }
//                         if (grid[row-1][0] == ALIVE){
//                             communities.union(row, col, row-1, 0);
//                         }
//                         if (grid[row+1][0] == ALIVE){
//                             communities.union(row, col, row+1, 0);
//                         }
                        
//                     }
            
//                     //CHECKING IF THE LOCATION IS ON THE LEFT EDGE
//                     else if (col == 0){
//                 if (grid[row-1][col] == ALIVE){
//                     communities.union(row, col, row-1, col);
//                 }
//                 if (grid[row+1][col] == ALIVE){
//                     communities.union(row, col, row+1, col);
//                 }
//                 if (grid[row-1][col+1] == ALIVE){
//                     communities.union(row, col, row-1, col+1);
//                 }
//                 if (grid[row][col+1] == ALIVE){
//                     communities.union(row, col, row, col+1);
//                 }
//                 if (grid[row+1][col+1] == ALIVE){
//                     communities.union(row, col, row+1, col+1);
//                 }
    
    
//                 if (grid[row][grid[0].length - 1] == ALIVE){
//                     communities.union(row, col, row, grid[0].length - 1);
//                 }
//                 if (grid[row-1][grid[0].length - 1] == ALIVE){
//                     communities.union(row, col, row-1, grid[0].length - 1);
//                 }
//                 if (grid[row+1][grid[0].length - 1] == ALIVE){
//                     communities.union(row, col, row+1, grid[0].length - 1);
//                 }
                
//             }
    
    
//                     //CHECKING IF ANY MIDDLE LOCATION IS SELECTED
//                     else{
//             //CHECKING ABOVE THE SPECIFIED LOCATION
//             if(grid[row-1][col] == ALIVE){
//                 communities.union(row, col, row-1, col);
//             }
//             if(grid[row-1][col+1] == ALIVE){
//                 communities.union(row, col, row-1, col+1);
//             }
//             if(grid[row-1][col-1] == ALIVE){
//                 communities.union(row, col, row-1, col-1);
//             }
    
//             //CHECKING BELOW TO THE SPECIFIED LOCATION
//             if(grid[row+1][col] == ALIVE){
//                 communities.union(row, col, row+1, col);
//             }
//             if(grid[row+1][col+1] == ALIVE){
//                 communities.union(row, col, row+1, col+1);
//             }
//             if(grid[row+1][col-1] == ALIVE){
//                 communities.union(row, col, row+1, col-1);
//             }
            
//             //CHECKING NEXT TO THE LOCATION
//             if(grid[row][col-1] == ALIVE){
//                 communities.union(row, col, row, col-1);
//             }
//             if(grid[row][col+1] == ALIVE){
//                 communities.union(row, col, row-1, col+1);
//             }
    
    
//         }
    
                    
                   
                    
//                 }
//             }
//         }

       

//         for (int i = 0; i < grid.length; i++){
//             for (int j = 0; j < grid[i].length; j++){
//                 if (communities.find(i, j) > max){
//                     max = communities.find(i, j);
//                 }
//             }

//         }

//         counter = new int[max+1];

        

//         for (int i = 0; i < grid.length; i++){
//             for (int j = 0; j < grid[i].length; j++){
//                 if(grid[i][j] != DEAD){
//                     counter[communities.find(i, j)] ++;
//                 }
                
//             }

//         }

//         for (int i = 0 ; i < counter.length; i++){
//             if (counter[i] != 0){
//                 numCommunities++;
//             }

//         }





//         return numCommunities; 
//     }
// }
