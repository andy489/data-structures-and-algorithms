// https://leetcode.com/problems/score-validator/

class Solution {
    public int[] scoreValidator(String[] events) {
        int score = 0, counter = 0;
        for (String e : events) {
            if (e.equals("W")) {
                counter++;
                if (counter == 10) {
                    break;
                }
            } else if (e.equals("WD") || e.equals("NB")) {
                score += 1;
            } else {
                score += Integer.parseInt(e);
            }
        }
        return new int[]{score, counter};
    }
}
