package com.daniil.spbt.services;

import com.daniil.spbt.entities.Item;
import com.daniil.spbt.repositories.ItemRep;
import com.daniil.spbt.repositories.specifications.ItemSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServ {
    private ItemRep itemRep;

    @Autowired
    public void setItemRep(ItemRep itemRep) {
        this.itemRep = itemRep;
    }

    public Page<Item> getAllItems(Specification<Item> itemSpec, Pageable pageable){
       return itemRep.findAll(itemSpec,pageable);
    }
    public Item getById(Long id){
        return itemRep.findById(id).orElse(null);
    }
    public List<Item> fin(int min, int max){
        return itemRep.findByCoastBetween(min,max);
    }
}
