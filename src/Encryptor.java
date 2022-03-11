import java.util.Arrays;

public class Encryptor
{
  /** A two-dimensional array of single-character strings, instantiated in the constructor */
  private String[][] letterBlock;

  /** The number of rows of f, set by the constructor */
  private int numRows;

  /** The number of columns of letterBlock, set by the constructor */
  private int numCols;

  /** Constructor*/
  public Encryptor(int r, int c)
  {
    letterBlock = new String[r][c];
    numRows = r;
    numCols = c;
  }
  
  public String[][] getLetterBlock()
  {
    return letterBlock;
  }
  
  /** Places a string into letterBlock in row-major order.
   *
   *   @param str  the string to be processed
   *
   *   Postcondition:
   *     if str.length() < numRows * numCols, "A" in each unfilled cell
   *     if str.length() > numRows * numCols, trailing characters are ignored
   */
  public void fillBlock(String str)
  {
    int counter = 0;
    for (int row = 0; row < numRows; row++)
    {
      for (int col = 0; col < numCols; col++)
      {
        if (counter < str.length()) {
          letterBlock[row][col] = str.substring(counter, counter + 1);
        }
        else
        {
          letterBlock[row][col] = "A";
        }
        counter++;
      }
    }
  }
  public void decryptFillBlock(String decodeStr)
  {
    int counter = 0;
    for (int col = 0; col < numCols; col++)
    {
      for (int row = 0; row < numRows; row++)
      {
        if (counter < decodeStr.length()) {
          letterBlock[row][col] = decodeStr.substring(counter, counter + 1);
        }
        else
        {
          letterBlock[row][col] = "?";
        }
        counter++;
      }
    }
  }

  /** Extracts encrypted string from letterBlock in column-major order.
   *
   *   Precondition: letterBlock has been filled
   *
   *   @return the encrypted string from letterBlock
   */
  public String encryptBlock()
  {
    String returnStr = "";
    for (int col = 0; col < numCols; col++)
    {
      for (int row = 0; row < numRows; row++)
      {
        returnStr += letterBlock[row][col];
      }
    }
    return returnStr;
  }

  public String decryptBlock()
  {
    String returnStr = "";
    for (int row = 0; row < numRows; row++)
    {
      for (int col = 0; col < numCols; col++)
      {
        returnStr += letterBlock[row][col];
      }
    }
    return returnStr;
  }

  /** Encrypts a message.
   *
   *  @param message the string to be encrypted
   *
   *  @return the encrypted message; if message is the empty string, returns the empty string
   */
  public String encryptMessage(String message)
  {
    if (message.equals(""))
    {
      return "";
    }
    String returnStr = "";
    for (int i = 0; i < message.length(); i += (numCols * numRows))
    {
      String tempMessage = "";
      if (i + (numCols * numRows) > message.length())
      {
         tempMessage = message.substring(i, i + (message.length() - i));
      }
      else {
         tempMessage = message.substring(i, i + (numCols * numRows));
      }

      fillBlock(tempMessage);
      tempMessage = encryptBlock();
      returnStr += tempMessage;
    }
    return returnStr;
  }

  
  /**  Decrypts an encrypted message. All filler 'A's that may have been
   *   added during encryption will be removed, so this assumes that the
   *   original message (BEFORE it was encrypted) did NOT end in a capital A!
   *
   *   NOTE! When you are decrypting an encrypted message,
   *         be sure that you have initialized your Encryptor object
   *         with the same row/column used to encrypted the message! (i.e. 
   *         the �encryption key� that is necessary for successful decryption)
   *         This is outlined in the precondition below.
   *
   *   Precondition: the Encryptor object being used for decryption has been
   *                 initialized with the same number of rows and columns
   *                 as was used for the Encryptor object used for encryption. 
   *  
   *   @param message the encrypted message to decrypt
   *
   *   @return  the decrypted, original message (which had been encrypted)
   *
   *   TIP: You are encouraged to create other helper methods as you see fit
   *        (e.g. a method to decrypt each section of the decrypted message,
   *         similar to how encryptBlock was used)
   */
  public String decryptMessage(String message)
  {
    if (message.equals(""))
    {
      return "";
    }
    String returnStr = "";
    for (int i = 0; i < message.length(); i += (numCols * numRows))
    {
      String tempMessage = "";
          tempMessage = message.substring(i, i + (numCols * numRows));
        decryptFillBlock(tempMessage);
        tempMessage = decryptBlock();
        returnStr += tempMessage;
      }
    String returnStrTempNoAs = returnStr.substring(returnStr.length() - (numRows * numCols), returnStr.length()).replace("A", "");
    returnStr = returnStr.substring(0, returnStr.length() - (numRows * numCols)) + returnStrTempNoAs;
      return returnStr;
  }
}