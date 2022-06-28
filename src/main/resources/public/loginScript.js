let baseUrl = "http://localhost:8081/";


async function login(){
    console.log("login button pressed")

    if(document.getElementById('uname').value.length == 0)
    {
        //gather input from the user 
        toggleError("unameError");
            return;   
    }

    if(document.getElementById('pass').value.length == 0)
    {
            toggleError("passError");
            return;
    }


    //create an object literal with it
    let uname = document.getElementById('uname').value;
    let pass = document.getElementById('pass').value;
    //print it to console

    //creating object literal
    let user = {
        username: uname,
        password: pass,
    }
    //this above is making a JS object

    //print to console
    console.log(user);

    let userJson = JSON.stringify(user);

    //sending a POST request to our backend using the FetchAPI
    //fetch returns a Promise
    //To work with that promise we need this to be an async function

    let res = await fetch(
        `${baseUrl}login`, //the url we're sending this request
         {
            method: 'POST',
            header: {'Content-Type': 'application/json'}, //this adds a header to our request that Javalin is going to see and know that the type of data is json
            body: userJson
         }
    );
    
    if(res.status === 404){
            toggleError(loginError);
    }     
    else if(res.status ===200){
    let resJson = await res.json() //conversion from json into another object
    //.then
         .then((resp) => {
            console.log(resp); //this is where we'll put DOM manipulation if needed

                sessionStorage.setItem('activeUser', JSON.stringify(resp));

                let user = resp;
                var values = Object.values(user);
                let accessLevel = values[4];

                if(accessLevel == 2){
                    window.location = 'http://localhost:8081/managerPage.html'
                }
                else{
                window.location = 'http://localhost:8081/homePage.html';
                }
            // window.location = 'https://localhost:8081/testpage.html/user/' + resp;
         })
         .catch((error)=>{console.log(error)});
    }

}

function toggleError(id){
    var x = document.getElementById(id);
    if(x.style.display === "none"){
        x.style.display="block";
    }
}

function validation(){

    
    return value;
}