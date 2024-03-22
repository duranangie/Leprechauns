import { validateToken } from "./ValidateToken.js";

export const loadMain = async (api) => {

    // const username = document.querySelector(".username");
    // username.textContent = sessionStorage.getItem("username")

    document.getElementById("customers-nav").addEventListener("click", async(e)=>{
        validateToken(api, "/customers");
    })

    document.getElementById("office-nav").addEventListener("click", async(e)=>{
        validateToken(api, "/offices");
    })

    document.getElementById("employee-nav").addEventListener("click", async(e)=>{
        validateToken(api, "/employee");
    })

    document.getElementById("payment-nav").addEventListener("click", async(e)=>{
        validateToken(api, "/payments");
    })

    document.getElementById("order-nav").addEventListener("click", async(e)=>{
        validateToken(api, "/orders");
    })

    document.getElementById("orderDetails-nav").addEventListener("click", async(e)=>{
        validateToken(api, "/orderdetails");
    })

    document.getElementById("product-nav").addEventListener("click", async(e)=>{
        validateToken(api, "/products");
    })

    document.getElementById("productRange-nav").addEventListener("click", async(e)=>{
        validateToken(api, "/ranges");
    })

    document.getElementById("logout").addEventListener("click", async(e)=>{
        localStorage.removeItem("token");
        window.location.href = "/FrontEnd/Login.html"
    })
}

