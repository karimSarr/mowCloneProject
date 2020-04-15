
package application;  
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import java.io.PrintWriter;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.AttributedString;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;  
import javafx.scene.Scene;  
import javafx.scene.control.Button;  
import javafx.scene.control.Label;  
import javafx.scene.control.TextField;  
import javafx.scene.layout.HBox;  
import javafx.stage.FileChooser;  
import javafx.stage.Stage;  
import javafx.application.Application;  
import javafx.scene.Scene;  
import javafx.scene.control.Button;  
import javafx.scene.control.Label;  
import javafx.scene.control.TextField;  
import javafx.scene.layout.HBox;  
import javafx.stage.FileChooser;  
import javafx.stage.Stage; 
import java.awt.datatransfer.*; // Clipboard
import java.io.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.text.*;

import com.inet.jortho.SpellChecker;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JPanel;


public class Principale extends JPanel {
    private static JTextPane jcomp1,jcomp2,jtp;
    private JMenuBar Fichier;
    static JLabel l, l1; 
    private JButton bouton = new JButton("Mon bouton");
    private JButton b, b1, b2, b3; 
    private JScrollPane scrollPane;


    public Principale() {
    	
        Fichier = new JMenuBar();
    	JMenu fileMenu = new JMenu ("Fichier");
    	JMenuItem nouveau = new JMenuItem ("Nouveau");
      	nouveau.setMnemonic(KeyEvent.VK_N);
      	nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
      	nouveau.setActionCommand("Nouveau");
        fileMenu.add (nouveau);
        JMenuItem modifierItem = new JMenuItem ("Ouvrir Fichier");
        modifierItem.setMnemonic(KeyEvent.VK_O);
        modifierItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        modifierItem.setActionCommand("Ouvrir Fichier");
        fileMenu.add (modifierItem);
        JMenuItem savMenu = new JMenuItem ("Enregistrer");
        savMenu.setMnemonic(KeyEvent.VK_S);
        savMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        savMenu.setActionCommand("Enregistrer");
        fileMenu.add (savMenu);
        
        
    	JMenu editMenu = new JMenu ("Edit");
      	JMenuItem italic = new JMenuItem ("Italic");
      	italic.setActionCommand("Italic");
      	editMenu.add (italic);
      	
      	JMenuItem gras = new JMenuItem ("Gras");
      	gras.setActionCommand("Gras");
      	
      	JMenuItem plain = new JMenuItem ("Normal");
      	editMenu.add (plain);
      	plain.setActionCommand("Plein");
      	
      	JMenuItem souligne = new JMenuItem ("Souligné");
      	editMenu.add (souligne);
      	souligne.setActionCommand("Souligné");
      	
    	JMenuItem couper = new JMenuItem ("Couper");
    	couper.setMnemonic(KeyEvent.VK_X);
      	couper.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
      	couper.setActionCommand("Couper");
      	editMenu.add (couper);
      	
    	JMenuItem copie = new JMenuItem ("Copier");
      	copie.setMnemonic(KeyEvent.VK_C);
      	copie.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
      	copie.setActionCommand("Copier");
      	editMenu.add (copie);
      	
      	JMenuItem coller = new JMenuItem ("Coller");
		coller.setMnemonic(KeyEvent.VK_V);
		coller.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
      	coller.setActionCommand("Coller");
      	editMenu.add (coller);
      	
      	
        JMenu policeMenu = new JMenu ("Police");
        JMenuItem agency_fbItem = new JMenuItem ("Agency FB");
        agency_fbItem.setActionCommand("Agency FB");
        policeMenu.add (agency_fbItem);
        
        JMenuItem arialItem = new JMenuItem ("Arial Black");
        arialItem.setActionCommand("Arial Black");
        policeMenu.add (arialItem);
        
        JMenuItem franklin_gothic_mediumItem = new JMenuItem ("Franklin Gothic Medium");
        franklin_gothic_mediumItem.setActionCommand("Franklin Gothic Medium");
        policeMenu.add (franklin_gothic_mediumItem);
        
        JMenuItem times_new_romanItem = new JMenuItem ("Times New Roman");
        times_new_romanItem.setActionCommand("Times New Roman");
        policeMenu.add (times_new_romanItem);
        
        JMenuItem algerianItem = new JMenuItem ("Algerian");
        algerianItem.setActionCommand("Algerian");
        policeMenu.add (algerianItem);
        
        JMenuItem Gigi = new JMenuItem ("Gigi");
        Gigi.setActionCommand("Gigi");
        policeMenu.add (Gigi);
        
        JMenuItem Castellar = new JMenuItem ("Castellar");
        Castellar.setActionCommand("Castellar");
        policeMenu.add (Castellar);
        
        JMenuItem Harrington = new JMenuItem ("Harrington");
        Harrington.setActionCommand("Harrington");
        policeMenu.add (Harrington);
        
        JMenuItem Magneto = new JMenuItem ("Magneto");
        Magneto.setActionCommand("Magneto");
        policeMenu.add (Magneto);
        
        JMenuItem Vladimir = new JMenuItem ("Vladimir Script");
        Vladimir.setActionCommand("Vladimir Script");
        policeMenu.add (Vladimir);

        JMenuItem Calibri = new JMenuItem ("Calibri");
        Calibri.setActionCommand("Calibri");
        policeMenu.add (Calibri);
        
        JMenuItem Freestyle = new JMenuItem ("Freestyle Script");
        Freestyle.setActionCommand("Freestyle Script");
        policeMenu.add (Freestyle);
        
        
        JMenu couleurMenu = new JMenu ("Couleur");
        JMenuItem rougeItem = new JMenuItem ("Rouge");
        couleurMenu.add (rougeItem);
        rougeItem.setActionCommand("Rouge");
        
        JMenuItem jauneItem = new JMenuItem ("Jaune");
        couleurMenu.add (jauneItem);
        jauneItem.setActionCommand("Jaune");
        
        JMenuItem vertItem = new JMenuItem ("Vert");
        couleurMenu.add (vertItem);
        vertItem.setActionCommand("Vert");
        
        JMenuItem bleuItem = new JMenuItem ("Bleu");
        couleurMenu.add (bleuItem);
        bleuItem.setActionCommand("Bleu");
        
        JMenuItem orangeItem = new JMenuItem ("Orange");
        couleurMenu.add (orangeItem);
        orangeItem.setActionCommand("Orange");
        
        JMenuItem jauneItem1 = new JMenuItem ("Gris");
        couleurMenu.add (jauneItem1);
        jauneItem1.setActionCommand("Gris");
        
        JMenuItem rougeItem2 = new JMenuItem ("Noir");
        couleurMenu.add (rougeItem2);
        rougeItem2.setActionCommand("Noir");
        
        JMenu helpMenu = new JMenu ("Help");
        JMenuItem aboutItem = new JMenuItem ("About");
        helpMenu.add (aboutItem);

      
        jcomp1 = new JTextPane ();
    	jcomp2 = new JTextPane();
    	SpellChecker.register(jcomp1);

    	


        setPreferredSize (new Dimension (1366, 760));
        setLayout (null);

        add (jcomp1);
        add (Fichier);

        jcomp1.setBounds (125, 90, 1100, 4000);
        Fichier.setBounds (0, 0, 2000, 30);


        MenuItemListener menuItemListener = new MenuItemListener();
		nouveau.addActionListener(menuItemListener);
		modifierItem.addActionListener(menuItemListener);
		savMenu.addActionListener(menuItemListener);
		couper.addActionListener(menuItemListener);
		copie.addActionListener(menuItemListener);
		coller.addActionListener(menuItemListener);
		gras.addActionListener(menuItemListener);
		italic.addActionListener(menuItemListener);
		souligne.addActionListener(menuItemListener);
		plain.addActionListener(menuItemListener);
		agency_fbItem.addActionListener(menuItemListener);
		Calibri.addActionListener(menuItemListener);
		arialItem.addActionListener(menuItemListener);
		franklin_gothic_mediumItem.addActionListener(menuItemListener);
		times_new_romanItem.addActionListener(menuItemListener);
		algerianItem.addActionListener(menuItemListener);
		Freestyle.addActionListener(menuItemListener);
		Vladimir.addActionListener(menuItemListener);
		Magneto.addActionListener(menuItemListener);
		Harrington.addActionListener(menuItemListener);
		Castellar.addActionListener(menuItemListener);
		Gigi.addActionListener(menuItemListener);
		rougeItem.addActionListener(menuItemListener);
		jauneItem.addActionListener(menuItemListener);
		vertItem.addActionListener(menuItemListener);
		bleuItem.addActionListener(menuItemListener);
		orangeItem.addActionListener(menuItemListener);
		jauneItem1.addActionListener(menuItemListener);
		rougeItem2.addActionListener(menuItemListener);
		
		fileMenu.add(nouveau);
		fileMenu.add(modifierItem);
        fileMenu.add (savMenu);
      	editMenu.add(couper);
		editMenu.add(copie);
		editMenu.add(coller);
		editMenu.add(italic);
		editMenu.add(gras);
		editMenu.add(souligne);
		editMenu.add(plain);
		
		policeMenu.add (agency_fbItem);
		policeMenu.add (algerianItem);
		policeMenu.add (arialItem);
		policeMenu.add (Calibri);
		policeMenu.add (Castellar);
		policeMenu.add (franklin_gothic_mediumItem);
		policeMenu.add (Freestyle);
		policeMenu.add (Gigi);
		policeMenu.add (Harrington);
		policeMenu.add (Magneto);
		policeMenu.add (times_new_romanItem);
		policeMenu.add (Vladimir);
		couleurMenu.add(rougeItem);
		couleurMenu.add(jauneItem);
		couleurMenu.add(vertItem);
		couleurMenu.add(bleuItem);
		couleurMenu.add(orangeItem);
		couleurMenu.add(jauneItem1);
		couleurMenu.add(rougeItem2);
		Fichier.add(fileMenu);
		Fichier.add(editMenu);
        Fichier.add (couleurMenu);
        Fichier.add (policeMenu);
		this.setJMenuBar(Fichier);
        Fichier.add (helpMenu);
  
    }
    private void setContentPane(JMenuBar fichier2) {
		// TODO Auto-generated method stub
		
	}
	private void setJMenuBar(JMenuBar fichier2) {
		// TODO Auto-generated method stub
		
	}
	class MenuItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {            
           //tA.setText(e.getActionCommand() + " JMenuItem clicked.");
           if (e.getActionCommand() == "Nouveau") {
        JFrame frame = new JFrame ("TextView");
		SpellChecker.registerDictionaries(null,"fr","fr");
    	frame.getContentPane().add(new Principale());
        frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
           }
           if (e.getActionCommand() == "Ouvrir Fichier") {
        	   JFileChooser dialogue = new JFileChooser(new File("."));
       		PrintWriter sortie;
       		File fichier;
       		if (dialogue.showOpenDialog(null)== 
       		    JFileChooser.APPROVE_OPTION) {
       		    fichier = dialogue.getSelectedFile();
       		    try {
       		        JFrame frame = new JFrame ("TextView");
       				SpellChecker.registerDictionaries(null,"fr","fr");
       		    	frame.getContentPane().add(new Principale());
       		        frame.pack();
       				frame.setLocationRelativeTo(null);
       				frame.setVisible(true);
					sortie = new PrintWriter
					(new FileWriter(fichier.getPath(), true));
			          FileReader fr=new FileReader(fichier);    
			          BufferedReader br=new BufferedReader(fr);
			          int i;    
			          while((i=br.read())!=-1){  
			        	  jcomp1.setText(jcomp1.getText()+Character.toString((char)i));
			          }  
			          br.close();    
			          fr.close();    
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
       		}
           }
           if (e.getActionCommand() == "Enregistrer"){
          	 JFileChooser chooser = new JFileChooser();
          	 BufferedWriter writer;
               int returnVal = chooser.showSaveDialog(getParent());
               if(returnVal == JFileChooser.APPROVE_OPTION)
               {
                   try
                   {
                  	 writer = new BufferedWriter(new FileWriter(chooser.getSelectedFile()));
                       jcomp1.write(writer);
                       writer.close();
                   } catch (FileNotFoundException fnfe)
                   {
                       fnfe.printStackTrace();
                   } catch (IOException ioe)
                   {
                       ioe.printStackTrace();
                   }
               }
           }
           if (e.getActionCommand() == "Copier") {
        	   try
               {
                        String str=jcomp1.getSelectedText();
        		Toolkit toolkit = Toolkit.getDefaultToolkit();
        		Clipboard clipboard = toolkit.getSystemClipboard();
        		StringSelection strSel = new StringSelection(str);
        		clipboard.setContents(strSel, null);
               }catch(Exception err)
               {
                   err.printStackTrace();
               }      	   
           }
           if (e.getActionCommand() == "Couper") {
        	   try
               {
        		String str=jcomp1.getSelectedText();
        		Toolkit toolkit = Toolkit.getDefaultToolkit();
        		Clipboard clipboard = toolkit.getSystemClipboard();
        		StringSelection strSel = new StringSelection(str);
        		clipboard.setContents(strSel, null);
        		String texto="";
             	jcomp1.replaceSelection(texto);
               }catch(Exception err)
               {
                   err.printStackTrace();
               }         	   
           }
           if (e.getActionCommand() == "Coller") {
        	   Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
               String text="";
                  try
                  {  
                	 	text = (String) clipboard.getData(DataFlavor.stringFlavor);
                 	   jcomp1.replaceSelection(text);
                  }
                  catch (Exception e1)
                  {
                     JOptionPane.showMessageDialog(null, e1);
                  }
              }
           if (e.getActionCommand() == "Italic") {
   		    int debutSel=jcomp1.getSelectionStart();
   		    int finSel=jcomp1.getSelectedText().length();
   		    SimpleAttributeSet styleItalic=new SimpleAttributeSet();
   		    StyleConstants.setItalic(styleItalic, true);
   		    StyledDocument doc=jcomp1.getStyledDocument();
   		    doc.setCharacterAttributes(debutSel, finSel, styleItalic, false);
              }
           if (e.getActionCommand() == "Gras") {
        		    int debutSel=jcomp1.getSelectionStart();
        		    int finSel=jcomp1.getSelectedText().length();
        		    SimpleAttributeSet styleGras = new SimpleAttributeSet();
        		    StyleConstants.setBold(styleGras, true);
        		    StyledDocument doc=jcomp1.getStyledDocument();
        		    doc.setCharacterAttributes(debutSel, finSel, styleGras, false);
           }
           if (e.getActionCommand() == "Plein") {

       		String textot="";
        	   Style defaut = jcomp1.getStyle("default");
        	   Style style1 = jcomp1.addStyle("bold", defaut);
        	   StyleConstants.setFontFamily(style1, "bold");
        	   Style style2 = jcomp1.addStyle("style2", style1);
        	      StyleConstants.setForeground(style2, Color.black);
        	      StyleConstants.setFontSize(style2, 10);        
        	      StyledDocument sDoc = (StyledDocument)jcomp1.getDocument();
        	      try {
               	   int debut = jcomp1.getSelectionStart();
               	   sDoc.insertString(debut, jcomp1.getSelectedText(), style1);
               	   jcomp1.replaceSelection(textot);
        	      } catch (BadLocationException ey) { }
              }
          if (e.getActionCommand() == "Souligné") {
           int debutSel=jcomp1.getSelectionStart();
		    int finSel=jcomp1.getSelectedText().length();
		    SimpleAttributeSet styleUnderline = new SimpleAttributeSet();
		    StyleConstants.setUnderline(styleUnderline, true);
		    StyledDocument doc=jcomp1.getStyledDocument();
		    doc.setCharacterAttributes(debutSel, finSel, styleUnderline, false);
          }

          if (e.getActionCommand() == "Rouge") {
        	  Style defaut = jcomp1.getStyle("default");
      		  Style style1 = jcomp1.addStyle("bold", defaut);
    	      StyleConstants.setForeground(style1, Color.red);
    	      StyledDocument sDoc = (StyledDocument)jcomp1.getDocument();
    	      try {
           	   int debut = jcomp1.getSelectionStart();
    	          sDoc.insertString(debut, jcomp1.getSelectedText(), style1);
        		String Rouge="";
             	jcomp1.replaceSelection(Rouge);
    	    } catch (BadLocationException ey) { }   	   
             }
          if (e.getActionCommand() == "Jaune") {
        	  Style defaut = jcomp1.getStyle("default");
      		  Style style1 = jcomp1.addStyle("bold", defaut);
    	      StyleConstants.setForeground(style1, Color.yellow);
    	      StyledDocument sDoc = (StyledDocument)jcomp1.getDocument();
    	      try {
           	   int debut = jcomp1.getSelectionStart();
    	          sDoc.insertString(debut, jcomp1.getSelectedText(), style1);
        		String Jaune="";
             	jcomp1.replaceSelection(Jaune);
    	    } catch (BadLocationException ey) { }      	   
             }
          if (e.getActionCommand() == "Vert") {
        	  Style defaut = jcomp1.getStyle("default");
      		  Style style1 = jcomp1.addStyle("bold", defaut);
    	      StyleConstants.setForeground(style1, Color.green);
    	      StyledDocument sDoc = (StyledDocument)jcomp1.getDocument();
    	      try {
           	   int debut = jcomp1.getSelectionStart();
    	          sDoc.insertString(debut, jcomp1.getSelectedText(), style1);
        		String Vert="";
             	jcomp1.replaceSelection(Vert);
    	    } catch (BadLocationException ey) { }      	   
             }
          if (e.getActionCommand() == "Bleu") {
        	  Style defaut = jcomp1.getStyle("default");
      		  Style style1 = jcomp1.addStyle("bold", defaut);
    	      StyleConstants.setForeground(style1, Color.blue);
    	      StyledDocument sDoc = (StyledDocument)jcomp1.getDocument();
    	      try {
           	   int debut = jcomp1.getSelectionStart();
    	          sDoc.insertString(debut, jcomp1.getSelectedText(), style1);
        		String Bleu="";
             	jcomp1.replaceSelection(Bleu);
    	    } catch (BadLocationException ey) { }      	   
             }
          if (e.getActionCommand() == "Orange") {
        	  Style defaut = jcomp1.getStyle(jcomp1.getSelectedText());
      		  Style style1 = jcomp1.addStyle("bold", defaut);
    	      StyleConstants.setForeground(style1, Color.orange);
    	      StyleConstants.setFontFamily(style1, "Agency FB");
    	      StyledDocument sDoc = (StyledDocument)jcomp1.getDocument();
    	      try {
           	   int debut = jcomp1.getSelectionStart();
    	          sDoc.insertString(debut, jcomp1.getSelectedText(), style1);
        		String Orange="";
             	jcomp1.replaceSelection(Orange);
    	    } catch (BadLocationException ey) { }     	   
             }
          if (e.getActionCommand() == "Gris") {
        	  Style defaut = jcomp1.getStyle("default");
      		  Style style1 = jcomp1.addStyle("bold", defaut);
    	      StyleConstants.setForeground(style1, Color.gray);
    	      StyledDocument sDoc = (StyledDocument)jcomp1.getDocument();
    	      try {
           	   int debut = jcomp1.getSelectionStart();
    	          sDoc.insertString(debut, jcomp1.getSelectedText(), style1);
        		String Gris="";
             	jcomp1.replaceSelection(Gris);
    	    } catch (BadLocationException ey) { }    	   
             }
          if (e.getActionCommand() == "Noir") {
        	  Style defaut = jcomp1.getStyle("default");
      		  Style style1 = jcomp1.addStyle("bold", defaut);
    	      StyleConstants.setForeground(style1, Color.black);
    	      StyledDocument sDoc = (StyledDocument)jcomp1.getDocument();
    	      try {
           	   int debut = jcomp1.getSelectionStart();
    	          sDoc.insertString(debut, jcomp1.getSelectedText(), style1);
        		String Noir="";
             	jcomp1.replaceSelection(Noir);
    	    } catch (BadLocationException ey) { }  	   
             }

          if (e.getActionCommand() == "Agency FB") {
        	  Style defaut = jcomp1.getStyle("default");
      		  Style style1 = jcomp1.addStyle("bold", defaut);
    	      StyleConstants.setForeground(style1, Color.black);
    	      StyleConstants.setFontFamily(style1, "Agency FB");
    	      StyleConstants.setFontSize(style1, 17);        
    	      StyledDocument sDoc = (StyledDocument)jcomp1.getDocument();
    	      try {
           	   int debut = jcomp1.getSelectionStart();
    	          sDoc.insertString(debut, jcomp1.getSelectedText(), style1);
        		String Agency="";
             	jcomp1.replaceSelection(Agency);
    	    } catch (BadLocationException ey) { }   	   
             }

          if (e.getActionCommand() == "Arial Black") {
        	  Style defaut = jcomp1.getStyle("default");
      		  Style style1 = jcomp1.addStyle("bold", defaut);
    	      StyleConstants.setForeground(style1, Color.black);
    	      StyleConstants.setFontFamily(style1, "Arial Black");
    	      StyleConstants.setFontSize(style1, 17);        
    	      StyledDocument sDoc = (StyledDocument)jcomp1.getDocument();
    	      try {
           	   int debut = jcomp1.getSelectionStart();
    	          sDoc.insertString(debut, jcomp1.getSelectedText(), style1);
        		String Arial="";
             	jcomp1.replaceSelection(Arial);
    	    } catch (BadLocationException ey) { }   	   
             }

          if (e.getActionCommand() == "Franklin Gothic Medium") {
        	  Style defaut = jcomp1.getStyle("default");
      		  Style style1 = jcomp1.addStyle("bold", defaut);
    	      StyleConstants.setForeground(style1, Color.black);
    	      StyleConstants.setFontFamily(style1, "Franklin Gothic Medium");
    	      StyleConstants.setFontSize(style1, 17);        
    	      StyledDocument sDoc = (StyledDocument)jcomp1.getDocument();
    	      try {
           	   int debut = jcomp1.getSelectionStart();
    	          sDoc.insertString(debut, jcomp1.getSelectedText(), style1);
        		String Franklin="";
             	jcomp1.replaceSelection(Franklin);
    	    } catch (BadLocationException ey) { }   	   
             }

          if (e.getActionCommand() == "Times New Roman") {
        	  Style defaut = jcomp1.getStyle("default");
      		  Style style1 = jcomp1.addStyle("bold", defaut);
    	      StyleConstants.setForeground(style1, Color.black);
    	      StyleConstants.setFontFamily(style1, "Times New Roman");
    	      StyleConstants.setFontSize(style1, 17);        
    	      StyledDocument sDoc = (StyledDocument)jcomp1.getDocument();
    	      try {
           	   int debut = jcomp1.getSelectionStart();
    	          sDoc.insertString(debut, jcomp1.getSelectedText(), style1);
        		String Times="";
             	jcomp1.replaceSelection(Times);
    	    } catch (BadLocationException ey) { }   	   
             }

          if (e.getActionCommand() == "Algerian") {
        	  Style defaut = jcomp1.getStyle("default");
      		  Style style1 = jcomp1.addStyle("bold", defaut);
    	      StyleConstants.setForeground(style1, Color.black);
    	      StyleConstants.setFontFamily(style1, "Algerian");
    	      StyleConstants.setFontSize(style1, 17);        
    	      StyledDocument sDoc = (StyledDocument)jcomp1.getDocument();
    	      try {
           	   int debut = jcomp1.getSelectionStart();
    	          sDoc.insertString(debut, jcomp1.getSelectedText(), style1);
        		String Algerian="";
             	jcomp1.replaceSelection(Algerian);
    	    } catch (BadLocationException ey) { }   	   
             }

          if (e.getActionCommand() == "Freestyle Script") {
        	  Style defaut = jcomp1.getStyle("default");
      		  Style style1 = jcomp1.addStyle("bold", defaut);
    	      StyleConstants.setForeground(style1, Color.black);
    	      StyleConstants.setFontFamily(style1, "Freestyle Script");
    	      StyleConstants.setFontSize(style1, 35);        
    	      StyledDocument sDoc = (StyledDocument)jcomp1.getDocument();
    	      try {
           	   int debut = jcomp1.getSelectionStart();
    	          sDoc.insertString(debut, jcomp1.getSelectedText(), style1);
        		String Freestyle="";
             	jcomp1.replaceSelection(Freestyle);
    	    } catch (BadLocationException ey) { }   	   
             }

          if (e.getActionCommand() == "Vladimir Script") {
        	  Style defaut = jcomp1.getStyle("default");
      		  Style style1 = jcomp1.addStyle("bold", defaut);
    	      StyleConstants.setForeground(style1, Color.black);
    	      StyleConstants.setFontFamily(style1, "Vladimir Script");
    	      StyleConstants.setFontSize(style1, 25);        
    	      StyledDocument sDoc = (StyledDocument)jcomp1.getDocument();
    	      try {
           	   int debut = jcomp1.getSelectionStart();
    	          sDoc.insertString(debut, jcomp1.getSelectedText(), style1);
        		String Vladimir="";
             	jcomp1.replaceSelection(Vladimir);
    	    } catch (BadLocationException ey) { }   	   
             }

          if (e.getActionCommand() == "Magneto") {
        	  Style defaut = jcomp1.getStyle("default");
      		  Style style1 = jcomp1.addStyle("bold", defaut);
    	      StyleConstants.setForeground(style1, Color.black);
    	      StyleConstants.setFontFamily(style1, "Magneto");
    	      StyleConstants.setFontSize(style1, 22);        
    	      StyledDocument sDoc = (StyledDocument)jcomp1.getDocument();
    	      try {
           	   int debut = jcomp1.getSelectionStart();
    	          sDoc.insertString(debut, jcomp1.getSelectedText(), style1);
        		String Magneto="";
             	jcomp1.replaceSelection(Magneto);
    	    } catch (BadLocationException ey) { }   	   
             }

          if (e.getActionCommand() == "Harrington") {
        	  Style defaut = jcomp1.getStyle("default");
      		  Style style1 = jcomp1.addStyle("bold", defaut);
    	      StyleConstants.setForeground(style1, Color.black);
    	      StyleConstants.setFontFamily(style1, "Harrington");
    	      StyleConstants.setFontSize(style1, 17);        
    	      StyledDocument sDoc = (StyledDocument)jcomp1.getDocument();
    	      try {
           	   int debut = jcomp1.getSelectionStart();
    	          sDoc.insertString(debut, jcomp1.getSelectedText(), style1);
        		String Harrington="";
             	jcomp1.replaceSelection(Harrington);
    	    } catch (BadLocationException ey) { }   	   
             }

          if (e.getActionCommand() == "Calibri") {
        	  Style defaut = jcomp1.getStyle("default");
      		  Style style1 = jcomp1.addStyle("bold", defaut);
    	      StyleConstants.setForeground(style1, Color.black);
    	      StyleConstants.setFontFamily(style1, "Calibri");
    	      StyleConstants.setFontSize(style1, 17);        
    	      StyledDocument sDoc = (StyledDocument)jcomp1.getDocument();
    	      try {
           	   int debut = jcomp1.getSelectionStart();
    	          sDoc.insertString(debut, jcomp1.getSelectedText(), style1);
        		String Calibri="";
             	jcomp1.replaceSelection(Calibri);
    	    } catch (BadLocationException ey) { }   	   
             }

          if (e.getActionCommand() == "Castellar") {
        	  Style defaut = jcomp1.getStyle("default");
      		  Style style1 = jcomp1.addStyle("bold", defaut);
    	      StyleConstants.setForeground(style1, Color.black);
    	      StyleConstants.setFontFamily(style1, "Castellar");
    	      StyleConstants.setFontSize(style1, 17);        
    	      StyledDocument sDoc = (StyledDocument)jcomp1.getDocument();
    	      try {
           	   int debut = jcomp1.getSelectionStart();
    	          sDoc.insertString(debut, jcomp1.getSelectedText(), style1);
        		String Castellar="";
             	jcomp1.replaceSelection(Castellar);
    	    } catch (BadLocationException ey) { }   	   
             }

          if (e.getActionCommand() == "Gigi") {
        	  Style defaut = jcomp1.getStyle("default");
      		  Style style1 = jcomp1.addStyle("bold", defaut);
    	      StyleConstants.setForeground(style1, Color.black);
    	      StyleConstants.setFontFamily(style1, "Gigi");
    	      StyleConstants.setFontSize(style1, 25);        
    	      StyledDocument sDoc = (StyledDocument)jcomp1.getDocument();
    	      try {
           	   int debut = jcomp1.getSelectionStart();
    	          sDoc.insertString(debut, jcomp1.getSelectedText(), style1);
        		String Gigi="";
             	jcomp1.replaceSelection(Gigi);
    	    } catch (BadLocationException ey) { }   	   
             }

		}    
     	}
	
    public static void main (String[] args) {
        JFrame frame = new JFrame ("TextView");
		SpellChecker.registerDictionaries(null,"fr","fr");
        //frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    	frame.getContentPane().add(new Principale());
        frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
        
    }
}