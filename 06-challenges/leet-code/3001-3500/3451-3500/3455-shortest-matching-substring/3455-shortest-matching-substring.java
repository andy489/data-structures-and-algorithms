// https://leetcode.com/problems/shortest-matching-substring/

// Solution: KMP + Two Pointers — O(n + m) time, O(n + m) space
class Solution {
    public int shortestMatchingSubstring(String s, String p) {
        // Split pattern into 3 parts by the two '*'
        int first = p.indexOf('*');
        int second = p.indexOf('*', first + 1);
        String a = p.substring(0, first);
        String b = p.substring(first + 1, second);
        String c = p.substring(second + 1);

        // Find all occurrences of each part in s using KMP
        List<Integer> aEnds = kmpEnds(s, a);    // end positions (exclusive) where a ends
        List<Integer> bRanges = kmpRanges(s, b); // [start, end] of b occurrences
        List<Integer> cStarts = kmpStarts(s, c);  // start positions where c starts

        if (aEnds == null || bRanges == null || cStarts == null) {
            return -1;
        }
        if (a.isEmpty() && b.isEmpty() && c.isEmpty()) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        int ai = 0, ci = 0;
        for (int bi = 0; bi < bRanges.size(); bi += 2) {
            int bStart = bRanges.get(bi), bEnd = bRanges.get(bi + 1);
            // Find rightmost a ending at or before bStart
            while (ai < aEnds.size() && aEnds.get(ai) <= bStart) {
                ai++;
            }
            int aIdx = ai - 1;
            // Find leftmost c starting at or after bEnd
            while (ci < cStarts.size() && cStarts.get(ci) < bEnd) {
                ci++;
            }
            if (aIdx < 0 && !a.isEmpty()) {
                continue;
            }
            if (ci >= cStarts.size() && !c.isEmpty()) {
                break;
            }
            int windowStart = a.isEmpty() ? bStart : aEnds.get(aIdx) - a.length();
            int windowEnd = c.isEmpty() ? bEnd : cStarts.get(ci) + c.length();
            ans = Math.min(ans, windowEnd - windowStart);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private List<Integer> kmpEnds(String text, String pattern) {
        if (pattern.isEmpty()) {
            List<Integer> all = new ArrayList<>();
            for (int i = 0; i <= text.length(); i++) {
                all.add(i);
            }
            return all;
        }
        List<Integer> result = new ArrayList<>();
        int[] lps = buildLPS(pattern);
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                result.add(i + 1);
                j = lps[j - 1];
            }
        }
        return result;
    }

    private List<Integer> kmpRanges(String text, String pattern) {
        if (pattern.isEmpty()) {
            List<Integer> all = new ArrayList<>();
            for (int i = 0; i <= text.length(); i++) {
                all.add(i);
                all.add(i);
            }
            return all;
        }
        List<Integer> result = new ArrayList<>();
        int[] lps = buildLPS(pattern);
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                result.add(i + 1 - pattern.length());
                result.add(i + 1);
                j = lps[j - 1];
            }
        }
        return result;
    }

    private List<Integer> kmpStarts(String text, String pattern) {
        if (pattern.isEmpty()) {
            List<Integer> all = new ArrayList<>();
            for (int i = 0; i <= text.length(); i++) {
                all.add(i);
            }
            return all;
        }
        List<Integer> result = new ArrayList<>();
        int[] lps = buildLPS(pattern);
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                result.add(i + 1 - pattern.length());
                j = lps[j - 1];
            }
        }
        return result;
    }

    private int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0, i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        return lps;
    }
}
