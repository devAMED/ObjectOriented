 Quiz II 
Overview  
QuizII is a single-class Java program package oop.q2 that recreates the transformation shown in the assignment animation.  
Given two lists:

list1 – integers  
list2 – strings  

it builds list3 by placing, for each integer v in list1, the string found at the odd index v × 2 − 1 of list2 (0-based).  
If an index falls outside the bounds of list2 the value is skipped.

The default literals exactly match the animation, but any values may be substituted without code changes.

---

1. Initialise list3 as an empty ArrayList<String>.  
2. Loop over every v in list1.  
Compute idx = v * 2 - 1.  
If 0 ≤ idx < list2.size(), append list2.get(idx) to list3.  
3. Print list3.  

---


