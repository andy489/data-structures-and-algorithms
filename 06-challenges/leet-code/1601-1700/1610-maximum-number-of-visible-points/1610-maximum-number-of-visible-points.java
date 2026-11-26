// https://leetcode.com/problems/maximum-number-of-visible-points/

// Solution: Polar Angle + Sliding Window — O(n log n) time, O(n) space
class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int lx = location.get(0), ly = location.get(1);
        List<Double> angles = new ArrayList<>();
        int atOrigin = 0;

        for (List<Integer> p : points) {
            int dx = p.get(0) - lx, dy = p.get(1) - ly;
            if (dx == 0 && dy == 0) {
                atOrigin++;
            } else {
                angles.add(Math.toDegrees(Math.atan2(dy, dx)));
            }
        }

        Collections.sort(angles);
        int n = angles.size();
        // duplicate the list (shifted by 360) for circular sliding window
        for (int i = 0; i < n; i++) {
            angles.add(angles.get(i) + 360.0);
        }

        int maxVisible = 0;
        int left = 0;
        for (int right = 0; right < angles.size(); right++) {
            while (angles.get(right) - angles.get(left) > angle) {
                left++;
            }
            maxVisible = Math.max(maxVisible, right - left + 1);
        }

        return maxVisible + atOrigin;
    }
}
