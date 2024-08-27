package com.example.astrologyapp.model;

import com.example.astrologyapp.model.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table
@Entity(name = "products")
public class Product extends BaseEntity {
}
