
$( function() {
  $( "#datepicker" ).datepicker();
} );

$( function() {
  var availableTags = [
    "AerodromeA",
    "AerodromeB",
    "AerodromeC",
    "AerodromeD",
  ];
  $( "#tags" ).autocomplete({
    source: availableTags
  });
} );

function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}

function deleteServerData(url, success){
    $.ajax({
    	method: "DELETE",
        dataType: "json",
        url: url
    }).done(success);
}

function putServerData(url, data, success){
    $.ajax({
		type: "PUT",
		contentType: "application/json; charset=utf-8",
        dataType: "json",
		data: data,
        url: url
    }).done(success);
}

function fillTable(container) {
  console.log(container);
  var html="";
  html = html + "<table class='table table-striped'";
  html = html + "<thead class='thead-inverse'><tr>";
  html = html + "<th scope='col'>aerodrome Departure</th><th scope='col'>Aerodrome arrival</th>"
  +"<th scope='col'>Day</th><th scope='col'>Time departure</th><th scope='col'>Time Arrival</th>"
  +"<th scope='col'>Places Number</th><th scope='col'>Places Taken</th>"
  +"<th scope='col'>MeetingPlace</th><th scope='col'>Reserved</th>";
  html = html + "</thead></tr>";
  html = html + "<tbody>";
  container.forEach(function (container) {
      html = html + "<tr>";
      html =html + "<td>" + container.aerodromeDeparture + "</td><td>" + container.aerodromeArrival + "</td><td>" 
      + container.timeDeparture.dayOfWeek +" "+ container.timeDeparture.dayOfMonth + " "+ container.timeDeparture.month+ "</td><td>" + container.timeDeparture.hour + ":"+ container.timeDeparture.minute+ "</td><td>" 
      + container.timeArrival.hour + ":"+ container.timeArrival.minute + "</td><td>"
      + container.placesNumber + "</td><td>" +container.placesTaken + "</td><td>" + container.meetingPlace + "</td><td>" + "<a class=nav-link href=login.html>LOGIN</a>" +  "</td>";
      html = html + "</tr>";
  }); html = html + "</tbody>";
  html = html + "</table>";
  console.log(html);
  document.getElementById('resultat').innerHTML = html;
  window.location.href = "#output"
}

function checkFlight(container) {
  var date = $("#datepicker").val();
  var myDate = date.split("/");
  var newDate = [{}];
  container.forEach(function (container) {
    if (myDate[0] == container.timeDeparture.dayOfMonth && myDate[1].aerodromeDeparture.timeDeparture.month && myDate[2] == container.timeDeparture.year) {
      newDate.push(container)
    }
  });
  if (newDate == [{}]) {
    alert("There is no flight with at this date");
  }
  fillTable(newDate);
}

$(function () {
  $("#buttonSearch").click(function () {
    var id = $("#tags").val();
    var date = $("#datepicker").val();
    var myDate = date.split("/");
    if (id == '') {
      getServerData("ws/flights/", fillTable);
    }
    else if ( myDate[1]==undefined ||  myDate[2]==undefined ||  myDate[0]==undefined) {
        getServerData("ws/aerodromes/"+ id +"/departure", fillTable);
    }
    else{
        getServerData("ws/flights/", checkFlight);
    }
  });
});

$(function () {
  $("#buttonSearch").click(function () {
    if(getComputedStyle(output).display == "none"){
      output.style.display = "block";
    } 
  });
});