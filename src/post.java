public class post {
    private String name;
    private String dongia;
    private static int postid = 100;
    private int id;
    private type level;

    public static int getPostid() {
        return postid;
    }

    public static void setPostid(int postid) {
        post.postid = postid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public type getLevel() {
        return level;
    }

    public void setLevel(type level) {
        this.level = level;
    }

    public post() {
        this.id = postid;
        postid++;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }

    @Override
    public String toString() {
        return "post{" +
                "name='" + name + '\'' +
                ", dongia='" + dongia + '\'' +
                ", id=" + id +
                ", level=" + level +
                '}';
    }

}
