import { validateToken } from "./ValidateToken.js";

export const loadMain = async (api) => {

    // const username = document.querySelector(".username");
    // username.textContent = sessionStorage.getItem("username")

    document.getElementById("customers-nav").addEventListener("click", async(e)=>{
        validateToken(api, "/customers");
    })


}

