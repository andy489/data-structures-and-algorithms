// https://leetcode.com/problems/reformat-date/

// Solution: String Parsing with Month Map — O(1) time, O(1) space
class Solution {
    private static final String[] MONTHS = {
        "", "Jan", "Feb", "Mar", "Apr", "May", "Jun",
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    public String reformatDate(String date) {
        String[] parts = date.split(" ");
        String dayStr = parts[0].replaceAll("[^0-9]", "");
        String monthStr = parts[1];
        String year = parts[2];

        int day = Integer.parseInt(dayStr);
        int month = 0;
        for (int i = 1; i <= 12; i++) {
            if (MONTHS[i].equals(monthStr)) {
                month = i;
                break;
            }
        }
        return String.format("%s-%02d-%02d", year, month, day);
    }
}
