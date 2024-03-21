let menu = document.querySelector('#menu-icon');
let navlist = document.querySelector('.navlist');


menu.onclick = () => {
    menu.classList.toggle('bx-x');
    navlist.classList.toggle('open')
}

function showContent(category) {
    var textContainer = document.getElementById('textContainer');
    var imageContainer = document.getElementById('imageContainer');
    var cardContainer = document.getElementById('cardContainer');
    var icons = document.querySelector('icons');
    var sectionHero = document.querySelector('.hero');
    // Ocultar el contenedor de texto
    textContainer.style.display = 'none';
    imageContainer.style.display = 'none';
    // icons.style.display = 'none';
    // sectionHero.style.display = 'flex';
    // sectionHero.style.gridTemplateColumns = 'none';
    // sectionHero.style.alignItems = 'none';
    // sectionHero.style.removeProperty('gap');
    // sectionHero.style.flexWrap = 'wrap';
    // sectionHero .style.justifyContent = 'center';
    // cardContainer.innerHTML = ''; // Limpiar las tarjetas

    // // Mostrar contenido según la categoría
    // switch (category) {
    //     case 'customer':
    //         // Lógica para mostrar contenido relacionado con "Customer"
    //         cardContainer.innerHTML = '<div class="card">Customer Information</div>';
    //         break;
    //     case 'employee':
    //         // Lógica para mostrar contenido relacionado con "Employee"
    //         cardContainer.innerHTML = '<div class="card">Employee Information</div>';
    //         break;
    //     case 'office':
    //         // Lógica para mostrar contenido relacionado con "Office"
    //         cardContainer.innerHTML = '<div class="card">Office Information</div>';
    //         break;
    //     case 'order':
    //         // Lógica para mostrar contenido relacionado con "Order"
    //         cardContainer.innerHTML = '<div class="card">Order Information</div>';
    //         break;
    //     case 'payment':
    //         // Lógica para mostrar contenido relacionado con "Payment"
    //         cardContainer.innerHTML = '<div class="card">Payment Information</div>';
    //         break;
    //     case 'product':
    //         // Lógica para mostrar contenido relacionado con "Product"
    //         cardContainer.innerHTML = '<div class="card">Product Information</div>';
    //         break;
    //     case 'product-range':
    //         // Lógica para mostrar contenido relacionado con "Product Range"
    //         cardContainer.innerHTML = '<div class="card">Product Range Information</div>';
    //         break;
    //     default:
    //         // Lógica predeterminada si no coincide con ninguna categoría
    //         break;
    // }
}