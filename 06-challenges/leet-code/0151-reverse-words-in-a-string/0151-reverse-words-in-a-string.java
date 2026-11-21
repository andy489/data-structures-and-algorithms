// https://leetcode.com/problems/reverse-words-in-a-string/

// Solution 1: Split + reverse — O(n) time, O(n) space
class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        int lo = 0, hi = words.length - 1;
        while (lo < hi) {
            String tmp = words[lo];
            words[lo++] = words[hi];
            words[hi--] = tmp;
        }
        return String.join(" ", words);
    }
}

// Solution 2: Reverse all then reverse each word (char array) — O(n) time, O(n) space
class Solution2 {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        reverse(arr, 0, n - 1);
        int start = 0, end = 0, write = 0;
        while (end < n) {
            while (end < n && arr[end] == ' ') end++;
            if (end == n) break;
            if (write > 0) arr[write++] = ' ';
            start = end;
            while (end < n && arr[end] != ' ') end++;
            int wordLen = end - start;
            System.arraycopy(arr, start, arr, write, wordLen);
            reverse(arr, write, write + wordLen - 1);
            write += wordLen;
        }
        return new String(arr, 0, write);
    }

    private void reverse(char[] arr, int lo, int hi) {
        while (lo < hi) {
            char tmp = arr[lo];
            arr[lo++] = arr[hi];
            arr[hi--] = tmp;
        }
    }
}
