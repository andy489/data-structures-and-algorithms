// https://leetcode.com/problems/check-if-n-and-its-double-exist/

// Solution: HashSet — O(n) time, O(n) space
class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int v : arr) {
            if (seen.contains(v*2) || (v%2==0 && seen.contains(v/2))) return true;
            seen.add(v);
        }
        return false;
    }
}
