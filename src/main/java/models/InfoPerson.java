package models;

public class InfoPerson {
    private String title;
    private String name;
    private String surname;
    private String address;
    private String mobile;

    public InfoPerson(String title, String name, String surname, String address, String mobile) {
        this.title = title;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.mobile = mobile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "'" + title + '\'' +
                ", '" + name + '\'' +
                ", '" + surname + '\'' +
                ", '" + address + '\'' +
                ", '" + mobile + '\'';
    }
}
