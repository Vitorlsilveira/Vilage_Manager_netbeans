package datas;

public class Persion {

    private String id;
    private String name;
    private String sex;
    private String address;
    private String tpnum;
    private String birthday;

    public Persion(String id, String name, String sex, String address, String tpnum, String birthday) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.tpnum = tpnum;
        this.birthday = birthday;
    }

    public Persion() {
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTpnum() {
        return tpnum;
    }

    public void setTpnum(String tpnum) {
        this.tpnum = tpnum;
    }

}
