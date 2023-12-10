package alex.app.myQuizzApp.security.user;


import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "AuthToken.findByUser_Id", query = "select a from AuthToken a where a.user.id = :id")
})
public class AuthToken {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(nullable = false)
    String token;

    public Long getId() {
        return id;
    }


    public AuthToken(){}
    public  AuthToken(String token,User user){
        this.token=token;
        this.user=user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User user;


    public void setRevoked(boolean revoked) {
        isRevoked = revoked;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public boolean isExpired;

    public boolean isRevoked;

    public void setId(Long id) {
        this.id = id;
    }
}
