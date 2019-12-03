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

public class InitialCleaner{
    private File fo;
    private FileReader fr;
    private BufferedReader br;
    private StringBuffer inputBuffer;
    private String line;
    private int currentLineNumber;
    private int FLAG_LENGTH = 2;

    public InitialCleaner(String filePath){
        try {
            this.fo = new File(filePath);
            this.fr = new FileReader(fo);
            this.br = new BufferedReader(fr);
            this.inputBuffer = new StringBuffer();
        }catch(Exception e){
            System.out.println("FileNotFound Exception\n");
        }
        
        this.line = "";
        this.currentLineNumber = 1;
    }

    //main driver function for initial scrubbing
    public void clean_input(){
        System.out.println("InitialCleaner: ");
        try{
            while((this.line = br.readLine()) != null){
                if(line.length() > 0){

                    System.out.println(this.line);
                    //TODO
                    this.parse_line();
                    
                } //end while if

                currentLineNumber++;
            }// end while

            System.out.println("-------------------------------------------------\n");
            System.out.println(inputBuffer.toString());

        }catch(Exception e){
            System.out.println("File read Error");
        }
    }
    

    /* Processing for each line.  
    *
    *  Splits each line into an array of strings and checks for flags and non ascii characters
    */
    public void parse_line(){
        String[] lineArray = this.line.split(" ", 0);
        String stringToAdd = "";
        boolean isAscii = true;
        boolean isFlag = false;

        for(int i = 0; i < lineArray.length; i++){
            //check if only valid ascii characters
            isAscii = Charset.forName("US-ASCII").newEncoder().canEncode(lineArray[i]);
            //if the string contains non-ascii chars, remove them.  
            if(!isAscii){lineArray[i] = remove_non_ascii_chars(lineArray[i]);}

            //if the string is "-*" where * is some char, check to see if that is a valid char flag first, if not remove it,
            // then make the entire line just that flag. 
            if(lineArray[i].length() == FLAG_LENGTH && lineArray[i].substring(0, 1).compareToIgnoreCase("-") == 0){
                isFlag = is_valid_flag(lineArray[i].charAt(1));
                
                if(isFlag){
                    //make the output line only the flag
                    stringToAdd = lineArray[i];
                    System.out.println("FLAG FOUND: " + stringToAdd);
                }
            }else{
                stringToAdd = stringToAdd + lineArray[i] + " ";
            }
        }   

        //add the line plus a newline char at the end
        stringToAdd = stringToAdd + "\n";
        
        inputBuffer.append(stringToAdd);
    }

    /*
    *      TODO
    */
    public String remove_non_ascii_chars(String nonAsciiString){
        //TODO
        return nonAsciiString;
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
                System.out.println("INVALID FLAG: -" + flag + " ignored\n");
                return false;
        }//end switch
        
    }//end of is_valid_flag

}//end of class