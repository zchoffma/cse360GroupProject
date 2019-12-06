package app;
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
    private StringBuffer errorlogBuffer;
    private Boolean passedClean;
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
            this.errorlogBuffer = new StringBuffer();
        }catch(Exception e){
            /**********************************************************************************************************
            * ERROR CONDITION----File Not Found
            **********************************************************************************************************/
            this.errorlogBuffer = new StringBuffer();
            this.passedClean = false;
            this.errorlogBuffer.append("FileNotFound: " + filePath + " not found\n");
            this.errorlogBuffer.append("\n");
            System.out.println("FileNotFound Exception\n");
        }
        
        this.passedClean = true;
        this.outputFilePath = "";
        this.filePath = filePath;
        this.line = "";
        this.currentLineNumber = 1;
    }

    //main driver function for initial scrubbing
    public void clean_input(){
        if(!is_passed()){
            return;
        }

        try{
            while((this.line = br.readLine()) != null){

                if(line.length() > 0){
                    this.parse_line(); 
                }
                this.currentLineNumber++;
            }// end while
        }catch(Exception e){
            /**********************************************************************************************************
            * ERROR CONDITION----File Read Error
            **********************************************************************************************************/
            this.passedClean = false;
            this.errorlogBuffer.append("FileReadError: Unknown Source");
            this.errorlogBuffer.append("\n");
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
                        * ERROR CONDITION----Multiple Flags on Same Line
                        **********************************************************************************************************/
                        this.errorlogBuffer.append("SameLineFlag: Multiple Flags on Same Line\n");
                        this.errorlogBuffer.append("'" + lineArray[i] + "' moved to new line\n");
                    }

                    sameLineFlag++;
                    this.add_string_to_output("\n");
                    this.add_string_to_output(lineArray[i]);
                    this.add_string_to_output("\n");
                    //System.out.println("FLAG FOUND: " + lineArray[i]);  //DEBUG -----------------------------------------------------------------
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
                 * ERROR CONDITION---- Non Ascii Char
                 **********************************************************************************************************/
                this.errorlogBuffer.append("NonAsciiChar: "+ (char)character + " removed on line: " + this.currentLineNumber);
                this.errorlogBuffer.append("\n");
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
                 * ERROR CONDITION----Invalid Flag
                 **********************************************************************************************************/
                this.errorlogBuffer.append("InvalidFlag: -" + flag + " ignored\n");
                return false;
        }//end switch
    }//end of is_valid_flag



    //Cleans file and writes it to  (filename)Cleaned.txt and returns file path
    public String write_to_file(){
        StringBuilder newFilePath = new StringBuilder(this.filePath);
        newFilePath.replace(this.filePath.length() - 4, this.filePath.length(), "Cleaned.txt");

        try{                
            File outFile = new File(newFilePath.toString());
            FileWriter fw = new FileWriter(outFile);
            fw.write(this.cleanedBuffer.toString());
            fw.close();

        }catch(Exception e){
            /**********************************************************************************************************
            * ERROR CONDITION----Unable to Write to File
            **********************************************************************************************************/
            this.errorlogBuffer.append("CleanedWriteError: cannot write cleaned file\n");
            this.passedClean = false;

        }

        return newFilePath.toString();
    }

    //getter for errorLog text area
    public String get_errors(){
        return this.errorlogBuffer.toString();
    }
    
    //getter for whether or not the file was processed
    public boolean is_passed(){
        return this.passedClean;
    }
}//end of class