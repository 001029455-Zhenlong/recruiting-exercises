import java.util.Map;

public class Inventory {
	String wareHouse;
	Map<String,Integer> inventory;
	
	public Inventory(String wareHouse,Map<String, Integer> inventory) {
		this.wareHouse = wareHouse;
		this.inventory = inventory;
	}
	
	public Inventory() {}

	public String getWareHouse() {
		return wareHouse;
	}

	public void setWareHouse(String wareHouse) {
		this.wareHouse = wareHouse;
	}

	public Map<String, Integer> getInventory() {
		return inventory;
	}

	public void setInventory(Map<String, Integer> inventory) {
		this.inventory = inventory;
	}
	
	public int getItemCount(String item) {
		return inventory.getOrDefault(item, 0);
	}
	
	public void setItemCount(String item,int count) {
		inventory.put(item, count);
	}

	@Override
	public String toString() {
		return "name:" + wareHouse + ", inventory:" + inventory;
	};
}
