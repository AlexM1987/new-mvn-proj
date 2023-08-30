package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Comparable{
    private int id;
    private String model;

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
