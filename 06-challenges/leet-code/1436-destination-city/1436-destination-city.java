// https://leetcode.com/problems/destination-city/

// Solution: HashSet — O(n) time, O(n) space
class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> sources = new HashSet<>();
        for (List<String> p : paths) sources.add(p.get(0));
        for (List<String> p : paths)
            if (!sources.contains(p.get(1))) return p.get(1);
        return "";
    }
}
