// https://leetcode.com/problems/design-spreadsheet/

// Solution: HashMap — O(1) per operation time, O(n) space
class Spreadsheet {
    private Map<String, Integer> cells;

    public Spreadsheet(int rows) {
        cells = new HashMap<>();
    }

    public void setCell(String cell, int value) {
        cells.put(cell, value);
    }

    public void resetCell(String cell) {
        cells.remove(cell);
    }

    public int getValue(String formula) {
        String expr = formula.substring(1); // remove '='
        String[] parts = expr.split("\\+");
        int sum = 0;
        for (String part : parts) {
            if (Character.isDigit(part.charAt(0))) {
                sum += Integer.parseInt(part);
            } else {
                sum += cells.getOrDefault(part, 0);
            }
        }
        return sum;
    }
}
