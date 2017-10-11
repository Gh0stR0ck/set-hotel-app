var table =
    $('#roomTable').DataTable({
      "ajax":  {"url":"/api/Rooms/","dataSrc":""},
      "columns": [
          { "data": "roomNumber" },
          {"data": "roomName"},
          { "data": "roomType.label" },
          { "data": "roomSize.label"},
          { "data": "roomStatus.label" }
        ],
        "columnDefs": [
            {
                "targets": [0],
                "visible": false,
                "searchable": false
            }
        ],
        "order": [[0, 'desc']],
       "pageLength": 10,
         "bLengthChange": false,
         "language": {
             "info": "Showing rooms _START_ to _END_ of _TOTAL_ "
             }
    } );


function handleRoom(type) {

    var obj = {
        roomNumber:     $("#roomNumber").val(),
        roomName: $("#roomName").val(),
        roomType:       { name: $("#roomType").val() },
        roomSize:       { name: $("#roomSize").val() },
        roomStatus:     { name: $("#roomStatus").val() },
    }

    console.log(obj);

    var params = {
        url: "api/Rooms/",
        data: JSON.stringify(obj),
        contentType: "application/json; charset=utf-8"
    };

    switch (type) {
        case 'post':

            params.type = "POST";
            params.success = function (result) {
                console.log(result);
                // toggle modal
                $("#roomModal").modal('toggle');
                // add to DataTable
//                var rowNode = table.row.add(result).draw().node();
//                // Highlight row (timeout)
//                $(rowNode).addClass('table-success');
//                setTimeout(function () {
//                    $(rowNode).removeClass('table-success');
//                }, 3000);
                table.ajax.reload();
                toastr["success"]('Room ' + result["roomNumber"] + ' added.');

                params.error = function (err) {
                    console.log(err);
                    toastr["error"]('Error: ' + err);
                }
            };
            break;

        case 'update':
            params.type = "PUT";
            params.success = function (result) {
                console.log(result);
                // toggle modal
                $("#roomModal").modal('toggle');
                // Refresh DataTable
                table.ajax.reload();
                toastr["success"]('Room ' + result["roomNumber"] + ' updated.')

                params.error = function (err) {
                    console.log(err);
                    toastr["error"]('Error: ' + err);
                }
            };
            break;

        case 'delete':
            params.type = "DELETE";
            params.success = function (result) {
                console.log(result);
                // Toggle modal
                $("#roomModal").modal('toggle');
                // Reload DataTable
                table.ajax.reload();
                toastr["success"]('Room ' + result["roomNumber"] + ' deleted.')

            };
            params.error = function (err) {
                console.log(err);
                toastr["error"]('Error deleting room: ' + err);
            };
            break;

    }
    $.ajax(params);
}


// Show modal for updating rooms
$('#roomTable tbody').on('click', 'tr', function () {
    var data = table.row(this).data();
    console.log(data);
    showRoomModal('modify', data);
});

// Show modal for adding rooms
$('#addRoomButton').on('click', function () {
    showRoomModal('add');
});

function showRoomModal(format, data) {
    // Populates inputfields and buttons based on format (String)
    // data id optional.
    switch (format) {
        case 'modify':

            // populate form
            $.each(data, function (key, value) {
                $('#addRoom').find("input[id='" + key + "']").val(value);
            });
            // initialize title and buttons
            $('#modalLabel').html('Edit room');
            $('#roomDeleteButton').show();
            $('#roomSaveButton').show();
            $('#roomAddButton').hide();
            break;

        default:
            // empty form
            $(':input', '#addRoom')
                .not(':button, :submit, :reset')
                .val('');

            // initialize title and buttons
            $('#modalLabel').html('Add new room');
            $('#roomDeleteButton').hide();
            $('#roomSaveButton').hide();
            $('#roomAddButton').show();
            break;
    }

    // show modal
    $("#roomModal").modal('toggle');
}
