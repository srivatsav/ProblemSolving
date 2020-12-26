package com.stacks;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class MaximumRectangle {

    public static void main(String[] args) {

        char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };

        maximalRectangle(matrix);
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int output[] = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                output[j] = matrix[i][j] == '0' ? 0 : output[j] + 1;
            max = Math.max(max, Histogram(output));
        }
        return max;
    }

    static int Histogram(int output[]) {
        int left[] = findLeft(output);
        int right[] = findRight(output);
        int width[] = findWidth(left, right);
        int area[] = findArea(output, width);
        int maxArea = findMax(area);
        return maxArea;
    }

    static int[] findLeft(int arr[]) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        int temp[] = new int[arr.length];
        temp[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            if (stack.size() == 0)
                temp[i] = -1;
            else if (stack.size() > 0 && arr[stack.peek()] >= arr[i]) {
                while (stack.size() > 0 && arr[stack.peek()] >= arr[i])
                    stack.pop();
                temp[i] = stack.size() == 0 ? -1 : stack.peek();
            } else
                temp[i] = stack.peek();
            stack.push(i);
        }
        return temp;
    }

    static int[] findRight(int arr[]) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(arr.length - 1);
        int temp[] = new int[arr.length];
        temp[arr.length - 1] = arr.length;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.size() == 0)
                temp[i] = arr.length;
            else if (stack.size() > 0 && arr[stack.peek()] >= arr[i]) {
                while (stack.size() > 0 && arr[stack.peek()] >= arr[i])
                    stack.pop();
                temp[i] = stack.size() == 0 ? arr.length : stack.peek();
            } else
                temp[i] = stack.peek();
            stack.push(i);
        }
        Collections.reverse(Arrays.asList(temp));
        return temp;
    }

    static int[] findWidth(int left[], int right[]) {
        int temp[] = new int[left.length];
        for (int i = 0; i < left.length; i++)
            temp[i] = right[i] - left[i] - 1;
        return temp;
    }

    static int[] findArea(int arr[], int width[]) {
        int temp[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            temp[i] = arr[i] * width[i];
        return temp;
    }

    static int findMax(int area[]) {
        int max = 0;
        for (int i = 0; i < area.length; i++)
            max = Math.max(max, area[i]);
        return max;
    }

}