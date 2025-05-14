package com.edstem.event_driven_programming.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "notifications")
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long userId;
	private String type;
	private String message;
	private boolean isRead;
	private LocalDateTime createdAt;

	public Notification(Long userId, String type, String message) {
		this.userId = userId;
		this.type = type;
		this.message = message;
		this.isRead = false;
		this.createdAt = LocalDateTime.now();
	}
}
