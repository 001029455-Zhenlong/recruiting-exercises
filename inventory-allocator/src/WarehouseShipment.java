import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WarehouseShipment {
    /**
     * Computes the best way an order can be shipped, given the inventory across
     * the warehouses. Destructively modifies _orders to reflect inventory allocations.
     */
	
	public LinkedList<Inventory> shipFromWarehousesInAscendingOrder(Map<String, Integer> order,List<Inventory> inventories){
		LinkedList<Inventory> list = new LinkedList<>();
		
		int totalCount = 0;
		for(String key : order.keySet())
			totalCount+=order.get(key);
		
		for(Inventory inventory : inventories) {
			Inventory newInventory = new Inventory(inventory.getWareHouse(),new HashMap<String,Integer>());
			
			for(String item : inventory.getInventory().keySet()) {
				if(totalCount==0) return list;
				
				if(order.getOrDefault(item, 0)==0||inventory.getItemCount(item)==0) continue;
				
				int requestNum = order.get(item);
				int storeNum = inventory.getItemCount(item);
				int taken = Math.min(requestNum, storeNum);
				newInventory.setItemCount(item, taken);
				
				totalCount -=taken;
				
				int leftInOrders = requestNum - storeNum;
				
				int max_inv = Math.max(0, leftInOrders);
				
				order.put(item, max_inv);
				
				if(!list.contains(newInventory)) list.add(newInventory);
			}
		}
		return list;
	}
}
