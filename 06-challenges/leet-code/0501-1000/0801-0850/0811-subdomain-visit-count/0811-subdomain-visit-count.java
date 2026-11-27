// https://leetcode.com/problems/subdomain-visit-count/

// Solution: HashMap — O(n·L) time, O(n·L) space
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();
        for (String entry : cpdomains) {
            int space = entry.indexOf(' ');
            int count = Integer.parseInt(entry.substring(0, space));
            String domain = entry.substring(space + 1);
            counts.merge(domain, count, Integer::sum);
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    counts.merge(domain.substring(i + 1), count, Integer::sum);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> e : counts.entrySet()) {
            result.add(e.getValue() + " " + e.getKey());
        }
        return result;
    }
}
