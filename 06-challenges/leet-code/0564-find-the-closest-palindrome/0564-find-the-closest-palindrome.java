class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        int len = n.length();

        List<Long> candidates = new ArrayList<>();
        candidates.add((long) Math.pow(10, len - 1) - 1);
        candidates.add((long) Math.pow(10, len) + 1);

        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (long p = prefix - 1; p <= prefix + 1; p++) {
            String half = Long.toString(p);
            String full;
            if (len % 2 == 0) {
                full = half + new StringBuilder(half).reverse().toString();
            } else {
                full = half + new StringBuilder(half.substring(0, half.length() - 1)).reverse().toString();
            }
            candidates.add(Long.parseLong(full));
        }

        long result = Long.MAX_VALUE;
        for (long c : candidates) {
            if (c == num) {
                continue;
            }
            if (result == Long.MAX_VALUE ||
                Math.abs(c - num) < Math.abs(result - num) ||
                (Math.abs(c - num) == Math.abs(result - num) && c < result)) {
                result = c;
            }
        }
        return Long.toString(result);
    }
}
