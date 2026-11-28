// https://leetcode.com/problems/longest-common-prefix-of-k-strings-after-removal/

// Solution: Trie with Count — O(total_chars) time, O(total_chars) space
class Solution {
    private int[][] children;
    private int[] cnt;
    private int nodeCount;

    private int newNode() {
        children[nodeCount] = new int[26];
        Arrays.fill(children[nodeCount], -1);
        cnt[nodeCount] = 0;
        return nodeCount++;
    }

    private void insert(String word, int delta) {
        int node = 0;
        cnt[node] += delta;
        for (char c : word.toCharArray()) {
            int ch = c - 'a';
            if (children[node][ch] == -1) {
                children[node][ch] = newNode();
            }
            node = children[node][ch];
            cnt[node] += delta;
        }
    }

    // Find max depth where count >= k
    private int query(int k) {
        int node = 0, depth = 0;
        while (true) {
            boolean found = false;
            for (int i = 0; i < 26; i++) {
                int child = children[node][i];
                if (child != -1 && cnt[child] >= k) {
                    node = child;
                    depth++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                break;
            }
        }
        return depth;
    }

    public int[] longestCommonPrefix(String[] words, int k) {
        int n = words.length;
        int totalChars = 0;
        for (String w : words) {
            totalChars += w.length();
        }
        children = new int[totalChars + 1][26];
        cnt = new int[totalChars + 1];
        nodeCount = 0;
        newNode(); // root is node 0

        for (String word : words) {
            insert(word, 1);
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            if (n - 1 < k) {
                answer[i] = 0;
                continue;
            }
            insert(words[i], -1);
            answer[i] = query(k);
            insert(words[i], 1);
        }
        return answer;
    }
}
