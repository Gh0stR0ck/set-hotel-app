var table =
    $('#reservationTable').DataTable({
      "ajax":  {"url":"/api/reservation/","dataSrc":""},
      "columns": [
          { "data": "reservationNumber" },
          {"data": "guestId"},
          {"data": "roomId"},
          {"data": "startDatePresentation"},
          {"data": "endDatePresentation"},
          {"data": "payment"},
          {"data": "startDateFormatted"},
          {"data": "endDateFormatted"},
          {"data": "guestName"},
          {"data": "roomName"}
        ],
        "columnDefs": [
            {
                "targets": [1, 2, 6, 7],
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
        // ReservationDTO
        reservationNumber: $("#reservationNumber").val(),
        guestId: $("#guest").val(),
        roomId: $("#room").val(),
        startDateFormatted: $("#startDate").val(),
        endDateFormatted: $("#endDate").val(),
        payment: $("#payment").val()
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
                // RELOAD DataTable
                table.ajax.reload();
                toastr["success"]('Reservation added.');
            };
            params.error = function (err) {
                    console.log(err);
                    toastr["error"](err.responseJSON.join('<br>'));
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
                toastr["success"]('Reservation updated.');
            };
            params.error = function (err) {
                    console.log(err);
                    toastr["error"](err.responseJSON.join('<br>'));
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
                toastr["success"]('Reservation deleted.');
            };
            params.error = function (err) {
                console.log(err);
                toastr["error"](err.responseJSON.join('<br>'));
            };
            break;

    }
    $.ajax(params);
}


function updateDropdownMenu(url, objName, objValue, elementName, elementTarget, initialText, label, sel) {
    // url           --> API url
    // objName       --> Text of dropdown item
    // objValue      --> Value of dropdown item
    // elementName   --> Name of the dropdown list to be generated
    // elementTarget --> Name of the element where it should be placed
    // initialText   --> Text like "select <guest>".
    // label         --> Form textlabel
    // sel           --> Selected item

    $("#" + elementTarget).empty()
        .append('<label for=\"' + elementName + '\" class=\"col-sm-3 col-form-label\">' + label + '</label>')
        .append('<select id=\"' + elementName + '\" class=\"custom-select col-sm-8\" ></select>');
    var selected = sel !== undefined ? 'selected' : '';
    $("#" + elementName).append('<option ' + selected + ' value=\"\">' + initialText + '</option>');

    $.get(url, function (result) {
        //console.log(url + " / " + result);
        $.each(result, function (key, value) {
            //console.log("l: " + value[objName[0]]);
            if (value[objName[0]] !== undefined) {
                var selected = (value[objValue] === sel) ? 'selected' : '';
                var optiontext = "";

                for (var i = 0; i < objName.length; ++i) {
                    //console.log("l2: " + value[objName[i]]);
                    optiontext += '' + value[objName[i]] + ' ';
                }

                $("#" + elementName).append('<option ' + selected + ' value=\"' + value[objValue] + '\">' + optiontext + '</option>');
            } else {
                console.log('No result for ' + value[objName]);
            }
        });
    })
}

// Show modal for updating reservation
$('#reservationTable tbody').on('click', 'tr', function () {
    var data = table.row(this).data();
    //console.log(data);
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
            updateDropdownMenu('/api/guest/', ['name', 'surname'], 'guestNumber', 'guest', 'guestinput', 'Select Guest', 'Guest', data['guestId']);
            updateDropdownMenu('/api/Rooms/', ['roomName'], 'roomNumber', 'room', 'roominput', 'Select Room', 'Room', data['roomId']);

            // initialize title and buttons
            $('#modalLabel').html('Edit reservation no. ' + data['reservationNumber'] + ' of "' + data['guestName'] + ' "');
            $('#reservationDeleteButton').show();
            $('#reservationSaveButton').show();
            $('#reservationAddButton').hide();

            //set start and end date fields
            $('#daterangepicker').data('daterangepicker').setStartDate(data['startDatePresentation']);
            $('#daterangepicker').data('daterangepicker').setEndDate(data['endDatePresentation']);
            $('#daterangepicker span').html(data['startDatePresentation'] + ' to ' + data['endDatePresentation']);


            break;

        default:
            // empty form
            $(':input', '#addReservation')
                .not(':button, :submit, :reset')
                .val('');
            updateDropdownMenu('/api/guest/', ['name', 'surname'], 'guestNumber', 'guest', 'guestinput', 'Select Guest', 'Guest');
            updateDropdownMenu('/api/Rooms/', ['roomName'], 'roomNumber', 'room', 'roominput', 'Select Room', 'Room');

            // initialize title and buttons
            $('#modalLabel').html('Add new reservation');
            $('#reservationDeleteButton').hide();
            $('#reservationSaveButton').hide();
            $('#reservationAddButton').show();

            $('#daterangepicker').data('daterangepicker').setStartDate();
            $('#daterangepicker').data('daterangepicker').setEndDate();
            $('#daterangepicker span').html('');


            break;
    }

    // show modal
    $("#reservationModal").modal('toggle');
}

//Datepickers
$('#daterangepicker').daterangepicker({
    "autoApply": true,
    "opens": "center",
    "locale": {
        "format": "DD/MM/YY"
    }
}, function (start, end, label) {
    console.log('s: ' + start + '  e: ' + end);
    $('#daterangepicker span').html(start.format('DD/MM/YY') + ' to ' + end.format('DD/MM/YY'));
    $('#startDate').val(start.format('DD/MM/YY') + 'T16:00');
    $('#endDate').val(end.format('DD/MM/YY') + 'T10:00');

});
