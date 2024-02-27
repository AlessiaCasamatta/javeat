package com.generation.javeat.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dish 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 
    private String name, category;
    private List<String> ingredients; //new ArrayList ??
    private double price; 

    @JsonIgnore
    @OneToMany(mappedBy = "dish", cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Set<DishToDelivery> deliveries;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    private Menu menu; 

    
}