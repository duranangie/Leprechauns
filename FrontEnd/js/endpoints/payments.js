

export const payments = async (api, data , type) => {
    let paymentsSection = document.querySelector("#payments");

    let header = document.querySelector(".navlist");
    let customersSection6 = document.querySelector("#customers");
    let officesSection6 = document.querySelector("#offices");
    let productSection6 = document.querySelector("#products");
    let employeeSection6 = document.querySelector("#employees");
    let orderDetails6 = document.querySelector("#orderDetails");
    let orders6 = document.querySelector("#orders");
    let payments6 = document.querySelector("#payments");
    let productsRange6 = document.querySelector("#productsRange");

    var hero = document.querySelector(".icons");
    var section = document.querySelector(".hero");   

    hero.style.display = 'none';
    section.style.padding = '0 3%';
    section.style.transition = '.2s';

    officesSection6.style.display = 'none';
    productSection6.style.display = 'none';
    employeeSection6.style.display = 'none';
    orderDetails6.style.display = 'none';
    orders6.style.display = 'none';
    payments6.style.display = '';
    productsRange6.style.display = 'none';
    customersSection6.style.display = 'none';

    productSection6.innerHTML = "";
    employeeSection6.innerHTML = "";
    officesSection6.innerHTML = "";
    orderDetails6.innerHTML = "";
    orders6.innerHTML = "";
    payments6.innerHTML = "";
    productsRange6.innerHTML = "";
    customersSection6.innerHTML = "";
    
    const paymentsHTML = data.map((payment)=> {
    return /*html*/`
        
        <div id="cardContainer" class="card-container">

            <div class=" face front">
                <h1><center> ${payment.transactionId} </center></h1>
                <img src="img/INVOICES.jpg" alt="">
                
            </div>
            <div class="face back">
                <ul>
                    <li><span class="key">Payment Form:</span> <span class="value">${payment.paymentForm}</span></li>
                    <li><span class="key">Pay Day:</span> <span class="value">${payment.payDay}</span></li>
                    <li><span class="key">Total:</span> <span class="value">${payment.total}</span></li>
                    <li><span class="key">Customer Id:</span> <span class="value">${payment.customer}</span></li>
                </ul>
            </div>
        </div>
        `;
    });
    paymentsSection.insertAdjacentHTML("beforeend", `${paymentsHTML.join("")}`);
}
