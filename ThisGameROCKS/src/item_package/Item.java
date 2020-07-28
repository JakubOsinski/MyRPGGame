package item_package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Item 
{
	private String itemId;
	private String itemName;
	//private ArrayList<HashMap<String, Integer>> itemAttsReqs;
	private HashMap<String, Integer> itemAttsReqs;

	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
//	public ArrayList<HashMap<String, Integer>> getItemAttsReqs() {
//		return itemAttsReqs;
//	}
//	public void setItemAttsReqs(ArrayList<HashMap<String, Integer>> itemAttsReqs) {
//		this.itemAttsReqs = itemAttsReqs;
//	}
	public HashMap<String, Integer> getItemAttsReqs() {
		return itemAttsReqs;
	}
	public void setItemAttsReqs(HashMap<String, Integer> itemAttsReqs) {
		this.itemAttsReqs = itemAttsReqs;
	}
	

}
