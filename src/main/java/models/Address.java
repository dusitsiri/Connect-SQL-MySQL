package models;

public class Address {

    private String province;
    private String district;
    private String subdistrict;
    private String zipcode;

    public Address(String province, String district, String subdistrict, String zipcode) {
        this.province = province;
        this.district = district;
        this.subdistrict = subdistrict;
        this.zipcode = zipcode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSubdistrict() {
        return subdistrict;
    }

    public void setSubdistrict(String subdistrict) {
        this.subdistrict = subdistrict;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return  "province='" + province + '\'' +
                ", district='" + district + '\'' +
                ", subdistrict='" + subdistrict + '\'' +
                ", zipcode='" + zipcode + '\'';
    }
}
