

export const productsRange = async (api, data , type) => {
console.log(data);

    let productRangeSection = document.querySelector("#productsRange");

    let header = document.querySelector(".navlist");
    let customersSection8 = document.querySelector("#customers");
    let officesSection8 = document.querySelector("#offices");
    let productSection8 = document.querySelector("#products");
    let employeeSection8 = document.querySelector("#employees");
    let orderDetails8 = document.querySelector("#orderDetails");
    let orders8 = document.querySelector("#orders");
    let payments8 = document.querySelector("#payments");
    let productsRange8 = document.querySelector("#productsRange");

    var hero = document.querySelector(".icons");
    var section = document.querySelector(".hero");   

    hero.style.display = 'none';
    section.style.padding = '0 3%';
    section.style.transition = '.2s';

    officesSection8.style.display = 'none';
    productSection8.style.display = 'none';
    employeeSection8.style.display = 'none';
    orderDetails8.style.display = 'none';
    orders8.style.display = 'none';
    payments8.style.display = 'none';
    productsRange8.style.display = '';
    customersSection8.style.display = 'none';

    productSection8.innerHTML = "";
    employeeSection8.innerHTML = "";
    officesSection8.innerHTML = "";
    orderDetails8.innerHTML = "";
    orders8.innerHTML = "";
    payments8.innerHTML = "";
    productsRange8.innerHTML = "";
    customersSection8.innerHTML = "";

    const productRangeHTML = data.map((range)=> {
    return /*html*/`
        
        <div id="cardContainer" class="card-container">

            <div class=" face front">
                <h1><center> ${range.range} </center></h1>
                <img src="img/RANGES.jpg" alt="">
                
            </div>
            <div class="face back">
                <ul>
                    <li><span class="key">Text Description:</span> <span class="value">${range.textDescription}</span></li>
                    <li><span class="key">HTML Description:</span> <span class="value">${range.htmlDescription}</span></li>
                    <li><span class="key">Image:</span> <span class="value">${range.image}</span></li>
                </ul>
            </div>
        </div>
        `;
    });
    productRangeSection.insertAdjacentHTML("beforeend", `${productRangeHTML.join("")}`);
}
