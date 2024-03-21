


const url5 = `http://localhost:9090`;


let orderDetailsSection = document.querySelector("#orderDetails");
let header5 = document.querySelector(".navlist");
let customersSection5 = document.querySelector("#customers");
let officesSection5 = document.querySelector("#offices");
let productSection5 = document.querySelector("#products");
let employeeSection5 = document.querySelector("#employees")

document.getElementById("orderDetails-nav").addEventListener("click", async(e)=>{


    let rel = await (await fetch(`${url5}/orderdetails`, {
        method: "GET"
    })).json();

    // customersSection2.style.display = 'none';
    employeeSection5.innerHTML = "";
    productSection5.innerHTML = "";
    officesSection5.innerHTML = "";
    customersSection5.innerHTML = "";
    orderDetailsSection.innerHTML = "";

    rel = rel.map((res)=> {
    return /*html*/`
    
        <div id="cardContainer" class="card-container">

            <div class=" face front">
                <h1><center>Order Code: ${res.orderCode} </center></h1>
                <h1><center>Product Code: ${res.productCode} </center></h1>
                <img src="img/ORDERDETAIL.jpg" alt="">
                
            </div>
            <div class="face back">
                
                <ul>
                    <li><span class="key">Amount:</span> <span class="value">${res.amount}</span></li>
                    <li><span class="key">Unit Price:</span> <span class="value">${res.unitPrice}</span></li>
                    <li><span class="key">Number Line:</span> <span class="value">${res.numberLine}</span></li>
                </ul>
            </div>
        </div>
        `;
    });

    orderDetailsSection.insertAdjacentHTML("beforeend", `${rel.join("")}`);
})