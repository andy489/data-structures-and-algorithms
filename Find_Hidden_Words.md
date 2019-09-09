**Task.** Given a 2D grid of characters and a word, find all occurrences of the given word in the grid. A word can be matched in all 8 directions at any point. Word is said be found in a direction if all characters match in this direction (not in zig-zag form).

The 8 directions areleft right up, down and 4 diagonal directions.

*Example:*

D|R|E|A|M|I|N|G
---|---|---|---|---|---|---|---
K|**P**|M|Q|**B**|**E**|**D**|N
P|O|**I**|Z|F|V|T|E
T|M|A|**L**|F|C|X|Z
P|O|C|Z|**L**|V|T|S
D|F|A|**P**|J|**O**|T|B
R|O|**A**|Z|F|O|**W**|H
Y|**N**|A|U|**N**|**A**|**P**|W

In the grid with bold font we can find the words: {DREAMING, PILLOW, BED, NAP}

input|output
---|---
NAP| pattern found at (7,1)<br>pattern found at (7,4)
PILLOW | pattern found at (1,1)
