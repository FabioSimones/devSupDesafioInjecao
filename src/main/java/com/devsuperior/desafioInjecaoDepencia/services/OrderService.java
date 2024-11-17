package com.devsuperior.desafioInjecaoDepencia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.desafioInjecaoDepencia.entities.Order;

@Service
public class OrderService {
	
	@Autowired
	private ShippingService shippingService;
	
	public double total(Order order) {
		double result = 0;
		
		if(order.getBasic() < 100.00) {
			result = (order.getBasic() - shippingService.shipment(order)) + 20.00;
		}
		if(order.getBasic() >= 100.00 && order.getBasic() <= 200.00) {
			result = (order.getBasic() - shippingService.shipment(order)) + 12.00;
		}
		if(order.getBasic() > 200.00)  {
			result = (order.getBasic() - shippingService.shipment(order));
		}
		
		return result;
	}
}
