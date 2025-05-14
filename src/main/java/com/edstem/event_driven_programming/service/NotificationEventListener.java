package com.edstem.event_driven_programming.service;

import com.edstem.event_driven_programming.event.OrderPlacedEvent;
import com.edstem.event_driven_programming.event.ProductOutOfStockEvent;
import com.edstem.event_driven_programming.event.UserRegisteredEvent;
import com.edstem.event_driven_programming.model.Notification;
import com.edstem.event_driven_programming.repository.NotificationRepository;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class NotificationEventListener {

	private final NotificationRepository repository;

	public NotificationEventListener(NotificationRepository repository) {
		this.repository = repository;
	}


	@Async
	@EventListener
	public void handleUserRegistered(UserRegisteredEvent event) {
		repository.save(new Notification(
				event.getUserId(),
				"User Registration",
				"Welcome, " + event.getUserName() + "! Your account has been created."
		));
	}

	@Async
	@EventListener
	public void handleOrderPlaced(OrderPlacedEvent event) {
		repository.save(new Notification(
				event.getUserId(),
				"Order Placed",
				"Your order has been placed: " + event.getOrderDetails()
		));
	}

	@Async
	@EventListener
	public void handleProductOutOfStock(ProductOutOfStockEvent event) {
		repository.save(new Notification(
				event.getUserId(),
				"Product Out of Stock",
				"Sorry, " + event.getProductName() + " is out of stock."
		));
	}

}
