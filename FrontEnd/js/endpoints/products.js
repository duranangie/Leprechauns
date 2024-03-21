
const url3 = `http://localhost:9090`;


let productsSection = document.querySelector("#products");
let header3 = document.querySelector(".navlist");
let customersSection3 = document.querySelector("#customers");
let officesSection3 = document.querySelector("#offices");
let productSection3 = document.querySelector("#products");
let employeeSection3 = document.querySelector("#employees");

document.getElementById("product-nav").addEventListener("click", async(e)=>{


    let rel = await (await fetch(`${url3}/products`, {
        method: "GET"
    })).json();

    // customersSection2.style.display = 'none';
    
    
    employeeSection3.innerHTML = "";
    officesSection3.innerHTML = "";
    customersSection3.innerHTML = "";
    productsSection.innerHTML = "";

    rel = rel.map((res)=> {
    return /*html*/`
    
        <div id="cardContainer" class="card-container">

            <div class=" face front">
                <h1><center> ${res.name} </center></h1>
                <img src="img/PRODUCTS.jpg" alt="">
                
            </div>
            <div class="face back">
                
                <ul>
                    <li><span class="key">Product Id:</span> <span class="value">${res.productId}</span></li>
                    <li><span class="key">Range Product:</span> <span class="value">${res.rangeProduct}</span></li>
                    <li><span class="key">Dimensions:</span> <span class="value">${res.dimensions}</span></li>
                    <li><span class="key">Supplier:</span> <span class="value">${res.supplier}</span></li>
                    <li><p class="key">Description:</span> <span class="value">${res.description}</p></li>
                    <li><span class="key">Amount:</span> <span class="value">${res.amountInStock}</span></li>
                    <li><span class="key">Sale Price:</span> <span class="value">${res.salePrice}</span></li>
                    <li><span class="key">Supplier Price:</span> <span class="value">${res.supplierPrice}</span></li>
                </ul>
            </div>
        </div>
        `;
    });

    productsSection.insertAdjacentHTML("beforeend", `${rel.join("")}`);
})