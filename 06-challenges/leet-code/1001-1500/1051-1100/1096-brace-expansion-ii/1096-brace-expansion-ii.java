// https://leetcode.com/problems/brace-expansion-ii/

// Solution: Recursive Parsing — O(n * 2^(n/2)) time, O(2^(n/2)) space
class Solution {
    private String expr;
    private int idx;

    public List<String> braceExpansionII(String expression) {
        expr = expression;
        idx = 0;
        Set<String> result = parse();
        List<String> list = new ArrayList<>(result);
        Collections.sort(list);
        return list;
    }

    private Set<String> parse() {
        Set<String> result = new HashSet<>();
        result.add("");
        while (idx < expr.length() && expr.charAt(idx) != '}' && expr.charAt(idx) != ',') {
            Set<String> next;
            if (expr.charAt(idx) == '{') {
                idx++; // skip '{'
                next = new HashSet<>();
                next.addAll(parse());
                while (expr.charAt(idx) == ',') {
                    idx++; // skip ','
                    next.addAll(parse());
                }
                idx++; // skip '}'
            } else {
                next = new HashSet<>();
                next.add(String.valueOf(expr.charAt(idx++)));
            }
            Set<String> combined = new HashSet<>();
            for (String a : result) {
                for (String b : next) {
                    combined.add(a + b);
                }
            }
            result = combined;
        }
        return result;
    }
}
