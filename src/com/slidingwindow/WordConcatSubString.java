package com.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordConcatSubString {
  public static void main(String[] args) {
    String str = "wordgoodgoodgoodbestword";
    String[] words = { "word", "good", "best", "word" };
    List<Integer> res = findWordConcatenation(str, words);
    for (Integer n : res) {
      System.out.println(n);
    }
  }

  private static List<Integer> findWordConcatenation(String str, String[] words) {
    List<Integer> res = new ArrayList<>();

    int wordCount = words.length;
    int wordLength = words[0].length();

    Map<String, Integer> map = new HashMap<>();
    for (String s : words) {
      map.put(s, map.getOrDefault(s, 0) + 1);
    }

    for (int i = 0; i <= str.length() - wordCount * words[0].length(); i++) {
      Map<String, Integer> wordsSeen = new HashMap<>();

      for (int j = 0; j < wordCount; j++) {
        int nextWordIndex = i + j * wordLength;

        String temp = str.substring(nextWordIndex, nextWordIndex + wordLength);

        if (!map.containsKey(temp))
          break;

        wordsSeen.put(temp, wordsSeen.getOrDefault(temp, 0) + 1);

        if (wordsSeen.size() == wordCount) {
          res.add(i);
        }
      }
    }

    return res;
  }
}