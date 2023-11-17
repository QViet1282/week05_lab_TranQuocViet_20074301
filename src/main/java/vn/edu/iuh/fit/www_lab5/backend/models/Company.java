package vn.edu.iuh.fit.www_lab5.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id", length=20)
    private long companyId;
    @OneToOne
    @JoinColumn(name = "add_id")
    private Address address;
    @Column(columnDefinition = "varchar(2000)")
    private String about;
    @Column(name = "comp_name", columnDefinition = "varchar(255)")
    private String companyName;
    @Column(columnDefinition = "varchar(255)")
    private String email;
    @Column(columnDefinition = "varchar(255)")
    private String phone;
    @Column(name = "web_url",columnDefinition = "varchar(255)")
    private String webUrl;

    public Company() {
    }

    public Company(vn.edu.iuh.fit.www_lab5.backend.models.Address address, String about, String companyName, String email, String phone, String webUrl) {
        this.address = address;
        this.about = about;
        this.companyName = companyName;
        this.email = email;
        this.phone = phone;
        this.webUrl = webUrl;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public vn.edu.iuh.fit.www_lab5.backend.models.Address getAddress() {
        return address;
    }

    public void setAddress(vn.edu.iuh.fit.www_lab5.backend.models.Address address) {
        this.address = address;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", address=" + address +
                ", about='" + about + '\'' +
                ", companyName='" + companyName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", webUrl='" + webUrl + '\'' +
                '}';
    }
}
