package com.leprechauns.main.Repository;

import java.util.List;

import org.antlr.v4.runtime.atn.SemanticContext.AND;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leprechauns.main.Entity.Office;
import com.leprechauns.main.Entity.DTO.OfficeDTO;

@Repository
public interface OfficeRepository extends JpaRepository<Office, String> {

    @Query("SELECT o.officeCode, o.city FROM Office o")
    List<Object[]> findOfficeCodeAndCity();

    @Query("SELECT o.phone, o.city FROM Office o WHERE o.country='España'")
    List<Object[]> findOfficeSpain();

    @Query("SELECT CONCAT(o.addressLine1, ' ', o.addressLine2) AS office_address" 
            + "FROM Office o JOIN employee e ON o.officeCode = e.codigo_oficina" 
            + "JOIN customer c ON e.codigo_empleado = c.codigo_empleado_rep_ventas"
            + "WHERE c.ciudad = 'Fuenlabrada'")
    List<Object[]> findOfficeAddress();

    // @Query("SELECT DISTINCT o.codigo_oficina"
    //         + "FROM oficina o"
    //         + "LEFT JOIN empleado e ON o.codigo_oficina = e.codigo_oficina"
    //         + "LEFT JOIN cliente c ON e.codigo_empleado = c.codigo_empleado_rep_ventas"
    //         + "LEFT JOIN pedido p ON c.codigo_cliente = p.codigo_cliente"
    //         + "LEFT JOIN detalle_pedido d ON p.codigo_pedido = d.codigo_pedido"
    //         + "LEFT JOIN producto pr ON d.codigo_producto = pr.codigo_producto"
    //         + "WHERE pr.gama = 'Frutales' AND c.codigo_empleado_rep_ventas IS NOT NULL AND e.codigo_empleado IS NOT NULL AND c.codigo_cliente IS NOT NULL AND p.codigo_pedido IS NOT NULL AND d.codigo_pedido IS NOT NULL AND pr.codigo_producto IS NOT NULL AND o.codigo_oficina IS NOT NULL")
    // List<Object[]> findOfficeEmployeeDontWorkEachProductFrutal();
}