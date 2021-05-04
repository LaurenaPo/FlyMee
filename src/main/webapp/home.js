
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
    var id = $("#tags").val();
    var date = $("#datepicker").val();
    var myDate = date.split("/");
    var newDate = myDate[2] +"-"+ myDate[1]+"-"+myDate[1];
    if (id == '') {
        getServerData("ws/flights/", fillTable);
    }
    else if ( myDate[1]==undefined ||  myDate[2]==undefined ||  myDate[0]==undefined) {
        getServerData("ws/flights/search/" + id, fillTable);
    }
    else{
        getServerData("ws/flights/" + id +"/"+ newDate, fillTable);
    }
    window.location.href="research.html";
  });
});


