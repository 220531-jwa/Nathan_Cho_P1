let baseUrl = "http://localhost:8081/";


async function setManagedRequest(){

    var sessId = sessionStorage.getItem('managerRequestNum');

    let res = await fetch(
        `${baseUrl}manager/requests/${sessId}`,
        {
            method: 'GET'
        }
    );

    let resJson = await res.json()
        .then((resp) => {
            sessionStorage.setItem('activeReqObj', JSON.stringify(resp));

            let ticket = resp;
            var values = Object.values(ticket);
            let requestID = values[10];
            let requestUserID = values[9];

            getName(requestUserID);

            console.log(ticket);

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
                    <tr><th>Amount to be Reimbursed</th><td>${ticket.cost}</td></tr>
                    <tr><th>Description</th><td>${ticket.description}</td></tr>
                    `
        })
        .catch((error) => {console.log(error)})

}

async function getName(id){
    let res = await fetch(
        `${baseUrl}user/${id}`,
        {
            method: 'GET'
        }
    );
    
    let resJson = await res.json()
        .then((resp) => {
            document.getElementById("requestOwner").innerHTML = `Displaying Employee:${resp.name}'s request. Employee ID = ${resp.id}`;
        });
}

async function giveResponse(){

}

async function statusUpdate(){

    console.log(sessionStorage.getItem('activeReqObj'));
    let ticket = JSON.parse(sessionStorage.getItem('activeReqObj'));
    var values = Object.values(ticket);
    let reqID = values[10];

    var newStatus = document.getElementById("newStatus").value;

    let res = await fetch(
        `${baseUrl}manager/requests/${reqID}`,
        {
            method: 'PUT',
            header: {'Content-Type': 'application/json'},
            body: newStatus
        }
    );

    let resJson = await res.json()
        .then((resp) => {
            console.log(resp);
            sessionStorage.setItem('activeReqObj', resp)
            window.location = 'http://localhost:8081/managerSingleView.html';
        })
        .catch((error) => {console.log(error)});
}


