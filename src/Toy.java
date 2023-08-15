public class Toy {
    private int id;
    private String name;
    private int count;
    private double winWeight;

    public Toy(int id, String name, int count, double winWeight) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.winWeight = winWeight;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setWinWeight(double winWeight) {
        this.winWeight = winWeight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public double getWinWeight() {
        return winWeight;
    }
    public void addMoreToys(int count){
        this.setCount(this.getCount()+count);
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", winWeight=" + winWeight +
                '}';
    }
}