// https://leetcode.com/problems/groups-of-special-equivalent-strings/

// Solution: Canonical Form — O(n*m log m) time, O(n*m) space
class Solution {
    public int numSpecialEquivGroups(String[] words) {
        Set<String> groups = new HashSet<>();
        for (String word : words) {
            char[] even = new char[word.length() / 2 + word.length() % 2];
            char[] odd = new char[word.length() / 2];
            int ei = 0, oi = 0;
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) { even[ei++] = word.charAt(i); }
                else { odd[oi++] = word.charAt(i); }
            }
            Arrays.sort(even); Arrays.sort(odd);
            groups.add(new String(even) + "," + new String(odd));
        }
        return groups.size();
    }
}
