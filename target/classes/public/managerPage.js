let baseUrl = "http://localhost:8081/";

function managerCheck(){
    var currentUser = JSON.parse(sessionStorage.getItem('activeUser'));
    var values = Object.values(currentUser);

    console.log(currentUser);
    console.log(values);

    let name = values[3];
    document.getElementById("namefield").innerHTML = "Hello, Finance Manager: " + name + ". What would you like to do today?";
    
}

function toEmpLookup(){
    
    window.location = 'http://localhost:8081/employeeLookup.html'
}

function toEmployeePage(){
    
    window.location = 'http://localhost:8081/homePage.html'
}

function toAllRequestsM(){

    window.location = 'http://localhost:8081/managerRequestPage.html'
}