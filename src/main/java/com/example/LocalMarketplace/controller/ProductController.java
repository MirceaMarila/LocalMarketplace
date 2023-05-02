package com.example.LocalMarketplace.controller;


import com.example.LocalMarketplace.dto.ProductDto;
import com.example.LocalMarketplace.mapper.ProductMapper;
import com.example.LocalMarketplace.model.Product;
import com.example.LocalMarketplace.repository.ProductRepository;
import com.example.LocalMarketplace.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Validated
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductController(ProductService productService, ProductMapper productMapper,
                             ProductRepository productRepository) {
        this.productService = productService;
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @PostMapping("/farmer/{farmerId}/add")
    public ResponseEntity<Product> saveNewProduct(@PathVariable Integer farmerId, @RequestBody @Valid ProductDto productDto) {
        Product product = productMapper.ProductDtoToProductMapper(productDto, farmerId);
        Product savedProduct = productService.saveNewProduct(product);

        return ResponseEntity.created(URI.create("/id/" + savedProduct.getId())).body(savedProduct);
    }

    @GetMapping("/farmer/{farmerId}/all")
    public ResponseEntity<ArrayList<Product>> findAllProductsByFarmerIf(@PathVariable Integer farmerId) {
        ArrayList<Product> products = productService.getAllProductsOfFarmer(farmerId);

        return ResponseEntity.ok().body(products);
    }

    @PostMapping("/update/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId, @RequestBody @Valid ProductDto productDto) {
        Product updatedProduct = productService.updateProduct(productId, productDto);

        return ResponseEntity.created(URI.create("/id/" + updatedProduct.getId())).body(updatedProduct);
    }

    @GetMapping("/{productName}/all")
    public ResponseEntity<ArrayList<Product>> findAllProductByName(@PathVariable String productName) {
        ArrayList<Product> products = productService.getAllProductsByName(productName);

        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/{productName}/all/currency/{currency}")
    public ResponseEntity<ArrayList<Product>> findAllProductByNameInCurrency(@PathVariable String productName, @PathVariable String currency) {
        ArrayList<Product> products = productService.getAllProductsByName(productName);
        for(Product product:products)
        {
            if(currency.equals("EUR"))
                product.setPrice(product.getPrice()/4.93);

            else if(currency.equals("USD"))
                product.setPrice(product.getPrice()/4.48);
        }
        return ResponseEntity.ok().body(products);
    }


    @GetMapping("/available/{available}")
    public ResponseEntity<ArrayList<Product>> findProductByAvailable(@PathVariable Integer available) {
        ArrayList<Product> products = productService.getAllProductsAvailable(available);

        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/available/{available}/currency/{currency}")
    public ResponseEntity<ArrayList<Product>> findProductByAvailableInCurrency(@PathVariable Integer available, @PathVariable String currency) {
        ArrayList<Product> products = productService.getAllProductsAvailable(available);
        for(Product product:products)
        {
            if(currency.equals("EUR"))
                product.setPrice(product.getPrice()/4.93);

            else if(currency.equals("USD"))
                product.setPrice(product.getPrice()/4.48);
        }
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/all")
    public ResponseEntity<ArrayList<Product>> findAllProduct() {
        ArrayList<Product> products = (ArrayList<Product>) productService.findAllProducts();

        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/all/currency/{currency}")
    public ResponseEntity<ArrayList<Product>> findAllProductInCurrency(@PathVariable String currency) {
        ArrayList<Product> products = (ArrayList<Product>) productService.findAllProducts();
        for(Product product:products)
        {
            if(currency.equals("EUR"))
                product.setPrice(product.getPrice()/4.93);

            else if(currency.equals("USD"))
                product.setPrice(product.getPrice()/4.48);
        }
        return ResponseEntity.ok().body(products);
    }

    /*@PostMapping("/cart/add/{productId}")
    public ResponseEntity<Product> saveProduct(@PathVariable Integer productId, @RequestBody @Valid ProductDto productDto) {
        Product product = productMapper.ProductDtoToProductMapper(productDto, productId);
        Product savedProduct = productService.saveProduct(product);

        return ResponseEntity.created(URI.create("/id/" + savedProduct.getId())).body(savedProduct);
    }*/

    @GetMapping("/all/category/{categoryName}")
    public ResponseEntity<ArrayList<Product>> findAllProductByCategory(@PathVariable String categoryName) {
        ArrayList<Product> products = productService.findAllProductsByCategory(categoryName);

        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/all/category/{categoryName}/currency/{currency}")
    public ResponseEntity<ArrayList<Product>> findAllProductByCategoryInCurrency(@PathVariable String categoryName, @PathVariable String currency) {
        ArrayList<Product> products = productService.findAllProductsByCategory(categoryName);
        for(Product product:products)
        {
            if(currency.equals("EUR"))
                product.setPrice(product.getPrice()/4.93);

            else if(currency.equals("USD"))
                product.setPrice(product.getPrice()/4.48);
        }
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/all/sorted/price/asc")
    public ResponseEntity<ArrayList<Product>> findAllProductByPriceSorted() {

        ArrayList<Product> products = (ArrayList<Product>) productService.findAllProducts();

        Collections.sort(products);

        return ResponseEntity.ok().body(products);

    }

    @GetMapping("/all/sorted/price/asc/currency/{currency}")
    public ResponseEntity<ArrayList<Product>> findAllProductByPriceSortedInCurrency(@PathVariable String currency) {

        ArrayList<Product> products = (ArrayList<Product>) productService.findAllProducts();

        for(Product product:products)
        {
            if(currency.equals("EUR"))
                product.setPrice(product.getPrice()/4.93);

            else if(currency.equals("USD"))
                product.setPrice(product.getPrice()/4.48);
        }

        Collections.sort(products);


        return ResponseEntity.ok().body(products);

    }

    @GetMapping("/all/sorted/price/desc")
    public ResponseEntity<ArrayList<Product>> findAllProductByPriceSortedDesc() {

        ArrayList<Product> products = (ArrayList<Product>) productService.findAllProducts();

        Collections.sort(products, Collections.reverseOrder());

        return ResponseEntity.ok().body(products);

    }

    @GetMapping("/all/sorted/price/desc/currency/{currency}")
    public ResponseEntity<ArrayList<Product>> findAllProductByPriceSortedDescInCurrency(@PathVariable String currency) {

        ArrayList<Product> products = (ArrayList<Product>) productService.findAllProducts();
        for(Product product:products)
        {
            if(currency.equals("EUR"))
                product.setPrice(product.getPrice()/4.93);

            else if(currency.equals("USD"))
                product.setPrice(product.getPrice()/4.48);
        }
        Collections.sort(products, Collections.reverseOrder());

        return ResponseEntity.ok().body(products);

    }

    @GetMapping("/all/sorted/name/asc")
    public ResponseEntity<ArrayList<Product>> findAllProductByNameSorted() {

        ArrayList<Product> products = (ArrayList<Product>) productService.findAllProducts();

        Comparator<Product> compareByName = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Collections.sort(products, compareByName);

        return ResponseEntity.ok().body(products);

    }

    @GetMapping("/all/sorted/name/asc/currency/{currency}")
    public ResponseEntity<ArrayList<Product>> findAllProductByNameSortedInCurrency(@PathVariable String currency) {

        ArrayList<Product> products = (ArrayList<Product>) productService.findAllProducts();

        for(Product product:products)
        {
            if(currency.equals("EUR"))
                product.setPrice(product.getPrice()/4.93);

            else if(currency.equals("USD"))
                product.setPrice(product.getPrice()/4.48);
        }
        Comparator<Product> compareByName = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Collections.sort(products, compareByName);

        return ResponseEntity.ok().body(products);

    }

    @GetMapping("/all/sorted/name/desc")
    public ResponseEntity<ArrayList<Product>> findAllProductByNameSortedDesc() {

        ArrayList<Product> products = (ArrayList<Product>) productService.findAllProducts();

        Comparator<Product> compareByName = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Collections.sort(products, Collections.reverseOrder(compareByName));

        return ResponseEntity.ok().body(products);

    }

    @GetMapping("/all/sorted/name/desc/currency/{currency}")
    public ResponseEntity<ArrayList<Product>> findAllProductByNameSortedDescInCurrency(@PathVariable String currency) {

        ArrayList<Product> products = (ArrayList<Product>) productService.findAllProducts();
        for(Product product:products)
        {
            if(currency.equals("EUR"))
                product.setPrice(product.getPrice()/4.93);

            else if(currency.equals("USD"))
                product.setPrice(product.getPrice()/4.48);
        }
        Comparator<Product> compareByName = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Collections.sort(products, Collections.reverseOrder(compareByName));

        return ResponseEntity.ok().body(products);

    }

}
