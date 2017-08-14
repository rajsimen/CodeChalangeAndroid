package mobile.android.codechalangeandroid.utils;


import java.util.Arrays;

import mobile.android.codechalangeandroid.model.Output;

public class LeastCostPath {

    public LeastCostPath(){

    }
    /*public static void main(String[] args) {
//        int[][] grid = {{3, 4, 1, 2, 8, 6},
//                        {6, 1, 8, 2, 7, 4},
//                        {5, 9, 3, 9, 9, 5},
//                        {8, 4, 1, 3, 2, 6},
//                        {3, 7, 2, 8, 6, 4}};
//        int[][] grid = {{3, 4, 1, 2, 8, 6},
//                        {6, 1, 8, 2, 7, 4},
//                        {5, 9, 3, 9, 9, 5},
//                        {8, 4, 1, 3, 2, 6},
//                        {3, 7, 2, 1, 2, 3}};
//        int[][] grid = {{ 6,  3, -5,  9},
//                        {-5,  2,  4, 10},
//                        { 3, -2,  6, 10},
//                        { 6, -1, -2, 10}};
//        int[][] grid = {{19, 10, 19, 10, 19},
//                        {21, 23, 20, 19, 12},
//                        {20, 12, 20, 11, 10}};
        int[][] grid = {{68},
                        {67},
                        {69}};
        
        LeastCostPath lcp = new LeastCostPath();
        Output o = lcp.findLeastCostPath(grid);
        
        System.out.println(OutputPresenter.toString(o));
    }*/
    
    public Output findLeastCostPath(int[][] grid) {
        int numberOfRows = grid.length;
        int numberOfColumns = 0;
        
        if (numberOfRows > 0) {
            numberOfColumns = grid[0].length;
        }
        
        int leastCost = Integer.MAX_VALUE;
        int leastCostRowIndex = -1;
        int leastCostColumnIndex = -1;
        
        int leastCostInColumn = Integer.MAX_VALUE;
        int leastCostRowIndexInColumn = -1;
        
        final int limitSum = 50;
        int minimumSum;
        int totalSum;
        
        // copy column '0' values as it is
        int sum[][] = new int[numberOfRows][numberOfColumns];
        for (int rowIndex=0; rowIndex<numberOfRows; rowIndex++) {
            totalSum = grid[rowIndex][0];
            
            if (totalSum > limitSum) {
                totalSum = Integer.MAX_VALUE;
            }

            // Check for the 0 Column
            sum[rowIndex][0] = totalSum;
            
            if (totalSum < leastCostInColumn) {
                leastCostInColumn = totalSum;
                leastCostRowIndexInColumn = rowIndex;
            }
        }
        
        if (leastCostRowIndexInColumn > -1) {
            leastCost = leastCostInColumn;
            leastCostRowIndex = leastCostRowIndexInColumn;
            leastCostColumnIndex = 0;
            
            for (int columnIndex=1; columnIndex<numberOfColumns; columnIndex++) {
                leastCostInColumn = Integer.MAX_VALUE;
                leastCostRowIndexInColumn = -1;
                // find the smallest value column wise
                for (int rowIndex=0; rowIndex<numberOfRows; rowIndex++) {
                    minimumSum = min(sum[getWrappedRowOrColumnIndex(rowIndex-1,numberOfRows)][columnIndex-1],
                                     sum[getWrappedRowOrColumnIndex(rowIndex,numberOfRows)][columnIndex-1],
                                     sum[getWrappedRowOrColumnIndex(rowIndex+1,numberOfRows)][columnIndex-1]);
                    
                    if (minimumSum == Integer.MAX_VALUE) {
                        sum[rowIndex][columnIndex] = totalSum = Integer.MAX_VALUE;
                    } else {
                        totalSum = grid[rowIndex][columnIndex] + minimumSum;
                        
                        if (totalSum > limitSum) {
                            totalSum = Integer.MAX_VALUE;
                        }
                        
                        sum[rowIndex][columnIndex] = totalSum;
                    }
                    
                    if (totalSum < leastCostInColumn) {
                        leastCostInColumn = totalSum;
                        leastCostRowIndexInColumn = rowIndex;
                    }
                }
                
                if (leastCostRowIndexInColumn == -1) {
                    break;
                } else {
                    leastCost = leastCostInColumn;
                    leastCostRowIndex = leastCostRowIndexInColumn;
                    leastCostColumnIndex = columnIndex;
                }
            }
        }

        // Make indexes one-based
        int[] leastCostRows = getLeastCostPath(sum, leastCostRowIndex, leastCostColumnIndex);
        for (int rowIndex=0; rowIndex<leastCostRows.length; rowIndex++) {
            leastCostRows[rowIndex] = ++leastCostRows[rowIndex];
        }
        
        Output output = new Output((leastCostColumnIndex == (numberOfColumns - 1)),leastCost,leastCostRows);
        /*output.isPathComplete = (leastCostColumnIndex == (numberOfColumns - 1));
        output.leastCost = leastCost;
        output.leastCostRows = getLeastCostPath(sum, leastCostRowIndex, leastCostColumnIndex);*/
        
        return output;
    }
    
    private int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }
    
    private int getWrappedRowOrColumnIndex(int index, int count) {

        if (index == -1) {//index <= -1
            return count - 1;//count+index
        } else if (index == count) {//index>=count
            return 0;//index-count
        } else {
            return index;
        }
    }
    
    private int[] getLeastCostPath(int[][] sum, int leastCostRowIndex, int leastCostColumnIndex) {
        int leastCostRows[] = new int[leastCostColumnIndex+1];
        int numberOfRows = sum.length;
        
        if (leastCostColumnIndex > -1) {
            leastCostRows[leastCostColumnIndex] = leastCostRowIndex;
        }
        
        for (int columnIndex=leastCostColumnIndex-1; columnIndex>=0; columnIndex--) {
            int firstIndex = getWrappedRowOrColumnIndex(leastCostRowIndex-1, numberOfRows);
            int firstValue = sum[firstIndex][columnIndex];
            int secondIndex = getWrappedRowOrColumnIndex(leastCostRowIndex, numberOfRows);
            int secondValue = sum[secondIndex][columnIndex];
            int thirdIndex = getWrappedRowOrColumnIndex(leastCostRowIndex+1, numberOfRows);
            int thirdValue = sum[thirdIndex][columnIndex];
            
            if ((firstValue <= secondValue) && (firstValue <= thirdValue)) {
                leastCostRowIndex = firstIndex;
            } else if (secondValue <= thirdValue) {
                leastCostRowIndex = secondIndex;
            } else {
                leastCostRowIndex = thirdIndex;
            }
            
            leastCostRows[columnIndex] = leastCostRowIndex;
        }
        
        return leastCostRows;
    }
    
    /*static class Output {
        public boolean isPathComplete;
        public int leastCost;
        public int[] leastCostRows;
    }*/
    
    static class OutputPresenter {
        public static String toString(Output output) {
            // Make indexes one-based
            int[] leastCostRows = output.getPath().clone();
            for (int rowIndex=0; rowIndex<leastCostRows.length; rowIndex++) {
                leastCostRows[rowIndex] = ++leastCostRows[rowIndex];
            }
            
            return (output.isCompletePath() ? "Yes" : "No") + "\n" + output.getLowestPathCost() + "\n" + Arrays.toString(leastCostRows);
        }
    }
}
