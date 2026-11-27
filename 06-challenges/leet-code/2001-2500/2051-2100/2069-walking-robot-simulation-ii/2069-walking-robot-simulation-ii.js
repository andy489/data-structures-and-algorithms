// https://leetcode.com/problems/walking-robot-simulation-ii/

// Solution: Modular Arithmetic — O(1) per step, O(1) space
class Robot {
    constructor(width, height) {
        this.w = width; this.h = height;
        this.perim = 2 * (width + height - 2);
        this.pos = 0;
    }
    step(num) { this.pos = (this.pos + num) % this.perim; }
    _state() {
        const { pos: p, w, h } = this;
        if (p < w) return [p, 0, 0];
        if (p < w + h - 1) return [w-1, p-w+1, 1];
        if (p < 2*w+h-2) return [w-1-(p-w-h+2), h-1, 2];
        return [0, h-1-(p-2*w-h+3), 3];
    }
    getPos() { const [x, y] = this._state(); return [x, y]; }
    getDir() { return ['East','North','West','South'][this._state()[2]]; }
}
