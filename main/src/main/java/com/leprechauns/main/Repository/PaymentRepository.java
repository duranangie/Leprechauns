package com.leprechauns.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leprechauns.main.Entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

//     @Query("SELECT DISTINCT codigo_cliente FROM pago WHERE EXTRACT(YEAR FROM fecha_pago) = 2008")

//     @Query("SELECT * FROM pago WHERE EXTRACT(YEAR FROM fecha_pago) = 2008 AND forma_pago = 'PayPal' ORDER BY fecha_pago DESC;")

//     @Query("SELECT DISTINCT forma_pago FROM pago")

//     @Query("SELECT DISTINCT c.nombre_cliente as Cliente_que_pagó, CONCAT(e.nombre, ' ', e.apellido1, ' ', e.apellido2) AS Nombre_representante_de_ventas "  
//             + "FROM pago p "
//             + "JOIN cliente c ON p.codigo_cliente = c.codigo_cliente " 
//             + "JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado")

//     @Query("SELECT DISTINCT c.nombre_cliente AS Cliente_que_pagó, CONCAT(e.nombre, ' ', e.apellido1, ' ', e.apellido2) AS Nombre_representante_de_ventas, o.ciudad as Oficina" 
//             + "FROM pago p "
//             + "JOIN cliente c ON p.codigo_cliente = c.codigo_cliente " 
//             + "JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado"
//             + "JOIN oficina o ON e.codigo_oficina = o.codigo_oficina")

//     @Query("SELECT ROUND(AVG(total), 2) AS pago_medio FROM pago WHERE EXTRACT(YEAR FROM fecha_pago) = 2009")

//     @Query("SELECT EXTRACT(YEAR FROM fecha_pago) AS año, SUM(total) AS total_pagos FROM pago GROUP BY EXTRACT(YEAR FROM fecha_pago)")
}