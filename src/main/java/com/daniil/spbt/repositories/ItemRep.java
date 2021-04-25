package com.daniil.spbt.repositories;

import com.daniil.spbt.entities.Item;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ItemRep extends PagingAndSortingRepository<Item,Long>, JpaSpecificationExecutor<Item> {
    List<Item> findByCoastBetween(int min,int max);


}
