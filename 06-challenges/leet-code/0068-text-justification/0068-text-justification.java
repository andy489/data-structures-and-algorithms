// https://leetcode.com/problems/text-justification/

// Solution: Greedy Line Packing — O(n·W) time, O(n·W) space
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int lineLen = words[i].length();
            int j = i + 1;
            while (j < words.length && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length();
                j++;
            }
            List<String> lineWords = Arrays.asList(words).subList(i, j);
            result.add(buildLine(lineWords, maxWidth, j == words.length));
            i = j;
        }
        return result;
    }

    private String buildLine(List<String> words, int maxWidth, boolean isLast) {
        int totalChars = words.stream().mapToInt(String::length).sum();
        int gaps = words.size() - 1;
        StringBuilder sb = new StringBuilder();
        if (isLast || gaps == 0) {
            sb.append(String.join(" ", words));
            while (sb.length() < maxWidth) sb.append(' ');
            return sb.toString();
        }
        int totalSpaces = maxWidth - totalChars;
        int spacePerGap = totalSpaces / gaps;
        int extra = totalSpaces % gaps;
        for (int k = 0; k < words.size(); k++) {
            sb.append(words.get(k));
            if (k < gaps) {
                int spaces = spacePerGap + (k < extra ? 1 : 0);
                for (int s = 0; s < spaces; s++) sb.append(' ');
            }
        }
        return sb.toString();
    }
}
