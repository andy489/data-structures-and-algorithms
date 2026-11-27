// https://leetcode.com/problems/sentence-similarity-iii/

// Solution: Two Pointers on Word Arrays — O(n) time, O(n) space
class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] w1 = sentence1.split(" ");
        String[] w2 = sentence2.split(" ");
        int i = 0, j1 = w1.length - 1, j2 = w2.length - 1;
        while (i <= j1 && i <= j2 && w1[i].equals(w2[i])) {
            i++;
        }
        while (j1 >= i && j2 >= i && w1[j1].equals(w2[j2])) {
            j1--;
            j2--;
        }
        return i > j1 || i > j2;
    }
}
