package entities;

import javax.persistence.*;

@Entity
@Table(name = "User", schema = "webApplication", catalog = "")
public class UserEntity {
    private String password;
    private String nickname = "User";
    private String email;
    private String perDes="This is personal Description";
    private String photoPro="123";
    private String gender="male";
    private String contactIno="info";
    private Integer iSstaff=1;
    private int id;
    private String username;

    @Basic
    @Column(name = "password", nullable = true, length = 16)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "nickname", nullable = true, length = 50)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 20)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "perDes", nullable = true, length = 225)
    public String getPerDes() {
        return perDes;
    }

    public void setPerDes(String perDes) {
        this.perDes = perDes;
    }

    @Basic
    @Column(name = "photoPro", nullable = true, length = 225)
    public String getPhotoPro() {
        return photoPro;
    }

    public void setPhotoPro(String photoPro) {
        this.photoPro = photoPro;
    }

    @Basic
    @Column(name = "gender", nullable = true, length = 10)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "iSstaff", nullable = true)
    public Integer getiSstaff() {
        return iSstaff;
    }

    public void setiSstaff(Integer iSstaff) {
        this.iSstaff = iSstaff;
    }


    @Basic
    @Column(name = "ISstaff", nullable = true)
    public Integer getiSstaff() {
        return iSstaff;
    }

    public void setiSstaff(Integer iSstaff) {
        this.iSstaff = iSstaff;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (contactIno != null ? !contactIno.equals(that.contactIno) : that.contactIno != null) return false;
        if (iSstaff != null ? !iSstaff.equals(that.iSstaff) : that.iSstaff != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = password != null ? password.hashCode() : 0;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (contactIno != null ? contactIno.hashCode() : 0);
        result = 31 * result + (iSstaff != null ? iSstaff.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
