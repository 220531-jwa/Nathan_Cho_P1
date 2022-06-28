let baseUrl = "http://localhost:8081/";

let user = JSON.parse(sessionStorage.getItem('activeUser'));
    var values = Object.values(user);
    let userid = values[2];

async function getRequests(){

    let res = await fetch(
        `${baseUrl}requests/${userid}`,
        {
            method: 'GET',
            header: {'Content-Type': 'application/json'}
        }
    );

    let resJson = await res.json()
        .then((resp) => {
            console.log(resp);
            var tbody = document.getElementById("requestsTable");

            for(var i = 0; i < resp.length; i++){
                
                var subTime = new Date(parseInt(resp[i].submissionTime));
                var sub = (subTime.getMonth() + 1)+'/'+ subTime.getDate() + '/' + subTime.getFullYear();
                
                tbody.innerHTML +=
                `
                    <tr>
                        <td>${resp[i].id}</td>
                        <td>${resp[i].subject}</td>
                        <td>${sub}</td>
                        <td>${resp[i].status}</td>
                        <td>${resp[i].grade}</td>
                    </tr>
                `
            }
        })
        .catch((error) => {console.log(error)})

}

async function pullSingleRequest(){
    let reqid = document.getElementById("reqID").value;

    //add code to verify that the id input is a number.

    let res = await fetch(
        `${baseUrl}requests/${userid}/${reqid}`,
        {
            method: 'GET',
            header: {'Content-Type': 'application/json'}
        }
    );

    let resJson = await res.json()
        .then((resp) => {
            console.log(resp);
            sessionStorage.setItem('selectedRequest', JSON.stringify(resp));
            window.location = 'http://localhost:8081/SingleRequest.html'
        })
        .catch((error) => {console.log(error)})
}

function goToHome(){
    window.location = 'http://localhost:8081/homePage.html';
}