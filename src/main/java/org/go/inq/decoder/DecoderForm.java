package org.go.inq.decoder;

import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
/*
 * Created by JFormDesigner on Sat Jun 08 09:38:31 FET 2013
 */



/**
 * @author unknown
 */
public class DecoderForm extends JPanel {
    final JFileChooser fc = new JFileChooser();

    public DecoderForm() {
        initComponents();
    }

    private void selectFileButtonClick(ActionEvent e) {
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = fc.showOpenDialog(DecoderForm.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            selectFileText.setText(file.getAbsolutePath());
        } else {
            selectFileText.setText("select file do decrypt");
        }
    }

    private void outputDirectoryClick(ActionEvent e) {
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnVal = fc.showOpenDialog(DecoderForm.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            outputDirectoryText.setText(file.getAbsolutePath());
        } else {
            outputDirectoryText.setText("select output directory");
        }
    }

    private void startButtonClick(ActionEvent e) {
        Decoder decoder = new Decoder(
                selectFileText.getText(),
                outputDirectoryText.getText(),
                keywordsArea.getText());

        decoder.tryDecrypt();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - sed sed
        selectFileButton = new JButton();
        selectFileText = new JTextField();
        outputDirectory = new JButton();
        outputDirectoryText = new JTextField();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        keywordsArea = new JTextArea();
        keywordsArea.setText(Const.DEFAULT_KEYWORD_LIST);
        startButton = new JButton();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "CWF Decoder", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new FormLayout(
            "default, $lcgap, 82dlu, $lcgap, default, $lcgap, 135dlu",
            "7*(default, $lgap), 38dlu, 3*($lgap, default)"));

        //---- selectFileButton ----
        selectFileButton.setText("Select file");
        selectFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectFileButtonClick(e);
            }
        });
        add(selectFileButton, CC.xywh(3, 5, 2, 1));
        add(selectFileText, CC.xy(7, 5));

        //---- outputDirectory ----
        outputDirectory.setText("Output directory");
        outputDirectory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputDirectoryClick(e);
            }
        });
        add(outputDirectory, CC.xywh(3, 9, 2, 1));
        add(outputDirectoryText, CC.xy(7, 9));

        //---- label2 ----
        label2.setText("Keywords(per comma):");
        add(label2, CC.xywh(3, 13, 3, 1));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(keywordsArea);
        }
        add(scrollPane1, CC.xywh(3, 14, 5, 4));

        //---- startButton ----
        startButton.setText("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButtonClick(e);
            }
        });
        add(startButton, CC.xywh(3, 21, 5, 1));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - sed sed
    private JButton selectFileButton;
    private JTextField selectFileText;
    private JButton outputDirectory;
    private JTextField outputDirectoryText;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTextArea keywordsArea;
    private JButton startButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
