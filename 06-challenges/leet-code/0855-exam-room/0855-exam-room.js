// https://leetcode.com/problems/exam-room/

class ExamRoom {
    constructor(n) {
        this.n = n;
        this.seats = [];
    }

    seat() {
        if (!this.seats.length) {
            this.seats.push(0);
            return 0;
        }
        let bestSeat = 0, bestDist = this.seats[0];
        for (let i = 1; i < this.seats.length; i++) {
            const mid = Math.floor((this.seats[i] + this.seats[i - 1]) / 2);
            const dist = mid - this.seats[i - 1];
            if (dist > bestDist) {
                bestDist = dist;
                bestSeat = mid;
            }
        }
        if (this.n - 1 - this.seats[this.seats.length - 1] > bestDist) {
            bestSeat = this.n - 1;
        }
        const idx = this.seats.findIndex(s => s > bestSeat);
        if (idx === -1) this.seats.push(bestSeat);
        else this.seats.splice(idx, 0, bestSeat);
        return bestSeat;
    }

    leave(p) {
        const idx = this.seats.indexOf(p);
        this.seats.splice(idx, 1);
    }
}
