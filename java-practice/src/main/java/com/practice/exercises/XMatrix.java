package com.practice.exercises;

/**
 * Prints elements on the X of the input NxN matrix 'm'.  'm' is a 2D int array of square dimensions.
 * For example, if m = [[1, 2, 3], [4, 5, 6], [7, 8, 9]] then the X is [[1  3], [  5  ], [7  9]]
 * The output of the print function should then be "1,3,5,7,9"
 */
public class XMatrix {

    public String printX(int[][] input) {
        return calc(input);
    }

    private String calc(int[][] input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            sb.append(printRow(i, input[i]));
        }
        return sb.substring(0, sb.length() - 1);
    }

    private String printRow(int rowIndex, int[] row) {
        int colIndex1 = calculateFirstColIndex(rowIndex);
        int colIndex2 = calculateSecondColIndex(rowIndex, row);

        if (colIndex1 == colIndex2) {
            return row[colIndex1] + ",";
        } else if (colIndex1 > colIndex2) {
            return row[colIndex2] + "," + row[colIndex1] + ",";
        } else {
            return row[colIndex1] + "," + row[colIndex2] + ",";
        }
    }

    private int calculateFirstColIndex(int rowIndex) {
        return rowIndex;
    }

    private int calculateSecondColIndex(int rowIndex, int[] row) {
        return row.length - 1 - rowIndex;
    }
}
