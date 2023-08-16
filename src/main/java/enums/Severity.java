package enums;

public enum Severity {
    BLOCKER(1){
        @Override
        public String getTimeFrame() {
            return "Time to perform 3 hours.";
        }
    },
    CRITICAL(2){
        @Override
        public String getTimeFrame() {
            return "Time to perform 8 hours.";
        }
    },
    NOT_CRITICAL(3){
        @Override
        public String getTimeFrame() {
            return "Time to perform 2 days.";
        }
    },
    MINOR(4){
        @Override
        public String getTimeFrame() {
            return "Time to perform 2 weeks.";
        }
    };

    private int priority;
    Severity (int priority){
        this.priority = priority;
    }

    public int getPriority(){
        return priority;
    }

    public abstract String getTimeFrame();
}
