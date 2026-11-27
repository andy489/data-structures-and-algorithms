// https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/

// Solution: Greedy Largest Fibonacci — O(log k) time, O(log k) space
class Solution {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> fibs = new ArrayList<>(Arrays.asList(1, 1));
        while (fibs.get(fibs.size()-1) < k)
            fibs.add(fibs.get(fibs.size()-1) + fibs.get(fibs.size()-2));
        int count = 0;
        for (int i = fibs.size()-1; i >= 0 && k > 0; i--)
            if (fibs.get(i) <= k) { k -= fibs.get(i); count++; }
        return count;
    }
}
