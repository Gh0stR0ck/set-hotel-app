var table =
    $('#reservationTable').DataTable({
      "ajax":  {"url":"/api/reservation/","dataSrc":""},
      "columns": [
          { "data": "reservationNumber" },
          { "data": "guest" },
          { "data": "room" },
          { "data": "startDate" },
          { "data": "endDate" },
          { "data": "payment" }
        ],
        "columnDefs": [
            {
                "targets": [ 0 ],
                "visible": false,
                "searchable": false
            }
        ],
        "order": [[0, 'desc']],
       "pageLength": 10,
         "bLengthChange": false,
         "language": {
             "info": "Showing reservations _START_ to _END_ of _TOTAL_ "
             }
    } );


function handleReservation (type) {

    var obj = {
        reservationNumber:  parseInt($("#reservationNumber").val(),10),
        guestNumber:        $("#guest").val(),
        room:               parseInt($("#room").val(),10),
        startdate:          $("#startdate").val(),
        enddate:            $("#enddate").val(),
        payment:            $("#payment").val()
    }

    var params = {
        url: "/api/reservation/",
        data: JSON.stringify(obj),
        contentType: "application/json; charset=utf-8"
    };

    switch (type) {
        case 'post':

            params.type = "POST";
            params.success = function (result) {
                console.log(result);
                // toggle modal
                $("#reservationModal").modal('toggle');
                // add to DataTable
                var rowNode = table.row.add(result).draw().node();
                // Highlight row (timeout)
                $(rowNode).addClass('table-success');
                setTimeout(function () {
                    $(rowNode).removeClass('table-success');
                }, 3000);
                params.error = function (err) {
                    console.log(err);
                    alert("Error while adding reservation: " + err);
                }
            };
            break;

        case 'update':
            params.type = "PUT";
            params.success = function (result) {
                console.log(result);
                // toggle modal
                $("#reservationModal").modal('toggle');
                // Refresh DataTable
                table.ajax.reload();
                params.error = function (err) {
                    console.log(err);
                    alert("Error while updating reservation: " + err);
                }
            };
            break;

        case 'delete':
            params.type = "DELETE";
            params.success = function (result) {
                console.log(result);
                // Toggle modal
                $("#reservationModal").modal('toggle');
                // Reload DataTable
                table.ajax.reload();
            };
            params.error = function (err) {
                console.log(err);
                alert("Error while deleting reservation: " + err);
            };
            break;

    }
    $.ajax(params);
}


// Show modal for updating reservation
$('#reservationTable tbody').on('click', 'tr', function () {
    var data = table.row(this).data();
    console.log(data);
    showReservationModal('modify', data);
});

// Show modal for adding reservations
$('#addReservationButton').on('click', function () {
    showReservationModal('add');
});

function showReservationModal(format, data) {
    // Populates inputfields and buttons based on format (String)
    // data id optional.
    switch (format) {
        case 'modify':

            // populate form
            $.each(data, function (key, value) {
                $('#addReservation').find("input[id='" + key + "']").val(value);
            });
            // initialize title and buttons
            $('#modalLabel').html('Edit reservation "' + data['guest.name'] + ' "');
            $('#reservationDeleteButton').show();
            $('#reservationSaveButton').show();
            $('#reservationAddButton').hide();
            break;

        default:
            // empty form
            $(':input', '#addReservation')
                .not(':button, :submit, :reset')
                .val('');

            // initialize title and buttons
            $('#modalLabel').html('Add new reservation');
            $('#reservationDeleteButton').hide();
            $('#reservationSaveButton').hide();
            $('#reservationAddButton').show();
            break;
    }

    // show modal
    $("#reservationModal").modal('toggle');
}