/***************************************************************************
 * Author: Zachary Hoffmann                                                *
 * ID: 1214623033                                                          *
 * Date: 12/2/19                                                           *
 * Description:                                                            *
 *      This class reads in a file whose path is passed into the           *
 *  constructor.  The file is opened and read line by line, checking       *
 *  for invalid flags (and removing them) or non-ascii characters (and     * 
 *  removing them).  The original file is written over and replaced with   *
 *  only the words and flags of the original text file to make processing  *
 *  easier.                                                                *
 ***************************************************************************/


import java.io.*;
import java.lang.StringBuilder;
import java.nio.charset.Charset;
import java.util.Arrays;

public class InitialCleaner{
    private File fo;
    private FileReader fr;
    private BufferedReader br;
    private StringBuffer cleanedBuffer;
    private String line;
    private String filePath;
    private String outputFilePath;
    private int currentLineNumber;
    private int FLAG_LENGTH = 2;

    public InitialCleaner(String filePath){
        try {
            this.fo = new File(filePath);
            this.fr = new FileReader(fo);
            this.br = new BufferedReader(fr);
            this.cleanedBuffer = new StringBuffer();
        }catch(Exception e){
                /**********************************************************************************************************
                 * ERROR CONDITION----PRINT TO ERROR LOG
                 **********************************************************************************************************/
            System.out.println("FileNotFound Exception\n");
        }
        
        this.outputFilePath = "";
        this.filePath = filePath;
        this.line = "";
        this.currentLineNumber = 1;
    }

    //main driver function for initial scrubbing
    public void clean_input(){
        System.out.println("InitialCleaner: ");
        try{
            while((this.line = br.readLine()) != null){
                if(line.length() > 0){

                    //System.out.println(this.line);
                    //TODO
                    this.parse_line();
                    
                } //end while if

                currentLineNumber++;
            }// end while

            System.out.println("-------------------------------------------------\n");
            System.out.println(cleanedBuffer.toString());

            this.write_to_file();

        }catch(Exception e){
                /**********************************************************************************************************
                 * ERROR CONDITION----PRINT TO ERROR LOG
                 **********************************************************************************************************/
            System.out.println("File read Error");
        }
    }
    

    /* Processing for each line.  
    *
    *  Splits each line into an array of strings and checks for flags and non ascii characters and formats one space between each string
    */
    public void parse_line(){
        String[] lineArray = this.line.split("\\s+"); 
        boolean isAscii = true;
        boolean isFlag = false;
        int sameLineFlag = 0;

        System.out.println(); //DEBUG------------------------------

        for(int i = 0; i < lineArray.length; i++){

            //check if only valid ascii characters
            isAscii = Charset.forName("US-ASCII").newEncoder().canEncode(lineArray[i]);

            //if the string contains non-ascii chars, remove them.  
            if(!isAscii){lineArray[i] = remove_non_ascii_chars(lineArray[i]);}

            //if the string is "-*" where * is some char, check to see if that is a valid char flag first, if not remove it,
            // then make the entire line just that flag. 
            if(lineArray[i].length() == FLAG_LENGTH
             && lineArray[i].substring(0, 1).compareToIgnoreCase("-") == 0){  //MAYBE MAKE IT SPLIT VALID FLAGS INTO THEIR OWN LINES
                
                isFlag = is_valid_flag(lineArray[i].charAt(1));
                if(isFlag){
                    //make the output line only the flag
                    if(sameLineFlag > 0){
                        /**********************************************************************************************************
                        * ERROR CONDITION----PRINT TO ERROR LOG
                        **********************************************************************************************************/
                        System.out.println("MULTIPLE FLAGS ON SAME LINE");
                        System.out.println(lineArray[i] + " has been moved to new line");
                    }

                    sameLineFlag++;
                    this.add_string_to_output("\n");
                    this.add_string_to_output(lineArray[i]);
                    this.add_string_to_output("\n");
                    System.out.println("FLAG FOUND: " + lineArray[i]);  //DEBUG -----------------------------------------------------------------
                }
            }else{
                //stringToBuild.append(lineArray[i].replaceAll("\\s", "") + new String(","));
                this.add_string_to_output(lineArray[i]);
                this.add_string_to_output(" ");
            }
        }   
        //add the newline char at the end
        this.add_string_to_output("\n");
    }


    //method for this to avoid confusion 
    public void add_string_to_output(String toAdd){
        cleanedBuffer.append(toAdd);
    }

    /*  remove_non_ascii_chars():  Will remove any non ascii char from a given string
    *     
    *   Description:
    *       function will iterate through nonAsciiString one character at a time until it finds the non ascii 
    *       values and removes them, then returns the string of what is left. 
    *       if * is a non ascii char:  abc*de ---> abcde
    */
    public String remove_non_ascii_chars(String nonAsciiString){
        int character;
        String onlyAsciiString = "";
        
        for(int i = 0; i < nonAsciiString.length(); i++){
            character = nonAsciiString.charAt(i);
            if(character <= 0x7F){
                onlyAsciiString = onlyAsciiString + (char)character;
            }else{
                /**********************************************************************************************************
                 * ERROR CONDITION----PRINT TO ERROR LOG
                 **********************************************************************************************************/
                System.out.println("ERROR: non ascii character '" + (char)character +"' was removed in line: " + this.currentLineNumber);
            }
        }
        
        return onlyAsciiString;
    }

    /* Method to check if character flag found is valid
    *
    *  returns true if valid, returns false and prints error message otherwise. 
    */
    public boolean is_valid_flag(char flag){
        switch(flag){
            case 'r':return true;
            case 'c': return true;
            case 'l': return true;
            case 't': return true;
            case 'd': return true;
            case 's': return true;
            case 'i': return true;
            case 'b': return true;
            case '2': return true;
            case '1': return true;
            case 'e': return true;
            default:
                /**********************************************************************************************************
                 * ERROR CONDITION----PRINT TO ERROR LOG
                 **********************************************************************************************************/
                System.out.println("INVALID FLAG: -" + flag + " ignored\n");
                return false;
        }//end switch
    }//end of is_valid_flag

    public void write_to_file(){
        StringBuilder newFilePath = new StringBuilder(this.filePath);



        try{                
            File outFile = new File("testOut.txt");
            FileWriter fw = new FileWriter(outFile);
            fw.write(this.cleanedBuffer.toString());
            fw.close();

        }catch(Exception e){
            System.out.println("ERROR: file unable to be written");
        }
        

    }
}//end of class