

export const products = async( api, data, type) =>{
console.log(data);
let productsSection = document.querySelector("#products");

let header3 = document.querySelector(".navlist");
let customersSection7 = document.querySelector("#customers");
let officesSection7 = document.querySelector("#offices");
let productSection7 = document.querySelector("#products");
let employeeSection7 = document.querySelector("#employees");
let orderDetails7 = document.querySelector("#orderDetails");
let orders7 = document.querySelector("#orders");
let payments7 = document.querySelector("#payments");
let productsRange7 = document.querySelector("#productsRange");

var hero = document.querySelector(".icons");
var section = document.querySelector(".hero");   

hero.style.display = 'none';
section.style.padding = '0 3%';
section.style.transition = '.2s';

officesSection7.style.display = 'none';
productSection7.style.display = '';
employeeSection7.style.display = 'none';
orderDetails7.style.display = 'none';
orders7.style.display = 'none';
payments7.style.display = 'none';
productsRange7.style.display = 'none';
customersSection7.style.display = 'none';

productSection7.innerHTML = "";
employeeSection7.innerHTML = "";
officesSection7.innerHTML = "";
orderDetails7.innerHTML = "";
orders7.innerHTML = "";
payments7.innerHTML = "";
productsRange7.innerHTML = "";
customersSection7.innerHTML = "";

    const productHTML = data.map((product)=> {
    return /*html*/`
    
        <div id="cardContainer" class="card-container">

            <div class=" face front">
                <h1><center> ${product.name} </center></h1>
                <img src="img/PRODUCTS.jpg" alt="">
                
            </div>
            <div class="face back">
                
                <ul>
                    <li><span class="key">Product Id:</span> <span class="value">${product.productId}</span></li>
                    <li><span class="key">Range Product:</span> <span class="value">${product.rangeProduct}</span></li>
                    <li><span class="key">Dimensions:</span> <span class="value">${product.dimensions}</span></li>
                    <li><span class="key">Supplier:</span> <span class="value">${product.supplier}</span></li>
                    <li><p class="key">Description:</span> <span class="value">${product.description}</p></li>
                    <li><span class="key">Amount:</span> <span class="value">${product.amountInStock}</span></li>
                    <li><span class="key">Sale Price:</span> <span class="value">${product.salePrice}</span></li>
                    <li><span class="key">Supplier Price:</span> <span class="value">${product.supplierPrice}</span></li>
                </ul>
            </div>
        </div>
        `;
    });

    productsSection.insertAdjacentHTML("beforeend", `${productHTML.join("")}`);
}