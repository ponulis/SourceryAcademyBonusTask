package com.kipras;

public class StringUtils {
    
    public static String compressString(String string)
    {   
        // Checking if provided string is empty with an additional null check to avoid NullPointerException
        if (string == null || string.isEmpty()) 
        {
            return "";
        }
        
        char[] charArray = string.toCharArray(); // Converting String to char[] for easier iteration
        char charToComp = charArray[0];
        int charCount = 0;
        StringBuilder compString = new StringBuilder(); // Initialize empty StringBuilder for the compressed version
                                                        // In a previous version I used regular Strings, but after some investigation I figured out that it is not 
                                                        // a good practice to use it while concatenating in a loop. Using StringBuilder will significanlty improve performance
                                                        // for large strings

        for (int i = 0; i < charArray.length + 1; i++) // We will be iterating through each char in charArray, plus one additional iteration to not omit the last charCount
        {
            if (i < charArray.length && charArray[i] == charToComp) // Check if iteration is still in bounds of charArray and charToComp is equal to corresponding char in the array
            {   
                // If true, we increment charCount because charToComp was repeated and get to the new iteration with continue to check for more repetitions of same char
                charCount++;
                continue;
            }
            
            // This part of the loop will only be accessed once repetition breaks, in other words, once we reach a different character that needs to be compressed
            compString.append(charToComp).append(charCount); // We then append the character which we wanted to compress and its repetition count to the result StringBuilder
            if (i < charArray.length) charToComp = charArray[i]; // Check if iteration is in bounds of charArray and if so, we move onto compressing a different character
            charCount = 1; // Repetition count is reset to 1
        }

        return compString.toString(); // Returning the compressed String
    }

    public static String decompressString(String string)
    {
        if (string == null || string.isEmpty())
        {
            return "";
        }

        char[] charArray = string.toCharArray();
        char charToDecomp = charArray[0];
        int charCount;
        StringBuilder decompString = new StringBuilder(); // Using StringBuilder for the decompressed version
        StringBuilder number = new StringBuilder(); // This will be used to temporary store the number of repetitions

        for (int i = 0; i < charArray.length; i++) // We will once again be iterating through each char in charArray, however here we don't need that additional iteration because nothing is at risk of being omitted
        {   
            if (Character.isDigit(charArray[i])) // We check if the character is a digit to know how many times the character should be repeated
            {   
                number.append(charArray[i]); // We need to store that number character in a StringBuilder in case it is multi-digit  
                if (i + 1 < charArray.length && Character.isDigit(charArray[i + 1])) continue; // We check if number is multi-digit by peeking at the next char in array with an additional check that keeps us within array boundaries
                                                                                               // If true - number is multi-digit so we skip past this iteration to get the full number
                
                // This part of the loop will only be accessed once we get the full number
                charCount = Integer.parseInt(number.toString()); // Parsing the number string to get an integer
                decompString.append(String.valueOf(charToDecomp).repeat(charCount)); // We convert the char that we need to repeat to a string, repeat it charCount times, and concatenate it to the result string
                number.setLength(0); // We reset the number before the next character 
            } 
            else // This part of the if statement is used when the char in the array is not a digit, meaning it is a char that we will need to decompress
            {
                charToDecomp = charArray[i]; // We save that char
            }
        }
        
        return decompString.toString(); // Returning the decompressed String
    }

}
