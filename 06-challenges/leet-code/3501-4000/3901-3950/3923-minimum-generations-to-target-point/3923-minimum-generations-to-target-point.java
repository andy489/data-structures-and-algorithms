// https://leetcode.com/problems/minimum-generations-to-target-point/

class Solution {
    public int minGenerations(int[][] points, int[] target) {
        Set<String> known = new HashSet<>();
        List<int[]> all = new ArrayList<>();
        for (int[] p : points) {
            String key = p[0] + "," + p[1] + "," + p[2];
            if (known.add(key)) {
                all.add(p);
            }
        }
        String tKey = target[0] + "," + target[1] + "," + target[2];
        if (known.contains(tKey)) {
            return 0;
        }
        for (int gen = 1; gen <= 1000; gen++) {
            int size = all.size();
            List<int[]> newPoints = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    int[] a = all.get(i);
                    int[] b = all.get(j);
                    int[] c = {(a[0] + b[0]) / 2, (a[1] + b[1]) / 2, (a[2] + b[2]) / 2};
                    String cKey = c[0] + "," + c[1] + "," + c[2];
                    if (cKey.equals(tKey)) {
                        return gen;
                    }
                    if (known.add(cKey)) {
                        newPoints.add(c);
                    }
                }
            }
            if (newPoints.isEmpty()) {
                return -1;
            }
            all.addAll(newPoints);
        }
        return -1;
    }
}
