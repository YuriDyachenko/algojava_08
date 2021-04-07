package kurs;

public class HashTable {
    private final Item[] items;
    private final int size;
    private final Item noItem;
    private final MyUtils mu;
    private int numberOfCollisions;

    public HashTable(int size, MyUtils mu) {
        this.size = size;
        items = new Item[size];
        noItem = new Item(-1);
        this.mu = mu;
        clearNumberOfCollisions();
    }

    public void clearNumberOfCollisions() {
        numberOfCollisions = 0;
    }

    public int getNumberOfCollisions() {
        return numberOfCollisions;
    }

    public int hashFunc(int key) {
        return key % size;
    }

    public void insert(int key) {
        Item item = new Item(key);
        int hash = hashFunc(key);
        while (items[hash] != null && !items[hash].equals(noItem)) {
            ++hash;
            hash %= size;
            numberOfCollisions++;
        }
        items[hash] = item;
    }

    public Item delete(int key) {
        int hash = hashFunc(key);
        while (items[hash] != null) {
            if (items[hash].getKey() == key) {
                Item item = items[hash];
                items[hash] = noItem;
                return item;
            }
            ++hash;
            hash %= size;
        }
        return null;
    }

    public Item find(int key) {
        int hash = hashFunc(key);
        while (items[hash] != null) {
            if (items[hash].getKey() == key) return items[hash];
            ++hash;
            hash %= size;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(mu.leftPad(items[i] == null ? "." : items[i].toString(), Constants.DATA_PADDING)).
                    append((i + 1) % Constants.DATA_IN_ROW == 0 ? "\n" + mu.charStr(' ', 10) : "");
        }
        return "\nHashTable{" + sb.toString() + "}";
    }
}
