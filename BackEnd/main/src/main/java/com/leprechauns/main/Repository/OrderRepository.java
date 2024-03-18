package com.leprechauns.main.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leprechauns.main.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT DISTINCT o.status FROM Order o")
    List<String> getOrderStatus();

    @Query("SELECT o.orderCode, o.expectedDate, o.deliverDate FROM Order o WHERE o.expectedDate < o.deliverDate")
    List<Object> findOrdersByExpectedDeliveryBeforeActual();

    @Query(value = "SELECT o.codigo_pedido, o.codigo_cliente, o.fecha_esperada, o.fecha_entrega FROM pedido o WHERE o.fecha_entrega <= DATE_SUB(o.fecha_esperada, INTERVAL 2 DAY)", nativeQuery = true)
    List<Object[]> findDay();

    @Query("SELECT o.orderCode, o.orderDate "
            + "FROM Order o "
            + "WHERE o.status = 'Rechazado' AND FUNCTION('YEAR', o.orderDate) = :year")
    List<Object[]> findOrders(int year);

    @Query("SELECT o.orderCode, o.orderDate, o.deliverDate, o.status FROM Order o WHERE EXTRACT(MONTH FROM o.deliverDate) = 1 AND o.status = :deadline")
    List<Object> findOrdersInJanuary(String deadline);

    @Query("SELECT COUNT(o) AS orderCount, o.status " +
            "FROM Order o " +
            "GROUP BY o.status " +
            "ORDER BY orderCount DESC")
    List<Object[]> countByEstado();
}