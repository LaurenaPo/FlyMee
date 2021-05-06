$('#loginForm').submit(event => {

  let email = $("#login").val();
  let password = $("#password").val();

  let data = {
    "email": email,
    "password": password
  }

  $.ajax({
    method: "POST",
		contentType: "application/json; charset=utf-8",
        dataType: "json",
		data: data,
    url: "/ws/users/login"
  }).done(user => {
    console.log(user);
  });
  
  event.preventDefault();
})