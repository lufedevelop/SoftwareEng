//Class to store all information about a Residence
package sample;

final class DBResidence {
    private final int ID;
    private final String style;
    private final String type;
    private final int price;
    private final String address;
    private final boolean mealplan;
    private final String users;

    public DBResidence(int ID, String style, String type, int price, String address, boolean mealplan, String users){
        this.ID = ID;
        this.style = style;
        this.type = type;
        this.price = price;
        this.address = address;
        this.mealplan = mealplan;
        this.users = users;
    }

    public int getID(){
        return ID;
    }

    public String getStyle() {
        return style;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public String getAddress() {
        return address;
    }

    public boolean getMealplan() {
        return mealplan;
    }

    public String getUsers() {
        return users;
    }

}
