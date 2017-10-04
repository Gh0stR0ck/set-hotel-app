function loadGuestList(){

    $('#guestTable').dataTable( {
      "ajax":  {"url":"/api/guest","dataSrc":""},
      "columns": [
          { "data": "guestNumber" },
          { "data": "surname" },
          { "data": "name" },
          { "data": "address" },
          { "data": "zipcode" },
          { "data": "city" },
          { "data": "country" },
          { "data": "phone" },
          { "data": "email" }
        ],
        "columnDefs": [
            {
                "targets": [ 0 ],
                "visible": false,
                "searchable": false
            }
        ],
       "pageLength": 10,
         "bLengthChange": false,
         "language": {
             "info": "Showing guests _START_ to _END_ of _TOTAL_ "
             }
    } );

}


function handleAddGuest(){

    var obj = {
        name:       $("#name").val(),
        surname:    $("#surname").val(),
        address:    $("#address").val(),
        zipcode:    $("#zipcode").val(),
        city:       $("#city").val(),
        country:    $("#country").val(),
        phone:      $("#phone").val(),
        email:      $("#email").val()
    }



    $.ajax({
        url: "/api/addUser",
        type: "POST",
        data: JSON.stringify(obj),
        contentType: "application/json; charset=utf-8",
        success: function(result) {
            console.log(result);

            // toggle
            $("#guestModal").modal('toggle');

            // empty form for reuse
            $(':input','#addGuest')
              .not(':button, :submit, :reset, :hidden')
              .val('')
              .removeAttr('checked')
              .removeAttr('selected');

            // add to DataTable
              var table = $('#guestTable').DataTable();
              var rowNode = table
                  .row.add( result )
                  .draw()
                  .node();

              $( rowNode ).addClass( 'highlight' );
              setTimeout(function() {
                  $( rowNode ).removeClass( 'highlight' );
              },3000);


    },
        error: function(err) {
        console.log(err);
        alert("Error while adding guest: " + err);
    }
    });
}


loadGuestList();


