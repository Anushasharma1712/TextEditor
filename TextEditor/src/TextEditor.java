import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class TextEditor implements ActionListener {
    JFrame frame;

    JMenuBar menuBar;

    JMenu file, edit;

    JMenuItem newFile, openFile, saveFile;

    JMenuItem cut, copy, paste, selectAll, close;

    JTextArea textArea;
    TextEditor(){

        frame = new JFrame();

        menuBar = new JMenuBar();

        textArea = new JTextArea();

        edit = new JMenu("Edit");

        newFile = new JMenuItem("New Window");
        openFile = new JMenuItem("Open File");
        saveFile = new JMenuItem("Save File");

        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);

        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);

        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select All");
        close = new JMenuItem("Close");

        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        close.addActionListener(this);


        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(close);




        menuBar.add(file);
        menuBar.add(edit);

        frame.setJMenuBar(menuBar);

        frame.add(textArea);

        // frame = new JFrame();
         frame.setBounds(100,100,400,400);
         frame.setVisible(true);
        frame.setLayout(null);
    }

    @Override
    public void actionPerformed( ActionEvent actionEvent) {
        if(actionEvent.getSource()==cut)
        {
            textArea.cut();
        }
        if(actionEvent.getSource()==copy)
        {
            textArea.copy();

        }
        if(actionEvent.getSource()==paste)
        {

            textArea.paste();
        }
        if(actionEvent.getSource()==selectAll)
        {

            textArea.selectAll();
        }
        if(actionEvent.getSource()==close)
        {

            System.exit(0);
        }
        if(actionEvent.getSource()==selectAll)
        {

            textArea.selectAll();
        }
        if(actionEvent.getSource()==openFile)
        {
            JFileChooser fileChooser = new JFileChooser("C:");
            int chooseOption = fileChooser.showOpenDialog(null);

            if(chooseOption==JFileChooser.APPROVE_OPTION)
            {
                File file = fileChooser.getSelectedFile();
                String filePath = file.getPath();

                try{
                    FileReader fileReader = new FileReader(filePath);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    String intermediate ="", output ="";
                    while( (intermediate = bufferedReader.readLine())!=null) {
                        output+=intermediate+"\n";
                    }
                    textArea.setText(output);
                }
                catch(FileNotFoundException fileNotFoundException)
                {
                    fileNotFoundException.printStackTrace();
                }
                catch(IOException ioException){
                    ioException.printStackTrace();
                }
            }
        }
        if(actionEvent.getSource()==saveFile)
        {
            JFileChooser fileChooser = new JFileChooser("C:");
            int chooseOption = fileChooser.showSaveDialog(null);

            if(chooseOption==JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath()+".txt");

                try{
                    FileWriter fileWriter = new FileWriter(file);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    textArea.write(bufferedWriter);
                    bufferedWriter.close();
                }
                catch(IOException ioException){
                    ioException.printStackTrace();
                }
            }
        }
         if(actionEvent.getSource()==newFile)
        {
          TextEditor newTextEditor = new TextEditor();
        }

    }
    public static void main(String[] args) {

         TextEditor textEditor = new TextEditor();
    }
}