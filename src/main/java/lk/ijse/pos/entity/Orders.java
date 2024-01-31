package lk.ijse.pos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Long orderId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="date")
    private LocalDateTime date;

    @Column(name = "qty")
    private Integer qty;

    @Column(nullable = false)
    private Double total;

    @ManyToOne
    @JoinColumn(name = "customerId",nullable = false)
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "order_item",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Item> items =new HashSet<>();
}
