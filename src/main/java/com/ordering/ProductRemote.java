package com.ordering;

import java.util.List;

public interface ProductRemote {

     void addToCart(Product product);
     List<Product> ViewOrder();
     double checkout();

    
}
