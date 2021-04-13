  function getServerData(url, success){
      $.ajax({
          dataType: "json",
          url: url
      }).done(success);
  }
  
  function checkEmail(container) {
      if (container == true) {
        window.location.href="newPassword.html";
        /**
         * plus l'appel au webservice pour envoyer l'email
         */
      }
      else{
        alert("Veuillez rentrer un email correcte");
      }
  }
  
  
  $(function () {
    $("#buttonSend").click(function () {
      var email = $("#email").val();
      getServerData("ws/users/login/"+email,checkEmail);
      
    });
  });