// https://leetcode.com/problems/exam-room/

// Solution: Sorted Set — O(n) seat, O(n) leave
class ExamRoom {
    private TreeSet<Integer> seats;
    private int n;

    public ExamRoom(int n) {
        this.n = n;
        seats = new TreeSet<>();
    }

    public int seat() {
        if (seats.isEmpty()) {
            seats.add(0);
            return 0;
        }
        int bestSeat = 0;
        int bestDist = seats.first();
        int prev = -1;
        for (int s : seats) {
            if (prev != -1) {
                int mid = (s + prev) / 2;
                int dist = mid - prev;
                if (dist > bestDist) {
                    bestDist = dist;
                    bestSeat = mid;
                }
            }
            prev = s;
        }
        if (n - 1 - seats.last() > bestDist) {
            bestSeat = n - 1;
        }
        seats.add(bestSeat);
        return bestSeat;
    }

    public void leave(int p) {
        seats.remove(p);
    }
}
