// https://leetcode.com/problems/largest-multiple-of-three/

// Solution: Greedy — O(n log n) time, O(n) space
class Solution {
    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);
        int sum = 0;
        for (int d : digits) sum += d;
        int rem = sum % 3;
        List<Integer> list = new ArrayList<>();
        for (int d : digits) list.add(d);
        if (rem != 0) {
            // Remove 1 digit with remainder rem, or 2 digits with remainder (3-rem)
            boolean removed = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) % 3 == rem) { list.remove(i); removed = true; break; }
            }
            if (!removed) {
                int cnt = 0;
                for (int i = 0; i < list.size() && cnt < 2; ) {
                    if (list.get(i) % 3 == 3-rem) { list.remove(i); cnt++; }
                    else i++;
                }
            }
        }
        if (list.isEmpty()) return "";
        list.sort(Collections.reverseOrder());
        if (list.get(0) == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for (int d : list) sb.append(d);
        return sb.toString();
    }
}
