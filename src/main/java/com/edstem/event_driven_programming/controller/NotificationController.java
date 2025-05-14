package com.edstem.event_driven_programming.controller;

import com.edstem.event_driven_programming.event.OrderPlacedEvent;
import com.edstem.event_driven_programming.event.ProductOutOfStockEvent;
import com.edstem.event_driven_programming.event.UserRegisteredEvent;
import com.edstem.event_driven_programming.model.Notification;
import com.edstem.event_driven_programming.service.NotificationService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

	private final NotificationService notificationService;

	private final ApplicationEventPublisher applicationEventPublisher;

	public NotificationController(NotificationService notificationService, ApplicationEventPublisher applicationEventPublisher) {
		this.notificationService = notificationService;
		this.applicationEventPublisher = applicationEventPublisher;
	}

	@GetMapping("/{userId}")
	public List<Notification> getNotifications(@PathVariable Long userId) {
		return notificationService.getNotifications(userId);
	}

	@PostMapping("/test/userRegistered")
	public String userRegistered(@RequestParam Long userId, @RequestParam String userName) {
		applicationEventPublisher.publishEvent(new UserRegisteredEvent(userId, userName));
		return "UserRegisteredEvent triggered";
	}

	@PostMapping("/test/orderPlaced")
	public String orderPlaced(@RequestParam Long userId, @RequestParam String details) {
		applicationEventPublisher.publishEvent(new OrderPlacedEvent(userId, details));
		return "OrderPlacedEvent triggered";
	}

	@PostMapping("/test/outOfStock")
	public String outOfStock(@RequestParam Long userId, @RequestParam String productName) {
		applicationEventPublisher.publishEvent(new ProductOutOfStockEvent(userId, productName));
		return "ProductOutOfStockEvent triggered";
	}
}
