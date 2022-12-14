package sr.unasat.library.entities;

import lombok.*;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String date_of_birth;
    private String library_number;
    private String cbb_id_number;

    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "borrowreceipt_id")
    private BorrowReceipt borrowReceipt;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "book_member",
            joinColumns = {@JoinColumn(name = "member_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    private Set<Book> books = new HashSet<Book>();

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

    public String getCbb_id_number() {
        return cbb_id_number;
    }

    public void setCbb_id_number(String cbb_id_number) {
        this.cbb_id_number = cbb_id_number;
    }

    public BorrowReceipt getBorrowReceipt() {
        return borrowReceipt;
    }

    public void setBorrowReceipt(BorrowReceipt borrowReceipt) {
        this.borrowReceipt = borrowReceipt;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}


