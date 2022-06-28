let baseUrl = "http://localhost:8081/";

async function createAccount(){

if(check("uname") || check("pass") || check("nameInput") || check("accountType") || document.getElementById("accountType").value == 0){
    toggleError("emptyFieldError");
    console.log('entry field error');
    return;
}

    let uname = document.getElementById("uname").value;
    let pass  = document.getElementById("pass").value;
    let nameInput = document.getElementById("nameInput").value;
    let access = document.getElementById("accountType").value;

    let user = {
        id: 0,
        username: uname,
        password: pass,
        name: nameInput,
        accLvl: access,
    }

    let userJson = JSON.stringify(user);

    let res = await fetch(
        `${baseUrl}create`,
        {
            method: 'POST',
            header: {'Content-Type': 'applicaiton/json'},
            body: userJson
        }
    );

    //I need to write an if statement that will toggle an error message if all the fields are not filled in.

    let resJson = await res.json()
        .then((resp) => {
            console.log(resp);
            window.location = 'http://localhost:8081/creationSuccess.html';
        //then redirect to login page.
    })
    .catch((error) => {console.log(error)})

}

function check(check){
    if(document.getElementById(check).value.length == 0){
        return true;
    }
    else{
        return false;
    }
}

function toggleError(id){
    var x = document.getElementById(id);
    if(x.style.display === "none"){
        x.style.display="block";
    }
}