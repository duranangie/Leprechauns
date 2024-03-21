

const url4 = `http://localhost:9090`;


let employeesSection = document.querySelector("#employees");
let header4 = document.querySelector(".navlist");
let customersSection4 = document.querySelector("#customers");
let officesSection4 = document.querySelector("#offices");
let productSection4 = document.querySelector("#products");

document.getElementById("employee-nav").addEventListener("click", async(e)=>{


    let rel = await (await fetch(`${url4}/employees`, {
        method: "GET"
    })).json();

    // customersSection2.style.display = 'none';
    
    productSection4.innerHTML = "";
    officesSection4.innerHTML = "";
    customersSection4.innerHTML = "";
    employeesSection.innerHTML = "";

    rel = rel.map((res)=> {
    return /*html*/`
    
        <div id="cardContainer" class="card-container">

            <div class=" face front">
                <h1><center> ${res.rol} </center></h1>
                <img src="img/EMPLOYEE.jpg" alt="">
                
            </div>
            <div class="face back">
                
                <ul>
                    <li><span class="key">Employee Name:</span> <span class="value">${res.employeeName}</span></li>
                    <li><span class="key">Last Name 1:</span> <span class="value">${res.lastName1}</span></li>
                    <li><span class="key">Last Name 2:</span> <span class="value">${res.lastName2}</span></li>
                    <li><span class="key">Extension:</span> <span class="value">${res.extension}</span></li>
                    <li><p class="key">Email:</span> <span class="value">${res.email}</p></li>
                    <li><span class="key">Office:</span> <span class="value">${res.office}</span></li>
                    <li><span class="key">Boss Code:</span> <span class="value">${res.bossCode}</span></li>
                </ul>
            </div>
        </div>
        `;
    });

    employeesSection.insertAdjacentHTML("beforeend", `${rel.join("")}`);
})