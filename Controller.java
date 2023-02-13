package MVC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.crypto.SecretKey;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import userPack.EmployeeUser;


public class Controller implements ActionListener{
View view;
private Model model;
private String password;
File f = new File("/Users/umutmurat/Documents/database.txt");
FileOutputStream writer;
Scanner input;







public Controller(View view, Model model) {
	
	this.view = view;
	this.model = model;
	view.loginBut.addActionListener(this);
	view.exitBut.addActionListener(this);
	view.exitEmp.addActionListener(this);
	view.exitAdm.addActionListener(this);
	view.showData.addActionListener(this);
	view.showData2.addActionListener(this);
	view.exitemployee.addActionListener(this);
	view.addRow.addActionListener(this);
	view.deleteRow.addActionListener(this);
	view.updateRow.addActionListener(this);
	view.hireEmp.addActionListener(this);
	view.fireEmp.addActionListener(this);
	view.raiseSal.addActionListener(this);
	view.nJS2Label = new JLabel(model.userName + ", " +model.Salary + ", " +model.jobTitle);
	
	
	
}


public View getView() {
	return view;
}
public Model getModel() {
	return model;
}
public void setView(View view) {
	this.view = view;
}
public void setModel(Model model) {
	this.model = model;
}
public String checkLogin() {
password = String.valueOf(view.password.getPassword());
	File f1 = new File("/Users/umutmurat/Documents/Passwords.txt");
	Scanner input=null;
	try {
		input = new Scanner(f1);
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	String line;
    while (input.hasNext()) {
       line = input.nextLine();
     String[] values = line.split("\t");
     
     
     try {
		if(Cryptography.getHash(view.userName.getText()).equals(values[1])) {
			 
			try {
				if(Cryptography.getHash(password).equals(values[0])) {
					
					if(values[2].equals("employee")) {
					return "employee";
					}if (values[2].equals("employer")){
						return "employer";
						
					}
					if(values[2].equals("admin")) {
						return "admin";
						
					}
					}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
     }
     
  

	return "";
	
	
}
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==view.loginBut) {
	if(checkLogin().equals("employer")) {

		view.frame.dispose();
		view.EmployerView();
		
		
	}
	else if(checkLogin().equals("admin")) {
		view.frame.dispose();
		view.adminView();
	}
	else if(checkLogin().equals("employee")) {
		view.frame.dispose();
		view.employeeView();
	}else {
		  JOptionPane.showMessageDialog(null, "Incorrect username or password", "Error", 1);
	}
		
	 }  
	if(e.getSource()==view.exitBut) {
		System.exit(0);
	}
	if(e.getSource()==view.exitEmp) {
		int result = JOptionPane.showOptionDialog(null, "What do you want to do?", "Exit Options",
		        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
		        new String[]{"Exit App", "Exit to Login Page"}, "Exit App");
		if (result == JOptionPane.YES_OPTION) {
		     
		      System.exit(0);
		    } else if (result == JOptionPane.NO_OPTION) {
		      view.frame.setVisible(true);
		      view.frame2.dispose();
		      view.userName.setText(null);
		     view.password.setText(null);
		      
		      
		      
		    }

	}
	if(e.getSource()==view.showData) {
		
	//	view.frame2.dispose();
		try {
			view.databaseView(model.datalist);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
if(e.getSource()==view.showData2) {
		
	//	view.frame2.dispose();
		try {
			view.databaseView(model.datalist);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
if(e.getSource()==view.exitemployee) {
	int result = JOptionPane.showOptionDialog(null, "What do you want to do?", "Exit Options",
	        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
	        new String[]{"Exit App", "Exit to Login Page"}, "Exit App");
	if (result == JOptionPane.YES_OPTION) {
	     
	      System.exit(0);
	    } else if (result == JOptionPane.NO_OPTION) {
	      view.frame.setVisible(true);
	      view.frame2.dispose();
	      view.userName.setText(null);
	      view.password.setText(null);
	      
	      
	    }
	
}
if(e.getSource()==view.exitAdm) {
	int result = JOptionPane.showOptionDialog(null, "What do you want to do?", "Exit Options",
	        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
	        new String[]{"Exit App", "Exit to Login Page"}, "Exit App");
	if (result == JOptionPane.YES_OPTION) {
	     
	      System.exit(0);
	    } else if (result == JOptionPane.NO_OPTION) {
	      view.frame.setVisible(true);
	      view.frame2.dispose();
	      view.userName.setText(null);
	      view.password.setText(null);
	      
	      
	    }
}
if(e.getSource()==view.addRow) {
	
	      


	      
	  //    String data = "\n"+" "+Cryptography.encrypt(view.name1.getText(), Cryptography.generateSecretKey())+" "+Cryptography.encrypt(view.job1.getText(), Cryptography.generateSecretKey())+" " + Cryptography.encrypt(view.salary1.getText(), Cryptography.generateSecretKey());;
	      try {
			model.datalist.add(new EmployeeUser(view.name1.getText(),view.job1.getText(),view.salary1.getText()));
	model.writeToDatabase();
	      } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	   
	
	
}
if(e.getSource()==view.deleteRow) {
model.deleteRow(view.index2.getText());
try {
	model.writeToDatabase();
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}


}         
if(e.getSource()==view.updateRow) {
	model.updateRow(view.index3.getText(), view.salary3.getText());
	try {
		model.writeToDatabase();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	
	
}
if(e.getSource()==view.hireEmp) {
	 try {
			model.datalist.add(new EmployeeUser(view.name1.getText(),view.job1.getText(),view.salary1.getText()));
	model.writeToDatabase();
	      } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	   
	
}
if(e.getSource()==view.fireEmp) {
	
	model.deleteRow(view.index2.getText());
	
	try {
		model.writeToDatabase();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

}
if(e.getSource()==view.raiseSal) {
	model.updateRow(view.index3.getText(), view.salary3.getText());
	try {
		model.writeToDatabase();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}


}
}
