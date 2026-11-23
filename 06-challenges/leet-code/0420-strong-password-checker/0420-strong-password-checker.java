// https://leetcode.com/problems/strong-password-checker/

// Solution: Greedy — O(n) time, O(n) space
class Solution {
    public int strongPasswordChecker(String s) {
        int n = s.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false;
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) { hasLower = true; }
            else if (Character.isUpperCase(ch)) { hasUpper = true; }
            else if (Character.isDigit(ch)) { hasDigit = true; }
        }
        int missingTypes = (hasLower ? 0 : 1) + (hasUpper ? 0 : 1) + (hasDigit ? 0 : 1);

        // Collect run lengths for consecutive repeated characters
        List<Integer> runs = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            if (j - i >= 3) {
                runs.add(j - i);
            }
            i = j;
        }

        if (n < 6) {
            return Math.max(6 - n, missingTypes);
        }

        // Count replacements needed for all runs (floor(runLen / 3) each)
        int repeatReplacements = 0;
        for (int runLen : runs) {
            repeatReplacements += runLen / 3;
        }

        if (n <= 20) {
            return Math.max(repeatReplacements, missingTypes);
        }

        // Need to delete (n - 20) characters; use deletions to reduce replacements
        int toDelete = n - 20;
        int deletions = toDelete;

        // Pass 1: runs where len % 3 == 0 — 1 deletion saves 1 replacement
        for (int k = 0; k < runs.size() && toDelete > 0; k++) {
            if (runs.get(k) % 3 == 0) {
                runs.set(k, runs.get(k) - 1);
                repeatReplacements--;
                toDelete--;
            }
        }
        // Pass 2: runs where len % 3 == 1 — 2 deletions save 1 replacement
        for (int k = 0; k < runs.size() && toDelete > 0; k++) {
            if (runs.get(k) % 3 == 1) {
                int reduce = Math.min(2, toDelete);
                runs.set(k, runs.get(k) - reduce);
                repeatReplacements -= reduce / 2;
                toDelete -= reduce;
            }
        }
        // Pass 3: remaining runs — 3 deletions save 1 replacement
        for (int k = 0; k < runs.size() && toDelete > 0; k++) {
            int reduce = (toDelete / 3) * 3;
            if (reduce > 0 && runs.get(k) >= 3) {
                int possible = Math.min(runs.get(k) - 2, reduce);
                runs.set(k, runs.get(k) - possible);
                repeatReplacements -= possible / 3;
                toDelete -= possible;
            }
        }

        return deletions + Math.max(repeatReplacements, missingTypes);
    }
}
