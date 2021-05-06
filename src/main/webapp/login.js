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
		data: JSON.stringify(data),
    url: "/ws/users/login"
  }).done(user => {
    sessionStorage.setItem("UserID", user.id)
    sessionStorage.setItem("user", JSON.stringify(user))

    window.location.href="home-user.html";
  });

  event.preventDefault();
})