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

async function loadRequests(){

    let res = await fetch(
        `${baseUrl}manager/requests`,
        {
            method: 'GET'
        }
    );

    let resJson = await res.json()
        .then((resp) => {
            console.log(resp);
            var tbody = document.getElementById("requests");

            tbody.innerHTML = 
            `<tr>
                <th>ID</th>
                <th>Subject</th>
                <th>Submission Time</th>
                <th>Status</th>
                <th>Grade</th>
            </tr>
            `

            for(var i = 0; i <resp.length; i++){
                var subTime = new Date(parseInt(resp[i].submissionTime));
                var sub = (subTime.getMonth() + 1)+'/'+ subTime.getDate() + '/' + subTime.getFullYear();
                
                tbody.innerHTML +=
                `
                    <tr>
                        <td>
                            <button id="id1" onclick="setReq('${resp[i].id}')"> ${resp[i].id} </button>
                        </td>
                        <td>${resp[i].subject}</td>
                        <td>${sub}</td>
                        <td>${resp[i].status}</td>
                        <td>${resp[i].grade}</td>
                    </tr>
                `
            }
        })
}

function setReq(val){
    sessionStorage.setItem('managerRequestNum', val);
    window.location = 'http://localhost:8081/managerSingleView.html';
}
