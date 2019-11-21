package cse360project1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Desktop;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JEditorPane;

public class GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launches the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates the frame.
	 */
	public GUI() {
		setForeground(Color.YELLOW);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnErrorLog = new JTextPane();
		txtpnErrorLog.setBackground(new Color(255, 153, 255));
		txtpnErrorLog.setBounds(10, 527, 425, 145);
		txtpnErrorLog.setText("Error Log");
		contentPane.add(txtpnErrorLog);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(255, 153, 255));
		editorPane.setForeground(new Color(33, 33, 33));
		editorPane.setBounds(221, 76, 214, 421);
		contentPane.add(editorPane);
		
		
			//saving to textFile
			JButton btnSaveFile = new JButton("Save File");
			btnSaveFile.setBackground(new Color(153, 51, 204));
			btnSaveFile.setBounds(10, 234, 100, 29);
			btnSaveFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String text = "This is the input text to be saved in file";
					try {
			            Files.write(Paths.get("my-file.txt"), text.getBytes());
			        
			        } catch (IOException e1) {
			            e1.printStackTrace();
			        }
				}
			});
			contentPane.add(btnSaveFile);
		
		JButton btnLoadFile_1 = new JButton("Load File");
		btnLoadFile_1.setBounds(10, 172, 100, 29);
		btnLoadFile_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
			    { 
			    String filetext="",filecontent="";

			    File file=new File("/Users/kobegoldman/Desktop/readme.txt");
			    FileReader fr=new FileReader(file);
			    BufferedReader br=new BufferedReader(fr);
			    StringBuilder sb=new StringBuilder();
			    
			           filetext=br.readLine();
			           sb.append(filetext);
			           sb.append("\n");
			    
			    filecontent=sb.toString();
			   // JOptionPane.showMessageDialog(null,"File is"+filecontent);
			    editorPane.setText("Here is some text");

			    }
			    catch(Exception ex){}
				
				
				
			}
			
		
		});
		contentPane.add(btnLoadFile_1);
		
		JLabel lblNewLabel = new JLabel("Text Parser Program", SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(100, 100, 100));
		lblNewLabel.setForeground(new Color (30,30,30));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNewLabel.setBounds(94, 6, 231, 29);
		contentPane.add(lblNewLabel);
		
		
		
		JLabel lblConsole = new JLabel("Console");
		lblConsole.setBounds(221, 59, 61, 16);
		contentPane.add(lblConsole);
		
		JButton btnPreview = new JButton("Preview");
		btnPreview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader("readme.txt"));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    String aLineFromFile = null;
			    try {
					while ((aLineFromFile = br.readLine()) != null){
					        JOptionPane.showMessageDialog(null, aLineFromFile);
					}
				} catch (HeadlessException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}        
			    try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    return;
			}
		});
		
			
			
		btnPreview.setBounds(10, 295, 100, 29);
		contentPane.add(btnPreview);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel}));
	
		
	}
	
}

