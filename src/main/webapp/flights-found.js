$(function() {
    let url = new URL(window.location);
    let params = new URLSearchParams(url.search);

    let departureAerodrome = params.get('departureAerodrome');
    let departureDate = params.get('departureDate');

    if (departureAerodrome && departureDate) {
        
        $.ajax({        
            dataType: "json",
            url: `/ws/aerodromes/${departureAerodrome}/departure`
        }).done(data => {
            console.log(data);
        })
    }


});