import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.text.StringCharacterIterator;
import java.text.CharacterIterator;

public class ReadArray {
	private Scanner input;
	private String fileName; // target file name
 
	public ReadArray(String fileName) {
		this.fileName = fileName;
        
	}

    public int[] run(){ //呼叫此函數來跑出需要的陣列
        openFile();
        int [] ans = readRecords();
        closeFile();
        return ans;
    }

	public void openFile() {
		try {
			input = new Scanner(Paths.get(fileName));
		} catch (IOException ioException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}

	// Read all records and return an Array of txt
	public int[] readRecords() {
        ArrayList<Integer> arrayList = new ArrayList(); 
		//System.out.printf("%-12s%-12s%10s%n", "First Name", "Last Name", "Balance");
		try {
			while (input.hasNext()) // while there is more to read
			{
				String element = input.next();
                for(int i = 0; i < element.length(); ++i){
                    if(Character.isDigit(element.charAt(i))==false && element.charAt(i) != '-'){
						throw new NumberFormatException();
					}
                }
				Integer tmp = Integer.parseInt(element);
                arrayList.add(tmp);
			}
		} catch (NoSuchElementException elementException) {
			System.err.println("File improperly formed. Terminating.");
		} catch (IllegalStateException stateException) {
			System.err.println("Error reading from file. Terminating.");
		} catch (NumberFormatException ex){
            System.err.println("Data format error.");
			System.exit(0);
        }
        Integer[] arr = arrayList.toArray(new Integer[0]);
        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; ++i){
            ans[i] = arr[i];
        }
		return ans;
	} // end method readRecords

	// close file and terminate application
	public void closeFile() {
		if (input != null)
			input.close();
	}

    public static String doc(){
        String str;
        str = "";
        str += "在創建此類別時，建構子丟入記事本的路徑，記事本中的資料格式須為整數，並且用空白分隔\n";
        return str;
    }
}