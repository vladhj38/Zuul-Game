import java.util.*;

/**
 * Write a description of class Player here.
 * 
 * @author Tanzeel
 */
public class Player {
	/**
	 * feilds :
	 */
	private String name;
	private String description;
	private Room currentRoom;
	private int weight;
	private HashMap<String,Item> itemsInPossesion;
	private Room previousRoom;
	/**
	 * Constructor for objects of class Player
	 */
	public Player(String name, String description, int weight) {
		this.name = name;
		this.description = description;
		this.weight = weight;
		itemsInPossesion = new HashMap<String,Item>();
	}

	public Room getCurrentPlayerRoom() {
		return currentRoom;
	}

	public String getPlayerDescription() {
		return description;
	}

	public String getPlayerName() {
		return name;
	}

	public String getFullPlayerDescription() {
		return name + " \n Can pick upto : " + weight
				+ " Kg. \n total wight carried : "+totalWeightCarried() 
				+ " \n bag pack :"  ;
	}

	public boolean pick(String itemName,Item item) {
		if (canPickItem(item)) {
			itemsInPossesion.put(itemName,item);
			return true;
		} else {
			System.out.println("Player can not pick " + item);
			return false;
		}
	}

	public Item drop(String itemName) {
		if (!itemsInPossesion.containsKey(itemName)) {
			return null;
		} else {
			Item itemDropped = itemsInPossesion.get(itemName);
			itemsInPossesion.remove(itemDropped);
			return itemDropped;
		}
	}

	private boolean canPickItem(Item item) {
		if ((totalWeightCarried() + item.getItemWeight()) > weight) {
			return false;
		}
		return true;
	}

	private int totalWeightCarried() {
		int weightCarried = 0;
		Set<String> keys = itemsInPossesion.keySet();
		for (String items : keys) {
			weightCarried += itemsInPossesion.get(items).getItemWeight();
		}
		return weightCarried;
	}

	public void printItemsAndWeight() {
	    Set<String> keys = itemsInPossesion.keySet();
		for (String items : keys) {
			System.out.println( itemsInPossesion.get(items).getItemDescription() + " "
					+  itemsInPossesion.get(items).getItemWeight() + "\n");
		}
		System.out.println(totalWeightCarried());

	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	public Room getPreviousRoom() {
		return previousRoom;
	}
	public void setPreviousRoom(Room previousRoom) {
		this.previousRoom = previousRoom;
	}
}
