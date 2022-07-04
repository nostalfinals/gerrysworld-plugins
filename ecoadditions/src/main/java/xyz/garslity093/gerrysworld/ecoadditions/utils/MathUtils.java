package xyz.garslity093.gerrysworld.ecoadditions.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/*数学相关工具类*/
public final class MathUtils {
    /*私有修饰 防止被实例化*/
    private MathUtils() {
    }

    /*四舍五入保留两位小数*/
    public static double halfUpTwoDecimal(double d) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return Double.parseDouble(decimalFormat.format(d));
    }
}
