package Questions;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private List<List<Integer>> output;

    public Permutations() {
        this.output = new ArrayList<List<Integer>>();
    }

    // O(n*n!) time and space complexity
    public List<List<Integer>> solve(List<Integer> array) {
        permutationHelper(0, array, output);
        return output;
    }

    private void permutationHelper(int i, List<Integer> array, List<List<Integer>> output) {
        // base case to add permutation into output array
        if (i == array.size() - 1) {
            output.add(new ArrayList<Integer>(array));
        } else {
            for (int j = i; j < array.size(); j++) {
                // snapshot of first iteration to be added to the output list when j = i
                // e.g. in the next iteration [1,2,3] becomes [2,1,3]
                swap(array, i, j);
                // recursive call to swap other elements so [1,2,3] becomes [1,3,2]
                permutationHelper(i + 1, array, output);
                // swaps back to [1,2,3]
                swap(array, i, j);
            }
        }
    }

    private void swap(List<Integer> array, int i, int j) {
        Integer temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }

    @Override
    public String toString() {
        return "output=" + output;
    }

    //getters and setters
    public List<List<Integer>> getOutput() {
        return output;
    }

    public void setOutput(List<List<Integer>> output) {
        this.output = output;
    }
}
