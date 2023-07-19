package generics;

public class GenericObject <T> {  //T не может быть примитивом, только объект
    private T value;

    public GenericObject(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class GenericTest{
    public static void main(String[] args) {
        GenericObject<String> gen = new GenericObject<String>("ABC");

        String val = gen.getValue();

        GenericObject<Integer> gen2 = new GenericObject<Integer>(123);

        gen2.setValue(54); // 54 -> new Integer(54)
        gen2.setValue(new Integer(123));

        int i_1 = gen2.getValue().intValue();

        Double d_1 = 10.5; // Неявная автоупаковка
        Double d_2 = new Double(80.5); // Явная упаковка

        GenericObject<Boolean> gen3 = new GenericObject<>(true);
    }
}
