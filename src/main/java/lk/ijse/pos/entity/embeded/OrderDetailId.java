package lk.ijse.pos.entity.embeded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class OrderDetailId implements Serializable {
    @Column(name = "orderId", length = 6)
    private String orderId;

    @Column(name = "itemCode", length = 6)
    private String itemCode;
}
