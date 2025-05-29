package oop.mid2.t1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>Two-Phase List Transformation (Task #1)</h1>
 * <p>
 * This program demonstrates a two-phase process using three lists:
 * <ol>
 *   <li><b>list1</b> (&lt;Integer&gt;) – a sequence of indices.</li>
 *   <li><b>list2</b> (&lt;String&gt;) – a lookup table of string values.</li>
 *   <li><b>list3</b> (&lt;String&gt;) – the result list that is built and then
 *       pruned down to a single element.</li>
 * </ol>
 *
 * <strong>Phase 1 – Build:</strong><br>
 * Iterate over each integer <code>v</code> in <code>list1</code>, compute
 * <code>idx = v * 2 - 1</code>, fetch <code>list2.get(idx)</code>, append it
 * to <code>list3</code>, and print the list state after each addition.
 *
 * <strong>Phase 2 – Remove:</strong><br>
 * Repeatedly remove exactly one element from <code>list3</code> at a time
 * (using <code>step % list3.size()</code> to wrap the removal index) until
 * only one element remains. After each removal, print the updated list.
 *
 * <p>
 * At the end, the final surviving element is printed, matching the behavior
 * shown in the provided HTML animation.
 * </p>
 *
 * <p><strong>Usage:</strong></p>
 * <pre>
 *   javac -d out src/oop/mid2/t1/Task1.java
 *   java -cp out oop.mid2.t1.Task1
 * </pre>
 *
 * @author Muhammad Ahmed
 * @since   2025-05-29
 */
public class Task1 {

    public static void main(String[] args) {
        // 1) Initialize inputs exactly as in the animation
        List<Integer> list1 = Arrays.asList(
                9, 8, 2, 3, 8, 3, 9, 5, 8, 7, 7, 7, 3
        );
        List<String> list2 = Arrays.asList(
                "dsFd", "3jY", "VDZ", "elO", "O1OnO", "0Dj", "MJC2", "cxB07",
                "fWFOy", "zISD", "t7H13", "CKa", "nAwJi", "nWF", "M2E", "rsPy",
                "69q", "2Og"
        );

        // Phase 1: build list3
        List<String> list3 = new ArrayList<>();
        System.out.println("=== Phase 1: Building list3 ===");
        for (int i = 0; i < list1.size(); i++) {
            int v = list1.get(i);
            int idx = v * 2 - 1;                  // compute lookup index
            String mapped = list2.get(idx);      // fetch from list2
            list3.add(mapped);                   // append to list3
            System.out.printf(
                    "Step %2d: took list1[%2d]=%d → list2[%2d]=%s → list3=%s%n",
                    i + 1, i, v, idx, mapped, list3
            );
        }

        // Phase 2: remove until one remains
        System.out.println("\n=== Phase 2: Removing from list3 ===");
        int step = 0;
        while (list3.size() > 1) {
            int removeIdx = step % list3.size(); // wrap removal index
            String removed = list3.remove(removeIdx);
            System.out.printf(
                    "Remove %2d: removed \"%s\" at idx %d → list3=%s%n",
                    step + 1, removed, removeIdx, list3
            );
            step++;
        }

        // Final report
        System.out.println("\n=== Done ===");
        System.out.println("Final element left in list3: " + list3.get(0));
    }
}
