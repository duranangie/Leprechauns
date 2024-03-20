// JavaScript
document.getElementById("startButton").addEventListener("click", function() {
    // Mostrar elemento de carga
    document.getElementById("loading").style.display = "block";
    // Simular carga por 2 segundos (puedes reemplazar esto con tu lógica de carga real)
    setTimeout(function() {
        // Redirigir después de la carga
        window.location.href = "../../FrontEnd/Login.html";
        // Ocultar elemento de carga
        document.getElementById("loading").style.display = "none";
    }, 2000); // 2 segundos de simulación de carga
});
