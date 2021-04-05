
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

