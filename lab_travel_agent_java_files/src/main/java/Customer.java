public class Customer {

//    properties

    private String name;
    private int wallet;

    public Customer(String name, int wallet){
        this.name = name;
        this.wallet = wallet;
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
