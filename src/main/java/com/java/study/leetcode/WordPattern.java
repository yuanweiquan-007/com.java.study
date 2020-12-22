package com.java.study.leetcode;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/17 7:34 下午
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        byte[] patternBytes = pattern.getBytes();
        int maxNumber = patternBytes.length;
        String[] split = s.split(" ");
        if (maxNumber != split.length) {
            return false;
        }
        for (int i = 0; i < patternBytes.length - 1; i++) {
            for (int j = i + 1; j < patternBytes.length; j++) {
                if ((patternBytes[i] == patternBytes[j] && !split[i].equals(split[j]))
                        || (patternBytes[i] != patternBytes[j] && split[i].equals(split[j]))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        String pattern = "abba";
        String context = "dog cat cat dog";
        System.out.println(new WordPattern().wordPattern(pattern, context));
    }

}
