function load() {
    document.getElementById("name").innerText = "Name: " + sessionStorage.firstName;
    document.getElementById("last").innerText = "Last Name: " + sessionStorage.lastName;
    document.getElementById("email").innerText = "Email: " + sessionStorage.email;
    document.getElementById("nik").innerText = "Nickname: " + sessionStorage.id;
}

function logout() {
    sessionStorage.clear();
}
load();