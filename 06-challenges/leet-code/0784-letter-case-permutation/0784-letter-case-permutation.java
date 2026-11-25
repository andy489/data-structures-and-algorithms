// https://leetcode.com/problems/letter-case-permutation/

// Solution: Backtracking — O(2^L * n) time, O(2^L * n) space
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s.toCharArray(), 0, result);
        return result;
    }

    private void backtrack(char[] arr, int i, List<String> result) {
        if (i == arr.length) {
            result.add(new String(arr));
            return;
        }
        backtrack(arr, i + 1, result);
        if (Character.isLetter(arr[i])) {
            arr[i] ^= 32;
            backtrack(arr, i + 1, result);
            arr[i] ^= 32;
        }
    }
}
