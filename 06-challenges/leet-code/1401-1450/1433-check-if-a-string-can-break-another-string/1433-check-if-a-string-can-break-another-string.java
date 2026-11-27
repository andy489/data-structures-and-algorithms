// https://leetcode.com/problems/check-if-a-string-can-break-another-string/

// Solution: Sort and Compare — O(n log n) time, O(n) space
class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] a = s1.toCharArray(), b = s2.toCharArray();
        Arrays.sort(a); Arrays.sort(b);
        boolean aGeB = true, bGeA = true;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[i]) aGeB = false;
            if (b[i] < a[i]) bGeA = false;
        }
        return aGeB || bGeA;
    }
}
