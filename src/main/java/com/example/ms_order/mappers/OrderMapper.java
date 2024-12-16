package com.example.ms_order.mappers;

import com.example.ms_order.dto.OrderDto;
import com.example.ms_order.entities.Order;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {
    Order toEntity(OrderDto orderDto);

    @AfterMapping
    default void linkProducts(@MappingTarget Order order) {
        order.getProducts().forEach(product -> product.setOrder(order));
    }

    OrderDto toDto(Order order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order partialUpdate(OrderDto orderDto, @MappingTarget Order order);
}