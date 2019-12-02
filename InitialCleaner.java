import java.io.*;
import java.lang.StringBuilder;

public class InitialCleaner{
    private File fo;
    private FileReader fr;
    private BufferedReader br;
    private StringBuffer inputBuffer;
    private String line;
    private int currentLineIndex;

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
        this.currentLineIndex = 0;
    }

    //main driver function for initial scrubbing
    
    public void clean_input(){
        System.out.println("InitialCleaner: ");
        try{
            while((this.line = br.readLine()) != null){
                if(line.length() > 0){

                    System.out.println(this.line);
                    
                    if(line.substring(0, 1).compareTo("-") == 0){
                        System.out.println("FLAG FOUND");
                    }else{
                        inputBuffer.append(this.line);
                    }
                } //end while if
            }// end while

            System.out.println("-------------------------------------------------\n");
            System.out.println(inputBuffer.toString());

        }catch(Exception e){
            System.out.println("File read Error");
        }
        
        System.out.println(this.line);
    }
    
    public void parse_line(){
        String token;
        while(this.line.length() > 0){
            token = this.line.substring(0, 1);
            if(token.compareTo("-") == 0){
                if(is_possible_flag()){
                    //this.line.replace()
                }else{

                }
            }

        }
    }

    public boolean is_possible_flag(){


        return false;
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
        }
    }

    

    public void testPrint(){
        System.out.println("InitialCleaner: ");
        try{

            while((this.line = br.readLine()) != null){
                if(line.length() > 0){

                    System.out.println(this.line);
                    

                    if(line.substring(0, 1).compareTo("-") == 0){
                        System.out.println("FLAG FOUND");
                    }else{
                        inputBuffer.append(this.line);
                    }
                } //end while if
            }// end while

            System.out.println("-------------------------------------------------\n");
            System.out.println(inputBuffer.toString());

        }catch(Exception e){
            System.out.println("File read Error");
        }
        
        System.out.println(this.line);
    }



}