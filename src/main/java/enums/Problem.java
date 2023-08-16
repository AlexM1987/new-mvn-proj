package enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Problem {

    private String name;
    private String details;
    private Severity severity;

    public Problem(String name, Severity severity) {
        this(name, null, severity);
    }

    public Problem(String name) {
        this(name, null, Severity.MINOR);
    }

    public void resolve(){
        System.out.println("Resolving the problem '" + name + "' ... " + severity.getTimeFrame());
    }
}
