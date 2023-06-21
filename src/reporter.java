public class reporter extends person {
    private static int AUTO_ID = 10000;

    private int id;
    private type level;

    public reporter() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public  type getLevtel() {
        return level;
    }

    public void setLevel(type level) {
        this.level = level;
    }

    public  int getAutoId() {
        return AUTO_ID;
    }

    public  void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    @Override
    public String toString() {
        return "reporter{" +
                "id=" + id +
                ", level=" + level +
                '}';
    }
}
