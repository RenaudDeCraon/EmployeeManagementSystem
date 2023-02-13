package MVC;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import userPack.EmployeeUser;


public class View {
	
	JFrame frame;
	JFrame frame2;
	JPanel panel;
	JButton loginBut;
	JButton exitBut;
	JTextField userName;
	JPasswordField password;
	JLabel labelSignIn;
	JLabel labelUserName;
	JLabel labelpassword;
JButton showData = new JButton("Show Database");
JButton hireEmp = new JButton("Hire Employee");
JButton fireEmp = new JButton("Fire Employee");
JButton raiseSal = new JButton("Raise Salary");
JButton exitEmp = new JButton("Exit");
JButton exitData = new JButton("Exit");
JButton returnData = new JButton("Return");
JTextField name1;
JTextField job1;
JTextField salary1;
JTextField index2;

JTextField index3;

JTextField salary3;

JButton showData2 = new JButton("Show Database");
JButton addRow=new JButton("Add Row");
JButton deleteRow = new JButton("Delete Row");
JButton updateRow = new JButton("Update Row");
JButton exitAdm = new JButton("Exit");
JLabel nJSlabel;
JLabel nJS2Label;
JButton exitemployee = new JButton("Exit");
File f = new File("/Users/umutmurat/Documents/database.txt");
JLabel databaseList;
Scanner input;
Scanner counter;
int rows = 0;
public ArrayList<EmployeeUser> datalist1 = new ArrayList<EmployeeUser>();
String [][] data;
ArrayList<String> datalist = new ArrayList<String>();
JTable jt = new JTable();
	

	View() {
	frame = new JFrame("User Employment System");
	frame.setSize(800, 800);
	frame.setLocation(100, 100);
	frame.setLayout(null);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	
	frame.setLayout(null);
	panel = new JPanel();
	panel.setBounds(0, 0, 800, 800);
	panel.setLayout(null);
//panel.setBackground(new Color(121,170,25
	
	loginBut = new JButton("Login");
	loginBut.setBounds(350, 400, 100, 50);
	panel.add(loginBut);
	exitBut = new JButton("Exit");
	exitBut.setBounds(450, 400, 50, 50);
	panel.add(exitBut);
	userName = new JTextField();
	userName.setBounds(350,350,100,20);
	panel.add(userName);
	password = new JPasswordField();
	password.setBounds(350, 375, 100, 20);
	panel.add(password);
	labelSignIn = new JLabel("Sign In");
	labelSignIn.setBounds(350, 300, 100, 50);
	labelSignIn.setFont(new Font("Arial", Font.BOLD, 15));
	
	labelSignIn.setOpaque(false);
	
	labelUserName = new JLabel("User Name");
	panel.add(labelUserName);
	labelpassword = new JLabel();
	panel.add(labelpassword);
	frame.add(labelSignIn);
	
	
	
	frame.add(panel);

		
		
		
		frame.setVisible(true);
	}
	public void EmployerView() {
		frame2 = new JFrame("Employer View");
		frame2.setSize(800,800);
		frame2.setLocation(100, 100);
		frame2.setLayout(null);
		frame2.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame2.setVisible(true); 
		panel = new JPanel();
		panel.setBounds(0, 0, 800, 800);
		panel.setLayout(null);
		
		
		showData.setBounds(225, 200, 350, 25);
		panel.add(showData);
		
		
		hireEmp.setBounds(445, 240, 130, 25);
		panel.add(hireEmp);
		
		
		fireEmp.setBounds(445, 280, 130, 25);
		panel.add(fireEmp);
		
	
		raiseSal.setBounds(445, 320, 130, 25);
		panel.add(raiseSal);
		
		
		exitEmp.setBounds(216, 360, 360, 25);
		panel.add(exitEmp);
		
		name1 = new JTextField();
		name1.setBounds(225, 240, 70, 25);
		panel.add(name1);
		JLabel namelabel = new JLabel("Name");
		namelabel.setBounds(225, 220, 70, 25);
		panel.add(namelabel);
		
		
		job1= new JTextField();
		job1.setBounds(300, 240, 70, 25);
		panel.add(job1);
		JLabel joblabel = new JLabel("Job");
		joblabel.setBounds(300, 220, 70, 25);
		panel.add(joblabel);
		
		
		salary1 = new JTextField();
		salary1.setBounds(375, 240, 70, 25);
		panel.add(salary1);
		JLabel salarylabel = new JLabel("Salary");
		salarylabel.setBounds(375, 220, 70, 25);
		panel.add(salarylabel);
		
		index2 = new JTextField();
		index2.setBounds(225, 280, 215, 25);
		panel.add(index2);
		JLabel index2label = new JLabel("Index");
		index2label.setBounds(225, 260, 70, 25);
		panel.add(index2label);
		
		
		index3 = new JTextField();
		index3.setBounds(225, 320, 105, 25);
		panel.add(index3);
		JLabel index3label = new JLabel("Index");
		index3label.setBounds(225, 300, 70, 25);
		panel.add(index3label);
		
		
		
		salary3 = new  JTextField();
		salary3.setBounds(335, 320, 105, 25);
		panel.add(salary3);
		JLabel salary3label = new JLabel("Salary");
		salary3label.setBounds(335, 300, 70, 25);
		panel.add(salary3label);
		
		
		
		
		frame2.add(panel);
		
		frame2.setVisible(true);
	}
	public void databaseView(ArrayList<EmployeeUser> employees) throws Exception   {
	
		int rows =employees.size();
		int columns = 3;
		
		
		ArrayList<Object[]> data = new ArrayList<>();
		for(int i = 0 ; i < employees.size();i++) {
			data.add(new Object[] {employees.get(i).getUserName(),employees.get(i).getJobTitle(),employees.get(i).getSalary() });
		}
		String [] columnnames = {"Name", "Job", "Salary"};
		
		DefaultTableModel model = new DefaultTableModel(data.toArray(new Object[data.size()][]),columnnames);
		
	 	this.data = new String[rows][columns];
		
			frame2 = new JFrame("Database");
			frame2.setSize(400,400);
			frame2.setLocation(100, 100);
			
			frame2.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			
			
			
			
			
			
			   jt.setModel(model);
		    jt.setBounds(30,40,200,300);          
		    jt.setFocusable(false);
		    JScrollPane sp=new JScrollPane(jt);    
		    frame2.add(sp);          
			frame2.setVisible(true);  
		
	}
	
