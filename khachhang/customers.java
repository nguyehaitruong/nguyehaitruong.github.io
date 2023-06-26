
public class customers extends person {
 private customer level;
    private static int AUTO_ID = 10000;
    private  int id;
    public customers() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public customer getLevel() {
        return level;
    }

    public void setLevel(customer level) {
        this.level = level;
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
