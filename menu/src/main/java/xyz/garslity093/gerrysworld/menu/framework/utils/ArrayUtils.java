package xyz.garslity093.gerrysworld.menu.framework.utils;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu.utils
 * @className: ArrayUtils
 * @author: GerryYuu
 * @date: 7/12/2022 6:36 PM
 */

public final class ArrayUtils {
    public ArrayUtils() {
    }

    public static int[] insertElement(int[] original, int element) {
        int length = original.length;
        int[] destination = new int[length + 1];
        System.arraycopy(original, 0, destination, 0, length);
        destination[length] = element;
        System.arraycopy(original, original.length, destination, length
                + 1, 0);
        return destination;
    }
}
