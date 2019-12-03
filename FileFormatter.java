/***************************************************************************
 * Authors: Zachary Hoffmann,                                                
 * IDs: 1214623033,                                                          
 * Date: 12/2/19                                                           
 * Description:                                                            
 *       FILE INCOMPLETE. THIS IS THE MAIN DRIVER FOR THE FORMATTING CLASS
 *                                                              
 ***************************************************************************/





import java.io.*;

public class FileFormatter{
     //All flags
     enum JustificationFlags{R, C, L, T;}
     enum SpacingFlags{D, S;}
     enum IndentationFlags{I, B, N;}
     enum ColumnFlags{ONE, TWO;}
 
    private File fo;
    private FileReader fr;
    private BufferedReader br;
    private StringBuffer outputFileBuffer;  //This is the file write 
    private String line; 
    private String[] currentWordBuffer;   
    private String formattedLine;
    private JustificationFlags currentJustFlag;
    private SpacingFlags currentSpaceFlag;
    private IndentationFlags currentIndentFlag;
    private ColumnFlags currentColumnFlag;
    private int MAX_LINE_LENGTH = 80;
    

    public FileFormatter(String filePath){
        try {
            this.fo = new File(filePath);
            this.fr = new FileReader(fo);
            this.br = new BufferedReader(fr);
            this.outputFileBuffer = new StringBuffer();
        }catch(Exception e){
            System.out.println("FileNotFound Exception\n");
        }
        
        this.line = "";
        this.formattedLine = "";
        this.currentJustFlag = JustificationFlags.L;  //left justification
        this.currentColumnFlag = ColumnFlags.ONE;     //one column
        this.currentIndentFlag = IndentationFlags.N;  //no indentation
        this.currentSpaceFlag = SpacingFlags.S;       //single spaced
    }

    /* format_input():  Driver function for file formatter
     * 
     *  Description:
     *      Reads in one line at a time then passes that string line to format_line
     *      where processing of individual lines takes place
     */
    public void format_input(){
        try{
            while((this.line = br.readLine()) != null){
                if(line.length() > 0){

                    /* TODO
                     *
                     * tempBuffer += line.split(" ", 0);
                     *
                     * if(line is a flag){     --//this is not a real if statement, most likely will be a large switch statement with the default being the else
                     *    -parse the currentWordBuffer till it is empty by calling format_currentWordBuffer (NO NEW FLAGS, JUST ONE CONSTANT STREAM OF WORDS TO BE FORMATTED USING THE CURRENT FLAGS)
                     *    -update the flag information
                     * }else{
                     *    -add tempBuffer to currentWordBuffer
                     * }
                     * 
                     * //--NOTE: the -e flag should not change any flags other than just adding a new line
                     */
            
                } //end while if
            }// end while

        }catch(Exception e){
            System.out.println("File read Error");
        }
    }

    /* format_current_word_buffer():  empties current word buffer w/ current flags
     * 
     * Description:
     *      
    */
    public void format_current_word_buffer(){
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


    //getter for output file.  will be used in the SAVE AS button of the gui
    public StringBuffer get_StringBuffer(){
        return this.outputFileBuffer;
    }

    //Handler function for "PREVIEW" button on gui
    public void preview_output(){
        //TODO
        //replace system.out to consol text box in gui
        System.out.println(outputFileBuffer.toString());
    }
}