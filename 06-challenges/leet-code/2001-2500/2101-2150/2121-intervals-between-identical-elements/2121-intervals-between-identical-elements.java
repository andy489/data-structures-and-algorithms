// https://leetcode.com/problems/intervals-between-identical-elements/
class Solution {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        long[] result = new long[n];
        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indices.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        for (List<Integer> group : indices.values()) {
            int k = group.size();
            long[] prefix = new long[k + 1];
            for (int j = 0; j < k; j++) {
                prefix[j + 1] = prefix[j] + group.get(j);
            }
            long total = prefix[k];
            for (int j = 0; j < k; j++) {
                long idx = group.get(j);
                long left = idx * j - prefix[j];
                long right = (total - prefix[j + 1]) - idx * (k - j - 1);
                result[group.get(j)] = left + right;
            }
        }
        return result;
    }
}
