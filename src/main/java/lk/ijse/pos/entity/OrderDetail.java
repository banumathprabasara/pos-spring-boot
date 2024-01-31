package lk.ijse.pos.entity;

import jakarta.persistence.*;

import lk.ijse.pos.entity.embeded.OrderDetailId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Entity
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId id;

    @ManyToOne
    @MapsId("itemCode")
    @JoinColumn(name = "itemCode",nullable = false)
    private Item item;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "orderId",nullable = false)
    private Orders orders;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "unitPrice", precision = 8, scale = 2)
    private BigDecimal unitPrice;
}
