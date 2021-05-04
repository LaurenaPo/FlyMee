function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}

function postServerData(url, data, success){
    $.ajax({
		type: "POST",
		contentType: "application/json; charset=utf-8",
        dataType: "json",
		data: data,
        url: url
    }).done(success);
}

function createAnAccount(container) {
    if (container == true) {
        /*
        rajouter l envoie d email automatique
        */
      window.location.href="newAccount.html";
    }
    else{
      alert("An error has occurred, please try again");
    }
}

function checkEmail(container) {

    var count = 0;
    var emailUser = $("#email").val();
    var password = $("#password").val();
    var pilot = document.getElementById("pilotcheck").checked;

    container.forEach(element => {
        if (element.email == emailUser) {
            count+=1;
            /**
            * plus l'appel au webservice pour envoyer l'email
            */
        }
    });
    console.log(count);
    if (count == 0) {
        postServerData("ws/users/signup/"+emailUser +"/" + password + "/" + pilot,emailUser,createAnAccount);
    }   
    else{
        alert("this email address is already taken");
    }      
}

$(function () {
    $("#buttonSignup").click(function () {
        var password = $("#password").val();
        var password2 = $("#password2").val();

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
        
    });
  });

