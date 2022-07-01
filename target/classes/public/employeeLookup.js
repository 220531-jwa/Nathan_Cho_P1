let baseUrl = "http://localhost:8081/";

async function lookup(){

    errorsOff();

    var lookupID = document.getElementById("employeeNum").value;

    let res = await fetch(
        `${baseUrl}user/${lookupID}`,
        {
            method: 'GET'
        }
    );
    
    if(res.status === 404){
        toggleError("notFound");
        return;
    }

    let resJson = await res.json()
        .then((resp) => {

            sessionStorage.setItem('targetEmployee', resp);
            document.getElementById("nameHere").innerHTML= `Showing reimbursement requests for: ${resp.name}`;
            pullRequests(resp);
        })
        .catch((error) => {console.log(error)});
}

async function pullRequests(user){
    console.log(user);

    clearTable();

    var userid = user.id;
    
    let res = await fetch(
        `${baseUrl}requests/${userid}`,
        {
            method: 'GET',
            header: {'Content-Type': 'application/json'}
        }
    );

    if(res.status === 404){
        toggleError("notFound");
        return;
    }

    let resJson = await res.json()
        .then((resp) => {
            console.log(resp);
            var tbody = document.getElementById("requestsTable");
            

            tbody.innerHTML = 
            `
                <tr>
                    <th>ID</th>
                    <th>Subject</th>
                    <th>Submission Time</th>
                    <th>Status</th>
                    <th>Grade</th>
                </tr>
            `

            for(var i = 0; i < resp.length; i++){
                
                var subTime = new Date(parseInt(resp[i].submissionTime));
                var sub = (subTime.getMonth() + 1)+'/'+ subTime.getDate() + '/' + subTime.getFullYear();
                
                tbody.innerHTML +=
                `
                    <tr>
                        <td>
                        <button class="btn btn-outline-primary" id="id1" onclick="setReq('${resp[i].id}')"> ${resp[i].id} </button>
                    </td>
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

function setReq(val){
    sessionStorage.setItem('managerRequestNum', val);
    window.location = 'http://localhost:8081/managerSingleView.html';
}

function toggleError(id){
    var x = document.getElementById(id);
    if(x.style.display == "none"){
        x.style.display="block";
    }
}

function errorsOff(){
    var x = document.getElementById("notFound");
    x.style.display = "none";
}

function clearTable(){
    document.getElementById("requestsTable").innerHTML = "";
}