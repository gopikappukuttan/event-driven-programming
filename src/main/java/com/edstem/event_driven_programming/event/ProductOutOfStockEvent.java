package com.edstem.event_driven_programming.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOutOfStockEvent {
	private  Long userId;
	private  String productName;

}
