

# 1) Simple Traversal / Simulation (Single Pass)
Pattern: Just scan array once and keep updating something.

- **Largest Element**
  - Keep max while traversing
  - Concept: **Linear traversal**

- **Linear Search**
  - Check each element
  - Concept: **Linear traversal**

- **Maximum Consecutive Ones**
  - Count streak of 1s
  - Concept: **Counter while traversing**

---

# 2) Maintain Multiple Variables (Greedy Tracking)
Pattern: Need more than one variable while traversing.

- **Second Largest Element**
  - Maintain `largest` and `secondLargest`
  - Concept: **State tracking / greedy**

---

# 3) Sorted Array Exploitation (Two Pointer-ish)
Pattern: Since array is sorted, exploit order.

- **Remove Duplicates from Sorted Array**
  - Use `i` and `j`
  - Concept: **Two pointers (slow-fast)**

- **Union of Two Sorted Arrays**
  - Traverse both arrays simultaneously
  - Concept: **Merge / two pointers**

---

# 4) Rotation / Reversal Pattern
Pattern: Circular shifting.

- **Left Rotate Array by One**
  - Save first, shift all
  - Concept: **Array shifting**

- **Left Rotate Array by K Places**
  Optimal:
  1. Reverse first k
  2. Reverse remaining
  3. Reverse whole
  Concept: **Reversal algorithm**

---

# 5) Partitioning / Rearrangement
Pattern: Move some elements to one side.

- **Move Zeros to End**
  Optimal:
  - Find first zero
  - Swap non-zero forward
  Concept: **Two pointers / partitioning**

---

# 6) Order Checking
Pattern: Verify condition over neighbors.

- **Check if Array is Sorted II**
  (Rotated sorted array)
  - Count number of drops (`arr[i] > arr[i+1]`)
  - If >1 → false
  Concept: **Pattern observation / circular traversal**

---

# 7) Math / Formula Based
Pattern: Use arithmetic instead of extra space.

- **Find Missing Number**
  Methods:
  - Sum formula
  - XOR
  Concept: **Math + Bit manipulation**

---

# 8) XOR / Bit Manipulation
Pattern: XOR cancels duplicates.

- **Find number appearing once, others twice**
  ```
  a ^ a = 0
  0 ^ x = x
  ```
  Concept: **Bit manipulation**

---

# 9) Sliding Window / Two Pointers
Pattern: Continuous subarray.

- **Longest subarray with given sum K (positives only)**
  Since all positive:
  - Expand window if sum < k
  - Shrink if sum > k
  Concept: **Sliding window / two pointers**

---

# 10) Prefix Sum + HashMap
Pattern: Subarray sum with negatives allowed.

- **Longest subarray with sum K**
  (positives + negatives + zero)

Optimal:
- Store prefix sum in hashmap
- If `(prefixSum - K)` exists → subarray found

Concept: **Prefix Sum + HashMap**

---

# Final Big Picture (Most Important)
If you reduce all 14 questions, Striver is teaching only these **10 core patterns**:

1. Linear traversal  
2. State tracking  
3. Two pointers  
4. Reversal  
5. Partitioning  
6. Sorted array exploitation  
7. Sliding window  
8. Prefix sum  
9. HashMap  
10. XOR / Bit tricks  

