package com.example.ms_order.mappers;

import com.example.ms_order.dto.ProductDtoRs;
import com.example.ms_order.entities.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-05T02:04:23+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class ProductMapperRsImpl implements ProductMapperRs {

    @Override
    public Product toEntity(ProductDtoRs productDtoRs) {
        if ( productDtoRs == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDtoRs.getId() );
        product.setModel( productDtoRs.getModel() );
        product.setQte( productDtoRs.getQte() );
        product.setPrice( productDtoRs.getPrice() );
        product.setStatus( productDtoRs.getStatus() );

        return product;
    }

    @Override
    public ProductDtoRs toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDtoRs.ProductDtoRsBuilder productDtoRs = ProductDtoRs.builder();

        productDtoRs.id( product.getId() );
        productDtoRs.model( product.getModel() );
        productDtoRs.price( product.getPrice() );
        productDtoRs.qte( product.getQte() );
        productDtoRs.status( product.getStatus() );

        return productDtoRs.build();
    }

    @Override
    public Product partialUpdate(ProductDtoRs productDtoRs, Product product) {
        if ( productDtoRs == null ) {
            return product;
        }

        if ( productDtoRs.getId() != null ) {
            product.setId( productDtoRs.getId() );
        }
        if ( productDtoRs.getModel() != null ) {
            product.setModel( productDtoRs.getModel() );
        }
        if ( productDtoRs.getQte() != null ) {
            product.setQte( productDtoRs.getQte() );
        }
        if ( productDtoRs.getPrice() != null ) {
            product.setPrice( productDtoRs.getPrice() );
        }
        if ( productDtoRs.getStatus() != null ) {
            product.setStatus( productDtoRs.getStatus() );
        }

        return product;
    }
}
