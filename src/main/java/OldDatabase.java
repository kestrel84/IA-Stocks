import java.util.ArrayList;

public class OldDatabase {
    private final String fileName;
    private final int lineLength;
    private int recordCount;
    private ArrayList<Integer> deletedRecords; //this holds a list of the row number of each line that has been deleted.
    private final String deleteFlag;


    public OldDatabase(String fileName, int lineLength, String deleteFlag) {
        this.fileName = fileName;
        this.lineLength = lineLength;
        recordCount = (int) (FileHandler.randomGetLength(fileName) / lineLength);
        deletedRecords = new ArrayList<>();
        this.deleteFlag = deleteFlag;

    }

    public void appendRecord(String data) {
        //adds on one record to the end of the file/database

        if (data.length() <= lineLength){
            FileHandler.randomWriteString(fileName, (lineLength+2)*recordCount, (String.format("%-" + lineLength + "s", data) + "\r\n"));
            recordCount++;
        } else {
            System.out.println("error: message too long for the database");
        }
    }

    public void deleteRecord(int rowNumber) {
        //this overwrites the last char in a line with a logical delete flag. other methods then acknowledge this flag.
        FileHandler.randomWriteString(fileName, ((rowNumber+1)*(lineLength+2))-(2+deleteFlag.length()), deleteFlag);
        recordCount--;
    }

    //this doesn't work properly because null values, carriage return newlines, delete flags,
    //and not being able to delete stuff properly in rfa.
    //accounting for all of this stuff is very messy, and I need to start again.
    //change this to a specific error value?
    public String getRecord(int rowNumber) {
        //returns a record at a specific line number
        if (rowNumber > recordCount){
            System.out.println("error: row number too large");
            return null;
        }

        String record = FileHandler.randomReadLine(fileName, rowNumber * (lineLength+2));

        //checks if the row number has been deleted
        if (isDeleted(rowNumber)){
            System.out.println("error: record has been deleted");
            return null;
        }


        if (record == null){
            System.out.println("error: record contains null value");
            return null;
        }

        return record;
    }

    public int getRecordCount() {
        return recordCount;
    }

    //fix this - broken since getRecord can return null value for deleted records
    public boolean recordExists(String data) {
        //if a given string matches a record in the file, it returns true, else false
/*
       int rowCounter = 0;

       String record = getRecord(rowCounter);
       while (record != null) {
           if (record.trim().equals(data)){
               return true;
           }
           rowCounter++;
           record = getRecord(rowCounter);
       }

*/

        String record;
        for (int i = 0; i < recordCount; i++) {
            record = getRecord(i);
            if (record.equals("")){
                return false;
            }
        }
        return true;
    }

    public boolean isDeleted(int rowNumber){
        //checks if a given rowNumber has been deleted
        return FileHandler.randomReadString(fileName, ((rowNumber + 1) * (lineLength + 2)) - (2+ deleteFlag.length()), deleteFlag.length()).equals(deleteFlag);
    }
}





