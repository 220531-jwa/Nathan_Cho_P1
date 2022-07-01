function loadid(){
    console.log(sessionStorage.getItem('activeUser'));
}



function insertname(){
    let user = JSON.parse(sessionStorage.getItem('activeUser'));
    var values = Object.values(user);
    console.log(user);
    console.log(values);
    let name = values[3];
    let id = user.id;
    document.getElementById("namefield").innerHTML = "Hello " + name + ", ID: " + id + ", What would you like to do today?";
}

function viewrequests(){
    window.location = 'http://localhost:8081/viewRequests.html'
}

function submitnewrequest(){
    window.location = 'http://localhost:8081/submitNewRequest.html'
}

function logout(){
    sessionStorage.removeItem('activeUser');
    window.location = 'http://localhost:8081/loginPage.html';
}