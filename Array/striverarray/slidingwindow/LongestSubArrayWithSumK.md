# Array Problems by Concept

**User:** Anonymous  
**Created:** 6/19/2026 20:20:15  
**Updated:** 6/25/2026 9:57:20  
**Exported:** 6/25/2026 10:02:42  
**Link:** [https://chatgpt.com/c/6a3556ea-cfe0-83ee-a538-4bfbc3328769](https://chatgpt.com/c/6a3556ea-cfe0-83ee-a538-4bfbc3328769)  

## Response:
25/06/2026, 09:48:00

Broo, let’s make this like our **zero-sum subarray deep notes**.

Topic: **Longest Subarray with Sum = K**

There are **two different optimal approaches**, and choosing the wrong one is where people get confused.

---

# Step 1 — What problem wants

Given an array and `K`, find:

> Length of the **longest contiguous subarray** whose sum equals `K`

Keywords:

- subarray → contiguous
- sum = K
- longest

Example:

```text id="a07d1t"
[10, 5, 2, 7, 1, 9]
K = 15
```

Valid subarrays:

```text id="m0ukn4"
[10,5] -> 15
[5,2,7,1] -> 15
```

Longest:

```text id="nd2s53"
length = 4
```

---

# Step 2 — First question to ask

Before coding, ask:

## Are all numbers positive / non-negative?
OR
## Are negatives allowed?

This decides everything.

---

# Case 1 — Positive / Non-negative only

Use **Sliding Window / Two Pointers**

Why?

Because sum changes predictably.

---

## Core property

If all numbers are positive:

### Expanding window
(sum + new element)

```text id="em4kfw"
sum increases (or stays same for zero)
```

---

### Shrinking window
(remove left element)

```text id="e7j2sm"
sum decreases (or stays same for zero)
```

That monotonic property is the reason sliding window works.

---

# Sliding Window Approach

Maintain window:

```text id="59lcw6"
[left ... right]
```

Keep window sum.

Rules:

### sum < K
Need larger sum

→ expand right

---

### sum > K
Need smaller sum

→ shrink left

---

### sum == K
Valid subarray

→ update max length

---

## Code (Positive Numbers Only)

```java id="tjlwmq"
public static int longestSubarray(int[] arr, int k) {
    int left = 0;
    int sum = 0;
    int maxLen = 0;

    for (int right = 0; right < arr.length; right++) {
        sum += arr[right];

        while (left <= right && sum > k) {
            sum -= arr[left];
            left++;
        }

        if (sum == k) {
            maxLen = Math.max(maxLen, right - left + 1);
        }
    }

    return maxLen;
}
```

---

## Complexity (Sliding Window)

Time:

$$
O(N)
$$

Why not O(N²) despite nested loop?

Because:
- right moves at most N times
- left moves at most N times

Total pointer moves:

```text id="j4s7wz"
<= 2N
```

---

Space:

$$
O(1)
$$

---

---

# Case 2 — Negatives Allowed

Sliding window may fail.

Need:

**Prefix Sum + HashMap**

---

# Why Sliding Window Fails

This is the important part.

Sliding window assumes:

> Expanding increases sum  
> Shrinking decreases sum

Negative numbers destroy that.

---

## Failing Case

Example:

```text id="x8hrb2"
arr = [2, -1, 2]
K = 3
```

Whole array sum:

```text id="gbrd0t"
2 + (-1) + 2 = 3
```

Answer exists.

Now watch.

Start:

```text id="1kuafj"
[2]
sum = 2
```

Expand:

```text id="w5jdvz"
[2,-1]
sum = 1
```

Broo notice:

Window expanded…

But sum decreased.

That breaks sliding window assumptions.

---

Another scary case:

```text id="m6gctz"
sum = 5
remove -3
```

New sum:

```text id="qv4d1q"
8
```

Shrinking increased sum!

That completely breaks two-pointer logic.

---

# Why Prefix Sum Fixes This

Instead of relying on window behavior, use math.

Maintain prefix sum:

$$
sum = arr[0]+arr[1]+...+arr[i]
$$

Suppose at current index prefix sum is:

```text id="5xovyo"
sum
```

We want subarray sum = K.

Need earlier prefix sum such that:

$$
sum - previous = K
$$

Rearrange:

$$
previous = sum - K
$$

That’s the trick.

---

# Prefix Sum + HashMap Approach

Store:

```text id="wcd2az"
prefixSum -> first index
```

At each index:

1. Update running sum
2. If sum == K → subarray from 0 to i
3. Check if:

```java id="0j26qn"
sum - k
```

exists in hashmap

If yes:

Valid subarray exists.

Update max length.

---

## Code (Works for Negatives too)

```java id="5fttvc"
import java.util.*;

public static int longestSubarray(int[] arr, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();

    int sum = 0;
    int maxLen = 0;

    for (int i = 0; i < arr.length; i++) {
        sum += arr[i];

        if (sum == k) {
            maxLen = i + 1;
        }

        if (map.containsKey(sum - k)) {
            int len = i - map.get(sum - k);
            maxLen = Math.max(maxLen, len);
        }

        map.putIfAbsent(sum, i);
    }

    return maxLen;
}
```

---

# Complexity (Prefix Sum)

Time:

$$
O(N)
$$

Single traversal + average O(1) hashmap operations.

Space:

$$
O(N)
$$

Worst case all prefix sums unique.

---

# How to Decide Which Approach?

Broo, use this interview decision tree:

---

## Use Sliding Window when:

✅ Array has only positive / non-negative numbers  
✅ Window sum changes monotonically  
✅ Need longest/shortest subarray with condition

Examples:
- longest subarray sum K (positives)
- minimum window
- max consecutive ones

---

## Use Prefix Sum + HashMap when:

✅ Negative numbers allowed  
✅ Sum target problems  
✅ Need subarray count / length

Examples:
- subarray sum = K
- longest subarray sum = K
- zero sum subarray
- count subarrays sum K

---

# One-line Approaches

### Sliding Window
> Maintain a window of positive elements, expand when sum is smaller than K and shrink when sum exceeds K, updating max length when sum equals K.

---

### Prefix Sum + HashMap
> Maintain running prefix sum and store first occurrences in a HashMap; if `(currentSum - K)` exists, the subarray between those indices sums to K.

---

# Final Memory Rule

Broo remember just this:

> **Positive numbers → Sliding Window**  
> **Negative numbers present → Prefix Sum + HashMap**

This single rule will solve 80% of “subarray sum” confusion.



---
Powered by [ChatGPT Exporter](https://www.chatgptexporter.com)