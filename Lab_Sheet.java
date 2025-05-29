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
	searchCustomerByName(String name){
		
	}
	
}

class Database{
	ArrayList<Item> item = new ArrayList<>();
	ArrayList<Customer> customer = new ArrayList<>();
	
	
}
class Main{
	void print(){
		System.out.println("------ Inventory Management ------");
		System.out.println("1. Add Item");
		System.out.println("2. Remove Item");
		System.out.println("3. Update Item Quantity");
		System.out.println("4. List All Items");
		System.out.println("5. Add Customer");
		System.out.println("6. List All Customers");
		System.out.println("7. Search Item by Name");
		System.out.println("0. Exit");
		System.out.println("---------------------------------");
		System.out.println("Enter your choice");


		
		
	}
	public static void main(String [] args){

	
	}
}

/* ------ Inventory Management ------
1. Add Item
2. Remove Item
3. Update Item Quantity
4. List All Items
5. Add Customer
6. List All Customers
7. Search Item by Name
0. Exit
---------------------------------
Enter your choice  */