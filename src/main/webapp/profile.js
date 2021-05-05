function success(data) {
  $("#name_and_role").text()
  $("#email_address").text() 
  $("#date_of_birth").text() 
  $("#weight").text() 
  $("#description").text()
}

function getServerData(url, success){
  $.ajax({
      url: "/ws/users/"
  }).done(success);
}

$(function() {
  let userId = sessionStorage.getItem("UserID") ?? 1;
  $.ajax({
    url: `/ws/users/${userId}`
  }).done(data=>{
    $("#name_and_role").html(`${data.firstName} - ${data.lastName}<br>Passenger`)
    $("#email_address").text(`${data.email}`)
    $("#date_of_birth").text(`${data.dateOfBirth.dayOfMonth}-${data.dateOfBirth.monthValue}-${data.dateOfBirth.year}`)
    $("#weight").text(`${data.weight} kg`)
    $("#description").text(`${data.description ?? "No description"}`)
    console.log(data)
  });
});