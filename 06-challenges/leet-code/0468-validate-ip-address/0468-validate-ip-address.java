// https://leetcode.com/problems/validate-ip-address/

// Solution: Split and Validate — O(1) time, O(1) space
class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            return isValidIPv4(queryIP) ? "IPv4" : "Neither";
        } else if (queryIP.contains(":")) {
            return isValidIPv6(queryIP) ? "IPv6" : "Neither";
        }
        return "Neither";
    }

    private boolean isValidIPv4(String ip) {
        String[] parts = ip.split("\\.", -1);
        if (parts.length != 4) {
            return false;
        }
        for (String part : parts) {
            if (part.isEmpty() || part.length() > 3) {
                return false;
            }
            if (part.length() > 1 && part.charAt(0) == '0') {
                return false;
            }
            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            int val = Integer.parseInt(part);
            if (val < 0 || val > 255) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidIPv6(String ip) {
        String[] parts = ip.split(":", -1);
        if (parts.length != 8) {
            return false;
        }
        String hexChars = "0123456789abcdefABCDEF";
        for (String part : parts) {
            if (part.isEmpty() || part.length() > 4) {
                return false;
            }
            for (char c : part.toCharArray()) {
                if (hexChars.indexOf(c) == -1) {
                    return false;
                }
            }
        }
        return true;
    }
}
