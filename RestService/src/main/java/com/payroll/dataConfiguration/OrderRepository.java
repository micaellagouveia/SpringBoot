package com.payroll.dataConfiguration;

import com.payroll.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Order, Long> {
}
