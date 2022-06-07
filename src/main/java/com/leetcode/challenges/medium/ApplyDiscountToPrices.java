package com.leetcode.challenges.medium;

import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplyDiscountToPrices {
    public static String applyDiscountToPrices(String sentence, int discount){
        Pattern pattern = Pattern.compile("\\s\\$\\d+(?:\\s|$)");
        Matcher matcher = pattern.matcher(sentence);
        String[] sentences = pattern.split(sentence);
        Iterator<String> itr = Arrays.stream(sentences).iterator();
        StringBuilder res = new StringBuilder();

        while(matcher.find()){
            int start = matcher.start();
            int end = matcher.end();
            Double num = Double.parseDouble(sentence.substring(start+2, end != sentence.length() ? end-1: end));
            System.out.println(num);
            Double percentage = ((double)discount)/100.0;
            Double savings = ((double)num) * percentage;
            Double correctedValue = num-savings;

            String str2 = "$" + correctedValue;
            if(start == 0)
                res.append(str2 + " ");
            else
                res.append(itr.next() + " " + str2 + " ");
        }
        if(itr.hasNext())
            res.append(itr.next());

        return res.toString().trim();
    }

    public static void main(String[] args) {
        String res = applyDiscountToPrices("there are $1 $2 and 5$ candies in the shop", 50);
        System.out.println(res);
    }
}
