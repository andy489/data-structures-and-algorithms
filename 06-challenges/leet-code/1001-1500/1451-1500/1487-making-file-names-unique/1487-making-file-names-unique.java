// https://leetcode.com/problems/making-file-names-unique/

// Solution: HashMap Counter — O(n * L) time, O(n) space
class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (!map.containsKey(name)) {
                res[i] = name;
                map.put(name, 1);
            } else {
                int k = map.get(name);
                while (map.containsKey(name + "(" + k + ")")) k++;
                res[i] = name + "(" + k + ")";
                map.put(name, k + 1);
                map.put(res[i], 1);
            }
        }
        return res;
    }
}
