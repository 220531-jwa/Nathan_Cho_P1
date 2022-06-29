let baseUrl = "http://localhost:8081/";

async function submitRequest() {
    if(check("subj") || check("evdate") || check("cost")){
        toggleError("emptyFieldError");
        console.log('entry field error');
        return;
    }

    let subj = document.getElementById("subj").value;
    let desc = document.getElementById("desc").value;
    let evdate = document.getElementById("evdate").value;
    let loca = document.getElementById("loca").value;
    let cost = document.getElementById("cost").value;
    let evtype = document.getElementById("evtype").value;
    let grade = document.getElementById("grade").value;

    let ticket = {
        subject: subj,
        description: desc,
        eventDate: evdate,
        location: loca,
        cost: cost,
        eventType: evtype,
        grade: grade
    }

    let userJson = JSON.stringify(ticket);
   
    let user = JSON.parse(sessionStorage.getItem('activeUser'));
    var values = Object.values(user);
    let userID = values[2];

    let res = await fetch(
        `${baseUrl}submitRequest/${userID}`,
        {
            method: 'POST',
            header: {'Content-Type': 'applicaiton/json'},
            body: userJson
        }
    );

    let resJson = await res.json()
        .then((resp) => {
            console.log(resp);
            sessionStorage.setItem('selectedRequest', JSON.stringify(resp));
            window.location = 'http://localhost:8081/SingleRequest.html';
        })
        .catch((error) => {console.log(error)})
}

function check(check){
    if(document.getElementById(check).value == null){
        return true;
    }
    else {
        return false;
    }
}

function toggleError(id){
    var x = document.getElementById(id);
    if(x.style.display === "none"){
        x.style.display="block";
    }
}