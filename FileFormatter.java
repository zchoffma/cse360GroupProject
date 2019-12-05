//package teamproject;

/***************************************************************************
 * Authors: Zachary Hoffmann, Kobe Goldman, ...                                                 
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
     *     //--TODO
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
                        this.currentJustFlag = JustificationFlags.R;
                    }else if(line.compareToIgnoreCase("-c")==0){
                        Object[] objectArray = appendableBuffer.toArray();
                        this.currentWordBuffer = new String[objectArray.length];
                        System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
                        this.format_current_word_buffer();
                        this.currentJustFlag = JustificationFlags.C;

                    }else if(line.compareToIgnoreCase("-l")==0){
                        Object[] objectArray = appendableBuffer.toArray();
                        this.currentWordBuffer = new String[objectArray.length];
                        System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
                        this.format_current_word_buffer();
                        this.currentJustFlag = JustificationFlags.L;

                    }else if(line.compareToIgnoreCase("-t")==0){
                        Object[] objectArray = appendableBuffer.toArray();
                        this.currentWordBuffer = new String[objectArray.length];
                        System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
                        this.format_current_word_buffer();
                        this.currentJustFlag = JustificationFlags.T;

                    }else if(line.compareToIgnoreCase("-d")==0){
                        Object[] objectArray = appendableBuffer.toArray();
                        this.currentWordBuffer = new String[objectArray.length];
                        System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
                        this.format_current_word_buffer();
                        this.currentSpaceFlag = SpacingFlags.D;

                    }else if(line.compareToIgnoreCase("-s")==0){
                        Object[] objectArray = appendableBuffer.toArray();
                        this.currentWordBuffer = new String[objectArray.length];
                        System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
                        this.format_current_word_buffer();
                        this.currentSpaceFlag = SpacingFlags.S;

                    }else if(line.compareToIgnoreCase("-i")==0){
                        Object[] objectArray = appendableBuffer.toArray();
                        this.currentWordBuffer = new String[objectArray.length];
                        System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
                        this.format_current_word_buffer();
                        this.currentIndentFlag = IndentationFlags.I;

                    }else if(line.compareToIgnoreCase("-b")==0){
                        Object[] objectArray = appendableBuffer.toArray();
                        this.currentWordBuffer = new String[objectArray.length];
                        System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
                        this.format_current_word_buffer();
                        this.currentIndentFlag = IndentationFlags.B;

                    }else if(line.compareToIgnoreCase("-2")==0){
                        Object[] objectArray = appendableBuffer.toArray();
                        this.currentWordBuffer = new String[objectArray.length];
                        System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
                        this.format_current_word_buffer();
                        this.currentColumnFlag = ColumnFlags.TWO;

                    }else if(line.compareToIgnoreCase("-1")==0){
                        Object[] objectArray = appendableBuffer.toArray();
                        this.currentWordBuffer = new String[objectArray.length];
                        System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
                        this.format_current_word_buffer();
                        this.currentColumnFlag = ColumnFlags.ONE;

                    }else if(line.compareToIgnoreCase("-e")==0){
                        outputFileBuffer.append("\n");  //only prints one new line-->does not change currentWordBuffer

                    }else{

                        //split the current line into a temporary array
                        String[] tempWordBuffer = this.line.split("\\s+");
                        for(int i = 0; i < tempWordBuffer.length; i++){
                            appendableBuffer.add(tempWordBuffer[i]);
                        }
                        //if there are no words in word buffer, set the current word buffer  = temp (avoids a space at the beginning)
                        /*
                        if(currentWordBuffer == null){
                            System.out.println("LENGTH 0");
                            currentWordBuffer = new String[tempWordBuffer.length];
                            System.arraycopy(tempWordBuffer, 0, currentWordBuffer, 0, tempWordBuffer.length);
                        }else{
                            System.out.println("ELSEYYY");
                            //probaby the grossest way to say append currentWordBuffer with tempwordBuffer
                            Object[] tempObjectWordBuffer = Stream.concat(Arrays.stream(this.currentWordBuffer), Arrays.stream(tempWordBuffer)).toArray();
                            this.currentWordBuffer = new String[tempWordBuffer.length];
                            System.arraycopy(tempObjectWordBuffer, 0, this.currentWordBuffer, 0, tempObjectWordBuffer.length);
                            tempWordBuffer = null; //delete temp word buffer (garbage collector)
                            tempObjectWordBuffer = null; //delete temp object buffer (garbage collector)
                        
                        }*/
                    } //end large if else statement
                } //end while if

                //process final block 
                Object[] objectArray = appendableBuffer.toArray();
                this.currentWordBuffer = new String[objectArray.length];
                System.arraycopy(objectArray, 0, this.currentWordBuffer, 0, objectArray.length);
                
            }// end while

        }catch(Exception e){
            /**********************************************************************************************************
            * ERROR CONDITION----PRINT TO ERROR LOG
            **********************************************************************************************************/
            System.out.println(e.toString());
        }
    }

    /* format_current_word_buffer():  empties current word buffer w/ current flags
     * 
     * Description:
     *      
    */
    public void format_current_word_buffer(){
        this.currentWordBuffer = null;
        System.out.println("MOPS PASSTHROUGH");
        //NOTE:indenting will only indent first line of the buffer.
        //String space;
        //int bufferIterator = 0;

        /* if(space flag = S) { 
         *   space = " "; //one space
         * }else if{space flag = D){
         *      space = "  "; //two spaces
         * } 
         *
         *if(indent flag = I){
         *    this.formattedLine = "     ";  //five spaces
         *}
         * 
         *  
         *while(this.currentWordBuffer is not empty){  //still not fully figured out.  here is where we check the flags and do formatting.  heres general idea though:
         *    if(size of formattedLine + size of currentWordBuffer[iterator] + spaces_size < 81){
         *          add currentWordBuffer[iterator] to the formattedLine w/
         *              formattedLine += space + currentWordBuffer[iterator];
         *  
         *          //--generally this is what we should do but we need a bunch of special 
         *              cases for all the different flags. Im not sure how we should do that, consult with group
         *          
         *    }else{
         *          formattedLine += "\n";
         *          outputFileBuffer.append(forrmattedLine);
         *    }
         * 
         *     
         * }
         */


    }
    


    /**
     *  ADD DESCRIPTION HERE OF METHOD
     * 
     *
     * 
     */
    public String justifyLine(String s, int length)
    {
    	int spaceCount = 0; 
    	char spaceChar = ' ';
    	length = s.length();
    	
    	if(currentJustFlag == JustificationFlags.R)
    	{
    		int end = s.length();
    		while(s.charAt(end) == spaceChar)
    		{
    			spaceCount++;
    			end--;
    		}
            s.trim();
            //CHECK IF THERE IS AN INDENT
    		s = s + new String(new char[spaceCount]).replace("\0", " ");
    		spaceCount = 0; 
    		
    		
    	}
    	
    	if(currentJustFlag == JustificationFlags.L)
    	{
    		//AUTOMATICALLY IS LEFT JUSTIFIED FOR DEFAULT, NO NEED TO TRIM SINCE WE NEED 80 CHARS
    		//s.trim();
    		
    	}
    	
    	if(currentJustFlag == JustificationFlags.C)
    	{

            //CHECK THIS-- should be really similar to -r, just only remove half of the spaces at end and stick them in front
    		int padSize = MAX_LINE_LENGTH - s.length();
    		int padStart = s.length() + padSize/2;
    		
    		s = String.format("%" + padStart + "s", s);
    	    s = String.format("%-" + MAX_LINE_LENGTH  + "s", s);
    		
    	}
    	
    	if(currentJustFlag == JustificationFlags.T)
    	{
    		int end = s.length();
    		String[] words = s.split("\\s+");
    	    int wordAmount = words.length;
    	    while(s.charAt(end) == spaceChar)
    		{
    			spaceCount++;
    			end--;
    		}
    	    s.trim();
    	    int spaceAmountPerWord = (int) Math.ceil(spaceCount/4);
    	    s = s + new String(new char[spaceAmountPerWord]).replace(' ', ' ');
    		
    	}

    	return s; 
    	
    }


    //getter for output file.  will be used in the SAVE AS button of the gui
    public StringBuffer get_StringBuffer(){
        return this.outputFileBuffer;
    }

    //Handler function for "PREVIEW" button on gui
    public void preview_output(){
        //TODO
        /**********************************************************************************************************
        * ---PRINT TO CONSOLE LOG
        **********************************************************************************************************/
        //replace system.out to consol text box in gui
        System.out.println(outputFileBuffer.toString());
    }


    //will write output buffer to file of specified filepath
    public void write_to_file(){

    }
}