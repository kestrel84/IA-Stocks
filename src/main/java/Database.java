import java.io.*;
import java.util.ArrayList;
//splitting lines into more than one record to be handled externally

//anything that returns a string returns "" (empty string) if it encounters an error
//anything that returns an int returns -1 as an error


public class Database {
    private final String filePath; //path of the text file linked to this database
    private final int lineLength;  //length of each line of the text file
    private int size;              //number of lines in the database

    //CONSTRUCTORS
    //------------
    public Database(String filePath, int lineLength) {
        //creates an empty database

        this.filePath = filePath;
        this.lineLength = lineLength + 2;

        //get the actual amount of lines in the file
        size = getFileSize();
    }
    public Database(String filePath, ArrayList<String> strings, int lineLength){
        //creates a database filled with existing strings (essentially useless)

        this.filePath = filePath;
        this.lineLength = lineLength+2;

        boolean tooLong = false;
        for (String s :
                strings) {
            if (s.length() > lineLength) {
                System.out.println("error: a string is too long");
                tooLong = true;
            }
        }

        if (!tooLong){
            for (String s :
                    strings) {
                appendRecord(s);
            }
        }

        size = strings.size();
    }

    //IMPORTANT STUFF
    public void appendRecord(String string){
        //pads a string and appends it to the end of the text file

        if (string.length() > lineLength-2){
            System.out.println("error - string too long to add");
        } else {
            try (
                    RandomAccessFile rf = new RandomAccessFile(filePath, "rws")
            ){
                //seek to the end of the file and write the string
                rf.seek((long) lineLength*size);
                for (char c:
                        padString(string).toCharArray()) {
                    rf.write((byte)c);
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("error in file access");
            }
        }

        size++;
    }
    public void setRecordAt(int lineNumber, String string){
        //pads a string and replaces a record at a line number with it

        if (string.length() > lineLength-2){
            System.out.println("error - string too long to add");
        } else {
            try (
                    RandomAccessFile rf = new RandomAccessFile(filePath, "rws")
            ){
                //seek to the end of the file and write the string
                rf.seek((long) lineLength*lineNumber);
                for (char c:
                        padString(string).toCharArray()) {
                    rf.write((byte)c);
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("error in file access");
            }
        }

        size++;
    }
    public void deleteRecord(int lineNumber){
        try (
                RandomAccessFile rf = new RandomAccessFile(filePath, "rws")
        ){
            //move every record below the line up
            for (int i = lineNumber; i < size-1; i++) {
                rf.seek((long) (i+1)*lineLength);
                String toBeMovedUp = rf.readLine();

                rf.seek((long) i*lineLength);
                for (char c:
                        (toBeMovedUp + "\r\n").toCharArray()) {
                    rf.write((byte)c);
                }
            }

            //replace the last line with empty characters
            rf.seek((long) (size-1)*lineLength);
            for (char c:
                    ("                    \r\n").toCharArray()) {
                rf.write((byte)c);
            }

            //shorten the file
            rf.setLength(rf.length()-lineLength);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error in file access");
        }

        size--;
    }
    public String getRecordAt(int lineNumber){
        //returns the String of the line at the specified lineNumber
        //linenumber starts at 0

        if (lineNumber <= size) {
            try (
                    RandomAccessFile rf = new RandomAccessFile(filePath, "rws")
            ) {
                //seek to the beginning of the line and return the line
                rf.seek((long) lineNumber*lineLength);
                return rf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("error in file access");
                return "";
            }
        } else {
            System.out.println("error - lineNumber too large");
            return "";
        }
    }

    //AUXILIARY METHODS
    public String padString(String s){
        return (String.format("%-" + (lineLength-2) + "s", s) + "\r\n");
    }
    private int getFileSize(){
        //gets the amount of lines in the file, aka size variable
        try (
                RandomAccessFile rf = new RandomAccessFile(filePath, "rws")
        ){
            return (int)rf.length() / lineLength;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error in file access");
            return -1;
        }
    }
    public int getSize(){
        return size;
    }

}
