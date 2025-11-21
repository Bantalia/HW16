package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductBasket {
            private List<Product> products = new ArrayList<>();

        public void addProduct(Product product) {
            products.add(product);
        }

        public void printReceipt() {
            int totalPrice = 0;
            int specialCount = 0;

            for (Product p : products) {
                System.out.println(p.toString());
                totalPrice += p.getPrice();
                if (p.isSpecial()) {
                    specialCount++;
                }
            }

            System.out.println("Итого: " + totalPrice);
            System.out.println("Специальных товаров: " + specialCount);
        }




    }

