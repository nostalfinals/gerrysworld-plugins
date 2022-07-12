package xyz.garslity093.gerrysworld.menu.utils;

import java.util.List;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu.utils
 * @className: PatternUtils
 * @author: GerryYuu
 * @date: 7/12/2022 6:15 PM
 */

public class PatternUtils {
    public PatternUtils() {
    }

    public static int[] process(char patternChar, String[] pattern, int[]... line) {
        int[] ints = new int[0];
        for (String s : pattern) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == patternChar) {
                    ints = ArrayUtils.insertElement(ints, line[List.of(pattern).indexOf(s)][i]);
                }
            }
        }
        return ints;
    }
}
