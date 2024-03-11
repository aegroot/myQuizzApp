package alex.app.myQuizzApp.domain.question;

import jakarta.persistence.*;


@Entity
public class Option  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String option;
    private boolean isRight;

    public Option(){}
    public Option(String option, boolean isRight){
        this.option=option;
        this.isRight=isRight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }
    public boolean getIsRight(){return  isRight;}

}


