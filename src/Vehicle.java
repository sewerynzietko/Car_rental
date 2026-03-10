public abstract class Vehicle {
    protected String id;
    protected String brand;
    protected String model;
    protected int year;
    protected float price;
    protected boolean rented;

    String toCSV () {
        return toCsv();
    }

    public String getId () {
        return id;
    }

    boolean isRented(){
        return this.rented;
    }

    void setRented(boolean rent){
        this.rented = rent;
    }

    public Vehicle ( String id, String brand, String model, int year, float price, boolean rented ) {}

    public abstract String toCsv ();
}
