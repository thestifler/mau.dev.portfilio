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
@Table(name ="project_photo")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class ProjectPhoto {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prp_id")
    private Long id;
    @Column(name = "prp_proid")
    private Long idproject;
    @Column(name = "prp_url")
    private String url;
    @Column(name = "prp_status")
    private String status;
    @Column(name = "prp_createat")
    private Date createat;

}
