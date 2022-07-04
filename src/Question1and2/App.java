package Question1and2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {

        // Question 1 Permutations
        Permutations permutations = new Permutations();
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        // size should be n!
        System.out.println(permutations.solve(input).size());
        ;
        System.out.println(permutations.getOutput());

        //Question 2 SortedArray
        int[] nums = {3453, 512, 12, 562462, 36, 432, 5, 8, 999};
        SortedArray numbers = new SortedArray(nums);
        System.out.println(numbers);
        nums[2] = 3;
        nums[3] = 23582105;
        System.out.println(Arrays.toString(numbers.sorted()));
        SortedArray arr = new SortedArray(new int[]{4, 2, 1, 3, 4, 6, 7});
        System.out.println(arr);


    }
}
