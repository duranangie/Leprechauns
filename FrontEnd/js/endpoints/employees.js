

export const employees = async (api, data, type) => {

let employeesSection = document.querySelector("#employees");

let header4 = document.querySelector(".navlist");
let customersSection2 = document.querySelector("#customers");
let officesSection2 = document.querySelector("#offices");
let productSection2 = document.querySelector("#products");
let employeeSection2 = document.querySelector("#employees");
let orderDetails2 = document.querySelector("#orderDetails");
let orders2 = document.querySelector("#orders");
let payments2 = document.querySelector("#payments");
let productsRange2 = document.querySelector("#productsRange");

    officesSection2.style.display = 'none';
    productSection2.style.display = 'none';
    employeeSection2.style.display = '';
    orderDetails2.style.display = 'none';
    orders2.style.display = 'none';
    payments2.style.display = 'none';
    productsRange2.style.display = 'none';
    customersSection2.style.display = 'none';

    productSection2.innerHTML = ""
    employeeSection2.innerHTML = "";
    officesSection2.innerHTML = "";
    orderDetails2.innerHTML = "";
    orders2.innerHTML = "";
    payments2.innerHTML = "";
    productsRange2.innerHTML = "";
    customersSection2.innerHTML = "";

    const employeeHTML = data.map((employee)=> {
    return /*html*/`
    
        <div id="cardContainer" class="card-container">

            <div class=" face front">
                <h1><center> ${employee.office} </center></h1>
                <img src="img/EMPLOYEE.jpg" alt="">
                
            </div>
            <div class="face back">
                
                <ul>
                    <li><span class="key">Employee Name:</span> <span class="value">${employee.employeeName}</span></li>
                    <li><span class="key">Last Name 1:</span> <span class="value">${employee.lastName1}</span></li>
                    <li><span class="key">Last Name 2:</span> <span class="value">${employee.lastName2}</span></li>
                    <li><span class="key">Extension:</span> <span class="value">${employee.extension}</span></li>
                    <li><p class="key">Email:</span> <span class="value">${employee.email}</p></li>
                    <li><span class="key">Office:</span> <span class="value">${employee.office}</span></li>
                    <li><span class="key">Boss Code:</span> <span class="value">${employee.bossCode}</span></li>
                </ul>
            </div>
        </div>
        `;
    });

    employeesSection.insertAdjacentHTML("beforeend", `${employeeHTML.join("")}`);
}