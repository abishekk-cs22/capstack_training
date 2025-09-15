package pack1;

import pack2.DataManipulation;


public class Start {

	public Start(){
	 //Initialize
	}

	public static void main(String[] args) {		
		System.out.println("This is the Start of the program");
		
		Start start = new Start();
		
		
		
		DataManipulation dataManipulation = new DataManipulation();
		
		dataManipulation.readDataFromDatabase();
		dataManipulation.insertDataIntoDatabase();
		dataManipulation.readDataFromDatabase();
		dataManipulation.updateDataToDatabase();
		dataManipulation.readDataFromDatabase();
//		dataManipulation.deleteDataFromDatabase();
//		dataManipulation.readDataFromDatabase();
	
	
}
}

