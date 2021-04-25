package com.daniil.spbt.controllers;

import com.daniil.spbt.entities.Item;
import com.daniil.spbt.repositories.ItemRep;

import com.daniil.spbt.services.ItemServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/items")
public class ItemContr {
    @Autowired
    public void setItemServ(ItemServ itemServ) {
        this.itemServ = itemServ;
    }

    ItemServ itemServ;
    @GetMapping
    public String shop(Model model) {
        Specification<Item> specification = Specification.where(null);

        List<Item> items = itemServ.getAllItems(specification, PageRequest.of(0,100)).getContent();
        model.addAttribute("items",items);
        return "items";

    }
    @GetMapping("/{id}")
    @ResponseBody
    public Item itemById(@PathVariable("id") Long id){

        return itemServ.getById(id);
    }
}
