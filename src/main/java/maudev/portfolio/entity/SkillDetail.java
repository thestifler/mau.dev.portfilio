package maudev.portfolio.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "skill_detail")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class SkillDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skd_id")
    private Long id;
    @Column(name = "skd_skiid")
    private Long idskill;

    @Column(name = "skd_details")
    @NotEmpty(message = "Error : details  cannot be Empty")
    private String details;
    
    @Column(name = "skd_status")
    private String status;
    @Column(name = "skd_createat")
    private Date createat;

    
    
}
