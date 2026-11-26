// https://leetcode.com/problems/find-beautiful-indices-in-the-given-array-i/

// Solution: Two Pointers on Occurrence Lists — O(n) time, O(n) space
class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> listA = findOccurrences(s, a);
        List<Integer> listB = findOccurrences(s, b);
        List<Integer> result = new ArrayList<>();
        int j = 0;
        for (int i : listA) {
            while (j < listB.size() && listB.get(j) < i - k) { j++; }
            if (j < listB.size() && listB.get(j) <= i + k) { result.add(i); }
        }
        return result;
    }

    private List<Integer> findOccurrences(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int idx = 0;
        while ((idx = s.indexOf(p, idx)) != -1) { res.add(idx); idx++; }
        return res;
    }
}
