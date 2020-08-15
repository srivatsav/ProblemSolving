package com.dynamic.programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {

  static List<String> res = new ArrayList<String>();

  public static void main(String[] args) {

    String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    List<String> wordList = new ArrayList<String>();
    wordList.add("a");
    wordList.add("aa");
    wordList.add("aaa");
    wordList.add("aaaa");
    wordList.add("aaaaa");
    wordList.add("aaaaaa");
    wordList.add("aaaaaaa");
    wordList.add("aaaaaaaa");
    wordList.add("aaaaaaaaa");
    wordList.add("aaaaaaaaaa");

    wordBreak(str, wordList);

    for (String sentence : res) {
      System.out.println(sentence);
    }
  }

  private static List<String> wordBreak(String s, List<String> wordDict) {

    if (s.length() == 0)
      return res;

    wordBreakHelper(s, wordDict, new ArrayList<String>(), new HashSet<String>());

    return res;
  }

  private static void wordBreakHelper(String str, List<String> dict, List<String> sentence, Set<String> set) {
    if (str == null || str.length() == 0) {
      StringBuilder sb = new StringBuilder();
      for (String word : sentence) {
        sb.append(word);
        sb.append(" ");
      }
      sb.deleteCharAt(sb.length() - 1);
      res.add(sb.toString());
      return;
    }

    // if (set.contains(str)) {
    // sentence.add(str);
    // wordBreakHelper(str.substring(str.length()), dict, sentence, set);
    // return;
    // }

    for (String word : dict) {
      if (str.startsWith(word)) {
        sentence.add(word);
        wordBreakHelper(str.substring(word.length()), dict, sentence, set);
        sentence.remove(sentence.size() - 1);
      }
    }

    // set.add(str);
  }
}