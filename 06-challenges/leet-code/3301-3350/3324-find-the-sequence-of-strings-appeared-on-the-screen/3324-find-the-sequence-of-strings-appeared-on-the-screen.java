// https://leetcode.com/problems/find-the-sequence-of-strings-appeared-on-the-screen/

class Solution {
    public List<String> stringSequence(String target) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        for (char c : target.toCharArray()) {
            current.append('a');
            result.add(current.toString());
            while (current.charAt(current.length() - 1) != c) {
                current.setCharAt(current.length() - 1, (char) (current.charAt(current.length() - 1) + 1));
                result.add(current.toString());
            }
        }
        return result;
    }
}
