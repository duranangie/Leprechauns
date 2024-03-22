

export const orderDetails = async(api, data, type) => {


let orderDetailsSection = document.querySelector("#orderDetails");

    let header5 = document.querySelector(".navlist");
    let customersSection4 = document.querySelector("#customers");
    let officesSection4 = document.querySelector("#offices");
    let productSection4 = document.querySelector("#products");
    let employeeSection4 = document.querySelector("#employees");
    let orderDetails4 = document.querySelector("#orderDetails");
    let orders4 = document.querySelector("#orders");
    let payments4 = document.querySelector("#payments");
    let productsRange4 = document.querySelector("#productsRange");

    officesSection4.style.display = 'none';
    productSection4.style.display = 'none';
    employeeSection4.style.display = 'none';
    orderDetails4.style.display = '';
    orders4.style.display = 'none';
    payments4.style.display = 'none';
    productsRange4.style.display = 'none';
    customersSection4.style.display = 'none';

    productSection4.innerHTML = "";
    employeeSection4.innerHTML = "";
    officesSection4.innerHTML = "";
    orderDetails4.innerHTML = "";
    orders4.innerHTML = "";
    payments4.innerHTML = "";
    productsRange4.innerHTML = "";
    customersSection4.innerHTML = "";

    const orderDetailHTML = data.map((orderDetail)=> {
    return /*html*/`
    
        <div id="cardContainer" class="card-container">

            <div class=" face front">
                <h1><center>Order Code: ${orderDetail.orderCode} </center></h1>
                <h1><center>Product Code: ${orderDetail.productCode} </center></h1>
                <img src="img/ORDERDETAIL.jpg" alt="">
                
            </div>
            <div class="face back">
                
                <ul>
                    <li><span class="key">Amount:</span> <span class="value">${orderDetail.amount}</span></li>
                    <li><span class="key">Unit Price:</span> <span class="value">${orderDetail.unitPrice}</span></li>
                    <li><span class="key">Number Line:</span> <span class="value">${orderDetail.numberLine}</span></li>
                </ul>
            </div>
        </div>
        `;
    });

    orderDetailsSection.insertAdjacentHTML("beforeend", `${orderDetailHTML.join("")}`);
}