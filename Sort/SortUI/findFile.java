// Fig. 15.12: JFileChooserDemo.java
// Demonstrating JFileChooser.
//參考範例選取檔案
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class findFile extends JFrame{
    private final JTextArea outputArea; // displays file contents
    private String fileName;

    // set up GUI
    public findFile(){
      super("JFileChooser Demo");
      outputArea = new JTextArea();
      add(new JScrollPane(outputArea)); // outputArea is scrollable
      analyzePath(); // get Path from user and display info
    } 

    // display information about file or directory user specifies
    public void analyzePath(){
        // get Path to user-selected file or directory
        Path path = getFileOrDirectoryPath();
        if (path != null && Files.exists(path)){ // if exists, display info
            // gather file (or directory) information
            fileName=path.toAbsolutePath().toString();
        } 
        else{ // Path does not exist
            JOptionPane.showMessageDialog(this, path.getFileName() +" does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }   
    } // end method analyzePath

   // allow user to specify file or directory name
    private Path getFileOrDirectoryPath(){
        // configure dialog allowing selection of a file or directory
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(
        JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showOpenDialog(this);

      // if user clicked Cancel button on dialog, return
        if (result == JFileChooser.CANCEL_OPTION)System.exit(1);
      // return Path representing the selected file
        return fileChooser.getSelectedFile().toPath();
    } 

    public String getName(){
        return fileName;
    }
} // end class JFileChooserDemo
//尊重智慧財產權的事能算湊行數嗎?
/*************************************************************************
* (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
* Pearson Education, Inc. All Rights Reserved.                           *
*                                                                        *
* DISCLAIMER: The authors and publisher of this book have used their     *
* best efforts in preparing the book. These efforts include the          *
* development, research, and testing of the theories and programs        *
* to determine their effectiveness. The authors and publisher make       *
* no warranty of any kind, expressed or implied, with regard to these    *
* programs or to the documentation contained in these books. The authors *
* and publisher shall not be liable in any event for incidental or       *
* consequential damages in connection with, or arising out of, the       *
* furnishing, performance, or use of these programs.                     *
*************************************************************************/