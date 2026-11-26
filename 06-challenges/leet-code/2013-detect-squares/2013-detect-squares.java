// https://leetcode.com/problems/detect-squares/

// Solution: HashMap — O(n) time per count, O(n) space
class DetectSquares {
    private Map<Integer, Map<Integer, Integer>> rowPoints = new HashMap<>();
    private Map<Integer, Integer> pointCount = new HashMap<>();

    public void add(int[] point) {
        int x = point[0], y = point[1];
        rowPoints.computeIfAbsent(y, k -> new HashMap<>()).merge(x, 1, Integer::sum);
        pointCount.merge(y * 1001 + x, 1, Integer::sum);
    }

    public int count(int[] point) {
        int px = point[0], py = point[1], res = 0;
        if (!rowPoints.containsKey(py)) { return 0; }
        for (Map.Entry<Integer, Integer> e : rowPoints.get(py).entrySet()) {
            int x1 = e.getKey();
            if (x1 == px) { continue; }
            int side = Math.abs(x1 - px);
            for (int dy : new int[]{side, -side}) {
                int ny = py + dy;
                res += e.getValue()
                    * pointCount.getOrDefault(ny * 1001 + px, 0)
                    * pointCount.getOrDefault(ny * 1001 + x1, 0);
            }
        }
        return res;
    }
}
