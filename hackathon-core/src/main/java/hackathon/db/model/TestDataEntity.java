package hackathon.db.model;

import javax.persistence.*;

/**
 * @author egorov
 * @since 03.06.2019
 */
@Entity
@Table(name = "TEST_DATA")
public class TestDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATA")
    private String data;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
