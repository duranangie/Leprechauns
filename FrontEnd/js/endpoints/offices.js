
const url = `http://localhost:9090`;

let officesSection = document.querySelector("#offices");
let header = document.querySelector(".navlist");

document.getElementById("office-nav").addEventListener("click", async(e)=>{

    let rel = await (await fetch(`${url}/offices`, {
        method: "GET"
    })).json();

    officesSection.innerHTML = "";

    rel = rel.map((res)=> {
    return /*html*/`
    
        <div id="cardContainer" class="card-container">

            <div class=" face front">
                <h1><center> ${res.officeCode} </center></h1>
                <img src="img/OFFICES.jpg" alt="">
                
            </div>
            <div class="face back">
                
            <ul>
           
                <li><span class="key">City:</span> <span class="value">${res.city}</span></li>
                <li><span class="key">Country:</span> <span class="value">${res.country}</span></li>
                <li><span class="key">Region:</span> <span class="value">${res.region}</span></li>
                <li><span class="key">Postal Code:</span> <span class="value">${res.postalCode}</span></li>
                <li><span class="key">Phone:</span> <span class="value">${res.phone}</span></li>
                <li><span class="key">Address Line 1:</span> <span class="value">${res.address1}</span></li>
                <li><span class="key">Address Line 2:</span> <span class="value">${res.address2}</span></li>
          
          </ul>
            </div>
        </div>
        `;
    });

    officesSection.insertAdjacentHTML("beforeend", `${rel.join("")}`);
})