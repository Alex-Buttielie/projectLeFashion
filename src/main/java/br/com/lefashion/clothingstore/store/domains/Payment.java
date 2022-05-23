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
import java.sql.Time;
import java.util.Date;

@Table(name = "tb_payment")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private Long idPayment;
    @Basic
    @Column(name = "type_payment")
    private Number typePayment;
    @Basic
    @Column(name = "value_change")
    private Number valueChange;
    @Basic
    @Column(name = "value_entry")
    private Number valueEntry;
    @OneToOne
    @JoinColumn(name = "fk_id_sale", referencedColumnName = "id_sale", nullable = true, unique = false)
    @JsonFormat
    private Sale sale;
}
