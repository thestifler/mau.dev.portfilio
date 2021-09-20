package maudev.portfolio.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "work_experience")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "woe_id")
    private Long id;
    @Column(name = "woe_useid")
    private Long iduser;
    @Column(name = "woe_jobposition")
    private String jobposition;
    @Column(name = "woe_company")
    private String company;
    @Column(name = "woe_description")
    private String description;
    @Column(name = "woe_startdate")
    private Date startdate;
    @Column(name = "woe_finishdate")
    private Date finishdate;
    @Column(name = "woe_location")
    private String location;
    @Column(name = "woe_status")
    private String status;
    @Column(name = "woe_createat")
    private Date createat;


    
}
