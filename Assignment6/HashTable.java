package Assignment6;

class HashTable {

    private static final int TABLE_SIZE = 10;

    private Integer[] keys;      

    private String[] values;      

    public HashTable() {

        keys = new Integer[TABLE_SIZE];

        values = new String[TABLE_SIZE];

    }


    private int hash(int key) {

        return key % TABLE_SIZE;

    }


    public void put(int key, String value) {

        int index = hash(key);

        while (keys[index] != null) {

            if (keys[index].equals(key)) { // Update existing key

                values[index] = value;

                return;

            }

            index = (index + 1) % TABLE_SIZE; // Linear probing

        }

        keys[index] = key;

        values[index] = value;

    }


    public String get(int key) {

        int index = hash(key);

        while (keys[index] != null) {

            if (keys[index].equals(key)) {

                return values[index];

            }

            index = (index + 1) % TABLE_SIZE; // Linear probing

        }

        return null; 

    }


    public void display() {

        for (int i = 0; i < TABLE_SIZE; i++) {

            if (keys[i] != null) {

                System.out.println("Index " + i + ": Key = " + keys[i] + ", Value = " + values[i]);

            } else {

                System.out.println("Index " + i + ": [empty]");

            }

        }

    }



    public static void main(String[] args) {

    	HashTable hashTable = new HashTable();

        hashTable.put(1, "One");

        hashTable.put(2, "Two");

        hashTable.put(11, "Eleven");

        hashTable.put(3, "Three");

  
        hashTable.display();


        System.out.println("Value for key 1: " + hashTable.get(1));

        System.out.println("Value for key 11: " + hashTable.get(11));

        System.out.println("Value for key 2: " + hashTable.get(2));

        System.out.println("Value for key 3: " + hashTable.get(3));

        System.out.println("Value for key 5 (not present): " + hashTable.get(5));

    }

}


