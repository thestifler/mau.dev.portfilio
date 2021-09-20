package maudev.portfolio.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_portfolio")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "use_id")
    private Long id;
    @Column(name = "use_name")
    private String name;
    @Column(name = "use_lastname")
    private String lastname;
    @Column(name = "use_aboutme")
    private String aboutme;
    @Column(name = "use_jobposition")
    private String jobposition;
    @Column(name = "use_status")
    private String status;
    @Column(name = "use_createat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createat;

    @OneToMany(targetEntity = Contact.class , fetch = FetchType.LAZY )
    @JoinColumn(name = "con_useid")
    private List<Contact> contacts;

    @OneToMany(targetEntity = WorkExperience.class , fetch = FetchType.LAZY)
    @JoinColumn(name = "woe_useid")
    private List<WorkExperience> workExperiences;


    @OneToMany(targetEntity = Project.class , fetch = FetchType.LAZY)
    @JoinColumn(name = "pro_useid")
    private List<Project> projecsList;

    @OneToMany(targetEntity = Skill.class , fetch = FetchType.LAZY)
    @JoinColumn(name = "ski_useid")
    private List<Skill> skills;

    
}
