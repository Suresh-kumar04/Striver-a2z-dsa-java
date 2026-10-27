# If the left half is unsorted, the right half must be sorted

This note explains one idea used in binary search on a **rotated sorted array**: at least one half is always sorted, and if the left half is not sorted, the right half is.

Assumptions: the array was sorted in ascending order with distinct values, then rotated some number of times.

---

## 1. The big picture

Take a sorted array and rotate it:

```
sorted:   [1, 2, 3, 4, 5, 6, 7]
rotated:  [5, 6, 7, 1, 2, 3, 4]
```

Look at the rotated one. It has two parts:

- a **big part** that comes first: `5, 6, 7`
- a **small part** that comes after: `1, 2, 3, 4`

Each part is sorted on its own. Every number in the big part is larger than every number in the small part. Between the two parts there is exactly **one drop**, the place where a number is smaller than the one before it (`7 → 1`).

> **The key fact: a rotated sorted array has at most one drop.**
> (Zero drops if it was rotated 0 times or N times, so it is just sorted.)

Everything below follows from this one fact.

---

## 2. What "unsorted half" really means

A half is **unsorted** only if it contains a drop, because without a drop the numbers only go up.

So:

- Left half is unsorted → the drop is **inside the left half**.
- We have only one drop → the right half has **no drop**.
- No drop → the right half is **sorted**.

That's the whole proof, in three lines.

---

## 3. A picture to remember

Imagine the numbers as a staircase:

```
            7
         6
      5                      4
                          3
                       2
                    1
   ----------------------------------->
   [ 5   6   7 | 1   2   3   4 ]
          one cliff here
```

The staircase goes up, falls off **one** cliff, then goes up again. You are cutting the staircase into a left half and a right half with a knife at `mid`. The cliff can only be in one place:

- cliff in the left piece → the right piece is a plain staircase going up (sorted)
- cliff in the right piece → the left piece is a plain staircase going up (sorted)
- cliff exactly at the cut → both pieces are plain staircases (both sorted)

You can never get a cliff in both pieces, because there is only one cliff.

---

## 4. Examples

For each example, `s` is the start, `e` is the end, and `mid = s + (e - s) / 2`.

### Example A: left half unsorted

```
index:  0  1  2  3  4  5  6  7
value: [6, 7, 0, 1, 2, 3, 4, 5]
        s           ^mid        e
```

- Left half `[6, 7, 0, 1]` has a drop `7 → 0`, so it is **unsorted**.
- Right half `[2, 3, 4, 5]` goes up the whole time, so it is **sorted**. ✅

### Example B: left half sorted (right half is the unsorted one)

```
value: [3, 4, 5, 6, 7, 8, 1, 2]
        s           ^mid        e
```

- Left half `[3, 4, 5, 6]` is **sorted**.
- Right half `[7, 8, 1, 2]` has the drop `8 → 1`, so it is **unsorted**.

Here the left is sorted, so our claim doesn't apply, but notice that the **other** half carries the drop.

### Example C: the cliff is exactly at the cut

```
value: [5, 6, 7, 8, 1, 2, 3, 4]
        s           ^mid        e
```

- Left half `[5, 6, 7, 8]` is **sorted**.
- Right half `[1, 2, 3, 4]` is **sorted**.

Both halves are sorted. The cliff sits between them (`8 → 1`).

### Example D: not rotated at all

```
value: [1, 2, 3, 4, 5, 6, 7, 8]
```

There is no drop, so both halves are sorted.

### Example E: cliff right at the front

```
value: [8, 1, 2, 3, 4, 5, 6, 7]
        s           ^mid        e
```

- Left half `[8, 1, 2, 3]` has the drop `8 → 1`, so it is **unsorted**.
- Right half `[4, 5, 6, 7]` is **sorted**. ✅

### Example F: smaller array

```
value: [4, 5, 1, 2, 3]
        s     ^mid  e
```

`mid = 2` (value `1`).

