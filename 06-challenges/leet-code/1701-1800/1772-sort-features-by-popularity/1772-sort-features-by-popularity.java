// https://leetcode.com/problems/sort-features-by-popularity/

// Solution: Hash Map + Stable Sort — O(R*W + F log F) time, O(F + R*W) space
class Solution {
    public String[] sortFeatures(String[] features, String[] responses) {
        Map<String, Integer> count = new HashMap<>();
        for (String response : responses) {
            Set<String> seen = new HashSet<>(Arrays.asList(response.split(" ")));
            for (String word : seen) {
                count.merge(word, 1, Integer::sum);
            }
        }
        Integer[] indices = new Integer[features.length];
        for (int i = 0; i < features.length; i++) indices[i] = i;
        Arrays.sort(indices, (a, b) -> {
            int ca = count.getOrDefault(features[a], 0);
            int cb = count.getOrDefault(features[b], 0);
            if (ca != cb) return cb - ca;
            return a - b;
        });
        String[] result = new String[features.length];
        for (int i = 0; i < indices.length; i++) {
            result[i] = features[indices[i]];
        }
        return result;
    }
}
