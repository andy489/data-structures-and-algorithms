// https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/

// Solution: Filter + Sort — O(n log n) time, O(n) space
class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> filtered = new ArrayList<>();
        for (int[] r : restaurants) {
            if ((veganFriendly == 0 || r[2] == 1) && r[3] <= maxPrice && r[4] <= maxDistance) {
                filtered.add(r);
            }
        }
        filtered.sort((a, b) -> a[1] != b[1] ? b[1]-a[1] : b[0]-a[0]);
        List<Integer> res = new ArrayList<>();
        for (int[] r : filtered) res.add(r[0]);
        return res;
    }
}
