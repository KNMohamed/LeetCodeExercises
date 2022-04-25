package com.leetcode.challenges.easy;
import java.util.*;
import java.util.stream.IntStream;

public class TandemBicycle {
    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        int[] allSpeeds = Arrays.copyOf(redShirtSpeeds,redShirtSpeeds.length+blueShirtSpeeds.length);
        System.arraycopy(blueShirtSpeeds,0,allSpeeds,redShirtSpeeds.length,blueShirtSpeeds.length);
        Arrays.sort(allSpeeds);

        int startIdx = fastest ? redShirtSpeeds.length : 0;
        int endIdx = fastest ? redShirtSpeeds.length*2 : redShirtSpeeds.length;
        int[] arrayToSum = IntStream.range(startIdx,endIdx).map(i -> allSpeeds[i]).toArray();
        return Arrays.stream(arrayToSum).sum();
    }

    public static void main(String[] args) {
        int[] redShirtSpeeds = new int[]{5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = new int[]{3, 6, 7, 2, 1};
        boolean fastest = false;
        int speed = tandemBicycle(redShirtSpeeds,blueShirtSpeeds,fastest);
        System.out.println(speed);
    }
}
