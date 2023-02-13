package MVC;



public class main {

	public static void main(String[] args) throws Exception {
	Model model = new Model("Umut","1420","Manager");
	View view = new View();
	Controller control = new Controller(view,model);
	
	
}
}