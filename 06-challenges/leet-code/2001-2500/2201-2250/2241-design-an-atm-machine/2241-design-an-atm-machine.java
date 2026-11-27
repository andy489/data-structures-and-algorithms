// https://leetcode.com/problems/design-an-atm-machine/

class ATM {
    private long[] counts;
    private int[] denominations;

    public ATM() {
        counts = new long[5];
        denominations = new int[]{20, 50, 100, 200, 500};
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            counts[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] used = new int[5];
        for (int i = 4; i >= 0; i--) {
            long take = Math.min(counts[i], amount / denominations[i]);
            used[i] = (int) take;
            amount -= take * denominations[i];
        }
        if (amount != 0) {
            return new int[]{-1};
        }
        for (int i = 0; i < 5; i++) {
            counts[i] -= used[i];
        }
        return used;
    }
}
