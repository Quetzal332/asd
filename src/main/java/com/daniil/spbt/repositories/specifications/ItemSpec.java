package com.daniil.spbt.repositories.specifications;

import com.daniil.spbt.entities.Item;
import org.springframework.data.jpa.domain.Specification;

public class ItemSpec {
    public static Specification<Item> nameContains(String word){
        return (Specification<Item>) (root,criteriaQuery,criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("name"),"%" + word + "%");
        };
    }
}
