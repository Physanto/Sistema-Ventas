-- NIVEL FÁCIL

-- Catálogo de productos disponibles
-- Lista todos los productos con su precio y stock actual
SELECT nombre, precio_venta, stock_actual, stock_minimo, ubicacion
FROM producto
ORDER BY nombre;

-- Directorio de clientes registrados
-- Muestra nombre completo, email y barrio de cada cliente
SELECT nombre, apellido, email, barrio
FROM cliente
ORDER BY apellido;

-- Productos con stock bajo mínimo
-- Identifica productos que requieren reabastecimiento urgente
SELECT nombre, stock_actual, stock_minimo, ubicacion
FROM producto
WHERE stock_actual <= stock_minimo
ORDER BY stock_actual;

-- Ventas registradas por método de pago
-- Historial de transacciones indicando cómo pagó cada cliente
SELECT id_venta, fecha, total_venta, metodo_pago
FROM venta
ORDER BY fecha DESC;


-- Productos próximos a vencer
-- Alerta de productos que vencen en los próximos 6 meses
SELECT nombre, fecha_vencimiento, stock_actual, ubicacion
FROM producto
WHERE fecha_vencimiento <= DATE_ADD(CURDATE(), INTERVAL 6 MONTH)
ORDER BY fecha_vencimiento;



-- NIVEL MEDIO

-- Ventas por cliente con datos de contacto
-- Une clientes y ventas para ver el historial de compras de cada persona
SELECT c.nombre, c.apellido, c.email,
       v.fecha, v.total_venta, v.metodo_pago
FROM cliente c
JOIN venta v ON c.id_cliente = v.id_cliente
ORDER BY c.apellido, v.fecha DESC;


-- Productos más vendidos por unidades
-- Ranking de productos según la cantidad total despachada
SELECT p.nombre, SUM(dv.cantidad) AS total_vendido,
       SUM(dv.cantidad * dv.precio_venta) AS ingresos_generados
FROM producto p
JOIN detalle_venta dv ON p.id_producto = dv.id_producto
GROUP BY p.id_producto, p.nombre
ORDER BY total_vendido DESC;

-- Compras realizadas a cada proveedor
-- Asocia cada factura de compra con el proveedor que la surtió
SELECT pr.nombre, pr.apellido, pr.email,
       c.numero_factura, c.fecha_compra, c.total
FROM proveedor pr
JOIN compra c ON pr.id_proveedor = c.id_proveedor
ORDER BY c.fecha_compra DESC;


-- Ingresos totales agrupados por categoría
-- Cuánto dinero ha generado cada línea de productos
SELECT cat.nombre AS categoria,
       SUM(dv.cantidad * dv.precio_venta) AS total_ingresos,
       COUNT(dv.id_detalle_venta) AS transacciones
FROM categoria cat
JOIN producto p ON cat.id_categoria = p.id_categoria
JOIN detalle_venta dv ON p.id_producto = dv.id_producto
GROUP BY cat.id_categoria, cat.nombre
ORDER BY total_ingresos DESC;


-- Resumen mensual de ventas
-- Total recaudado y número de ventas agrupados por mes
SELECT DATE_FORMAT(fecha, '%Y-%m') AS mes,
       COUNT(*) AS num_ventas,
       SUM(total_venta) AS total_recaudado,
       AVG(total_venta) AS promedio_venta
FROM venta
GROUP BY DATE_FORMAT(fecha, '%Y-%m')
ORDER BY mes DESC;



-- NIVEL COMPLEJO

-- Margen de ganancia por producto
-- Resta el costo de compra al precio de venta para ver cuánto gana cada producto
SELECT p.nombre,
       dc.precio_base        AS costo_compra,
       p.precio_venta,
       p.precio_venta - dc.precio_base AS ganancia
FROM producto p
JOIN detalle_compra dc ON p.id_producto = dc.id_producto
ORDER BY ganancia DESC;

-- Clientes con más de una compra
-- Muestra cuántas veces ha comprado cada cliente y cuánto ha gastado en total
SELECT c.nombre, c.apellido,
       COUNT(v.id_venta)  AS num_compras,
       SUM(v.total_venta) AS total_gastado
FROM cliente c
JOIN venta v ON c.id_cliente = v.id_cliente
GROUP BY c.id_cliente, c.nombre, c.apellido
HAVING COUNT(v.id_venta) > 1
ORDER BY total_gastado DESC;

-- Unidades compradas vs vendidas por producto
-- Compara cuánto entró al inventario contra cuánto salió por ventas
SELECT p.nombre,
       SUM(dc.cantidad) AS unidades_compradas,
       SUM(dv.cantidad) AS unidades_vendidas,
       p.stock_actual
FROM producto p
JOIN detalle_compra dc ON p.id_producto = dc.id_producto
JOIN detalle_venta dv  ON p.id_producto = dv.id_producto
GROUP BY p.id_producto, p.nombre, p.stock_actual
ORDER BY p.nombre;

-- Total invertido por proveedor
-- Cuánto dinero se le ha pagado a cada proveedor y cuántas compras se le han hecho
SELECT pr.nombre, pr.apellido,
       COUNT(c.id_compra)  AS num_compras,
       SUM(c.total)       AS total_invertido
FROM proveedor pr
JOIN compra c ON pr.id_proveedor = c.id_proveedor
GROUP BY pr.id_proveedor, pr.nombre, pr.apellido
ORDER BY total_invertido DESC;

-- Ingresos y costos por categoría
-- Resume cuánto se vendió y cuánto costó comprar esos productos, agrupado por categoría
SELECT cat.nombre AS categoria,
       SUM(dv.cantidad * dv.precio_venta)  AS total_ventas,
       SUM(dc.cantidad * dc.precio_base)   AS total_costos
FROM categoria cat
JOIN producto p      ON cat.id_categoria = p.id_categoria
JOIN detalle_venta dv  ON p.id_producto   = dv.id_producto
JOIN detalle_compra dc ON p.id_producto   = dc.id_producto
GROUP BY cat.id_categoria, cat.nombre
ORDER BY total_ventas DESC;