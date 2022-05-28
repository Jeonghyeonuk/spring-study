package com.sprata.springcore.service;

import com.sprata.springcore.model.Product;
import com.sprata.springcore.dto.ProductMypriceRequestDto;
import com.sprata.springcore.repository.ProductRepository;
import com.sprata.springcore.dto.ProductRequestDto;
import com.sprata.springcore.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service //bean으로 등록한
public class ProductService {
    private final ProductRepository productRepository;


    @Autowired //등록된 bean을 꺼내올때 사용한다
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public Product creatProduct(ProductRequestDto requestDto, Long userId){
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Product product = new Product(requestDto, userId);
        productRepository.save(product);

        return product;
    }

    public Product updateProcduct(Long id, ProductMypriceRequestDto requestDto){
//        if (requestDto.getMyprice() <=0){
//            throw new RuntimeException("최저가를 0원 이상으로 설정해주세요");
//
//        }
        Product product = productRepository.findById(id).orElseThrow(()-> new NullPointerException("해당 아이디가 존재하지 않습니다."));

        int myprice = requestDto.getMyprice();
        product.setMyprice(myprice);
        productRepository.save(product);
        return product;
    }

    public List<Product> getProducts(Long userId){
        return productRepository.findAllByUserId(userId);

    }

    //관리자용 상품 전체조회
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}


