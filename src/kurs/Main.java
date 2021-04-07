package kurs;

public class Main {

    public static void main(String[] args) {
        //задание 8.1
        exampleOfHashTables();
        //задание 8.2
        exampleOfKeysAndCollisions();
        //задание 8.3
        exampleOfHashFinctions();
        //задание 8.4-8.5
        testHashTables();
    }

    private static void testHashTables() {
        System.out.println("- - - - - Задание 8.4 - 8.5 - - - - -");
        MyUtils mu = new MyUtils();

        HashTable ht = new HashTable(66, mu);
        DoubleHashTable dht = new DoubleHashTable(66, mu);
        fillTables(ht, dht, mu);

        System.out.println(ht);
        System.out.println("ht.getNumberOfCollisions() = " + ht.getNumberOfCollisions());
        System.out.println(dht);
        System.out.println("dht.getNumberOfCollisions() = " + dht.getNumberOfCollisions());

        System.out.println("ht.find(222) = " + ht.find(222));
        System.out.println("dht.find(222) = " + dht.find(222));

        System.out.println("ht.delete(309) = " + ht.delete(309));
        System.out.println("dht.delete(309) = " + dht.delete(309));

        System.out.println(ht);
        System.out.println(dht);
    }

    private static void fillTables(HashTable ht, DoubleHashTable dht, MyUtils mu) {
        for (int i = 0; i < 30; i++) {
            int ri = mu.random.nextInt(1000);
            ht.insert(ri);
            dht.insert(ri);
        }

        ht.insert(209);
        ht.insert(309);
        ht.insert(222);
        dht.insert(209);
        dht.insert(309);
        dht.insert(222);
    }

    private static void exampleOfHashTables() {
        System.out.println("- - - - - Задание 8.1 - - - - -");
        System.out.println(" Примеры использования хеш таблиц:");
        System.out.println("  HashMap");
        System.out.println("  HashSet");
    }

    private static void exampleOfKeysAndCollisions() {
        System.out.println("- - - - - Задание 8.2 - - - - -");
        System.out.println(" Примеры ключей и коллизий:");
        System.out.println("  ключ int = 15, 27...");
        System.out.println("  ключ String = orange, apple, mango");
        System.out.println("  коллизии - когда для разных ключей получается одно значение хеш функции");
        System.out.println("  например, для 19 и 29 хеш функция Х % 10 вернет одно значение 9");
    }

    private static void exampleOfHashFinctions() {
        System.out.println("- - - - - Задание 8.3 - - - - -");
        System.out.println(" Примеры хеш функций:");
        System.out.println("  основанные на умножении");
        System.out.println("  основанные на делении");
        System.out.println("  криптографические");
    }
}
