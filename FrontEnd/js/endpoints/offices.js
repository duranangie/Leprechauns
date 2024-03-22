

export const offices = async (api, data, type) =>{
    let officesSection = document.querySelector("#offices");

    let header2 = document.querySelector(".navlist");
    let customersSection3 = document.querySelector("#customers");
    let officesSection3 = document.querySelector("#offices");
    let productSection3 = document.querySelector("#products");
    let employeeSection3 = document.querySelector("#employees");
    let orderDetails3 = document.querySelector("#orderDetails");
    let orders3 = document.querySelector("#orders");
    let payments3 = document.querySelector("#payments");
    let productsRange3 = document.querySelector("#productsRange");

    var hero = document.querySelector(".icons");
    var section = document.querySelector(".hero");   

    hero.style.display = 'none';
    section.style.padding = '0 3%';
    section.style.transition = '.2s';

    officesSection3.style.display = '';
    productSection3.style.display = 'none';
    employeeSection3.style.display = 'none';
    orderDetails3.style.display = 'none';
    orders3.style.display = 'none';
    payments3.style.display = 'none';
    productsRange3.style.display = 'none';
    customersSection3.style.display = 'none';

    productSection3.innerHTML = "";
    employeeSection3.innerHTML = "";
    officesSection3.innerHTML = "";
    orderDetails3.innerHTML = "";
    orders3.innerHTML = "";
    payments3.innerHTML = "";
    productsRange3.innerHTML = "";
    customersSection3.innerHTML = "";

        const officeHTML = data.map((office)=> {
        return /*html*/`
        
            <div id="cardContainer" class="card-container">

                <div class=" face front">
                    <h1><center> ${office.officeCode} </center></h1>
                    <img src="img/OFFICE.jpg" alt="">
                    
                </div>
                <div class="face back">
                    
                    <ul>
                        <li><span class="key">City:</span> <span class="value">${office.city}</span></li>
                        <li><span class="key">Country:</span> <span class="value">${office.country}</span></li>
                        <li><span class="key">Region:</span> <span class="value">${office.region}</span></li>
                        <li><span class="key">Postal Code:</span> <span class="value">${office.postalCode}</span></li>
                        <li><span class="key">Phone:</span> <span class="value">${office.phone}</span></li>
                        <li><span class="key">Address Line 1:</span> <span class="value">${office.addressLine1}</span></li>
                        <li><span class="key">Address Line 2:</span> <span class="value">${office.addressLine2}</span></li>
                    </ul>
                </div>
            </div>
            `;
        });

        officesSection.insertAdjacentHTML("beforeend", `${officeHTML.join("")}`);
}