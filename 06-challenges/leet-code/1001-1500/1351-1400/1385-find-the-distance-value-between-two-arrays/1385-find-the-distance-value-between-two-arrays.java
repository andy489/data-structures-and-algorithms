// https://leetcode.com/problems/find-the-distance-value-between-two-arrays/

// Solution: Sort + Binary Search — O((m+n) log n) time, O(1) space
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int v : arr1) {
            int lo = lowerBound(arr2, v - d), hi = upperBound(arr2, v + d);
            if (lo >= hi) count++;
        }
        return count;
    }
    private int lowerBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) { int mid=(lo+hi)/2; if(arr[mid]<target) lo=mid+1; else hi=mid; }
        return lo;
    }
    private int upperBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) { int mid=(lo+hi)/2; if(arr[mid]<=target) lo=mid+1; else hi=mid; }
        return lo;
    }
}
