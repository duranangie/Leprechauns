
import { customers } from "./endpoints/customers.js";
import { offices } from "./endpoints/offices.js";
import { employees } from "./endpoints/employees.js";
import { payments } from "./endpoints/payments.js";
import { orders } from "./endpoints/orders.js";
import { orderDetails } from "./endpoints/orderDetails.js";
import { products } from "./endpoints/products.js";
import { productsRange } from "./endpoints/productsRange.js";

export const displayData = async (api, data, type) => {
    if (document.getElementById("dashboard")) {
        document.getElementById("dashboard").remove()
    }
    
    if (type === "/customers") {
       await customers(api, data, type);
    } else if (type === "/offices") {
        await offices(api, data, type);
    } else if (type === "/employee") {
        await employees(api, data, type);
    } else if (type === "/payments") {
        await payments(api, data, type);
    } else if (type === "/orders") {productsRange
        await orders(api, data, type);
    } else if (type === "/orderdetails") {
        await orderDetails(api, data, type);
    } else if (type === "/products") {
        await products(api, data, type);
    } else if (type === "/ranges") {
        await productsRange(api, data, type);
    }
}