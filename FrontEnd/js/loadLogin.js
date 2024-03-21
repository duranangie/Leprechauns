export const loadLogin = (api) => {
    const container = document.querySelector('#hero');
    const registerBtn = document.querySelector('#register');
    const loginBtn = document.querySelector('#login');
    const upForm = document.querySelector(".input-group-up");
    const inForm = document.querySelector(".input-group");

    registerBtn.addEventListener('click', () => {
        container.classList.add("active");
    });

    loginBtn.addEventListener('click', () => {
        container.classList.remove("active");
    });

    inForm.addEventListener("submit", (e) => {
        e.preventDefault();
        const data = Object.fromEntries(new FormData(e.target));
        sendData(data, api, "/login");
    })

    upForm.addEventListener("submit", (e) => {
        e.preventDefault();
        const data = Object.fromEntries(new FormData(e.target));
        sendData(data, api, "/register");
    })
}

async function sendData(data, api, type) {
    const params = new URLSearchParams();
    params.append('user', data.username);
    params.append('encryptedPass', data.password);

    const res = await (await fetch(api + type, {
        method: "POST",
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: params
    })).json();

    if (res.error) {
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: `${res.message}`,
            showConfirmButton: false,
            timer: 2500,
            timerProgressBar: true,
            footer: `${res.help}`
        });
    } else if (res.token) {
        sessionStorage.setItem("token", res.token);
        sessionStorage.setItem("username", data.username)

        let timerInterval;
        Swal.fire({
            icon: "success",
            title: "Welcome!",
            html: "Loading <b></b>%.",
            timer: 1000,
            timerProgressBar: true,
            didOpen: () => {
                Swal.showLoading();
                const timer = Swal.getPopup().querySelector("b");
                timerInterval = setInterval(() => {
                    timer.textContent = `${Swal.getTimerLeft()}`;
                }, 100);
            },
            willClose: () => {
                clearInterval(timerInterval);
            }
        }).then(() => {
            window.location.href = "../FrontEnd/index.html"
        })
    } else {
        Swal.fire({
            icon: "success",
            title: `${res.message}`,
            showConfirmButton: false,
            timer: 2000,
            timerProgressBar: true
        }).then(() => {
            window.location.reload();
        });
    }
}