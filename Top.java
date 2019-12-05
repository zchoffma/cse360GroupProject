import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Top{

    enum JustificationFlags{R, C, L, T;} 
     enum SpacingFlags{D, S;}
     enum IndentationFlags{I, B, N;}
     enum ColumnFlags{ONE, TWO;}

    public static void main(String[] args){
        
        
        InitialCleaner newCleaner = new InitialCleaner("test.txt");
        newCleaner.clean_input();
        newCleaner.write_to_file();
        FileFormatter newFormatter = new FileFormatter("testOut1.txt");
        newFormatter.format_input();
        
    }
}