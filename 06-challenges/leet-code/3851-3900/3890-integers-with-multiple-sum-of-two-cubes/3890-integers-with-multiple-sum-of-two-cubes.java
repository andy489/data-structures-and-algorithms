// https://leetcode.com/problems/integers-with-multiple-sum-of-two-cubes/
class Solution {
    public List<Long> getGoodIntegers(long n) {
        Map<Long, Integer> countMap = new HashMap<>();
        long limit = (long)Math.cbrt(n) + 1;

        for (long a = 1; a <= limit; a++) {
            for (long b = a; b <= limit; b++) {
                long sum = a * a * a + b * b * b;
                if (sum > n) {
                    break;
                }
                countMap.merge(sum, 1, Integer::sum);
            }
        }

        List<Long> result = new ArrayList<>();
        for (Map.Entry<Long, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() >= 2) {
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        return result;
    }
}
