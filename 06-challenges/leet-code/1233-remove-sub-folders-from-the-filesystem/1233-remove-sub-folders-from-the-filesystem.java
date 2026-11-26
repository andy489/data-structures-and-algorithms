// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/

// Solution: Sort and Prefix Check — O(n log n) time, O(n) space
// Solution: Sort and Prefix Check — O(n log n) time, O(n) space
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        String last = "";
        for (String f : folder) {
            if (last.isEmpty() || !f.startsWith(last + "/")) {
                res.add(f);
                last = f;
            }
        }
        return res;
    }
}