	public void adminView() {
		frame2 = new JFrame("Admin View");
		frame2.setSize(800,800);
		frame2.setLocation(100, 100);
		frame2.setLayout(null);
		frame2.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame2.setVisible(true); 
		panel = new JPanel();
		panel.setBounds(0, 0, 800, 800);
		panel.setLayout(null);
		
		
		showData2.setBounds(225, 200, 350, 25);
		panel.add(showData2);
		
		
		addRow.setBounds(445, 240, 130, 25);
		panel.add(addRow);
		
		
		deleteRow.setBounds(445, 280, 130, 25);
		panel.add(deleteRow);
		
		
		
		updateRow.setBounds(445, 320, 130, 25);
		panel.add(updateRow);
		
		
		exitAdm.setBounds(216, 360, 360, 25);
		panel.add(exitAdm);
		
		name1 = new JTextField();
		name1.setBounds(225, 240, 70, 25);
		panel.add(name1);
		JLabel namelabel = new JLabel("Name");
		namelabel.setBounds(225, 220, 70, 25);
		panel.add(namelabel);
		
		
		job1= new JTextField();
		job1.setBounds(300, 240, 70, 25);
		panel.add(job1);
		JLabel joblabel = new JLabel("Job");
		joblabel.setBounds(300, 220, 70, 25);
		panel.add(joblabel);
		
		
		salary1 = new JTextField();
		salary1.setBounds(375, 240, 70, 25);
		panel.add(salary1);
		JLabel salarylabel = new JLabel("Salary");
		salarylabel.setBounds(375, 220, 70, 25);
		panel.add(salarylabel);
		
		index2 = new JTextField();
		index2.setBounds(225, 280, 215, 25);
		panel.add(index2);
		JLabel index2label = new JLabel("Index");
		index2label.setBounds(225, 260, 70, 25);
		panel.add(index2label);
		
		
		index3 = new JTextField();
		index3.setBounds(225, 320, 105, 25);
		panel.add(index3);
		JLabel index3label = new JLabel("Index");
		index3label.setBounds(225, 300, 70, 25);
		panel.add(index3label);
		
		
		
		salary3 = new  JTextField();
		salary3.setBounds(335, 320, 105, 25);
		panel.add(salary3);
		JLabel salary3label = new JLabel("Salary");
		salary3label.setBounds(335, 300, 70, 25);
		panel.add(salary3label);
		
		
		
		
		frame2.add(panel);
		
		frame2.setVisible(true);
	}
	public void employeeView() {
		frame2 = new JFrame("Employee View");
		frame2.setSize(800,800);
		frame2.setLocation(100, 100);
		frame2.setLayout(null);
		frame2.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame2.setVisible(true); 
		panel = new JPanel();
		panel.setBounds(0, 0, 800, 800);
		panel.setLayout(null);
		
		
		nJSlabel = new JLabel("Name , Salary , Job");
		nJSlabel.setBounds(350, 350, 150, 20);
		panel.add(nJSlabel);
		
		
		nJS2Label.setBounds(350, 370, 250, 20);
		panel.add(nJS2Label);
		
		
		exitemployee.setBounds(350, 430, 100, 20);
		panel.add(exitemployee);
		
		
		frame2.add(panel);
		
		
		frame2.setVisible(true);
		
		
	}
	
}
