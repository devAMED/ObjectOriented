package t1;

import java.util.*;

/**
 *  <p><b>Goal.</b>  We have two lists:</p>
 *  <ul>
 *      <li><b>list1 (Integer)</b> – each number is a <i>1-based</i> index,</li>
 *      <li><b>list2 (String)</b>  – a pool of words.</li>
 *  </ul>
 *
 *  <p>For every number <code>v</code> in <code>list1</code> we copy the word
 *  at position <code>v − 1</code> in <code>list2</code> into
 *  <code>list3</code>.
 *  If the number is out of range, we store <code>null</code> so the order is
 *  preserved.</p>
 *
 *  <h3>Example with the predefined data (same as the web animation)</h3>
 *  <pre>
 *      list1 = [5, 7, 9, 4, 2, 1, 3, 6, 10, 8]
 *      list2 = ["uiu","bzc","fuw","ang","gga","eog",
 *               "kpv","etk","dne","oqy","tid","hph"]
 *
 *      v = 5  →  list2[4] = "gga"  →  list3[0]
 *      v = 7  →  list2[6] = "kpv"  →  list3[1]
 *      ⋯
 *      list3 = ["gga","kpv","dne","ang","bzc",
 *               "uiu","fuw","eog","oqy","etk"]
 *  </pre>
 *
 *  <h3>Algorithm</h3>
 *  <ol>
 *      <li>Create an empty <code>ArrayList&lt;String&gt;</code> sized like list1.</li>
 *      <li>Loop through list1; convert each 1-based index to 0-based.</li>
 *      <li>Copy the word from list2 if the index is valid, else insert <code>null</code>.</li>
 *  </ol>
 *  <p>Complexity&nbsp;: <b>O(n)</b> time, <b>O(n)</b> space.</p>
 *
 *  <h3>Usage</h3>
 *  <pre>
 *      # from project root
 *      javac src/t1/Task1.java
 *      java  -cp src t1.Task1
 *
 *      # generate the HTML docs (optional)
 *      javadoc -d docs -encoding UTF-8 -charset UTF-8 src/t1/Task1.java
 *  </pre>
 *
 */
public final class Task1 {

    /** Utility class – no instances needed. */
    private Task1() {}

    public static void main(String[] args) {

        // Exact input from the animation
        List<Integer> list1 = Arrays.asList(5, 7, 9, 4, 2, 1, 3, 6, 10, 8);

        List<String> list2 = Arrays.asList(
                "uiu", "bzc", "fuw", "ang", "gga", "eog",
                "kpv", "etk", "dne", "oqy", "tid", "hph"
        );

        // Build result list
        List<String> list3 = new ArrayList<>(list1.size());

        for (int v : list1) {
            int i = v - 1;                               // 1-based → 0-based
            list3.add(i >= 0 && i < list2.size() ? list2.get(i) : null);
        }

        // Quick verification
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        System.out.println("list3 = " + list3);
    }
}
