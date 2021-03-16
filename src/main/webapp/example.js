
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