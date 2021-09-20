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
@Table(name = "skill")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ski_id")
    private Long id;
    @Column(name = "ski_useid")
    private Long iduser;
    @Column(name = "ski_name")
    private String name;
    @Column(name = "ski_urlphoto")
    private String urlphoto;
    @Column(name = "ski_description")
    private String description;
    @Column(name = "ski_status")
    private String status;
    @Column(name = "ski_createat")
    private Date createat;

    @OneToMany(targetEntity = SkillDetail.class , fetch = FetchType.LAZY)
    @JoinColumn(name = "skd_skiid")
    private List<SkillDetail> skillDetails;
}
