// https://leetcode.com/problems/reorder-data-in-log-files/

// Solution: Custom Sort — O(n log n) time, O(n) space
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        java.util.List<String> letters = new java.util.ArrayList<>();
        java.util.List<String> digits = new java.util.ArrayList<>();
        for (String log : logs) {
            int space = log.indexOf(' ');
            if (Character.isDigit(log.charAt(space + 1))) {
                digits.add(log);
            } else {
                letters.add(log);
            }
        }
        letters.sort((a, b) -> {
            int ia = a.indexOf(' '), ib = b.indexOf(' ');
            String aContent = a.substring(ia + 1), bContent = b.substring(ib + 1);
            int cmp = aContent.compareTo(bContent);
            return cmp != 0 ? cmp : a.substring(0, ia).compareTo(b.substring(0, ib));
        });
        letters.addAll(digits);
        return letters.toArray(new String[0]);
    }
}
