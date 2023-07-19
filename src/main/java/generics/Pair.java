package generics;

public interface Pair <K, V> { //K - key, V - value
    K getKey();
    V getValue();
    default void print(){
        System.out.println(getKey() + " : " + getValue());
    }
}

class Assoc <K,V> implements Pair <K,V> {

    private K key;
    private V value;

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public Assoc(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class PairTest{
    public static void main(String[] args) {
        Assoc<String,String> assoc1 = new Assoc<>("Main", "Главный");
        Assoc<String,String> assoc2 = new Assoc<>("Cat", "Кот");
        Assoc<String,String> assoc3 = new Assoc<>("Dog", "Собака");

        System.out.println(assoc2.getValue());
        assoc1.print();

        Storage<Assoc<String,String>> assocs = new Storage<>();
        assocs.add(assoc1);
        assocs.add(assoc2);
        assocs.add(assoc3);

        System.out.println(assocs.get(2).getValue());


        Assoc<Integer,String> assocIntStr1 = new Assoc<>(1, "One");
        Assoc<Integer,String> assocIntStr2 = new Assoc<>(2, "Two");
        Assoc<Integer,String> assocIntStr3 = new Assoc<>(3, "Three");
        Assoc<Integer,String> assocIntStr4 = new Assoc<>(4, "Four");
        Assoc<Integer,String> assocIntStr5 = new Assoc<>(5, "Five");
        Assoc<Integer,String> assocIntStr6 = new Assoc<>(6, "Six");
        Assoc<Integer,String> assocIntStr7 = new Assoc<>(7, "Seven");
        Assoc<Integer,String> assocIntStr8 = new Assoc<>(8, "Eight");
        Assoc<Integer,String> assocIntStr9 = new Assoc<>(9, "Nine");
        Assoc<Integer,String> assocIntStr10 = new Assoc<>(10, "Ten");
        Storage<Assoc<Integer, String>> assocsIntStr1 = new Storage<>();
        assocsIntStr1.add(assocIntStr1);
        assocsIntStr1.add(assocIntStr2);
        assocsIntStr1.add(assocIntStr3);
        assocsIntStr1.add(assocIntStr4);
        assocsIntStr1.add(assocIntStr5);
        assocsIntStr1.add(assocIntStr6);
        assocsIntStr1.add(assocIntStr7);
        assocsIntStr1.add(assocIntStr8);
        assocsIntStr1.add(assocIntStr9);
        assocsIntStr1.add(assocIntStr10);


    }
}
