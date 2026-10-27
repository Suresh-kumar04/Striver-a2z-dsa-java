# XOR Approach: Missing and Repeating Number

Problem: `nums` has size `n`, values `1..n`. One value appears twice (**repeating**), one value is missing (**missing**). Return `[repeating, missing]`.

My example: `nums = [1, 1, 2, 3, 5]`, `n = 5`. Repeating = **1**, missing = **4**. Answer: `[1, 4]`.

---

## My understanding (confirmed correct)

1. XOR the given array together with `1..n`.
2. Every normal number appears **twice** in total (once in the array, once in `1..n`), so it cancels.
3. The repeating number appears **3 times**, so one copy is left. The missing number appears **once**, so it is left too.
4. So after the first XOR I get **one value** = `missing ^ repeating`. I can't read the two numbers out of one value directly.
5. That value has a 1 at some bit. A 1 in an XOR result means **the two numbers have different bits at that position**. So the two numbers are different from each other at that bit. I call that position `diffBit`.
6. Go through **all** numbers (`nums` and `1..n`) and put each one in the `ones` pile or the `zeros` pile, depending on its bit at `diffBit`. Then XOR each pile. Each pile gives me one of the two numbers.

---

## Step by step on `[1, 1, 2, 3, 5]`

### Step 1: the first XOR

```
xor = (1 ^ 1 ^ 2 ^ 3 ^ 5)  ^  (1 ^ 2 ^ 3 ^ 4 ^ 5)
    = 4 ^ 1
    = 5
```

In binary: `4 = 100`, `1 = 001`, so `xor = 101`.

### Step 2: find `diffBit`

`xor = 101` has a 1 at bit 0 (and bit 2). I take the lowest one, so `diffBit = 0`.

This means: **4 and 1 are different at bit 0.** Check: `4 = 100` has a 0 there, `1 = 001` has a 1 there.

### Step 3: make the two piles

`ones` and `zeros` are just names for two piles. They are not the numbers 1 and 0.

Look at bit `diffBit` of every number from `nums` **and** `1..n`:

```
Bit 0 is 1  ->  ones pile  :  1, 3, 5
Bit 0 is 0  ->  zeros pile :  2, 4
```

(In this example `diffBit = 0`, so the `ones` pile happens to hold the numbers whose lowest bit is 1. That is only because `diffBit` is 0 here. See the second example below, where it is not.)

All 2n numbers:

```
range: 1 2 3 4 5
nums : 1 1 2 3 5

ones pile  : 1,3,5 (range) + 1,1,3,5 (nums)
zeros pile : 2,4   (range) + 2       (nums)
```

### Step 4: XOR each pile

```
ones pile : 1^3^5^1^1^3^5 -> 3 cancels, 5 cancels, 1 appears 3 times -> one 1 left -> 1
zeros pile: 2^4^2         -> 2 cancels, 4 appears once              -> 4
```

`ones = 1`, `zeros = 4`.

### Step 5: which one is repeating?

The piles only give me two numbers. They don't say which is which. Scan `nums` and count one of them:

```
count of 'ones' (1) in nums = 2  ->  1 is the repeating number
```

So repeating = 1, missing = 4. Answer: `[1, 4]`.

---

## Why splitting into piles works

- Two copies of the same number have the **same bits**, so they always go into the **same pile**. That means they still cancel inside the pile.
- The missing and repeating numbers are **different at `diffBit`**, so they go into **different piles**.
- So each pile has exactly one number that doesn't cancel, and its XOR is that number.

If I picked a bit where `xor` has a 0, missing and repeating would have the **same** bit there, they would land in the same pile, and I would be stuck with a mixed value again.

---

## Second example where `diffBit` is NOT 0

`nums = [1, 2, 2, 3]`, `n = 4`. Repeating = **2**, missing = **4**.

```
nums XOR  = 1^2^2^3 = 2
range XOR = 1^2^3^4 = 4
xor = 2 ^ 4 = 6  (binary 110)
```

`110` has its lowest 1 at **bit 1**, so `diffBit = 1`.

Piles by bit 1 (this is NOT odd/even):

```
Bit 1 is 1 (numbers 2, 3):  ones pile  -> range 2,3  + nums 2,2,3  -> 2^3^2^2^3 = 2
Bit 1 is 0 (numbers 1, 4):  zeros pile -> range 1,4  + nums 1      -> 1^4^1     = 4
```

`ones = 2`, `zeros = 4`. Count of 2 in `nums` is 2, so 2 is repeating and 4 is missing. Answer: `[2, 4]`.

---

## Be careful: the two XORs on their own mean nothing

In my first example, XOR of `nums` was 4 and XOR of `1..5` was 1, which looks like the answer (missing and repeating). That was a **coincidence**.

`nums = [1, 2, 2, 4]` (repeating 2, missing 3):

```
XOR of nums   = 1^2^2^4 = 5
XOR of 1..4   = 1^2^3^4 = 4
```

Neither 5 nor 4 is 2 or 3. Only the combination `5 ^ 4 = 1` is reliable, and it equals `2 ^ 3`.

---

## Code (my version, fixed)

My original code was correct up to the grouping, but I **only grouped `nums`**. The `1..n` numbers have to be grouped too, otherwise nothing cancels.

```java
static int[] zor(int[] nums) {
    int n = nums.length;

    // step 1: xor = missing ^ repeating
    int xor = 0;
    for (int i = 0; i < n; i++) {
        xor ^= nums[i];
        xor ^= i + 1;
    }

    // step 2: find diffBit (lowest bit where xor has a 1)
    int diffBit = 0;
    while (true) {
        if ((xor & (1 << diffBit)) != 0) {
            break;
        }
        diffBit++;
    }

    // step 3 + 4: make the two piles and XOR each
    int ones = 0, zeros = 0;
    for (int num : nums) {
        int t = num >> diffBit;
        if ((t & 1) == 1) {
            ones ^= num;
        } else {
            zeros ^= num;
        }
    }
    // THE FIX: group 1..n the same way
    for (int num = 1; num <= n; num++) {
        int t = num >> diffBit;
        if ((t & 1) == 1) {
            ones ^= num;
        } else {
            zeros ^= num;
        }
    }

    // step 5: whichever appears twice in nums is repeating
    int cnt = 0;
    for (int x : nums) {
        if (x == ones) cnt++;
    }
    return cnt == 2 ? new int[]{ones, zeros} : new int[]{zeros, ones};
}
```

### Shorter way to find `diffBit` (optional)

`xor & -xor` gives the lowest set bit as a **mask** (like `2` or `4`) instead of an index, and it needs no loop:

```java
int bit = xor & -xor;
// test a number with: (num & bit) != 0
```

Example with `xor = 6 = 0110`: `-xor = 1010`, so `xor & -xor = 0010`. Only the lowest set bit survives.

---

## Quick recap

1. XOR everything (`nums` + `1..n`) -> `missing ^ repeating`.
2. A 1 in that result = a bit where the two numbers differ -> `diffBit`.
3. Split **all** numbers (`nums` and `1..n`) into `ones` / `zeros` piles using `diffBit`.
4. XOR each pile -> one number each.
5. Count in `nums` to see which is repeating.

Time O(n), space O(1), no overflow.
