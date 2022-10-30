/*
Caroline Hsu - 10/20/2022
Given an even number of rows and columns, I calculate the maximum sum of the 
upper-left NxN submatrix by reversing the columns and rows.  

notes for trying to solve this: (somewhat pseudocode)
Following Thomas' method/guidance he gave in class:
Use corner method. Find the maximum of all the corners with math.max - 
- you cannot do math.max of more than 2  
- you can do the box method

1  2  3  4 
5  6  7  8
9  10 11 12
13 14 15 16
find max of 1, 4, 13, 16
find max of 2, 14, 15, 3
find max of 5, 9, 8, 12
find max of 6, 7, 10, 11
add them up
get sum
 */
package matrixquadrant;

public class MatrixQuadrant
{

  public static void main(String[] args)
  {
    // declare matrix
    int n = 2; // for 2n
    int r = 2*n;
    int c = 2*n;
    int[][] matrix = new int[r][c];
    int sum = 0;
    
    // insert matrix values (this is very inefficient oops)
    matrix[0][0] = 112;
    matrix[0][1] = 42;
    matrix[0][2] = 83;
    matrix[0][3] = 119;
    matrix[1][0] = 56;
    matrix[1][1] = 125;
    matrix[1][2] = 56;
    matrix[1][3] = 49;
    matrix[2][0] = 58;
    matrix[2][1] = 78;
    matrix[2][2] = 101;
    matrix[2][3] = 43;
    matrix[3][0] = 62;
    matrix[3][1] = 98;
    matrix[3][2] = 114;
    matrix[3][3] = 108;
    
    // print out regular matrix and calculated max sum of upper left quadrant
    System.out.println("Regular matrix:");
    printArray(matrix);
    sum = maxSum(matrix);
    System.out.println("The maximum sum of the upper left quadrant: " + sum);
  }
  
  // print array method in square shape
  public static void printArray(int[][] matrix)
  {
    // loops to loop through the rows and columns
    for (int r = 0; r < matrix.length; r++)
    {
      for (int c = 0; c < matrix[0].length; c++)
      {
        // minimum width of 5 spaces to align every entry
        // %- for print f right justifies, % left justifies for print f
        System.out.printf("%-5d", matrix[r][c]);
      }
      // new line for 5x5 2d array after every row
      System.out.print("\n");
    }
  }
  
  // return an int to main method to print sum
  public static int maxSum(int [][] matrix)
  {
    // declare necessary variables for the max sum method
    int sum = 0;
    int rowLength = matrix.length;
    int columnLength = matrix[0].length;
    // n row/column length would be 3-1 = 2 in this scenario (which would go to 1 bc 
    // you start counting with 0
    int nRowLength = rowLength - 1;
    int nColumnLength = columnLength - 1;
    // calculate the corners max bc math.max is only with two values
    int corners1 = 0;
    int corners2 = 0;
    int compare = 0;
    
    // loops to loop through the rows and column
    for (int r = 0; r < rowLength / 2; r++)
    {
      for (int c = 0; c < columnLength / 2; c++)
      {
        // ex. find the max of two corners and find the max of two other corners
        // and find the max of both and add it to sum - use the corners for each
        corners1 = Math.max(matrix[r][c], matrix[nRowLength - r][nColumnLength - c]);
        corners2 = Math.max(matrix[nRowLength - r][c], matrix[r][nColumnLength - c]);
        compare = Math.max(corners1, corners2);
        // calculate the sum of the max from the corner
        sum = sum + compare;
      }
    }
    // return the sum to the main method
    return sum;
  }
  
}
