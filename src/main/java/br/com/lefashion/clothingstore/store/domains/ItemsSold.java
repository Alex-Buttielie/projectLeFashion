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
import java.util.Collection;

@Table(name = "tb_items_sold")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ItemsSold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_items_sold")
    private Long idItemsSold;
    @OneToOne
    @JsonFormat
    @JoinColumn(name = "fk_id_product", columnDefinition = "id_product", nullable = false)
    private Product product;
    @ManyToOne
    @JoinColumn(name = "fk_id_sale", referencedColumnName = "id_sale", nullable = false)
    private Sale sale;
}
