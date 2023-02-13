package MVC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import userPack.EmployeeUser;

public class Model {
public String userName;

public String Salary;
public String jobTitle;
int count = 0 ;

public String level;
private File f = new File("/Users/umutmurat/Documents/database.txt");
File f1 = new File("/Users/umutmurat/Documents/deneme.txt");
ArrayList<EmployeeUser> datalist = new ArrayList<EmployeeUser>();
ArrayList<String> data = new ArrayList<String>();
Scanner input = new Scanner(f);
PrintStream ps;
Scanner scan2 = new Scanner(f);







public Model(String userName,String Salary,String jobTitle) throws Exception {
	
	this.userName = userName;
	
	this.Salary = Salary;
	this.jobTitle = jobTitle;
	this.level = level;
	while(input.hasNext()) {
		datalist.add(new EmployeeUser(Cryptography.decrypt(input.next(), Cryptography.generateSecretKey()),Cryptography.decrypt(input.next(), Cryptography.generateSecretKey()),Cryptography.decrypt(input.next(), Cryptography.generateSecretKey())));
	
	}
	
	while(scan2.hasNext()) {
		data.add(scan2.nextLine());
	}

	
}

public void writeToDatabase() throws Exception {
ps = new PrintStream(f);
	for(int i = 0 ; i<datalist.size();i++) {
		ps.println(Cryptography.encrypt(datalist.get(i).getUserName(),Cryptography.generateSecretKey())+" "+Cryptography.encrypt(datalist.get(i).getJobTitle(),Cryptography.generateSecretKey())+" "+Cryptography.encrypt(datalist.get(i).getSalary(),Cryptography.generateSecretKey()));
	}
	}

public void deleteRow(String a){
	datalist.remove(Integer.parseInt(a));
	
	

} 
public void updateRow(String a,String sal) {
	int b = Integer.parseInt(a);
	EmployeeUser temp = new EmployeeUser(datalist.get(b).getUserName(),datalist.get(b).getJobTitle(),sal);
	datalist.set(b, temp);
	
	
	
}
		
	 



public File getF() {
	return f;
}





public void setF(File f) {
	this.f = f;
}





public String getLevel() {
	return level;
}





public void setLevel(String level) {
	this.level = level;
}





public String getUserName() {
	return userName;
}










public String getJobTitle() {
	return jobTitle;
}



public void setUserName(String userName) {
	this.userName = userName;
}










}
