package cn.snpyy.telephonedictionary.bean;

/**
 * 通讯录数据类  PhoneDirBean
 * @author 遂宁彭于晏
 */
public class PhoneDir {
    private int id;
    private String master;       //电话簿主人
    private String contact;     //联系人名字
    private long number;        //联系人电话
    private String homeLoc;     //号码归属地
    private String address;     //朋友地址备注

    public PhoneDir() {
    }

    public PhoneDir(String master, String contact, long number, String homeLoc, String address) {
        this.master = master;
        this.contact = contact;
        this.number = number;
        this.homeLoc = homeLoc;
        this.address = address;
    }

    public PhoneDir(int id, String master, String contact, long number, String homeLoc, String address) {
        this.id = id;
        this.master = master;
        this.contact = contact;
        this.number = number;
        this.homeLoc = homeLoc;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getHomeLoc() {
        return homeLoc;
    }

    public void setHomeLoc(String homeLoc) {
        this.homeLoc = homeLoc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PhoneDir{" +
                "id=" + id +
                ", master='" + master + '\'' +
                ", contact='" + contact + '\'' +
                ", number=" + number +
                ", homeLoc='" + homeLoc + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
