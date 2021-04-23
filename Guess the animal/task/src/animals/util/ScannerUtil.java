package animals.util;

import java.util.Scanner;

public class ScannerUtil {
    private static Scanner sc = null;

    public static Scanner getInstance() {
        if (sc == null) {
            synchronized(ScannerUtil.class) {
                if (sc == null)
                    sc = new Scanner(System.in);
            }
        }
        return sc;
    }

    private ScannerUtil() {
        sc = new Scanner(System.in);
    }
}