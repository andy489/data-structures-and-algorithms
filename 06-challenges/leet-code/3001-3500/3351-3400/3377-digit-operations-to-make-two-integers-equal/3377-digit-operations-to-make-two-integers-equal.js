// https://leetcode.com/problems/digit-operations-to-make-two-integers-equal/

var minOperations = function(n, m) {
    const limit = 10001;
    const isPrime = new Array(limit).fill(true);
    isPrime[0] = isPrime[1] = false;
    for (let i = 2; i * i < limit; i++) {
        if (isPrime[i]) {
            for (let j = i * i; j < limit; j += i) {
                isPrime[j] = false;
            }
        }
    }

    if (isPrime[n] || isPrime[m]) return -1;

    const dist = new Array(limit).fill(Infinity);
    dist[n] = n;
    // min-heap: [cost, number]
    const heap = [[n, n]];

    const push = (item) => {
        heap.push(item);
        let i = heap.length - 1;
        while (i > 0) {
            const parent = (i - 1) >> 1;
            if (heap[parent][0] <= heap[i][0]) break;
            [heap[parent], heap[i]] = [heap[i], heap[parent]];
            i = parent;
        }
    };
    const pop = () => {
        const top = heap[0];
        const last = heap.pop();
        if (heap.length > 0) {
            heap[0] = last;
            let i = 0;
            while (true) {
                let smallest = i;
                const l = 2 * i + 1, r = 2 * i + 2;
                if (l < heap.length && heap[l][0] < heap[smallest][0]) smallest = l;
                if (r < heap.length && heap[r][0] < heap[smallest][0]) smallest = r;
                if (smallest === i) break;
                [heap[smallest], heap[i]] = [heap[i], heap[smallest]];
                i = smallest;
            }
        }
        return top;
    };

    while (heap.length > 0) {
        const [cost, num] = pop();
        if (cost > dist[num]) continue;
        if (num === m) return cost;
        const digits = String(num).split('');
        for (let i = 0; i < digits.length; i++) {
            const orig = digits[i];
            // increase digit
            if (orig < '9') {
                digits[i] = String(Number(orig) + 1);
                const nxt = parseInt(digits.join(''));
                if (!isPrime[nxt] && cost + nxt < dist[nxt]) {
                    dist[nxt] = cost + nxt;
                    push([dist[nxt], nxt]);
                }
                digits[i] = orig;
            }
            // decrease digit (no leading zero)
            if (orig > '0' && !(i === 0 && orig === '1')) {
                digits[i] = String(Number(orig) - 1);
                const nxt = parseInt(digits.join(''));
                if (!isPrime[nxt] && cost + nxt < dist[nxt]) {
                    dist[nxt] = cost + nxt;
                    push([dist[nxt], nxt]);
                }
                digits[i] = orig;
            }
        }
    }
    return -1;
};
