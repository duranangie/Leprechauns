
const url2 = `http://localhost:9090`;


let officesSection = document.querySelector("#offices");
let header2 = document.querySelector(".navlist");
let customersSection2 = document.querySelector("#customers");
let productSection2 = document.querySelector("#products");
let employeeSection2 = document.querySelector("#employees");

document.getElementById("office-nav").addEventListener("click", async(e)=>{

    customersSection2.style.display = 'none';
    let rel = await (await fetch(`${url2}/offices`, {
        method: "GET"
    })).json();
    
    employeeSection2.innerHTML = "";
    productSection2.innerHTML = "";
    customersSection2.innerHTML = "";
    officesSection.innerHTML = "";

    rel = rel.map((res)=> {
    return /*html*/`
    
        <div id="cardContainer" class="card-container">

            <div class=" face front">
                <h1><center> ${res.officeCode} </center></h1>
                <img src="img/OFFICE.jpg" alt="">
                
            </div>
            <div class="face back">
                
                <ul>
                    <li><span class="key">City:</span> <span class="value">${res.city}</span></li>
                    <li><span class="key">Country:</span> <span class="value">${res.country}</span></li>
                    <li><span class="key">Region:</span> <span class="value">${res.region}</span></li>
                    <li><span class="key">Postal Code:</span> <span class="value">${res.postalCode}</span></li>
                    <li><span class="key">Phone:</span> <span class="value">${res.phone}</span></li>
                    <li><span class="key">Address Line 1:</span> <span class="value">${res.addressLine1}</span></li>
                    <li><span class="key">Address Line 2:</span> <span class="value">${res.addressLine2}</span></li>
                </ul>
            </div>
        </div>
        `;
    });

    officesSection.insertAdjacentHTML("beforeend", `${rel.join("")}`);
})