package scanner;

import java.util.HashMap;
import java.util.Stack;

/**
 * This is the file you will modify.
 */
public class Scanner {

  //------------------------------------------------------------
  // TODO: declare the HashMaps that you will use to store
  // your tables. Also declare the start state.
  //------------------------------------------------------------
  private HashMap<Character, String> classifierTable;
  private HashMap<String, String> transitionTable;
  private HashMap<String, String> tokenTypeTable;

  //------------------------------------------------------------
  // TODO: build your tables in the constructor and implement
  // the get methods.
  //------------------------------------------------------------

  /**
   * Builds the tables needed for the scanner.
   */
  public Scanner(TableReader tableReader) {
    // TODO: starting with the skeleton code below, build the
    // classifer, transition and token type tables. You will need
    // to also implement the test functions below once you have your
    // tables built.

    this.classifierTable = new HashMap<>();
    this.transitionTable = new HashMap<>();
    this.tokenTypeTable = new HashMap<>();

    // Build catMap, mapping a character to a category.
    for (TableReader.CharCat cat : tableReader.getClassifier()) {
      System.out.println("Character " + cat.getC() + " is of category "
              + cat.getCategory());
      classifierTable.put(cat.getC(), cat.getCategory());
    }
    //System.out.printf("The size of the Classifier Table is: %d\n", classifierTable.size());

    // Build the transition table. Given a state and a character category,
    // give a new state.
    for (TableReader.Transition t : tableReader.getTransitions()) {
      System.out.println(t.getFromStateName() + " -- " + t.getCategory()
              + " --> " + t.getToStateName());
      transitionTable.put(String.format("%s,%s", t.getFromStateName(), t.getCategory()), t.getToStateName());
    }
    //System.out.printf("The size of the Transition Table is: %d\n", transitionTable.size());

    // Build the token types table
    for (TableReader.TokenType tt : tableReader.getTokens()) {
      System.out.println("State " + tt.getState()
              + " accepts with the lexeme being of type " + tt.getType());
      tokenTypeTable.put(tt.getState(), tt.getType());
    }
    //System.out.printf("The size of the Token Type Table is: %d\n", tokenTypeTable.size());

  }

  /**
   * Returns the category for c or "not in alphabet" if c has no category. Do not hardcode
   * this. That is, this function should have nothing more than a table lookup
   * or two. You should not have any character literals in here such as 'r' or '3'.
   */
  public String getCategory(Character c) {

    if(classifierTable.containsKey(c)){
      return classifierTable.get(c);
    }

    return "not in alphabet";
  }

  /**
   * Returns the new state given a current state and category. This models
   * the transition table. Returns "error" if there is no transition.
   * Do not hardcode any state names or categories. You should have only
   * table lookups here.
   */
  public String getNewState(String state, String category) {

    String key = String.format("%s,%s", state, category);

    if(transitionTable.containsKey(key)){
      return transitionTable.get(key);
    }

    return "error";
  }

  /**
   * Returns the type of token corresponding to a given state. If the state
   * is not accepting then return "error".
   * Do not hardcode any state names or token types.
   */
  public String getTokenType(String state) {

    if(tokenTypeTable.containsKey(state)){
      return tokenTypeTable.get(state);
    }

    return "error";
  }

  //------------------------------------------------------------
  // TODO: implement nextToken
  //------------------------------------------------------------

  /**
   * Return the next token or null if there's a lexical error.
   */
  public Token nextToken(ScanStream ss) {
    // TODO: get a single token. This is an implementation of the nextToken
    // algorithm given in class. You may *not* use TableReader in this
    // function. Return null if there is a lexical error.
    return null;
  }

}
