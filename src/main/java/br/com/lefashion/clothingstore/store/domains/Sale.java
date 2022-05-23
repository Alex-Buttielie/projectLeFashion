package br.com.lefashion.clothingstore.store.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;

@Table(name = "tb_sale")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sale")
    private Long idSale;
    @Basic
    @Column(name = "sale_date")
    private Date saleDate;
    @Basic
    @Column(name = "sale_time")
    private Time saleTime;
    @Basic
    @Column(name = "value_sale")
    private Number valueSale;
    @OneToOne
    @JoinColumn(name = "fk_id_user", referencedColumnName = "id_user",  nullable = false, unique = false)
    @JsonFormat
    private User user;
    @OneToMany(mappedBy = "idItemsSold", cascade = CascadeType.ALL)
    private Collection<ItemsSold> itemsSolds;

}
