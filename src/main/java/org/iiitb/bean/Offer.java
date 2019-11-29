package org.iiitb.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String organisation;
    private Character min_grade;
    private Integer max_intake;
    private String domainName;
    private String specsName;
    @JsonIgnore
    @ManyToMany(cascade=CascadeType.ALL)
    private List<Specialisation> specialisation = new ArrayList();
    @JsonIgnore
    @ManyToMany(cascade=CascadeType.ALL)
    private List<Domain> domain = new ArrayList();
    //private String jd_url;
    public Integer getId() {
        return id;
    }
    public String getOrganisation(){ return organisation;}
    public void setOrganisation(String organisation){
        this.organisation = organisation;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Character getMin_grade() {
        return min_grade;
    }
    public void setMin_grade(Character min_grade) {
        this.min_grade = min_grade;
    }
    public Integer getMax_intake() {
        return max_intake;
    }
    public void setMax_intake(Integer max_intake) {
        this.max_intake = max_intake;
    }
    public List<Specialisation> getSpecialisation() {
        return specialisation;
    }
    public void setSpecialisation(List<Specialisation> specialisation) {
        this.specialisation = specialisation;
    }
    public List<Domain> getDomain() {
        return domain;
    }
    public void setDomain(List<Domain> domain) {
        this.domain = domain;
    }
    public String getDomainName(int i){ return getDomain().get(i).getName();}
    public String getSpecialisationName(int i){ return getSpecialisation().get(i).getName();}
    public String getDomainName() {
        return domainName;
    }
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getSpecsName() {
        return specsName;
    }

    public void setSpecsName(String specsName) {
        this.specsName = specsName;
    }

    /*public String getJd_url() {
            return jd_url;
        }
        public void setJd_url(String jd_url) {
            this.jd_url = jd_url;
        }*/
    @Override
    public String toString() {
        return "Offer [id=" + id + ", min_grade=" + min_grade + ", max_intake=" + max_intake + ", specialisation="
                + specialisation + ", domian=" + domain +"]";
    }
}
