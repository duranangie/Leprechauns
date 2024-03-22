

export const orders = async (api, data , type) => {
    let ordersSection = document.querySelector("#orders");

    let header = document.querySelector(".navlist");
    let customersSection5 = document.querySelector("#customers");
    let officesSection5 = document.querySelector("#offices");
    let productSection5 = document.querySelector("#products");
    let employeeSection5 = document.querySelector("#employees");
    let orderDetails5 = document.querySelector("#orderDetails");
    let orders5 = document.querySelector("#orders");
    let payments5 = document.querySelector("#payments");
    let productsRange5 = document.querySelector("#productsRange");

    officesSection5.style.display = 'none';
    productSection5.style.display = 'none';
    employeeSection5.style.display = 'none';
    orderDetails5.style.display = 'none';
    orders5.style.display = '';
    payments5.style.display = 'none';
    productsRange5.style.display = 'none';
    customersSection5.style.display = 'none';

    productSection5.innerHTML = "";
    employeeSection5.innerHTML = "";
    officesSection5.innerHTML = "";
    orderDetails5.innerHTML = "";
    orders5.innerHTML = "";
    payments5.innerHTML = "";
    productsRange5.innerHTML = "";
    customersSection5.innerHTML = "";

    const orderHTML = data.map((order)=> {
    return /*html*/`
        
        <div id="cardContainer" class="card-container">

            <div class=" face front">
                <h1><center> ${order.status} </center></h1>
                <img src="img/ORDERS.jpg" alt="">
                
            </div>
            <div class="face back">
                <ul>
                    <li><span class="key">Order Date:</span> <span class="value">${order.orderDate}</span></li>
                    <li><span class="key">Expected Date:</span> <span class="value">${order.expectedDate}</span></li>
                    <li><span class="key">Deliver Date:</span> <span class="value">${order.deliverDate}</span></li>
                    <li><span class="key">Comments:</span> <span class="value">${order.comments}</span></li>
                    <li><span class="key">Customer Id:</span> <span class="value">${order.customerId}</span></li>
                </ul>
            </div>
        </div>
        `;
    });
    ordersSection.insertAdjacentHTML("beforeend", `${orderHTML.join("")}`);
}
