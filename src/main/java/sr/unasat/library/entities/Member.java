package sr.unasat.library.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
public class Member {

    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    private String date_of_birth;
    private String library_number;
    private String cbb_id_nummer;

    @ManyToMany (cascade = {CascadeType.ALL})
    @JoinTable (name = "Book_Member",
            joinColumns = {@JoinColumn(name = "member_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    private Set<Member> members;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getLibrary_number() {
        return library_number;
    }

    public void setLibrary_number(String library_number) {
        this.library_number = library_number;
    }

    public String getCbb_id_nummer() {
        return cbb_id_nummer;
    }

    public void setCbb_id_nummer(String cbb_id_nummer) {
        this.cbb_id_nummer = cbb_id_nummer;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }
}
