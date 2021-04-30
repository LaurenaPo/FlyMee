function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}

function checkEmail(container) {
    var count = 0;
    var emailUser = $("#email").val();
    container.forEach(element => {
        if (element.email == emailUser) {
            window.location.href="newPassword.html";
            count+=1;
            /**
            * plus le code pour l'email
            */
        }
    });
    if (count == 0) {
        alert("Our email address is incorect");
    }     
}

$(function () {
  $("#buttonSend").click(function () {
    getServerData("ws/users",checkEmail);
  });
});