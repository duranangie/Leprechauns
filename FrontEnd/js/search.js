document.getElementById("searchInput").addEventListener("input", function() {
    const query = this.value.trim().toLowerCase();
    const cards = document.querySelectorAll(".card-container");

    cards.forEach(card => {
        const cardText = card.textContent.toLowerCase();
        if (cardText.includes(query)) {
            card.style.display = "block";
        } else {
            card.style.display = "none";
        }
    });
});
