
 import java.io.*;
 import java.util.Scanner;
 import java.net.*;
import java.text.NumberFormat;
import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;

 public class Client extends JFrame implements ActionListener {
   // Text field for receiving radius
   private JTextField jtf = new JTextField();
 
   // Text area to display contents
   private JTextArea jta = new JTextArea();
 
   // IO streams
   
   private ObjectOutputStream outputObjToServer;
   private ObjectInputStream inputObjFromServer;
   private DataOutputStream outputToServer;
   private DataInputStream inputFromServer;
   public static void main(String[] args) {
     new Client();
   }
 
   public Client() {
     // Panel p to hold the label and text field
	
     JPanel p = new JPanel();
     p.setLayout(new BorderLayout());
     p.add(new JLabel("Height and weight in that order, seperated by exactly one space"), BorderLayout.WEST);
  
     p.add(jtf, BorderLayout.CENTER);
     jtf.setHorizontalAlignment(JTextField.RIGHT);
 
     getContentPane().setLayout(new BorderLayout());
     getContentPane().add(p, BorderLayout.NORTH);
     getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);
 
     jtf.addActionListener(this); // Register listener
 
     setTitle("Client");
     setSize(500, 300);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setVisible(true); // It is necessary to show the frame here!
 
     try {
       // Create a socket to connect to the server
       Socket socket = new Socket("localhost", 8000);
       // Socket socket = new Socket("130.254.204.36", 8000);
       // Socket socket = new Socket("drake.Armstrong.edu", 8000);
 
       // Create an input stream to receive data from the server
    inputFromServer = new DataInputStream(
 		      socket.getInputStream());
      outputToServer =
        new DataOutputStream(socket.getOutputStream());
       outputObjToServer = new ObjectOutputStream(socket.getOutputStream());
       outputObjToServer.flush();
       inputObjFromServer = new ObjectInputStream(socket.getInputStream());
       
       
       // Create an output stream to send data to the server
    
     }
     catch (IOException ex) {
       jta.append(ex.toString() + '\n');
     }
   }
 
   public void actionPerformed(ActionEvent e) {
     String actionCommand = e.getActionCommand();
     if (e.getSource() instanceof JTextField) {
       try {
         // Get the radius from the text field
         
         String bmiSet = jtf.getText().trim();
         String[] bmiGet = bmiSet.split(" ");
         Double height = Double.parseDouble(bmiGet[0]);
         Double weight = Double.parseDouble(bmiGet[1]);
         
         BMI bmiMove = new BMI(height, weight);
         outputObjToServer.writeObject(bmiMove);
         outputObjToServer.flush();
         
         double bmi = inputFromServer.readDouble();
         
         // Display to the text area
         NumberFormat nf = NumberFormat.getInstance();
         nf.setMaximumFractionDigits(3);
         
         String bmForm = nf.format(bmi);
         jta.append("BMI received from the server is "
           + bmForm + '\n');
       }
       catch (IOException ex) {
    	
         System.err.println(ex);
         
       }
     }
   }
 }
