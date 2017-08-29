$(
    $(function() {
        function check_update() {
            $.ajax({
                url: "/index/version"
            }).done(function (data) {
                if (data != $("#version").text()) {
                    location.reload();
                }
                else {
                    $("#log").prepend("Checked version at " + new Date().toLocaleString() + ".<br/>");
                    setTimeout(check_update, 1000);
                }
            })
        }

        setTimeout(check_update, 1000);
    })
);