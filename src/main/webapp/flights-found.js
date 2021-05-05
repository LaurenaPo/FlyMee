$(function() {
    let url = new URL(window.location);
    let params = new URLSearchParams(url.search);

    let departureAerodrome = params.get('departureAerodrome');
    let departureDate = params.get('departureDate');

    if (departureAerodrome && departureDate) {
        $.ajax({        
            dataType: "json",
            url: `/ws/aerodromes/${departureAerodrome}/departure`
        }).done(flights => {
            let flightTemplate = _.template($('#flightTemplate').html());
            for (const flight of flights) {
                let html = flightTemplate({
                    "departureAerodrome": flight.aerodromeDeparture,
                    "arrivalAerodrome": flight.aerodromeArrival,
                    "departureDate": `${flight.timeDeparture.year}-${String(flight.timeDeparture.monthValue).padStart(2, 0)}-${String(flight.timeDeparture.dayOfMonth).padStart(2,0)} ${String(flight.timeDeparture.hour).padStart(2,0)}:${String(flight.timeDeparture.minute).padStart(2,0)}`,     
                    "arrivalDate": `${flight.timeArrival.year}-${String(flight.timeArrival.monthValue).padStart(2,0)}-${String(flight.timeArrival.dayOfMonth).padStart(2,0)} ${String(flight.timeArrival.hour).padStart(2,0)}:${String(flight.timeArrival.minute).padStart(2,0)}`,  
                    "passengerCount": flight.placesNumber,
                    "price": flight.price,             
                })
                $("#flightsContainer").append(html)
            }
        })
    }
});