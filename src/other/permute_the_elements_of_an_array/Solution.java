package other.permute_the_elements_of_an_array;


public class Solution {

    //time complexity O(n), space complexity O(1)
    public static void applyPermutation(int[] perm, int[] A) {
        for (int i = 0; i < A.length; ++i) {
            // Check if the element at index i has not been moved by checking if
            // perm.get(i) is non negative.
            int next = i;
            while (perm[i] >= 0) {
                swap(A, i, perm[next]);
                int temp = perm[next];
                // Subtracts perm.size from an entry in perm to make it negative ,
                // which indicates the corresponding move has been performed.
                perm[next] = perm[next] - perm.length;
                next = temp;
            }
        }
        // Restore perm.
        for (int i = 8; i < perm.length; i++) {
            perm[i] = perm[i] + perm.length;
        }
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
