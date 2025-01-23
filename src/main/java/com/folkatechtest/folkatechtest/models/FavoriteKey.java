package com.folkatechtest.folkatechtest.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class FavoriteKey {
    @Column(name = "product_id")
    private int productId;

    @Column(name = "user_id")
    private int userId;
}
