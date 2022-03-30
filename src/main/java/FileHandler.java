import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    //GENERIC STATIC FILE HANDLER FOR ANY PROJECT


    //SERIAL FILE READING
    //------------
    public static String singleLineFileRead(String fileName, int lineNumber) {
        // 0 is the first line of the file
        //reads a single specific line of a text file

        int lineCounter = 0;

        try (
                FileReader fr = new FileReader(fileName);
                BufferedReader br = new BufferedReader(fr)
        ) {

            // (effectively) loops through the file up to the lineNumber index
            String line = br.readLine();
            while (line != null && lineCounter < lineNumber) {
                line = br.readLine();
                lineCounter++;
            }
            return (line != null ? line : "line number too large");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("error in file access");
            return "";
        }
    }
    public static ArrayList<String> fileReadToArray(String fileName) {
        //writes each line to a different array index

        ArrayList<String> fileArray = new ArrayList<>();

        try (
                FileReader fr = new FileReader(fileName);
                BufferedReader br = new BufferedReader(fr)
        ){
            String line = br.readLine();
            while (line != null) {
                fileArray.add(line);
                line = br.readLine();
            }
        }
        catch (IOException e)
        {
            System.out.println("error in file access");
            e.printStackTrace();
        }

        return fileArray;
    }

    //SERIAL FILE WRITING
    //------------
    public static void arrayListFileWrite(String fileName, ArrayList<String> text, boolean append) {
        //takes an arraylist of inputs and writes the whole thing to a file

        try (
                FileWriter fw = new FileWriter(fileName, append);
                PrintWriter pw = new PrintWriter(fw)
        ) {

            for (String s:
                    text) {
                pw.println(s);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("error in file access");
        }
    }
    public static void singleLineFileWrite(String fileName, String text, boolean append) {
        //writes one line either to a new file/existing file erased, or appends onto an existing file.

        try (
                FileWriter fw = new FileWriter(fileName, append);
                PrintWriter pw = new PrintWriter(fw)
        ) {
            pw.println(text);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("error in file access");
        }
    }


    //RANDOM FILE ACCESS: READING
    //---------------------------
    public static char randomReadChar(String fileName, int start){
        //returns a single character at a specific position in a text file

        try (
                RandomAccessFile rf = new RandomAccessFile(fileName, "rws")
        ){
            rf.seek(start);
            char letter = (char)rf.read();
            //checking if a character is a carriage return
            if (letter == '\r') {
                return ' ';
            } else {
                return letter;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error in file access");
            return '\0';
        }
    }
    public static String randomReadString(String fileName, int start, int length){
        //returns a string from a set position of given length

        try (
                RandomAccessFile rf = new RandomAccessFile(fileName, "rws")
        ){
            rf.seek(start);
            StringBuilder output = new StringBuilder();

            for (int i = 0; i<length; i++) {
                output.append((char) rf.read());
            }

            return output.toString();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error in file access");
            return "";
        }
    }
    public static String randomReadLine(String fileName, int start){
        //reads from a set position to the end of the line

        try (
                RandomAccessFile rf = new RandomAccessFile(fileName, "rws")
        ){
            rf.seek(start);
            return rf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error in file access");
            return "";
        }
    }
    public static ArrayList<String> randomReadArray(String fileName){
        //reads the entire file into an arraylist, one line per index

        try (
                RandomAccessFile rf = new RandomAccessFile(fileName, "rws")
        ){
            rf.seek(0);

            ArrayList<String> output = new ArrayList<>();
            while (rf.readLine() != null){
                output.add(rf.readLine());
            }
            return output;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error in file access");
            return null;
        }
    }
    public static long randomGetLength(String fileName){
        //returns the length of the file in number of characters, as a long

        try (
                RandomAccessFile rf = new RandomAccessFile(fileName, "rws")
        ){
            rf.seek(0);
            return(rf.length());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error in file access");
            return -1;
        }
    }

    //RFA: WRITING
    //------------
    public static void randomWriteChar(String fileName, int start, char write){
        //writes a single character to a specific position in a text file

        try (
                RandomAccessFile rf = new RandomAccessFile(fileName, "rws")
        ){
            rf.seek(start);
            rf.write((byte)write);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error in file access");
        }
    }
    public static void randomWriteString(String fileName, int start, String write){
        //writes a string to a specific position in a text file

        try (
                RandomAccessFile rf = new RandomAccessFile(fileName, "rws")
        ){
            rf.seek(start);
            for (char c:
                    write.toCharArray()) {
                rf.write((byte)c);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error in file access");
        }
    }
    public static void randomWriteArray(String fileName, int start, boolean append, ArrayList<String> write){
        //writes an entire arraylist to a file (new or appended), treating one index as one line

        try (
                RandomAccessFile rf = new RandomAccessFile(fileName, "rws")
        ){
            if (append){
                //if appending, seek to the end of the file and add on from there
                rf.seek(rf.length());
                for (String s:
                        write) {
                    rf.writeChars(s);
                }
            } else {
                //if not, just write the arraylist at a specific position
                rf.seek(start);
                for (String s:
                        write) {
                    rf.writeChars(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error in file access");
        }
    }
}


