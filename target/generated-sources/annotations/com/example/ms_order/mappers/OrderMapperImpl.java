package com.example.ms_order.mappers;

import com.example.ms_order.dto.OrderDto;
import com.example.ms_order.entities.Order;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-05T02:04:23+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toEntity(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        Order order = new Order();

        order.setRef( orderDto.getRef() );
        order.setDate( orderDto.getDate() );
        order.setClientFirstName( orderDto.getClientFirstName() );
        order.setClientLastName( orderDto.getClientLastName() );
        order.setAddress( orderDto.getAddress() );
        order.setProductId( orderDto.getProductId() );
        order.setProductQte( orderDto.getProductQte() );

        return order;
    }

    @Override
    public OrderDto toDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDto.OrderDtoBuilder orderDto = OrderDto.builder();

        orderDto.ref( order.getRef() );
        orderDto.date( order.getDate() );
        orderDto.clientFirstName( order.getClientFirstName() );
        orderDto.clientLastName( order.getClientLastName() );
        orderDto.address( order.getAddress() );
        orderDto.productId( order.getProductId() );
        orderDto.productQte( order.getProductQte() );

        return orderDto.build();
    }

    @Override
    public Order partialUpdate(OrderDto orderDto, Order order) {
        if ( orderDto == null ) {
            return order;
        }

        if ( orderDto.getRef() != null ) {
            order.setRef( orderDto.getRef() );
        }
        if ( orderDto.getDate() != null ) {
            order.setDate( orderDto.getDate() );
        }
        if ( orderDto.getClientFirstName() != null ) {
            order.setClientFirstName( orderDto.getClientFirstName() );
        }
        if ( orderDto.getClientLastName() != null ) {
            order.setClientLastName( orderDto.getClientLastName() );
        }
        if ( orderDto.getAddress() != null ) {
            order.setAddress( orderDto.getAddress() );
        }
        if ( orderDto.getProductId() != null ) {
            order.setProductId( orderDto.getProductId() );
        }
        if ( orderDto.getProductQte() != null ) {
            order.setProductQte( orderDto.getProductQte() );
        }

        return order;
    }
}
