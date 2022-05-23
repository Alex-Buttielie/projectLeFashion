package br.com.lefashion.clothingstore.store.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tb_user")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;
    @Basic
    @Column(name = "ds_login")
    private String dsLogin;
    @Basic
    @Column(name = "name_user")
    private String nameUser;
    @Basic
    @Column(name = "password_user")
    private String passwordUser;
    @Basic
    @Column(name = "cpf")
    private String cpf;
    @Basic
    @Column(name = "rg")
    private String rg;
    @Basic
    @Column(name = "birth_date")
    private Date birthDate;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "telephone")
    private String telephone;
    @Basic
    @Column(name = "telephone2")
    private String telephone2;
    @Basic
    @Column(name = "cadastre_date")
    private String cadastreDate;
    @Basic
    @Column(name = "sex")
    private Number sex;
    @Basic
    @Column(name = "user_typer")
    private Number userTyper;

}
