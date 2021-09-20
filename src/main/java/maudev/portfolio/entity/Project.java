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


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "project")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Project {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private Long id;

    @Column(name = "pro_useid")
    private Long iduser;

    @Column(name = "pro_name" )
    private String name;

    @Column(name = "pro_description")
    private String description;

    @Column(name = "pro_resume")
    private String resume;

    @Column(name = "pro_urlproject")
    private String urlproject;

    @Column(name = "pro_urlgithub")
    private String urlgithub;

    @Column(name = "pro_status")
    private String status;

    @Column(name = "pro_createat")
    private Date  createat;


    @OneToMany(targetEntity = ProjectPhoto.class , fetch = FetchType.LAZY)
    @JoinColumn(name = "prp_proid")
    private List<ProjectPhoto> photos;


}
