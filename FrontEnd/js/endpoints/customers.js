
export const customers = async (api, data , type) => {
    let customersSection = document.querySelector("#customers");

    let header = document.querySelector(".navlist");
    let customersSection2 = document.querySelector("#customers");
    let officesSection1 = document.querySelector("#offices");
    let productSection1 = document.querySelector("#products");
    let employeeSection1 = document.querySelector("#employees");
    let orderDetails1 = document.querySelector("#orderDetails");
    let orders1 = document.querySelector("#orders");
    let payments1 = document.querySelector("#payments");
    let productsRange1 = document.querySelector("#productsRange");

    var hero = document.querySelector(".icons");
    var section = document.querySelector(".hero");   

    hero.style.display = 'none';
    section.style.padding = '0 3%';
    section.style.transition = '.2s';

    officesSection1.style.display = 'none';
    productSection1.style.display = 'none';
    employeeSection1.style.display = 'none';
    orderDetails1.style.display = 'none';
    orders1.style.display = 'none';
    payments1.style.display = 'none';
    productsRange1.style.display = 'none';
    customersSection2.style.display = '';



    productSection1.innerHTML = "";
    employeeSection1.innerHTML = "";
    officesSection1.innerHTML = "";
    orderDetails1.innerHTML = "";
    orders1.innerHTML = "";
    payments1.innerHTML = "";
    productsRange1.innerHTML = "";
    customersSection2.innerHTML = "";

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




// query 1
document.getElementById("query-1-customers").addEventListener("click", async () => {
    const main = document.querySelector("#customers");
    console.log(api + type + "/customers/customersCountry");
    const res = await (await fetch(api + type + "/customersCountry", {
        
        headers: {
            'Authorization': sessionStorage.getItem('token')
        }
    })).json();

    console.log(res);
    if (res.error) {
       console.log("Error");
    } else {
        const customerHTML = res.map(customer =>
            `<div class="content-data medium">
                <div class="box">
                    <h2 class="title">${customer.customerName}</h2>
                    <div class="info">
                        <span><strong>Customer Id:</strong> ${customer.customerId}</span>
                    </div>
                </div>
            </div>`
        ).join("");

        if (customerHTML.length === 0) {
            main.innerHTML = `
                <h1>Returns a list with the name of all Spanish clients.</h1>
                <h2 style="color: #81D43A; text-align: center; font-size: 4rem; margin-bottom: 50px">There is no data to show</h2>
                <img src="" alt="NO DATA TO SHOW" style="min-width: 250px; width: 50%; height: 50%; display: block; margin: 0 auto;"/>
            `
        } else {
            main.innerHTML = `
                <h1>Returns a list with the name of all Spanish clients.</h1>
                <div class="data" id="content-api">
                    ${customerHTML}
                </div>
            `
        }
    }
})
}

// // query 2 // PAYMENT
// document.getElementById("query-2-customers").addEventListener("click", async () => {
//     const res = await (await fetch(api + type + "/clients-with-payments-year/2008", {
//         headers: {
//             'Authorization': sessionStorage.getItem('token')
//         }
//     })).json();

//     if (res.error) {
//         Swal.fire({
//             icon: "error",
//             title: "Oops...",
//             text: `${res.message}`,
//             showConfirmButton: false,
//             timer: 2500,
//             timerProgressBar: true,
//             footer: `${res.help}`
//         });
//     } else {
//         const customerHTML = res.map(customerCode =>
//             `<div class="content-data medium">
//                 <div class="box">
//                     <h2 class="title" style="font-size: 4rem">${customerCode}</h2>
//                 </div>
//             </div>`
//         ).join("");

//         if (customerHTML.length === 0) {
//             main.innerHTML = `
//                 <h1>Returns a list with the customer code of those customers who made a payment in 2008. Keep in mind that you must eliminate those customer codes that appear repeated.</h1>
//                 <h2 style="color: #81D43A; text-align: center; font-size: 4rem; margin-bottom: 50px">There is no data to show</h2>
//                 <img src="http://127.0.0.1:5500/frontend/resources/nodata.jpg" alt="NO DATA TO SHOW" style="min-width: 250px; width: 50%; height: 50%; display: block; margin: 0 auto;"/>
//             `
//         } else {
//             main.innerHTML = `
//                 <h1>Returns a list with the customer code of those customers who made a payment in 2008. Keep in mind that you must eliminate those customer codes that appear repeated.</h1>
//                 <div class="data" id="content-api">
//                     ${customerHTML}
//                 </div>
//             `
//         }
//     }
// })

 // query 3
//  document.getElementById("query-3-customers").addEventListener("click", async () => {
//     const res = await (await fetch(api + type + "/clients-in-madrid-with-specific-representatives", {
//         headers: {
//             'Authorization': sessionStorage.getItem('token')
//         }
//     })).json();

//     const customerHTML = res.map(customer =>
//         `<div class="content-data medium">
//             <div class="box">
//                 <h2 class="title">${customer.customerName}</h2>
//                 <div class="info">
//                     <span><strong>Customer Id:</strong> ${customer.customerCode}</span>
//                     <span><strong>Phone:</strong> ${customer.phone}</span>
//                     <span><strong>Address:</strong> ${customer.addressLine1}</span>
//                     <span><strong>Location:</strong> ${customer.city}, ${customer.country}</span>
//                 </div>
//             </div>
//         </div>`
//     ).join("");

//     if (customerHTML.length === 0) {
//         main.innerHTML = `
//             <h1>Returns a list with all the clients who are from the city of Madrid and whose sales representative has the employee code 11 or 30.</h1>
//             <h2 style="color: #81D43A; text-align: center; font-size: 4rem; margin-bottom: 50px">There is no data to show</h2>
//             <img src="http://127.0.0.1:5500/frontend/resources/nodata.jpg" alt="NO DATA TO SHOW" style="min-width: 250px; width: 50%; height: 50%; display: block; margin: 0 auto;"/>
//         `
//     } else {
//         main.innerHTML = `
//             <h1>Returns a list with all the clients who are from the city of Madrid and whose sales representative has the employee code 11 or 30.</h1>
//             <div class="data" id="content-api">
//                 ${customerHTML}
//             </div>
//         `
//     }
// })