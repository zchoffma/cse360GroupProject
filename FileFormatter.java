//package teamproject;

/***************************************************************************
 * Authors: Zachary Hoffmann, Kobe Goldman                                                
 * IDs: 1214623033,                                                          
 * Date: 12/2/19                                                           
 * Description:                                                            
 *       FILE INCOMPLETE. THIS IS THE MAIN DRIVER FOR THE FORMATTING CLASS
 * 
 *      CAN ASSUME ONLY VALID FLAGS, FLAGS ONLY ON OWN LINE AND THATS IT
 *                                                              
 ***************************************************************************/

//download swing



import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileFormatter{
     //All flags
     enum JustificationFlags{R, C, L, T;} 
     enum SpacingFlags{D, S;}
     enum IndentationFlags{I, B, N;}
     enum ColumnFlags{ONE, TWO;}
 
    private File fo;
    private FileReader fr;
    private BufferedReader br;
    private String filePath;
    private StringBuffer outputFileBuffer;  //This is the file write buffer
    private String line; //original input line
    private String[] currentWordBuffer; //words between flags (everything in this buffer has the same flags)
    private String formattedLine;  //the 80 char line that will be added to the output file buffer
    private JustificationFlags currentJustFlag;  //enum for current flags
    private SpacingFlags currentSpaceFlag;      //enum for flags
    private IndentationFlags currentIndentFlag;  //enum for flags
    private ColumnFlags currentColumnFlag;   //enum for flags
    private int MAX_LINE_LENGTH = 80;   //constant max line length 
    

    public FileFormatter(String filePath){
        try {
            this.fo = new File(filePath);
            this.fr = new FileReader(fo);
            this.br = new BufferedReader(fr);
            this.outputFileBuffer = new StringBuffer();
        }catch(Exception e){
            /**********************************************************************************************************
            * ERROR CONDITION----PRINT TO ERROR LOG
            **********************************************************************************************************/
            System.out.println("FileNotFound Exception\n");
        }
        
        this.filePath = filePath;
        this.line = "";
        this.formattedLine = "";
        this.currentWordBuffer = null;
        this.currentJustFlag = JustificationFlags.L;  //left justification
        this.currentColumnFlag = ColumnFlags.ONE;     //one column
        this.currentIndentFlag = IndentationFlags.N;  //no indentation
        this.currentSpaceFlag = SpacingFlags.S;       //single spaced
    }

    /* format_input():  Driver function for file formatter
     * 
     *  Description:
     *     
     *      
     */
    public void format_input(){  //--TESTED WORKING
        ArrayList<String> appendableBuffer = new ArrayList<String>();

        //int count = 0;
        try{
            while((this.line = br.readLine()) != null){

                if(line.length() > 0){
                    //if line is a flag, process current word buffer and update currentFlag info
                    if(line.compareToIgnoreCase("-r")==0){
                        Object[] objectArray = appendableBuffer.toArray();
                        this.currentWordBuffer = new String[objectArray.length];
                        System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
                        this.format_current_word_buffer();
                        appendableBuffer.clear();
                        this.currentJustFlag = JustificationFlags.R;

                    }else if(line.compareToIgnoreCase("-c")==0){
                        Object[] objectArray = appendableBuffer.toArray();
                        this.currentWordBuffer = new String[objectArray.length];
                        System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
                        this.format_current_word_buffer();
                        appendableBuffer.clear();
                        this.currentJustFlag = JustificationFlags.C;

                    }else if(line.compareToIgnoreCase("-l")==0){
                        Object[] objectArray = appendableBuffer.toArray();
                        this.currentWordBuffer = new String[objectArray.length];
                        System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
                        this.format_current_word_buffer();
                        appendableBuffer.clear();
                        this.currentJustFlag = JustificationFlags.L;

                    }else if(line.compareToIgnoreCase("-t")==0){
                        Object[] objectArray = appendableBuffer.toArray();
                        this.currentWordBuffer = new String[objectArray.length];
                        System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
                        this.format_current_word_buffer();
                        appendableBuffer.clear();
                        this.currentJustFlag = JustificationFlags.T;

                    }else if(line.compareToIgnoreCase("-d")==0){
                        Object[] objectArray = appendableBuffer.toArray();
                        this.currentWordBuffer = new String[objectArray.length];
                        System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
                        this.format_current_word_buffer();
                        appendableBuffer.clear();
                        this.currentSpaceFlag = SpacingFlags.D;

                    }else if(line.compareToIgnoreCase("-s")==0){
                        Object[] objectArray = appendableBuffer.toArray();
                        this.currentWordBuffer = new String[objectArray.length];
                        System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
                        this.format_current_word_buffer();
                        appendableBuffer.clear();
                        this.currentSpaceFlag = SpacingFlags.S;

                    }else if(line.compareToIgnoreCase("-i")==0){
                        Object[] objectArray = appendableBuffer.toArray();
                        this.currentWordBuffer = new String[objectArray.length];
                        System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
                        this.format_current_word_buffer();
                        appendableBuffer.clear();
                        this.currentIndentFlag = IndentationFlags.I;

                    }else if(line.compareToIgnoreCase("-b")==0){
                        Object[] objectArray = appendableBuffer.toArray();
                        this.currentWordBuffer = new String[objectArray.length];
                        System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
                        this.format_current_word_buffer();
                        appendableBuffer.clear();
                        this.currentIndentFlag = IndentationFlags.B;

                    }else if(line.compareToIgnoreCase("-2")==0){
                        Object[] objectArray = appendableBuffer.toArray();
                        this.currentWordBuffer = new String[objectArray.length];
                        System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
                        this.format_current_word_buffer();
                        appendableBuffer.clear();
                        this.currentColumnFlag = ColumnFlags.TWO;

                    }else if(line.compareToIgnoreCase("-1")==0){
                        Object[] objectArray = appendableBuffer.toArray();
                        this.currentWordBuffer = new String[objectArray.length];
                        System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
                        this.format_current_word_buffer();
                        appendableBuffer.clear();
                        this.currentColumnFlag = ColumnFlags.ONE;

                    }else if(line.compareToIgnoreCase("-e")==0){
                        Object[] objectArray = appendableBuffer.toArray();
                        this.currentWordBuffer = new String[objectArray.length];
                        System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
                        this.format_current_word_buffer();
                        appendableBuffer.clear();
                        outputFileBuffer.append("\n");  //only prints one new line-->does not change currentWordBuffer

                    }else{

                        //split the current line into a temporary array and add to the appendable Buffer
                        String[] tempWordBuffer = this.line.split("\\s+");
                        for(int i = 0; i < tempWordBuffer.length; i++){
                            appendableBuffer.add(tempWordBuffer[i]);
                        }
                    } //end large if else statement
                } //end while if   
            }// end while

            //process final block 
            Object[] objectArray = appendableBuffer.toArray();
            this.currentWordBuffer = new String[objectArray.length];
            System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
            this.format_current_word_buffer();

            this.write_to_file("test");  //----------------------------------------------------------debug file output 
            
        }catch(Exception e){
            /**********************************************************************************************************
            * ERROR CONDITION----PRINT TO ERROR LOG
            **********************************************************************************************************/
            System.out.println(e.toString());
        }
    }


    public void debug(String toPrint){
        System.out.println(toPrint);
    }


    /* format_current_word_buffer():  empties current word buffer w/ current flags
     * 
     * Description:
     *      
    */
    public void format_current_word_buffer(){
        //initially check if buffer is empty
        if(this.currentWordBuffer.length != 0){
            //Get Spacing Format
            String spaces = "";
            if(currentSpaceFlag == SpacingFlags.S){
                spaces = " ";                                   //Single spaces
            }else if(currentSpaceFlag == SpacingFlags.D){
                spaces = "  ";                                  //Double spaces
            }

            if(currentColumnFlag == ColumnFlags.ONE){
                this.One_Column_Format(spaces);
            }else if(currentColumnFlag == ColumnFlags.TWO){
                this.Two_Column_Format(spaces);
            }
        }

        //clear the current buffer to be garbage collected
        this.currentWordBuffer = null;
    }
    


    public void One_Column_Format(String space){
        ArrayList<String> oneColumnBuffer = new ArrayList<String>();
        StringBuilder eightyCharLine = new StringBuilder();
        int bufferIterator = 0;
        int currWordSize = 0;
        int wordsAdded = 0;

        //Build arrayList of 35 char lines
        while(bufferIterator != this.currentWordBuffer.length){

            if(eightyCharLine.length() == 80){
                oneColumnBuffer.add(eightyCharLine.toString());
                eightyCharLine.delete(0, eightyCharLine.length());
                wordsAdded = 0;
            }

            //INDENTION HANDLER ---------------------------
            if(currentIndentFlag == IndentationFlags.I && bufferIterator == 0){
                eightyCharLine.append(String.format("%5s", ""));
            }else if(currentIndentFlag == IndentationFlags.B && wordsAdded == 0){
                eightyCharLine.append(String.format("%10s", ""));
            }
            //END INDENTION HANDLER --------------------------


            currWordSize = this.currentWordBuffer[bufferIterator].length();
            if((currWordSize + eightyCharLine.length()) <= 80){
                eightyCharLine.append(this.currentWordBuffer[bufferIterator]);
                bufferIterator++;
                wordsAdded++;

            if(bufferIterator >= this.currentWordBuffer.length){
                while(eightyCharLine.length() != 80){
                    eightyCharLine.append(" "); 
                }
                oneColumnBuffer.add(eightyCharLine.toString());
                wordsAdded = 0;
            }
            }else if(eightyCharLine.length() < 80){
                while(eightyCharLine.length() != 80){
                    eightyCharLine.append(" ");  
                }
            }
            if((eightyCharLine.length() + space.length()) <= 80){
                eightyCharLine.append(space);
            }
        }


        for(int i = 0; i < oneColumnBuffer.size(); i++){
            //System.out.println(oneColumnBuffer.get(i));----------------------------------------------
            oneColumnBuffer.set(i, justifyLine(oneColumnBuffer.get(i), 80));
            //System.out.println(oneColumnBuffer.get(i));----------------------------------------------
            this.outputFileBuffer.append(oneColumnBuffer.get(i));
            this.outputFileBuffer.append("\n");
        }
    }




    /* Driver function for formatting two Columns
     *
     *  Handles creating the lines, then splitting them into two separate columns;
     * 
     */
    public void Two_Column_Format(String space){
        ArrayList<String> twoColumnBuffer = new ArrayList<String>();
        StringBuilder thirtyFiveCharLine = new StringBuilder();
        int bufferIterator = 0;
        int currWordSize = 0;


        //Build arrayList of 35 char lines
        while(bufferIterator != this.currentWordBuffer.length){
            if(thirtyFiveCharLine.length() == 35){
                twoColumnBuffer.add(thirtyFiveCharLine.toString());
                thirtyFiveCharLine.delete(0, thirtyFiveCharLine.length());
            }

            currWordSize = this.currentWordBuffer[bufferIterator].length();
            if((currWordSize + thirtyFiveCharLine.length()) <= 35){
                thirtyFiveCharLine.append(this.currentWordBuffer[bufferIterator]);
                bufferIterator++;

            if(bufferIterator >= this.currentWordBuffer.length){
                while(thirtyFiveCharLine.length() != 35){
                    thirtyFiveCharLine.append(" "); 
                }
                twoColumnBuffer.add(thirtyFiveCharLine.toString());
            }
            }else if(thirtyFiveCharLine.length() < 35){
                while(thirtyFiveCharLine.length() != 35){
                    thirtyFiveCharLine.append(" ");  
                }
            }
            if((thirtyFiveCharLine.length() + space.length()) <= 35){
                thirtyFiveCharLine.append(space);
            }
        }

        //justify each line 
        for(int i = 0; i < twoColumnBuffer.size(); i++){
            //System.out.println(twoColumnBuffer.get(i));
            twoColumnBuffer.set(i, justifyLine(twoColumnBuffer.get(i), 35));
        }
        

        //split into columns and print
        int columnSize = (int) Math.ceil((double)twoColumnBuffer.size() / (double)2);
        for(int i = 0; i < columnSize; i++){
            //System.out.println(i + " " + (i+columnSize)); -----------------------------------
            if((i + columnSize) >= twoColumnBuffer.size()){
                this.outputFileBuffer.append(String.format("%35s%45s", twoColumnBuffer.get(i), ""));
                this.outputFileBuffer.append("\n");
            }else{
                this.outputFileBuffer.append(String.format("%35s%10s%35s", twoColumnBuffer.get(i), "", twoColumnBuffer.get(i+columnSize)));
                this.outputFileBuffer.append("\n");
            }
        }
    }

  
    
    public String justifyLine(String s, int length)
    {
    	int spaceCount = 0; 
    	char spaceChar = ' ';
    	StringBuilder temp = new StringBuilder();
    	String newString = "";

        //Strings are automatically left justified
        if(this.currentJustFlag == JustificationFlags.L){
            return s;
        }

        //Right Justify working
    	if(this.currentJustFlag == JustificationFlags.R)
    	{
    		int end = s.length()-1;
    		while(s.charAt(end) == spaceChar)
    		{
    			spaceCount++;
    			end--;
            }
            String tempString = s.substring(0, s.length() - spaceCount);
            temp = new StringBuilder();
            //cheap fix
            while(spaceCount != 0){
                temp.append(" ");
                spaceCount--;
            }
            temp.append(tempString);
            return temp.toString();
    	}


        //working 
    	if(this.currentJustFlag == JustificationFlags.C)
    	{
            int end = s.length()-1;
    		while(s.charAt(end) == spaceChar)
    		{
    			spaceCount++;
    			end--;
            }
            //extract words with indent
            String tempString = s.substring(0, s.length() - spaceCount);
            temp = new StringBuilder();
            int halfSpaces = spaceCount / 2; //auto floors when casting
            while(spaceCount != (halfSpaces)){
                temp.append(" ");
                spaceCount--;
            }
            temp.append(tempString);
            while(spaceCount != 0){
                temp.append(" ");
                spaceCount--;
            }

            return temp.toString();
    	}

    	if(this.currentJustFlag == JustificationFlags.T)
    	{

    		int count = 0; 
    	    s = s.trim();

    		for(int i = 0; i<s.length();i++)
    		{
    			if(s.charAt(i)==spaceChar)
    			{
    				count++;
    			}
    		}

    		int spacePadSize = (int) Math.ceil(length/count);
    		String spaceAmount = "";	

    	    for(int i = 0; i<spacePadSize;i++)
    	    {
    	       	spaceAmount+=" ";
    	    }

    	    s = s.replace(" ", spaceAmount);
    		temp = new StringBuilder(s);
    	    newString = temp.toString();

    	}
    	return newString;
    }




    //getter for output file.  will be used in the SAVE AS button of the gui
    public StringBuffer get_StringBuffer(){
        return this.outputFileBuffer;
    }



    //Handler function for "PREVIEW" button on gui
    public String get_preview_output(){
        return outputFileBuffer.toString();
    }




    //will write output buffer to file of specified filepath
    public void write_to_file(String newFilePath){

        newFilePath = "FormattedOutput.txt";
            try{                
                File outFile = new File(newFilePath);
                FileWriter fw = new FileWriter(outFile);
                fw.write(this.outputFileBuffer.toString());
                fw.close();
    
            }catch(Exception e){
                System.out.println("ERROR: file unable to be written");
            }
    
    }
}