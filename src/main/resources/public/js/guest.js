function loadGuestList(){
    $.get("/api/guest", function(result){
        console.log(result);
        //$("#guestTable").empty();
        //$("#hotel_content").html("<pre>"+ JSON.stringify(result, undefined, 4) + "</pre>");
        drawTable(result);

        var table = $('#guestTable').DataTable({
                                                   "pageLength": 10,

                                                   "bLengthChange": false,
                                                   "language": {
                                                       "info": "Showing guests _START_ to _END_ of _TOTAL_ "
                                                       }
                                               });

        $('#guestTable tbody').on('click', 'tr', function () {
            var data = table.row( this ).data();
            alert( 'You clicked on '+data[1]+'\'s row' );
        } );
    });
}

function drawTable(data) {
    for (var i = 0; i < data.length; i++) {
        drawRow(data[i]);
    }
}

function drawRow(rowData) {
    var row = $("<tr />")
    $("#guestTable").append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
    row.append($("<td>" + rowData.name + "</td>"));
    row.append($("<td>" + rowData.surname + "</td>"));
    row.append($("<td>" + rowData.address + "</td>"));
    row.append($("<td>" + rowData.zipcode + "</td>"));
    row.append($("<td>" + rowData.city + "</td>"));
    row.append($("<td>" + rowData.country + "</td>"));
    row.append($("<td>" + rowData.phone + "</td>"));
    row.append($("<td>" + rowData.email + "</td>"));
}


loadGuestList();
console.log( "ready!" );

$(document).ready(function() {

} );
