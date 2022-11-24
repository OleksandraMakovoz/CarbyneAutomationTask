package org.makovoz;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> products = List.of(
                Product.builder()
                        .id(1L)
                        .category("Book")
                        .price(123.00)
                        .build(),
                Product.builder()
                        .id(2L)
                        .category("NoteBook")
                        .price(101.00)
                        .build(),
                Product.builder()
                        .id(3L)
                        .category("Book")
                        .price(100.00)
                        .build(),
                Product.builder()
                        .id(4L)
                        .category("Book")
                        .price(500.00)
                        .build()
        );
        List<Product> filteredProducts = filterProducts(products);

        filteredProducts.stream()
                .map(Product::getId)
                .forEach(System.out::println);

        String[] arr = new String[] {"cat", "dog", "red", "is", "am"};
        String[] arr1 = new String[] {"catCAT", "dogy", "red", "is", "am"};
        System.out.println(Arrays.toString(longestStrings(arr)));
        System.out.println(Arrays.toString(longestStrings(arr1)));
    }


    public static List<Product> filterProducts(List<Product> products) {
        return products.stream()
                .filter(product -> product.getCategory().equals("Book") && product.getPrice() > 100.00).toList();
    }

    public static String[] longestStrings(String[] arr) {
        int max = 0;
        for (String str : arr) {
            max = Math.max(max, str.length());
        }
        int finMax = max;
        return Arrays.stream(arr)
                .filter(str -> str.length() == finMax)
                .toArray(String[]::new);
    }
}
