# Huffman Coding

## What it is
**Lossless compression.** Frequent characters get **shorter** bit codes; rare characters get longer codes. Prefix-free: no code is a prefix of another (decode unambiguously).

## Pipeline (your `huffman.java`)
```
Input string
    → frequency map
    → min-heap of leaf nodes
    → merge until one tree
    → DFS to assign 0/1 codes
    → encode / decode via HashMaps
```

## Step 1: Frequency map
Count each character:
```
"suresh" → s:2, u:1, r:1, e:1, h:1
```

## Step 2: Build Huffman tree
1. Put each `(char, freq)` as a leaf in a **min priority queue** (lowest freq first)
2. While `size > 1`:
   - Poll two smallest nodes `a`, `b`
   - Create internal node with `cost = a.cost + b.cost`, `data = '\0'`
   - Link as left/right, push back
3. Last node = **root**

## Step 3: Assign codes (`setTreeFreq`)
DFS from root:
- Go left → append `'0'`
- Go right → append `'1'`
- At **leaf** (both children null) → store code in `encoder`, reverse in `decoder`

## Why leaf-only for codes
Internal nodes don't represent real characters. Only leaves map char ↔ bitstring.

## Encode
For each char in input, append `encoder.get(ch)`.

## Decode
Read bits one by one into `key`. When `key` exists in `decoder`, append char and reset `key`.

## Niche points

1. **Greedy is optimal** — Huffman's merge rule gives minimum expected code length.
2. **Prefix-free property** — comes from tree structure; leaves only at ends of paths.
3. **Single unique character** — tree has one node; you need a convention (e.g. code `"0"`) or decode breaks.
4. **Empty input** — define behavior explicitly.
5. **`String +=` in loops** — O(n²); use `StringBuilder` for production.
6. **`compareTo` with subtraction** — can overflow for huge costs; use `Integer.compare(a, b)`.
7. **Internal node char `'\0'`** — sentinel only; never encoded as real data.
8. **Tie-breaking** — when two nodes have same freq, different merge order → different codes, same compression length.

## Complexity
| Step | Time |
|------|------|
| Build freq map | O(n) |
| Build tree | O(k log k), k = unique chars |
| Encode | O(n × avg code length) |
| Decode | O(bits) |

## Example intuition
If `e` appears 100× and `z` appears 1×:
- `e` might get code `0` (1 bit)
- `z` might get `110101` (6 bits)
- Total bits ≪ fixed-length encoding (e.g. 8 bits per char)

## Connection to your other code
- Uses **min priority queue** (Java's `PriorityQueue`) — same heap idea as your `PriorityQueue.java`
- Tree traversal = DFS (same family as segment tree build/query)

## Possible improvements
- [ ] Handle single-char and empty string
- [ ] `StringBuilder` in encode/decode
- [ ] Serialize tree for decoding without retransmitting freq table
