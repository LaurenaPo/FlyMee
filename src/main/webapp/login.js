function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}

function checkLogin(container) {

    var emailUser = $("#login").val();
    var passwordUser = $("#password").val();
    var count = 0;
    
    container.forEach(element => {
        if (element.email == emailUser) {
            if (element.password == passwordUser) {
              window.location.href="newPassword.html";
              count+=1;
            }
        }
    });
    if (count == 0) {
        alert("Our email address or our password is incorect");
    } 
}

function goToHome(container) {
    if (container == true) {
      window.location.href="home.html";
    }
    else{
      alert("an error as occured, retry in a few minutes");
    }
}


$(function () {
  $("#buttonLogin").click(function () {
    getServerData("ws/users",checkLogin);
    
  });
});

$(function () {
    $("#buttonLogout").click(function () {
      getServerData("ws/users/logout",goToHome);
    });
  });
  