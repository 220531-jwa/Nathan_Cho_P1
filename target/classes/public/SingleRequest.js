function pullUpRequest(){
    let ticket = JSON.parse(sessionStorage.getItem('selectedRequest'));
    var values = Object.values(ticket);
    let requestID = values[10];

    console.log(ticket);

    document.getElementById("requestName").innerHTML = "Displaying Reimbursement Request Information for Request ID = " + requestID;

    var tbody = document.getElementById("requestTable");

    var subTime = new Date(parseInt(ticket.submissionTime));
        var sub = (subTime.getMonth() + 1)+'/'+ subTime.getDate() + '/' + subTime.getFullYear();

    var eventTime = new Date(parseInt(ticket.eventDate));
        var eve = (eventTime.getMonth() + 1)+'/'+ eventTime.getDate() + '/' + eventTime.getFullYear();

    tbody.innerHTML = 
        `
            <tr><th>Subject</th><td>${ticket.subject}</td></tr>
            <tr><th>Status</th><td>${ticket.status}</td></tr>
            <tr><th>Submission Date</th><td>${sub}</td></tr>
            <tr><th>Event Type</th><td>${ticket.eventType}</td></tr>
            <tr><th>Grade</th><td>${ticket.grade}</td></tr>
            <tr><th>Location</th><td>${ticket.location}</td></tr>
            <tr><th>Event Time</th><td>${eve}</td></tr>
            <tr><th>Amount</th><td>${ticket.cost}</td></tr>
            <tr><th>Description</th><td>${ticket.description}</td></tr>
            `

        //NEED TO FIX HOW TIME SHOWS
}

function toHome(){
    window.location = 'http://localhost:8081/homePage.html';
}

function toViewAll(){
    window.location = 'http://localhost:8081/viewRequests.html'
}

function toNewRequest(){
    window.location = 'http://localhost:8081/submitNewRequest.html'
}

function editRequest(){

}