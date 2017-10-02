function loadGuestList(){
    $.get("/api/guest", function(result){
        console.log(result);
        //$("#dataTableBody").empty();
        //$("#hotel_content").html("<pre>"+ JSON.stringify(result, undefined, 4) + "</pre>");
        drawTable(result);
    });
}

function drawTable(data) {
    for (var i = 0; i < data.length; i++) {
        drawRow(data[i]);
    }
}

function drawRow(rowData) {
    var row = $("<tr />")
    $("#dataTable").append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
    row.append($("<td>" + rowData.guestNumber + "</td>"));
    row.append($("<td>" + rowData.name + "</td>"));
    row.append($("<td>" + rowData.surname + "</td>"));
}


loadGuestList();
console.log( "ready!" );
