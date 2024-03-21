
const url = `http://localhost:9090`;

let customersSection = document.querySelector("#customers");
let header = document.querySelector(".navlist");

document.getElementById("customers-nav").addEventListener("click", async(e)=>{

    let rel = await (await fetch(`${url}/customers`, {
        method: "GET"
    })).json();

    customersSection.innerHTML = "";

    rel = rel.map((res)=> {
    return /*html*/`
    
        <div id="cardContainer" class="card-container">

            <div class=" face front">
                <h1><center> ${res.customerName} </center></h1>
                <img src="img/CUSTOMERS.jpg" alt="">
                
            </div>
            <div class="face back">
                
            <ul>
                <li><span class="key">Contact:</span> <span class="value">${res.contactName}</span></li>
                <li><span class="key">Last Name:</span> <span class="value">${res.contactLastName}</span></li>
                <li><span class="key">Phone:</span> <span class="value">${res.phoneNumber}</span></li>
                <li><span class="key">Fax:</span> <span class="value">${res.fax}</span></li>
                <li><span class="key">Address1:</span> <span class="value">${res.lineAddress1}</span></li>
                <li><span class="key">Address2:</span> <span class="value">${res.lineAddress2}</span></li>
                <li><span class="key">City:</span> <span class="value">${res.city}</span></li>
                <li><span class="key">Region:</span> <span class="value">${res.region}</span></li>
                <li><span class="key">Country:</span> <span class="value">${res.country}</span></li>
                <li><span class="key">Postal code:</span> <span class="value">${res.postalCode}</span></li>
                <li><span class="key">Credit limit:</span> <span class="value">${res.creditLimit}</span></li>
                <li><span class="key">Sales role:</span> <span class="value">${res.sales}</span></li>
          </ul>
            </div>
        </div>
        `;
    });

    customersSection.insertAdjacentHTML("beforeend", `${rel.join("")}`);
})
// async function uploadCards(){
//     let rel = await (await fetch("http://localhost:9090/customers", {
//         method: "GET"
//     })).json();

//     productsSection.innerHTML = "";

//     rel = rel.map((res)=> {
//     return /*html*/`
    
//         <div id="cardContainer" class="card-container">

//             <div class=" face front">
//                 <img src="img/PRODUCTS.jpg" alt="">
//             </div>
//             <div class="face back">
//                 <span> product name ${res.productName} </span>
//                 <span> product name ${res.producCode} </span>
//             </div>
//         </div>
//         `;
//     });

//     productsSection.insertAdjacentHTML("beforeend", `${rel.join("")}`);
// }

// addEventListener("DOMContentLoaded", async (e)=>{
//     await uploadCards();
// });