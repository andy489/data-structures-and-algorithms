// https://leetcode.com/problems/guess-the-word/

// Solution: Minimax — O(n²·L) time, O(n) space
class Solution {
    public void findSecretWord(String[] words, Master master) {
        List<String> candidates = new ArrayList<>(Arrays.asList(words));
        Random rand = new Random();
        for (int i = 0; i < 10 && !candidates.isEmpty(); i++) {
            String guess = candidates.get(rand.nextInt(candidates.size()));
            int matches = master.guess(guess);
            List<String> next = new ArrayList<>();
            for (String w : candidates) {
                if (w.equals(guess)) {
                    continue;
                }
                if (match(guess, w) == matches) {
                    next.add(w);
                }
            }
            candidates = next;
        }
    }

    private int match(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
