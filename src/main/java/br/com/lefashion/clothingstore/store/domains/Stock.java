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

@Table(name = "tb_stock")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_stock")
    private Long idStock;
    @Basic
    @Column(name = "stock_start_date")
    private Date stockStartDate;
    @Basic
    @Column(name = "stock_end_date")
    private Date stockEndDate;
    @Basic
    @Column(name = "quantity_partys_stock")
    private Number quantityPartysStock;
    @Basic
    @Column(name = "reference_month")
    private Number referenceMonth;

}
