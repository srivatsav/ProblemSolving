package com.trie;

import java.util.HashMap;
import java.util.Map;

public class AddSearchRegexWord {

  TrieNode root;
  boolean isWordFound;

  /** Initialize your data structure here. */
  public AddSearchRegexWord() {
    root = new TrieNode('#');
  }

  public static void main(String[] args) {
    AddSearchRegexWord obj = new AddSearchRegexWord();
    obj.addWord("a");
    obj.addWord("a");
    // obj.addWord("mad");
    System.out.println(obj.search("aa"));
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    TrieNode currentNode = root;

    for (int i = 0; i < word.length(); i++) {
      currentNode = currentNode.getChildNode(word.charAt(i));
    }
    currentNode.makeLeaf();
  }

  /**
   * Returns if the word is in the data structure. A word could contain the dot
   * character '.' to represent any one letter.
   */
  public boolean search(String word) {
    TrieNode currentNode = root;
    return checkIfWordExists(word, currentNode, 0);
  }

  private boolean checkIfWordExists(String word, TrieNode currentNode, int idx) {

    if (idx >= word.length() && currentNode.isLeaf())
      return true;
    else if (idx >= word.length() && !currentNode.isLeaf())
      return false;
    else if (currentNode.getChildNodes().size() < word.length())
      return false;

    if (word.charAt(idx) == '.') {
      for (Map.Entry<Character, TrieNode> entry : currentNode.getChildNodes().entrySet()) {
        TrieNode value = entry.getValue();

        if (!isWordFound && checkIfWordExists(word, value, idx + 1)) {
          isWordFound = true;
          break;
        }
      }
    } else {
      currentNode = currentNode.checkIfChildExists(word.charAt(idx));

      if (currentNode != null && currentNode.isLeaf())
        isWordFound = true;
      else if (currentNode == null || idx + 1 >= word.length())
        isWordFound = false;
      else
        checkIfWordExists(word, currentNode, idx + 1);
    }

    return isWordFound;
  }
}

class TrieNode {
  char value;
  Map<Character, TrieNode> childNodes;
  boolean isLeaf;

  TrieNode(char value) {
    this.value = value;
    isLeaf = false;
    childNodes = new HashMap<Character, TrieNode>();
  }

  public TrieNode getChildNode(char value) {
    if (childNodes.get(value) == null)
      childNodes.put(value, new TrieNode(value));

    return childNodes.get(value);
  }

  public boolean isLeaf() {
    return this.isLeaf;
  }

  public void makeLeaf() {
    this.isLeaf = true;
  }

  public TrieNode checkIfChildExists(Character val) {
    return childNodes.get(val);
  }

  public Map<Character, TrieNode> getChildNodes() {
    return childNodes;
  }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
 * = obj.search(word);
 */