package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;
	private int count = 0;
	private Collectible[] inventory;

	public NaiveInventory() {
		inventory = new Collectible[INITIAL_CAPACITY];
	}

	@Override
	public void collect(Collectible collectible) {
		if (count >= inventory.length) {
			Collectible[] newInventory = new Collectible[inventory.length * 2];
			for (int i = 0; i < inventory.length; i++) {
				newInventory[i] = inventory[i];
			}

			inventory = newInventory;
		}
		inventory[count] = collectible;
		count++;
	}

	@Override
	public float getTotalWeight() {
		float weight = 0;
		for (int i = 0; i < count; i++) {
			weight += inventory[i].getWeight();
		}
		return weight;
	}

	@Override
	public int getCurrentCount() {
		return count;
	}

	// Returns the array of Collectibles that is stored in the field of this class
	public Collectible[] getCollArr() {
		return inventory;
	}
}
