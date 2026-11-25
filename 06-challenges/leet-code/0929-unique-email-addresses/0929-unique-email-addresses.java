// https://leetcode.com/problems/unique-email-addresses/

// Solution: String Processing + Set — O(n*L) time, O(n*L) space
class Solution {
    public int numUniqueEmails(String[] emails) {
        java.util.Set<String> unique = new java.util.HashSet<>();
        for (String email : emails) {
            int at = email.indexOf('@');
            String local = email.substring(0, at);
            String domain = email.substring(at);
            int plus = local.indexOf('+');
            if (plus != -1) {
                local = local.substring(0, plus);
            }
            local = local.replace(".", "");
            unique.add(local + domain);
        }
        return unique.size();
    }
}
