package com.practice.exercises;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class XMatrixTest {

    @Test
    void printX_3x3Matrix_isOk() {
        int[][] testData = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        String output = new XMatrix().printX(testData);

        assertThat(output).isEqualTo("1,3,5,7,9");
    }

    @Test
    void printX_4x4Matrix_isOk() {
        int[][] testData = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        String output = new XMatrix().printX(testData);

        assertThat(output).isEqualTo("1,4,6,7,10,11,13,16");
    }
}