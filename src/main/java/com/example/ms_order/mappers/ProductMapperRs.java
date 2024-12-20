package com.example.ms_order.mappers;

import com.example.ms_order.dto.ProductDtoRs;
import com.example.ms_order.entities.Product;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapperRs {
    Product toEntity(ProductDtoRs productDtoRs);

    ProductDtoRs toDto(Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product partialUpdate(ProductDtoRs productDtoRs, @MappingTarget Product product);
}