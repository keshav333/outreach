var api = "webapi/domain";
$.get(api, function (domain, status) {
    if (status == "success") {
        var domainOptions = "";
        for (var i = 0; i < domain.length; i++) {
            domainOptions += '<option value="' + domain[i].id + '">' + domain[i].discipline + ' ' + domain[i].branch + '</option>';
        }
        $("#domainId").append(domainOptions);
    }
});

function previewFile() {
    var preview = document.getElementById('preview');
    var fileName = $(".custom-file-label");
    var file = document.querySelector('input[type=file]').files[0]; //sames as here
    var reader = new FileReader();

    reader.onloadend = function () {
        preview.src = reader.result;
        fileName.html(file.name);
    };

    if (file) {
        reader.readAsDataURL(file); //reads the data as a URL
    } else {
        preview.src = "images/placeholder.png";
        fileName.html("Photograph");
    }
}

var api = "webapi/domain/getdomain";
$.get(api, function (domain, status) {
    if (status == "success") {
        var domainOptions = "";
        console.log(domain);
        for (var i = 0; i < domain.length; i++) {
            domainOptions += '<option value="' + domain[i].id + '">' + domain[i].name + '</option>';

        }
        console.log(domainOptions);
        $("#domainId").append(domainOptions);
    }
});

var api = "webapi/special/getspecial";
$.get(api, function (specs, status) {
    if (status == "success") {
        var specOptions = "";
        console.log(specs);
        for (var i = 0; i < specs.length; i++) {
            specOptions += '<option value="' + specs[i].id + '">' + specs[i].name + '</option>';

        }
        console.log(specOptions);
        $("#specId").append(specOptions);
    }
});