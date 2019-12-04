import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Top{
public static void main(String[] args){

    String testLine = "";
    String testLine2 = "guess what fucker it works";

    String[] currentWordBuffer = testLine.split(" ", 0);
    String[] newSplitLine = testLine2.split(" ", 0);

    Object[] tempWordBuffer = Stream.concat(Arrays.stream(currentWordBuffer), Arrays.stream(newSplitLine)).toArray();
    currentWordBuffer = new String[tempWordBuffer.length];
    System.arraycopy(tempWordBuffer, 0, currentWordBuffer, 0, tempWordBuffer.length);
    tempWordBuffer = null; //delete temp word buffer


    for(int i = 0; i < currentWordBuffer.length; i++){
        System.out.print(currentWordBuffer[i] + " ");
    }

    //InitialCleaner newCleaner = new InitialCleaner("test.txt");
    //newCleaner.clean_input();
}}