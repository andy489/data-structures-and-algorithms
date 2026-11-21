// https://leetcode.com/problems/word-ladder/

// Solution 1: BFS — O(n·L·26) time, O(n·L) space
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        wordSet.remove(beginWord);
        int steps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            while (size-- > 0) {
                char[] chars = queue.poll().toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        chars[i] = c;
                        String next = new String(chars);
                        if (next.equals(endWord)) return steps;
                        if (wordSet.remove(next)) queue.offer(next);
                        chars[i] = original;
                    }
                }
            }
        }
        return 0;
    }
}

// Solution 2: Bidirectional BFS — O(n·L·26) time, O(n·L) space
class Solution2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Set<String> frontA = new HashSet<>(), frontB = new HashSet<>();
        frontA.add(beginWord);
        frontB.add(endWord);
        wordSet.remove(beginWord);
        wordSet.remove(endWord);
        int steps = 1;
        while (!frontA.isEmpty() && !frontB.isEmpty()) {
            if (frontA.size() > frontB.size()) {
                Set<String> tmp = frontA; frontA = frontB; frontB = tmp;
            }
            steps++;
            Set<String> next = new HashSet<>();
            for (String word : frontA) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        chars[i] = c;
                        String neighbor = new String(chars);
                        if (frontB.contains(neighbor)) return steps;
                        if (wordSet.remove(neighbor)) next.add(neighbor);
                        chars[i] = original;
                    }
                }
            }
            frontA = next;
        }
        return 0;
    }
}
