import { validateToken } from "./ValidateToken.js";

export const loadMain = async (api) => {
    validateToken(api, "/validateToken")


    const username = document.querySelector(".username");
    username.textContent = sessionStorage.getItem("username")

}

