package notepad;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.io.*;

public class np extends JFrame implements ActionListener {

    JTextArea textArea;
    JFrame frame;
    public np() {

        frame = new JFrame("Notepad");
        textArea = new JTextArea();

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");

        JMenuItem newFile = new JMenuItem("New");
        JMenuItem saveFile = new JMenuItem("Save");

        newFile.addActionListener(this);
        saveFile.addActionListener(this);

        // Add menu items to file menu
        fileMenu.add(newFile);
        fileMenu.add(saveFile);
        menuBar.add(fileMenu);

        JMenuItem darkMode = new JMenuItem("Dark Mode");
        darkMode.addActionListener(this);

        menuBar.add(darkMode);

        frame.setJMenuBar(menuBar);
        frame.add(textArea);
        frame.setSize(500, 500);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // If a button is pressed
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("New")) {
            textArea.setText("");
        } else if (command.equals("Save")) {
            JFileChooser save = new JFileChooser();
            int saveResult = save.showSaveDialog(null);
            if (saveResult == JFileChooser.APPROVE_OPTION) {
            }
        } else if (command.equals("Dark Mode")) {
            // dark and light modes
            if (textArea.getBackground().equals(Color.WHITE)) {
                textArea.setBackground(Color.BLACK);
                textArea.setForeground(Color.WHITE);
            } else {
                textArea.setBackground(Color.WHITE);
                textArea.setForeground(Color.BLACK);
            }
        }
    }

    public static void main(String[] args) {
        new np();
    }
}
