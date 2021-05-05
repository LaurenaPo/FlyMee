function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}

function putServerData(url, datajson, success){
    $.ajax({
		type: "PUT",
		contentType: "application/json; charset=utf-8",
        dataType: "json",
		data: JSON.stringify(datajson),
        url: url
    }).done(success);
}

function createAnAccount() {
        /*
        rajouter l envoie d email automatique
        */
      window.location.href="newAccount.html";
}

function checkEmail(container) {

    var count = 0;
    var emailUser = $("#email").val();
    var password = $("#password").val();
    var pilot = document.getElementById("pilotcheck").checked;
    var data = { "email": emailUser, "password" : password };

    container.forEach(element => {
        if (element.email == emailUser) {
            count+=1;
        }
    });
    console.log(count);
    if (count == 0) {
        if (pilot == false) {
            putServerData("ws/users/signup",data,createAnAccount);
        }
        else{
            putServerData("ws/pilots/signup",data,createAnAccount);
        }
    }   
    else{
        alert("this email address is already taken");
    }      
}

$(function () {
    $("#buttonSignup").click(function () {
        var emailUser = $("#email").val();
        var password = $("#password").val();
        var password2 = $("#password2").val();
        if (emailUser !="") {
            if (password!="") {
                if (password == password2) {
                    getServerData("ws/users",checkEmail);
                }
                else{
                    alert("Our two passwords are not the same")
                }
            }
            else{
                alert("Please enter a password")
            }
        }
        else{
            alert("Please enter an Email")
        }
       
        
    });
  });

