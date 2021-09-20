package maudev.portfolio.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contact")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Contact {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "con_id")
    private Long id;
    @Column(name = "con_useid")
    private Long iduser;
    @Column(name = "con_name")
    private String name;
    @Column(name = "con_url")
    private String url;
    @Column(name = "con_urlphoto")
    private String urlPhoto;
    @Column(name = "con_status")
    private String status;
    @Column(name = "con_createat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createat;

}
