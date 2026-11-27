// https://leetcode.com/problems/k-similar-strings/

// Solution: BFS — O(n · |states|) time, O(|states|) space
class Solution {
    public int kSimilarity(String s1, String s2) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s1);
        visited.add(s1);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int q = 0; q < size; q++) {
                String curr = queue.poll();
                if (curr.equals(s2)) {
                    return steps;
                }
                int i = 0;
                while (curr.charAt(i) == s2.charAt(i)) {
                    i++;
                }
                char[] arr = curr.toCharArray();
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] == s2.charAt(i)) {
                        char tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;
                        String next = new String(arr);
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                        arr[j] = arr[i];
                        arr[i] = tmp;
                    }
                }
            }
            steps++;
        }
        return steps;
    }
}
