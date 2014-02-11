
package datas;

public class Home {
    private String hoemnumber;
    private String owner;
    private String address;
    private String tpnumber;
    private int numofmembers;

    public Home(){
       
    }
    
    public Home(String hoemnumber, String owner, String address, String tpnumber, int numofmembers ){
        this.hoemnumber = hoemnumber;
        this.owner = owner;
        this.address = address;
        this.tpnumber = tpnumber;
        this.numofmembers = numofmembers;
    }
    
    public void setHoemnumber(String hoemnumber) {
        this.hoemnumber = hoemnumber;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTpnumber(String tpnumber) {
        this.tpnumber = tpnumber;
    }

    public void setNumofmembers(int numofmembers) {
        this.numofmembers = numofmembers;
    }

    public String getHoemnumber() {
        return hoemnumber;
    }

    public String getOwner() {
        return owner;
    }

    public String getAddress() {
        return address;
    }

    public String getTpnumber() {
        return tpnumber;
    }

    public int getNumofmembers() {
        return numofmembers;
    }
    
    
}
