# https://leetcode.com/problems/peeking-iterator/

class PeekingIterator:
    def __init__(self, iterator):
        self._iter = iterator
        self._peeked = None
        self._has_peeked = False

    def peek(self):
        if not self._has_peeked:
            self._peeked = next(self._iter)
            self._has_peeked = True
        return self._peeked

    def next(self):
        if self._has_peeked:
            self._has_peeked = False
            return self._peeked
        return next(self._iter)

    def hasNext(self):
        return self._has_peeked or self._iter.hasNext()
