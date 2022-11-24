package org.makovoz;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
public class Product {
    private Long id;
    private String name;
    private String category;
    private Double price;
    private Set<Order> orders;
}
