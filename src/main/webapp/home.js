$(function() {
  $("#datepicker").datepicker();
} );

$(function() {
  $.get("/ws/aerodromes").done(aerodromes => {    
    let availableTags = aerodromes.map(x => x.name);
    $( "#tags" ).autocomplete({
      source: availableTags
    });
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

function callDone(result){
	var templateExample = _.template($('#templateExample').html());

	var html = templateExample({
		"attribute":JSON.stringify(result)
	});

	$("#result").append(html);
}

$(function(){
	$("#getButton").click(function(){
		getServerData("ws/users", callDone);
	});
	$("#deleteButton").click(function(){
		deleteServerData("ws/users/1", callDone);
	});
	
});

function fillTable(container) {
    var template = _.template($('#templateRow').html());
    var result = "";

    container.actions.forEach(action => result += template(action));

    $("#result").html(result);
}


$(function () {
  $("#buttonSearch").click(function () {
    let departure = $("#tags").val();
    let date = $("#datepicker").val();
    let myDate = date.split("/");
    let newDate = myDate[2] +"-"+ myDate[0]+"-"+myDate[1];
    
    if(departure !== "" && date !== ""){       
      localStorage.setItem('departureAerodrome', departure);
      localStorage.setItem('departureDate', newDate);
      window.location.href="flights-found.html";
    }

  });
});

