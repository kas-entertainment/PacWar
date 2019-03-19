var host = "http://localhost:8080/register/"

async function getUser() {
    var agregar = "";
    await Promise.resolve(axios.get(host)
            .then(async function (response) {

            }));
}

async function addUser() {
    console.log(document.getElementById("Name"))
    document.getElementById("Name")
    document.getElementsByClassName("lastname")
    document.getElementsByClassName("email")
    document.getElementsByClassName("nikName")
    document.getElementsByClassName("password")
}