- Left half `[4, 5, 1]` has the drop `5 → 1`, so it is **unsorted**.
- Right half `[1, 2, 3]` is **sorted**. ✅

In every example where the left half was unsorted, the right half turned out sorted.

---

## 5. Proof by contradiction (the "what if?" version)

Suppose both halves were unsorted at the same time.

1. The left half is unsorted, so it has a drop.
2. The right half is unsorted, so it also has a drop.
3. That makes **two** drops in the array.

But a rotated sorted array has only **one** drop. For two drops, the array would go up, down, up, down, which means it was not made by rotating a sorted array.

So both halves can't be unsorted. At least one is sorted. ∎

---

## 6. How do we check "is the left half sorted?" in code

We can't scan the whole half, since that would be O(N). We use just two numbers, `arr[s]` and `arr[mid]`.

Remember the big part and small part idea (every big number is larger than every small number):

- **If there is no drop in `s..mid`**, the numbers only go up, so `arr[s] <= arr[mid]`.
- **If there is a drop in `s..mid`**, then `s` is in the big part and `mid` is in the small part (after the cliff). A big number is larger than a small number, so `arr[s] > arr[mid]`.

So:

```
arr[s] <= arr[mid]   →  left half is sorted
arr[s] >  arr[mid]   →  left half is unsorted  →  right half is sorted
```

The `<=` matters: when `s == mid` the two are the same number, and a single element is sorted.

Quick check with Example A, `[6, 7, 0, 1, 2, 3, 4, 5]`: `arr[s] = 6`, `arr[mid] = 1`, and `6 > 1`, so the left half is unsorted. ✅

Quick check with Example B, `[3, 4, 5, 6, 7, 8, 1, 2]`: `arr[s] = 3`, `arr[mid] = 6`, and `3 <= 6`, so the left half is sorted. ✅

---

## 7. Why this helps binary search

Binary search needs a half where you can answer "is the target in here?" with a quick check. A sorted half gives you that, because you can just compare against its two ends.

Searching for `target` in a rotated array:

1. Find `mid`.
2. Find which half is sorted (using `arr[s] <= arr[mid]`).
3. In the sorted half, check whether the target lies between its ends.
   - If yes, search that half.
   - If no, the target must be in the other half, so search there.

```java
int search(int[] arr, int target) {
    int s = 0, e = arr.length - 1;
    while (s <= e) {
        int mid = s + (e - s) / 2;
        if (arr[mid] == target) return mid;

        if (arr[s] <= arr[mid]) {                    // left half is sorted
            if (arr[s] <= target && target < arr[mid]) e = mid - 1;
            else s = mid + 1;
        } else {                                     // left unsorted => right is sorted
            if (arr[mid] < target && target <= arr[e]) s = mid + 1;
            else e = mid - 1;
        }
    }
    return -1;
}
```

Trace for `[6, 7, 0, 1, 2, 3, 4, 5]`, `target = 1`:

- `s=0, e=7, mid=3` (value `1`): found right away.

Trace for the same array, `target = 7`:

- `s=0, e=7, mid=3` (value `1`). `arr[s]=6 > 1`, so the left is unsorted and the right is sorted. The right half is `[2..5]` and `7` is not in it, so `e = 2`.
- `s=0, e=2, mid=1` (value `7`): found. ✅

Each step throws away half the array, so this takes O(log N).

---

## 8. Summary

- A rotated sorted array has **one drop** (or none).
- A half is unsorted only if it contains that drop.
- Only one drop exists, so only one half can be unsorted.
- Therefore: **left unsorted → right sorted** (and the other way around).
- You detect it in O(1) with `arr[s] <= arr[mid]`.
- A sorted half lets you decide quickly which side to keep searching.

**Note on duplicates:** this note assumes distinct values. With duplicates, `arr[s] == arr[mid]` can happen even when there is a drop (for example `[2, 2, 2, 0, 2]`), and the check above is no longer enough. That needs extra handling.