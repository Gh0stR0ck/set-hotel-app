var formatType;
var formatStatus;
var formatSize;

var table =
    $('#roomTable').DataTable({
      "ajax":  {"url":"/api/Rooms/","dataSrc":""},
      "columns": [
          { "data": "roomNumber" },
          { "data": "roomType" },
          { "data": "roomSize"},
          { "data": "roomStatus" },
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
        roomType:       $("#roomType").val(),
        roomSize:       $("#roomSize").val(),
        roomStatus:     $("#roomStatus").val(),
    }

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
                var rowNode = table.row.add(result).draw().node();
                // Highlight row (timeout)
                $(rowNode).addClass('table-success');
                setTimeout(function () {
                    $(rowNode).removeClass('table-success');
                }, 3000);
                params.error = function (err) {
                    console.log(err);
                    alert("Error while adding room: " + err);
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
                params.error = function (err) {
                    console.log(err);
                    alert("Error while updating room: " + err);
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
            };
            params.error = function (err) {
                console.log(err);
                alert("Error while deleting room: " + err);
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
