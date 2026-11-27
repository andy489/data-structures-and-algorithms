// https://leetcode.com/problems/split-array-into-fibonacci-sequence/

// Solution: Backtracking — O(n²) time, O(n) space
class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> seq = new ArrayList<>();
        backtrack(num, 0, seq);
        return seq;
    }

    private boolean backtrack(String num, int idx, List<Integer> seq) {
        if (idx == num.length() && seq.size() >= 3) {
            return true;
        }
        for (int end = idx + 1; end <= num.length(); end++) {
            String part = num.substring(idx, end);
            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }
            long val = Long.parseLong(part);
            if (val > Integer.MAX_VALUE) {
                break;
            }
            int n = seq.size();
            if (n >= 2 && val != (long) seq.get(n - 1) + seq.get(n - 2)) {
                if (val > (long) seq.get(n - 1) + seq.get(n - 2)) {
                    break;
                }
                continue;
            }
            seq.add((int) val);
            if (backtrack(num, end, seq)) {
                return true;
            }
            seq.remove(seq.size() - 1);
        }
        return false;
    }
}
