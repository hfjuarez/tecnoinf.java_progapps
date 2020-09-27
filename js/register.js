function esDoc(){
    let htmlContentToAppend = "";
    if (document.getElementById("check").checked == true){
        htmlContentToAppend += `
        <label for="ins">Instituto<span style="color: red;">*</span></label>
        <input type="text" class="form-control" id="ins" placeholder="Ingresa el nombre del Instituto" required>
        `
    }
    else{
        htmlContentToAppend += `

        `
    }



        document.getElementById("instdoc").innerHTML = htmlContentToAppend;
    }