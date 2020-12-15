package com.inkombizz.web.service.impl;

import com.inkombizz.web.dto.ProductAddRequest;
import com.inkombizz.web.exception.DataIsEmptyException;
import com.inkombizz.web.model.Product;
import com.inkombizz.web.repository.ProductRepository;
import com.inkombizz.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        List<Product> products = productRepository.findAllProduct();
        if (products.isEmpty()){
            throw new DataIsEmptyException();
        }
        return products;
    }

    @Override
    public void addOrUpdateProduct(ProductAddRequest productAddRequest) {
        if (productAddRequest.getIdProduct() == null){
            Product product = new Product();
            product.setName(productAddRequest.getProductName());
            product.setPrice(new BigDecimal(productAddRequest.getProductPrice()));
            product.setExpireDate(productAddRequest.getProductExpire());
            productRepository.save(product);
        } else {
//            Product currentProduct = productRepository.findOne(productAddRequest.getIdProduct());
//            currentProduct.setName(productAddRequest.getProductName());
//            currentProduct.setPrice(new BigDecimal(productAddRequest.getProductPrice()));
//            currentProduct.setExpireDate(productAddRequest.getProductExpire());
//            productRepository.save(currentProduct);
        }

    }

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
}
