/* Generated By:JavaCC: Do not edit this line. ParserConstants.java */
package parser;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface ParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int PLUS = 5;
  /** RegularExpression Id. */
  int MINUS = 6;
  /** RegularExpression Id. */
  int TIMES = 7;
  /** RegularExpression Id. */
  int DIVIDE = 8;
  /** RegularExpression Id. */
  int OPEN_PAR = 9;
  /** RegularExpression Id. */
  int CLOSE_PAR = 10;
  /** RegularExpression Id. */
  int EQUAL = 11;
  /** RegularExpression Id. */
  int TTP = 12;
  /** RegularExpression Id. */
  int VAR = 13;
  /** RegularExpression Id. */
  int SIN = 14;
  /** RegularExpression Id. */
  int COS = 15;
  /** RegularExpression Id. */
  int NUMBER = 16;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\r\"",
    "\"\\n\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "\"(\"",
    "\")\"",
    "\"=\"",
    "\"^\"",
    "<VAR>",
    "\"sin\"",
    "\"cos\"",
    "<NUMBER>",
  };

}