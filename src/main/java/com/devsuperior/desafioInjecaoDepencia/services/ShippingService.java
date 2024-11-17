package com.devsuperior.desafioInjecaoDepencia.services;

import org.springframework.stereotype.Service;

import com.devsuperior.desafioInjecaoDepencia.entities.Order;

@Service
public class ShippingService {
	public double shipment(Order order) {
		return (order.getBasic() * order.getDiscount()) / 100.0;
	}
}
