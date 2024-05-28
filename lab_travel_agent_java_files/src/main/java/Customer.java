public class Customer {

//    properties

    private String name;
    private int wallet;

    public Customer(String name, int wallet){
        this.name = name;
        this.wallet = wallet;
    }

    public void pay(int amount){
        this.wallet -= amount;
    }

    public boolean canAfford(int price){
        if (price <= this.wallet){
            return true;
        }
        return false;
    }

//    getters and setters

    public void setName(String newName){
        this.name = newName;
    }

    public void setWallet(int newWallet){
        this.wallet = newWallet;
    }

    public String getName(){
        return this.name;
    }

    public int getWallet(){
        return this.wallet;
    }


}
