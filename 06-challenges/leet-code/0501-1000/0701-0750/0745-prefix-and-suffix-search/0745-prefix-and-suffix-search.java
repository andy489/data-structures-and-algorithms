// https://leetcode.com/problems/prefix-and-suffix-search/

// Solution: HashMap with Combined Key — O(n·L²) build, O(1) query
class WordFilter {
    private Map<String, Integer> lookup;

    public WordFilter(String[] words) {
        lookup = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            int len = w.length();
            for (int p = 0; p <= len; p++) {
                for (int s = 0; s <= len; s++) {
                    String key = w.substring(0, p) + "#" + w.substring(len - s);
                    lookup.put(key, i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return lookup.getOrDefault(pref + "#" + suff, -1);
    }
}
