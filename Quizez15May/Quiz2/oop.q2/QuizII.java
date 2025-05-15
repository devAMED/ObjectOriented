package oop.q2;

import java.util.*;

/**
 * <h2>Quiz #2 r</h2>
 *
 * <p>This program recreates the mapping demonstrated in the assignment’s
 * animation.  For every integer <em>v</em> in {@link #list1}, it computes the
 * odd index {@code v × 2 − 1} in {@link #list2}.  If that index is in range,
 * the corresponding string is pushed into <code>list3</code>.  At the end the
 * program prints <code>list3</code>.</p>
 *
 * <p>Although <code>list1</code> and <code>list2</code> are pre-filled with the
 * exact values from the animation, you can replace them with <em>any</em>
 * data and the same logic will still work.</p>
 *
 * <h3>Compilation &amp; execution</h3>
 * <pre>{@code
 * # from project root
 * javac -d out src/oop/q2/QuizII.java
 * java  -cp out oop.q2.QuizII
 * }</pre>
 */
public class QuizII {

    /** Integer source list  */
    static List<Integer> list1 = Arrays.asList(
            9, 8, 2, 3, 8, 3, 9, 5, 8, 7, 7, 7, 3);

    /** String lookup list  */
    static List<String> list2 = Arrays.asList(
            "dsFd", "3jY", "VDZ", "elO", "O1OnO", "0Dj", "MJC2", "cxB07",
            "fWFOy", "zISD", "t7H13", "CKa", "nAwJi", "nWF", "M2E",
            "rsPy", "69q", "2Og");

    /**
     * Builds {@code list3} with the mapping rule and prints it.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        List<String> list3 = new ArrayList<>();

        for (int v : list1) {
            int idx = v * 2 - 1;               // 0-based odd index
            if (idx >= 0 && idx < list2.size()) list3.add(list2.get(idx));
        }

        System.out.println(list3);
    }
}
