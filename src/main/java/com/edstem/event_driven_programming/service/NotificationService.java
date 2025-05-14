package com.edstem.event_driven_programming.service;

import com.edstem.event_driven_programming.model.Notification;
import com.edstem.event_driven_programming.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
	private final NotificationRepository repository;

	public NotificationService(NotificationRepository repository) {
		this.repository = repository;
	}

	public List<Notification> getNotifications(Long userId) {
		return repository.findByUserId(userId);
	}
}
