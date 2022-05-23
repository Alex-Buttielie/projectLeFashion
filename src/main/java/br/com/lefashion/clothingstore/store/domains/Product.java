package br.com.lefashion.clothingstore.store.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tb_product")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long idProduct;
    @Basic
    @Column(name = "identification_product_code")
    private Integer identificationProductCode;
    @Basic
    @Column(name = "product_name")
    private String ProductName;
    @Basic
    @Column(name = "cadastre_date")
    private Date  cadastreDate;
    @Basic
    @Column(name = "model")
    private Integer model;
    @Basic
    @Column(name = "size")
    private Integer size;
    @Basic
    @Column(name = "is_accepts_discount")
    private Boolean isAcceptsDiscount;
    @Basic
    @Column(name = "is_accepts_exchange")
    private Boolean isAcceptsExchange;
    @Basic
    @Column(name = "price_cost")
    private Integer priceCost;
    @OneToOne
    @JoinColumn(nullable = true, unique = false)
    @JsonFormat
    private Brand brand;
    @OneToOne
    @JoinColumn(nullable = true, unique = false)
    @JsonFormat
    private Stock stock;


}
