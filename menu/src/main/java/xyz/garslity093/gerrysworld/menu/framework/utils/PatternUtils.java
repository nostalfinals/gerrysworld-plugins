package xyz.garslity093.gerrysworld.menu.framework.utils;

import java.util.Arrays;
import java.util.List;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu.utils
 * @className: PatternUtils
 * @author: GerryYuu
 * @date: 7/12/2022 6:15 PM
 */

public final class PatternUtils {
    public PatternUtils() {
    }

    public static int[] process(char patternChar, String[] pattern, int[]... line) {
        int[] ints = new int[0];
        System.out.println("pattern " + Arrays.toString(pattern));
        System.out.println("line " + Arrays.toString(line));
        System.out.println("list of pattern" + List.of(pattern));
        for (int a = 0; a < pattern.length; a++) {
            System.out.println(pattern.length);
            System.out.println("outside1111");
            System.out.println("line" + pattern[a]);
            System.out.println("line size is " + line.length);
            for (int i = 0; i < pattern[a].length(); i++) {
                //System.out.println("inside1111");
                System.out.println("char " + pattern[a].charAt(i));
                System.out.println("try to in " + line[a][i]);
                if (pattern[a].charAt(i) == patternChar) {
                    //System.out.println("s" + List.of(pattern).indexOf(s));
                    //System.out.println("i" + i);
                    ints = ArrayUtils.insertElement(ints, line[a][i]);
                    System.out.println("inserted " + line[a][i]);
                }
            }
        }
        return ints;
    }
}
