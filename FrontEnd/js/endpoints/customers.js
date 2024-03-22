
export const customers = async (api, data , type) => {
    let customersSection = document.querySelector("#customers");

    let header = document.querySelector(".navlist");
    let officesSection1 = document.querySelector("#offices");
    let productSection1 = document.querySelector("#products");
    let employeeSection1 = document.querySelector("#employees");
    var hero = document.querySelector(".icons");
    var section = document.querySelector(".hero");   

    hero.style.display = 'none';
    section.style.padding = '0 3%';
    section.style.transition = '.2s'
    officesSection1.style.display = 'none';
    // let rel = await (await fetch(`${api}/customers`, {
    //     "Authorization": sessionStorage.getItem("token")
    // })).json();
    // console.log(res)
    employeeSection1.innerHTML = "";
    productSection1.innerHTML = "";
    officesSection1.innerHTML = "";
    customersSection.innerHTML = "";

    const customerHTML = data.map((customer)=> {
    return /*html*/`
        
        <div id="cardContainer" class="card-container">

            <div class=" face front">
                <h1><center> ${customer.customerName} </center></h1>
                <img src="img/CUSTOMERS.jpg" alt="">
                
            </div>
            <div class="face back">
                <ul>
                    <li><span class="key">Contact:</span> <span class="value">${customer.contactName}</span></li>
                    <li><span class="key">Last Name:</span> <span class="value">${customer.contactLastName}</span></li>
                    <li><span class="key">Phone:</span> <span class="value">${customer.phoneNumber}</span></li>
                    <li><span class="key">Fax:</span> <span class="value">${customer.fax}</span></li>
                    <li><span class="key">Address1:</span> <span class="value">${customer.lineAddress1}</span></li>
                    <li><span class="key">Address2:</span> <span class="value">${customer.lineAddress2}</span></li>
                    <li><span class="key">City:</span> <span class="value">${customer.city}</span></li>
                    <li><span class="key">Region:</span> <span class="value">${customer.region}</span></li>
                    <li><span class="key">Country:</span> <span class="value">${customer.country}</span></li>
                    <li><span class="key">Postal code:</span> <span class="value">${customer.postalCode}</span></li>
                    <li><span class="key">Credit limit:</span> <span class="value">${customer.creditLimit}</span></li>
                    <li><span class="key">Sales role:</span> <span class="value">${customer.sales}</span></li>
                </ul>
            </div>
        </div>
        `;
    });
    customersSection.insertAdjacentHTML("beforeend", `${customerHTML.join("")}`);
}

// function hide(){
//     var hero = document.querySelector(".icons");
//     hero.style.display = 'none';
// }
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