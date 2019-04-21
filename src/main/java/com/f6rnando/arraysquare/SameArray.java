package com.f6rnando.arraysquare;

public class SameArray {

    public static boolean compare(int[] arrayA, int[] arrayB) {
        boolean isTheSame;

        if (arrayA == null || arrayB == null
                || arrayA.length == 0 || arrayB.length == 0
                || (arrayA.length != arrayB.length)) {
            isTheSame = false;
        } else {
            isTheSame = true;
        }

        return isTheSame;
    }
}
