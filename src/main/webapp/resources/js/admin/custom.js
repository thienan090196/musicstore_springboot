$(document).ready(function () {
    //trim space
    $("#title").on("change", function () {
        $("#title").prop("value", $.trim($("#title").val()));
    })

    //preview image
    $("#file").change(function () {
        var listValidFileType = ["image/jpg", "image/jpeg", "image/gif", "image/png"];
        var fileList = this.files;
        var count = 0;
        $(".preview-image").empty();
        for (var index = 0; index < fileList.length; index++) {
            if (listValidFileType.indexOf(fileList[index].type) == -1 || fileList[index].size > 5242880) {
                count++;
            }
        }
        if (count != 0) {
            if (fileList[0].size > 5242880) {
                alert("File is too big!");
            } else {
                alert("Invalid file type!");
            }
            $("#file").replaceWith($("#file").val('').clone(true));
        }
        else {
            readURL(this);
        }
    });

    function readURL(input) {
        $(".preview-image").show();
        $(".load-exists-image").hide();
        if (input.files && input.files[0]) {
            for (var index = 0; index < input.files.length; index++) {
                var reader = new FileReader();
                reader.onload = function (e) {
                    if ($(".preview-image")[0]) {
                        $(".preview-image").append(
                            "<img src= '" + e.target.result + "' id= 'imageUpload' width= '100px' height= '75px' alt='' />"
                        );
                    } else {
                        $('#imageUpload').attr('src', e.target.result);
                        $('#imageUpload').show();
                    }
                }
                reader.readAsDataURL(input.files[index]);
            }
        }
        else {
            $('#imageUpload').hide();
        }
    }
});