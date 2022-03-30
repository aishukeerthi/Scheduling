import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

public class SchedulingUI {

	
	static File inputFile;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		JFrame frame = new JFrame("Scheduling Algorithms");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JLabel headerLabel = new JLabel("Project 2 AOS Algorithms, Student ID: 700728421 , Aishwarya Echapuram", JLabel.CENTER);    
		JButton button = new JButton();
		
		JLabel imgLabel = new JLabel(new ImageIcon("scheduler.jpg"));
		
		button.setText("upload excel file to input elements");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		String[] bookTitles = new String[] { "FCFS", "SJF", "Priority Scheduling", "Round Robin" };

		JComboBox<String> bookList = new JComboBox<>(bookTitles);
		panel.add(headerLabel);
		panel.add(button);
		panel.add(bookList);
		panel.add(imgLabel);
		frame.add(panel);
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		bookList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i = bookList.getSelectedIndex();

				try {
					
						if(inputFile != null) {
							SchedulingAlgorithm(i);
						}else {
							JOptionPane.showMessageDialog(frame, "Please upload input ",
						               "Swing Tester", JOptionPane.ERROR_MESSAGE);
						}
						
					
					
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
		});

		
		 
		button.addActionListener(new ActionListener() {

			@Override public void actionPerformed(ActionEvent e) { 		  
				JFileChooser jfc = new
						JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				int returnValue = jfc.showOpenDialog(null); // int returnValue =
				jfc.showSaveDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) { 
					File selectedFile = jfc.getSelectedFile(); 
					setSelectedFile(selectedFile);
					System.out.println(selectedFile.getAbsolutePath()); }
			}

		});
		 

	}
	
	static void setSelectedFile(File file) {
		
		inputFile = file;
		
	}

	static void SchedulingAlgorithm(int input) throws IOException {

		Scanner sc = new Scanner(inputFile);
		HashMap<String, ProcessObject> processMap = new HashMap<>();

		while (input != 3 && sc.hasNext()) {
			String str = sc.nextLine();
			String[] field = str.split(",");
			processMap.put(field[0], new ProcessObject(field[0], Integer.parseInt(field[1]), Integer.parseInt(field[2]),
					Integer.parseInt(field[3])));

		}

		switch (input) {

		case 0:
			FCFSScheduling.FAFCScheduling(processMap);
			break;
		case 1:
			SJFScheduling.getSJFScheduling(processMap);
			break;
		case 2:
			PriorityScheduling.getPriorityBasedScheduling(processMap);
			break;
		case 3:
			RRScheduling.findAvgTime(inputFile);
			break;
		default:
			System.out.println("Not a valid Input");

		}

	}

}
