// https://leetcode.com/problems/relative-sort-array/

// Solution: Custom Comparator with Rank Map — O(n log n) time, O(n) space
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> rank = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            rank.put(arr2[i], i);
        }
        Integer[] boxed = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            boxed[i] = arr1[i];
        }
        Arrays.sort(boxed, (a, b) -> {
            int ra = rank.getOrDefault(a, arr2.length + a);
            int rb = rank.getOrDefault(b, arr2.length + b);
            return ra - rb;
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = boxed[i];
        }
        return arr1;
    }
}

// Solution 2: Counting Sort — O(n + K) time, O(K) space
class Solution2 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int x : arr1) {
            count[x]++;
        }
        int idx = 0;
        for (int x : arr2) {
            while (count[x]-- > 0) {
                arr1[idx++] = x;
            }
        }
        boolean[] inArr2 = new boolean[1001];
        for (int x : arr2) {
            inArr2[x] = true;
        }
        for (int v = 0; v <= 1000; v++) {
            if (!inArr2[v]) {
                while (count[v]-- > 0) {
                    arr1[idx++] = v;
                }
            }
        }
        return arr1;
    }
}
