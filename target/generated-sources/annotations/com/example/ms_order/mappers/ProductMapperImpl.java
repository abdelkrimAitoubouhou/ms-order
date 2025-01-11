package com.example.ms_order.mappers;

import com.example.ms_order.dto.ProductDto;
import com.example.ms_order.entities.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-05T02:04:23+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntity(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDto.getId() );
        product.setModel( productDto.getModel() );
        product.setQte( productDto.getQte() );
        product.setPrice( productDto.getPrice() );
        product.setStatus( productDto.getStatus() );

        return product;
    }

    @Override
    public ProductDto toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setModel( product.getModel() );
        productDto.setQte( product.getQte() );
        productDto.setPrice( product.getPrice() );
        productDto.setStatus( product.getStatus() );

        return productDto;
    }

    @Override
    public Product partialUpdate(ProductDto productDto, Product product) {
        if ( productDto == null ) {
            return product;
        }

        if ( productDto.getId() != null ) {
            product.setId( productDto.getId() );
        }
        if ( productDto.getModel() != null ) {
            product.setModel( productDto.getModel() );
        }
        if ( productDto.getQte() != null ) {
            product.setQte( productDto.getQte() );
        }
        if ( productDto.getPrice() != null ) {
            product.setPrice( productDto.getPrice() );
        }
        if ( productDto.getStatus() != null ) {
            product.setStatus( productDto.getStatus() );
        }

        return product;
    }
}
