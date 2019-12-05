import java.io.*;


public class Top{

    enum JustificationFlags{R, C, L, T;} 
     enum SpacingFlags{D, S;}
     enum IndentationFlags{I, B, N;}
     enum ColumnFlags{ONE, TWO;}

    public static void main(String[] args){
        
        
        InitialCleaner newCleaner = new InitialCleaner("test.txt");
        newCleaner.clean_input();
        String newPath = newCleaner.write_to_file();
        if(newCleaner.is_passed()){
            
            FileFormatter newFormatter = new FileFormatter(newPath);
            newFormatter.format_input();
        }else{
            System.out.println("Cannot clean");
        }
        
        
    }
}