package alex.app.myQuizzApp.domain.summary;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Summary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    //limited char count/values
    String description;

    @OneToMany
    Set<SummaryChapter>chapters;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
