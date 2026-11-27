// https://leetcode.com/problems/hand-of-straights/

// Solution: Greedy with Sorted Map — O(n log n) time, O(n) space
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int card : hand) {
            freq.merge(card, 1, Integer::sum);
        }
        while (!freq.isEmpty()) {
            int start = freq.firstKey();
            for (int i = 0; i < groupSize; i++) {
                int key = start + i;
                if (!freq.containsKey(key)) {
                    return false;
                }
                int cnt = freq.get(key);
                if (cnt == 1) {
                    freq.remove(key);
                } else {
                    freq.put(key, cnt - 1);
                }
            }
        }
        return true;
    }
}
