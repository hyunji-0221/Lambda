package product;


import common.UtilService;
import common.UtilServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ProductView {
    public static void main(String[] args) {

        UtilService util = UtilServiceImpl.getInstance();
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            productList.add(Product.builder()
                    .pno(util.createRandomInteger(0, 10))
                    .name(util.createRandomName())
                    .company(util.createRandomCompany())
                    .price(util.createRandomInteger(5000, 10000))
                    .build());
        }

        Stream<Product> stream = productList.stream();
        stream.forEach( p -> {
            System.out.println(p);
        });

    }
}
