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

    // Build catMap, mapping a character to a category.
    for (TableReader.CharCat cat : tableReader.getClassifier()) {
      System.out.println("Character " + cat.getC() + " is of category "
              + cat.getCategory());
    }

    // Build the transition table. Given a state and a character category,
    // give a new state.
    for (TableReader.Transition t : tableReader.getTransitions()) {
      System.out.println(t.getFromStateName() + " -- " + t.getCategory()
              + " --> " + t.getToStateName());
    }

    // Build the token types table
    for (TableReader.TokenType tt : tableReader.getTokens()) {
      System.out.println("State " + tt.getState()
              + " accepts with the lexeme being of type " + tt.getType());
    }

  }

  /**
   * Returns the category for c or "not in alphabet" if c has no category. Do not hardcode
   * this. That is, this function should have nothing more than a table lookup
   * or two. You should not have any character literals in here such as 'r' or '3'.
   */
  public String getCategory(Character c) {
    return "";
  }

  /**
   * Returns the new state given a current state and category. This models
   * the transition table. Returns "error" if there is no transition.
   * Do not hardcode any state names or categories. You should have only
   * table lookups here.
   */
  public String getNewState(String state, String category) {
    return "";
  }

  /**
   * Returns the type of token corresponding to a given state. If the state
   * is not accepting then return "error".
   * Do not hardcode any state names or token types.
   */
  public String getTokenType(String state) {
    return "";
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