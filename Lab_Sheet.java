import java.util.*;

class Item{
	private String description;
	private String name;
	private int unitPrice;
	private int quantityAvailable;
	
	void updateQuantity(int amount){
		
	}
	void printDetails(){
		System.out.println();
	}
	
	public String getDescription(){ return description;}
	public String getName(){ return name;}
	public int getUnitPrice(){return unitPrice;}
	public int getQuantityAvailable(){return quantityAvailable;}
	
	public void setUnitPrice(int newPrice){unitPrice = newPrice;}
	public void setQuantityAvailable(int qty){quantityAvailable = qty;}


	addItem(Item item){
		
	}
	removeItem(String itemName or ID){
		
	}
	searchItem(String name){
		
	}
	updateItemQuantity(String itemName, int amount){
		
	}
	
	
	
}

class Customer{
	String name;
	String contactDetails;
	
	addCustomer(Customer customer){
		
	}
	removeCustomer(String name){
		
	}
	listCustomers(){
		
	}
	searchCustomerByName(String name{
		
	}
	
}

class Database{
	ArrayList<Item> item = new ArrayList<>();
	ArrayList<Customer> customer = new ArrayList<>();
	
	
}
class Main{
	public static void main(String [] args){

	
	}
}
