package kurs;

import java.util.Objects;

public class Item {
    private final int data;

    public Item(int data) {
        this.data = data;
    }

    public int getKey() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return data == item.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "" + data;
    }
}
