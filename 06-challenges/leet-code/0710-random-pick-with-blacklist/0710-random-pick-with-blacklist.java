// https://leetcode.com/problems/random-pick-with-blacklist/

// Solution: Remapping — O(b) init, O(1) pick, O(b) space
class Solution {
    private final Map<Integer, Integer> remap;
    private final int m;
    private final Random rand;

    public Solution(int n, int[] blacklist) {
        remap = new HashMap<>();
        rand = new Random();
        m = n - blacklist.length;

        Set<Integer> blackInUpper = new HashSet<>();
        for (int b : blacklist) {
            if (b >= m) {
                blackInUpper.add(b);
            }
        }

        int ptr = m;
        for (int b : blacklist) {
            if (b < m) {
                while (blackInUpper.contains(ptr)) {
                    ptr++;
                }
                remap.put(b, ptr++);
            }
        }
    }

    public int pick() {
        int r = rand.nextInt(m);
        return remap.getOrDefault(r, r);
    }
}
