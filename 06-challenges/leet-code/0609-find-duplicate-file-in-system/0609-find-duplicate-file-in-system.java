// https://leetcode.com/problems/find-duplicate-file-in-system/

// Solution: Hash Map by Content — O(n·k) time, O(n·k) space
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contentToFiles = new HashMap<>();
        for (String path : paths) {
            String[] parts = path.split(" ");
            String dir = parts[0];
            for (int i = 1; i < parts.length; i++) {
                int parenIdx = parts[i].indexOf('(');
                String fileName = parts[i].substring(0, parenIdx);
                String content = parts[i].substring(parenIdx + 1, parts[i].length() - 1);
                String fullPath = dir + "/" + fileName;
                contentToFiles.computeIfAbsent(content, k -> new ArrayList<>()).add(fullPath);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> files : contentToFiles.values()) {
            if (files.size() >= 2) {
                result.add(files);
            }
        }
        return result;
    }
}
