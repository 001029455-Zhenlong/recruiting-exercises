import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedList;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Test {
	
	@org.junit.Test
	public void testCase() {
		HashMap<String, Integer> order = new HashMap<String, Integer>();
        order.put("apple", 1);

        LinkedList<Inventory> warehouses = new LinkedList<Inventory>();
        HashMap<String, Integer> inventory = new HashMap<String, Integer>();
        inventory.put("apple", 1);
        Inventory wh = new Inventory("owd", inventory);
        warehouses.add(wh);

        System.out.println("Input: " + order + ", " + warehouses);

        LinkedList<Inventory> result = new LinkedList<Inventory>();
        result.add(wh);

        WarehouseShipment shipment = new WarehouseShipment();
        LinkedList<Inventory> output = (LinkedList<Inventory>) shipment.shipFromWarehousesInAscendingOrder(order, warehouses);

        System.out.println("Output: " + output);
        System.out.println();

        assertEquals(result.toString(), output.toString());
	}
	
	@org.junit.Test
    /** Warehouses contain items not in the order. */
    public void testItemsNotInOrder() {
        HashMap<String, Integer> order = new HashMap<String, Integer>();
        order.put("apple", 5);
        order.put("banana", 5);
        order.put("orange", 5);

        LinkedList<Inventory> warehouses = new LinkedList<Inventory>();

        HashMap<String, Integer> inventory1 = new HashMap<String, Integer>();
        inventory1.put("apple", 5);
        inventory1.put("orange", 10);
        inventory1.put("cabbage", 10);
        Inventory wh1 = new Inventory("ny", inventory1);
        warehouses.add(wh1);

        HashMap<String, Integer> inventory2 = new HashMap<String, Integer>();
        inventory2.put("banana", 5);
        inventory2.put("orange", 10);
        inventory2.put("sweet potato", 10);
        Inventory wh2 = new Inventory("sf", inventory2);
        warehouses.add(wh2);

        System.out.println("Input: " + order + ", " + warehouses);

        WarehouseShipment allocator = new WarehouseShipment();
        LinkedList<Inventory> output = allocator.shipFromWarehousesInAscendingOrder(order, warehouses);

        LinkedList<Inventory> result = new LinkedList<Inventory>();

        HashMap<String, Integer> result_inv1 = new HashMap<String, Integer>();
        result_inv1.put("apple", 5);
        result_inv1.put("orange", 5);
        Inventory result_wh1 = new Inventory("ny", result_inv1);
        result.add(result_wh1);

        HashMap<String, Integer> result_inv2 = new HashMap<String, Integer>();
        result_inv2.put("banana", 5);
        Inventory result_wh2 = new Inventory("sf", result_inv2);
        result.add(result_wh2);

        System.out.println("Output: " + output);
        System.out.println();

        assertEquals(result.toString(), output.toString());
    }
	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(Test.class);
	}
}
