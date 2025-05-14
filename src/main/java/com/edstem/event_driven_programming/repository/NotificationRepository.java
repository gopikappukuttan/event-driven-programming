package com.edstem.event_driven_programming.repository;

import com.edstem.event_driven_programming.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
	List<Notification>findByUserId(Long userId);
}
