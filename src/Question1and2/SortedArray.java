package Question1and2;

import java.util.Arrays;

public class SortedArray {
    private int[] array;
    private int[] reversedArray;

    public SortedArray(int[] array) {
        this.array = array;
        this.reversedArray = new int[array.length];
        sorted();
        reversed();
    }

    public int[] sorted() {
        // empty input
        if (array.length == 0) return array;
        quicksortHelper(this.array, 0, this.array.length - 1);
        return this.array;
    }

    private void quicksortHelper(int[] array, int start, int end) {
        // base case
        if (start >= end) return;

        int pivotIndex = start;
        int leftIndex = start + 1;
        int rightIndex = end;

        while (rightIndex >= leftIndex) {
            // swap if left index is greater than pivot index AND right index is lesser than pivot index
            if (array[leftIndex] > array[pivotIndex] && array[rightIndex] < array[pivotIndex]) {
                swap(leftIndex, rightIndex);
            }

            if (array[leftIndex] <= array[pivotIndex]) leftIndex++;
            if (array[rightIndex] >= array[pivotIndex]) rightIndex--;
            // swap pivot and right index -> final position for that element
        }
        swap(pivotIndex, rightIndex);
        //find the smaller sub array to split the array into two
        boolean smallerSubArray = rightIndex - 1 - start < end - (rightIndex + 1);
        // perform quicksort on the smaller array
        if (smallerSubArray) {
            quicksortHelper(this.array, start, rightIndex - 1);
            quicksortHelper(this.array, rightIndex + 1, end);
        } else {
            quicksortHelper(this.array, rightIndex + 1, end);
            quicksortHelper(this.array, start, rightIndex - 1);
        }

    }

    private void swap(int leftIndex, int rightIndex) {
        int temp = this.array[rightIndex];
        this.array[rightIndex] = this.array[leftIndex];
        this.array[leftIndex] = temp;
    }

    public int[] reversed() {
        // reverse list using two pointers
        if (reversedArray.length == 0) return reversedArray;
        int leftIndex = 0;
        int rightIndex = reversedArray.length -1;
        while (leftIndex<=rightIndex){
            int temp = this.array[leftIndex];
            this.reversedArray[leftIndex] = this.array[rightIndex];
            this.reversedArray[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
        return reversedArray;
    }

    @Override
    public String toString() {
        return "The sorted array is: " + Arrays.toString(array) +" \nThe reversed array is: " + Arrays.toString(reversedArray)  ;
    }

    //getters and setters
    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] getReversedArray() {
        return reversedArray;
    }

    public void setReversedArray(int[] reversedArray) {
        this.reversedArray = reversedArray;
    }
}

