package lk.ijse.pos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "unitPrice", nullable = false)
    private double unitPrice;
    @Column(name = "qtyOnHand", nullable = false)
    private int qtyOnHand;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ItemCategory category;

    @JsonIgnore
    @ManyToMany(
            mappedBy = "items"
    )
    private Set<Orders> orders = new HashSet<>();
}
