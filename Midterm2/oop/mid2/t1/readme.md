Overview

This Java program demonstrates a two-phase transformation using three lists:

list1 (Integer) – source indices.

list2 (String) – lookup table.

list3 (String) – result list that is first built and then pruned down.

Phase 1 – Build

For each integer v in list1:

Compute idx = v * 2 - 1.

Fetch list2.get(idx).

Append to list3 and print the current state.

Phase 2 – Remove

Repeat until only one element remains in list3:

Remove the element at index step % list3.size().

Print the updated list3 after each removal.

Screenshot

<img width="1470" alt="Screenshot 2025-05-29 at 9 54 13 AM" src="https://github.com/user-attachments/assets/2f0a0960-1a3a-4d73-bc5c-a5e7c68c9c07" />

