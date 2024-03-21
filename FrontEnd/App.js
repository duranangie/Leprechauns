
import { loadLogin } from "./js/loadLogin.js";
import { loadMain } from "./js/loadMain.js";

const api = "http://localhost:9090"

document.addEventListener("DOMContentLoaded", () => {
    if (window.location.href.includes('Login.html')) {
        loadLogin(api);
    }
    if (window.location.href.includes('index.html')) {
        document.querySelector(".btnLogOut").addEventListener("click", () => {
            sessionStorage.removeItem("token");
            sessionStorage.removeItem("username");
            window.location.href = "http://127.0.0.1:5500/FrontEnd/Login.html"
        })
        loadMain(api);
    }
})