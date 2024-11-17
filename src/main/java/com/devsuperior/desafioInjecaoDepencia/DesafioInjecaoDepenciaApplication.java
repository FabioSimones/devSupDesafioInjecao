package com.devsuperior.desafioInjecaoDepencia;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.desafioInjecaoDepencia.entities.Order;
import com.devsuperior.desafioInjecaoDepencia.services.OrderService;

@SpringBootApplication
public class DesafioInjecaoDepenciaApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;
	public static void main(String[] args) {
		SpringApplication.run(DesafioInjecaoDepenciaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dados do pedido: código, valor básico, porcentagem de desconto");
		int code = sc.nextInt();
		double basic = sc.nextDouble();
		double discount = sc.nextDouble();
		
		Order order = new Order(code, basic, discount);
		
		System.out.printf("Pedido código " + code);
		System.out.println();
		System.out.printf("Valor total: R$ %.2f", orderService.total(order));
		
		sc.close();
	}

}
